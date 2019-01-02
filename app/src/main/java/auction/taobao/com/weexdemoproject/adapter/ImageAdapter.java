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


public class ImageAdapter implements IWXImgLoaderAdapter {


    @Override
    public void setImage(final String url, final ImageView view, WXImageQuality quality, final WXImageStrategy strategy) {
        //实现你自己的图片下载。

    }
}
