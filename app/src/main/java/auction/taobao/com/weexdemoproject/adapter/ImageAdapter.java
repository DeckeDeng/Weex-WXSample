package auction.taobao.com.weexdemoproject.adapter;

import android.net.Uri;
import android.text.TextUtils;
import android.widget.ImageView;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.adapter.IWXImgLoaderAdapter;
import com.taobao.weex.common.WXImageStrategy;
import com.taobao.weex.dom.WXImageQuality;

/**
 * Created by lixinke on 16/6/1.
 * Adapter 扩展 Weex 对一些基础功能实现了统一的接口，可实现这些接口来定制自己的业务。例如：图片下载等。
 * handler类似于service，可被component、module或其他handler调用。
 * handler和module在位置中的位置不一样。页面的module相当于一份拷贝，会随着页面的销毁而销毁；而handler的实例是公共的，只会有一个。
 * handler一般由app实现，需要实现该handler对应的接口声明的方法。
 */
public class ImageAdapter implements IWXImgLoaderAdapter {


    @Override
    public void setImage(final String url, final ImageView view, WXImageQuality quality, final WXImageStrategy strategy) {
        //实现你自己的图片下载。
        WXSDKManager.getInstance().postOnUiThread(new Runnable() {

            @Override
            public void run() {
                if (view == null || view.getLayoutParams() == null) {
                    return;
                }
                if (TextUtils.isEmpty(url)) {
                    view.setImageBitmap(null);
                    return;
                }
                String temp = url;
                if (url.startsWith("//")) {
                    temp = "http:" + url;
                }
                if (view.getLayoutParams().width <= 0 || view.getLayoutParams().height <= 0) {
                    return;
                }


                if (!TextUtils.isEmpty(strategy.placeHolder)) {
                    Picasso.Builder builder = new Picasso.Builder(WXEnvironment.getApplication());
                    Picasso picasso = builder.build();
                    picasso.load(Uri.parse(strategy.placeHolder)).into(view);

                    view.setTag(strategy.placeHolder.hashCode(), picasso);
                }

                Picasso.with(WXEnvironment.getApplication())
                        .load(temp)
                        .transform(new BlurTransformation(strategy.blurRadius))
                        .into(view, new Callback() {
                            @Override
                            public void onSuccess() {
                                if (strategy.getImageListener() != null) {
                                    strategy.getImageListener().onImageFinish(url, view, true, null);
                                }

                                if (!TextUtils.isEmpty(strategy.placeHolder)) {
                                    ((Picasso) view.getTag(strategy.placeHolder.hashCode())).cancelRequest(view);
                                }
                            }

                            @Override
                            public void onError() {
                                if (strategy.getImageListener() != null) {
                                    strategy.getImageListener().onImageFinish(url, view, false, null);
                                }
                            }
                        });
            }
        }, 0);
    }
}
