package me.lwoollett.quotely.model

import java.util.HashMap

class Contents {

    var quotes: List<Quote>? = null
    var copyright: String? = null
    val additionalProperties: Map<String, Object> = HashMap<String, Object>()

    /**
     * No args constructor for use in serialization
     *
     */
    constructor() {}

    /**
     *
     * @param quotes
     * @param copyright
     */
    constructor(quotes: List<Quote>, copyright: String) : super() {
        this.quotes = quotes
        this.copyright = copyright
    }

    fun setAdditionalProperty(name: String, value: Object) {
        this.additionalProperties.put(name, value)
    }

}
