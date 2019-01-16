package com.facebook.common.c;
/* loaded from: classes2.dex */
public class a {
    private static c ike = b.bUC();

    public static boolean isLoggable(int i) {
        return ike.isLoggable(i);
    }

    public static void d(Class<?> cls, String str) {
        if (ike.isLoggable(2)) {
            ike.v(r(cls), str);
        }
    }

    public static void a(Class<?> cls, String str, Object obj) {
        if (ike.isLoggable(2)) {
            ike.v(r(cls), m(str, obj));
        }
    }

    public static void a(Class<?> cls, String str, Object obj, Object obj2) {
        if (ike.isLoggable(2)) {
            ike.v(r(cls), m(str, obj, obj2));
        }
    }

    public static void a(Class<?> cls, String str, Object obj, Object obj2, Object obj3) {
        if (isLoggable(2)) {
            d(cls, m(str, obj, obj2, obj3));
        }
    }

    public static void a(Class<?> cls, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        if (ike.isLoggable(2)) {
            ike.v(r(cls), m(str, obj, obj2, obj3, obj4));
        }
    }

    public static void v(String str, String str2, Object... objArr) {
        if (ike.isLoggable(2)) {
            ike.v(str, m(str2, objArr));
        }
    }

    public static void c(Class<?> cls, String str, Object... objArr) {
        if (ike.isLoggable(2)) {
            ike.v(r(cls), m(str, objArr));
        }
    }

    public static void b(Class<?> cls, String str, Object obj) {
        if (ike.isLoggable(3)) {
            ike.d(r(cls), m(str, obj));
        }
    }

    public static void e(Class<?> cls, String str) {
        if (ike.isLoggable(4)) {
            ike.i(r(cls), str);
        }
    }

    public static void f(Class<?> cls, String str) {
        if (ike.isLoggable(5)) {
            ike.w(r(cls), str);
        }
    }

    public static void w(String str, String str2, Object... objArr) {
        if (ike.isLoggable(5)) {
            ike.w(str, m(str2, objArr));
        }
    }

    public static void a(String str, Throwable th, String str2, Object... objArr) {
        if (ike.isLoggable(5)) {
            ike.w(str, m(str2, objArr), th);
        }
    }

    public static void d(Class<?> cls, String str, Object... objArr) {
        if (ike.isLoggable(5)) {
            ike.w(r(cls), m(str, objArr));
        }
    }

    public static void a(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (isLoggable(5)) {
            a(cls, m(str, objArr), th);
        }
    }

    public static void a(Class<?> cls, String str, Throwable th) {
        if (ike.isLoggable(5)) {
            ike.w(r(cls), str, th);
        }
    }

    public static void e(String str, String str2) {
        if (ike.isLoggable(6)) {
            ike.e(str, str2);
        }
    }

    public static void g(Class<?> cls, String str) {
        if (ike.isLoggable(6)) {
            ike.e(r(cls), str);
        }
    }

    public static void b(String str, Throwable th, String str2, Object... objArr) {
        if (ike.isLoggable(6)) {
            ike.e(str, m(str2, objArr), th);
        }
    }

    public static void e(Class<?> cls, String str, Object... objArr) {
        if (ike.isLoggable(6)) {
            ike.e(r(cls), m(str, objArr));
        }
    }

    public static void b(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (ike.isLoggable(6)) {
            ike.e(r(cls), m(str, objArr), th);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        if (ike.isLoggable(6)) {
            ike.e(str, str2, th);
        }
    }

    public static void b(Class<?> cls, String str, Throwable th) {
        if (ike.isLoggable(6)) {
            ike.e(r(cls), str, th);
        }
    }

    public static void f(String str, String str2, Object... objArr) {
        if (ike.isLoggable(6)) {
            ike.dc(str, m(str2, objArr));
        }
    }

    public static void f(Class<?> cls, String str, Object... objArr) {
        if (ike.isLoggable(6)) {
            ike.dc(r(cls), m(str, objArr));
        }
    }

    public static void c(Class<?> cls, String str, Throwable th) {
        if (ike.isLoggable(6)) {
            ike.f(r(cls), str, th);
        }
    }

    private static String m(String str, Object... objArr) {
        return String.format(null, str, objArr);
    }

    private static String r(Class<?> cls) {
        return cls.getSimpleName();
    }
}
