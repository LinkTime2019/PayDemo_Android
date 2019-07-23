package com.example.administrator.paydemo.bean

data class TokenBean(
    var access_token: String,
    var token_type: String,
    var expires_in: Int = 0,
    var scope: String,
    var jti: String
)
