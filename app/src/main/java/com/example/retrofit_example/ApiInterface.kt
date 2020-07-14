package com.example.retrofit_example

import com.example.retrofit_example.data.Books
import retrofit2.Call
import retrofit2.http.GET

//private const val JSONURL = "http://10.0.2.2:3000/"

interface ApiInterface {

    @GET("dbooks.json")
    fun getBooks(): Call<List<Books>>

}