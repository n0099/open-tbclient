package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.baidu.pass.biometrics.base.utils.PassBiometricUtil;
/* loaded from: classes5.dex */
public final class AbiUtil {
    public static Abi a;

    /* loaded from: classes5.dex */
    public enum Abi {
        UNKNOWN,
        ARMEABI_V7A,
        ARM64_V8A
    }

    public static String a(Context context) {
        return b(context) ? "arm64-v8a" : PassBiometricUtil.CPU_TYPE_ARMEABI_V7A;
    }

    public static boolean b(Context context) {
        return c(context) == Abi.ARM64_V8A;
    }

    public static Abi c(Context context) {
        Abi abi;
        Abi abi2 = a;
        if (abi2 != null) {
            return abi2;
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            if (i < 23) {
                if (i >= 21) {
                    try {
                        a = ((Boolean) q.a(q.a("dalvik.system.VMRuntime", "getRuntime", new Object[0]), "is64Bit", new Object[0])).booleanValue() ? Abi.ARM64_V8A : Abi.ARMEABI_V7A;
                    } catch (Throwable th) {
                        th.printStackTrace();
                        try {
                            a = context.getApplicationInfo().nativeLibraryDir.contains("arm64") ? Abi.ARM64_V8A : Abi.UNKNOWN;
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                            abi = Abi.UNKNOWN;
                        }
                    }
                }
                return a;
            } else if (Process.is64Bit()) {
                abi = Abi.ARM64_V8A;
            }
            a = abi;
            return a;
        }
        abi = Abi.ARMEABI_V7A;
        a = abi;
        return a;
    }
}
