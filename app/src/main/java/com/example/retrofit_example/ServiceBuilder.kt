package com.example.retrofit_example

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object ServiceBuilder {
    private val client = OkHttpClient.Builder().build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("http://10.0.2.2:3000/")
        .addConverterFactory(MoshiConverterFactory.create())
        .client(client)
        .build()

    fun <T> buildService(service:Class<T>):T{
        return retrofit.create(service)
    }

}