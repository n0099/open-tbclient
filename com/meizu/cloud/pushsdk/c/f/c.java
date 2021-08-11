package com.meizu.cloud.pushsdk.c.f;
/* loaded from: classes10.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static int f74502a;

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
        f74502a = bVar.a();
    }

    public static void a(String str, String str2, Object... objArr) {
        if (f74502a >= 1) {
            c.l.a.a.a.b(a(str), a(str2, objArr));
        }
    }

    public static void b(String str, String str2, Object... objArr) {
        if (f74502a >= 2) {
            c.l.a.a.a.a(a(str), a(str2, objArr));
        }
    }

    public static void c(String str, String str2, Object... objArr) {
        if (f74502a >= 3) {
            c.l.a.a.a.d(a(str), a(str2, objArr));
        }
    }
}
