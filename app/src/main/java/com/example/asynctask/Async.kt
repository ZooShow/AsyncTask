package com.example.asynctask

import android.os.AsyncTask
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import java.net.URL
import java.util.concurrent.TimeUnit

class Async(progressBar: ProgressBar, textView: TextView) : AsyncTask<URL, Int, String>() {

    private var result: String = "";
    private val progressBar = progressBar
    private val textView = textView

    override fun onPreExecute() {
        super.onPreExecute()
        progressBar.visibility = View.VISIBLE
    }

    override fun doInBackground(vararg params: URL?): String {
        TimeUnit.SECONDS.sleep(1);
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
