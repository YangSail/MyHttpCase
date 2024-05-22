package com.example.myhttpcase.model

import android.content.ClipData
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myhttpcase.model.bean.UserData
import com.example.myhttpcase.network.ApiService
import dagger.hilt.android.lifecycle.HiltViewModel

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch


import javax.inject.Inject

/**
 *
 * 作者: 杨志凡
 * 时间: 2024/5/10 15:21
 */
@HiltViewModel
class MainActivityViewModel @Inject constructor(private val apiService: ApiService) : ViewModel() {
    // 使用StateFlow或SharedFlow来暴露数据
    private val _items = MutableStateFlow<String>("")
    val items: StateFlow<String> = _items

//    init {
//        fetchItems()
//    }

    fun fetchItems() {
        viewModelScope.launch { // 假设你有一个viewModelScope来处理协程
            val items = apiService.getItems()
            Log.e("fetchItems", "fetchItems: $items")
            _items.value = items.toString()
        }
    }

}



