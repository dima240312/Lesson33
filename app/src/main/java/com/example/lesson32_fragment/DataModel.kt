package com.example.lesson32_fragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class DataModel:ViewModel() {
    val messageForActivity: MutableLiveData<String> by lazy{
        MutableLiveData<String>()
    }
    val messageForFragment_One: MutableLiveData<String> by lazy{
        MutableLiveData<String>()
    }
    val messageForFragment_Two: MutableLiveData<String> by lazy{
        MutableLiveData<String>()
    }
}