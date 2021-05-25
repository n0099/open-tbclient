package com.kwad.sdk.crash.utils;

import android.os.Build;
import com.kwad.sdk.utils.n;
/* loaded from: classes6.dex */
public final class AbiUtil {

    /* renamed from: a  reason: collision with root package name */
    public static Abi f33003a;

    /* loaded from: classes6.dex */
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
        if (Build.VERSION.SDK_INT < 21) {
            return Abi.ARMEABI_V7A;
        }
        Abi abi = f33003a;
        if (abi != null) {
            return abi;
        }
        try {
            Abi abi2 = ((Boolean) n.a(n.a("dalvik.system.VMRuntime", "getRuntime", new Object[0]), "is64Bit", new Object[0])).booleanValue() ? Abi.ARM64_V8A : Abi.ARMEABI_V7A;
            f33003a = abi2;
            return abi2;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.a.b(th);
            try {
                if (com.kwad.sdk.crash.d.a().f().getApplicationInfo().nativeLibraryDir.contains("arm64")) {
                    Abi abi3 = Abi.ARM64_V8A;
                    f33003a = abi3;
                    return abi3;
                }
            } catch (Throwable th2) {
                com.kwad.sdk.core.d.a.b(th2);
            }
            Abi abi4 = Abi.UNKNOWN;
            f33003a = abi4;
            return abi4;
        }
    }
}
