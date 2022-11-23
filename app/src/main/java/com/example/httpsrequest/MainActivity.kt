package com.example.httpsrequest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.json.JSONException
import org.json.JSONObject
import org.w3c.dom.Text
import java.io.IOException
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL
import java.util.logging.Level
import java.util.logging.Logger
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonGetRequest = findViewById<Button>(R.id.button)
        val TextView1 = findViewById<TextView>(R.id.textView2)
        val TextView2 = findViewById<TextView>(R.id.textView3)
        val textBox = findViewById<EditText>(R.id.editText1)

        val apiService = HttpRequestClass()

        buttonGetRequest.setOnClickListener {
            thread {
                val id = textBox.text.toString().toIntOrNull() ?: 0
                val post = apiService.getPostById(id)

                var personId = post?.userId?.toIntOrNull() ?: 0
                val person = apiService.getPersonById(personId)

                runOnUiThread {
                    TextView1.text = post?.body + " " + post?.title
                    TextView2.text = person?.name + " " + person?.email
                }
            }
        }

    }
}