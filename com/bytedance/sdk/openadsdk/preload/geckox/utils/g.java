package com.bytedance.sdk.openadsdk.preload.geckox.utils;

import android.content.Context;
/* loaded from: classes6.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static Context f30316a;

    public static void a(Context context) {
        if (context != null) {
            f30316a = context;
        }
    }

    public static void a(String str) {
        System.loadLibrary(str);
    }
}
