package com.example.models

import kotlinx.serialization.Serializable

@Serializable
data class Article(
    val id: String,
    val name: String,
    val date_added: String,
    val body: String,
    val url: String,
    val category: String
)

//enum class Category

//val articleStorage = mutableListOf<Article>()
val articleStorage = mutableListOf<Article>(
    Article(
        "11",
        "article about kotlin",
        "19.06.1998",
        "Text this article",
        "https://kotlinlang.org/docs/home.html",
        "Kotlin"
    ),
    Article(
        "22",
        "article about eng",
        "20.05.2022",
        "Text this article eng",
        "https://www.youtube.com/watch?v=TDPDtrLxT-c",
        "English"
    )
)

