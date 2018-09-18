package me.lwoollett.quotely.model

import java.time.LocalDate
import java.util.HashMap

class ApiQuote {
    var success: Success? = null
    var contents: Contents? = null
    val additionalProperties: Map<String, Object> = HashMap<String, Object>()

    /**
     * No args constructor for use in serialization
     *
     */
    constructor() {}

    /**
     *
     * @param contents
     * @param success
     */
    constructor(success: Success, contents: Contents) : super() {
        this.success = success
        this.contents = contents
    }

    fun setAdditionalProperty(name: String, value: Object) {
        this.additionalProperties.put(name, value)
    }

}
