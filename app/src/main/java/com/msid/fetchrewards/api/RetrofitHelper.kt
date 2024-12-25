package com.msid.fetchrewards.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    val baseUrl="https://fetch-hiring.s3.amazonaws.com/"

    fun getInstance() : Retrofit {
        return Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}