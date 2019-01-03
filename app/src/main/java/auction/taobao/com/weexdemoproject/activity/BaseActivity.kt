package auction.taobao.com.weexdemoproject.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.taobao.weex.IWXRenderListener
import com.taobao.weex.WXSDKInstance


abstract class BaseActivity : AppCompatActivity(), IWXRenderListener {
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
        setContentView(getLayoutId())
        mWXSDKInstance.registerRenderListener(this)
        initData()


    }

    abstract fun getLayoutId(): Int
    abstract fun initData()

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
