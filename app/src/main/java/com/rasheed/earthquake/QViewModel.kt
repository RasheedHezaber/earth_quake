package com.rasheed.earthquake

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class QViewModel : ViewModel() {

    val qItemLiveData: LiveData<List<QItem>>

    init {
        qItemLiveData = QuakeReg().getQuakes()
    }
}