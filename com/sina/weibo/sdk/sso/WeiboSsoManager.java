package com.sina.weibo.sdk.sso;

import android.content.Context;
import android.text.TextUtils;
import com.sina.weibo.sdk.utils.LogUtil;
import com.weibo.ssosdk.WeiboSsoSdk;
import com.weibo.ssosdk.a;
import com.weibo.ssosdk.b;
/* loaded from: classes2.dex */
public final class WeiboSsoManager {
    private static final String TAG = "WeiboSsoManager";
    private static WeiboSsoManager sInstance;

    private WeiboSsoManager() {
    }

    public static synchronized WeiboSsoManager getInstance() {
        WeiboSsoManager weiboSsoManager;
        synchronized (WeiboSsoManager.class) {
            if (sInstance == null) {
                sInstance = new WeiboSsoManager();
            }
            weiboSsoManager = sInstance;
        }
        return weiboSsoManager;
    }

    public void init(Context context, String str) {
        LogUtil.d(TAG, "init config");
        b bVar = new b();
        bVar.setContext(context);
        bVar.setAppKey(str);
        bVar.setFrom("1478195010");
        bVar.Ii("1000_0001");
        WeiboSsoSdk.a(bVar);
    }

    public String getAid() {
        Exception e;
        LogUtil.d(TAG, "getAid()");
        try {
            String aid = WeiboSsoSdk.cND().getAid();
            try {
                if (TextUtils.isEmpty(aid)) {
                    return WeiboSsoSdk.cND().cNE().getAid();
                }
                return aid;
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                LogUtil.e(TAG, e.getMessage());
                return null;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    public String getMfp(Context context) {
        return a.getMfp(context);
    }
}
