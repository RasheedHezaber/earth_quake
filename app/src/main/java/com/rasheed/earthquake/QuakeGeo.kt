package com.rasheed.earthquake

import com.google.gson.annotations.SerializedName

class QuakeGeo (
    @SerializedName("coordinates")
    var g: List<Double> = emptyList()
)