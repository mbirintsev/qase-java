/*
 * Qase.io API
 * Qase API Specification.
 *
 * The version of the OpenAPI document: 1.0.0
 * Contact: support@qase.io
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package io.qase.client.model;

import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;

import java.util.*;

/**
 * CustomFieldUpdate
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-03-05T00:04:57.018823+03:00[Europe/Moscow]")
public class CustomFieldUpdate {
    public static final String SERIALIZED_NAME_TITLE = "title";
    public static final String SERIALIZED_NAME_VALUE = "value";
    public static final String SERIALIZED_NAME_REPLACE_VALUES = "replace_values";
    public static final String SERIALIZED_NAME_PLACEHOLDER = "placeholder";
    public static final String SERIALIZED_NAME_DEFAULT_VALUE = "default_value";
    public static final String SERIALIZED_NAME_IS_FILTERABLE = "is_filterable";
    public static final String SERIALIZED_NAME_IS_VISIBLE = "is_visible";
    public static final String SERIALIZED_NAME_IS_REQUIRED = "is_required";
    public static final String SERIALIZED_NAME_PROJECTS_CODES = "projects_codes";
    @SerializedName(SERIALIZED_NAME_TITLE)
    private String title;
    @SerializedName(SERIALIZED_NAME_VALUE)
    private List<CustomFieldCreateValue> value = null;
    @SerializedName(SERIALIZED_NAME_REPLACE_VALUES)
    private Map<String, String> replaceValues = null;
    @SerializedName(SERIALIZED_NAME_PLACEHOLDER)
    private String placeholder;
    @SerializedName(SERIALIZED_NAME_DEFAULT_VALUE)
    private String defaultValue;
    @SerializedName(SERIALIZED_NAME_IS_FILTERABLE)
    private Boolean isFilterable;
    @SerializedName(SERIALIZED_NAME_IS_VISIBLE)
    private Boolean isVisible;
    @SerializedName(SERIALIZED_NAME_IS_REQUIRED)
    private Boolean isRequired;
    @SerializedName(SERIALIZED_NAME_PROJECTS_CODES)
    private List<String> projectsCodes = new ArrayList<>();

    private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
        return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
    }

    private static <T> int hashCodeNullable(JsonNullable<T> a) {
        if (a == null) {
            return 1;
        }
        return a.isPresent() ? Arrays.deepHashCode(new Object[]{a.get()}) : 31;
    }

    public CustomFieldUpdate title(String title) {

        this.title = title;
        return this;
    }

    /**
     * Get title
     *
     * @return title
     **/
    @javax.annotation.Nonnull
    @ApiModelProperty(required = true, value = "")

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public CustomFieldUpdate value(List<CustomFieldCreateValue> value) {

        this.value = value;
        return this;
    }

    public CustomFieldUpdate addValueItem(CustomFieldCreateValue valueItem) {
        if (this.value == null) {
            this.value = new ArrayList<>();
        }
        this.value.add(valueItem);
        return this;
    }

    /**
     * Get value
     *
     * @return value
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")

    public List<CustomFieldCreateValue> getValue() {
        return value;
    }

    public void setValue(List<CustomFieldCreateValue> value) {
        this.value = value;
    }

    public CustomFieldUpdate replaceValues(Map<String, String> replaceValues) {

        this.replaceValues = replaceValues;
        return this;
    }

    public CustomFieldUpdate putReplaceValuesItem(String key, String replaceValuesItem) {
        if (this.replaceValues == null) {
            this.replaceValues = new HashMap<>();
        }
        this.replaceValues.put(key, replaceValuesItem);
        return this;
    }

    /**
     * Dictionary of old values and their replacemants
     *
     * @return replaceValues
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "Dictionary of old values and their replacemants")

    public Map<String, String> getReplaceValues() {
        return replaceValues;
    }

    public void setReplaceValues(Map<String, String> replaceValues) {
        this.replaceValues = replaceValues;
    }

    public CustomFieldUpdate placeholder(String placeholder) {

        this.placeholder = placeholder;
        return this;
    }

    /**
     * Get placeholder
     *
     * @return placeholder
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")

    public String getPlaceholder() {
        return placeholder;
    }

    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
    }

    public CustomFieldUpdate defaultValue(String defaultValue) {

        this.defaultValue = defaultValue;
        return this;
    }

    /**
     * Get defaultValue
     *
     * @return defaultValue
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public CustomFieldUpdate isFilterable(Boolean isFilterable) {

        this.isFilterable = isFilterable;
        return this;
    }

    /**
     * Get isFilterable
     *
     * @return isFilterable
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")

    public Boolean getIsFilterable() {
        return isFilterable;
    }

    public void setIsFilterable(Boolean isFilterable) {
        this.isFilterable = isFilterable;
    }

    public CustomFieldUpdate isVisible(Boolean isVisible) {

        this.isVisible = isVisible;
        return this;
    }

    /**
     * Get isVisible
     *
     * @return isVisible
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")

    public Boolean getIsVisible() {
        return isVisible;
    }

    public void setIsVisible(Boolean isVisible) {
        this.isVisible = isVisible;
    }

    public CustomFieldUpdate isRequired(Boolean isRequired) {

        this.isRequired = isRequired;
        return this;
    }

    /**
     * Get isRequired
     *
     * @return isRequired
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")

    public Boolean getIsRequired() {
        return isRequired;
    }

    public void setIsRequired(Boolean isRequired) {
        this.isRequired = isRequired;
    }

    public CustomFieldUpdate projectsCodes(List<String> projectsCodes) {

        this.projectsCodes = projectsCodes;
        return this;
    }

    public CustomFieldUpdate addProjectsCodesItem(String projectsCodesItem) {
        this.projectsCodes.add(projectsCodesItem);
        return this;
    }

    /**
     * Get projectsCodes
     *
     * @return projectsCodes
     **/
    @javax.annotation.Nonnull
    @ApiModelProperty(required = true, value = "")

    public List<String> getProjectsCodes() {
        return projectsCodes;
    }

    public void setProjectsCodes(List<String> projectsCodes) {
        this.projectsCodes = projectsCodes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CustomFieldUpdate customFieldUpdate = (CustomFieldUpdate) o;
        return Objects.equals(this.title, customFieldUpdate.title) &&
                Objects.equals(this.value, customFieldUpdate.value) &&
                Objects.equals(this.replaceValues, customFieldUpdate.replaceValues) &&
                Objects.equals(this.placeholder, customFieldUpdate.placeholder) &&
                Objects.equals(this.defaultValue, customFieldUpdate.defaultValue) &&
                Objects.equals(this.isFilterable, customFieldUpdate.isFilterable) &&
                Objects.equals(this.isVisible, customFieldUpdate.isVisible) &&
                Objects.equals(this.isRequired, customFieldUpdate.isRequired) &&
                Objects.equals(this.projectsCodes, customFieldUpdate.projectsCodes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, value, replaceValues, placeholder, defaultValue, isFilterable, isVisible, isRequired, projectsCodes);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CustomFieldUpdate {\n");
        sb.append("    title: ").append(toIndentedString(title)).append("\n");
        sb.append("    value: ").append(toIndentedString(value)).append("\n");
        sb.append("    replaceValues: ").append(toIndentedString(replaceValues)).append("\n");
        sb.append("    placeholder: ").append(toIndentedString(placeholder)).append("\n");
        sb.append("    defaultValue: ").append(toIndentedString(defaultValue)).append("\n");
        sb.append("    isFilterable: ").append(toIndentedString(isFilterable)).append("\n");
        sb.append("    isVisible: ").append(toIndentedString(isVisible)).append("\n");
        sb.append("    isRequired: ").append(toIndentedString(isRequired)).append("\n");
        sb.append("    projectsCodes: ").append(toIndentedString(projectsCodes)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}

