package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.common.security.CacheDeviceInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.tencent.connect.common.Constants;
import com.yy.hiidostatis.inner.BaseStatisContent;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class w2 {
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
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(334603164, "Lcom/kuaishou/weapon/p0/w2;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(334603164, "Lcom/kuaishou/weapon/p0/w2;");
        }
    }

    public w2() {
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
                return g.a(sb.toString());
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static Map a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            try {
                String str = WeaponHI.sKSAppkey;
                String str2 = WeaponHI.sKSSecKey;
                HashMap hashMap = new HashMap();
                hashMap.put(a, str);
                hashMap.put(b, str2);
                hashMap.put(f, String.valueOf(System.currentTimeMillis() / 1000));
                hashMap.put(g, a(hashMap));
                return hashMap;
            } catch (Exception unused) {
                return null;
            }
        }
        return (Map) invokeL.objValue;
    }

    public static void a(Context context, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, jSONObject) == null) {
            try {
                jSONObject.put("k", t1.a(context));
                jSONObject.put("hp", context.getPackageName());
                jSONObject.put(CacheDeviceInfo.JSON_KEY_HARMONY_VERSION, h1.m(context));
                jSONObject.put("dpver", i.a(context, "re_po_rt").a(f3.i, q1.e));
                jSONObject.put(Constants.PARAM_PLATFORM, 1);
                jSONObject.put(PushConstants.URI_PACKAGE_NAME, "p0");
            } catch (Exception unused) {
            }
        }
    }

    public static String b(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, map)) == null) {
            String str = "";
            for (Map.Entry<String, String> entry : map.entrySet()) {
                str = str + "&" + entry.getKey() + "=" + entry.getValue();
            }
            return str.substring(1);
        }
        return (String) invokeL.objValue;
    }

    public static JSONObject b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                a(context, jSONObject);
                jSONObject.put(BaseStatisContent.SDKVER, WeaponHI.sKSSdkver);
                jSONObject.put("pluginver", "5.0.1");
                jSONObject.put("device_id", n2.b(context));
                jSONObject.put("iv", "v1");
                return jSONObject;
            } catch (Exception unused) {
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    public static JSONObject c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("k", t1.a(context));
                jSONObject.put("hp", context.getPackageName());
                jSONObject.put(CacheDeviceInfo.JSON_KEY_HARMONY_VERSION, h1.m(context));
                try {
                    String a2 = i.a(context, "re_po_rt").a(f3.k, q1.e);
                    if (TextUtils.isEmpty(a2)) {
                        a2 = q1.e;
                    }
                    jSONObject.put("pver", a2);
                } catch (Exception unused) {
                    jSONObject.put("pver", q1.e);
                }
                jSONObject.put(Constants.PARAM_PLATFORM, 1);
                jSONObject.put(PushConstants.URI_PACKAGE_NAME, "p0");
                jSONObject.put(BaseStatisContent.SDKVER, WeaponHI.sKSSdkver);
                jSONObject.put("pluginver", "5.0.1");
                jSONObject.put("device_id", n2.b(context));
                jSONObject.put("iv", "v1");
                return jSONObject;
            } catch (Exception unused2) {
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    public static String d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            Map a2 = a(context);
            if (a2 == null || a2.size() <= 0) {
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
