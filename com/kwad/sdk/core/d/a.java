package com.kwad.sdk.core.d;

import android.util.Log;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f34079a = true;

    /* renamed from: b  reason: collision with root package name */
    public static String f34080b = "[KSAdSDK_3.3.9]";

    /* renamed from: c  reason: collision with root package name */
    public static boolean f34081c = false;

    public static String a() {
        return f34080b;
    }

    public static void a(String str, String str2) {
    }

    public static void a(String str, String str2, Throwable th) {
        if (f34079a) {
            Log.e(str, str2, th);
        }
    }

    public static void a(String str, boolean z) {
        f34080b = "[" + str + "]";
        f34079a = z;
    }

    public static void a(Throwable th) {
        if (f34079a && th != null) {
            th.printStackTrace();
        }
        if (com.kwad.sdk.a.f32184b.booleanValue()) {
            throw new RuntimeException(th);
        }
    }

    public static String b() {
        String str;
        int i2;
        if (f34081c) {
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
        if (f34079a) {
            Log.i(a(), e(str, str2));
        }
    }

    public static void b(Throwable th) {
        if (!f34079a || th == null) {
            return;
        }
        th.printStackTrace();
    }

    public static void c(String str, String str2) {
        if (f34079a) {
            Log.w(a(), e(str, str2));
        }
    }

    public static void d(String str, String str2) {
        if (f34079a) {
            Log.e(a(), e(str, str2));
        }
    }

    public static String e(String str, String str2) {
        return "[" + str + "]: " + str2 + " " + b();
    }
}
