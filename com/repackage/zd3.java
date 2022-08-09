package com.repackage;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.util.io.JSONUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class zd3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755115896, "Lcom/repackage/zd3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755115896, "Lcom/repackage/zd3;");
                return;
            }
        }
        a = jh1.a;
    }

    public static <T> T a(JSONObject jSONObject, String str, Class<T> cls) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, jSONObject, str, cls)) == null) {
            if (jSONObject == null) {
                return null;
            }
            T t = (T) jSONObject.opt(str);
            if (cls.isInstance(t)) {
                if (a) {
                    String obj = t.toString();
                    if (((t instanceof JSONObject) || (t instanceof JSONArray)) && obj.length() > 30) {
                        obj = obj.substring(0, 30) + StringHelper.STRING_MORE;
                    }
                    if (a) {
                        Log.d(JSONUtils.TAG, "json: " + str + "=" + obj);
                    }
                }
                return t;
            }
            if (a) {
                if (t == null) {
                    Log.w(JSONUtils.TAG, "Json has no value by name: '" + str + "'!");
                } else {
                    Log.w(JSONUtils.TAG, "Value of '" + str + "' is not a instance of '" + cls.getSimpleName() + "'!");
                }
            }
            return null;
        }
        return (T) invokeLLL.objValue;
    }

    public static float b(JSONObject jSONObject, String str, float f) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{jSONObject, str, Float.valueOf(f)})) == null) ? jSONObject == null ? f : (float) jSONObject.optDouble(str, f) : invokeCommon.floatValue;
    }

    public static JSONArray c(JSONObject jSONObject, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, jSONObject, str)) == null) ? (JSONArray) a(jSONObject, str, JSONArray.class) : (JSONArray) invokeLL.objValue;
    }

    @NonNull
    public static JSONObject d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return new JSONObject();
            }
            try {
                return new JSONObject(str);
            } catch (JSONException e) {
                if (a) {
                    Log.w(JSONUtils.TAG, "JSONObject parsed error!!", e);
                }
                return new JSONObject();
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    public static JSONArray e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return new JSONArray();
            }
            try {
                return new JSONArray(str);
            } catch (JSONException e) {
                if (a) {
                    Log.w(JSONUtils.TAG, "JSONArray parsed error!!", e);
                }
                return new JSONArray();
            }
        }
        return (JSONArray) invokeL.objValue;
    }

    public static JSONObject f(JSONObject jSONObject, String str, Object obj) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, null, jSONObject, str, obj)) == null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            try {
                jSONObject.put(str, obj);
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeLLL.objValue;
    }
}
