package com.example.retrofit_example.data

data class Books(
    val books: List<Book>
)

data class Book(
    val id: Int,
    val title: String
)