package com.kwad.sdk.e;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T extends c> List<T> a(String str, @NonNull d<T> dVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, str, dVar)) == null) {
            ArrayList arrayList = new ArrayList();
            if (TextUtils.isEmpty(str)) {
                return arrayList;
            }
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    T createInstance = dVar.createInstance();
                    createInstance.parseJson(jSONObject);
                    arrayList.add(createInstance);
                }
            } catch (Exception unused) {
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static <T> JSONArray a(@NonNull Set<T> set) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, set)) == null) {
            JSONArray jSONArray = new JSONArray();
            for (Object obj : set) {
                if (!(obj instanceof JSONObject)) {
                    if (obj instanceof c) {
                        obj = ((c) obj).toJson();
                    }
                }
                jSONArray.put(obj);
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

    public static void a(JSONObject jSONObject, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65539, null, jSONObject, str, i2) == null) {
            try {
                jSONObject.put(str, i2);
            } catch (JSONException unused) {
            }
        }
    }

    public static void a(JSONObject jSONObject, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject, str, str2) == null) {
            try {
                jSONObject.put(str, str2);
            } catch (JSONException unused) {
            }
        }
    }

    public static void a(JSONObject jSONObject, String str, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65541, null, jSONObject, str, jSONArray) == null) && jSONArray != null && jSONArray.length() != 0 && jSONObject != null && !TextUtils.isEmpty(str)) {
            try {
                jSONObject.put(str, jSONArray);
            } catch (JSONException unused) {
            }
        }
    }

    public static void a(JSONObject jSONObject, String str, JSONObject jSONObject2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65542, null, jSONObject, str, jSONObject2) == null) && jSONObject2 != null && jSONObject != null && !TextUtils.isEmpty(str)) {
            try {
                jSONObject.put(str, jSONObject2);
            } catch (JSONException unused) {
            }
        }
    }

    public static void a(JSONObject jSONObject, String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLZ(65543, null, jSONObject, str, z) == null) && jSONObject != null && !TextUtils.isEmpty(str)) {
            try {
                jSONObject.put(str, z);
            } catch (JSONException unused) {
            }
        }
    }
}
