package com.facebook.common.c;
/* loaded from: classes2.dex */
public class a {
    private static c jzS = b.ctN();

    public static boolean isLoggable(int i) {
        return jzS.isLoggable(i);
    }

    public static void d(Class<?> cls, String str) {
        if (jzS.isLoggable(2)) {
            jzS.v(u(cls), str);
        }
    }

    public static void a(Class<?> cls, String str, Object obj) {
        if (jzS.isLoggable(2)) {
            jzS.v(u(cls), l(str, obj));
        }
    }

    public static void a(Class<?> cls, String str, Object obj, Object obj2) {
        if (jzS.isLoggable(2)) {
            jzS.v(u(cls), l(str, obj, obj2));
        }
    }

    public static void a(Class<?> cls, String str, Object obj, Object obj2, Object obj3) {
        if (isLoggable(2)) {
            d(cls, l(str, obj, obj2, obj3));
        }
    }

    public static void a(Class<?> cls, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        if (jzS.isLoggable(2)) {
            jzS.v(u(cls), l(str, obj, obj2, obj3, obj4));
        }
    }

    public static void v(String str, String str2, Object... objArr) {
        if (jzS.isLoggable(2)) {
            jzS.v(str, l(str2, objArr));
        }
    }

    public static void c(Class<?> cls, String str, Object... objArr) {
        if (jzS.isLoggable(2)) {
            jzS.v(u(cls), l(str, objArr));
        }
    }

    public static void b(Class<?> cls, String str, Object obj) {
        if (jzS.isLoggable(3)) {
            jzS.d(u(cls), l(str, obj));
        }
    }

    public static void e(Class<?> cls, String str) {
        if (jzS.isLoggable(4)) {
            jzS.i(u(cls), str);
        }
    }

    public static void f(Class<?> cls, String str) {
        if (jzS.isLoggable(5)) {
            jzS.w(u(cls), str);
        }
    }

    public static void w(String str, String str2, Object... objArr) {
        if (jzS.isLoggable(5)) {
            jzS.w(str, l(str2, objArr));
        }
    }

    public static void a(String str, Throwable th, String str2, Object... objArr) {
        if (jzS.isLoggable(5)) {
            jzS.w(str, l(str2, objArr), th);
        }
    }

    public static void d(Class<?> cls, String str, Object... objArr) {
        if (jzS.isLoggable(5)) {
            jzS.w(u(cls), l(str, objArr));
        }
    }

    public static void a(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (isLoggable(5)) {
            a(cls, l(str, objArr), th);
        }
    }

    public static void a(Class<?> cls, String str, Throwable th) {
        if (jzS.isLoggable(5)) {
            jzS.w(u(cls), str, th);
        }
    }

    public static void e(String str, String str2) {
        if (jzS.isLoggable(6)) {
            jzS.e(str, str2);
        }
    }

    public static void g(Class<?> cls, String str) {
        if (jzS.isLoggable(6)) {
            jzS.e(u(cls), str);
        }
    }

    public static void b(String str, Throwable th, String str2, Object... objArr) {
        if (jzS.isLoggable(6)) {
            jzS.e(str, l(str2, objArr), th);
        }
    }

    public static void e(Class<?> cls, String str, Object... objArr) {
        if (jzS.isLoggable(6)) {
            jzS.e(u(cls), l(str, objArr));
        }
    }

    public static void b(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (jzS.isLoggable(6)) {
            jzS.e(u(cls), l(str, objArr), th);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        if (jzS.isLoggable(6)) {
            jzS.e(str, str2, th);
        }
    }

    public static void b(Class<?> cls, String str, Throwable th) {
        if (jzS.isLoggable(6)) {
            jzS.e(u(cls), str, th);
        }
    }

    public static void f(String str, String str2, Object... objArr) {
        if (jzS.isLoggable(6)) {
            jzS.ek(str, l(str2, objArr));
        }
    }

    public static void f(Class<?> cls, String str, Object... objArr) {
        if (jzS.isLoggable(6)) {
            jzS.ek(u(cls), l(str, objArr));
        }
    }

    public static void c(Class<?> cls, String str, Throwable th) {
        if (jzS.isLoggable(6)) {
            jzS.f(u(cls), str, th);
        }
    }

    private static String l(String str, Object... objArr) {
        return String.format(null, str, objArr);
    }

    private static String u(Class<?> cls) {
        return cls.getSimpleName();
    }
}
