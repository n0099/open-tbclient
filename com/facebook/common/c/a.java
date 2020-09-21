package com.facebook.common.c;
/* loaded from: classes17.dex */
public class a {
    private static c nve = b.dSI();

    public static boolean isLoggable(int i) {
        return nve.isLoggable(i);
    }

    public static void e(Class<?> cls, String str) {
        if (nve.isLoggable(2)) {
            nve.v(A(cls), str);
        }
    }

    public static void a(Class<?> cls, String str, Object obj) {
        if (nve.isLoggable(2)) {
            nve.v(A(cls), j(str, obj));
        }
    }

    public static void a(Class<?> cls, String str, Object obj, Object obj2) {
        if (nve.isLoggable(2)) {
            nve.v(A(cls), j(str, obj, obj2));
        }
    }

    public static void a(Class<?> cls, String str, Object obj, Object obj2, Object obj3) {
        if (isLoggable(2)) {
            e(cls, j(str, obj, obj2, obj3));
        }
    }

    public static void a(Class<?> cls, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        if (nve.isLoggable(2)) {
            nve.v(A(cls), j(str, obj, obj2, obj3, obj4));
        }
    }

    public static void h(String str, String str2, Object... objArr) {
        if (nve.isLoggable(2)) {
            nve.v(str, j(str2, objArr));
        }
    }

    public static void b(Class<?> cls, String str, Object... objArr) {
        if (nve.isLoggable(2)) {
            nve.v(A(cls), j(str, objArr));
        }
    }

    public static void f(Class<?> cls, String str) {
        if (nve.isLoggable(3)) {
            nve.d(A(cls), str);
        }
    }

    public static void b(Class<?> cls, String str, Object obj) {
        if (nve.isLoggable(3)) {
            nve.d(A(cls), j(str, obj));
        }
    }

    public static void g(Class<?> cls, String str) {
        if (nve.isLoggable(5)) {
            nve.w(A(cls), str);
        }
    }

    public static void j(String str, String str2, Object... objArr) {
        if (nve.isLoggable(5)) {
            nve.w(str, j(str2, objArr));
        }
    }

    public static void c(Class<?> cls, String str, Object... objArr) {
        if (nve.isLoggable(5)) {
            nve.w(A(cls), j(str, objArr));
        }
    }

    public static void a(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (isLoggable(5)) {
            a(cls, j(str, objArr), th);
        }
    }

    public static void a(Class<?> cls, String str, Throwable th) {
        if (nve.isLoggable(5)) {
            nve.w(A(cls), str, th);
        }
    }

    public static void e(String str, String str2) {
        if (nve.isLoggable(6)) {
            nve.e(str, str2);
        }
    }

    public static void h(Class<?> cls, String str) {
        if (nve.isLoggable(6)) {
            nve.e(A(cls), str);
        }
    }

    public static void g(String str, String str2, Object... objArr) {
        if (nve.isLoggable(6)) {
            nve.e(str, j(str2, objArr));
        }
    }

    public static void d(Class<?> cls, String str, Object... objArr) {
        if (nve.isLoggable(6)) {
            nve.e(A(cls), j(str, objArr));
        }
    }

    public static void b(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (nve.isLoggable(6)) {
            nve.e(A(cls), j(str, objArr), th);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        if (nve.isLoggable(6)) {
            nve.e(str, str2, th);
        }
    }

    public static void b(Class<?> cls, String str, Throwable th) {
        if (nve.isLoggable(6)) {
            nve.e(A(cls), str, th);
        }
    }

    public static void wtf(String str, String str2) {
        if (nve.isLoggable(6)) {
            nve.wtf(str, str2);
        }
    }

    public static void k(String str, String str2, Object... objArr) {
        if (nve.isLoggable(6)) {
            nve.wtf(str, j(str2, objArr));
        }
    }

    public static void c(Class<?> cls, String str, Throwable th) {
        if (nve.isLoggable(6)) {
            nve.wtf(A(cls), str, th);
        }
    }

    private static String j(String str, Object... objArr) {
        return String.format(null, str, objArr);
    }

    private static String A(Class<?> cls) {
        return cls.getSimpleName();
    }
}
