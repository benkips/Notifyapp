package com.mabnets.notifyapp.Repository

import com.mabnets.notifyapp.Network.ApiInterface
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repo @Inject constructor (private val apiInterface: ApiInterface):Baserepository(){

    suspend  fun sending(msg: String,title: String
    ) = safeApiCall {
        apiInterface.tobesent(msg,title)
    }
}