package com.alecbrando.anotherretrofitexample.model

import com.squareup.moshi.Json

data class Cats(
    @Json(name = "urls") val urls: List<String>
)