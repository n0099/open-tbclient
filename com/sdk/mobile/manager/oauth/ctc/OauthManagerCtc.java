package com.sdk.mobile.manager.oauth.ctc;

import android.content.Context;
import com.sdk.base.api.CallBack;
import com.sdk.base.framework.a.a.c;
import com.sdk.base.module.manager.SDKManager;
import com.sdk.mobile.b.a.a;
import com.sdk.mobile.manager.oauth.cucc.OauthManager;
/* loaded from: classes5.dex */
public class OauthManagerCtc extends SDKManager {
    private static volatile OauthManagerCtc manager;
    private Context mContext;

    private OauthManagerCtc(Context context) {
        this.mContext = context;
    }

    public static OauthManagerCtc getInstance(Context context) {
        if (manager == null) {
            synchronized (OauthManager.class) {
                if (manager == null) {
                    manager = new OauthManagerCtc(context);
                }
            }
        }
        return manager;
    }

    public <T> void getAuthoriseCode(int i, CallBack<T> callBack) {
        new a(this.mContext, i, callBack).a(1);
    }

    public <T> void getMobileForCode(String str, int i, CallBack<T> callBack) {
        if (c.a(str).booleanValue()) {
            toFailed(callBack, 101001, "授权码不能为空");
        } else {
            new a(this.mContext, i, callBack).a(str, null);
        }
    }

    public <T> void getMobileForCode(String str, String str2, int i, CallBack<T> callBack) {
        if (c.a(str).booleanValue()) {
            toFailed(callBack, 101001, "授权码不能为空");
        } else if (c.a(str2).booleanValue()) {
            toFailed(callBack, 101002, "认证的手机号不能为空");
        } else {
            new a(this.mContext, i, callBack).a(str, str2);
        }
    }
}
