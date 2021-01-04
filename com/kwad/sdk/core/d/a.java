package com.kwad.sdk.core.d;

import android.util.Log;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    private static String f9354b = "[KSAdSDK_3.3.9]";

    /* renamed from: a  reason: collision with root package name */
    public static boolean f9353a = true;
    private static boolean c = false;

    private static String a() {
        return f9354b;
    }

    public static void a(String str, String str2) {
    }

    public static void a(String str, String str2, Throwable th) {
        if (f9353a) {
            Log.e(str, str2, th);
        }
    }

    public static void a(String str, boolean z) {
        f9354b = "[" + str + "]";
        f9353a = z;
    }

    public static void a(Throwable th) {
        if (f9353a && th != null) {
            th.printStackTrace();
        }
        if (com.kwad.sdk.a.f8423b.booleanValue()) {
            throw new RuntimeException(th);
        }
    }

    private static String b() {
        if (c) {
            int i = -1;
            String str = "unknown";
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            if (stackTrace.length > 3) {
                str = stackTrace[3].getFileName();
                i = stackTrace[3].getLineNumber();
            }
            return "(" + str + ':' + i + ')';
        }
        return "";
    }

    public static void b(String str, String str2) {
        if (f9353a) {
            Log.i(a(), e(str, str2));
        }
    }

    public static void b(Throwable th) {
        if (!f9353a || th == null) {
            return;
        }
        th.printStackTrace();
    }

    public static void c(String str, String str2) {
        if (f9353a) {
            Log.w(a(), e(str, str2));
        }
    }

    public static void d(String str, String str2) {
        if (f9353a) {
            Log.e(a(), e(str, str2));
        }
    }

    private static String e(String str, String str2) {
        return "[" + str + "]: " + str2 + " " + b();
    }
}
