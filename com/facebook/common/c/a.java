package com.facebook.common.c;
/* loaded from: classes2.dex */
public class a {
    private static c jSe = b.cBF();

    public static boolean isLoggable(int i) {
        return jSe.isLoggable(i);
    }

    public static void d(Class<?> cls, String str) {
        if (jSe.isLoggable(2)) {
            jSe.v(t(cls), str);
        }
    }

    public static void a(Class<?> cls, String str, Object obj) {
        if (jSe.isLoggable(2)) {
            jSe.v(t(cls), l(str, obj));
        }
    }

    public static void a(Class<?> cls, String str, Object obj, Object obj2) {
        if (jSe.isLoggable(2)) {
            jSe.v(t(cls), l(str, obj, obj2));
        }
    }

    public static void a(Class<?> cls, String str, Object obj, Object obj2, Object obj3) {
        if (isLoggable(2)) {
            d(cls, l(str, obj, obj2, obj3));
        }
    }

    public static void a(Class<?> cls, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        if (jSe.isLoggable(2)) {
            jSe.v(t(cls), l(str, obj, obj2, obj3, obj4));
        }
    }

    public static void v(String str, String str2, Object... objArr) {
        if (jSe.isLoggable(2)) {
            jSe.v(str, l(str2, objArr));
        }
    }

    public static void c(Class<?> cls, String str, Object... objArr) {
        if (jSe.isLoggable(2)) {
            jSe.v(t(cls), l(str, objArr));
        }
    }

    public static void b(Class<?> cls, String str, Object obj) {
        if (jSe.isLoggable(3)) {
            jSe.d(t(cls), l(str, obj));
        }
    }

    public static void e(Class<?> cls, String str) {
        if (jSe.isLoggable(4)) {
            jSe.i(t(cls), str);
        }
    }

    public static void f(Class<?> cls, String str) {
        if (jSe.isLoggable(5)) {
            jSe.w(t(cls), str);
        }
    }

    public static void w(String str, String str2, Object... objArr) {
        if (jSe.isLoggable(5)) {
            jSe.w(str, l(str2, objArr));
        }
    }

    public static void a(String str, Throwable th, String str2, Object... objArr) {
        if (jSe.isLoggable(5)) {
            jSe.w(str, l(str2, objArr), th);
        }
    }

    public static void d(Class<?> cls, String str, Object... objArr) {
        if (jSe.isLoggable(5)) {
            jSe.w(t(cls), l(str, objArr));
        }
    }

    public static void a(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (isLoggable(5)) {
            a(cls, l(str, objArr), th);
        }
    }

    public static void a(Class<?> cls, String str, Throwable th) {
        if (jSe.isLoggable(5)) {
            jSe.w(t(cls), str, th);
        }
    }

    public static void e(String str, String str2) {
        if (jSe.isLoggable(6)) {
            jSe.e(str, str2);
        }
    }

    public static void g(Class<?> cls, String str) {
        if (jSe.isLoggable(6)) {
            jSe.e(t(cls), str);
        }
    }

    public static void b(String str, Throwable th, String str2, Object... objArr) {
        if (jSe.isLoggable(6)) {
            jSe.e(str, l(str2, objArr), th);
        }
    }

    public static void e(Class<?> cls, String str, Object... objArr) {
        if (jSe.isLoggable(6)) {
            jSe.e(t(cls), l(str, objArr));
        }
    }

    public static void b(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (jSe.isLoggable(6)) {
            jSe.e(t(cls), l(str, objArr), th);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        if (jSe.isLoggable(6)) {
            jSe.e(str, str2, th);
        }
    }

    public static void b(Class<?> cls, String str, Throwable th) {
        if (jSe.isLoggable(6)) {
            jSe.e(t(cls), str, th);
        }
    }

    public static void f(String str, String str2, Object... objArr) {
        if (jSe.isLoggable(6)) {
            jSe.ey(str, l(str2, objArr));
        }
    }

    public static void f(Class<?> cls, String str, Object... objArr) {
        if (jSe.isLoggable(6)) {
            jSe.ey(t(cls), l(str, objArr));
        }
    }

    public static void c(Class<?> cls, String str, Throwable th) {
        if (jSe.isLoggable(6)) {
            jSe.c(t(cls), str, th);
        }
    }

    private static String l(String str, Object... objArr) {
        return String.format(null, str, objArr);
    }

    private static String t(Class<?> cls) {
        return cls.getSimpleName();
    }
}
