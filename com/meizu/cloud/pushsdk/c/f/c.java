package com.meizu.cloud.pushsdk.c.f;

import com.meizu.cloud.pushinternal.DebugLogger;
/* loaded from: classes8.dex */
public class c {
    public static int a;

    public static String a() {
        return Thread.currentThread().getName();
    }

    public static String a(String str) {
        return "PushTracker->" + str;
    }

    public static String a(String str, Object... objArr) {
        return a() + "|" + String.format(str, objArr);
    }

    public static void a(b bVar) {
        a = bVar.a();
    }

    public static void a(String str, String str2, Object... objArr) {
        if (a >= 1) {
            DebugLogger.e(a(str), a(str2, objArr));
        }
    }

    public static void b(String str, String str2, Object... objArr) {
        if (a >= 2) {
            DebugLogger.d(a(str), a(str2, objArr));
        }
    }

    public static void c(String str, String str2, Object... objArr) {
        if (a >= 3) {
            DebugLogger.i(a(str), a(str2, objArr));
        }
    }
}
