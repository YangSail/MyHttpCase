package com.example.myhttpcase.network

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 *
 * 作者: 杨志凡
 * 时间: 2024/5/10 18:28
 */

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    // public static String IMAGE_URL = "http://172.28.2.12";
    private var okHttpClient: OkHttpClient?  = OkHttpClient.Builder()
        .connectTimeout(6, TimeUnit.SECONDS)
        .build()

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://www.wanandroid.com")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }


}