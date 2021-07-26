package d.a.o0.a.c2.f.p0;

import android.text.TextUtils;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.o0.a.v2.o0;
import java.util.Map;
/* loaded from: classes7.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65536, null, str, map) == null) || TextUtils.isEmpty(str) || map == null) {
            return;
        }
        String f2 = o0.f(str);
        String o = o0.o(str);
        String b2 = b(f2);
        if (TextUtils.equals(f2, b2)) {
            return;
        }
        if (!TextUtils.isEmpty(o)) {
            b2 = b2 + "?" + o;
        }
        map.put("pageRoutePath", b2);
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? c(str, d.a.o0.a.a2.d.g().r().F()) : (String) invokeL.objValue;
    }

    public static String c(String str, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, swanAppConfigData)) == null) ? swanAppConfigData == null ? str : swanAppConfigData.i(str) : (String) invokeLL.objValue;
    }
}
