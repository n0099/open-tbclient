package com.kwad.sdk.api;

import androidx.annotation.Nullable;
import com.kwad.sdk.api.core.IKsAdSDK;
/* loaded from: classes10.dex */
public final class c {
    public static IKsAdSDK alt;

    public static void a(IKsAdSDK iKsAdSDK) {
        alt = iKsAdSDK;
    }

    public static String bR(String str) {
        return (String) c("TRANSFORM_API_HOST", str);
    }

    @Nullable
    public static <T> T c(String str, Object... objArr) {
        try {
            T t = (T) alt.dM(str, objArr);
            if (t != null) {
                return t;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static IKsAdSDK zc() {
        return alt;
    }

    public static boolean zd() {
        Boolean bool = (Boolean) c("enableDynamic", new Object[0]);
        if (bool == null || bool.booleanValue()) {
            return false;
        }
        return true;
    }

    public static int ze() {
        Integer num = (Integer) c("getAutoRevertTime", new Object[0]);
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }
}
