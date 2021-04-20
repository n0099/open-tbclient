package com.kwad.sdk.core.d;

import android.util.Log;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f33747a = true;

    /* renamed from: b  reason: collision with root package name */
    public static String f33748b = "[KSAdSDK_3.3.9]";

    /* renamed from: c  reason: collision with root package name */
    public static boolean f33749c = false;

    public static String a() {
        return f33748b;
    }

    public static void a(String str, String str2) {
    }

    public static void a(String str, String str2, Throwable th) {
        if (f33747a) {
            Log.e(str, str2, th);
        }
    }

    public static void a(String str, boolean z) {
        f33748b = "[" + str + "]";
        f33747a = z;
    }

    public static void a(Throwable th) {
        if (f33747a && th != null) {
            th.printStackTrace();
        }
        if (com.kwad.sdk.a.f31932b.booleanValue()) {
            throw new RuntimeException(th);
        }
    }

    public static String b() {
        String str;
        int i;
        if (f33749c) {
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            if (stackTrace.length > 3) {
                str = stackTrace[3].getFileName();
                i = stackTrace[3].getLineNumber();
            } else {
                str = "unknown";
                i = -1;
            }
            return "(" + str + ':' + i + ')';
        }
        return "";
    }

    public static void b(String str, String str2) {
        if (f33747a) {
            Log.i(a(), e(str, str2));
        }
    }

    public static void b(Throwable th) {
        if (!f33747a || th == null) {
            return;
        }
        th.printStackTrace();
    }

    public static void c(String str, String str2) {
        if (f33747a) {
            Log.w(a(), e(str, str2));
        }
    }

    public static void d(String str, String str2) {
        if (f33747a) {
            Log.e(a(), e(str, str2));
        }
    }

    public static String e(String str, String str2) {
        return "[" + str + "]: " + str2 + " " + b();
    }
}
