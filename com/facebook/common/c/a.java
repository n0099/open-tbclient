package com.facebook.common.c;
/* loaded from: classes2.dex */
public class a {
    private static c jzn = b.ctG();

    public static boolean isLoggable(int i) {
        return jzn.isLoggable(i);
    }

    public static void d(Class<?> cls, String str) {
        if (jzn.isLoggable(2)) {
            jzn.v(u(cls), str);
        }
    }

    public static void a(Class<?> cls, String str, Object obj) {
        if (jzn.isLoggable(2)) {
            jzn.v(u(cls), l(str, obj));
        }
    }

    public static void a(Class<?> cls, String str, Object obj, Object obj2) {
        if (jzn.isLoggable(2)) {
            jzn.v(u(cls), l(str, obj, obj2));
        }
    }

    public static void a(Class<?> cls, String str, Object obj, Object obj2, Object obj3) {
        if (isLoggable(2)) {
            d(cls, l(str, obj, obj2, obj3));
        }
    }

    public static void a(Class<?> cls, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        if (jzn.isLoggable(2)) {
            jzn.v(u(cls), l(str, obj, obj2, obj3, obj4));
        }
    }

    public static void v(String str, String str2, Object... objArr) {
        if (jzn.isLoggable(2)) {
            jzn.v(str, l(str2, objArr));
        }
    }

    public static void c(Class<?> cls, String str, Object... objArr) {
        if (jzn.isLoggable(2)) {
            jzn.v(u(cls), l(str, objArr));
        }
    }

    public static void b(Class<?> cls, String str, Object obj) {
        if (jzn.isLoggable(3)) {
            jzn.d(u(cls), l(str, obj));
        }
    }

    public static void e(Class<?> cls, String str) {
        if (jzn.isLoggable(4)) {
            jzn.i(u(cls), str);
        }
    }

    public static void f(Class<?> cls, String str) {
        if (jzn.isLoggable(5)) {
            jzn.w(u(cls), str);
        }
    }

    public static void w(String str, String str2, Object... objArr) {
        if (jzn.isLoggable(5)) {
            jzn.w(str, l(str2, objArr));
        }
    }

    public static void a(String str, Throwable th, String str2, Object... objArr) {
        if (jzn.isLoggable(5)) {
            jzn.w(str, l(str2, objArr), th);
        }
    }

    public static void d(Class<?> cls, String str, Object... objArr) {
        if (jzn.isLoggable(5)) {
            jzn.w(u(cls), l(str, objArr));
        }
    }

    public static void a(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (isLoggable(5)) {
            a(cls, l(str, objArr), th);
        }
    }

    public static void a(Class<?> cls, String str, Throwable th) {
        if (jzn.isLoggable(5)) {
            jzn.w(u(cls), str, th);
        }
    }

    public static void e(String str, String str2) {
        if (jzn.isLoggable(6)) {
            jzn.e(str, str2);
        }
    }

    public static void g(Class<?> cls, String str) {
        if (jzn.isLoggable(6)) {
            jzn.e(u(cls), str);
        }
    }

    public static void b(String str, Throwable th, String str2, Object... objArr) {
        if (jzn.isLoggable(6)) {
            jzn.e(str, l(str2, objArr), th);
        }
    }

    public static void e(Class<?> cls, String str, Object... objArr) {
        if (jzn.isLoggable(6)) {
            jzn.e(u(cls), l(str, objArr));
        }
    }

    public static void b(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (jzn.isLoggable(6)) {
            jzn.e(u(cls), l(str, objArr), th);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        if (jzn.isLoggable(6)) {
            jzn.e(str, str2, th);
        }
    }

    public static void b(Class<?> cls, String str, Throwable th) {
        if (jzn.isLoggable(6)) {
            jzn.e(u(cls), str, th);
        }
    }

    public static void f(String str, String str2, Object... objArr) {
        if (jzn.isLoggable(6)) {
            jzn.el(str, l(str2, objArr));
        }
    }

    public static void f(Class<?> cls, String str, Object... objArr) {
        if (jzn.isLoggable(6)) {
            jzn.el(u(cls), l(str, objArr));
        }
    }

    public static void c(Class<?> cls, String str, Throwable th) {
        if (jzn.isLoggable(6)) {
            jzn.f(u(cls), str, th);
        }
    }

    private static String l(String str, Object... objArr) {
        return String.format(null, str, objArr);
    }

    private static String u(Class<?> cls) {
        return cls.getSimpleName();
    }
}
