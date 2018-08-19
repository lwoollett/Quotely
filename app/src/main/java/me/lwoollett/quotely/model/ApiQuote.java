
package me.lwoollett.quotely.model;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class ApiQuote {

    private Success success;
    private Contents contents;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ApiQuote() {
    }

    /**
     * 
     * @param contents
     * @param success
     */
    public ApiQuote(Success success, Contents contents) {
        super();
        this.success = success;
        this.contents = contents;
    }

    public Success getSuccess() {
        return success;
    }

    public void setSuccess(Success success) {
        this.success = success;
    }

    public Contents getContents() {
        return contents;
    }

    public void setContents(Contents contents) {
        this.contents = contents;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
