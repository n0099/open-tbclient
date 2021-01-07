package com.bytedance.sdk.openadsdk.utils;

import android.util.Log;
/* loaded from: classes4.dex */
public class u {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f7901a = false;

    /* renamed from: b  reason: collision with root package name */
    private static int f7902b = 4;

    public static void a(int i) {
        f7902b = i;
    }

    public static boolean a() {
        return f7902b <= 3;
    }

    public static void b() {
        f7901a = true;
        a(3);
    }

    public static boolean c() {
        return f7901a;
    }

    public static void a(String str, String str2) {
        if (c() && str2 != null && f7902b <= 2) {
            Log.v(str, str2);
        }
    }

    public static void a(String str) {
        if (c()) {
            b("Logger", str);
        }
    }

    public static void b(String str, String str2) {
        if (c() && str2 != null && f7902b <= 3) {
            Log.d(str, str2);
        }
    }

    public static void a(String str, String str2, Throwable th) {
        if (c()) {
            if ((str2 != null || th != null) && f7902b <= 3) {
                Log.d(str, str2, th);
            }
        }
    }

    public static void c(String str, String str2) {
        if (c() && str2 != null && f7902b <= 4) {
            Log.i(str, str2);
        }
    }

    public static void d(String str, String str2) {
        if (c() && str2 != null && f7902b <= 5) {
            Log.w(str, str2);
        }
    }

    public static void b(String str, String str2, Throwable th) {
        if (c()) {
            if ((str2 != null || th != null) && f7902b <= 5) {
                Log.w(str, str2, th);
            }
        }
    }

    public static void e(String str, String str2) {
        if (str2 != null) {
            if (str == null) {
                str = "Logger";
            }
            Log.i(str, str2);
        }
    }

    public static void b(String str) {
        if (c()) {
            f("Logger", str);
        }
    }

    public static void f(String str, String str2) {
        if (c() && str2 != null && f7902b <= 6) {
            Log.e(str, str2);
        }
    }

    public static void c(String str, String str2, Throwable th) {
        if (c()) {
            if ((str2 != null || th != null) && f7902b <= 6) {
                Log.e(str, str2, th);
            }
        }
    }
}
