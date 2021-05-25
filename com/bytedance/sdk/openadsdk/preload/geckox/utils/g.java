package com.bytedance.sdk.openadsdk.preload.geckox.utils;

import android.content.Context;
/* loaded from: classes6.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static Context f30131a;

    public static void a(Context context) {
        if (context != null) {
            f30131a = context;
        }
    }

    public static void a(String str) {
        System.loadLibrary(str);
    }
}
