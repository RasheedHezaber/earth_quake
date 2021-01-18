package com.rasheed.api

import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("fdsnws/event/1/query?format=geojson&limit=10")
    fun fetchQuakes(): Call<EarthQuakeRes>
}