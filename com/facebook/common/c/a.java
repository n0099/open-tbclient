package com.facebook.common.c;
/* loaded from: classes12.dex */
public class a {
    private static c lHK = b.djw();

    public static boolean isLoggable(int i) {
        return lHK.isLoggable(i);
    }

    public static void e(Class<?> cls, String str) {
        if (lHK.isLoggable(2)) {
            lHK.v(C(cls), str);
        }
    }

    public static void a(Class<?> cls, String str, Object obj) {
        if (lHK.isLoggable(2)) {
            lHK.v(C(cls), o(str, obj));
        }
    }

    public static void a(Class<?> cls, String str, Object obj, Object obj2) {
        if (lHK.isLoggable(2)) {
            lHK.v(C(cls), o(str, obj, obj2));
        }
    }

    public static void a(Class<?> cls, String str, Object obj, Object obj2, Object obj3) {
        if (isLoggable(2)) {
            e(cls, o(str, obj, obj2, obj3));
        }
    }

    public static void a(Class<?> cls, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        if (lHK.isLoggable(2)) {
            lHK.v(C(cls), o(str, obj, obj2, obj3, obj4));
        }
    }

    public static void f(String str, String str2, Object... objArr) {
        if (lHK.isLoggable(2)) {
            lHK.v(str, o(str2, objArr));
        }
    }

    public static void b(Class<?> cls, String str, Object... objArr) {
        if (lHK.isLoggable(2)) {
            lHK.v(C(cls), o(str, objArr));
        }
    }

    public static void f(Class<?> cls, String str) {
        if (lHK.isLoggable(3)) {
            lHK.d(C(cls), str);
        }
    }

    public static void b(Class<?> cls, String str, Object obj) {
        if (lHK.isLoggable(3)) {
            lHK.d(C(cls), o(str, obj));
        }
    }

    public static void g(Class<?> cls, String str) {
        if (lHK.isLoggable(5)) {
            lHK.w(C(cls), str);
        }
    }

    public static void g(String str, String str2, Object... objArr) {
        if (lHK.isLoggable(5)) {
            lHK.w(str, o(str2, objArr));
        }
    }

    public static void c(Class<?> cls, String str, Object... objArr) {
        if (lHK.isLoggable(5)) {
            lHK.w(C(cls), o(str, objArr));
        }
    }

    public static void a(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (isLoggable(5)) {
            a(cls, o(str, objArr), th);
        }
    }

    public static void a(Class<?> cls, String str, Throwable th) {
        if (lHK.isLoggable(5)) {
            lHK.f(C(cls), str, th);
        }
    }

    public static void e(String str, String str2) {
        if (lHK.isLoggable(6)) {
            lHK.e(str, str2);
        }
    }

    public static void h(Class<?> cls, String str) {
        if (lHK.isLoggable(6)) {
            lHK.e(C(cls), str);
        }
    }

    public static void h(String str, String str2, Object... objArr) {
        if (lHK.isLoggable(6)) {
            lHK.e(str, o(str2, objArr));
        }
    }

    public static void d(Class<?> cls, String str, Object... objArr) {
        if (lHK.isLoggable(6)) {
            lHK.e(C(cls), o(str, objArr));
        }
    }

    public static void b(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (lHK.isLoggable(6)) {
            lHK.e(C(cls), o(str, objArr), th);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        if (lHK.isLoggable(6)) {
            lHK.e(str, str2, th);
        }
    }

    public static void b(Class<?> cls, String str, Throwable th) {
        if (lHK.isLoggable(6)) {
            lHK.e(C(cls), str, th);
        }
    }

    public static void fc(String str, String str2) {
        if (lHK.isLoggable(6)) {
            lHK.fc(str, str2);
        }
    }

    public static void j(String str, String str2, Object... objArr) {
        if (lHK.isLoggable(6)) {
            lHK.fc(str, o(str2, objArr));
        }
    }

    public static void c(Class<?> cls, String str, Throwable th) {
        if (lHK.isLoggable(6)) {
            lHK.g(C(cls), str, th);
        }
    }

    private static String o(String str, Object... objArr) {
        return String.format(null, str, objArr);
    }

    private static String C(Class<?> cls) {
        return cls.getSimpleName();
    }
}
