package com.repackage;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class cc4 {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<String, dc4> a;
    public static HashMap<String, dc4> b;
    public transient /* synthetic */ FieldHolder $fh;

    public cc4() {
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

    @NonNull
    public static dc4 a(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (a == null) {
                synchronized (cc4.class) {
                    if (a == null) {
                        HashMap<String, dc4> hashMap = new HashMap<>();
                        a = hashMap;
                        e(hashMap, "download_api_ctrl");
                    }
                }
            }
            return c(str, a);
        }
        return (dc4) invokeL.objValue;
    }

    @NonNull
    public static dc4 b(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (b == null) {
                synchronized (cc4.class) {
                    if (b == null) {
                        HashMap<String, dc4> hashMap = new HashMap<>();
                        b = hashMap;
                        e(hashMap, "preload_api_ctrl");
                    }
                }
            }
            return c(str, b);
        }
        return (dc4) invokeL.objValue;
    }

    @NonNull
    public static dc4 c(@Nullable String str, @NonNull HashMap<String, dc4> hashMap) {
        InterceptResult invokeLL;
        dc4 dc4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, hashMap)) == null) {
            if (TextUtils.isEmpty(str) || (dc4Var = hashMap.get(str)) == null) {
                dc4 dc4Var2 = hashMap.get("default");
                return dc4Var2 != null ? dc4Var2 : dc4.a();
            }
            return dc4Var;
        }
        return (dc4) invokeLL.objValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? b74.c().a("SwanDownloadApiStrategy").getString("version", "0") : (String) invokeV.objValue;
    }

    public static void e(@NonNull HashMap<String, dc4> hashMap, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, hashMap, str) == null) {
            try {
                JSONObject optJSONObject = new JSONObject(b74.c().a("SwanDownloadApiStrategy").getString("data", StringUtil.EMPTY_ARRAY)).optJSONObject(str);
                if (optJSONObject != null) {
                    Iterator<String> keys = optJSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        if (!TextUtils.isEmpty(next)) {
                            hashMap.put(next, dc4.b(optJSONObject.optJSONObject(next)));
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static void f(@Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65542, null, jSONObject) == null) || jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("version");
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        sf4 a2 = b74.c().a("SwanDownloadApiStrategy");
        a2.putString("version", optString);
        a2.putString("data", optJSONObject != null ? optJSONObject.toString() : null);
    }
}
