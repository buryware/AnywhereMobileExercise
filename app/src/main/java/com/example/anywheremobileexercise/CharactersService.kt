package com.example.anywheremobileexercise

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CharactersService {

    @GET("Abstract")
    fun getAffectedCharacterList () : Call<List<MyCharacter>>
}