package com.rasheed.earthquake

import com.google.gson.annotations.SerializedName

class QProperties (
    @SerializedName("place")
    var place: String = "",
    @SerializedName("time")
    var time: Long  = 0L,
    @SerializedName("mag")
    var magnitude : String = ""
    )