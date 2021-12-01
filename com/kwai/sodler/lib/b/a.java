package com.kwai.sodler.lib.b;

import android.os.Build;
import android.os.Process;
import com.baidu.android.util.devices.IDevices;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static String a;

    /* renamed from: b  reason: collision with root package name */
    public static String f60090b;

    /* renamed from: c  reason: collision with root package name */
    public static final Map<String, String> f60091c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2133780114, "Lcom/kwai/sodler/lib/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2133780114, "Lcom/kwai/sodler/lib/b/a;");
                return;
            }
        }
        HashMap hashMap = new HashMap();
        f60091c = hashMap;
        hashMap.put(IDevices.ABI_MIPS, IDevices.ABI_MIPS);
        f60091c.put("mips64", "mips64");
        f60091c.put("x86", "x86");
        f60091c.put("x86_64", "x86_64");
        f60091c.put("arm64", "arm64-v8a");
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 23) {
                return Process.is64Bit();
            }
            if (i2 >= 21) {
                Boolean bool = null;
                try {
                    Class<?> cls = Class.forName("dalvik.system.VMRuntime");
                    Method declaredMethod = cls.getDeclaredMethod("getRuntime", new Class[0]);
                    declaredMethod.setAccessible(true);
                    Object invoke = declaredMethod.invoke(null, new Object[0]);
                    Method declaredMethod2 = cls.getDeclaredMethod("is64Bit", new Class[0]);
                    declaredMethod2.setAccessible(true);
                    bool = (Boolean) declaredMethod2.invoke(invoke, new Object[0]);
                } catch (Exception e2) {
                    e2.printStackTrace();
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

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a() ? "arm64-v8a" : "armeabi-v7a" : (String) invokeV.objValue;
    }
}
