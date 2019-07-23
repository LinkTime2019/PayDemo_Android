package com.example.administrator.paydemo.request

import okhttp3.OkHttpClient
import okhttp3.Protocol

import java.util.Arrays
import java.util.concurrent.TimeUnit


object OkHttpClientApi {
    val okHttpClient: OkHttpClient

    init {
        okHttpClient = OkHttpClient.Builder()
            .protocols(Arrays.asList(Protocol.HTTP_1_1))
            .connectTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(5, TimeUnit.SECONDS)
            .readTimeout(5, TimeUnit.SECONDS)
            .build()
    }


}
