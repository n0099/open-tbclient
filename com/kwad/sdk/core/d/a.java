package com.kwad.sdk.core.d;

import android.util.Log;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    private static String f9055b = "[KSAdSDK_3.3.9]";

    /* renamed from: a  reason: collision with root package name */
    public static boolean f9054a = true;
    private static boolean c = false;

    private static String a() {
        return f9055b;
    }

    public static void a(String str, String str2) {
    }

    public static void a(String str, String str2, Throwable th) {
        if (f9054a) {
            Log.e(str, str2, th);
        }
    }

    public static void a(String str, boolean z) {
        f9055b = "[" + str + "]";
        f9054a = z;
    }

    public static void a(Throwable th) {
        if (f9054a && th != null) {
            th.printStackTrace();
        }
        if (com.kwad.sdk.a.f8124b.booleanValue()) {
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
        if (f9054a) {
            Log.i(a(), e(str, str2));
        }
    }

    public static void b(Throwable th) {
        if (!f9054a || th == null) {
            return;
        }
        th.printStackTrace();
    }

    public static void c(String str, String str2) {
        if (f9054a) {
            Log.w(a(), e(str, str2));
        }
    }

    public static void d(String str, String str2) {
        if (f9054a) {
            Log.e(a(), e(str, str2));
        }
    }

    private static String e(String str, String str2) {
        return "[" + str + "]: " + str2 + " " + b();
    }
}
