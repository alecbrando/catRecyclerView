package com.alecbrando.anotherretrofitexample.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alecbrando.anotherretrofitexample.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository): ViewModel() {

    val response: MutableLiveData<Response<List<String>>> = MutableLiveData()

    fun getCats(count: Int = 10) {
        viewModelScope.launch {
            val res : Response<List<String>> = repository.getCats(count)
            response.value = res
        }
    }
}