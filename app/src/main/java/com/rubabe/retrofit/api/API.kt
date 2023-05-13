package com.rubabe.retrofit.api

import com.rubabe.retrofit.DTO
import retrofit2.Call
import retrofit2.http.GET


interface API {

    @GET("marvel")
    fun getsuperHeroes(): Call<List<DTO>>

}