package com.example.administrator.paydemo.request

import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @Author ChenP
 * @Create 2019/2/19
 * @Describe Retrofit
 */
object RetrofitApi {

    private var retrofit: Retrofit? = null

    init {
        retrofit = Retrofit.Builder()
            .baseUrl("http://open.pandax.tech/")
            .client(OkHttpClientApi.okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .build()
    }

    fun getRetrofit(): Retrofit {
        return retrofit!!
    }


}
