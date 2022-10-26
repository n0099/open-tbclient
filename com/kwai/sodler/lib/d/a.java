package com.kwai.sodler.lib.d;

import android.os.Build;
import android.os.Process;
import com.baidu.android.util.devices.IDevices;
import com.baidu.pass.biometrics.base.utils.PassBiometricUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.utils.q;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public static String ayJ;
    public static String ayK;
    public static final Map ayL;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2133720532, "Lcom/kwai/sodler/lib/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2133720532, "Lcom/kwai/sodler/lib/d/a;");
                return;
            }
        }
        HashMap hashMap = new HashMap();
        ayL = hashMap;
        hashMap.put(IDevices.ABI_MIPS, IDevices.ABI_MIPS);
        ayL.put("mips64", "mips64");
        ayL.put("x86", "x86");
        ayL.put("x86_64", "x86_64");
        ayL.put("arm64", "arm64-v8a");
    }

    public static String FH() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? is64Bit() ? "arm64-v8a" : PassBiometricUtil.CPU_TYPE_ARMEABI_V7A : (String) invokeV.objValue;
    }

    public static boolean is64Bit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 23) {
                return Process.is64Bit();
            }
            if (i >= 21) {
                Boolean bool = null;
                try {
                    bool = (Boolean) q.a(q.a("dalvik.system.VMRuntime", "getRuntime", new Object[0]), "is64Bit", new Object[0]);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (bool != null) {
                    return bool.booleanValue();
                }
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
