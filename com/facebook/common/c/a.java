package com.facebook.common.c;
/* loaded from: classes2.dex */
public class a {
    private static c kaX = b.cCM();

    public static boolean isLoggable(int i) {
        return kaX.isLoggable(i);
    }

    public static void c(Class<?> cls, String str) {
        if (kaX.isLoggable(2)) {
            kaX.v(s(cls), str);
        }
    }

    public static void a(Class<?> cls, String str, Object obj) {
        if (kaX.isLoggable(2)) {
            kaX.v(s(cls), k(str, obj));
        }
    }

    public static void a(Class<?> cls, String str, Object obj, Object obj2) {
        if (kaX.isLoggable(2)) {
            kaX.v(s(cls), k(str, obj, obj2));
        }
    }

    public static void a(Class<?> cls, String str, Object obj, Object obj2, Object obj3) {
        if (isLoggable(2)) {
            c(cls, k(str, obj, obj2, obj3));
        }
    }

    public static void a(Class<?> cls, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        if (kaX.isLoggable(2)) {
            kaX.v(s(cls), k(str, obj, obj2, obj3, obj4));
        }
    }

    public static void f(String str, String str2, Object... objArr) {
        if (kaX.isLoggable(2)) {
            kaX.v(str, k(str2, objArr));
        }
    }

    public static void b(Class<?> cls, String str, Object... objArr) {
        if (kaX.isLoggable(2)) {
            kaX.v(s(cls), k(str, objArr));
        }
    }

    public static void b(Class<?> cls, String str, Object obj) {
        if (kaX.isLoggable(3)) {
            kaX.d(s(cls), k(str, obj));
        }
    }

    public static void d(Class<?> cls, String str) {
        if (kaX.isLoggable(4)) {
            kaX.i(s(cls), str);
        }
    }

    public static void e(Class<?> cls, String str) {
        if (kaX.isLoggable(5)) {
            kaX.w(s(cls), str);
        }
    }

    public static void g(String str, String str2, Object... objArr) {
        if (kaX.isLoggable(5)) {
            kaX.w(str, k(str2, objArr));
        }
    }

    public static void a(String str, Throwable th, String str2, Object... objArr) {
        if (kaX.isLoggable(5)) {
            kaX.c(str, k(str2, objArr), th);
        }
    }

    public static void c(Class<?> cls, String str, Object... objArr) {
        if (kaX.isLoggable(5)) {
            kaX.w(s(cls), k(str, objArr));
        }
    }

    public static void a(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (isLoggable(5)) {
            a(cls, k(str, objArr), th);
        }
    }

    public static void a(Class<?> cls, String str, Throwable th) {
        if (kaX.isLoggable(5)) {
            kaX.c(s(cls), str, th);
        }
    }

    public static void e(String str, String str2) {
        if (kaX.isLoggable(6)) {
            kaX.e(str, str2);
        }
    }

    public static void f(Class<?> cls, String str) {
        if (kaX.isLoggable(6)) {
            kaX.e(s(cls), str);
        }
    }

    public static void b(String str, Throwable th, String str2, Object... objArr) {
        if (kaX.isLoggable(6)) {
            kaX.e(str, k(str2, objArr), th);
        }
    }

    public static void d(Class<?> cls, String str, Object... objArr) {
        if (kaX.isLoggable(6)) {
            kaX.e(s(cls), k(str, objArr));
        }
    }

    public static void b(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (kaX.isLoggable(6)) {
            kaX.e(s(cls), k(str, objArr), th);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        if (kaX.isLoggable(6)) {
            kaX.e(str, str2, th);
        }
    }

    public static void b(Class<?> cls, String str, Throwable th) {
        if (kaX.isLoggable(6)) {
            kaX.e(s(cls), str, th);
        }
    }

    public static void h(String str, String str2, Object... objArr) {
        if (kaX.isLoggable(6)) {
            kaX.em(str, k(str2, objArr));
        }
    }

    public static void e(Class<?> cls, String str, Object... objArr) {
        if (kaX.isLoggable(6)) {
            kaX.em(s(cls), k(str, objArr));
        }
    }

    public static void c(Class<?> cls, String str, Throwable th) {
        if (kaX.isLoggable(6)) {
            kaX.f(s(cls), str, th);
        }
    }

    private static String k(String str, Object... objArr) {
        return String.format(null, str, objArr);
    }

    private static String s(Class<?> cls) {
        return cls.getSimpleName();
    }
}
