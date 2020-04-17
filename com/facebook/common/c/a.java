package com.facebook.common.c;
/* loaded from: classes13.dex */
public class a {
    private static c lRE = b.dnc();

    public static boolean isLoggable(int i) {
        return lRE.isLoggable(i);
    }

    public static void e(Class<?> cls, String str) {
        if (lRE.isLoggable(2)) {
            lRE.v(A(cls), str);
        }
    }

    public static void a(Class<?> cls, String str, Object obj) {
        if (lRE.isLoggable(2)) {
            lRE.v(A(cls), l(str, obj));
        }
    }

    public static void a(Class<?> cls, String str, Object obj, Object obj2) {
        if (lRE.isLoggable(2)) {
            lRE.v(A(cls), l(str, obj, obj2));
        }
    }

    public static void a(Class<?> cls, String str, Object obj, Object obj2, Object obj3) {
        if (isLoggable(2)) {
            e(cls, l(str, obj, obj2, obj3));
        }
    }

    public static void a(Class<?> cls, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        if (lRE.isLoggable(2)) {
            lRE.v(A(cls), l(str, obj, obj2, obj3, obj4));
        }
    }

    public static void j(String str, String str2, Object... objArr) {
        if (lRE.isLoggable(2)) {
            lRE.v(str, l(str2, objArr));
        }
    }

    public static void b(Class<?> cls, String str, Object... objArr) {
        if (lRE.isLoggable(2)) {
            lRE.v(A(cls), l(str, objArr));
        }
    }

    public static void f(Class<?> cls, String str) {
        if (lRE.isLoggable(3)) {
            lRE.d(A(cls), str);
        }
    }

    public static void b(Class<?> cls, String str, Object obj) {
        if (lRE.isLoggable(3)) {
            lRE.d(A(cls), l(str, obj));
        }
    }

    public static void g(Class<?> cls, String str) {
        if (lRE.isLoggable(5)) {
            lRE.w(A(cls), str);
        }
    }

    public static void k(String str, String str2, Object... objArr) {
        if (lRE.isLoggable(5)) {
            lRE.w(str, l(str2, objArr));
        }
    }

    public static void c(Class<?> cls, String str, Object... objArr) {
        if (lRE.isLoggable(5)) {
            lRE.w(A(cls), l(str, objArr));
        }
    }

    public static void a(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (isLoggable(5)) {
            a(cls, l(str, objArr), th);
        }
    }

    public static void a(Class<?> cls, String str, Throwable th) {
        if (lRE.isLoggable(5)) {
            lRE.w(A(cls), str, th);
        }
    }

    public static void e(String str, String str2) {
        if (lRE.isLoggable(6)) {
            lRE.e(str, str2);
        }
    }

    public static void h(Class<?> cls, String str) {
        if (lRE.isLoggable(6)) {
            lRE.e(A(cls), str);
        }
    }

    public static void h(String str, String str2, Object... objArr) {
        if (lRE.isLoggable(6)) {
            lRE.e(str, l(str2, objArr));
        }
    }

    public static void d(Class<?> cls, String str, Object... objArr) {
        if (lRE.isLoggable(6)) {
            lRE.e(A(cls), l(str, objArr));
        }
    }

    public static void b(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (lRE.isLoggable(6)) {
            lRE.e(A(cls), l(str, objArr), th);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        if (lRE.isLoggable(6)) {
            lRE.e(str, str2, th);
        }
    }

    public static void b(Class<?> cls, String str, Throwable th) {
        if (lRE.isLoggable(6)) {
            lRE.e(A(cls), str, th);
        }
    }

    public static void wtf(String str, String str2) {
        if (lRE.isLoggable(6)) {
            lRE.wtf(str, str2);
        }
    }

    public static void l(String str, String str2, Object... objArr) {
        if (lRE.isLoggable(6)) {
            lRE.wtf(str, l(str2, objArr));
        }
    }

    public static void c(Class<?> cls, String str, Throwable th) {
        if (lRE.isLoggable(6)) {
            lRE.wtf(A(cls), str, th);
        }
    }

    private static String l(String str, Object... objArr) {
        return String.format(null, str, objArr);
    }

    private static String A(Class<?> cls) {
        return cls.getSimpleName();
    }
}
