package com.example.anywheremobileexercise

import android.content.res.Resources
import androidx.core.content.res.TypedArrayUtils.getString
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ServiceBuilder {

    //Get our characters Data API
  //  private val apiURL = Resources.getSystem().getString(R.string.data_api)
    private val apiURL = "http://api.duckduckgo.com/?q=simpsons+characters&format=json"

        //Create HTTP CLIENT
    private val okHttp = OkHttpClient.Builder()

    //retrofit builder
    private val builder = Retrofit.Builder().baseUrl(apiURL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttp.build())

    //create retrofit Instance
    private val retrofit = builder.build()

    //we will use this class to create an anonymous inner class function that
    //implements Character service Interface

    fun <T> buildService (serviceType :Class<T>):T{
        return retrofit.create(serviceType)
    }

}