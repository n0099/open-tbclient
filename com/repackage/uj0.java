package com.repackage;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.provider.FontsContractCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.sdk.WebChromeClient;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class uj0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLL;
        double d;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, str, str2, str3, str4)) == null) {
            JSONObject jSONObject = new JSONObject();
            yx0.f(jSONObject, "downStatus", str);
            try {
                d = Double.parseDouble(str2) * 100.0d;
            } catch (Exception unused) {
                d = 0.0d;
            }
            yx0.e(jSONObject, "process", Math.round(d));
            yx0.f(jSONObject, "uri", str3);
            yx0.f(jSONObject, FontsContractCompat.Columns.FILE_ID, str4);
            return jSONObject.toString();
        }
        return (String) invokeLLLL.objValue;
    }

    public static void b(@Nullable zg0 zg0Var, boolean z, @Nullable Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{zg0Var, Boolean.valueOf(z), map}) == null) || zg0Var == null) {
            return;
        }
        if (map == null) {
            map = new HashMap<>();
        }
        zx0.e(map, "status", z ? "0" : "202");
        zx0.e(map, "message", z ? "调用成功" : "");
        zg0Var.a(z, map);
    }

    public static void c(@Nullable zg0 zg0Var, String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLLL(65538, null, zg0Var, str, str2, str3, str4) == null) || zg0Var == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(WebChromeClient.KEY_ARG_CALLBACK, str);
        JSONObject jSONObject = new JSONObject();
        yx0.f(jSONObject, "uri", str2);
        yx0.f(jSONObject, FontsContractCompat.Columns.FILE_ID, str3);
        yx0.f(jSONObject, "downStatus", str4);
        hashMap.put("data", jSONObject.toString());
        b(zg0Var, true, hashMap);
    }

    public static String d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? TextUtils.isEmpty(str) ? "" : yx0.c(str).optString("bt_info") : (String) invokeL.objValue;
    }
}
