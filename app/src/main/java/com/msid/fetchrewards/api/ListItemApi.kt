package com.msid.fetchrewards.api

import com.msid.fetchrewards.model.Items
import retrofit2.Response
import retrofit2.http.GET

interface ListItemApi {

    @GET("/hiring.json")
    suspend fun getItems() : Response<Items>
}

