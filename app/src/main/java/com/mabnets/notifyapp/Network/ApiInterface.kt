package com.mabnets.notifyapp.Network

import com.mabnets.notifyapp.Models.Resultstuff

import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiInterface {
    companion object{
        const val BASE_URL="https://repentanceandholinessinfo.com/"
    }
    @FormUrlEncoded
    @POST("account.php")
    suspend fun tobesent(
            @Field("nmssg") message: String,
            @Field("ntitle") title: String


    ):Resultstuff

}