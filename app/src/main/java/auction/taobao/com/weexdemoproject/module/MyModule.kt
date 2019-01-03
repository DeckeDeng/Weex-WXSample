package auction.taobao.com.weexdemoproject.module

import android.widget.Toast
import com.taobao.weex.annotation.JSMethod
import com.taobao.weex.common.WXModule
import org.jetbrains.anko.toast


/**
 * module是完成一个操作的方法集合，类似package，例如网络请求的stream module。
   module扩展非UI的特定功能，例如 sendHttp、openURL 等。
   weex sdk中内置了部分module，app端也可以注册module，供js调用。
   Weex是根据反射来进行调用 Module 扩展方法，所以Module中的扩展方法必须是 public 类型，且module不能被混淆
 */
class MyModule : WXModule() {


    /**
     * 扩展方法必须加上@JSMethod (uiThread = false or true) 注解。
     * Weex 会根据注解来判断当前方法是否要运行在 UI 线程，和当前方法是否是扩展方法。
     */
    @JSMethod(uiThread = true)
    open fun printLog(msg: String) {
        Toast.makeText(mWXSDKInstance.getContext(), msg, Toast.LENGTH_SHORT).show();
    }

    @JSMethod(uiThread = false)
    open fun fireEventSyncCall() {
        //implement your module logic here
    }

}