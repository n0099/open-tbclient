package com.bytedance.sdk.openadsdk.m;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.b.c.b.g;
import c.b.c.b.k;
import c.p.a.b.a.a.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.pms.constants.PmsConstant;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.utils.ZeusInitConfigUtils;
import com.bytedance.sdk.component.net.utils.NetworkUtils;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.AppLogHelper;
import com.bytedance.sdk.openadsdk.TTAdConfig;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.core.k.b;
import com.bytedance.sdk.openadsdk.core.k.d;
import com.bytedance.sdk.openadsdk.core.l;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.s;
import com.bytedance.sdk.openadsdk.q.q;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static Uri a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, str, str2)) == null) {
            return null;
        }
        return (Uri) invokeLL.objValue;
    }

    public static void a(Context context, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, context, jSONObject) == null) {
            try {
                float f2 = 0.0f;
                float f3 = b.a(context) == null ? 0.0f : b.a(context).f67028a;
                if (b.a(context) != null) {
                    f2 = b.a(context).f67029b;
                }
                jSONObject.put("latitude", f3);
                jSONObject.put("longitude", f2);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void a(c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, aVar) == null) {
        }
    }

    public static void a(TTAdConfig tTAdConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, tTAdConfig) == null) {
        }
    }

    public static void a(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, jSONObject, jSONObject2) == null) {
        }
    }

    public static boolean a(c.p.a.a.a.f.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, cVar)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void b(Context context, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65550, null, context, jSONObject) == null) {
            try {
                jSONObject.put("imei", j.d(context));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void c(Context context, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65555, null, context, jSONObject) == null) {
            try {
                jSONObject.put("udid", j.d(context));
                jSONObject.put("mc", com.bytedance.sdk.openadsdk.core.k.c.b());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) ? "df979cdb-05a7-448c-bece-92d5005a1247" : (String) invokeV.objValue;
    }

    public static void d(Context context, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65557, null, context, jSONObject) == null) {
            try {
                JSONArray a2 = d.a(context);
                if (a2 != null) {
                    jSONObject.put("app_list", a2);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65558, null)) == null) ? s.a().c() : (String) invokeV.objValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (l.f67051b == null || l.f67051b.isCanUseWifiState()) {
                return j.h(o.a());
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, null) == null) {
            com.bytedance.sdk.openadsdk.core.j.b.c().d();
        }
    }

    public static void b(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, jSONObject) == null) {
            try {
                com.bytedance.sdk.openadsdk.core.k.a a2 = b.a(o.a());
                JSONObject jSONObject2 = new JSONObject();
                if (a2 != null) {
                    jSONObject2.put("longitude", a2.f67029b);
                    jSONObject2.put("latitude", a2.f67028a);
                }
                jSONObject.put("location", jSONObject2);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, null, context) == null) {
            c.b.c.b.l.a(context.getApplicationContext(), new g(context) { // from class: com.bytedance.sdk.openadsdk.m.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Context f68342a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {context};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f68342a = context;
                }

                @Override // c.b.c.b.g
                public Map<String, Object> a() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        HashMap hashMap = new HashMap();
                        String appLogDid = AppLogHelper.getInstance().getAppLogDid();
                        if (TextUtils.isEmpty(appLogDid)) {
                            appLogDid = j.a(this.f68342a);
                        }
                        if (!TextUtils.isEmpty(appLogDid)) {
                            hashMap.put("device_id", appLogDid);
                        }
                        hashMap.put("ac", NetworkUtils.getNetworkTypeString(this.f68342a));
                        hashMap.put("aid", 164362);
                        hashMap.put("app_name", "unionser_slardar_applog");
                        String f2 = q.f();
                        if (!TextUtils.isEmpty(f2)) {
                            hashMap.put("app_version", f2);
                        }
                        String e2 = q.e();
                        if (!TextUtils.isEmpty(e2)) {
                            hashMap.put("version_code", e2);
                            hashMap.put("update_version_code", e2);
                        }
                        hashMap.put("version_name", "3.7.0.3");
                        hashMap.put("device_platform", "android");
                        hashMap.put("os", "Android");
                        hashMap.put(HttpConstants.DEVICE_TYPE, Build.MODEL);
                        hashMap.put("device_mode", Build.MODEL);
                        hashMap.put("rom", com.bytedance.sdk.openadsdk.q.l.a());
                        hashMap.put(PmsConstant.EnvParam.Key.CPU_ABI, Build.CPU_ABI);
                        hashMap.put("device_brand", Build.BRAND);
                        hashMap.put("language", Locale.getDefault().getLanguage());
                        hashMap.put("os_api", String.valueOf(Build.VERSION.SDK_INT));
                        try {
                            String str = Build.VERSION.RELEASE;
                            if (str != null && str.length() > 10) {
                                str = str.substring(0, 10);
                            }
                            hashMap.put(HttpConstants.OS_VERSION, str);
                        } catch (Exception unused) {
                        }
                        hashMap.put("openudid", j.c(this.f68342a));
                        hashMap.put("dpi", String.valueOf(com.bytedance.sdk.openadsdk.q.s.f(this.f68342a)));
                        hashMap.put("resolution", com.bytedance.sdk.openadsdk.q.s.c(this.f68342a) + "*" + com.bytedance.sdk.openadsdk.q.s.d(this.f68342a));
                        return hashMap;
                    }
                    return (Map) invokeV.objValue;
                }

                @Override // c.b.c.b.g
                public String b() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? j.a(this.f68342a) : (String) invokeV.objValue;
                }

                @Override // c.b.c.b.g
                public String c() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? AppLogHelper.getInstance().getAppLogUserUniqueID() : (String) invokeV.objValue;
                }

                @Override // c.b.c.b.g
                public String d() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) {
                        return null;
                    }
                    return (String) invokeV.objValue;
                }

                @Override // c.b.c.b.g
                public Map<String, Integer> e() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        return null;
                    }
                    return (Map) invokeV.objValue;
                }

                @Override // c.b.c.b.g
                public List<String> f() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        return null;
                    }
                    return (List) invokeV.objValue;
                }

                @Override // c.b.c.b.g
                public Map<String, Object> g() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048582, this)) == null) {
                        HashMap hashMap = new HashMap();
                        String h2 = h.d().h();
                        if (TextUtils.isEmpty(h2)) {
                            h2 = String.valueOf(164362);
                        }
                        hashMap.put("host_appid", h2);
                        hashMap.put(ZeusInitConfigUtils.PREF_KEY_SDK_VERSION, "3.7.0.3");
                        return hashMap;
                    }
                    return (Map) invokeV.objValue;
                }
            }, true, false);
            c.b.c.b.l.d(new k() { // from class: com.bytedance.sdk.openadsdk.m.a.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0037 A[Catch: all -> 0x0043, TRY_LEAVE, TryCatch #0 {all -> 0x0043, blocks: (B:5:0x0005, B:7:0x0018, B:9:0x0029, B:15:0x0037), top: B:23:0x0005 }] */
                @Override // c.b.c.b.k
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public boolean a(Throwable th, Thread thread) {
                    InterceptResult invokeLL;
                    boolean z;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, th, thread)) == null) {
                        try {
                            StringWriter stringWriter = new StringWriter();
                            th.printStackTrace(new PrintWriter(stringWriter));
                            String stringWriter2 = stringWriter.toString();
                            if (stringWriter2 != null) {
                                if (!stringWriter2.contains(AdSlot.class.getPackage().getName()) && !stringWriter2.contains("com.bytedance.msdk")) {
                                    z = false;
                                    if (z) {
                                        c.b.c.b.l.e(com.bytedance.sdk.openadsdk.core.d.a().b());
                                        return true;
                                    }
                                }
                                z = true;
                                if (z) {
                                }
                            }
                        } catch (Throwable unused) {
                        }
                        return false;
                    }
                    return invokeLL.booleanValue;
                }
            });
        }
    }

    public static void a(TTCustomController tTCustomController, List<String> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, tTCustomController, list) == null) && tTCustomController.isCanUseLocation()) {
            list.add("android.permission.ACCESS_COARSE_LOCATION");
            list.add("android.permission.ACCESS_FINE_LOCATION");
        }
    }

    public static void a(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.core.k.a a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, null, jSONObject) == null) || (a2 = b.a(o.a())) == null) {
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("latitude", a2.f67028a);
            jSONObject2.put("longitude", a2.f67029b);
            jSONObject.put("geo", jSONObject2);
        } catch (Exception unused) {
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, null, str) == null) {
            s.a().a(str);
        }
    }

    public static void b(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65549, null, context) == null) || TextUtils.isEmpty(j.a(context))) {
            return;
        }
        s.a().b("AdShow");
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? (l.f67051b == null || l.f67051b.isCanUsePhoneState()) ? j.f(o.a()) : "" : (String) invokeV.objValue;
    }

    public static Map<String, String> b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, str, str2)) == null) {
            return s.a().a(str, str2 != null ? str2.getBytes() : new byte[0]);
        }
        return (Map) invokeLL.objValue;
    }

    public static void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, context) == null) {
            b.a(context);
        }
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) ? d.a(str) : invokeL.booleanValue;
    }
}
