package com.example.asynctask

import android.os.AsyncTask
import android.os.Bundle
import android.view.View
import android.widget.Button
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
        val button: Button = findViewById(R.id.button)
        val progressBar: ProgressBar = findViewById(R.id.progressBar)
        val textView: TextView = findViewById(R.id.textView)
        button.setOnClickListener{
            val task = Async(progressBar, textView)
            task.execute()
        }
    }

}