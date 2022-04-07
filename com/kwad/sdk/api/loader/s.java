package com.kwad.sdk.api.loader;

import android.os.Build;
import android.os.Process;
import com.baidu.pass.biometrics.base.utils.PassBiometricUtil;
/* loaded from: classes5.dex */
public class s {
    public static boolean a() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            return Process.is64Bit();
        }
        if (i >= 21) {
            try {
                return ((Boolean) Reflect.a("dalvik.system.VMRuntime").d("getRuntime").d("is64Bit").a()).booleanValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static String b() {
        return a() ? "arm64-v8a" : PassBiometricUtil.CPU_TYPE_ARMEABI_V7A;
    }
}
