package com.bytedance.sdk.openadsdk.preload.geckox.utils;

import android.content.Context;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static Context f7825a;

    public static void a(Context context) {
        if (context != null) {
            f7825a = context;
        }
    }

    public static void a(String str) {
        System.loadLibrary(str);
    }
}
