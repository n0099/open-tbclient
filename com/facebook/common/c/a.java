package com.facebook.common.c;
/* loaded from: classes13.dex */
public class a {
    private static c lIt = b.dkL();

    public static boolean isLoggable(int i) {
        return lIt.isLoggable(i);
    }

    public static void e(Class<?> cls, String str) {
        if (lIt.isLoggable(2)) {
            lIt.v(C(cls), str);
        }
    }

    public static void a(Class<?> cls, String str, Object obj) {
        if (lIt.isLoggable(2)) {
            lIt.v(C(cls), o(str, obj));
        }
    }

    public static void a(Class<?> cls, String str, Object obj, Object obj2) {
        if (lIt.isLoggable(2)) {
            lIt.v(C(cls), o(str, obj, obj2));
        }
    }

    public static void a(Class<?> cls, String str, Object obj, Object obj2, Object obj3) {
        if (isLoggable(2)) {
            e(cls, o(str, obj, obj2, obj3));
        }
    }

    public static void a(Class<?> cls, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        if (lIt.isLoggable(2)) {
            lIt.v(C(cls), o(str, obj, obj2, obj3, obj4));
        }
    }

    public static void f(String str, String str2, Object... objArr) {
        if (lIt.isLoggable(2)) {
            lIt.v(str, o(str2, objArr));
        }
    }

    public static void b(Class<?> cls, String str, Object... objArr) {
        if (lIt.isLoggable(2)) {
            lIt.v(C(cls), o(str, objArr));
        }
    }

    public static void f(Class<?> cls, String str) {
        if (lIt.isLoggable(3)) {
            lIt.d(C(cls), str);
        }
    }

    public static void b(Class<?> cls, String str, Object obj) {
        if (lIt.isLoggable(3)) {
            lIt.d(C(cls), o(str, obj));
        }
    }

    public static void g(Class<?> cls, String str) {
        if (lIt.isLoggable(5)) {
            lIt.w(C(cls), str);
        }
    }

    public static void g(String str, String str2, Object... objArr) {
        if (lIt.isLoggable(5)) {
            lIt.w(str, o(str2, objArr));
        }
    }

    public static void c(Class<?> cls, String str, Object... objArr) {
        if (lIt.isLoggable(5)) {
            lIt.w(C(cls), o(str, objArr));
        }
    }

    public static void a(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (isLoggable(5)) {
            a(cls, o(str, objArr), th);
        }
    }

    public static void a(Class<?> cls, String str, Throwable th) {
        if (lIt.isLoggable(5)) {
            lIt.w(C(cls), str, th);
        }
    }

    public static void e(String str, String str2) {
        if (lIt.isLoggable(6)) {
            lIt.e(str, str2);
        }
    }

    public static void h(Class<?> cls, String str) {
        if (lIt.isLoggable(6)) {
            lIt.e(C(cls), str);
        }
    }

    public static void h(String str, String str2, Object... objArr) {
        if (lIt.isLoggable(6)) {
            lIt.e(str, o(str2, objArr));
        }
    }

    public static void d(Class<?> cls, String str, Object... objArr) {
        if (lIt.isLoggable(6)) {
            lIt.e(C(cls), o(str, objArr));
        }
    }

    public static void b(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (lIt.isLoggable(6)) {
            lIt.e(C(cls), o(str, objArr), th);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        if (lIt.isLoggable(6)) {
            lIt.e(str, str2, th);
        }
    }

    public static void b(Class<?> cls, String str, Throwable th) {
        if (lIt.isLoggable(6)) {
            lIt.e(C(cls), str, th);
        }
    }

    public static void wtf(String str, String str2) {
        if (lIt.isLoggable(6)) {
            lIt.wtf(str, str2);
        }
    }

    public static void j(String str, String str2, Object... objArr) {
        if (lIt.isLoggable(6)) {
            lIt.wtf(str, o(str2, objArr));
        }
    }

    public static void c(Class<?> cls, String str, Throwable th) {
        if (lIt.isLoggable(6)) {
            lIt.wtf(C(cls), str, th);
        }
    }

    private static String o(String str, Object... objArr) {
        return String.format(null, str, objArr);
    }

    private static String C(Class<?> cls) {
        return cls.getSimpleName();
    }
}
