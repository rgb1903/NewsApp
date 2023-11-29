package com.example.globalnews.repos

import com.google.gson.annotations.SerializedName


data class Model(
    @SerializedName("articles")
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
){
}
