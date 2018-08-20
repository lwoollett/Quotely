package me.lwoollett.quotely

import androidx.appcompat.app.AppCompatActivity
import me.lwoollett.quotely.model.ApiQuote

import android.os.Bundle
import android.util.Log
import android.widget.TextView

import com.google.gson.Gson
import com.google.gson.JsonParser
import com.jakewharton.threetenabp.AndroidThreeTen
import me.lwoollett.quotely.model.Prefs
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import org.threeten.bp.LocalDate

class MainActivity : AppCompatActivity() {
    var prefs: Prefs? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidThreeTen.init(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        prefs = Prefs(this)
        val LastQuote = prefs!!.lastQuote
        Log.d("Memed", LastQuote)
        if(LastQuote.equals("None")) {
            doAsync {
                val q = getAPI(prefs!!)
                uiThread {
                    var txt_qoute = findViewById<TextView>(R.id.txt_quote)
                    var txt_author = findViewById<TextView>(R.id.txt_author)
                    txt_author.text = """Author: ${q?.contents!!.quotes[0].author}"""
                    txt_qoute.text = q?.contents!!.quotes[0].quote
                }
            }
        }else{
            val root = JsonParser().parse(LastQuote)
            val q = Gson().fromJson<ApiQuote>(root, ApiQuote::class.java!!)
            val lastDateStr = q.contents.quotes[0].date
            val lastDate = LocalDate.parse(lastDateStr)
            Log.d("Time", lastDateStr)
            Log.d("Time", LocalDate.now().toString())
            if(lastDate.isBefore(LocalDate.now())){
                doAsync {
                    val q = getAPI(prefs!!)
                    uiThread {
                        var txt_qoute = findViewById<TextView>(R.id.txt_quote)
                        var txt_author = findViewById<TextView>(R.id.txt_author)
                        txt_author.text = """Author: ${q?.contents!!.quotes[0].author}"""
                        txt_qoute.text = q?.contents!!.quotes[0].quote
                    }
                }
            }else{
                var txt_qoute = findViewById<TextView>(R.id.txt_quote)
                var txt_author = findViewById<TextView>(R.id.txt_author)
                txt_author.text = """Author: ${q?.contents!!.quotes[0].author}"""
                txt_qoute.text = q?.contents!!.quotes[0].quote
                }
            }
        }
    }
