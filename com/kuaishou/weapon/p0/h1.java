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
import com.tencent.connect.common.Constants;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class h1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ String b;

        public a(Context context, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                q2.a(this.a, this.b);
            }
        }
    }

    public h1() {
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

    public static String A(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            StringBuilder sb = new StringBuilder();
            try {
                PackageManager packageManager = context.getPackageManager();
                String[] strArr = {"android.hardware.camera", "android.hardware.camera.autofocus", "android.hardware.camera.flash", "android.hardware.location", "android.hardware.location.gps", "android.hardware.location.network", "android.hardware.microphone", "android.hardware.sensor.compass", "android.hardware.sensor.accelerometer", "android.hardware.sensor.light", "android.hardware.sensor.proximity", "android.hardware.telephony", "android.hardware.telephony.cdma", "android.hardware.telephony.gsm", "android.hardware.touchscreen", "android.hardware.touchscreen.multitouch", "android.hardware.touchscreen.multitouch.distinct", "android.hardware.camera.front", "android.hardware.wifi", "android.hardware.bluetooth", "android.hardware.nfc", "android.hardware.fingerprint", "android.hardware.biometrics.face", "android.hardware.screen.portrait", "android.hardware.screen.landscape", "android.hardware.faketouch", "android.hardware.audio.output"};
                for (int i = 0; i < 27; i++) {
                    sb.append(packageManager.hasSystemFeature(strArr[i]) ? "1" : "0");
                }
            } catch (Exception unused) {
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static boolean B(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            try {
                return Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", 0) > 0;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0020, code lost:
        if (android.provider.Settings.Secure.getInt(r4.getContentResolver(), "adb_enabled", 0) > 0) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean C(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            boolean z = false;
            if (Build.VERSION.SDK_INT > 16) {
                if (Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", 0) > 0) {
                    z = true;
                }
                return z;
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    @TargetApi(22)
    public static int a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            try {
                String c = c(com.kwad.sdk.c.b.xm().xh());
                if (TextUtils.isEmpty(c) || c.startsWith("RISK")) {
                    return -1;
                }
                return Integer.parseInt(c);
            } catch (Throwable unused) {
                return -2;
            }
        }
        return invokeL.intValue;
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            try {
                String c = c(com.kwad.sdk.c.b.xm().xk());
                if (!TextUtils.isEmpty(c)) {
                    if (!c.startsWith("RISK")) {
                    }
                }
                return c;
            } catch (Throwable unused) {
                return i1.d;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String a(AccessibilityServiceInfo accessibilityServiceInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, accessibilityServiceInfo)) == null) {
            String id = accessibilityServiceInfo.getId();
            int lastIndexOf = id.lastIndexOf("/");
            return lastIndexOf > 0 ? id.substring(0, lastIndexOf) : id;
        }
        return (String) invokeL.objValue;
    }

    public static String a(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65543, null, context, i)) == null) {
            try {
                return i == 1 ? c(com.kwad.sdk.c.b.xm().xd()) : c(com.kwad.sdk.c.b.xm().xa());
            } catch (Throwable unused) {
                return i1.d;
            }
        }
        return (String) invokeLI.objValue;
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                return (String) cls.getMethod("get", String.class).invoke(cls, str);
            } catch (Throwable unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static Method a(Class<?> cls, String str, Class<?>... clsArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65545, null, cls, str, clsArr)) == null) {
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

    public static void a(Context context, String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65546, null, context, str, map) == null) || TextUtils.isEmpty(str) || i.a(context, "re_po_rt").b(f3.c1, 1) == 0) {
            return;
        }
        try {
            JSONObject a2 = new n2(str, l2.j).a(context);
            if (map == null || map.size() <= 0) {
                a2.put("module_section", new JSONObject());
            } else {
                a2.put("module_section", new JSONObject(map));
            }
            o.a().a(new a(context, a2.toString()));
        } catch (Throwable unused) {
        }
    }

    public static int b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return 0;
                }
                return new JSONObject(str).getBoolean("userSet") ? 1 : 0;
            } catch (Throwable unused) {
                return -2;
            }
        }
        return invokeL.intValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            try {
                Locale locale = Locale.getDefault();
                return locale.getLanguage() + "-" + locale.getCountry();
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, context)) == null) {
            try {
                List<InputMethodInfo> inputMethodList = ((InputMethodManager) context.getSystemService("input_method")).getInputMethodList();
                StringBuilder sb = new StringBuilder();
                for (InputMethodInfo inputMethodInfo : inputMethodList) {
                    sb.append(inputMethodInfo.getId());
                    sb.append(";");
                }
                if (TextUtils.isEmpty(sb)) {
                    return i1.c;
                }
                String sb2 = sb.toString();
                return sb2.endsWith(";") ? sb2.substring(0, sb2.length() - 1) : sb2;
            } catch (Exception unused) {
                return i1.d;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String b(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65550, null, context, i)) == null) {
            try {
                return i == 1 ? c(com.kwad.sdk.c.b.xm().xd()) : c(com.kwad.sdk.c.b.xm().xa());
            } catch (Throwable unused) {
                return i1.d;
            }
        }
        return (String) invokeLI.objValue;
    }

    public static Method b(Class<?> cls, String str, Class<?>... clsArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65551, null, cls, str, clsArr)) == null) {
            try {
                Method a2 = a(cls, str, clsArr);
                try {
                    a2.setAccessible(true);
                    return a2;
                } catch (Throwable unused) {
                    return a2;
                }
            } catch (Throwable unused2) {
                return null;
            }
        }
        return (Method) invokeLLL.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) {
            Locale locale = Build.VERSION.SDK_INT >= 24 ? LocaleList.getDefault().get(0) : Locale.getDefault();
            return locale.getLanguage() + "-" + locale.getCountry();
        }
        return (String) invokeV.objValue;
    }

    public static String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, context)) == null) {
            try {
                return c(com.kwad.sdk.c.b.xm().xb());
            } catch (Throwable unused) {
                return i1.d;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, str)) == null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return "";
                }
                JSONObject jSONObject = new JSONObject(str);
                int i = jSONObject.getInt("errorCode");
                return i == 0 ? jSONObject.getString("value") : i == 3 ? i1.c : i == 1 ? i1.a : i1.d;
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) {
            try {
                return c(com.kwad.sdk.c.b.xm().getIp());
            } catch (Throwable unused) {
                return i1.c;
            }
        }
        return (String) invokeV.objValue;
    }

    public static JSONObject d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, context)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                String str = WeaponHI.sUserId;
                String i = i();
                String str2 = WeaponHI.sChannel;
                String h = h();
                String k = k();
                String str3 = "";
                jSONObject.put("userId", TextUtils.isEmpty(str) ? "" : URLEncoder.encode(str, "UTF-8"));
                jSONObject.put(Constants.PARAM_PLATFORM, TextUtils.isEmpty(i) ? "" : URLEncoder.encode(i, "UTF-8"));
                jSONObject.put("channel", TextUtils.isEmpty(str2) ? "" : URLEncoder.encode(str2, "UTF-8"));
                try {
                    if (i.a(context, "re_po_rt").b("a1_p_s_p_s")) {
                        jSONObject.put(SearchJsBridge.COOKIE_MOD, TextUtils.isEmpty(h) ? "" : URLEncoder.encode(h, "UTF-8"));
                        if (!TextUtils.isEmpty(k)) {
                            str3 = URLEncoder.encode(k, "UTF-8");
                        }
                    } else {
                        jSONObject.put(SearchJsBridge.COOKIE_MOD, "");
                    }
                    jSONObject.put("sysver", str3);
                } catch (Exception unused) {
                }
                return jSONObject;
            } catch (Exception unused2) {
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    public static double e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) {
            try {
                String c = c(com.kwad.sdk.c.b.xm().getLocation());
                if (TextUtils.isEmpty(c) || c.startsWith("RISK")) {
                    return -1.0d;
                }
                return new JSONObject(c).getDouble("latitude");
            } catch (Throwable unused) {
                return -1.0d;
            }
        }
        return invokeV.doubleValue;
    }

    public static String e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65558, null, context)) == null) ? i1.c : (String) invokeL.objValue;
    }

    public static double f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65559, null)) == null) {
            try {
                String c = c(com.kwad.sdk.c.b.xm().getLocation());
                if (TextUtils.isEmpty(c) || c.startsWith("RISK")) {
                    return -1.0d;
                }
                return new JSONObject(c).getDouble("longitude");
            } catch (Throwable unused) {
                return -1.0d;
            }
        }
        return invokeV.doubleValue;
    }

    public static String f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65560, null, context)) == null) ? i1.d : (String) invokeL.objValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65561, null)) == null) {
            try {
                return c(com.kwad.sdk.c.b.xm().xc());
            } catch (Throwable unused) {
                return i1.c;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, null, context)) == null) {
            try {
                boolean z = h.a(context, "android.permission.BLUETOOTH") == 0;
                if (Build.VERSION.SDK_INT < 23) {
                    return z ? f(context) : i1.a;
                }
                String string = ApiReplaceUtil.Overload.getString(context.getContentResolver(), "bluetooth_address");
                return !TextUtils.isEmpty(string) ? string : z ? e(context) : i1.a;
            } catch (Throwable unused) {
                return i1.d;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65563, null)) == null) {
            return Build.MANUFACTURER + "(" + Build.MODEL + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeV.objValue;
    }

    public static String h(Context context) {
        InterceptResult invokeL;
        Iterator<String> keys;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65564, null, context)) == null) {
            try {
                StringBuilder sb = new StringBuilder();
                JSONObject d = d(context);
                if (d != null && (keys = d.keys()) != null) {
                    String str = "";
                    while (keys.hasNext()) {
                        String next = keys.next();
                        String string = d.getString(next);
                        sb.append(str);
                        sb.append(next);
                        sb.append("=");
                        sb.append(string);
                        str = ";";
                    }
                    return sb.toString();
                }
            } catch (Exception unused) {
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65565, null)) == null) ? "ANDROID_PHONE" : (String) invokeV.objValue;
    }

    public static String i(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, null, context)) == null) {
            try {
                if (Settings.Secure.getInt(context.getContentResolver(), "accessibility_enabled", 0) != 1) {
                    return i1.e;
                }
                String string = ApiReplaceUtil.Overload.getString(context.getContentResolver(), "enabled_accessibility_services");
                return TextUtils.isEmpty(string) ? i1.c : string;
            } catch (Throwable unused) {
                return i1.d;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65567, null)) == null) {
            try {
                String c = c(com.kwad.sdk.c.b.xm().xi());
                if (TextUtils.isEmpty(c) || c.startsWith("RISK")) {
                    return c;
                }
                JSONObject jSONObject = new JSONObject(c);
                return jSONObject.getString("cellId") + StringUtil.ARRAY_ELEMENT_SEPARATOR + jSONObject.getString("lac");
            } catch (Throwable unused) {
                return i1.d;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String j(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65568, null, context)) == null) {
            try {
                return c(com.kwad.sdk.c.b.xm().xa());
            } catch (Throwable unused) {
                return i1.d;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65569, null)) == null) {
            return "ANDROID_" + Build.VERSION.RELEASE;
        }
        return (String) invokeV.objValue;
    }

    public static String k(Context context) {
        InterceptResult invokeL;
        StringBuilder sb;
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65570, null, context)) == null) {
            AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
            StringBuilder sb2 = null;
            if (accessibilityManager == null) {
                return null;
            }
            try {
                if (!accessibilityManager.isEnabled() || (enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(-1)) == null || enabledAccessibilityServiceList.size() <= 0) {
                    sb = null;
                } else {
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
                    }
                }
            } catch (Exception unused2) {
            }
            if (sb == null) {
                return null;
            }
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '|') {
                sb.deleteCharAt(sb.length() - 1);
            }
            sb2 = sb;
            return sb2.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String l(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65571, null, context)) == null) {
            try {
                return (String) context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.loadLabel(context.getPackageManager());
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static JSONArray l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65572, null)) == null) {
            try {
                String c = c(com.kwad.sdk.c.b.xm().xj());
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

    public static String m(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65573, null, context)) == null) {
            try {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String n(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65574, null, context)) == null) {
            try {
                return context.getPackageName();
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String o(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65575, null, context)) == null) {
            try {
                return c(com.kwad.sdk.c.b.xm().getIccId());
            } catch (Throwable unused) {
                return i1.d;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String p(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65576, null, context)) == null) {
            try {
                return c(com.kwad.sdk.c.b.xm().xa());
            } catch (Throwable unused) {
                return i1.d;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String q(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65577, null, context)) == null) {
            try {
                return c(com.kwad.sdk.c.b.xm().xa());
            } catch (Throwable unused) {
                return i1.d;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String r(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65578, null, context)) == null) {
            try {
                return c(com.kwad.sdk.c.b.xm().xf());
            } catch (Throwable unused) {
                return i1.d;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String s(Context context) {
        InterceptResult invokeL;
        List<InputMethodInfo> enabledInputMethodList;
        ActivityInfo activityInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65579, null, context)) == null) {
            String str = "";
            if (context != null) {
                try {
                    PackageManager packageManager = context.getPackageManager();
                    String string = ApiReplaceUtil.Overload.getString(context.getContentResolver(), "default_input_method");
                    if (string == null) {
                        string = StringUtil.NULL_STRING;
                    }
                    String str2 = "1=" + string + ";";
                    InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
                    if (inputMethodManager != null && (enabledInputMethodList = inputMethodManager.getEnabledInputMethodList()) != null) {
                        String str3 = str2 + "2=";
                        int i = -1;
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
                            StringBuilder sb = new StringBuilder();
                            sb.append(str3);
                            sb.append(packageName);
                            sb.append("-");
                            sb.append(settingsActivity);
                            sb.append("-");
                            sb.append(String.format("%d", Integer.valueOf(i)));
                            sb.append(";");
                            str3 = sb.toString();
                        }
                        return str3;
                    }
                    str = str2;
                } catch (Throwable unused2) {
                    return "";
                }
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x004a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String t(Context context) {
        InterceptResult invokeL;
        StringBuilder sb;
        List<AccessibilityServiceInfo> installedAccessibilityServiceList;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65580, null, context)) != null) {
            return (String) invokeL.objValue;
        }
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
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x0016: IGET  (r1v1 long A[REMOVE]) = (r4v3 android.content.pm.PackageInfo) android.content.pm.PackageInfo.firstInstallTime long)] */
    public static String u(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65581, null, context)) == null) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                StringBuilder sb = new StringBuilder();
                sb.append(packageInfo.firstInstallTime);
                return sb.toString();
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String v(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65582, null, context)) == null) {
            try {
                return c(com.kwad.sdk.c.b.xm().getOaid());
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
            StringBuilder sb = new StringBuilder();
            try {
                String[] strArr = {h.c, h.i, "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_CONTACTS", PermissionRequest.RESOURCE_VIDEO_CAPTURE, PermissionRequest.RESOURCE_AUDIO_CAPTURE, h.g, h.h, "android.permission.BLUETOOTH", "android.permission.WRITE_CALENDAR", "android.permission.READ_CALENDAR"};
                for (int i = 0; i < 11; i++) {
                    sb.append(h.a(context, strArr[i]) == 0 ? "1" : "0");
                }
            } catch (Exception unused) {
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    @TargetApi(23)
    public static int x(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65584, null, context)) == null) {
            try {
                String c = c(com.kwad.sdk.c.b.xm().xg());
                if (TextUtils.isEmpty(c) || c.startsWith("RISK")) {
                    return -1;
                }
                return Integer.parseInt(c);
            } catch (Throwable unused) {
                return -2;
            }
        }
        return invokeL.intValue;
    }

    public static String y(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65585, null, context)) == null) {
            try {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.name;
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String z(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65586, null, context)) == null) ? i1.c : (String) invokeL.objValue;
    }
}
