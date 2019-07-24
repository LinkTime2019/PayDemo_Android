# PayDemo

## 演示Gif

![](https://i.imgur.com/kNIjmKV.gif)

## 说明

此Demo用于第三方APP拉起Pandax钱包进行支付，并且可以通过向Pandax管理后台申请appid、appsecret获取临时access_token，用来发起之后支付，通过设置的回调url监听结果。整体架构图如下:

![](https://i.imgur.com/IMZLR5m.png)



## 用法

### 一、只拉起支付，不监听交易结果

    var adress = adress.text
        var money = money.text
        var token = token.text
        var name = appname.text


        var builder = StringBuilder()
        builder.append("pandax://thirdpay/")//固定格式，用来打开Pandax app
        builder.append("param=")//后面是参数

        var params = JSONObject()
        params.put("adress", adress)//地址
        params.put("amountmoney", money)//转账币的数量
        params.put("pkgname", getPackName())//应用包名---用于确认交易之后返回三方app，如果为空，确认交易之后不返回
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


第三方APP通过设置如下参数，可以直接拉起Pandax钱包

### 二、拉起支付，并且监听结果

#### 1.在管理后台申请appid、appsecret，以及设置回调url

#### 2.三方app通过调用三方服务器接口获取access_token，具体流程参考上面流程图

#### 3.三方app通过调用钱包接口获取代币列表

#### 4.通过用户选择的代币Token，拉起Pandax进行支付，具体参数如下:

    var adress = adress.text
        var money = money.text
        var token = token.text//这里可以设置为用户选择的代币Token，代币列表可以通过接口获取


        var builder = StringBuilder()
        builder.append("pandax://thirdpay/")//固定格式，用来打开app
        builder.append("param=")//后面是参数

        var params = JSONObject()
        params.put("adress", adress)//地址
        params.put("amountmoney", money)//转账币的数量
        params.put("pkgname", getPackName())//应用包名---用于确认交易之后返回三方app，如果为空，确认交易之后不返回
        params.put("token", token)//转账Token名称--
        if (tokenBean != null) {
            params.put("access_token", tokenBean?.access_token)//授权的access_token
        }
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


## PayDemo APK下载

![](https://i.imgur.com/2wNwaH6.png)
