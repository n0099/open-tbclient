package com.sina.weibo.sdk.sso;

import android.content.Context;
import android.text.TextUtils;
import com.sina.weibo.sdk.utils.LogUtil;
import com.weibo.ssosdk.WeiboSsoSdk;
import d.p.a.a;
import d.p.a.b;
import d.p.a.c;
/* loaded from: classes6.dex */
public final class WeiboSsoManager {
    public static final String TAG = "WeiboSsoManager";
    public String aid;

    /* loaded from: classes6.dex */
    public static class Instance {
        public static final WeiboSsoManager instance = new WeiboSsoManager();
    }

    public static synchronized WeiboSsoManager getInstance() {
        WeiboSsoManager weiboSsoManager;
        synchronized (WeiboSsoManager.class) {
            weiboSsoManager = Instance.instance;
        }
        return weiboSsoManager;
    }

    private void initAid() {
        try {
            WeiboSsoSdk.i().m(new b() { // from class: com.sina.weibo.sdk.sso.WeiboSsoManager.1
                @Override // d.p.a.b
                public void handler(WeiboSsoSdk.d dVar) {
                    if (dVar != null) {
                        WeiboSsoManager.this.aid = dVar.a();
                        return;
                    }
                    LogUtil.d(WeiboSsoManager.TAG, "VisitorLoginInfo is null.");
                }
            });
        } catch (Exception e2) {
            e2.printStackTrace();
            LogUtil.e(TAG, e2.getMessage());
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
        return a.n(context);
    }

    public void init(Context context, String str) {
        LogUtil.d(TAG, "init config");
        c cVar = new c();
        cVar.j(context);
        cVar.i(str);
        cVar.k("1478195010");
        cVar.l("1000_0001");
        WeiboSsoSdk.j(cVar);
        initAid();
    }

    public WeiboSsoManager() {
    }
}
