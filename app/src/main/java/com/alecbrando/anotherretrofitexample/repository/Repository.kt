package com.alecbrando.anotherretrofitexample.repository

import com.alecbrando.anotherretrofitexample.api.RetrofitInstance
import retrofit2.Response

class Repository {
    suspend fun getCats(count : Int): Response<List<String>> {
        return RetrofitInstance.api.getCats(count)
    }

}