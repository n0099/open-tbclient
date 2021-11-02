package com.kwad.sdk.core.b;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.KsAdSDKImpl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(String str) {
        InterceptResult invokeL;
        String c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            Context context = KsAdSDKImpl.get().getContext();
            return (context == null || (c2 = b.r.a.a.b.c(context, str)) == null) ? "" : c2;
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

    public static void a(String str, Map<String, String> map, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, str, map, jSONObject) == null) {
            map.put("Ks-Sig1", a(b(str, new HashMap(), jSONObject)));
        }
    }

    public static String b(String str, Map<String, String> map, JSONObject jSONObject) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, str, map, jSONObject)) == null) {
            List<String> a2 = a(map);
            return str + "&" + TextUtils.join("&", a2) + "&" + jSONObject.toString();
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
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) ? str == null ? "" : str : (String) invokeL.objValue;
    }
}
