package com.example.ejercicio02_cm.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.ejercicio02_cm.R
import com.example.ejercicio02_cm.databinding.ActivityMainBinding
import com.example.ejercicio02_cm.databinding.ActivitycharacterdetailsBinding
import com.example.ejercicio02_cm.model.CharacterDetails
import com.example.ejercicio02_cm.view.adapters.HPAdapter
import com.google.gson.annotations.SerializedName

class ShowCharacterDetails : AppCompatActivity() {

    private lateinit var binding: ActivitycharacterdetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitycharacterdetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        val characterDetails = intent.getParcelableExtra<CharacterDetails>("character")



        characterDetails?.let {
            binding.tvNombrePersonaje.text = it.name
            binding.tvActor.text = "${getString(R.string.actor)} : ${it.actor}"
            binding.tvDateOfBirth.text = "${getString(R.string.fechaNacimiento)} : ${it.dateOfBirth}"
            binding.tvHouse.text = "${getString(R.string.house)} : ${it.house}"
            binding.tvEyeColour.text = "${getString(R.string.eyeColour)} : ${ it.eyeColour}"
            binding.tvSpecies.text = "${getString(R.string.species)} : ${ it.species}"
            binding.tvAncestry.text = "${getString(R.string.ancestry)} : ${ it.ancestry}"

            Glide.with(this)
                .load(it.image)
                .into(binding.ivImage)
        }




    }
}