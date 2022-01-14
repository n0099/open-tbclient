package com.kwad.sdk.core.d;

import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
/* loaded from: classes3.dex */
public class a {
    public static boolean a = true;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f55652b;

    public static String a() {
        return "KSAdSDK";
    }

    public static void a(String str) {
        a();
    }

    public static void a(String str, String str2) {
        if (a && com.kwad.kwai.kwai.a.a.booleanValue()) {
            b(a(), f(str, str2));
        }
    }

    public static void a(String str, String str2, Throwable th) {
        boolean z = a;
    }

    public static void a(String str, Throwable th) {
        if (a) {
            com.kwad.kwai.kwai.a.a.booleanValue();
        }
    }

    public static void a(Throwable th) {
        if (a && th != null) {
            th.printStackTrace();
        }
        if (com.kwad.kwai.kwai.a.a.booleanValue()) {
            throw new RuntimeException(th);
        }
    }

    public static void a(boolean z) {
        a = z;
    }

    public static String b() {
        String str;
        int i2;
        if (f55652b) {
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
        if (str2.length() > 4000) {
            str2.substring(0, 4000);
            b(str, str2.substring(4000));
        }
    }

    public static void b(Throwable th) {
        if (!com.kwad.kwai.kwai.a.a.booleanValue() || th == null) {
            return;
        }
        th.printStackTrace();
    }

    public static void c(String str, String str2) {
        if (a) {
            a();
            f(str, str2);
        }
    }

    public static void d(String str, String str2) {
        if (a) {
            a();
            f(str, str2);
        }
    }

    public static void e(String str, String str2) {
        if (a) {
            a();
            f(str, str2);
        }
    }

    public static String f(String str, String str2) {
        return PreferencesUtil.LEFT_MOUNT + str + "]: " + str2 + " " + b();
    }
}
