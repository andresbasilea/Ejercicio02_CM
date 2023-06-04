package com.example.ejercicio02_cm.view.activities

import android.os.Bundle
import android.util.Log
import android.view.View
import android.content.Intent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ejercicio02_cm.R
import com.example.ejercicio02_cm.databinding.ActivityMainBinding
import com.example.ejercicio02_cm.model.CharacterDetails
import com.example.ejercicio02_cm.network.HPAPI
import com.example.ejercicio02_cm.network.RetrofitService
import com.example.ejercicio02_cm.utils.Constants
import com.example.ejercicio02_cm.view.adapters.HPAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), HPAdapter.OnItemClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onItemClick(character: CharacterDetails){
        val intent = Intent(this, ShowCharacterDetails::class.java )
        intent.putExtra("character", character)
        startActivity(intent)
    }


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

            call.enqueue(object : Callback<ArrayList<CharacterDetails>> {
                override fun onResponse(
                    call: Call<ArrayList<CharacterDetails>>,
                    response: Response<ArrayList<CharacterDetails>>
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
                        val adapter = HPAdapter(this@MainActivity, response.body()!!)
//                        binding.rvMainActivity.adapter =
//                            adapter
                        adapter.setOnItemClickListener(this@MainActivity)
                        binding.rvMainActivity.adapter = adapter

                    }

                }

                override fun onFailure(call: Call<ArrayList<CharacterDetails>>, t: Throwable) {
                    binding.pbRecyclerView.visibility = View.GONE
                    Toast.makeText(this@MainActivity, R.string.connectionerror, Toast.LENGTH_LONG)
                        .show()
                }

            })
        }

        if (value == 2) {
            val call = RetrofitService.getRetrofit().create(HPAPI::class.java)
                .getCharacters("api/characters/students/")

            call.enqueue(object : Callback<ArrayList<CharacterDetails>> {
                override fun onResponse(
                    call: Call<ArrayList<CharacterDetails>>,
                    response: Response<ArrayList<CharacterDetails>>
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
                        val adapter = HPAdapter(this@MainActivity, response.body()!!)
//                        binding.rvMainActivity.adapter =
//                            adapter
                        adapter.setOnItemClickListener(this@MainActivity)
                        binding.rvMainActivity.adapter = adapter

                    }

                }

                override fun onFailure(call: Call<ArrayList<CharacterDetails>>, t: Throwable) {
                    binding.pbRecyclerView.visibility = View.GONE
                    Toast.makeText(this@MainActivity, R.string.connectionerror, Toast.LENGTH_LONG)
                        .show()

                }

            })
        }






    }
}