package me.lwoollett.quotely

import android.util.Log
import com.google.gson.Gson
import com.google.gson.JsonParser
import me.lwoollett.quotely.model.ApiQuote
import me.lwoollett.quotely.model.Prefs

fun getAPI(prefs: Prefs): ApiQuote? {
    Log.d("Async", "Async Started")
    val gson = Gson()
    val url = "http://quotes.rest/qod.json"
    val json = readUrl.urlReader(url)
    prefs!!.lastQuote = json

    Log.d("Async", "JSON Recieved")
    val jp = JsonParser()
    Log.d("Async", "JsonParser Created")
    val root = jp.parse(json)
    Log.d("Async", "File Parsed")

    val q = gson.fromJson<ApiQuote>(root, ApiQuote::class.java!!)

    Log.d("Async", "Converted")
    return q
}