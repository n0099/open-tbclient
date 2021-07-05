package com.kwad.sdk.utils;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class o {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T> List<T> a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            ArrayList arrayList = new ArrayList();
            if (TextUtils.isEmpty(str)) {
                return arrayList;
            }
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    Object obj = jSONArray.get(i2);
                    if (obj != null) {
                        arrayList.add(obj);
                    }
                }
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static JSONArray a(@NonNull List<String> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, list)) == null) {
            JSONArray jSONArray = new JSONArray();
            for (String str : list) {
                jSONArray.put(str);
            }
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }

    public static JSONObject a(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, map)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (map != null && !map.isEmpty()) {
                try {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        jSONObject.put(entry.getKey(), entry.getValue());
                    }
                } catch (Exception unused) {
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static void a(JSONArray jSONArray, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, jSONArray, jSONObject) == null) {
            jSONArray.put(jSONObject);
        }
    }

    public static void a(JSONObject jSONObject, String str, double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65540, null, new Object[]{jSONObject, str, Double.valueOf(d2)}) == null) {
            try {
                jSONObject.put(str, d2);
            } catch (JSONException unused) {
            }
        }
    }

    public static void a(JSONObject jSONObject, String str, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{jSONObject, str, Float.valueOf(f2)}) == null) {
            try {
                jSONObject.put(str, f2);
            } catch (JSONException unused) {
            }
        }
    }

    public static void a(JSONObject jSONObject, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(AdIconUtil.BAIDU_LOGO_ID, null, jSONObject, str, i2) == null) {
            try {
                jSONObject.put(str, i2);
            } catch (JSONException unused) {
            }
        }
    }

    public static void a(JSONObject jSONObject, String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{jSONObject, str, Long.valueOf(j)}) == null) {
            try {
                jSONObject.put(str, j);
            } catch (JSONException unused) {
            }
        }
    }

    public static void a(JSONObject jSONObject, String str, com.kwad.sdk.core.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65544, null, jSONObject, str, bVar) == null) || bVar == null) {
            return;
        }
        try {
            jSONObject.put(str, bVar.toJson());
        } catch (JSONException unused) {
        }
    }

    public static void a(JSONObject jSONObject, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65545, null, jSONObject, str, str2) == null) {
            try {
                jSONObject.put(str, str2);
            } catch (JSONException unused) {
            }
        }
    }

    public static void a(JSONObject jSONObject, String str, List<?> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65546, null, jSONObject, str, list) == null) || list == null) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        boolean z = false;
        for (Object obj : list) {
            if (!(obj instanceof com.kwad.sdk.core.b)) {
                if (!(obj instanceof String)) {
                    break;
                }
                jSONArray.put(obj);
            } else {
                a(jSONArray, ((com.kwad.sdk.core.b) obj).toJson());
            }
            z = true;
        }
        if (z) {
            a(jSONObject, str, jSONArray);
        }
    }

    public static void a(JSONObject jSONObject, String str, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65547, null, jSONObject, str, jSONArray) == null) {
            try {
                jSONObject.put(str, jSONArray);
            } catch (JSONException unused) {
            }
        }
    }

    public static void a(JSONObject jSONObject, String str, JSONObject jSONObject2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65548, null, jSONObject, str, jSONObject2) == null) {
            try {
                jSONObject.put(str, jSONObject2);
            } catch (JSONException unused) {
            }
        }
    }

    public static void a(JSONObject jSONObject, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65549, null, jSONObject, str, z) == null) {
            try {
                jSONObject.put(str, z);
            } catch (JSONException unused) {
            }
        }
    }

    public static Map<String, String> b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, str)) == null) {
            HashMap hashMap = new HashMap();
            try {
                JSONObject jSONObject = new JSONObject(str);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    String optString = jSONObject.optString(next, "");
                    if (TextUtils.isEmpty(optString) || TextUtils.equals(StringUtil.NULL_STRING, optString)) {
                        optString = "";
                    }
                    hashMap.put(next, optString);
                }
            } catch (JSONException unused) {
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }
}
