package com.kwad.sdk.core.d;

import android.util.Log;
import com.kwad.sdk.b;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f32112a = true;

    /* renamed from: b  reason: collision with root package name */
    public static String f32113b = "[KSAdSDK_3.3.8.3]";

    /* renamed from: c  reason: collision with root package name */
    public static boolean f32114c = false;

    public static String a() {
        return f32113b;
    }

    public static void a(String str) {
        Log.v(a(), str);
    }

    public static void a(String str, String str2) {
        if (f32112a && b.f31890b.booleanValue()) {
            b(a(), f(str, str2));
        }
    }

    public static void a(String str, String str2, Throwable th) {
        if (f32112a) {
            Log.e(str, str2, th);
        }
    }

    public static void a(String str, boolean z) {
        f32113b = "[" + str + "]";
        f32112a = z;
    }

    public static void a(Throwable th) {
        if (f32112a && th != null) {
            th.printStackTrace();
        }
        if (b.f31890b.booleanValue()) {
            throw new RuntimeException(th);
        }
    }

    public static String b() {
        String str;
        int i2;
        if (f32114c) {
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            if (stackTrace.length > 3) {
                str = stackTrace[3].getFileName();
                i2 = stackTrace[3].getLineNumber();
            } else {
                str = "unknown";
                i2 = -1;
            }
            return "(" + str + ':' + i2 + ')';
        }
        return "";
    }

    public static void b(String str, String str2) {
        if (str2.length() <= 4000) {
            Log.d(str, str2);
            return;
        }
        Log.d(str, str2.substring(0, 4000));
        b(str, str2.substring(4000));
    }

    public static void b(Throwable th) {
        if (!f32112a || th == null) {
            return;
        }
        th.printStackTrace();
    }

    public static void c(String str, String str2) {
        if (f32112a) {
            Log.i(a(), f(str, str2));
        }
    }

    public static void d(String str, String str2) {
        if (f32112a) {
            Log.w(a(), f(str, str2));
        }
    }

    public static void e(String str, String str2) {
        if (f32112a) {
            Log.e(a(), f(str, str2));
        }
    }

    public static String f(String str, String str2) {
        return "[" + str + "]: " + str2 + " " + b();
    }
}
