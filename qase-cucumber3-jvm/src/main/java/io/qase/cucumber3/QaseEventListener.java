package io.qase.cucumber3;

import cucumber.api.Result;
import cucumber.api.event.EventPublisher;
import cucumber.api.event.TestCaseFinished;
import cucumber.api.event.TestCaseStarted;
import cucumber.api.formatter.Formatter;
import gherkin.pickles.PickleTag;
import io.qase.api.exceptions.QaseException;
import io.qase.client.ApiClient;
import io.qase.client.api.ResultsApi;
import io.qase.client.model.ResultCreate;
import io.qase.client.model.ResultCreate.StatusEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;
import java.util.Optional;

import static io.qase.api.utils.IntegrationUtils.*;

public class QaseEventListener implements Formatter {
    private static final Logger logger = LoggerFactory.getLogger(QaseEventListener.class);
    private final ApiClient apiClient = new ApiClient();
    private final ResultsApi resultsApi = new ResultsApi(apiClient);
    private boolean isEnabled;
    private String projectCode;
    private String runId;
    private long startTime;

    public QaseEventListener() {
        isEnabled = Boolean.parseBoolean(System.getProperty(ENABLE_KEY, "false"));
        if (!isEnabled) {
            return;
        }

        String apiToken = System.getProperty(API_TOKEN_KEY, System.getenv(API_TOKEN_KEY));
        if (apiToken == null) {
            isEnabled = false;
            logger.info(REQUIRED_PARAMETER_WARNING_MESSAGE, API_TOKEN_KEY);
            return;
        }

        String qaseUrl = System.getProperty(QASE_URL_KEY, System.getenv(API_TOKEN_KEY));
        if (qaseUrl != null) {
            apiClient.setBasePath(qaseUrl);
        }
        apiClient.setApiKey(apiToken);

        projectCode = System.getProperty(PROJECT_CODE_KEY, System.getenv(PROJECT_CODE_KEY));
        if (projectCode == null) {
            isEnabled = false;
            logger.info(REQUIRED_PARAMETER_WARNING_MESSAGE, PROJECT_CODE_KEY);
            return;
        }
        logger.info("Qase project code - {}", projectCode);

        runId = System.getProperty(RUN_ID_KEY, System.getenv(RUN_ID_KEY));
        if (runId == null) {
            isEnabled = false;
            logger.info(REQUIRED_PARAMETER_WARNING_MESSAGE, RUN_ID_KEY);
            return;
        }
        logger.info("Qase run id - {}", runId);
    }

    @Override
    public void setEventPublisher(EventPublisher publisher) {
        publisher.registerHandlerFor(TestCaseStarted.class, this::testCaseStarted);
        publisher.registerHandlerFor(TestCaseFinished.class, this::testCaseFinished);
    }

    private void testCaseStarted(TestCaseStarted event) {
        startTime = System.currentTimeMillis();
    }

    private void testCaseFinished(TestCaseFinished event) {
        Duration duration = Duration.ofMillis(System.currentTimeMillis() - startTime);
        List<PickleTag> tags = event.testCase.getTags();
        Long caseId = getCaseId(tags);
        if (caseId != null) {
            send(caseId, duration, event.result);
        }
    }

    private Long getCaseId(List<PickleTag> tags) {
        for (PickleTag pickleTag : tags) {
            String tag = pickleTag.getName();
            String[] split = tag.split("=");
            if (CASE_TAGS.contains(split[0]) && split.length == 2 && split[1].matches("\\d+")) {
                return Long.valueOf(split[1]);
            }
        }
        return null;
    }

    private void send(Long caseId, Duration duration, Result result) {
        if (!isEnabled) {
            return;
        }
        try {
            StatusEnum status = convertStatus(result.getStatus());
            Optional<Throwable> optionalThrowable = Optional.ofNullable(result.getError());
            String comment = optionalThrowable
                    .flatMap(throwable -> Optional.of(throwable.toString())).orElse(null);
            Boolean isDefect = optionalThrowable
                    .flatMap(throwable -> Optional.of(throwable instanceof AssertionError))
                    .orElse(false);
            String stacktrace = optionalThrowable
                    .flatMap(throwable -> Optional.of(getStacktrace(throwable))).orElse(null);

            resultsApi.createResult(projectCode,
                    runId,
                    new ResultCreate()
                            .caseId(caseId)
                            .status(status)
                            .timeMs(duration.toMillis())
                            .comment(comment)
                            .stacktrace(stacktrace)
                            .defect(isDefect));
        } catch (QaseException e) {
            logger.error(e.getMessage());
        }
    }

    private StatusEnum convertStatus(Result.Type status) {
        switch (status) {
            case FAILED:
                return StatusEnum.FAILED;
            case PASSED:
                return StatusEnum.PASSED;
            case PENDING:
            case SKIPPED:
            case AMBIGUOUS:
            case UNDEFINED:
            default:
                return StatusEnum.SKIPPED;
        }
    }
}