package com.example.administrator.paydemo

import com.example.administrator.paydemo.bean.TokenBean

interface MainView {

    fun onGetAuth(tokenBean: TokenBean)
}
