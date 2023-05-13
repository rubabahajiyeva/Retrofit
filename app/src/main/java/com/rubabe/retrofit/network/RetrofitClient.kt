package com.rubabe.retrofit.network

import com.rubabe.retrofit.Constants
import com.rubabe.retrofit.api.API
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitClient private constructor() {
    private val myApi: API

    init {
        val retrofit: Retrofit = Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        myApi = retrofit.create(API::class.java)
    }

    fun getMyApi(): API {
        return myApi
    }

    companion object {
        @get:Synchronized
        var instance: RetrofitClient? = null
            get() {
                if (field == null) {
                    field = RetrofitClient()
                }
                return field
            }
            private set
    }
}