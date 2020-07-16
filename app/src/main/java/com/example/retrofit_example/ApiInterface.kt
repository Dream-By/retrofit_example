package com.example.retrofit_example

import com.example.retrofit_example.data.Book
import com.example.retrofit_example.data.Books
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {

    @GET("/books")
    fun getBooks(): Call <List<Book>>

    @DELETE("/books/{id}")
    fun delBooks(@Path("id") id : Int) : Call<Response<Void>>

}