package com.example.myhttpcase.network

import android.content.ClipData.Item
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

/**
 *
 * 作者: 杨志凡
 * 时间: 2024/5/10 18:38
 */
interface ApiService {
    @GET("/article/list/0/json")
    suspend fun getItems():  String  // 使用 Flow 作为返回类型
}