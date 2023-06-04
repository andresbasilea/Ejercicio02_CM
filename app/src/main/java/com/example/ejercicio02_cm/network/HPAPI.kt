package com.example.ejercicio02_cm.network


import com.example.ejercicio02_cm.model.Character
import com.example.ejercicio02_cm.model.CharacterDetails
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Url






interface HPAPI {

    @GET
    fun getCharacters(
        @Url url:String?
    ): Call<ArrayList<Character>>

    @GET("api/character/{id}")
    fun getCharacterDetails(
        @Path("id") id:String?
    ): Call<CharacterDetails>




}