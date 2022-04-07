package com.kwad.sdk.core.d;

import android.util.Log;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
/* loaded from: classes5.dex */
public class a {
    public static boolean a = true;
    public static boolean b;

    public static String a() {
        return "KSAdSDK";
    }

    public static void a(String str) {
        Log.v(a(), str);
    }

    public static void a(String str, String str2) {
        if (a && com.kwad.kwai.kwai.a.a.booleanValue()) {
            b(a(), f(str, str2));
        }
    }

    public static void a(String str, String str2, Throwable th) {
        if (a) {
            Log.e(str, str2, th);
        }
    }

    public static void a(String str, Throwable th) {
        if (a && com.kwad.kwai.kwai.a.a.booleanValue()) {
            Log.w(str, th);
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
        int i;
        if (b) {
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
        if (str2.length() <= 4000) {
            Log.d(str, str2);
            return;
        }
        Log.d(str, str2.substring(0, 4000));
        b(str, str2.substring(4000));
    }

    public static void b(Throwable th) {
        if (!com.kwad.kwai.kwai.a.a.booleanValue() || th == null) {
            return;
        }
        th.printStackTrace();
    }

    public static void c(String str, String str2) {
        if (a) {
            Log.i(a(), f(str, str2));
        }
    }

    public static void d(String str, String str2) {
        if (a) {
            Log.w(a(), f(str, str2));
        }
    }

    public static void e(String str, String str2) {
        if (a) {
            Log.e(a(), f(str, str2));
        }
    }

    public static String f(String str, String str2) {
        return PreferencesUtil.LEFT_MOUNT + str + "]: " + str2 + " " + b();
    }
}
