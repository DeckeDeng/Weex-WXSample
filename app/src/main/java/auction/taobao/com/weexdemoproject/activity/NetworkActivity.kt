package auction.taobao.com.weexdemoproject.activity

import auction.taobao.com.weexdemoproject.R
import com.taobao.weex.WXSDKInstance
import com.taobao.weex.common.WXRenderStrategy
import com.taobao.weex.utils.WXFileUtils
import java.util.HashMap


/**
 * Author: xiaojia.dxj
 * Date: 2019/1/3 10:48
 * Email: xiaojia.dxj@alibaba-inc.com
 * LastUpdateTime: 2019/1/3 10:48
 * LastUpdateBy: xiaojia.dxj
 *
 * Describle:
 */
class NetworkActivity : BaseActivity() {

    override fun getLayoutId(): Int = R.layout.activity_main


    override fun initData() {
        val TEST_URL = "http://dotwe.org/raw/dist/6fe11640e8d25f2f98176e9643c08687.bundle.js"
        val options = HashMap<String, Any>()
        options[WXSDKInstance.BUNDLE_URL] = TEST_URL
        /**
         * pageName:自定义，一个标示符号。
         * url:远程bundle JS的下载地址
         * options:初始化时传入WEEX的参数，比如 bundle JS地址
         * flag:渲染策略。WXRenderStrategy.APPEND_ASYNC:异步策略先返回外层View，其他View渲染完成后调用onRenderSuccess。
         * WXRenderStrategy.APPEND_ONCE 所有控件渲染完后后一次性返回。
         */
        mWXSDKInstance.renderByUrl("WXSample", TEST_URL, options, null, WXRenderStrategy.APPEND_ONCE)

    }

}