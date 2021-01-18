package com.rasheed.earthquake


import com.rasheed.api.EarthQuakeRes
import com.rasheed.api.Api
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val TAG = "QuakeFetchr"

class QuakeReg{

    private val api: Api

    init {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://earthquake.usgs.gov/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(Api::class.java)
    }

    fun getQuakes(): LiveData<List<QItem>> {
        val responseLiveData: MutableLiveData<List<QItem>> = MutableLiveData()
        val quakeRequest: Call<EarthQuakeRes> = api.fetchQuakes()

        quakeRequest.enqueue(object : Callback<EarthQuakeRes> {

            override fun onFailure(call: Call<EarthQuakeRes>, t: Throwable) {
                Log.e(TAG, "Failed to fetch quakes",t)
            }

            override fun onResponse(call: Call<EarthQuakeRes>, res: Response<EarthQuakeRes>) {
                Log.d(TAG, "Response received corr")
                val quakeRes: EarthQuakeRes? = res.body()
                var qItems: List<QItem> = quakeRes?.qs
                    ?: mutableListOf()
                responseLiveData.value = qItems
            }
        })

        return responseLiveData
    }
}