
package me.lwoollett.quotely.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Contents {

    private List<Quote> quotes = null;
    private String copyright;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Contents() {
    }

    /**
     * 
     * @param quotes
     * @param copyright
     */
    public Contents(List<Quote> quotes, String copyright) {
        super();
        this.quotes = quotes;
        this.copyright = copyright;
    }

    public List<Quote> getQuotes() {
        return quotes;
    }

    public void setQuotes(List<Quote> quotes) {
        this.quotes = quotes;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
