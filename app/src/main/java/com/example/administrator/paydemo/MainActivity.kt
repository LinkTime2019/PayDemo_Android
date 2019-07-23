package com.example.administrator.paydemo

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.administrator.paydemo.bean.TokenBean
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject

class MainActivity : AppCompatActivity(), MainView {

    private var mainPresenter: MainPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        mainPresenter = MainPresenter(this)
        btn_to_get_auth.setOnClickListener { view ->
            go_to_auth()
        }
        btn_to_pay.setOnClickListener { view ->
            go_to_pay()
        }
    }

    fun go_to_auth() {
        mainPresenter?.getAuth()
    }

    override fun onGetAuth(tokenBean: TokenBean) {
        Toast.makeText(baseContext, "access_token=" + tokenBean?.access_token, Toast.LENGTH_LONG).show()
    }


    fun go_to_pay() {
        var adress = adress.text
        var money = money.text
        var token = token.text
        var name = appname.text


        var builder = StringBuilder()
        builder.append("pandax://thirdpay/")//固定格式，用来打开app
        builder.append("param=")//后面是参数

        var params = JSONObject()
        params.put("adress", adress)//地址
        params.put("amountmoney", money)//转账币的数量
        params.put("pkgname", "com.example.administrator.paydemo")//应用包名---用于确认交易之后返回三方app，如果为空，确认交易之后不返回
        params.put("appName", name)//应用显示名称，用于弹窗的时候显示三方app名称
        params.put("token", token)//转账Token名称--
        builder.append(params.toString())

        var data = Uri.parse(builder.toString())
        var intent = Intent(Intent.ACTION_VIEW, data)
        //保证新启动的APP有单独的堆栈，如果希望新启动的APP和原有APP使用同一个堆栈则去掉该项
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        try {
            startActivityForResult(intent, RESULT_OK)
        } catch (e: Exception) {
            e.printStackTrace()
            Toast.makeText(baseContext, "没有匹配的APP，请下载安装", Toast.LENGTH_SHORT).show()
        }
    }
}
