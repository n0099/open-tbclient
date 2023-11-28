package com.kwad.sdk.api.loader;

import android.os.Build;
import android.os.Process;
import com.baidu.pass.biometrics.base.utils.PassBiometricUtil;
/* loaded from: classes10.dex */
public final class w {
    public static boolean is64Bit() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            return Process.is64Bit();
        }
        if (i >= 21) {
            try {
                return ((Boolean) Reflect.bX("dalvik.system.VMRuntime").ca("getRuntime").ca("is64Bit").get()).booleanValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static String xz() {
        if (is64Bit()) {
            return "arm64-v8a";
        }
        return PassBiometricUtil.CPU_TYPE_ARMEABI_V7A;
    }
}
