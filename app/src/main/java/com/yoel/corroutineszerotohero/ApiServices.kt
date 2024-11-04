package com.yoel.corroutineszerotohero

import com.google.gson.annotations.SerializedName
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiServices {

    @GET("/api/6e6f40b0820bb3c2a01421a88c266428/search/{name}")
    suspend fun getSuperheroes(@Path("name") superheroName:String): Response<SuperHeroDataResponse>
}

data class SuperHeroDataResponse(@SerializedName("response") val response:String)