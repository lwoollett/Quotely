package me.lwoollett.quotely

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.URL
import android.util.Log
import androidx.core.app.NotificationCompat
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
    val result = gson.fromJson<ApiQuote>(root, ApiQuote::class.java!!)
    Log.d("Async", "Converted")
    return result
}

fun urlReader(urlString: String): String? {
    var reader: BufferedReader? = null
    try {
        val url = URL(urlString)
        reader = BufferedReader(InputStreamReader(url.openStream()))
        val buffer = StringBuffer()
        var read: Int
        val chars = CharArray(1024)
        while ((read = reader!!.read(chars)) != -1)
            buffer.append(chars, 0, read)

        reader!!.close()
        return buffer.toString()
    } catch (e: IOException) {
        e.printStackTrace()
        return null
    }
}
