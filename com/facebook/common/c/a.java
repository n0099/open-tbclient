package com.facebook.common.c;
/* loaded from: classes2.dex */
public class a {
    private static c kcO = b.cFO();

    public static boolean isLoggable(int i) {
        return kcO.isLoggable(i);
    }

    public static void d(Class<?> cls, String str) {
        if (kcO.isLoggable(2)) {
            kcO.v(v(cls), str);
        }
    }

    public static void a(Class<?> cls, String str, Object obj) {
        if (kcO.isLoggable(2)) {
            kcO.v(v(cls), l(str, obj));
        }
    }

    public static void a(Class<?> cls, String str, Object obj, Object obj2) {
        if (kcO.isLoggable(2)) {
            kcO.v(v(cls), l(str, obj, obj2));
        }
    }

    public static void a(Class<?> cls, String str, Object obj, Object obj2, Object obj3) {
        if (isLoggable(2)) {
            d(cls, l(str, obj, obj2, obj3));
        }
    }

    public static void a(Class<?> cls, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        if (kcO.isLoggable(2)) {
            kcO.v(v(cls), l(str, obj, obj2, obj3, obj4));
        }
    }

    public static void v(String str, String str2, Object... objArr) {
        if (kcO.isLoggable(2)) {
            kcO.v(str, l(str2, objArr));
        }
    }

    public static void c(Class<?> cls, String str, Object... objArr) {
        if (kcO.isLoggable(2)) {
            kcO.v(v(cls), l(str, objArr));
        }
    }

    public static void b(Class<?> cls, String str, Object obj) {
        if (kcO.isLoggable(3)) {
            kcO.d(v(cls), l(str, obj));
        }
    }

    public static void e(Class<?> cls, String str) {
        if (kcO.isLoggable(4)) {
            kcO.i(v(cls), str);
        }
    }

    public static void f(Class<?> cls, String str) {
        if (kcO.isLoggable(5)) {
            kcO.w(v(cls), str);
        }
    }

    public static void w(String str, String str2, Object... objArr) {
        if (kcO.isLoggable(5)) {
            kcO.w(str, l(str2, objArr));
        }
    }

    public static void a(String str, Throwable th, String str2, Object... objArr) {
        if (kcO.isLoggable(5)) {
            kcO.c(str, l(str2, objArr), th);
        }
    }

    public static void d(Class<?> cls, String str, Object... objArr) {
        if (kcO.isLoggable(5)) {
            kcO.w(v(cls), l(str, objArr));
        }
    }

    public static void a(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (isLoggable(5)) {
            a(cls, l(str, objArr), th);
        }
    }

    public static void a(Class<?> cls, String str, Throwable th) {
        if (kcO.isLoggable(5)) {
            kcO.c(v(cls), str, th);
        }
    }

    public static void e(String str, String str2) {
        if (kcO.isLoggable(6)) {
            kcO.e(str, str2);
        }
    }

    public static void g(Class<?> cls, String str) {
        if (kcO.isLoggable(6)) {
            kcO.e(v(cls), str);
        }
    }

    public static void b(String str, Throwable th, String str2, Object... objArr) {
        if (kcO.isLoggable(6)) {
            kcO.e(str, l(str2, objArr), th);
        }
    }

    public static void e(Class<?> cls, String str, Object... objArr) {
        if (kcO.isLoggable(6)) {
            kcO.e(v(cls), l(str, objArr));
        }
    }

    public static void b(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (kcO.isLoggable(6)) {
            kcO.e(v(cls), l(str, objArr), th);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        if (kcO.isLoggable(6)) {
            kcO.e(str, str2, th);
        }
    }

    public static void b(Class<?> cls, String str, Throwable th) {
        if (kcO.isLoggable(6)) {
            kcO.e(v(cls), str, th);
        }
    }

    public static void f(String str, String str2, Object... objArr) {
        if (kcO.isLoggable(6)) {
            kcO.eA(str, l(str2, objArr));
        }
    }

    public static void f(Class<?> cls, String str, Object... objArr) {
        if (kcO.isLoggable(6)) {
            kcO.eA(v(cls), l(str, objArr));
        }
    }

    public static void c(Class<?> cls, String str, Throwable th) {
        if (kcO.isLoggable(6)) {
            kcO.f(v(cls), str, th);
        }
    }

    private static String l(String str, Object... objArr) {
        return String.format(null, str, objArr);
    }

    private static String v(Class<?> cls) {
        return cls.getSimpleName();
    }
}
