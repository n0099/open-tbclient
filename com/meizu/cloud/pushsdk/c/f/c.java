package com.meizu.cloud.pushsdk.c.f;
/* loaded from: classes5.dex */
public class c {
    private static int a = 0;

    private static String a() {
        return Thread.currentThread().getName();
    }

    private static String a(String str) {
        return "PushTracker->" + str;
    }

    private static String a(String str, Object... objArr) {
        return a() + "|" + String.format(str, objArr);
    }

    public static void a(b bVar) {
        a = bVar.a();
    }

    public static void a(String str, String str2, Object... objArr) {
        if (a >= 1) {
            com.meizu.cloud.a.a.e(a(str), a(str2, objArr));
        }
    }

    public static void b(String str, String str2, Object... objArr) {
        if (a >= 2) {
            com.meizu.cloud.a.a.d(a(str), a(str2, objArr));
        }
    }

    public static void c(String str, String str2, Object... objArr) {
        if (a >= 3) {
            com.meizu.cloud.a.a.i(a(str), a(str2, objArr));
        }
    }
}
