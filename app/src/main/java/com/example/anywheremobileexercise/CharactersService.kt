package com.example.anywheremobileexercise

import retrofit2.Call
import retrofit2.http.GET

interface CharactersService {

    @GET("countries")
    fun getAffectedCharacterList () : Call<List<MyCharacter>>
}