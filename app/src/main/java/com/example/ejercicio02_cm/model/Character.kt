package com.example.ejercicio02_cm.model

import com.google.gson.annotations.SerializedName

data class Character (

    @SerializedName("id")
    var id: String?,
    @SerializedName("image")
    var image: String?,
    @SerializedName("name")
    var name: String?,
    @SerializedName("actor")
    var actor: String?,
    @SerializedName("dateOfBirth")
    var dateOfBirth: String?,
    @SerializedName("house")
    var house: String?,

    )
