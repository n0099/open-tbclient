package com.bytedance.sdk.openadsdk.preload.geckox.utils;

import android.content.Context;
/* loaded from: classes6.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static Context f5106a;

    public static void a(Context context) {
        if (context != null) {
            f5106a = context;
        }
    }

    public static void a(String str) {
        System.loadLibrary(str);
    }
}
