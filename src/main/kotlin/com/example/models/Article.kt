package com.example.models

import kotlinx.serialization.Serializable

@Serializable
data class Article(
    val id: String,
    val name: String,
    val date_added: String,
    
)