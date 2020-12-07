package com.meizu.cloud.pushsdk.c.f;
/* loaded from: classes16.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static int f4179a = 0;

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
        f4179a = bVar.a();
    }

    public static void a(String str, String str2, Object... objArr) {
        if (f4179a >= 1) {
            com.meizu.cloud.a.a.e(a(str), a(str2, objArr));
        }
    }

    public static void b(String str, String str2, Object... objArr) {
        if (f4179a >= 2) {
            com.meizu.cloud.a.a.d(a(str), a(str2, objArr));
        }
    }

    public static void c(String str, String str2, Object... objArr) {
        if (f4179a >= 3) {
            com.meizu.cloud.a.a.i(a(str), a(str2, objArr));
        }
    }
}
