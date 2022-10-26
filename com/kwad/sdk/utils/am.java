package com.kwad.sdk.utils;

import android.text.TextUtils;
/* loaded from: classes8.dex */
public final class am {
    public static String T(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            a(new NullPointerException("Argument cannot be null " + str2));
        }
        return str;
    }

    public static void a(RuntimeException runtimeException) {
        com.kwad.sdk.core.e.b.printStackTrace(runtimeException);
    }

    public static void c(Object... objArr) {
        for (int i = 0; i < 2; i++) {
            checkNotNull(objArr[i]);
        }
    }

    public static void checkArgument(boolean z, Object obj) {
        if (z) {
            return;
        }
        a(new IllegalArgumentException("Expression cannot be false " + obj));
    }

    public static Object checkNotNull(Object obj) {
        return e(obj, "");
    }

    public static String dQ(String str) {
        return T(str, "");
    }

    public static Object e(Object obj, String str) {
        if (obj == null) {
            a(new NullPointerException("Argument cannot be null " + str));
        }
        return obj;
    }
}
