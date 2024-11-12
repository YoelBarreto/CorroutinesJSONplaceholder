package com.yoel.corroutineszerotohero

import com.google.gson.annotations.SerializedName
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiServices {
    @GET("/posts")
    suspend fun getSuperheroes(): Response<List<SuperHeroDataResponse>>
}

data class SuperHeroDataResponse(
    @SerializedName("userId") val userId:Int,
    @SerializedName("id") val id:Int,
    @SerializedName("title") val title:String,
    @SerializedName("body") val body:String
)