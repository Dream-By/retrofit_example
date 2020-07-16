package com.example.retrofit_example.data

import com.squareup.moshi.Json

data class Books(
    val results: List<Book>
)

data class Book(
        @field:Json (name = "id") val id: Int,
        @field:Json (name = "title") val title: String
)