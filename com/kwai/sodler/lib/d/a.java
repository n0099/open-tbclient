package com.kwai.sodler.lib.d;

import android.os.Build;
import android.os.Process;
import com.baidu.pass.biometrics.base.utils.PassBiometricUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.utils.q;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public static String a;
    public static String b;
    public static final Map<String, String> c;
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
        c = hashMap;
        hashMap.put("mips", "mips");
        c.put("mips64", "mips64");
        c.put("x86", "x86");
        c.put("x86_64", "x86_64");
        c.put("arm64", "arm64-v8a");
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? b() ? "arm64-v8a" : PassBiometricUtil.CPU_TYPE_ARMEABI_V7A : (String) invokeV.objValue;
    }

    public static boolean b() {
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
