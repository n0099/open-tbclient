package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.live.nps.LiveNPSPluginManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class jl {
    public static /* synthetic */ Interceptable $ic;
    public static Map<String, ml> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1964036349, "Lcom/repackage/jl;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1964036349, "Lcom/repackage/jl;");
                return;
            }
        }
        HashMap hashMap = new HashMap();
        a = hashMap;
        hashMap.put(LiveNPSPluginManager.NPS_PLUGIN_PKG_NAME, new il());
    }

    public static void a(String str, int i) {
        ml mlVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65537, null, str, i) == null) || (mlVar = a.get(str)) == null) {
            return;
        }
        mlVar.b(i);
    }

    public static void b(String str, int i, long j) {
        ml mlVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{str, Integer.valueOf(i), Long.valueOf(j)}) == null) || (mlVar = a.get(str)) == null) {
            return;
        }
        mlVar.c(i, j);
    }

    public static void c(String str, int i, int i2) {
        ml mlVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(65539, null, str, i, i2) == null) || (mlVar = a.get(str)) == null) {
            return;
        }
        mlVar.d(i, i2);
    }

    public static void d(String str, int i, int i2) {
        ml mlVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i, i2) == null) || (mlVar = a.get(str)) == null) {
            return;
        }
        mlVar.e(i, i2);
    }
}
