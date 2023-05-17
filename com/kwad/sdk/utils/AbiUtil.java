package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.baidu.pass.biometrics.base.utils.PassBiometricUtil;
/* loaded from: classes9.dex */
public final class AbiUtil {
    public static Abi amH;

    /* loaded from: classes9.dex */
    public enum Abi {
        UNKNOWN,
        ARMEABI_V7A,
        ARM64_V8A
    }

    public static String bO(Context context) {
        return isArm64(context) ? "arm64-v8a" : PassBiometricUtil.CPU_TYPE_ARMEABI_V7A;
    }

    public static Abi bP(Context context) {
        Abi abi;
        Abi abi2 = amH;
        if (abi2 != null) {
            return abi2;
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            if (i < 23) {
                if (i >= 21) {
                    try {
                        amH = ((Boolean) q.a(q.a("dalvik.system.VMRuntime", "getRuntime", new Object[0]), "is64Bit", new Object[0])).booleanValue() ? Abi.ARM64_V8A : Abi.ARMEABI_V7A;
                    } catch (Throwable th) {
                        th.printStackTrace();
                        try {
                            amH = context.getApplicationInfo().nativeLibraryDir.contains("arm64") ? Abi.ARM64_V8A : Abi.UNKNOWN;
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                            abi = Abi.UNKNOWN;
                        }
                    }
                }
                return amH;
            } else if (Process.is64Bit()) {
                abi = Abi.ARM64_V8A;
            }
            amH = abi;
            return amH;
        }
        abi = Abi.ARMEABI_V7A;
        amH = abi;
        return amH;
    }

    public static boolean isArm64(Context context) {
        return bP(context) == Abi.ARM64_V8A;
    }
}
