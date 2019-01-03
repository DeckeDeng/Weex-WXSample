package auction.taobao.com.weexdemoproject;

import android.app.Application;
import auction.taobao.com.weexdemoproject.adapter.ImageAdapter;
import com.taobao.weex.InitConfig;
import com.taobao.weex.WXSDKEngine;


/**
 * 注意要在Manifest中设置android:name=".WXApplication"
 * 要实现ImageAdapter 否则图片不能下载
 * gradle 中一定要添加一些依赖，否则初始化会失败。
 * compile 'com.android.support:recyclerview-v7:23.1.1'
 * compile 'com.android.support:support-v4:23.1.1'
 * compile 'com.android.support:appcompat-v7:23.1.1'
 * compile 'com.alibaba:fastjson:1.1.45'
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
//        InitConfig config = new InitConfig.Builder().setImgAdapter(new ImageAdapter()).build();
//        WXSDKEngine.initialize(this,config);
    }
}
