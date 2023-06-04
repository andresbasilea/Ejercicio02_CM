package com.example.ejercicio02_cm.view.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ejercicio02_cm.databinding.ActivitySplashScreenBinding
import kotlin.concurrent.thread

class SplashScreen : AppCompatActivity() {

    private lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        setContentView(binding.root)
        thread{
            Thread.sleep(1500)
            val intent = Intent(this, ChooseStudentStaff::class.java)
            startActivity(intent)
            finish()
        }
    }
}