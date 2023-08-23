package com.example.retrofitlibrary

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query


//https://newsapi.org/v2/top-headlines?country=in&apiKey=API_KEY

//https://newsapi.org/v2/everything?q=apple&from=2023-08-22&to=2023-08-22&sortBy=popularity&apiKey=API_KEY


const val BASE_URL = "https://newsapi.org/"
const val API_KEY = "169e19b9db7e435eb7b0578ab770a4ea"


interface NewsInterface {

    @GET("v2/top-headlines?apiKey=$API_KEY")
    fun getHeadLines(@Query("country") country: String, @Query("page") page: Int): Call<News>
}
// https://newsapi.org/v2/top-headlines?apiKey=$API_KEY&country=in&page=3


object NewsService {
    val newsInstance:NewsInterface
    init {

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()

        newsInstance= retrofit.create(NewsInterface::class.java)
    }
}