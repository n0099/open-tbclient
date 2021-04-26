package com.sdk.mobile.manager.login.cucc;

import android.content.Context;
import com.sdk.base.api.CallBack;
import com.sdk.base.module.manager.SDKManager;
import com.sdk.mobile.b.a;
/* loaded from: classes6.dex */
public class UiOauthManager extends SDKManager {
    public static volatile UiOauthManager manager;
    public Context mContext;

    public UiOauthManager(Context context) {
        this.mContext = context;
    }

    public static UiOauthManager getInstance(Context context) {
        if (manager == null) {
            synchronized (UiOauthManager.class) {
                if (manager == null) {
                    manager = new UiOauthManager(context);
                }
            }
        }
        return manager;
    }

    public <T> void login(int i2, CallBack<T> callBack) {
        new a(this.mContext, i2, callBack).a(0);
    }
}
