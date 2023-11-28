package com.kwad.library.solder.lib.d;

import android.os.Build;
import android.os.Process;
import com.baidu.android.util.devices.IDevices;
import com.baidu.pass.biometrics.base.utils.PassBiometricUtil;
import com.kwad.sdk.utils.s;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public final class a {
    public static String ajW;
    public static String ajX;
    public static final Map<String, String> ajY;

    static {
        HashMap hashMap = new HashMap();
        ajY = hashMap;
        hashMap.put(IDevices.ABI_MIPS, IDevices.ABI_MIPS);
        ajY.put("mips64", "mips64");
        ajY.put("x86", "x86");
        ajY.put("x86_64", "x86_64");
        ajY.put("arm64", "arm64-v8a");
    }

    public static String xz() {
        if (is64Bit()) {
            return "arm64-v8a";
        }
        return PassBiometricUtil.CPU_TYPE_ARMEABI_V7A;
    }

    public static boolean is64Bit() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            return Process.is64Bit();
        }
        if (i < 21) {
            return false;
        }
        Boolean bool = null;
        try {
            bool = (Boolean) s.callMethod(s.a("dalvik.system.VMRuntime", "getRuntime", new Object[0]), "is64Bit", new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }
}
