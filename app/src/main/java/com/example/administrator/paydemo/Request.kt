package com.example.administrator.paydemo

import com.example.administrator.paydemo.bean.TokenBean
import com.example.administrator.paydemo.request.RetrofitApi
import com.example.administrator.paydemo.request.SToken

object Request {

    //http://open.pandax.tech/oauth/token?grant_type=client_credentials&client_id=unitimes&client_secret=123456&scope=basic

    fun getAuth(): rx.Observable<TokenBean> {
        return RetrofitApi.getRetrofit()?.create(SToken::class.java).getCall(
            "client_credentials",
            "unitimes",
            "123456",
            "basic"
        )
    }

}
