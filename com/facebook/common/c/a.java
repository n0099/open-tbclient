package com.facebook.common.c;
/* loaded from: classes11.dex */
public class a {
    private static c lEh = b.dit();

    public static boolean isLoggable(int i) {
        return lEh.isLoggable(i);
    }

    public static void e(Class<?> cls, String str) {
        if (lEh.isLoggable(2)) {
            lEh.v(C(cls), str);
        }
    }

    public static void a(Class<?> cls, String str, Object obj) {
        if (lEh.isLoggable(2)) {
            lEh.v(C(cls), o(str, obj));
        }
    }

    public static void a(Class<?> cls, String str, Object obj, Object obj2) {
        if (lEh.isLoggable(2)) {
            lEh.v(C(cls), o(str, obj, obj2));
        }
    }

    public static void a(Class<?> cls, String str, Object obj, Object obj2, Object obj3) {
        if (isLoggable(2)) {
            e(cls, o(str, obj, obj2, obj3));
        }
    }

    public static void a(Class<?> cls, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        if (lEh.isLoggable(2)) {
            lEh.v(C(cls), o(str, obj, obj2, obj3, obj4));
        }
    }

    public static void f(String str, String str2, Object... objArr) {
        if (lEh.isLoggable(2)) {
            lEh.v(str, o(str2, objArr));
        }
    }

    public static void b(Class<?> cls, String str, Object... objArr) {
        if (lEh.isLoggable(2)) {
            lEh.v(C(cls), o(str, objArr));
        }
    }

    public static void f(Class<?> cls, String str) {
        if (lEh.isLoggable(3)) {
            lEh.d(C(cls), str);
        }
    }

    public static void b(Class<?> cls, String str, Object obj) {
        if (lEh.isLoggable(3)) {
            lEh.d(C(cls), o(str, obj));
        }
    }

    public static void g(Class<?> cls, String str) {
        if (lEh.isLoggable(5)) {
            lEh.w(C(cls), str);
        }
    }

    public static void g(String str, String str2, Object... objArr) {
        if (lEh.isLoggable(5)) {
            lEh.w(str, o(str2, objArr));
        }
    }

    public static void c(Class<?> cls, String str, Object... objArr) {
        if (lEh.isLoggable(5)) {
            lEh.w(C(cls), o(str, objArr));
        }
    }

    public static void a(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (isLoggable(5)) {
            a(cls, o(str, objArr), th);
        }
    }

    public static void a(Class<?> cls, String str, Throwable th) {
        if (lEh.isLoggable(5)) {
            lEh.f(C(cls), str, th);
        }
    }

    public static void e(String str, String str2) {
        if (lEh.isLoggable(6)) {
            lEh.e(str, str2);
        }
    }

    public static void h(Class<?> cls, String str) {
        if (lEh.isLoggable(6)) {
            lEh.e(C(cls), str);
        }
    }

    public static void h(String str, String str2, Object... objArr) {
        if (lEh.isLoggable(6)) {
            lEh.e(str, o(str2, objArr));
        }
    }

    public static void d(Class<?> cls, String str, Object... objArr) {
        if (lEh.isLoggable(6)) {
            lEh.e(C(cls), o(str, objArr));
        }
    }

    public static void b(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (lEh.isLoggable(6)) {
            lEh.e(C(cls), o(str, objArr), th);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        if (lEh.isLoggable(6)) {
            lEh.e(str, str2, th);
        }
    }

    public static void b(Class<?> cls, String str, Throwable th) {
        if (lEh.isLoggable(6)) {
            lEh.e(C(cls), str, th);
        }
    }

    public static void fa(String str, String str2) {
        if (lEh.isLoggable(6)) {
            lEh.fa(str, str2);
        }
    }

    public static void j(String str, String str2, Object... objArr) {
        if (lEh.isLoggable(6)) {
            lEh.fa(str, o(str2, objArr));
        }
    }

    public static void c(Class<?> cls, String str, Throwable th) {
        if (lEh.isLoggable(6)) {
            lEh.g(C(cls), str, th);
        }
    }

    private static String o(String str, Object... objArr) {
        return String.format(null, str, objArr);
    }

    private static String C(Class<?> cls) {
        return cls.getSimpleName();
    }
}
