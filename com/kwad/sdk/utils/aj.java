package com.kwad.sdk.utils;

import android.text.TextUtils;
import androidx.annotation.Nullable;
/* loaded from: classes5.dex */
public final class aj {
    public static <T> T a(T t) {
        return (T) a(t, "");
    }

    public static <T> T a(T t, @Nullable String str) {
        if (t == null) {
            a((RuntimeException) new NullPointerException("Argument cannot be null " + str));
        }
        return t;
    }

    public static String a(String str) {
        return a(str, "");
    }

    public static String a(String str, @Nullable String str2) {
        if (TextUtils.isEmpty(str)) {
            a((RuntimeException) new NullPointerException("Argument cannot be null " + str2));
        }
        return str;
    }

    public static void a(RuntimeException runtimeException) {
        com.kwad.sdk.core.d.b.a(runtimeException);
    }

    public static void a(boolean z, @Nullable Object obj) {
        if (z) {
            return;
        }
        a((RuntimeException) new IllegalArgumentException("Expression cannot be false " + obj));
    }

    public static void a(Object... objArr) {
        for (int i = 0; i < 2; i++) {
            a(objArr[i]);
        }
    }
}
