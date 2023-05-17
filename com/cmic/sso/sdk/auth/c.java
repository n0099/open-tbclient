package com.cmic.sso.sdk.auth;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.util.io.FileUtils;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static JSONObject a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("resultCode", "103000");
                jSONObject.put("desc", "true");
                jSONObject.put("securityphone", str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static JSONObject a(String str, com.cmic.sso.sdk.a aVar, JSONObject jSONObject) {
        InterceptResult invokeLLL;
        String b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, str, aVar, jSONObject)) == null) {
            String[] strArr = {FileUtils.UNKNOW, "移动", "联通", "电信"};
            try {
                b = aVar.b("operatortype", "0");
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (!"0".equals(b) && !TextUtils.isEmpty(b)) {
                jSONObject.put("operatorType", strArr[Integer.parseInt(b)]);
                return jSONObject;
            }
            if ("103000".equals(str)) {
                jSONObject.put("operatorType", strArr[1]);
            } else {
                jSONObject.put("operatorType", strArr[0]);
            }
            return jSONObject;
        }
        return (JSONObject) invokeLLL.objValue;
    }

    public static JSONObject a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("resultCode", str);
                jSONObject.put("desc", str2);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }

    public static JSONObject b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("resultCode", str);
                jSONObject.put("desc", str2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }

    public static JSONObject a(String str, String str2, com.cmic.sso.sdk.a aVar, JSONObject jSONObject) {
        InterceptResult invokeLLLL;
        String str3;
        String str4;
        String str5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65539, null, str, str2, aVar, jSONObject)) == null) {
            String str6 = "0";
            JSONObject jSONObject2 = new JSONObject();
            try {
                int parseInt = Integer.parseInt(aVar.b("authType", "0"));
                int c = aVar.c("networktype");
                if (parseInt == 3) {
                    if (c == 3) {
                        str4 = "WIFI下网关鉴权";
                        str5 = "1";
                    } else {
                        str4 = "网关鉴权";
                        str5 = "2";
                    }
                    String str7 = str5;
                    str3 = str4;
                    str6 = str7;
                } else {
                    str3 = "其他";
                }
                jSONObject2.put("resultCode", str);
                jSONObject2.put("authType", str6);
                jSONObject2.put("authTypeDes", str3);
                if ("103000".equals(str)) {
                    if (1 == aVar.c("logintype")) {
                        jSONObject2.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_OPEN_ID, aVar.b(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_OPEN_ID));
                        jSONObject2.put("securityphone", aVar.b("securityphone"));
                    }
                    jSONObject2.put("token", jSONObject.optString("token"));
                    jSONObject2.put("tokenExpiresIn", jSONObject.optString("tokenExpiresIn"));
                } else {
                    jSONObject2.put("desc", str2);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            com.cmic.sso.sdk.e.c.b("AuthnResult", "返回参数:" + jSONObject2.toString());
            return jSONObject2;
        }
        return (JSONObject) invokeLLLL.objValue;
    }
}
