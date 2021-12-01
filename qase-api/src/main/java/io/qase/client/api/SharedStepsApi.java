/*
 * Qase.io API
 * # Introduction  You can use our API to access [Qase.io](https://qase.io) API endpoints, which allows to retrieve information about entities stored in database and perform actions with them. The API is organized around [REST](http://en.wikipedia.org/wiki/Representational_State_Transfer).  # API Rate limits  Your application can make up to 200 API requests per minute.  Once the limit is exceeded, clients receive an HTTP 429 with a Retry-After: X header to indicate how long their timeout period is before they will be able to send requests again. The timeout period is set to 60 seconds once the limit is exceeded.  # Authentication  To authorize, use this code:  ```shell # With shell, you can just pass the correct header with each request curl \"https://api.qase.io/v1/api_endpoint\"   -H \"Token: api_token\"   -H \"Content-Type: application/json\" ```  Make sure to replace `api_token` with your API key.  Qase.io uses API tokens to authenticate requests. You can view an manage your API keys in [API tokens pages](https://app.qase.io/user/api/token).  Your API keys has the same access rights as your role in the app, so be sure to keep them secure! Do not share your secret API keys in publicly accessible areas such as GitHub, client-side code, and so forth.  Qase API expects for the API key to be included in all API requests to the server in a header that looks like the following:  `Token: api_token`  You must replace `api_token` with your personal API key.  All API requests must be made over [HTTPS](http://en.wikipedia.org/wiki/HTTP_Secure). Calls made over plain HTTP will fail. API requests without authentication will also fail.  # Access rights  Qase.io is using Role-based Access Control system to restrict some features usage in Web interface and the same rules are applied to API methods. In description for each method you will find a rule name, that is required to perform an action through API. If you don't have enough access rights, you will receive an error with `403` status code.  # Errors  Qase API uses the following error codes:  Code | Meaning ---------- | ------- 400 | Bad Request - Your request is invalid. 401 | Unauthorized - Your API key is wrong. 403 | Forbidden - Your role doesn't have enough permissions to perform this action 404 | Not Found - The resource could not be found. 405 | Method Not Allowed - You tried to access a resource with an invalid method. 406 | Not Acceptable - You requested a format that isn't json. 410 | Gone - The resource requested has been removed from our servers. 429 | Too Many Requests - You're performing too many requests! Slow down! 500 | Internal Server Error - We had a problem with our server. Try again later. 503 | Service Unavailable - We're temporarily offline for maintenance. Please try again later. 
 *
 * The version of the OpenAPI document: 1.0.0
 * Contact: support@qase.io
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package io.qase.client.api;

import com.google.gson.reflect.TypeToken;
import io.qase.api.exceptions.QaseException;
import io.qase.api.inner.FilterHelper;
import io.qase.client.*;
import io.qase.client.model.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SharedStepsApi {
    private ApiClient localVarApiClient;

    public SharedStepsApi() {
        this(Configuration.getDefaultApiClient());
    }

    public SharedStepsApi(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return localVarApiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    /**
     * Build call for createSharedStep
     * @param code Code of project, where to search entities. (required)
     * @param sharedStepCreate  (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws QaseException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> A result. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call createSharedStepCall(String code, SharedStepCreate sharedStepCreate, final ApiCallback _callback) throws QaseException {
        Object localVarPostBody = sharedStepCreate;

        // create path and map variables
        String localVarPath = "/shared_step/{code}"
            .replaceAll("\\{" + "code" + "\\}", localVarApiClient.escapeString(code.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "TokenAuth" };
        return localVarApiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call createSharedStepValidateBeforeCall(String code, SharedStepCreate sharedStepCreate, final ApiCallback _callback) throws QaseException {
        
        // verify the required parameter 'code' is set
        if (code == null) {
            throw new QaseException("Missing the required parameter 'code' when calling createSharedStep(Async)");
        }
        
        // verify the required parameter 'sharedStepCreate' is set
        if (sharedStepCreate == null) {
            throw new QaseException("Missing the required parameter 'sharedStepCreate' when calling createSharedStep(Async)");
        }
        

        okhttp3.Call localVarCall = createSharedStepCall(code, sharedStepCreate, _callback);
        return localVarCall;

    }

    /**
     * Create a new shared step.
     * This method allows to create a shared step in selected project. 
     * @param code Code of project, where to search entities. (required)
     * @param sharedStepCreate  (required)
     * @return HashResponse
     * @throws QaseException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> A result. </td><td>  -  </td></tr>
     </table>
     */
    public HashResponse createSharedStep(String code, SharedStepCreate sharedStepCreate) throws QaseException {
        ApiResponse<HashResponse> localVarResp = createSharedStepWithHttpInfo(code, sharedStepCreate);
        return localVarResp.getData();
    }

    /**
     * Create a new shared step.
     * This method allows to create a shared step in selected project. 
     * @param code Code of project, where to search entities. (required)
     * @param sharedStepCreate  (required)
     * @return ApiResponse&lt;HashResponse&gt;
     * @throws QaseException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> A result. </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<HashResponse> createSharedStepWithHttpInfo(String code, SharedStepCreate sharedStepCreate) throws QaseException {
        okhttp3.Call localVarCall = createSharedStepValidateBeforeCall(code, sharedStepCreate, null);
        Type localVarReturnType = new TypeToken<HashResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Create a new shared step. (asynchronously)
     * This method allows to create a shared step in selected project. 
     * @param code Code of project, where to search entities. (required)
     * @param sharedStepCreate  (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws QaseException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> A result. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call createSharedStepAsync(String code, SharedStepCreate sharedStepCreate, final ApiCallback<HashResponse> _callback) throws QaseException {

        okhttp3.Call localVarCall = createSharedStepValidateBeforeCall(code, sharedStepCreate, _callback);
        Type localVarReturnType = new TypeToken<HashResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for deleteSharedStep
     * @param code Code of project, where to search entities. (required)
     * @param hash Hash. (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws QaseException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> A Result. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call deleteSharedStepCall(String code, String hash, final ApiCallback _callback) throws QaseException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/shared_step/{code}/{hash}"
            .replaceAll("\\{" + "code" + "\\}", localVarApiClient.escapeString(code.toString()))
            .replaceAll("\\{" + "hash" + "\\}", localVarApiClient.escapeString(hash.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "TokenAuth" };
        return localVarApiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call deleteSharedStepValidateBeforeCall(String code, String hash, final ApiCallback _callback) throws QaseException {
        
        // verify the required parameter 'code' is set
        if (code == null) {
            throw new QaseException("Missing the required parameter 'code' when calling deleteSharedStep(Async)");
        }
        
        // verify the required parameter 'hash' is set
        if (hash == null) {
            throw new QaseException("Missing the required parameter 'hash' when calling deleteSharedStep(Async)");
        }
        

        okhttp3.Call localVarCall = deleteSharedStepCall(code, hash, _callback);
        return localVarCall;

    }

    /**
     * Delete shared step.
     * This method completely deletes a shared step from repository. 
     * @param code Code of project, where to search entities. (required)
     * @param hash Hash. (required)
     * @return HashResponse
     * @throws QaseException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> A Result. </td><td>  -  </td></tr>
     </table>
     */
    public HashResponse deleteSharedStep(String code, String hash) throws QaseException {
        ApiResponse<HashResponse> localVarResp = deleteSharedStepWithHttpInfo(code, hash);
        return localVarResp.getData();
    }

    /**
     * Delete shared step.
     * This method completely deletes a shared step from repository. 
     * @param code Code of project, where to search entities. (required)
     * @param hash Hash. (required)
     * @return ApiResponse&lt;HashResponse&gt;
     * @throws QaseException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> A Result. </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<HashResponse> deleteSharedStepWithHttpInfo(String code, String hash) throws QaseException {
        okhttp3.Call localVarCall = deleteSharedStepValidateBeforeCall(code, hash, null);
        Type localVarReturnType = new TypeToken<HashResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Delete shared step. (asynchronously)
     * This method completely deletes a shared step from repository. 
     * @param code Code of project, where to search entities. (required)
     * @param hash Hash. (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws QaseException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> A Result. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call deleteSharedStepAsync(String code, String hash, final ApiCallback<HashResponse> _callback) throws QaseException {

        okhttp3.Call localVarCall = deleteSharedStepValidateBeforeCall(code, hash, _callback);
        Type localVarReturnType = new TypeToken<HashResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for getSharedStep
     * @param code Code of project, where to search entities. (required)
     * @param hash Hash. (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws QaseException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> A shared step. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getSharedStepCall(String code, String hash, final ApiCallback _callback) throws QaseException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/shared_step/{code}/{hash}"
            .replaceAll("\\{" + "code" + "\\}", localVarApiClient.escapeString(code.toString()))
            .replaceAll("\\{" + "hash" + "\\}", localVarApiClient.escapeString(hash.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "TokenAuth" };
        return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call getSharedStepValidateBeforeCall(String code, String hash, final ApiCallback _callback) throws QaseException {
        
        // verify the required parameter 'code' is set
        if (code == null) {
            throw new QaseException("Missing the required parameter 'code' when calling getSharedStep(Async)");
        }
        
        // verify the required parameter 'hash' is set
        if (hash == null) {
            throw new QaseException("Missing the required parameter 'hash' when calling getSharedStep(Async)");
        }
        

        okhttp3.Call localVarCall = getSharedStepCall(code, hash, _callback);
        return localVarCall;

    }

    /**
     * Get a specific shared step.
     * This method allows to retrieve a specific shared step. 
     * @param code Code of project, where to search entities. (required)
     * @param hash Hash. (required)
     * @return SharedStepResponse
     * @throws QaseException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> A shared step. </td><td>  -  </td></tr>
     </table>
     */
    public SharedStepResponse getSharedStep(String code, String hash) throws QaseException {
        ApiResponse<SharedStepResponse> localVarResp = getSharedStepWithHttpInfo(code, hash);
        return localVarResp.getData();
    }

    /**
     * Get a specific shared step.
     * This method allows to retrieve a specific shared step. 
     * @param code Code of project, where to search entities. (required)
     * @param hash Hash. (required)
     * @return ApiResponse&lt;SharedStepResponse&gt;
     * @throws QaseException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> A shared step. </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<SharedStepResponse> getSharedStepWithHttpInfo(String code, String hash) throws QaseException {
        okhttp3.Call localVarCall = getSharedStepValidateBeforeCall(code, hash, null);
        Type localVarReturnType = new TypeToken<SharedStepResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Get a specific shared step. (asynchronously)
     * This method allows to retrieve a specific shared step. 
     * @param code Code of project, where to search entities. (required)
     * @param hash Hash. (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws QaseException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> A shared step. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getSharedStepAsync(String code, String hash, final ApiCallback<SharedStepResponse> _callback) throws QaseException {

        okhttp3.Call localVarCall = getSharedStepValidateBeforeCall(code, hash, _callback);
        Type localVarReturnType = new TypeToken<SharedStepResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for getSharedSteps
     * @param code Code of project, where to search entities. (required)
     * @param limit A number of entities in result set. (optional, default to 10)
     * @param offset How many entities should be skipped. (optional, default to 0)
     * @param filters  (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws QaseException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> A list of all shared steps. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getSharedStepsCall(String code, Integer limit, Integer offset, Filters6 filters, final ApiCallback _callback) throws QaseException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/shared_step/{code}"
            .replaceAll("\\{" + "code" + "\\}", localVarApiClient.escapeString(code.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (limit != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("limit", limit));
        }

        if (offset != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("offset", offset));
        }

        if (filters != null) {
            localVarQueryParams.addAll(FilterHelper.getFilterPairs(filters));
        }

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "TokenAuth" };
        return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call getSharedStepsValidateBeforeCall(String code, Integer limit, Integer offset, Filters6 filters, final ApiCallback _callback) throws QaseException {
        
        // verify the required parameter 'code' is set
        if (code == null) {
            throw new QaseException("Missing the required parameter 'code' when calling getSharedSteps(Async)");
        }
        

        okhttp3.Call localVarCall = getSharedStepsCall(code, limit, offset, filters, _callback);
        return localVarCall;

    }

    /**
     * Get all shared steps.
     * This method allows to retrieve all shared steps stored in selected project. 
     * @param code Code of project, where to search entities. (required)
     * @param limit A number of entities in result set. (optional, default to 10)
     * @param offset How many entities should be skipped. (optional, default to 0)
     * @param filters  (optional)
     * @return SharedStepListResponse
     * @throws QaseException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> A list of all shared steps. </td><td>  -  </td></tr>
     </table>
     */
    public SharedStepListResponse getSharedSteps(String code, Integer limit, Integer offset, Filters6 filters) throws QaseException {
        ApiResponse<SharedStepListResponse> localVarResp = getSharedStepsWithHttpInfo(code, limit, offset, filters);
        return localVarResp.getData();
    }

    /**
     * Get all shared steps.
     * This method allows to retrieve all shared steps stored in selected project. 
     * @param code Code of project, where to search entities. (required)
     * @param limit A number of entities in result set. (optional, default to 10)
     * @param offset How many entities should be skipped. (optional, default to 0)
     * @param filters  (optional)
     * @return ApiResponse&lt;SharedStepListResponse&gt;
     * @throws QaseException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> A list of all shared steps. </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<SharedStepListResponse> getSharedStepsWithHttpInfo(String code, Integer limit, Integer offset, Filters6 filters) throws QaseException {
        okhttp3.Call localVarCall = getSharedStepsValidateBeforeCall(code, limit, offset, filters, null);
        Type localVarReturnType = new TypeToken<SharedStepListResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Get all shared steps. (asynchronously)
     * This method allows to retrieve all shared steps stored in selected project. 
     * @param code Code of project, where to search entities. (required)
     * @param limit A number of entities in result set. (optional, default to 10)
     * @param offset How many entities should be skipped. (optional, default to 0)
     * @param filters  (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws QaseException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> A list of all shared steps. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getSharedStepsAsync(String code, Integer limit, Integer offset, Filters6 filters, final ApiCallback<SharedStepListResponse> _callback) throws QaseException {

        okhttp3.Call localVarCall = getSharedStepsValidateBeforeCall(code, limit, offset, filters, _callback);
        Type localVarReturnType = new TypeToken<SharedStepListResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for updateSharedStep
     * @param code Code of project, where to search entities. (required)
     * @param hash Hash. (required)
     * @param sharedStepUpdate  (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws QaseException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> A result. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call updateSharedStepCall(String code, String hash, SharedStepUpdate sharedStepUpdate, final ApiCallback _callback) throws QaseException {
        Object localVarPostBody = sharedStepUpdate;

        // create path and map variables
        String localVarPath = "/shared_step/{code}/{hash}"
            .replaceAll("\\{" + "code" + "\\}", localVarApiClient.escapeString(code.toString()))
            .replaceAll("\\{" + "hash" + "\\}", localVarApiClient.escapeString(hash.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "TokenAuth" };
        return localVarApiClient.buildCall(localVarPath, "PATCH", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call updateSharedStepValidateBeforeCall(String code, String hash, SharedStepUpdate sharedStepUpdate, final ApiCallback _callback) throws QaseException {
        
        // verify the required parameter 'code' is set
        if (code == null) {
            throw new QaseException("Missing the required parameter 'code' when calling updateSharedStep(Async)");
        }
        
        // verify the required parameter 'hash' is set
        if (hash == null) {
            throw new QaseException("Missing the required parameter 'hash' when calling updateSharedStep(Async)");
        }
        
        // verify the required parameter 'sharedStepUpdate' is set
        if (sharedStepUpdate == null) {
            throw new QaseException("Missing the required parameter 'sharedStepUpdate' when calling updateSharedStep(Async)");
        }
        

        okhttp3.Call localVarCall = updateSharedStepCall(code, hash, sharedStepUpdate, _callback);
        return localVarCall;

    }

    /**
     * Update shared step.
     * This method updates a shared step. 
     * @param code Code of project, where to search entities. (required)
     * @param hash Hash. (required)
     * @param sharedStepUpdate  (required)
     * @return HashResponse
     * @throws QaseException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> A result. </td><td>  -  </td></tr>
     </table>
     */
    public HashResponse updateSharedStep(String code, String hash, SharedStepUpdate sharedStepUpdate) throws QaseException {
        ApiResponse<HashResponse> localVarResp = updateSharedStepWithHttpInfo(code, hash, sharedStepUpdate);
        return localVarResp.getData();
    }

    /**
     * Update shared step.
     * This method updates a shared step. 
     * @param code Code of project, where to search entities. (required)
     * @param hash Hash. (required)
     * @param sharedStepUpdate  (required)
     * @return ApiResponse&lt;HashResponse&gt;
     * @throws QaseException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> A result. </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<HashResponse> updateSharedStepWithHttpInfo(String code, String hash, SharedStepUpdate sharedStepUpdate) throws QaseException {
        okhttp3.Call localVarCall = updateSharedStepValidateBeforeCall(code, hash, sharedStepUpdate, null);
        Type localVarReturnType = new TypeToken<HashResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Update shared step. (asynchronously)
     * This method updates a shared step. 
     * @param code Code of project, where to search entities. (required)
     * @param hash Hash. (required)
     * @param sharedStepUpdate  (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws QaseException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> A result. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call updateSharedStepAsync(String code, String hash, SharedStepUpdate sharedStepUpdate, final ApiCallback<HashResponse> _callback) throws QaseException {

        okhttp3.Call localVarCall = updateSharedStepValidateBeforeCall(code, hash, sharedStepUpdate, _callback);
        Type localVarReturnType = new TypeToken<HashResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
}