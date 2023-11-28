package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.baidu.pass.biometrics.base.utils.PassBiometricUtil;
/* loaded from: classes10.dex */
public final class AbiUtil {
    public static Abi aMB;

    /* loaded from: classes10.dex */
    public enum Abi {
        UNKNOWN,
        ARMEABI_V7A,
        ARM64_V8A
    }

    public static String bD(Context context) {
        if (isArm64(context)) {
            return "arm64-v8a";
        }
        return PassBiometricUtil.CPU_TYPE_ARMEABI_V7A;
    }

    public static boolean isArm64(Context context) {
        if (bE(context) == Abi.ARM64_V8A) {
            return true;
        }
        return false;
    }

    public static Abi bE(Context context) {
        Abi abi;
        Abi abi2;
        Abi abi3 = aMB;
        if (abi3 != null) {
            return abi3;
        }
        int i = Build.VERSION.SDK_INT;
        if (i < 21) {
            aMB = Abi.ARMEABI_V7A;
        } else if (i >= 23) {
            if (Process.is64Bit()) {
                abi2 = Abi.ARM64_V8A;
            } else {
                abi2 = Abi.ARMEABI_V7A;
            }
            aMB = abi2;
        } else if (i >= 21) {
            try {
                if (((Boolean) s.callMethod(s.a("dalvik.system.VMRuntime", "getRuntime", new Object[0]), "is64Bit", new Object[0])).booleanValue()) {
                    abi = Abi.ARM64_V8A;
                } else {
                    abi = Abi.ARMEABI_V7A;
                }
                aMB = abi;
            } catch (Throwable th) {
                th.printStackTrace();
                try {
                    if (context.getApplicationInfo().nativeLibraryDir.contains("arm64")) {
                        aMB = Abi.ARM64_V8A;
                    } else {
                        aMB = Abi.UNKNOWN;
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                    aMB = Abi.UNKNOWN;
                }
            }
        }
        return aMB;
    }
}
