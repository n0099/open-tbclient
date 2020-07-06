package com.facebook.common.c;
/* loaded from: classes13.dex */
public class a {
    private static c mIN = b.dzo();

    public static boolean isLoggable(int i) {
        return mIN.isLoggable(i);
    }

    public static void e(Class<?> cls, String str) {
        if (mIN.isLoggable(2)) {
            mIN.v(A(cls), str);
        }
    }

    public static void a(Class<?> cls, String str, Object obj) {
        if (mIN.isLoggable(2)) {
            mIN.v(A(cls), l(str, obj));
        }
    }

    public static void a(Class<?> cls, String str, Object obj, Object obj2) {
        if (mIN.isLoggable(2)) {
            mIN.v(A(cls), l(str, obj, obj2));
        }
    }

    public static void a(Class<?> cls, String str, Object obj, Object obj2, Object obj3) {
        if (isLoggable(2)) {
            e(cls, l(str, obj, obj2, obj3));
        }
    }

    public static void a(Class<?> cls, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        if (mIN.isLoggable(2)) {
            mIN.v(A(cls), l(str, obj, obj2, obj3, obj4));
        }
    }

    public static void j(String str, String str2, Object... objArr) {
        if (mIN.isLoggable(2)) {
            mIN.v(str, l(str2, objArr));
        }
    }

    public static void b(Class<?> cls, String str, Object... objArr) {
        if (mIN.isLoggable(2)) {
            mIN.v(A(cls), l(str, objArr));
        }
    }

    public static void f(Class<?> cls, String str) {
        if (mIN.isLoggable(3)) {
            mIN.d(A(cls), str);
        }
    }

    public static void b(Class<?> cls, String str, Object obj) {
        if (mIN.isLoggable(3)) {
            mIN.d(A(cls), l(str, obj));
        }
    }

    public static void g(Class<?> cls, String str) {
        if (mIN.isLoggable(5)) {
            mIN.w(A(cls), str);
        }
    }

    public static void k(String str, String str2, Object... objArr) {
        if (mIN.isLoggable(5)) {
            mIN.w(str, l(str2, objArr));
        }
    }

    public static void c(Class<?> cls, String str, Object... objArr) {
        if (mIN.isLoggable(5)) {
            mIN.w(A(cls), l(str, objArr));
        }
    }

    public static void a(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (isLoggable(5)) {
            a(cls, l(str, objArr), th);
        }
    }

    public static void a(Class<?> cls, String str, Throwable th) {
        if (mIN.isLoggable(5)) {
            mIN.w(A(cls), str, th);
        }
    }

    public static void e(String str, String str2) {
        if (mIN.isLoggable(6)) {
            mIN.e(str, str2);
        }
    }

    public static void h(Class<?> cls, String str) {
        if (mIN.isLoggable(6)) {
            mIN.e(A(cls), str);
        }
    }

    public static void h(String str, String str2, Object... objArr) {
        if (mIN.isLoggable(6)) {
            mIN.e(str, l(str2, objArr));
        }
    }

    public static void d(Class<?> cls, String str, Object... objArr) {
        if (mIN.isLoggable(6)) {
            mIN.e(A(cls), l(str, objArr));
        }
    }

    public static void b(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (mIN.isLoggable(6)) {
            mIN.e(A(cls), l(str, objArr), th);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        if (mIN.isLoggable(6)) {
            mIN.e(str, str2, th);
        }
    }

    public static void b(Class<?> cls, String str, Throwable th) {
        if (mIN.isLoggable(6)) {
            mIN.e(A(cls), str, th);
        }
    }

    public static void wtf(String str, String str2) {
        if (mIN.isLoggable(6)) {
            mIN.wtf(str, str2);
        }
    }

    public static void l(String str, String str2, Object... objArr) {
        if (mIN.isLoggable(6)) {
            mIN.wtf(str, l(str2, objArr));
        }
    }

    public static void c(Class<?> cls, String str, Throwable th) {
        if (mIN.isLoggable(6)) {
            mIN.wtf(A(cls), str, th);
        }
    }

    private static String l(String str, Object... objArr) {
        return String.format(null, str, objArr);
    }

    private static String A(Class<?> cls) {
        return cls.getSimpleName();
    }
}
