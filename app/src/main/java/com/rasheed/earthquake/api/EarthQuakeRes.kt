package com.rasheed.api

import com.rasheed.earthquake.QItem
import com.google.gson.annotations.SerializedName

class EarthQuakeRes (
      @SerializedName("features")
     var qs: List<QItem>
)