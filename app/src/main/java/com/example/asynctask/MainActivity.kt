package com.example.asynctask

import android.os.AsyncTask
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.net.URL

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AsyncTasks().execute()
    }

    inner class AsyncTasks : AsyncTask<URL, Int, String>() {

        private var result: String = "";
        val progressBar: ProgressBar = findViewById(R.id.progressBar)
        val textView: TextView = findViewById(R.id.textView)

        override fun onPreExecute() {
            super.onPreExecute()
            progressBar.visibility = View.VISIBLE
        }

        override fun doInBackground(vararg params: URL?): String {

            when ((1..3).random()){
                1 -> result = "Hello"
                2 -> result = "Holla"
                3 -> result = "Ahlan wa sahlan"
            }

            return result
        }

        override fun onProgressUpdate(vararg values: Int?) {
            super.onProgressUpdate(*values)
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            progressBar.visibility = View.GONE
            textView.text = result
        }
    }
    
}