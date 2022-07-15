package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
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
/* renamed from: com.kuaishou.weapon.p0.ʽʾ  reason: contains not printable characters */
/* loaded from: classes5.dex */
public class C0355 {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: ʻ  reason: contains not printable characters */
    public static String f178 = "appkey";

    /* renamed from: ʼ  reason: contains not printable characters */
    public static String f179 = "secretkey";

    /* renamed from: ʽ  reason: contains not printable characters */
    public static String f180 = "pver";

    /* renamed from: ʾ  reason: contains not printable characters */
    public static String f181 = "sdkver";

    /* renamed from: ʿ  reason: contains not printable characters */
    public static String f182 = "ksid";

    /* renamed from: ˆ  reason: contains not printable characters */
    public static String f183 = "timestamp";

    /* renamed from: ˈ  reason: contains not printable characters */
    public static String f184 = "sign";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(335182678, "Lcom/kuaishou/weapon/p0/ʽʾ;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(335182678, "Lcom/kuaishou/weapon/p0/ʽʾ;");
        }
    }

    public C0355() {
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

    /* renamed from: ʻ  reason: contains not printable characters */
    public static String m357(Map map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, map)) == null) {
            StringBuilder sb = new StringBuilder();
            try {
                sb.append(map.get(f178));
                sb.append(map.get(f179));
                sb.append(map.get(f183));
                return C0304.m174(sb.toString());
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public static Map m358(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            try {
                String str = WeaponHI.sKSAppkey;
                String str2 = WeaponHI.sKSSecKey;
                HashMap hashMap = new HashMap();
                hashMap.put(f178, str);
                hashMap.put(f179, str2);
                hashMap.put(f183, String.valueOf(System.currentTimeMillis() / 1000));
                hashMap.put(f184, m357(hashMap));
                return hashMap;
            } catch (Exception unused) {
                return null;
            }
        }
        return (Map) invokeL.objValue;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public static void m359(Context context, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, jSONObject) == null) {
            try {
                jSONObject.put("k", C0310.m205(context));
                jSONObject.put("hp", context.getPackageName());
                jSONObject.put("hv", C0433.m891(context));
                jSONObject.put("dpver", C0374.m389(context).m395(C0374.f301, C0303.f37));
                jSONObject.put(Constants.PARAM_PLATFORM, 1);
                jSONObject.put(PushConstants.URI_PACKAGE_NAME, "p0");
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public static String m360(Map<String, String> map) {
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

    /* renamed from: ʼ  reason: contains not printable characters */
    public static JSONObject m361(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                m359(context, jSONObject);
                jSONObject.put(BaseStatisContent.SDKVER, WeaponHI.sKSSdkver);
                jSONObject.put("pluginver", "5.0.0");
                jSONObject.put("device_id", C0333.m249(context));
                jSONObject.put("iv", "v1");
                return jSONObject;
            } catch (Exception unused) {
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public static JSONObject m362(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("k", C0310.m205(context));
                jSONObject.put("hp", context.getPackageName());
                jSONObject.put("hv", C0433.m891(context));
                try {
                    String m395 = C0374.m389(context).m395(C0374.f305, C0303.f37);
                    if (TextUtils.isEmpty(m395)) {
                        m395 = C0303.f37;
                    }
                    jSONObject.put("pver", m395);
                } catch (Exception unused) {
                    jSONObject.put("pver", C0303.f37);
                }
                jSONObject.put(Constants.PARAM_PLATFORM, 1);
                jSONObject.put(PushConstants.URI_PACKAGE_NAME, "p0");
                jSONObject.put(BaseStatisContent.SDKVER, WeaponHI.sKSSdkver);
                jSONObject.put("pluginver", "5.0.0");
                jSONObject.put("device_id", C0333.m249(context));
                jSONObject.put("iv", "v1");
                return jSONObject;
            } catch (Exception unused2) {
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    /* renamed from: ʾ  reason: contains not printable characters */
    public static String m363(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            Map m358 = m358(context);
            if (m358 == null || m358.size() <= 0) {
                return null;
            }
            String str = "";
            for (Map.Entry entry : m358.entrySet()) {
                str = str + "&" + ((String) entry.getKey()) + "=" + ((String) entry.getValue());
            }
            return str.substring(1);
        }
        return (String) invokeL.objValue;
    }
}
