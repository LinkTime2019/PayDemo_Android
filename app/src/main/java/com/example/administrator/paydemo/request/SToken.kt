package com.example.administrator.paydemo.request

import com.example.administrator.paydemo.bean.TokenBean
import retrofit2.http.*

/**
 * @Author ChenP
 * @Create 2019/2/19
 * @Describe 钱包三方授权
 */
interface SToken {

    @FormUrlEncoded
    @POST(Constant.getAuth)
    fun getCall(
        @Field("grant_type") grant_type: String,
        @Field("client_id") client_id: String, @Field("client_secret") client_secret: String, @Field("scope") scope: String
    ): rx.Observable<TokenBean>
}
