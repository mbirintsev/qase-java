package io.qase.cucumber3;

import cucumber.api.Result;
import cucumber.api.event.EventPublisher;
import cucumber.api.event.TestCaseFinished;
import cucumber.api.event.TestCaseStarted;
import cucumber.api.event.TestRunFinished;
import cucumber.api.formatter.Formatter;
import gherkin.pickles.PickleTag;
import io.qase.api.StepStorage;
import io.qase.api.config.QaseConfig;
import io.qase.api.utils.CucumberUtils;
import io.qase.client.model.ResultCreate;
import io.qase.client.model.ResultCreate.StatusEnum;
import io.qase.client.model.ResultCreateSteps;
import io.qase.api.services.QaseTestCaseListener;
import lombok.AccessLevel;
import lombok.Getter;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static io.qase.api.utils.IntegrationUtils.getStacktrace;
import static io.qase.configuration.QaseModule.getInjector;

public class QaseEventListener implements Formatter {

    private static final String REPORTER_NAME = "Cucumber 3-JVM";

    @Getter(lazy = true, value = AccessLevel.PRIVATE)
    private final QaseTestCaseListener qaseTestCaseListener = getInjector().getInstance(QaseTestCaseListener.class);

    static {
        System.setProperty(QaseConfig.QASE_CLIENT_REPORTER_NAME_KEY, REPORTER_NAME);
    }

    @Override
    public void setEventPublisher(EventPublisher publisher) {
        publisher.registerHandlerFor(TestCaseStarted.class, this::testCaseStarted);
        publisher.registerHandlerFor(TestCaseFinished.class, this::testCaseFinished);
        publisher.registerHandlerFor(TestRunFinished.class, this::testRunFinished);
    }

    private void testRunFinished(TestRunFinished testRunFinished) {
        getQaseTestCaseListener().onTestCasesSetFinished();
    }

    private void testCaseStarted(TestCaseStarted event) {
        getQaseTestCaseListener().onTestCaseStarted();
    }

    private void testCaseFinished(TestCaseFinished event) {
        getQaseTestCaseListener().onTestCaseFinished(resultCreate -> setupResultItem(resultCreate, event));
    }

    private void setupResultItem(ResultCreate resultCreate, TestCaseFinished event) {
        List<PickleTag> pickleTags = event.testCase.getTags();
        List<String> tags = pickleTags.stream().map(PickleTag::getName).collect(Collectors.toList());
        Long caseId = CucumberUtils.getCaseId(tags);
        StatusEnum status = convertStatus(event.result.getStatus());
        Optional<Throwable> optionalThrowable = Optional.ofNullable(event.result.getError());
        String comment = optionalThrowable
            .flatMap(throwable -> Optional.of(throwable.toString())).orElse(null);
        Boolean isDefect = optionalThrowable
            .flatMap(throwable -> Optional.of(throwable instanceof AssertionError))
            .orElse(false);
        String stacktrace = optionalThrowable
            .flatMap(throwable -> Optional.of(getStacktrace(throwable))).orElse(null);
        LinkedList<ResultCreateSteps> steps = StepStorage.stopSteps();
        resultCreate
            .caseId(caseId)
            .status(status)
            .comment(comment)
            .stacktrace(stacktrace)
            .steps(steps.isEmpty() ? null : steps)
            .defect(isDefect);
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
