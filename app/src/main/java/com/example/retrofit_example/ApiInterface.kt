package com.example.retrofit_example

import com.example.retrofit_example.data.Books
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("dbooks.json")
    fun getBooks(): Call <Books>

}