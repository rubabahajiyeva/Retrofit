package com.rubabe.retrofit

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rubabe.retrofit.model.DTO
import com.rubabe.retrofit.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getSuperHeroes()
    }

    private fun getSuperHeroes() {
        val call: Call<List<DTO>>? = RetrofitClient.instance?.getMyApi()?.getsuperHeroes()
        call?.enqueue(object : Callback<List<DTO>> {


            override fun onResponse(call: Call<List<DTO>>, response: Response<List<DTO>>) {
                val myheroList: List<DTO> = response.body() as List<DTO>

                val adapter = Adapter(this@MainActivity, myheroList)
                findViewById<RecyclerView>(R.id.rV).setAdapter(adapter)
                findViewById<RecyclerView>(R.id.rV).layoutManager = LinearLayoutManager(this@MainActivity,LinearLayoutManager.VERTICAL,false)

            }

            override fun onFailure(call: Call<List<DTO>>, t: Throwable) {
                Toast.makeText(applicationContext, "An error has occured", Toast.LENGTH_LONG).show()
            }

        })
    }
}