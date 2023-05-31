package com.example.anywheremobileexercise

import android.content.Context
import android.content.res.Resources
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import com.example.anywheremobileexercise.CharactersService
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
* Author: Steve Stansbury.
*/

class MainActivity : AppCompatActivity() {

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

        if (isNetworkConnected) {
            loadCharacters()
        } else {
            Toast.makeText(applicationContext, "No Internet Connection Yet!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun loadCharacters() {
        //initiate the service
        val destinationService = ServiceBuilder.buildService(CharactersService::class.java)
        val requestCall = destinationService.getAffectedCharacterList()
        
        //make network call asynchronously
        requestCall.enqueue(object : Callback<List<MyCharacter>> {
            override fun onResponse(call: Call<List<MyCharacter>>, response: Response<List<MyCharacter>>) {
                Log.d("Response", "onResponse: ${response.body()}")
                if (response.isSuccessful){
                    val characterList = response.body()!!
                    Log.d("Response", "characterlist size : ${characterList.size}")
                 /*   viewer_recycler.apply {
                        setHasFixedSize(true)
                        layoutManager = GridLayoutManager(this@MainActivity,2)
                        adapter = CharactersAdapter(response.body()!!)
                    }*/
                }else{
                    Toast.makeText(this@MainActivity, "Something went wrong ${response.message()}", Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<List<MyCharacter>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Something went wrong $t", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
