package com.facebook.common.c;
/* loaded from: classes12.dex */
public class a {
    private static c mQP = b.dCA();

    public static boolean isLoggable(int i) {
        return mQP.isLoggable(i);
    }

    public static void e(Class<?> cls, String str) {
        if (mQP.isLoggable(2)) {
            mQP.v(A(cls), str);
        }
    }

    public static void a(Class<?> cls, String str, Object obj) {
        if (mQP.isLoggable(2)) {
            mQP.v(A(cls), l(str, obj));
        }
    }

    public static void a(Class<?> cls, String str, Object obj, Object obj2) {
        if (mQP.isLoggable(2)) {
            mQP.v(A(cls), l(str, obj, obj2));
        }
    }

    public static void a(Class<?> cls, String str, Object obj, Object obj2, Object obj3) {
        if (isLoggable(2)) {
            e(cls, l(str, obj, obj2, obj3));
        }
    }

    public static void a(Class<?> cls, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        if (mQP.isLoggable(2)) {
            mQP.v(A(cls), l(str, obj, obj2, obj3, obj4));
        }
    }

    public static void j(String str, String str2, Object... objArr) {
        if (mQP.isLoggable(2)) {
            mQP.v(str, l(str2, objArr));
        }
    }

    public static void b(Class<?> cls, String str, Object... objArr) {
        if (mQP.isLoggable(2)) {
            mQP.v(A(cls), l(str, objArr));
        }
    }

    public static void f(Class<?> cls, String str) {
        if (mQP.isLoggable(3)) {
            mQP.d(A(cls), str);
        }
    }

    public static void b(Class<?> cls, String str, Object obj) {
        if (mQP.isLoggable(3)) {
            mQP.d(A(cls), l(str, obj));
        }
    }

    public static void g(Class<?> cls, String str) {
        if (mQP.isLoggable(5)) {
            mQP.w(A(cls), str);
        }
    }

    public static void k(String str, String str2, Object... objArr) {
        if (mQP.isLoggable(5)) {
            mQP.w(str, l(str2, objArr));
        }
    }

    public static void c(Class<?> cls, String str, Object... objArr) {
        if (mQP.isLoggable(5)) {
            mQP.w(A(cls), l(str, objArr));
        }
    }

    public static void a(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (isLoggable(5)) {
            a(cls, l(str, objArr), th);
        }
    }

    public static void a(Class<?> cls, String str, Throwable th) {
        if (mQP.isLoggable(5)) {
            mQP.w(A(cls), str, th);
        }
    }

    public static void e(String str, String str2) {
        if (mQP.isLoggable(6)) {
            mQP.e(str, str2);
        }
    }

    public static void h(Class<?> cls, String str) {
        if (mQP.isLoggable(6)) {
            mQP.e(A(cls), str);
        }
    }

    public static void h(String str, String str2, Object... objArr) {
        if (mQP.isLoggable(6)) {
            mQP.e(str, l(str2, objArr));
        }
    }

    public static void d(Class<?> cls, String str, Object... objArr) {
        if (mQP.isLoggable(6)) {
            mQP.e(A(cls), l(str, objArr));
        }
    }

    public static void b(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (mQP.isLoggable(6)) {
            mQP.e(A(cls), l(str, objArr), th);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        if (mQP.isLoggable(6)) {
            mQP.e(str, str2, th);
        }
    }

    public static void b(Class<?> cls, String str, Throwable th) {
        if (mQP.isLoggable(6)) {
            mQP.e(A(cls), str, th);
        }
    }

    public static void wtf(String str, String str2) {
        if (mQP.isLoggable(6)) {
            mQP.wtf(str, str2);
        }
    }

    public static void l(String str, String str2, Object... objArr) {
        if (mQP.isLoggable(6)) {
            mQP.wtf(str, l(str2, objArr));
        }
    }

    public static void c(Class<?> cls, String str, Throwable th) {
        if (mQP.isLoggable(6)) {
            mQP.wtf(A(cls), str, th);
        }
    }

    private static String l(String str, Object... objArr) {
        return String.format(null, str, objArr);
    }

    private static String A(Class<?> cls) {
        return cls.getSimpleName();
    }
}
