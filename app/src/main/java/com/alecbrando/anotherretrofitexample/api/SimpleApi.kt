package com.alecbrando.anotherretrofitexample.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SimpleApi {
    @GET("/api/cats")
    suspend fun getCats(@Query("count") count : Int) : Response<List<String>>
}