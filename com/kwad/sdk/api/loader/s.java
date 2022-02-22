package com.kwad.sdk.api.loader;

import android.os.Build;
import android.os.Process;
/* loaded from: classes4.dex */
public class s {
    public static boolean a() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23) {
            return Process.is64Bit();
        }
        if (i2 >= 21) {
            try {
                return ((Boolean) Reflect.a("dalvik.system.VMRuntime").d("getRuntime").d("is64Bit").a()).booleanValue();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }

    public static String b() {
        return a() ? "arm64-v8a" : "armeabi-v7a";
    }
}
