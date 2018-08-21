package me.lwoollett.quotely

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import me.lwoollett.quotely.model.ApiQuote

import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.View
import android.widget.TextView
import androidx.core.app.NotificationCompat

import com.google.gson.Gson
import com.google.gson.JsonParser
import com.jakewharton.threetenabp.AndroidThreeTen
import me.lwoollett.quotely.model.Prefs
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import org.threeten.bp.LocalDate

class MainActivity : AppCompatActivity() {
    var prefs: Prefs? = null
    var txt_quote: TextView? = null
    var txt_author: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidThreeTen.init(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txt_quote = findViewById<TextView>(R.id.txt_quote)
        txt_author = findViewById<TextView>(R.id.txt_author)
        txt_quote!!.setOnClickListener {
            if(txt_quote!!.typeface == Typeface.create("cursive", Typeface.BOLD)){
                txt_quote!!.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD_ITALIC)
                txt_author!!.setTypeface(Typeface.SANS_SERIF, Typeface.ITALIC)
                txt_quote!!.setTextSize(TypedValue.COMPLEX_UNIT_SP, 22.0F)
                txt_author!!.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18.0F)
            }else{
                txt_quote!!.typeface = Typeface.create("cursive", Typeface.BOLD)
                txt_author!!.typeface = Typeface.create("cursive", Typeface.ITALIC)
                txt_quote!!.setTextSize(TypedValue.COMPLEX_UNIT_SP, 38.0F)
                txt_author!!.setTextSize(TypedValue.COMPLEX_UNIT_SP, 22.0F)
            }
        }
        txt_author!!.setOnClickListener{
            if(txt_quote!!.typeface == Typeface.create("cursive", Typeface.BOLD)){
                txt_quote!!.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD_ITALIC)
                txt_author!!.setTypeface(Typeface.SANS_SERIF, Typeface.ITALIC)
                txt_quote!!.setTextSize(TypedValue.COMPLEX_UNIT_SP, 22.0F)
                txt_author!!.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18.0F)
            }else{
                txt_quote!!.typeface = Typeface.create("cursive", Typeface.BOLD)
                txt_author!!.typeface = Typeface.create("cursive", Typeface.ITALIC)
                txt_quote!!.setTextSize(TypedValue.COMPLEX_UNIT_SP, 38.0F)
                txt_author!!.setTextSize(TypedValue.COMPLEX_UNIT_SP, 22.0F)
            }
        }

        prefs = Prefs(this)
        val LastQuote = prefs!!.lastQuote
        if (LastQuote.equals("None")) {
            updateText()
        } else {
            val root = JsonParser().parse(LastQuote)
            val q = Gson().fromJson<ApiQuote>(root, ApiQuote::class.java!!)
            val lastDateStr = q.contents.quotes[0].date
            val lastDate = LocalDate.parse(lastDateStr)
            Log.d("Time", lastDateStr)
            Log.d("Time", LocalDate.now().toString())
            if (lastDate.isBefore(LocalDate.now())) {
                updateText()
            } else {
                txt_author!!.text = """Author: ${q?.contents!!.quotes[0].author}"""
                txt_quote!!.text = q?.contents!!.quotes[0].quote
            }
        }
    }

    private fun updateText() {
        doAsync {
            val q = getAPI(prefs!!)
            uiThread {
                txt_author!!.text = """Author: ${q?.contents!!.quotes[0].author}"""
                txt_quote!!.text = q?.contents!!.quotes[0].quote
            }
        }
    }
}
