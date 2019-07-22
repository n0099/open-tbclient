package com.facebook.common.c;
/* loaded from: classes2.dex */
public class a {
    private static c jZl = b.cEF();

    public static boolean isLoggable(int i) {
        return jZl.isLoggable(i);
    }

    public static void d(Class<?> cls, String str) {
        if (jZl.isLoggable(2)) {
            jZl.v(v(cls), str);
        }
    }

    public static void a(Class<?> cls, String str, Object obj) {
        if (jZl.isLoggable(2)) {
            jZl.v(v(cls), l(str, obj));
        }
    }

    public static void a(Class<?> cls, String str, Object obj, Object obj2) {
        if (jZl.isLoggable(2)) {
            jZl.v(v(cls), l(str, obj, obj2));
        }
    }

    public static void a(Class<?> cls, String str, Object obj, Object obj2, Object obj3) {
        if (isLoggable(2)) {
            d(cls, l(str, obj, obj2, obj3));
        }
    }

    public static void a(Class<?> cls, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        if (jZl.isLoggable(2)) {
            jZl.v(v(cls), l(str, obj, obj2, obj3, obj4));
        }
    }

    public static void v(String str, String str2, Object... objArr) {
        if (jZl.isLoggable(2)) {
            jZl.v(str, l(str2, objArr));
        }
    }

    public static void c(Class<?> cls, String str, Object... objArr) {
        if (jZl.isLoggable(2)) {
            jZl.v(v(cls), l(str, objArr));
        }
    }

    public static void b(Class<?> cls, String str, Object obj) {
        if (jZl.isLoggable(3)) {
            jZl.d(v(cls), l(str, obj));
        }
    }

    public static void e(Class<?> cls, String str) {
        if (jZl.isLoggable(4)) {
            jZl.i(v(cls), str);
        }
    }

    public static void f(Class<?> cls, String str) {
        if (jZl.isLoggable(5)) {
            jZl.w(v(cls), str);
        }
    }

    public static void w(String str, String str2, Object... objArr) {
        if (jZl.isLoggable(5)) {
            jZl.w(str, l(str2, objArr));
        }
    }

    public static void a(String str, Throwable th, String str2, Object... objArr) {
        if (jZl.isLoggable(5)) {
            jZl.c(str, l(str2, objArr), th);
        }
    }

    public static void d(Class<?> cls, String str, Object... objArr) {
        if (jZl.isLoggable(5)) {
            jZl.w(v(cls), l(str, objArr));
        }
    }

    public static void a(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (isLoggable(5)) {
            a(cls, l(str, objArr), th);
        }
    }

    public static void a(Class<?> cls, String str, Throwable th) {
        if (jZl.isLoggable(5)) {
            jZl.c(v(cls), str, th);
        }
    }

    public static void e(String str, String str2) {
        if (jZl.isLoggable(6)) {
            jZl.e(str, str2);
        }
    }

    public static void g(Class<?> cls, String str) {
        if (jZl.isLoggable(6)) {
            jZl.e(v(cls), str);
        }
    }

    public static void b(String str, Throwable th, String str2, Object... objArr) {
        if (jZl.isLoggable(6)) {
            jZl.e(str, l(str2, objArr), th);
        }
    }

    public static void e(Class<?> cls, String str, Object... objArr) {
        if (jZl.isLoggable(6)) {
            jZl.e(v(cls), l(str, objArr));
        }
    }

    public static void b(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (jZl.isLoggable(6)) {
            jZl.e(v(cls), l(str, objArr), th);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        if (jZl.isLoggable(6)) {
            jZl.e(str, str2, th);
        }
    }

    public static void b(Class<?> cls, String str, Throwable th) {
        if (jZl.isLoggable(6)) {
            jZl.e(v(cls), str, th);
        }
    }

    public static void f(String str, String str2, Object... objArr) {
        if (jZl.isLoggable(6)) {
            jZl.ez(str, l(str2, objArr));
        }
    }

    public static void f(Class<?> cls, String str, Object... objArr) {
        if (jZl.isLoggable(6)) {
            jZl.ez(v(cls), l(str, objArr));
        }
    }

    public static void c(Class<?> cls, String str, Throwable th) {
        if (jZl.isLoggable(6)) {
            jZl.f(v(cls), str, th);
        }
    }

    private static String l(String str, Object... objArr) {
        return String.format(null, str, objArr);
    }

    private static String v(Class<?> cls) {
        return cls.getSimpleName();
    }
}
