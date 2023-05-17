package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes9.dex */
public class w {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static Map<String, List<q>> a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, str)) == null) {
            if (context == null) {
                return null;
            }
            Map<String, ?> a = g0.a(context, str);
            b(a);
            return a(a);
        }
        return (Map) invokeLL.objValue;
    }

    public static Map<String, List<q>> a(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Map<String, List<q>> a;
        Map<String, List<q>> a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, context, str, str2)) == null) {
            if ("alltype".equals(str2) || TextUtils.isEmpty(str)) {
                y.c("hmsSdk", "read all event records");
                a = a(context, "stat_v2_1");
                a2 = a(context, "cached_v2_1");
            } else {
                String a3 = u0.a(str, str2);
                a = b(context, "stat_v2_1", a3);
                a2 = b(context, "cached_v2_1", a3);
            }
            return a(a, a2);
        }
        return (Map) invokeLLL.objValue;
    }

    public static Map<String, List<q>> a(Map<String, ?> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, map)) == null) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, ?> entry : map.entrySet()) {
                String key = entry.getKey();
                if (entry.getValue() instanceof String) {
                    a(key, (String) entry.getValue(), hashMap);
                }
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public static Map<String, List<q>> a(Map<String, List<q>> map, Map<String, List<q>> map2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, map, map2)) == null) {
            if (map.size() == 0 && map2.size() == 0) {
                return new HashMap();
            }
            if (map.size() == 0) {
                return map2;
            }
            if (map2.size() == 0) {
                return map;
            }
            HashMap hashMap = new HashMap(map);
            hashMap.putAll(map2);
            return hashMap;
        }
        return (Map) invokeLL.objValue;
    }

    public static void a(String str, String str2, Map<String, List<q>> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2, map) == null) {
            ArrayList arrayList = new ArrayList();
            try {
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                JSONArray jSONArray = new JSONArray(str2);
                if (jSONArray.length() == 0) {
                    return;
                }
                for (int i = 0; i < jSONArray.length(); i++) {
                    q qVar = new q();
                    try {
                        qVar.a(jSONArray.getJSONObject(i));
                        arrayList.add(qVar);
                    } catch (JSONException unused) {
                        y.e("hmsSdk", "JSON Exception happened when create data for report - readDataToRecord");
                    }
                }
                map.put(str, arrayList);
            } catch (JSONException unused2) {
                y.e("hmsSdk", "When events turn to JSONArray,JSON Exception has happened");
            }
        }
    }

    public static Map<String, List<q>> b(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, context, str, str2)) == null) {
            String a = g0.a(context, str, str2, "");
            HashMap hashMap = new HashMap();
            a(str2, a, hashMap);
            return hashMap;
        }
        return (Map) invokeLLL.objValue;
    }

    public static void b(Map<String, ?> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, map) == null) {
            Iterator<Map.Entry<String, ?>> it = map.entrySet().iterator();
            Set<String> a = u0.a(b.b());
            while (it.hasNext()) {
                if (!a.contains(it.next().getKey())) {
                    it.remove();
                }
            }
        }
    }
}
