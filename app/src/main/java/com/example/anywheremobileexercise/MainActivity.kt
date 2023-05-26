package com.example.anywheremobileexercise

import android.content.Context
import android.net.ConnectivityManager
import android.os.AsyncTask
import android.os.Bundle
import android.widget.ListView
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.net.URL


/**
* Author: Steve Stansbury.
*/

class MainActivity : AppCompatActivity() {

    lateinit var Lv_developers: ListView
    lateinit var Pbar: ProgressBar
    private var viewItems: MutableList<Any?>? = ArrayList()

    // Checking Internet is available or not
    private val isNetworkConnected: Boolean
        get() = (getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager).activeNetworkInfo != null

    // Show BackButton on Actionbar
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // findViewById and set view id
        Pbar = findViewById(R.id.Pbar)
        Lv_developers = findViewById(R.id.Lv_developers)

        if (isNetworkConnected) {

        //    RetrieveFeedTask().execute(urlToRssFeed)

        } else {
            Toast.makeText(applicationContext, "No Internet Connection Yet!", Toast.LENGTH_SHORT).show()
        }
    }

   /* internal class RetrieveFeedTask :
        AsyncTask<String?, Void?, RSSFeed?>() {
        private var exception: Exception? = null
        protected override fun doInBackground(vararg urls: String): RSSFeed? {
            return try {
                val url = URL(urls[0])
                val factory: SAXParserFactory = SAXParserFactory.newInstance()
                val parser: SAXParser = factory.newSAXParser()
                val xmlreader: XMLReader = parser.getXMLReader()
                val theRSSHandler = RssHandler()
                xmlreader.setContentHandler(theRSSHandler)
                val `is` = InputSource(url.openStream())
                xmlreader.parse(`is`)
                theRSSHandler.getFeed()
            } catch (e: Exception) {
                exception = e
                null
            } finally {
                `is`.close()
            }
        }

        override fun onPostExecute(feed: RSSFeed?) {
            // TODO: check this.exception
            // TODO: do something with the feed
        }*/
}
