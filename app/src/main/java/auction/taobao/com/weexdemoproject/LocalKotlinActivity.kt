package auction.taobao.com.weexdemoproject

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.taobao.weex.IWXRenderListener
import com.taobao.weex.common.WXRenderStrategy
import com.taobao.weex.WXSDKInstance
import com.taobao.weex.utils.WXFileUtils
import org.jetbrains.anko.startActivity
import java.util.HashMap


class LocalKotlinActivity : AppCompatActivity(), IWXRenderListener {
    override fun onRefreshSuccess(instance: WXSDKInstance?, width: Int, height: Int) {
    }

    override fun onException(instance: WXSDKInstance?, errCode: String?, msg: String?) {
    }

    override fun onViewCreated(instance: WXSDKInstance?, view: View?) {
        setContentView(view)
    }

    override fun onRenderSuccess(instance: WXSDKInstance?, width: Int, height: Int) {
    }

    val mWXSDKInstance by lazy {
        WXSDKInstance(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mWXSDKInstance.registerRenderListener(this)


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

    override fun onResume() {
        super.onResume()
        if (mWXSDKInstance != null) {
            mWXSDKInstance.onActivityResume()
        }
    }

    override fun onPause() {
        super.onPause()
        if (mWXSDKInstance != null) {
            mWXSDKInstance.onActivityPause()
        }
    }

    override fun onStop() {
        super.onStop()
        if (mWXSDKInstance != null) {
            mWXSDKInstance.onActivityStop()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (mWXSDKInstance != null) {
            mWXSDKInstance.onActivityDestroy()
        }
    }

}
