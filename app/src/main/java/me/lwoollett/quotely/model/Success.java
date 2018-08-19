
package me.lwoollett.quotely.model;

import java.util.HashMap;
import java.util.Map;

public class Success {

    private Integer total;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Success() {
    }

    /**
     * 
     * @param total
     */
    public Success(Integer total) {
        super();
        this.total = total;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
