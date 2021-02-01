package com.sdk.mobile.manager.login.cucc;

import android.content.Context;
import com.sdk.base.api.CallBack;
import com.sdk.base.module.manager.SDKManager;
import com.sdk.mobile.b.a;
/* loaded from: classes4.dex */
public class UiOauthManager extends SDKManager {
    private static volatile UiOauthManager manager;
    private Context mContext;

    private UiOauthManager(Context context) {
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

    public <T> void login(int i, CallBack<T> callBack) {
        new a(this.mContext, i, callBack).a(0);
    }
}
