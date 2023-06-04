package com.example.ejercicio02_cm.view.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.ejercicio02_cm.databinding.ActivitystudentsstaffBinding

class ChooseStudentStaff : AppCompatActivity() {

    private lateinit var binding: ActivitystudentsstaffBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitystudentsstaffBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
    }

    fun sendtostaff(view: View) {

        val intent = Intent(this, MainActivity::class.java)
        val b = Bundle()
        b.putInt("key", 1)
        intent.putExtras(b)
        startActivity(intent)
    }

    fun sendtostudents(view: View) {

        val intent = Intent(this, MainActivity::class.java)
        val b = Bundle()
        b.putInt("key", 2)
        intent.putExtras(b)
        startActivity(intent)
    }


}