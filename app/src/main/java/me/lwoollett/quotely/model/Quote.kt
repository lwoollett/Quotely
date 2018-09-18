package me.lwoollett.quotely.model

import java.util.HashMap

class Quote {

    val quote: String
    var length: String? = null
    var author: String? = null
    var tags: List<String>? = null
    var category: String? = null
    var date: String? = null
    var permalink: String? = null
    var title: String? = null
    var background: String? = null
    var id: String? = null
    val additionalProperties: Map<String, Object> = HashMap<String, Object>()

    /**
     * No args constructor for use in serialization
     *
     */
    constructor() {}

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
    constructor(quote: String, length: String, author: String, tags: List<String>, category: String, date: String, permalink: String, title: String, background: String, id: String) : super() {
        this.quote = quote
        this.length = length
        this.author = author
        this.tags = tags
        this.category = category
        this.date = date
        this.permalink = permalink
        this.title = title
        this.background = background
        this.id = id
    }

    fun setAdditionalProperty(name: String, value: Object) {
        this.additionalProperties.put(name, value)
    }

}
