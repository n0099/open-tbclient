package com.repackage;

import android.text.TextUtils;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Map;
/* loaded from: classes6.dex */
public class m43 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65536, null, str, map) == null) || TextUtils.isEmpty(str) || map == null) {
            return;
        }
        String f = me3.f(str);
        String o = me3.o(str);
        String b = b(f);
        if (TextUtils.equals(f, b)) {
            return;
        }
        if (!TextUtils.isEmpty(o)) {
            b = b + "?" + o;
        }
        map.put("pageRoutePath", b);
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? c(str, t03.J().r().P()) : (String) invokeL.objValue;
    }

    public static String c(String str, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, swanAppConfigData)) == null) {
            if (swanAppConfigData == null) {
                return str;
            }
            String f = bw2.f(str);
            return !TextUtils.isEmpty(f) ? f : swanAppConfigData.j(str);
        }
        return (String) invokeLL.objValue;
    }
}
