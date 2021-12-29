package com.kwad.sdk.utils;

import android.os.Build;
import android.os.Process;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.loader.Reflect;
/* loaded from: classes3.dex */
public final class AbiUtil {
    public static Abi a;

    /* loaded from: classes3.dex */
    public enum Abi {
        UNKNOWN,
        ARMEABI_V7A,
        ARM64_V8A
    }

    public static String a() {
        return b() ? "arm64-v8a" : "armeabi-v7a";
    }

    public static boolean b() {
        return c() == Abi.ARM64_V8A;
    }

    public static Abi c() {
        Abi abi;
        Abi abi2 = a;
        if (abi2 != null) {
            return abi2;
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            if (i2 < 23) {
                if (i2 >= 21) {
                    try {
                        a = ((Boolean) Reflect.a("dalvik.system.VMRuntime").d("getRuntime").d("is64Bit").a()).booleanValue() ? Abi.ARM64_V8A : Abi.ARMEABI_V7A;
                    } catch (Throwable th) {
                        th.printStackTrace();
                        try {
                            a = KsAdSDKImpl.get().getContext().getApplicationInfo().nativeLibraryDir.contains("arm64") ? Abi.ARM64_V8A : Abi.UNKNOWN;
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
