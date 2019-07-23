package com.example.administrator.paydemo

import android.util.Log
import com.example.administrator.paydemo.bean.TokenBean
import rx.android.schedulers.AndroidSchedulers
import rx.functions.Action1
import rx.schedulers.Schedulers

class MainPresenter(private val mainView: MainView?) {

    fun getAuth() {
        Request.getAuth().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ tokenBean ->
                Log.i("clp", "tokenBean:" + tokenBean.access_token)
                mainView?.onGetAuth(tokenBean)
            }, { throwable -> Log.i("clp", "throwable" + throwable.message) })
    }
}
