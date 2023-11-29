package com.example.globalnews.service

import com.example.globalnews.repos.Model
import io.reactivex.Single
import retrofit2.http.GET

interface NewsApi {

    // https://newsapi.org/v2/everything?domains=wsj.com&apiKey=661a529f210445eaa950ac01df05a4ff

    @GET("v2/everything?domains=wsj.com&apiKey=661a529f210445eaa950ac01df05a4ff")
    fun getNews() : Single<Model>

}