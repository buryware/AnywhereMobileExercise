package com.example.anywheremobileexercise

import com.google.gson.annotations.SerializedName

data class MyCharacter(
    val charactername: String,
    val charactertitle: String,
    val characterdescription: String,
    val characterInfo: CharacterInfo,
) {
    data class CharacterInfo(
        val flag: String,
        @SerializedName("_id")
        val id: Int
    )
}