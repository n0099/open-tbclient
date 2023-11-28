package com.kuaishou.weapon.p0;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.LocaleList;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityManager;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.searchbox.cloudcontrol.utils.CloudStabilityUBCUtils;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.ApiReplaceUtil;
import com.baidu.tbadk.mutiprocess.live.YyLiveRoomConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.PermissionRequest;
import com.huawei.hms.framework.network.grs.local.model.CountryCodeBean;
import com.tencent.connect.common.Constants;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class bh {
    public static /* synthetic */ Interceptable $ic;
    public static String a;
    public static String b;
    public transient /* synthetic */ FieldHolder $fh;

    public static String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65572, null)) == null) ? "ANDROID_PHONE" : (String) invokeV.objValue;
    }

    public static String n(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65574, null, context)) == null) ? bi.d : (String) invokeL.objValue;
    }

    public static String o(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65575, null, context)) == null) ? bi.c : (String) invokeL.objValue;
    }

    public static String p(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65576, null, context)) == null) ? bi.a : (String) invokeL.objValue;
    }

    public static String v(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65582, null, context)) == null) ? bi.c : (String) invokeL.objValue;
    }

    public bh() {
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

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65560, null)) == null) {
            try {
                return c(com.kwad.sdk.f.b.Hj().getIp());
            } catch (Throwable unused) {
                return bi.c;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65562, null)) == null) {
            try {
                return c(com.kwad.sdk.f.b.Hj().GZ());
            } catch (Throwable unused) {
                return bi.c;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65568, null)) == null) {
            return "ANDROID_" + Build.VERSION.RELEASE;
        }
        return (String) invokeV.objValue;
    }

    public static JSONObject A(Context context) {
        String encode;
        String encode2;
        String encode3;
        String encode4;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                String str = WeaponHI.sUserId;
                String m = m();
                String str2 = WeaponHI.sChannel;
                String l = l();
                String k = k();
                String str3 = "";
                if (TextUtils.isEmpty(str)) {
                    encode = "";
                } else {
                    encode = URLEncoder.encode(str, "UTF-8");
                }
                jSONObject.put("userId", encode);
                if (TextUtils.isEmpty(m)) {
                    encode2 = "";
                } else {
                    encode2 = URLEncoder.encode(m, "UTF-8");
                }
                jSONObject.put(Constants.PARAM_PLATFORM, encode2);
                if (TextUtils.isEmpty(str2)) {
                    encode3 = "";
                } else {
                    encode3 = URLEncoder.encode(str2, "UTF-8");
                }
                jSONObject.put("channel", encode3);
                try {
                    if (h.a(context, "re_po_rt").e("a1_p_s_p_s")) {
                        if (TextUtils.isEmpty(l)) {
                            encode4 = "";
                        } else {
                            encode4 = URLEncoder.encode(l, "UTF-8");
                        }
                        jSONObject.put(SearchJsBridge.COOKIE_MOD, encode4);
                        if (!TextUtils.isEmpty(k)) {
                            str3 = URLEncoder.encode(k, "UTF-8");
                        }
                        jSONObject.put("sysver", str3);
                    } else {
                        jSONObject.put(SearchJsBridge.COOKIE_MOD, "");
                        jSONObject.put("sysver", "");
                    }
                } catch (Exception unused) {
                }
                return jSONObject;
            } catch (Exception unused2) {
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x003e, code lost:
        if (android.text.TextUtils.isEmpty(r2) != false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x004a, code lost:
        if (r2.length() <= (r2.indexOf(" ") + 11)) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x004c, code lost:
        r1 = r2.substring(r2.indexOf(" ") + 1, r2.indexOf(" ") + 11);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a() {
        InterceptResult invokeV;
        BufferedReader bufferedReader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            String str = null;
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(c.b("c3RhdCAgL2RhdGEvc3lzdGVtL3VzZXJzLzA=", 2)).getInputStream()));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            if (readLine.contains("Access") && !readLine.contains("Uid")) {
                                break;
                            }
                        }
                    } catch (Throwable unused) {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Exception unused2) {
                            }
                        }
                        return null;
                    }
                }
                try {
                    bufferedReader.close();
                } catch (Exception unused3) {
                }
                return str;
            } catch (Throwable unused4) {
                bufferedReader = null;
            }
        } else {
            return (String) invokeV.objValue;
        }
    }

    public static JSONArray f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65559, null)) == null) {
            try {
                String c = c(com.kwad.sdk.f.b.Hj().Hg());
                if (!TextUtils.isEmpty(c) && !c.startsWith("RISK")) {
                    JSONArray jSONArray = new JSONArray();
                    JSONArray jSONArray2 = new JSONArray(c);
                    for (int i = 0; i < jSONArray2.length(); i++) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("1", jSONArray2.getJSONObject(i).getString(YyLiveRoomConfig.KEY_SSID));
                        jSONObject.put("2", jSONArray2.getJSONObject(i).getString("bssid"));
                        jSONArray.put(jSONObject);
                    }
                    return jSONArray;
                }
            } catch (Throwable unused) {
            }
            return null;
        }
        return (JSONArray) invokeV.objValue;
    }

    public static String a(AccessibilityServiceInfo accessibilityServiceInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, accessibilityServiceInfo)) == null) {
            String id = accessibilityServiceInfo.getId();
            int lastIndexOf = id.lastIndexOf("/");
            if (lastIndexOf > 0) {
                return id.substring(0, lastIndexOf);
            }
            return id;
        }
        return (String) invokeL.objValue;
    }

    public static int b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return 0;
                }
                if (!new JSONObject(str).getBoolean("userSet")) {
                    return 0;
                }
                return 1;
            } catch (Throwable unused) {
                return -2;
            }
        }
        return invokeL.intValue;
    }

    public static String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, context)) == null) {
            try {
                return c(com.kwad.sdk.f.b.Hj().GX());
            } catch (Throwable unused) {
                return bi.d;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, context)) == null) {
            try {
                return c(com.kwad.sdk.f.b.Hj().Hc());
            } catch (Throwable unused) {
                return bi.d;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, context)) == null) {
            try {
                return c(com.kwad.sdk.f.b.Hj().getIccId());
            } catch (Throwable unused) {
                return bi.d;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, context)) == null) {
            try {
                return c(com.kwad.sdk.f.b.Hj().GY());
            } catch (Throwable unused) {
                return bi.d;
            }
        }
        return (String) invokeL.objValue;
    }

    public static boolean g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, null, context)) == null) {
            try {
                if (Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", 0) <= 0) {
                    return false;
                }
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static String r(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65578, null, context)) == null) {
            return b;
        }
        return (String) invokeL.objValue;
    }

    public static String s(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65579, null, context)) == null) {
            try {
                return context.getPackageName();
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String w(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65583, null, context)) == null) {
            try {
                return c(com.kwad.sdk.f.b.Hj().getOaid());
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            try {
                return c(com.kwad.sdk.f.b.Hj().GX());
            } catch (Throwable unused) {
                return bi.d;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, context)) == null) {
            try {
                return c(com.kwad.sdk.f.b.Hj().GX());
            } catch (Throwable unused) {
                return bi.d;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String a(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65541, null, context, i)) == null) {
            try {
                if (i == 1) {
                    return c(com.kwad.sdk.f.b.Hj().Ha());
                }
                return c(com.kwad.sdk.f.b.Hj().GX());
            } catch (Throwable unused) {
                return bi.d;
            }
        }
        return (String) invokeLI.objValue;
    }

    public static String b(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65549, null, context, i)) == null) {
            try {
                if (i == 1) {
                    return c(com.kwad.sdk.f.b.Hj().Ha());
                }
                return c(com.kwad.sdk.f.b.Hj().GX());
            } catch (Throwable unused) {
                return bi.d;
            }
        }
        return (String) invokeLI.objValue;
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            try {
                Class<?> cls = Class.forName(CountryCodeBean.ANDRIOD_SYSTEMPROP);
                return (String) cls.getMethod(CommandUBCHelper.COMMAND_UBC_SOURCE_RECEIVE, String.class).invoke(cls, str);
            } catch (Throwable unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, str)) == null) {
            String str2 = "";
            try {
                if (TextUtils.isEmpty(str)) {
                    return "";
                }
                JSONObject jSONObject = new JSONObject(str);
                int i = jSONObject.getInt(CloudStabilityUBCUtils.KEY_ERROR_CODE);
                if (i == 0) {
                    str2 = jSONObject.getString("value");
                    return str2;
                } else if (i == 3) {
                    return bi.c;
                } else {
                    if (i == 1) {
                        return bi.a;
                    }
                    return bi.d;
                }
            } catch (Throwable unused) {
                return str2;
            }
        }
        return (String) invokeL.objValue;
    }

    public static boolean h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, null, context)) == null) {
            boolean z = false;
            try {
                if (Build.VERSION.SDK_INT <= 16 ? Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", 0) > 0 : Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", 0) > 0) {
                    z = true;
                }
            } catch (Throwable unused) {
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public static String k(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65569, null, context)) == null) {
            try {
                if (Settings.Secure.getInt(context.getContentResolver(), "accessibility_enabled", 0) != 1) {
                    return bi.e;
                }
                String string = ApiReplaceUtil.Overload.getString(context.getContentResolver(), "enabled_accessibility_services");
                if (TextUtils.isEmpty(string)) {
                    return bi.c;
                }
                return string;
            } catch (Throwable unused) {
                return bi.d;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String q(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65577, null, context)) == null) {
            try {
                if (TextUtils.isEmpty(a)) {
                    PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                    b = (String) packageInfo.applicationInfo.loadLabel(context.getPackageManager());
                    a = packageInfo.versionName;
                }
            } catch (Throwable unused) {
            }
            return a;
        }
        return (String) invokeL.objValue;
    }

    @TargetApi(23)
    public static int t(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65580, null, context)) == null) {
            try {
                String c = c(com.kwad.sdk.f.b.Hj().Hd());
                if (!TextUtils.isEmpty(c) && !c.startsWith("RISK")) {
                    return Integer.parseInt(c);
                }
                return -1;
            } catch (Throwable unused) {
                return -2;
            }
        }
        return invokeL.intValue;
    }

    @TargetApi(22)
    public static int u(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65581, null, context)) == null) {
            try {
                String c = c(com.kwad.sdk.f.b.Hj().He());
                if (!TextUtils.isEmpty(c) && !c.startsWith("RISK")) {
                    return Integer.parseInt(c);
                }
                return -1;
            } catch (Throwable unused) {
                return -2;
            }
        }
        return invokeL.intValue;
    }

    public static Method a(Class<?> cls, String str, Class<?>... clsArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, cls, str, clsArr)) == null) {
            try {
                Method b2 = b(cls, str, clsArr);
                try {
                    b2.setAccessible(true);
                    return b2;
                } catch (Throwable unused) {
                    return b2;
                }
            } catch (Throwable unused2) {
                return null;
            }
        }
        return (Method) invokeLLL.objValue;
    }

    public static void a(Context context, String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65544, null, context, str, map) != null) || TextUtils.isEmpty(str) || h.a(context, "re_po_rt").c(df.br, 1) == 0) {
            return;
        }
        try {
            JSONObject a2 = new cm(str, ck.l).a(context);
            if (map != null && map.size() > 0) {
                a2.put("module_section", new JSONObject(map));
            } else {
                a2.put("module_section", new JSONObject());
            }
            n.a().a(new Runnable(context, a2.toString()) { // from class: com.kuaishou.weapon.p0.bh.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Context a;
                public final /* synthetic */ String b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {context, r7};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = context;
                    this.b = r7;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        cp.a(this.a, this.b);
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    public static boolean a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, context, str)) == null) {
            try {
                context.getPackageManager().getApplicationInfo(str, 0);
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static double b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            try {
                String c = c(com.kwad.sdk.f.b.Hj().getLocation());
                if (!TextUtils.isEmpty(c) && !c.startsWith("RISK")) {
                    return new JSONObject(c).getDouble("latitude");
                }
                return -1.0d;
            } catch (Throwable unused) {
                return -1.0d;
            }
        }
        return invokeV.doubleValue;
    }

    public static double c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            try {
                String c = c(com.kwad.sdk.f.b.Hj().getLocation());
                if (!TextUtils.isEmpty(c) && !c.startsWith("RISK")) {
                    return new JSONObject(c).getDouble("longitude");
                }
                return -1.0d;
            } catch (Throwable unused) {
                return -1.0d;
            }
        }
        return invokeV.doubleValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) {
            try {
                String c = c(com.kwad.sdk.f.b.Hj().Hh());
                if (!TextUtils.isEmpty(c)) {
                    if (c.startsWith("RISK")) {
                    }
                }
                return c;
            } catch (Throwable unused) {
                return bi.d;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65564, null)) == null) {
            try {
                Locale locale = Locale.getDefault();
                return locale.getLanguage() + "-" + locale.getCountry();
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public static String j() {
        InterceptResult invokeV;
        Locale locale;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65566, null)) == null) {
            if (Build.VERSION.SDK_INT >= 24) {
                locale = LocaleList.getDefault().get(0);
            } else {
                locale = Locale.getDefault();
            }
            return locale.getLanguage() + "-" + locale.getCountry();
        }
        return (String) invokeV.objValue;
    }

    public static String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65570, null)) == null) {
            return Build.MANUFACTURER + "(" + Build.MODEL + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeV.objValue;
    }

    public static Method b(Class<?> cls, String str, Class<?>... clsArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65550, null, cls, str, clsArr)) == null) {
            try {
                Method method = cls.getMethod(str, clsArr);
                if (method != null) {
                    return method;
                }
            } catch (Throwable unused) {
            }
            while (cls != null) {
                try {
                    Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
                    declaredMethod.setAccessible(true);
                    return declaredMethod;
                } catch (NoSuchMethodException unused2) {
                    cls = cls.getSuperclass();
                }
            }
            throw new NoSuchMethodException();
        }
        return (Method) invokeLLL.objValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) {
            try {
                String c = c(com.kwad.sdk.f.b.Hj().Hf());
                if (!TextUtils.isEmpty(c) && !c.startsWith("RISK")) {
                    JSONObject jSONObject = new JSONObject(c);
                    return jSONObject.getString("cellId") + StringUtil.ARRAY_ELEMENT_SEPARATOR + jSONObject.getString("lac");
                }
                return c;
            } catch (Throwable unused) {
                return bi.d;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String i(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65565, null, context)) == null) {
            try {
                List<InputMethodInfo> inputMethodList = ((InputMethodManager) context.getSystemService("input_method")).getInputMethodList();
                StringBuilder sb = new StringBuilder();
                for (InputMethodInfo inputMethodInfo : inputMethodList) {
                    sb.append(inputMethodInfo.getId());
                    sb.append(ParamableElem.DIVIDE_PARAM);
                }
                if (TextUtils.isEmpty(sb)) {
                    return bi.c;
                }
                String sb2 = sb.toString();
                if (sb2.endsWith(ParamableElem.DIVIDE_PARAM)) {
                    return sb2.substring(0, sb2.length() - 1);
                }
                return sb2;
            } catch (Exception unused) {
                return bi.d;
            }
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x004a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String l(Context context) {
        InterceptResult invokeL;
        StringBuilder sb;
        List<AccessibilityServiceInfo> installedAccessibilityServiceList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65571, null, context)) == null) {
            AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
            if (accessibilityManager == null) {
                return null;
            }
            try {
                installedAccessibilityServiceList = accessibilityManager.getInstalledAccessibilityServiceList();
            } catch (Exception unused) {
            }
            if (installedAccessibilityServiceList != null && installedAccessibilityServiceList.size() > 0) {
                sb = new StringBuilder();
                try {
                    for (AccessibilityServiceInfo accessibilityServiceInfo : installedAccessibilityServiceList) {
                        String a2 = a(accessibilityServiceInfo);
                        if (sb.indexOf(a2) == -1) {
                            sb.append(a2);
                            sb.append("|");
                        }
                    }
                } catch (Exception unused2) {
                }
                if (sb != null) {
                    return null;
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                return sb.toString();
            }
            sb = null;
            if (sb != null) {
            }
        } else {
            return (String) invokeL.objValue;
        }
    }

    public static String m(Context context) {
        InterceptResult invokeL;
        StringBuilder sb;
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65573, null, context)) == null) {
            AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
            StringBuilder sb2 = null;
            if (accessibilityManager == null) {
                return null;
            }
            try {
                if (accessibilityManager.isEnabled() && (enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(-1)) != null && enabledAccessibilityServiceList.size() > 0) {
                    sb = new StringBuilder();
                    try {
                        for (AccessibilityServiceInfo accessibilityServiceInfo : enabledAccessibilityServiceList) {
                            String a2 = a(accessibilityServiceInfo);
                            if (sb.indexOf(a2) == -1) {
                                sb.append(a2);
                                sb.append("|");
                            }
                        }
                    } catch (Exception unused) {
                        sb2 = sb;
                        sb = sb2;
                        return sb.toString();
                    }
                } else {
                    sb = null;
                }
            } catch (Exception unused2) {
            }
            if (sb == null) {
                return null;
            }
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '|') {
                sb.deleteCharAt(sb.length() - 1);
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String x(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65584, null, context)) == null) {
            StringBuilder sb = new StringBuilder();
            try {
                PackageManager packageManager = context.getPackageManager();
                String[] strArr = {"android.hardware.camera", "android.hardware.camera.autofocus", "android.hardware.camera.flash", "android.hardware.location", "android.hardware.location.gps", "android.hardware.location.network", "android.hardware.microphone", "android.hardware.sensor.compass", "android.hardware.sensor.accelerometer", "android.hardware.sensor.light", "android.hardware.sensor.proximity", "android.hardware.telephony", "android.hardware.telephony.cdma", "android.hardware.telephony.gsm", "android.hardware.touchscreen", "android.hardware.touchscreen.multitouch", "android.hardware.touchscreen.multitouch.distinct", "android.hardware.camera.front", "android.hardware.wifi", "android.hardware.bluetooth", "android.hardware.nfc", "android.hardware.fingerprint", "android.hardware.biometrics.face", "android.hardware.screen.portrait", "android.hardware.screen.landscape", "android.hardware.faketouch", "android.hardware.audio.output"};
                for (int i = 0; i < 27; i++) {
                    if (packageManager.hasSystemFeature(strArr[i])) {
                        sb.append("1");
                    } else {
                        sb.append("0");
                    }
                }
            } catch (Exception unused) {
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String j(Context context) {
        InterceptResult invokeL;
        List<InputMethodInfo> enabledInputMethodList;
        ActivityInfo activityInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65567, null, context)) == null) {
            int i = -1;
            if (context == null) {
                return "";
            }
            try {
                PackageManager packageManager = context.getPackageManager();
                String string = ApiReplaceUtil.Overload.getString(context.getContentResolver(), "default_input_method");
                if (string == null) {
                    string = StringUtil.NULL_STRING;
                }
                String str = "1=" + string + ParamableElem.DIVIDE_PARAM;
                InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
                if (inputMethodManager != null && (enabledInputMethodList = inputMethodManager.getEnabledInputMethodList()) != null) {
                    str = str + "2=";
                    for (InputMethodInfo inputMethodInfo : enabledInputMethodList) {
                        String packageName = inputMethodInfo.getPackageName();
                        if (packageName == null) {
                            packageName = StringUtil.NULL_STRING;
                        }
                        String settingsActivity = inputMethodInfo.getSettingsActivity();
                        if (settingsActivity == null) {
                            settingsActivity = StringUtil.NULL_STRING;
                        }
                        if (packageManager != null) {
                            try {
                                if (!packageName.equals(StringUtil.NULL_STRING) && !settingsActivity.equals(StringUtil.NULL_STRING) && (activityInfo = packageManager.getActivityInfo(new ComponentName(packageName, settingsActivity), 0)) != null) {
                                    i = activityInfo.launchMode;
                                }
                            } catch (Exception unused) {
                            }
                        }
                        str = str + packageName + "-" + settingsActivity + "-" + String.format("%d", Integer.valueOf(i)) + ParamableElem.DIVIDE_PARAM;
                    }
                }
                return str;
            } catch (Throwable unused2) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String y(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65585, null, context)) == null) {
            StringBuilder sb = new StringBuilder();
            try {
                String[] strArr = {g.c, g.i, "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_CONTACTS", PermissionRequest.RESOURCE_VIDEO_CAPTURE, PermissionRequest.RESOURCE_AUDIO_CAPTURE, g.g, g.h, "android.permission.BLUETOOTH", "android.permission.WRITE_CALENDAR", "android.permission.READ_CALENDAR"};
                for (int i = 0; i < 11; i++) {
                    if (g.a(context, strArr[i]) == 0) {
                        sb.append("1");
                    } else {
                        sb.append("0");
                    }
                }
            } catch (Exception unused) {
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String z(Context context) {
        InterceptResult invokeL;
        Iterator<String> keys;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65586, null, context)) == null) {
            try {
                StringBuilder sb = new StringBuilder();
                JSONObject A = A(context);
                if (A != null && (keys = A.keys()) != null) {
                    String str = "";
                    while (keys.hasNext()) {
                        String next = keys.next();
                        String string = A.getString(next);
                        sb.append(str);
                        str = ParamableElem.DIVIDE_PARAM;
                        sb.append(next);
                        sb.append("=");
                        sb.append(string);
                    }
                    return sb.toString();
                }
            } catch (Exception unused) {
            }
            return "";
        }
        return (String) invokeL.objValue;
    }
}
