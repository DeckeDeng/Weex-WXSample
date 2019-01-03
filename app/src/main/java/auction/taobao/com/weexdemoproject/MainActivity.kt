package auction.taobao.com.weexdemoproject

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import auction.taobao.com.weexdemoproject.activity.LocalActivity
import auction.taobao.com.weexdemoproject.activity.NetworkActivity
import auction.taobao.com.weexdemoproject.manager.MyModuleManager
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MyModuleManager().initSDK(application)

        btn_local.setOnClickListener {
            startActivity<LocalActivity>()
        }

        btn_netWork.setOnClickListener {
//            toast("等待")
            startActivity<NetworkActivity>()
        }

    }

}
