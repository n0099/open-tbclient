package com.yxcorp.kuaishou.addfp.android.b;

import com.baidu.android.imrtc.BuildConfig;
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f14389a = false;

    public static String a() {
        return BuildConfig.VERSION_NAME;
    }

    public static void a(String str) {
    }

    public static void a(Throwable th) {
        try {
            if (f14389a) {
                th.printStackTrace();
            }
        } catch (Exception e) {
        }
    }

    public static String b() {
        return "AD_AND";
    }

    public static void b(String str) {
    }
}
