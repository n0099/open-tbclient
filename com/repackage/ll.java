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
public class ll {
    public static /* synthetic */ Interceptable $ic;
    public static Map<String, ol> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1964034427, "Lcom/repackage/ll;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1964034427, "Lcom/repackage/ll;");
                return;
            }
        }
        HashMap hashMap = new HashMap();
        a = hashMap;
        hashMap.put(LiveNPSPluginManager.NPS_PLUGIN_PKG_NAME, new kl());
    }

    public static void a(String str, int i) {
        ol olVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65537, null, str, i) == null) || (olVar = a.get(str)) == null) {
            return;
        }
        olVar.b(i);
    }

    public static void b(String str, int i, long j) {
        ol olVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{str, Integer.valueOf(i), Long.valueOf(j)}) == null) || (olVar = a.get(str)) == null) {
            return;
        }
        olVar.c(i, j);
    }

    public static void c(String str, int i, int i2) {
        ol olVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(65539, null, str, i, i2) == null) || (olVar = a.get(str)) == null) {
            return;
        }
        olVar.d(i, i2);
    }

    public static void d(String str, int i, int i2) {
        ol olVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i, i2) == null) || (olVar = a.get(str)) == null) {
            return;
        }
        olVar.e(i, i2);
    }
}
