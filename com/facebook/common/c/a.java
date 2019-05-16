package com.facebook.common.c;
/* loaded from: classes2.dex */
public class a {
    private static c jSd = b.cBD();

    public static boolean isLoggable(int i) {
        return jSd.isLoggable(i);
    }

    public static void d(Class<?> cls, String str) {
        if (jSd.isLoggable(2)) {
            jSd.v(t(cls), str);
        }
    }

    public static void a(Class<?> cls, String str, Object obj) {
        if (jSd.isLoggable(2)) {
            jSd.v(t(cls), l(str, obj));
        }
    }

    public static void a(Class<?> cls, String str, Object obj, Object obj2) {
        if (jSd.isLoggable(2)) {
            jSd.v(t(cls), l(str, obj, obj2));
        }
    }

    public static void a(Class<?> cls, String str, Object obj, Object obj2, Object obj3) {
        if (isLoggable(2)) {
            d(cls, l(str, obj, obj2, obj3));
        }
    }

    public static void a(Class<?> cls, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        if (jSd.isLoggable(2)) {
            jSd.v(t(cls), l(str, obj, obj2, obj3, obj4));
        }
    }

    public static void v(String str, String str2, Object... objArr) {
        if (jSd.isLoggable(2)) {
            jSd.v(str, l(str2, objArr));
        }
    }

    public static void c(Class<?> cls, String str, Object... objArr) {
        if (jSd.isLoggable(2)) {
            jSd.v(t(cls), l(str, objArr));
        }
    }

    public static void b(Class<?> cls, String str, Object obj) {
        if (jSd.isLoggable(3)) {
            jSd.d(t(cls), l(str, obj));
        }
    }

    public static void e(Class<?> cls, String str) {
        if (jSd.isLoggable(4)) {
            jSd.i(t(cls), str);
        }
    }

    public static void f(Class<?> cls, String str) {
        if (jSd.isLoggable(5)) {
            jSd.w(t(cls), str);
        }
    }

    public static void w(String str, String str2, Object... objArr) {
        if (jSd.isLoggable(5)) {
            jSd.w(str, l(str2, objArr));
        }
    }

    public static void a(String str, Throwable th, String str2, Object... objArr) {
        if (jSd.isLoggable(5)) {
            jSd.w(str, l(str2, objArr), th);
        }
    }

    public static void d(Class<?> cls, String str, Object... objArr) {
        if (jSd.isLoggable(5)) {
            jSd.w(t(cls), l(str, objArr));
        }
    }

    public static void a(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (isLoggable(5)) {
            a(cls, l(str, objArr), th);
        }
    }

    public static void a(Class<?> cls, String str, Throwable th) {
        if (jSd.isLoggable(5)) {
            jSd.w(t(cls), str, th);
        }
    }

    public static void e(String str, String str2) {
        if (jSd.isLoggable(6)) {
            jSd.e(str, str2);
        }
    }

    public static void g(Class<?> cls, String str) {
        if (jSd.isLoggable(6)) {
            jSd.e(t(cls), str);
        }
    }

    public static void b(String str, Throwable th, String str2, Object... objArr) {
        if (jSd.isLoggable(6)) {
            jSd.e(str, l(str2, objArr), th);
        }
    }

    public static void e(Class<?> cls, String str, Object... objArr) {
        if (jSd.isLoggable(6)) {
            jSd.e(t(cls), l(str, objArr));
        }
    }

    public static void b(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (jSd.isLoggable(6)) {
            jSd.e(t(cls), l(str, objArr), th);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        if (jSd.isLoggable(6)) {
            jSd.e(str, str2, th);
        }
    }

    public static void b(Class<?> cls, String str, Throwable th) {
        if (jSd.isLoggable(6)) {
            jSd.e(t(cls), str, th);
        }
    }

    public static void f(String str, String str2, Object... objArr) {
        if (jSd.isLoggable(6)) {
            jSd.ey(str, l(str2, objArr));
        }
    }

    public static void f(Class<?> cls, String str, Object... objArr) {
        if (jSd.isLoggable(6)) {
            jSd.ey(t(cls), l(str, objArr));
        }
    }

    public static void c(Class<?> cls, String str, Throwable th) {
        if (jSd.isLoggable(6)) {
            jSd.c(t(cls), str, th);
        }
    }

    private static String l(String str, Object... objArr) {
        return String.format(null, str, objArr);
    }

    private static String t(Class<?> cls) {
        return cls.getSimpleName();
    }
}
