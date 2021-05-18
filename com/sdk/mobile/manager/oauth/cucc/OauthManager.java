package com.sdk.mobile.manager.oauth.cucc;

import android.content.Context;
import com.sdk.base.api.CallBack;
import com.sdk.base.framework.a.a.c;
import com.sdk.base.module.manager.SDKManager;
import com.sdk.mobile.b.a;
/* loaded from: classes7.dex */
public class OauthManager extends SDKManager {
    public static volatile OauthManager manager;
    public Context mContext;

    public OauthManager(Context context) {
        this.mContext = context;
    }

    public static OauthManager getInstance(Context context) {
        if (manager == null) {
            synchronized (OauthManager.class) {
                if (manager == null) {
                    manager = new OauthManager(context);
                }
            }
        }
        return manager;
    }

    public <T> void getAuthoriseCode(int i2, CallBack<T> callBack) {
        new a(this.mContext, i2, callBack).a(1);
    }

    public <T> void getMobileForCode(String str, int i2, CallBack<T> callBack) {
        if (c.a(str).booleanValue()) {
            SDKManager.toFailed(callBack, 101001, "授权码不能为空");
        } else {
            new a(this.mContext, i2, callBack).a(str);
        }
    }

    public <T> void getMobileForCode(String str, String str2, int i2, CallBack<T> callBack) {
        if (c.a(str).booleanValue()) {
            SDKManager.toFailed(callBack, 101001, "授权码不能为空");
        } else if (c.a(str2).booleanValue()) {
            SDKManager.toFailed(callBack, 101002, "认证的手机号不能为空");
        } else {
            new a(this.mContext, i2, callBack).a(str, str2);
        }
    }
}
