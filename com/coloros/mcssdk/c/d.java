package com.coloros.mcssdk.c;

import android.util.Log;
/* loaded from: classes5.dex */
public final class d {
    public static final String a = "com.coloros.mcssdk---";
    private static String b = "MCS";
    private static boolean c = false;
    private static boolean d = false;
    private static boolean e = true;
    private static boolean f = true;
    private static boolean g = true;
    private static String h = "-->";
    private static boolean i = true;

    private static String a() {
        return b;
    }

    private static void a(Exception exc) {
        if (g) {
            exc.printStackTrace();
        }
    }

    public static void a(String str) {
        if (e && i) {
            Log.d(a, b + h + str);
        }
    }

    private static void a(String str, String str2) {
        if (c && i) {
            Log.v(str, b + h + str2);
        }
    }

    private static void a(String str, Throwable th) {
        if (g) {
            Log.e(str, th.toString());
        }
    }

    private static void a(boolean z) {
        c = z;
    }

    public static void b(String str) {
        if (g && i) {
            Log.e(a, b + h + str);
        }
    }

    private static void b(String str, String str2) {
        if (e && i) {
            Log.d(str, b + h + str2);
        }
    }

    private static void b(boolean z) {
        e = z;
    }

    private static boolean b() {
        return c;
    }

    private static void c(String str) {
        if (c && i) {
            Log.v(a, b + h + str);
        }
    }

    private static void c(String str, String str2) {
        if (d && i) {
            Log.i(str, b + h + str2);
        }
    }

    private static void c(boolean z) {
        d = z;
    }

    private static boolean c() {
        return e;
    }

    private static void d(String str) {
        if (d && i) {
            Log.i(a, b + h + str);
        }
    }

    private static void d(String str, String str2) {
        if (f && i) {
            Log.w(str, b + h + str2);
        }
    }

    private static void d(boolean z) {
        f = z;
    }

    private static boolean d() {
        return d;
    }

    private static void e(String str) {
        if (f && i) {
            Log.w(a, b + h + str);
        }
    }

    private static void e(String str, String str2) {
        if (g && i) {
            Log.e(str, b + h + str2);
        }
    }

    private static void e(boolean z) {
        g = z;
    }

    private static boolean e() {
        return f;
    }

    private static void f(String str) {
        b = str;
    }

    private static void f(boolean z) {
        i = z;
        if (z) {
            c = true;
            e = true;
            d = true;
            f = true;
            g = true;
            return;
        }
        c = false;
        e = false;
        d = false;
        f = false;
        g = false;
    }

    private static boolean f() {
        return g;
    }

    private static void g(String str) {
        h = str;
    }

    private static boolean g() {
        return i;
    }

    private static String h() {
        return h;
    }
}
