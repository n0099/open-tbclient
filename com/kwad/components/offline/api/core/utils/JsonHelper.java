package com.kwad.components.offline.api.core.utils;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.offline.api.core.model.IOfflineCompoJsonParse;
import com.kwad.sdk.core.e.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class JsonHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public JsonHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static <T> List<T> jsonArrayToList(String str, Class<T> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, cls)) == null) {
            ArrayList arrayList = new ArrayList();
            if (TextUtils.isEmpty(str)) {
                return arrayList;
            }
            try {
                return jsonArrayToList(new JSONArray(str), cls);
            } catch (JSONException e) {
                b.printStackTraceOnly(e);
                return arrayList;
            }
        }
        return (List) invokeLL.objValue;
    }

    public static <T> List<T> jsonArrayToList(JSONArray jSONArray, Class<T> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONArray, cls)) == null) {
            ArrayList arrayList = new ArrayList();
            if (jSONArray != null && jSONArray.length() > 0) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    try {
                        Object obj = jSONArray.get(i);
                        if (obj != null) {
                            arrayList.add(obj);
                        }
                    } catch (Exception e) {
                        b.printStackTraceOnly(e);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static void merge(JSONObject jSONObject, JSONObject jSONObject2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, null, jSONObject, jSONObject2) == null) || jSONObject == null || jSONObject2 == null) {
            return;
        }
        Iterator<String> keys = jSONObject2.keys();
        while (keys.hasNext()) {
            String obj = keys.next().toString();
            Object opt = jSONObject2.opt(obj);
            if (opt != null) {
                try {
                    jSONObject.put(obj, opt);
                } catch (JSONException unused) {
                }
            }
        }
    }

    public static Map<String, String> parseJSON2MapString(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            try {
                return parseJSON2MapString(new JSONObject(str));
            } catch (JSONException unused) {
                return new HashMap();
            }
        }
        return (Map) invokeL.objValue;
    }

    public static Map<String, String> parseJSON2MapString(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, jSONObject)) == null) {
            HashMap hashMap = new HashMap();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                String str = "";
                String optString = jSONObject.optString(next, "");
                if (!TextUtils.isEmpty(optString) && !TextUtils.equals(StringUtil.NULL_STRING, optString)) {
                    str = optString;
                }
                hashMap.put(next, str);
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public static JSONObject parseMap2JSON(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, map)) == null) {
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

    public static void putValue(JSONArray jSONArray, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, jSONArray, jSONObject) == null) {
            jSONArray.put(jSONObject);
        }
    }

    public static void putValue(JSONObject jSONObject, String str, byte b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{jSONObject, str, Byte.valueOf(b)}) == null) {
            try {
                jSONObject.put(str, (int) b);
            } catch (JSONException unused) {
            }
        }
    }

    public static void putValue(JSONObject jSONObject, String str, double d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{jSONObject, str, Double.valueOf(d)}) == null) {
            try {
                jSONObject.put(str, d);
            } catch (JSONException unused) {
            }
        }
    }

    public static void putValue(JSONObject jSONObject, String str, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{jSONObject, str, Float.valueOf(f)}) == null) {
            try {
                jSONObject.put(str, f);
            } catch (JSONException unused) {
            }
        }
    }

    public static void putValue(JSONObject jSONObject, String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65547, null, jSONObject, str, i) == null) {
            try {
                jSONObject.put(str, i);
            } catch (JSONException unused) {
            }
        }
    }

    public static void putValue(JSONObject jSONObject, String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{jSONObject, str, Long.valueOf(j)}) == null) {
            try {
                jSONObject.put(str, j);
            } catch (JSONException unused) {
            }
        }
    }

    public static void putValue(JSONObject jSONObject, String str, IOfflineCompoJsonParse iOfflineCompoJsonParse) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65549, null, jSONObject, str, iOfflineCompoJsonParse) == null) || iOfflineCompoJsonParse == null) {
            return;
        }
        try {
            jSONObject.put(str, iOfflineCompoJsonParse.toJson());
        } catch (JSONException unused) {
        }
    }

    public static void putValue(JSONObject jSONObject, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65550, null, jSONObject, str, str2) == null) {
            try {
                jSONObject.put(str, str2);
            } catch (JSONException unused) {
            }
        }
    }

    public static void putValue(JSONObject jSONObject, String str, List<?> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65551, null, jSONObject, str, list) == null) || list == null) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        boolean z = false;
        for (Object obj : list) {
            if (obj instanceof IOfflineCompoJsonParse) {
                putValue(jSONArray, ((IOfflineCompoJsonParse) obj).toJson());
            } else if ((obj instanceof String) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof JSONObject) || (obj instanceof JSONArray) || (obj instanceof Double) || (obj instanceof Boolean)) {
                jSONArray.put(obj);
            } else {
                if (!(obj instanceof Float)) {
                    break;
                }
                try {
                    jSONArray.put(((Float) obj).floatValue());
                } catch (JSONException unused) {
                }
            }
            z = true;
        }
        if (z) {
            putValue(jSONObject, str, jSONArray);
        }
    }

    public static void putValue(JSONObject jSONObject, String str, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65552, null, jSONObject, str, jSONArray) == null) && jSONArray != null && jSONArray.length() != 0 && jSONObject != null && !TextUtils.isEmpty(str)) {
            try {
                jSONObject.put(str, jSONArray);
            } catch (JSONException unused) {
            }
        }
    }

    public static void putValue(JSONObject jSONObject, String str, JSONObject jSONObject2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65553, null, jSONObject, str, jSONObject2) == null) && jSONObject2 != null && jSONObject != null && !TextUtils.isEmpty(str)) {
            try {
                jSONObject.put(str, jSONObject2);
            } catch (JSONException unused) {
            }
        }
    }

    public static void putValue(JSONObject jSONObject, String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLZ(65554, null, jSONObject, str, z) == null) && jSONObject != null && !TextUtils.isEmpty(str)) {
            try {
                jSONObject.put(str, z);
            } catch (JSONException unused) {
            }
        }
    }

    public static JSONArray toJsonArray(@NonNull List<String> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, list)) == null) {
            JSONArray jSONArray = new JSONArray();
            for (String str : list) {
                jSONArray.put(str);
            }
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }

    public static <T extends IOfflineCompoJsonParse> JSONArray toJsonArrayForJsonParseList(@NonNull List<T> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, list)) == null) {
            JSONArray jSONArray = new JSONArray();
            for (T t : list) {
                jSONArray.put(t.toJson());
            }
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }
}
