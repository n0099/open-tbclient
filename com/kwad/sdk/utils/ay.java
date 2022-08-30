package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import java.io.IOException;
/* loaded from: classes7.dex */
public final class ay {
    public static Class<?> aou;

    public static String dV(String str) {
        try {
            Runtime runtime = Runtime.getRuntime();
            return com.kwad.sdk.crash.utils.g.d(runtime.exec("getprop " + str).getInputStream());
        } catch (IOException e) {
            com.kwad.sdk.core.e.b.printStackTrace(e);
            return null;
        }
    }

    @SuppressLint({"PrivateApi"})
    public static Object f(String str, Object... objArr) {
        try {
            if (aou == null) {
                aou = Class.forName("android.os.SystemProperties");
            }
            return q.c(aou, str, objArr);
        } catch (Throwable th) {
            com.kwad.sdk.core.e.b.printStackTrace(th);
            return null;
        }
    }

    public static String get(String str) {
        Object f = f("get", str);
        return f instanceof String ? (String) f : dV(str);
    }
}
