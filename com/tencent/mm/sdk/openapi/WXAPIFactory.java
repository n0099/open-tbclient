package com.tencent.mm.sdk.openapi;

import android.content.Context;
/* loaded from: classes.dex */
public class WXAPIFactory {
    private static WXAPIFactory Q = null;

    private WXAPIFactory() {
    }

    public static IWXAPI createWXAPI(Context context, String str) {
        if (Q == null) {
            Q = new WXAPIFactory();
        }
        return new WXApiImplV10(context, str);
    }

    public static IWXAPI createWXAPI(Context context, String str, boolean z) {
        if (Q == null) {
            Q = new WXAPIFactory();
        }
        return new WXApiImplV10(context, str, z);
    }
}
