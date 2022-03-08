package com.meizu.cloud.pushsdk.c.f;
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
            c.k.a.a.a.b(a(str), a(str2, objArr));
        }
    }

    public static void b(String str, String str2, Object... objArr) {
        if (a >= 2) {
            c.k.a.a.a.a(a(str), a(str2, objArr));
        }
    }

    public static void c(String str, String str2, Object... objArr) {
        if (a >= 3) {
            c.k.a.a.a.d(a(str), a(str2, objArr));
        }
    }
}
