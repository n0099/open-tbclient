package com.facebook.common.c;
/* loaded from: classes13.dex */
public class a {
    private static c lIr = b.dkJ();

    public static boolean isLoggable(int i) {
        return lIr.isLoggable(i);
    }

    public static void e(Class<?> cls, String str) {
        if (lIr.isLoggable(2)) {
            lIr.v(C(cls), str);
        }
    }

    public static void a(Class<?> cls, String str, Object obj) {
        if (lIr.isLoggable(2)) {
            lIr.v(C(cls), o(str, obj));
        }
    }

    public static void a(Class<?> cls, String str, Object obj, Object obj2) {
        if (lIr.isLoggable(2)) {
            lIr.v(C(cls), o(str, obj, obj2));
        }
    }

    public static void a(Class<?> cls, String str, Object obj, Object obj2, Object obj3) {
        if (isLoggable(2)) {
            e(cls, o(str, obj, obj2, obj3));
        }
    }

    public static void a(Class<?> cls, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        if (lIr.isLoggable(2)) {
            lIr.v(C(cls), o(str, obj, obj2, obj3, obj4));
        }
    }

    public static void f(String str, String str2, Object... objArr) {
        if (lIr.isLoggable(2)) {
            lIr.v(str, o(str2, objArr));
        }
    }

    public static void b(Class<?> cls, String str, Object... objArr) {
        if (lIr.isLoggable(2)) {
            lIr.v(C(cls), o(str, objArr));
        }
    }

    public static void f(Class<?> cls, String str) {
        if (lIr.isLoggable(3)) {
            lIr.d(C(cls), str);
        }
    }

    public static void b(Class<?> cls, String str, Object obj) {
        if (lIr.isLoggable(3)) {
            lIr.d(C(cls), o(str, obj));
        }
    }

    public static void g(Class<?> cls, String str) {
        if (lIr.isLoggable(5)) {
            lIr.w(C(cls), str);
        }
    }

    public static void g(String str, String str2, Object... objArr) {
        if (lIr.isLoggable(5)) {
            lIr.w(str, o(str2, objArr));
        }
    }

    public static void c(Class<?> cls, String str, Object... objArr) {
        if (lIr.isLoggable(5)) {
            lIr.w(C(cls), o(str, objArr));
        }
    }

    public static void a(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (isLoggable(5)) {
            a(cls, o(str, objArr), th);
        }
    }

    public static void a(Class<?> cls, String str, Throwable th) {
        if (lIr.isLoggable(5)) {
            lIr.w(C(cls), str, th);
        }
    }

    public static void e(String str, String str2) {
        if (lIr.isLoggable(6)) {
            lIr.e(str, str2);
        }
    }

    public static void h(Class<?> cls, String str) {
        if (lIr.isLoggable(6)) {
            lIr.e(C(cls), str);
        }
    }

    public static void h(String str, String str2, Object... objArr) {
        if (lIr.isLoggable(6)) {
            lIr.e(str, o(str2, objArr));
        }
    }

    public static void d(Class<?> cls, String str, Object... objArr) {
        if (lIr.isLoggable(6)) {
            lIr.e(C(cls), o(str, objArr));
        }
    }

    public static void b(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (lIr.isLoggable(6)) {
            lIr.e(C(cls), o(str, objArr), th);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        if (lIr.isLoggable(6)) {
            lIr.e(str, str2, th);
        }
    }

    public static void b(Class<?> cls, String str, Throwable th) {
        if (lIr.isLoggable(6)) {
            lIr.e(C(cls), str, th);
        }
    }

    public static void wtf(String str, String str2) {
        if (lIr.isLoggable(6)) {
            lIr.wtf(str, str2);
        }
    }

    public static void j(String str, String str2, Object... objArr) {
        if (lIr.isLoggable(6)) {
            lIr.wtf(str, o(str2, objArr));
        }
    }

    public static void c(Class<?> cls, String str, Throwable th) {
        if (lIr.isLoggable(6)) {
            lIr.wtf(C(cls), str, th);
        }
    }

    private static String o(String str, Object... objArr) {
        return String.format(null, str, objArr);
    }

    private static String C(Class<?> cls) {
        return cls.getSimpleName();
    }
}
