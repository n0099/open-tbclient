package com.bytedance.sdk.openadsdk.utils;

import android.util.Log;
/* loaded from: classes6.dex */
public class u {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f30334a = false;

    /* renamed from: b  reason: collision with root package name */
    public static int f30335b = 4;

    public static void a(int i2) {
        f30335b = i2;
    }

    public static void b() {
        f30334a = true;
        a(3);
    }

    public static boolean c() {
        return f30334a;
    }

    public static void d(String str, String str2) {
        if (f30334a && str2 != null && f30335b <= 5) {
            Log.w(str, str2);
        }
    }

    public static void e(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (str == null) {
            str = "Logger";
        }
        Log.i(str, str2);
    }

    public static void f(String str, String str2) {
        if (f30334a && str2 != null && f30335b <= 6) {
            Log.e(str, str2);
        }
    }

    public static boolean a() {
        return f30335b <= 3;
    }

    public static void c(String str, String str2) {
        if (f30334a && str2 != null && f30335b <= 4) {
            Log.i(str, str2);
        }
    }

    public static void a(String str, String str2) {
        if (f30334a && str2 != null && f30335b <= 2) {
            Log.v(str, str2);
        }
    }

    public static void b(String str, String str2) {
        if (f30334a && str2 != null && f30335b <= 3) {
            Log.d(str, str2);
        }
    }

    public static void c(String str, String str2, Throwable th) {
        if (f30334a) {
            if (!(str2 == null && th == null) && f30335b <= 6) {
                Log.e(str, str2, th);
            }
        }
    }

    public static void a(String str) {
        if (f30334a) {
            b("Logger", str);
        }
    }

    public static void b(String str, Object... objArr) {
        if (f30334a && objArr != null && f30335b <= 4) {
            Log.v(str, a(objArr));
        }
    }

    public static void a(String str, String str2, Throwable th) {
        if (f30334a) {
            if (!(str2 == null && th == null) && f30335b <= 3) {
                Log.d(str, str2, th);
            }
        }
    }

    public static void c(String str, Object... objArr) {
        if (f30334a && objArr != null && f30335b <= 6) {
            Log.v(str, a(objArr));
        }
    }

    public static void b(String str, String str2, Throwable th) {
        if (f30334a) {
            if (!(str2 == null && th == null) && f30335b <= 5) {
                Log.w(str, str2, th);
            }
        }
    }

    public static void a(String str, Object... objArr) {
        if (f30334a && objArr != null && f30335b <= 3) {
            Log.v(str, a(objArr));
        }
    }

    public static void b(String str) {
        if (f30334a) {
            f("Logger", str);
        }
    }

    public static String a(Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Object obj : objArr) {
            if (obj != null) {
                sb.append(obj.toString());
            } else {
                sb.append(" null ");
            }
            sb.append(" ");
        }
        return sb.toString();
    }
}
