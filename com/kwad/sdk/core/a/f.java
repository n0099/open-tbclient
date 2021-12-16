package com.kwad.sdk.core.a;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.KsAdSDKImpl;
import com.yxcorp.kuaishou.addfp.KWEGIDDFP;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public final class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(String str) {
        InterceptResult invokeL;
        String doSign;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            Context context = KsAdSDKImpl.get().getContext();
            return (context == null || (doSign = KWEGIDDFP.doSign(context, str)) == null) ? "" : doSign;
        }
        return (String) invokeL.objValue;
    }

    public static List<String> a(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, map)) == null) {
            ArrayList arrayList = new ArrayList(map.size());
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                if (!b(key)) {
                    arrayList.add(key + "=" + c(entry.getValue()));
                }
            }
            try {
                Collections.sort(arrayList);
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static void a(String str, Map<String, String> map, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, str, map, str2) == null) {
            map.put("Ks-Sig1", a(b(str, new HashMap(), str2)));
        }
    }

    public static String b(String str, Map<String, String> map, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, str, map, str2)) == null) {
            List<String> a = a(map);
            return str + "&" + TextUtils.join("&", a) + "&" + str2;
        }
        return (String) invokeLLL.objValue;
    }

    public static boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? TextUtils.isEmpty(str) || str.startsWith("__") : invokeL.booleanValue;
    }

    public static String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) ? str == null ? "" : str : (String) invokeL.objValue;
    }
}
