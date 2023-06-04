package com.example.ejercicio02_cm.view.activities

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ejercicio02_cm.R
import com.example.ejercicio02_cm.databinding.ActivityMainBinding
import com.example.ejercicio02_cm.model.Character
import com.example.ejercicio02_cm.network.HPAPI
import com.example.ejercicio02_cm.network.RetrofitService
import com.example.ejercicio02_cm.utils.Constants
import com.example.ejercicio02_cm.view.adapters.HPAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        val b = intent.extras
        var value = -1 // or other values
        if (b!= null) {
            value = b.getInt("key")
        }

        if (value == 1) {
            val call = RetrofitService.getRetrofit().create(HPAPI::class.java)
                .getCharacters("api/characters/staff/")

            call.enqueue(object : Callback<ArrayList<Character>> {
                override fun onResponse(
                    call: Call<ArrayList<Character>>,
                    response: Response<ArrayList<Character>>
                ) {
                    binding.pbRecyclerView.visibility = View.GONE
                    Log.d(Constants.LOGTAG, "Server response: ${response.toString()}")
                    Log.d(Constants.LOGTAG, "Data: ${response.body().toString()}")

                    binding.rvMainActivity.layoutManager = LinearLayoutManager(this@MainActivity)


                    if (response.body().isNullOrEmpty()) {
                        Toast.makeText(
                            this@MainActivity,
                            R.string.connectionerror,
                            Toast.LENGTH_LONG
                        ).show()
                    } else {
                        binding.rvMainActivity.adapter =
                            HPAdapter(this@MainActivity, response.body()!!)
                    }

                }

                override fun onFailure(call: Call<ArrayList<Character>>, t: Throwable) {
                    binding.pbRecyclerView.visibility = View.GONE
                    Toast.makeText(this@MainActivity, R.string.connectionerror, Toast.LENGTH_LONG)
                        .show()
                }

            })
        }

        if (value == 2) {
            val call = RetrofitService.getRetrofit().create(HPAPI::class.java)
                .getCharacters("api/characters/students/")

            call.enqueue(object : Callback<ArrayList<Character>> {
                override fun onResponse(
                    call: Call<ArrayList<Character>>,
                    response: Response<ArrayList<Character>>
                ) {
                    binding.pbRecyclerView.visibility = View.GONE
                    Log.d(Constants.LOGTAG, "Server response: ${response.toString()}")
                    Log.d(Constants.LOGTAG, "Data: ${response.body().toString()}")

                    binding.rvMainActivity.layoutManager = LinearLayoutManager(this@MainActivity)


                    if (response.body().isNullOrEmpty()) {
                        Toast.makeText(
                            this@MainActivity,
                            R.string.connectionerror,
                            Toast.LENGTH_LONG
                        ).show()
                    } else {
                        binding.rvMainActivity.adapter =
                            HPAdapter(this@MainActivity, response.body()!!)
                    }

                }

                override fun onFailure(call: Call<ArrayList<Character>>, t: Throwable) {
                    binding.pbRecyclerView.visibility = View.GONE
                    Toast.makeText(this@MainActivity, R.string.connectionerror, Toast.LENGTH_LONG)
                        .show()
                }

            })
        }






    }
}