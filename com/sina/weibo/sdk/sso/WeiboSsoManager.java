package com.sina.weibo.sdk.sso;

import android.content.Context;
import android.text.TextUtils;
import com.sina.weibo.sdk.utils.LogUtil;
import com.weibo.ssosdk.WeiboSsoSdk;
import com.weibo.ssosdk.a;
import com.weibo.ssosdk.b;
/* loaded from: classes4.dex */
public final class WeiboSsoManager {
    private static final String TAG = "WeiboSsoManager";
    private String aid;

    /* loaded from: classes4.dex */
    private static class Instance {
        private static final WeiboSsoManager instance = new WeiboSsoManager();

        private Instance() {
        }
    }

    private WeiboSsoManager() {
    }

    public static synchronized WeiboSsoManager getInstance() {
        WeiboSsoManager weiboSsoManager;
        synchronized (WeiboSsoManager.class) {
            weiboSsoManager = Instance.instance;
        }
        return weiboSsoManager;
    }

    public void init(Context context, String str) {
        LogUtil.d(TAG, "init config");
        b bVar = new b();
        bVar.setContext(context);
        bVar.setAppKey(str);
        bVar.setFrom("1478195010");
        bVar.QG("1000_0001");
        WeiboSsoSdk.a(bVar);
        initAid();
    }

    private void initAid() {
        try {
            this.aid = WeiboSsoSdk.dCC().dCE();
            if (TextUtils.isEmpty(this.aid)) {
                this.aid = WeiboSsoSdk.dCC().dCD().dCE();
            }
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.e(TAG, e.getMessage());
        }
    }

    public String getAid(Context context, String str) {
        LogUtil.d(TAG, "getAid()");
        if (TextUtils.isEmpty(this.aid)) {
            init(context, str);
        }
        return this.aid;
    }

    public String getMfp(Context context) {
        return a.getMfp(context);
    }
}
