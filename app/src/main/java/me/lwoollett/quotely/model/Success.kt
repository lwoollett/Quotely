package me.lwoollett.quotely.model

import java.util.HashMap

class Success {

    var total: Integer? = null
    val additionalProperties: Map<String, Object> = HashMap<String, Object>()

    /**
     * No args constructor for use in serialization
     *
     */
    constructor() {}

    /**
     *
     * @param total
     */
    constructor(total: Integer) : super() {
        this.total = total
    }

    fun setAdditionalProperty(name: String, value: Object) {
        this.additionalProperties.put(name, value)
    }

}
