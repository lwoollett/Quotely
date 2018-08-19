
package me.lwoollett.quotely.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Quote {

    private String quote;
    private String length;
    private String author;
    private List<String> tags = null;
    private String category;
    private String date;
    private String permalink;
    private String title;
    private String background;
    private String id;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Quote() {
    }

    /**
     * 
     * @param id
     * @param tags
     * @param author
     * @param title
     * @param category
     * @param permalink
     * @param quote
     * @param background
     * @param length
     * @param date
     */
    public Quote(String quote, String length, String author, List<String> tags, String category, String date, String permalink, String title, String background, String id) {
        super();
        this.quote = quote;
        this.length = length;
        this.author = author;
        this.tags = tags;
        this.category = category;
        this.date = date;
        this.permalink = permalink;
        this.title = title;
        this.background = background;
        this.id = id;
    }

    public String getQuote() {
        return quote;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
