package com.facebook.common.c;
/* loaded from: classes4.dex */
public class a {
    private static c pBy = b.esT();

    public static boolean isLoggable(int i) {
        return pBy.isLoggable(i);
    }

    public static void f(Class<?> cls, String str) {
        if (pBy.isLoggable(2)) {
            pBy.v(t(cls), str);
        }
    }

    public static void a(Class<?> cls, String str, Object obj) {
        if (pBy.isLoggable(2)) {
            pBy.v(t(cls), l(str, obj));
        }
    }

    public static void a(Class<?> cls, String str, Object obj, Object obj2) {
        if (pBy.isLoggable(2)) {
            pBy.v(t(cls), l(str, obj, obj2));
        }
    }

    public static void a(Class<?> cls, String str, Object obj, Object obj2, Object obj3) {
        if (isLoggable(2)) {
            f(cls, l(str, obj, obj2, obj3));
        }
    }

    public static void a(Class<?> cls, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        if (pBy.isLoggable(2)) {
            pBy.v(t(cls), l(str, obj, obj2, obj3, obj4));
        }
    }

    public static void f(String str, String str2, Object... objArr) {
        if (pBy.isLoggable(2)) {
            pBy.v(str, l(str2, objArr));
        }
    }

    public static void b(Class<?> cls, String str, Object... objArr) {
        if (pBy.isLoggable(2)) {
            pBy.v(t(cls), l(str, objArr));
        }
    }

    public static void g(Class<?> cls, String str) {
        if (pBy.isLoggable(3)) {
            pBy.d(t(cls), str);
        }
    }

    public static void b(Class<?> cls, String str, Object obj) {
        if (pBy.isLoggable(3)) {
            pBy.d(t(cls), l(str, obj));
        }
    }

    public static void h(Class<?> cls, String str) {
        if (pBy.isLoggable(5)) {
            pBy.w(t(cls), str);
        }
    }

    public static void g(String str, String str2, Object... objArr) {
        if (pBy.isLoggable(5)) {
            pBy.w(str, l(str2, objArr));
        }
    }

    public static void c(Class<?> cls, String str, Object... objArr) {
        if (pBy.isLoggable(5)) {
            pBy.w(t(cls), l(str, objArr));
        }
    }

    public static void a(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (isLoggable(5)) {
            a(cls, l(str, objArr), th);
        }
    }

    public static void a(Class<?> cls, String str, Throwable th) {
        if (pBy.isLoggable(5)) {
            pBy.w(t(cls), str, th);
        }
    }

    public static void e(String str, String str2) {
        if (pBy.isLoggable(6)) {
            pBy.e(str, str2);
        }
    }

    public static void i(Class<?> cls, String str) {
        if (pBy.isLoggable(6)) {
            pBy.e(t(cls), str);
        }
    }

    public static void e(String str, String str2, Object... objArr) {
        if (pBy.isLoggable(6)) {
            pBy.e(str, l(str2, objArr));
        }
    }

    public static void d(Class<?> cls, String str, Object... objArr) {
        if (pBy.isLoggable(6)) {
            pBy.e(t(cls), l(str, objArr));
        }
    }

    public static void b(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (pBy.isLoggable(6)) {
            pBy.e(t(cls), l(str, objArr), th);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        if (pBy.isLoggable(6)) {
            pBy.e(str, str2, th);
        }
    }

    public static void b(Class<?> cls, String str, Throwable th) {
        if (pBy.isLoggable(6)) {
            pBy.e(t(cls), str, th);
        }
    }

    public static void wtf(String str, String str2) {
        if (pBy.isLoggable(6)) {
            pBy.wtf(str, str2);
        }
    }

    public static void h(String str, String str2, Object... objArr) {
        if (pBy.isLoggable(6)) {
            pBy.wtf(str, l(str2, objArr));
        }
    }

    public static void c(Class<?> cls, String str, Throwable th) {
        if (pBy.isLoggable(6)) {
            pBy.wtf(t(cls), str, th);
        }
    }

    private static String l(String str, Object... objArr) {
        return String.format(null, str, objArr);
    }

    private static String t(Class<?> cls) {
        return cls.getSimpleName();
    }
}
