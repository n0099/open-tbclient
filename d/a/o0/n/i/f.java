package d.a.o0.n.i;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.o0.t.i;
import java.util.Map;
/* loaded from: classes7.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            String a2 = i.a(i.a(i.a(i.a(i.a(i.a(i.a(i.a(i.a(i.a(i.a(str, "cuid", d.a.o0.n.c.b().h()), "uuid", d.a.o0.n.c.b().e()), "ut", d.a.o0.n.c.b().E()), "ua", i.b(d.a.o0.n.c.b().i())), "host_app", d.a.o0.n.c.b().c()), "host_app_ver", d.a.o0.n.c.b().i()), "host_os", d.a.o0.t.a.f()), "host_os_ver", d.a.o0.t.a.g()), "network", d.a.o0.t.a.e()), "sdk_ver", d.a.o0.n.c.b().b()), "ut_score", String.valueOf(d.a.o0.n.c.b().a()));
            String q = d.a.o0.n.c.b().q();
            return !TextUtils.isEmpty(q) ? i.a(a2, "sid", q) : a2;
        }
        return (String) invokeL.objValue;
    }

    public static String b(String str, Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, map)) == null) {
            if (map != null) {
                for (String str2 : map.keySet()) {
                    if (!TextUtils.isEmpty(map.get(str2))) {
                        str = i.a(str, str2, map.get(str2));
                    }
                }
            }
            return str;
        }
        return (String) invokeLL.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? String.format("%s/fetchpkglist", g()) : (String) invokeV.objValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? String.format("%s/getpkg", g()) : (String) invokeV.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? String.format("%s/getplugin", g()) : (String) invokeV.objValue;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? String.format("%s/updatecore", g()) : (String) invokeV.objValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? d.a.o0.n.c.b().B() : (String) invokeV.objValue;
    }

    public static String h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) ? a(str) : (String) invokeL.objValue;
    }

    public static String i(String str, Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, str, map)) == null) ? b(a(str), map) : (String) invokeLL.objValue;
    }
}
