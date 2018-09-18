package me.lwoollett.quotely.model

import android.content.Context
import android.content.SharedPreferences

class Prefs(context: Context) {
    val PREFS_FILENAME = "me.lwoollett.Quotely.prefs"
    val LAST_QUOTE = "lastQuote"
    val prefs: SharedPreferences = context.getSharedPreferences(PREFS_FILENAME, 0);

    var lastQuote: String
        get() = prefs.getString(LAST_QUOTE, "None")
        set(value) = prefs.edit().putString(LAST_QUOTE, value).apply()
}
