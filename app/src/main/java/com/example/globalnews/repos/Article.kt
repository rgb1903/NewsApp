package com.example.globalnews.repos



data class Article(val source : Sources,
                   val title : String,
                   val author: String,
                   val description : String,
                   val url : String,
                   val urlToImage : String,
                   val publishedAt : String,
                   val content : String
) {

}