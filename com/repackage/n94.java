package com.repackage;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Map;
/* loaded from: classes6.dex */
public class n94 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            String a = og4.a(og4.a(og4.a(og4.a(og4.a(og4.a(og4.a(og4.a(og4.a(og4.a(og4.a(str, "cuid", q74.b().g()), "uuid", q74.b().e()), "ut", q74.b().I()), "ua", og4.b(q74.b().h())), "host_app", q74.b().c()), "host_app_ver", q74.b().h()), "host_os", gg4.f()), "host_os_ver", gg4.g()), "network", gg4.e()), "sdk_ver", q74.b().b()), "ut_score", String.valueOf(q74.b().a()));
            String q = q74.b().q();
            return !TextUtils.isEmpty(q) ? og4.a(a, "sid", q) : a;
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
                        str = og4.a(str, str2, map.get(str2));
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
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return h() + "/getopenbundleid";
        }
        return (String) invokeV.objValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return h() + "/fetchpkglist";
        }
        return (String) invokeV.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return h() + "/getpkg";
        }
        return (String) invokeV.objValue;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return h() + "/getplugin";
        }
        return (String) invokeV.objValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return h() + "/updatecore";
        }
        return (String) invokeV.objValue;
    }

    public static String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? q74.b().E() : (String) invokeV.objValue;
    }

    public static String i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) ? a(str) : (String) invokeL.objValue;
    }

    public static String j(String str, Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, str, map)) == null) ? b(a(str), map) : (String) invokeLL.objValue;
    }
}
