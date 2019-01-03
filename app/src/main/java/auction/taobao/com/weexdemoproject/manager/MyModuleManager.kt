package auction.taobao.com.weexdemoproject.manager

import android.app.Application
import auction.taobao.com.weexdemoproject.adapter.ImageAdapter
import auction.taobao.com.weexdemoproject.module.MyModule
import com.taobao.weex.InitConfig
import com.taobao.weex.WXSDKEngine


/**
 * Author: xiaojia.dxj
 * Date: 2019/1/2 17:42
 * Email: xiaojia.dxj@alibaba-inc.com
 * LastUpdateTime: 2019/1/2 17:42
 * LastUpdateBy: xiaojia.dxj
 *
 * Describle:
 */
class MyModuleManager {

   open fun initSDK(context: Application) {
       //初始化weex
        val weexConfig = InitConfig.Builder().setImgAdapter(ImageAdapter()).build()
        WXSDKEngine.initialize(context, weexConfig)
        WXSDKEngine.registerModule("MyModule", MyModule::class.java)
    }


}

