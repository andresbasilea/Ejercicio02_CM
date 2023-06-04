package com.example.ejercicio02_cm.model

import com.google.gson.annotations.SerializedName

data class CharacterDetails(


    @SerializedName("id")
    var id: String?,
    @SerializedName("image")
    var image: String?,
    @SerializedName("name")
    var name: String?,

    @SerializedName("actor")
    var actor: String?,

    @SerializedName("hogwartsStudent")
    var hogwartsStudent: String?,
    @SerializedName("hogwartsStaff")
    var hogwartsStaff: String?,

    @SerializedName("house")
    var house: String?,

    @SerializedName("species")
    var species: String?,


    @SerializedName("ancestry")
    var ancestry: String?,

    @SerializedName("ancestry")
    var eyeColour: String?,




    )
