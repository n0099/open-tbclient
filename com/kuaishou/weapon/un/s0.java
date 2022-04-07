package com.kuaishou.weapon.un;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.connect.common.Constants;
import com.yy.hiidostatis.inner.BaseStatisContent;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class s0 {
    public static /* synthetic */ Interceptable $ic = null;
    public static String a = "appkey";
    public static String b = "secretkey";
    public static String c = "pver";
    public static String d = "sdkver";
    public static String e = "ksid";
    public static String f = "timestamp";
    public static String g = "sign";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(535003315, "Lcom/kuaishou/weapon/un/s0;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(535003315, "Lcom/kuaishou/weapon/un/s0;");
        }
    }

    public s0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static String a(Map map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, map)) == null) {
            StringBuilder sb = new StringBuilder();
            try {
                sb.append(map.get(a));
                sb.append(map.get(b));
                sb.append(map.get(f));
                return s1.a(sb.toString());
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static Map a(Context context) {
        String str;
        String str2;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            try {
                String[] a2 = l1.a(context);
                if (a2 == null || a2.length != 2 || TextUtils.isEmpty(a2[0]) || TextUtils.isEmpty(a2[1])) {
                    str = "16";
                    str2 = l1.d;
                } else {
                    str = a2[0];
                    str2 = a2[1];
                }
                HashMap hashMap = new HashMap();
                hashMap.put(a, str);
                hashMap.put(b, str2);
                hashMap.put(f, String.valueOf(System.currentTimeMillis() / 1000));
                hashMap.put(g, a(hashMap));
                return hashMap;
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (Map) invokeL.objValue;
    }

    public static void a(Context context, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, jSONObject) == null) {
            try {
                jSONObject.put("k", "");
                jSONObject.put("hp", context.getPackageName());
                jSONObject.put("hv", l1.e(context));
                jSONObject.put("pver", new d(context).a(d.U, d.S));
                jSONObject.put(Constants.PARAM_PLATFORM, 1);
                jSONObject.put("device_id", l1.g(context));
            } catch (Exception unused) {
            }
        }
    }

    public static JSONObject b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                a(context, jSONObject);
                jSONObject.put(BaseStatisContent.SDKVER, "2.8.3");
                jSONObject.put("piv", "v1");
                jSONObject.put("sysver", l1.m());
                jSONObject.put(SearchJsBridge.COOKIE_MOD, l1.j());
                return jSONObject;
            } catch (Exception e2) {
                l1.a(e2);
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    public static JSONObject c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                a(context, jSONObject);
                jSONObject.put(BaseStatisContent.SDKVER, "2.8.3");
                jSONObject.put("iv", "v1");
                return jSONObject;
            } catch (Exception e2) {
                l1.a(e2);
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    public static JSONObject d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("k", "");
                jSONObject.put("hp", context.getPackageName());
                jSONObject.put("hv", l1.e(context));
                try {
                    String a2 = new d(context).a(d.j0, d.S);
                    if (TextUtils.isEmpty(a2)) {
                        a2 = d.S;
                    }
                    jSONObject.put("pver", a2);
                } catch (Exception e2) {
                    jSONObject.put("pver", d.S);
                    x0.a(e2);
                }
                jSONObject.put(Constants.PARAM_PLATFORM, 1);
                jSONObject.put(BaseStatisContent.SDKVER, "2.8.3");
                jSONObject.put("device_id", l1.g(context));
                jSONObject.put("iv", "v1");
                return jSONObject;
            } catch (Exception e3) {
                x0.a(e3);
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    public static String e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            Map a2 = a(context);
            if (a2 == null || a2.size() < 1) {
                return null;
            }
            String str = "";
            for (Map.Entry entry : a2.entrySet()) {
                str = str + "&" + ((String) entry.getKey()) + "=" + ((String) entry.getValue());
            }
            return str.substring(1);
        }
        return (String) invokeL.objValue;
    }
}
