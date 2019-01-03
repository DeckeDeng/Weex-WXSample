package auction.taobao.com.weexdemoproject.activity

import auction.taobao.com.weexdemoproject.R
import com.taobao.weex.common.WXRenderStrategy
import com.taobao.weex.utils.WXFileUtils


class LocalActivity : BaseActivity() {
    override fun initData() {
        /**
         * WXSample 可以替换成自定义的字符串，针对埋点有效。
         * template 是.we transform 后的 js文件。
         * option 可以为空，或者通过option传入 js需要的参数。例如bundle js的地址等。
         * jsonInitData 可以为空。
         * width 为-1 默认全屏，可以自己定制。
         * height =-1 默认全屏，可以自己定制。
         */
        mWXSDKInstance.render(
            "WXSample",
            WXFileUtils.loadAsset("hello.js", this),
            null, null, -1, -1, WXRenderStrategy.APPEND_ASYNC
        );

//        mWXSDKInstance.render(
//            "WXSample",
//            WXFileUtils.loadAsset("home.js", this),
//            null,
//            null,
//            WXRenderStrategy.APPEND_ASYNC
//        )

    }

    override fun getLayoutId(): Int = R.layout.activity_main

}
