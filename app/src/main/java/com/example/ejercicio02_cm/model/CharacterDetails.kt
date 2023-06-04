package com.example.ejercicio02_cm.model

import com.google.gson.annotations.SerializedName
import android.os.Parcel
import android.os.Parcelable

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

    @SerializedName("dateOfBirth")
    var dateOfBirth: String?,


    @SerializedName("ancestry")
    var ancestry: String?,

    @SerializedName("eyeColour")
    var eyeColour: String?,

    ) : Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(image)
        parcel.writeString(name)
        parcel.writeString(actor)
        parcel.writeString(hogwartsStudent)
        parcel.writeString(hogwartsStaff)
        parcel.writeString(house)
        parcel.writeString(species)
        parcel.writeString(dateOfBirth)
        parcel.writeString(ancestry)
        parcel.writeString(eyeColour)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CharacterDetails> {
        override fun createFromParcel(parcel: Parcel): CharacterDetails {
            return CharacterDetails(parcel)
        }


        override fun newArray(size: Int): Array<CharacterDetails?> {
            return arrayOfNulls(size)
        }
    }
}

