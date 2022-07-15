package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import com.baidu.sofire.sharedpreferences.SharedPreferenceManager;
import java.io.IOException;
/* loaded from: classes5.dex */
public final class au {
    public static Class<?> a;

    @SuppressLint({"PrivateApi"})
    public static Object a(String str, Object... objArr) {
        try {
            if (a == null) {
                a = Class.forName("android.os.SystemProperties");
            }
            return q.b(a, str, objArr);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.a(th);
            return null;
        }
    }

    public static String a(String str) {
        Object a2 = a(SharedPreferenceManager.OPERATION_GET_PERFIX, str);
        return a2 instanceof String ? (String) a2 : b(str);
    }

    public static String b(String str) {
        try {
            Runtime runtime = Runtime.getRuntime();
            return com.kwad.sdk.crash.utils.g.a(runtime.exec("getprop " + str).getInputStream());
        } catch (IOException e) {
            com.kwad.sdk.core.d.b.a(e);
            return null;
        }
    }
}
