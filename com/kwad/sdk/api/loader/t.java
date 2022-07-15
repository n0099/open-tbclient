package com.kwad.sdk.api.loader;

import android.os.Build;
import android.os.Process;
/* loaded from: classes5.dex */
public final class t {
    public static boolean a() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            return Process.is64Bit();
        }
        if (i >= 21) {
            try {
                return ((Boolean) Reflect.a(Reflect.c("dalvik.system.VMRuntime")).b("getRuntime").b("is64Bit").a).booleanValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
