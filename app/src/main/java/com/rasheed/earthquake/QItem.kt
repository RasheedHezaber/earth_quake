package com.rasheed.earthquake

import com.google.gson.annotations.SerializedName

data class QItem (

    @SerializedName("properties")
    var props: QProperties = QProperties(),

    @SerializedName("geometry")
    var geo: QuakeGeo = QuakeGeo()
)