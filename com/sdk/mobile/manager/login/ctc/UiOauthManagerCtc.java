package com.sdk.mobile.manager.login.ctc;

import android.content.Context;
import com.sdk.base.api.CallBack;
import com.sdk.base.module.manager.SDKManager;
import com.sdk.mobile.b.a.a;
/* loaded from: classes9.dex */
public class UiOauthManagerCtc extends SDKManager {
    private static volatile UiOauthManagerCtc manager;
    private Context mContext;

    private UiOauthManagerCtc(Context context) {
        this.mContext = context;
    }

    public static UiOauthManagerCtc getInstance(Context context) {
        if (manager == null) {
            synchronized (UiOauthManagerCtc.class) {
                if (manager == null) {
                    manager = new UiOauthManagerCtc(context);
                }
            }
        }
        return manager;
    }

    public <T> void login(int i, CallBack<T> callBack) {
        new a(this.mContext, i, callBack).a(0);
    }
}
