package com.kwad.sdk.core.d;

import android.util.Log;
/* loaded from: classes3.dex */
public class a {
    private static String b = "[KSAdSDK_3.3.9]";

    /* renamed from: a  reason: collision with root package name */
    public static boolean f6021a = true;
    private static boolean c = false;

    private static String a() {
        return b;
    }

    public static void a(String str, String str2) {
    }

    public static void a(String str, String str2, Throwable th) {
        if (f6021a) {
            Log.e(str, str2, th);
        }
    }

    public static void a(String str, boolean z) {
        b = "[" + str + "]";
        f6021a = z;
    }

    public static void a(Throwable th) {
        if (f6021a && th != null) {
            th.printStackTrace();
        }
        if (com.kwad.sdk.a.b.booleanValue()) {
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
        if (f6021a) {
            Log.i(a(), e(str, str2));
        }
    }

    public static void b(Throwable th) {
        if (!f6021a || th == null) {
            return;
        }
        th.printStackTrace();
    }

    public static void c(String str, String str2) {
        if (f6021a) {
            Log.w(a(), e(str, str2));
        }
    }

    public static void d(String str, String str2) {
        if (f6021a) {
            Log.e(a(), e(str, str2));
        }
    }

    private static String e(String str, String str2) {
        return "[" + str + "]: " + str2 + " " + b();
    }
}
