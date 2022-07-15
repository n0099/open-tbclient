package com.kuaishou.weapon.p0;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActivityManager;
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
import com.baidu.sofire.sharedpreferences.SharedPreferenceManager;
import com.baidu.sofire.utility.PermissionChecker;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.c.b;
import com.tencent.connect.common.Constants;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* renamed from: com.kuaishou.weapon.p0.ٴٴ  reason: contains not printable characters */
/* loaded from: classes5.dex */
public class C0433 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.kuaishou.weapon.p0.ٴٴ$ʻ  reason: contains not printable characters */
    /* loaded from: classes5.dex */
    public static class RunnableC0434 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: ʻ  reason: contains not printable characters */
        public final /* synthetic */ Context f612;

        /* renamed from: ʼ  reason: contains not printable characters */
        public final /* synthetic */ String f613;

        public RunnableC0434(Context context, String str) {
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
            this.f612 = context;
            this.f613 = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                C0336.m282(this.f612, this.f613);
            }
        }
    }

    public C0433() {
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

    @TargetApi(22)
    /* renamed from: ʻ  reason: contains not printable characters */
    public static int m850(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            try {
                String m867 = m867(b.t().j());
                if (TextUtils.isEmpty(m867) || m867.startsWith("RISK")) {
                    return -1;
                }
                return Integer.parseInt(m867);
            } catch (Throwable unused) {
                return -2;
            }
        }
        return invokeL.intValue;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public static String m851() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            try {
                String m867 = m867(b.t().p());
                if (!TextUtils.isEmpty(m867)) {
                    if (!m867.startsWith("RISK")) {
                    }
                }
                return m867;
            } catch (Throwable unused) {
                return C0453.f699;
            }
        }
        return (String) invokeV.objValue;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public static String m852(AccessibilityServiceInfo accessibilityServiceInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, accessibilityServiceInfo)) == null) {
            String id = accessibilityServiceInfo.getId();
            int lastIndexOf = id.lastIndexOf("/");
            return lastIndexOf > 0 ? id.substring(0, lastIndexOf) : id;
        }
        return (String) invokeL.objValue;
    }

    @SuppressLint({"LocalSuppress", "NewApi"})
    /* renamed from: ʻ  reason: contains not printable characters */
    public static String m853(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, context, i)) == null) {
            try {
                return i == 1 ? m867(b.t().e()) : m867(b.t().a());
            } catch (Throwable unused) {
                return C0453.f699;
            }
        }
        return (String) invokeLI.objValue;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public static String m854(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                return (String) cls.getMethod(SharedPreferenceManager.OPERATION_GET_PERFIX, String.class).invoke(cls, str);
            } catch (Throwable unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public static Method m855(Class<?> cls, String str, Class<?>... clsArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, null, cls, str, clsArr)) == null) {
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

    /* renamed from: ʻ  reason: contains not printable characters */
    public static void m856(Context context, String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65543, null, context, str, map) == null) || TextUtils.isEmpty(str) || C0374.m389(context).m402(C0374.f282, 1) == 0) {
            return;
        }
        try {
            JSONObject m253 = new C0333(str, C0331.f85).m253(context);
            if (map == null || map.size() <= 0) {
                m253.put("module_section", new JSONObject());
            } else {
                m253.put("module_section", new JSONObject(map));
            }
            C0358.m366().m367(new RunnableC0434(context, m253.toString()));
        } catch (Throwable unused) {
        }
    }

    /* renamed from: ʻʻ  reason: contains not printable characters */
    public static String m857(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) ? C0453.f697 : (String) invokeL.objValue;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public static int m858(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
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

    /* renamed from: ʼ  reason: contains not printable characters */
    public static String m859() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            try {
                Locale locale = Locale.getDefault();
                return locale.getLanguage() + "-" + locale.getCountry();
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public static String m860(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) {
            try {
                List<InputMethodInfo> inputMethodList = ((InputMethodManager) context.getSystemService("input_method")).getInputMethodList();
                StringBuilder sb = new StringBuilder();
                for (InputMethodInfo inputMethodInfo : inputMethodList) {
                    sb.append(inputMethodInfo.getId());
                    sb.append(ParamableElem.DIVIDE_PARAM);
                }
                if (TextUtils.isEmpty(sb)) {
                    return C0453.f697;
                }
                String sb2 = sb.toString();
                return sb2.endsWith(ParamableElem.DIVIDE_PARAM) ? sb2.substring(0, sb2.length() - 1) : sb2;
            } catch (Exception unused) {
                return C0453.f699;
            }
        }
        return (String) invokeL.objValue;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public static String m861(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65548, null, context, i)) == null) {
            try {
                return i == 1 ? m867(b.t().e()) : m867(b.t().a());
            } catch (Throwable unused) {
                return C0453.f699;
            }
        }
        return (String) invokeLI.objValue;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public static Method m862(Class<?> cls, String str, Class<?>... clsArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65549, null, cls, str, clsArr)) == null) {
            try {
                Method m855 = m855(cls, str, clsArr);
                try {
                    m855.setAccessible(true);
                    return m855;
                } catch (Throwable unused) {
                    return m855;
                }
            } catch (Throwable unused2) {
                return null;
            }
        }
        return (Method) invokeLLL.objValue;
    }

    /* renamed from: ʼʼ  reason: contains not printable characters */
    public static String m863(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, context)) == null) {
            try {
                return m867(b.t().d());
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public static String m864() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            Locale locale = Build.VERSION.SDK_INT >= 24 ? LocaleList.getDefault().get(0) : Locale.getDefault();
            return locale.getLanguage() + "-" + locale.getCountry();
        }
        return (String) invokeV.objValue;
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public static String m865(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, context)) == null) {
            try {
                return m867(b.t().c());
            } catch (Throwable unused) {
                return C0453.f699;
            }
        }
        return (String) invokeL.objValue;
    }

    @SuppressLint({"LocalSuppress", "NewApi"})
    /* renamed from: ʽ  reason: contains not printable characters */
    public static String m866(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65553, null, context, i)) == null) ? C0453.f699 : (String) invokeLI.objValue;
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public static String m867(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, str)) == null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return "";
                }
                JSONObject jSONObject = new JSONObject(str);
                int i = jSONObject.getInt("errorCode");
                return i == 0 ? jSONObject.getString("value") : i == 3 ? C0453.f697 : i == 1 ? C0453.f693 : C0453.f699;
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    /* renamed from: ʽʽ  reason: contains not printable characters */
    public static String m868(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, context)) == null) {
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

    /* renamed from: ʾ  reason: contains not printable characters */
    public static String m869() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) {
            try {
                return m867(b.t().m());
            } catch (Throwable unused) {
                return C0453.f697;
            }
        }
        return (String) invokeV.objValue;
    }

    /* renamed from: ʾ  reason: contains not printable characters */
    public static String m870(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65557, null, context, i)) == null) {
            try {
                return i == 1 ? m867(b.t().e()) : m867(b.t().a());
            } catch (Throwable unused) {
                return C0453.f699;
            }
        }
        return (String) invokeLI.objValue;
    }

    /* renamed from: ʾ  reason: contains not printable characters */
    public static JSONObject m871(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, context)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                String str = WeaponHI.sUserId;
                String m882 = m882();
                String str2 = WeaponHI.sChannel;
                String m880 = m880();
                String m886 = m886();
                String str3 = "";
                jSONObject.put("userId", TextUtils.isEmpty(str) ? "" : URLEncoder.encode(str, "UTF-8"));
                jSONObject.put(Constants.PARAM_PLATFORM, TextUtils.isEmpty(m882) ? "" : URLEncoder.encode(m882, "UTF-8"));
                jSONObject.put("channel", TextUtils.isEmpty(str2) ? "" : URLEncoder.encode(str2, "UTF-8"));
                try {
                    if (C0374.m389(context).m408("a1_p_s_p_s")) {
                        jSONObject.put(SearchJsBridge.COOKIE_MOD, TextUtils.isEmpty(m880) ? "" : URLEncoder.encode(m880, "UTF-8"));
                        if (!TextUtils.isEmpty(m886)) {
                            str3 = URLEncoder.encode(m886, "UTF-8");
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

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0020, code lost:
        if (android.provider.Settings.Secure.getInt(r4.getContentResolver(), "adb_enabled", 0) > 0) goto L11;
     */
    /* renamed from: ʾʾ  reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean m872(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, context)) == null) {
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

    /* renamed from: ʿ  reason: contains not printable characters */
    public static double m873() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65560, null)) == null) {
            try {
                String m867 = m867(b.t().o());
                if (TextUtils.isEmpty(m867) || m867.startsWith("RISK")) {
                    return -1.0d;
                }
                return new JSONObject(m867).getDouble("latitude");
            } catch (Throwable unused) {
                return -1.0d;
            }
        }
        return invokeV.doubleValue;
    }

    /* renamed from: ʿ  reason: contains not printable characters */
    public static String m874(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65561, null, context)) == null) ? C0453.f697 : (String) invokeL.objValue;
    }

    /* renamed from: ʿʿ  reason: contains not printable characters */
    public static boolean m875(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, null, context)) == null) {
            try {
                return Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", 0) > 0;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    /* renamed from: ˆ  reason: contains not printable characters */
    public static double m876() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65563, null)) == null) {
            try {
                String m867 = m867(b.t().o());
                if (TextUtils.isEmpty(m867) || m867.startsWith("RISK")) {
                    return -1.0d;
                }
                return new JSONObject(m867).getDouble("longitude");
            } catch (Throwable unused) {
                return -1.0d;
            }
        }
        return invokeV.doubleValue;
    }

    /* renamed from: ˆ  reason: contains not printable characters */
    public static String m877(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65564, null, context)) == null) ? C0453.f699 : (String) invokeL.objValue;
    }

    /* renamed from: ˈ  reason: contains not printable characters */
    public static String m878() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65565, null)) == null) {
            try {
                return m867(b.t().d());
            } catch (Throwable unused) {
                return C0453.f697;
            }
        }
        return (String) invokeV.objValue;
    }

    /* renamed from: ˈ  reason: contains not printable characters */
    public static String m879(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, null, context)) == null) {
            try {
                boolean z = C0306.m179(context, "android.permission.BLUETOOTH") == 0;
                if (Build.VERSION.SDK_INT < 23) {
                    return z ? m877(context) : C0453.f693;
                }
                String string = Settings.Secure.getString(context.getContentResolver(), "bluetooth_address");
                return !TextUtils.isEmpty(string) ? string : z ? m874(context) : C0453.f693;
            } catch (Throwable unused) {
                return C0453.f699;
            }
        }
        return (String) invokeL.objValue;
    }

    /* renamed from: ˉ  reason: contains not printable characters */
    public static String m880() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65567, null)) == null) {
            return Build.MANUFACTURER + "(" + Build.MODEL + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeV.objValue;
    }

    /* renamed from: ˉ  reason: contains not printable characters */
    public static String m881(Context context) {
        InterceptResult invokeL;
        Iterator<String> keys;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65568, null, context)) == null) {
            try {
                StringBuilder sb = new StringBuilder();
                JSONObject m871 = m871(context);
                if (m871 != null && (keys = m871.keys()) != null) {
                    String str = "";
                    while (keys.hasNext()) {
                        String next = keys.next();
                        String string = m871.getString(next);
                        sb.append(str);
                        sb.append(next);
                        sb.append("=");
                        sb.append(string);
                        str = ParamableElem.DIVIDE_PARAM;
                    }
                    return sb.toString();
                }
            } catch (Exception unused) {
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static String m882() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65569, null)) == null) ? "ANDROID_PHONE" : (String) invokeV.objValue;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static String m883(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65570, null, context)) == null) {
            try {
                if (Settings.Secure.getInt(context.getContentResolver(), "accessibility_enabled", 0) != 1) {
                    return C0453.f701;
                }
                String string = Settings.Secure.getString(context.getContentResolver(), "enabled_accessibility_services");
                return TextUtils.isEmpty(string) ? C0453.f697 : string;
            } catch (Throwable unused) {
                return C0453.f699;
            }
        }
        return (String) invokeL.objValue;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static String m884() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65571, null)) == null) {
            try {
                String m867 = m867(b.t().k());
                if (TextUtils.isEmpty(m867) || m867.startsWith("RISK")) {
                    return m867;
                }
                JSONObject jSONObject = new JSONObject(m867);
                return jSONObject.getString("cellId") + StringUtil.ARRAY_ELEMENT_SEPARATOR + jSONObject.getString("lac");
            } catch (Throwable unused) {
                return C0453.f699;
            }
        }
        return (String) invokeV.objValue;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static String m885(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65572, null, context)) == null) {
            try {
                return m867(b.t().a());
            } catch (Throwable unused) {
                return C0453.f699;
            }
        }
        return (String) invokeL.objValue;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static String m886() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65573, null)) == null) {
            return "ANDROID_" + Build.VERSION.RELEASE;
        }
        return (String) invokeV.objValue;
    }

    @SuppressLint({"LocalSuppress", "NewApi"})
    /* renamed from: ˎ  reason: contains not printable characters */
    public static String m887(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65574, null, context)) == null) ? C0453.f699 : (String) invokeL.objValue;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static String m888(Context context) {
        InterceptResult invokeL;
        StringBuilder sb;
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65575, null, context)) == null) {
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
                            String m852 = m852(accessibilityServiceInfo);
                            if (sb.indexOf(m852) == -1) {
                                sb.append(m852);
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

    /* renamed from: ˏ  reason: contains not printable characters */
    public static JSONArray m889() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65576, null)) == null) {
            try {
                String m867 = m867(b.t().n());
                if (!TextUtils.isEmpty(m867) && !m867.startsWith("RISK")) {
                    JSONArray jSONArray = new JSONArray();
                    JSONArray jSONArray2 = new JSONArray(m867);
                    for (int i = 0; i < jSONArray2.length(); i++) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("1", jSONArray2.getJSONObject(i).getString("ssid"));
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

    /* renamed from: ˑ  reason: contains not printable characters */
    public static String m890(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65577, null, context)) == null) {
            try {
                return (String) context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.loadLabel(context.getPackageManager());
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    /* renamed from: י  reason: contains not printable characters */
    public static String m891(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65578, null, context)) == null) {
            try {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    /* renamed from: ـ  reason: contains not printable characters */
    public static String m892(Context context) {
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

    /* renamed from: ٴ  reason: contains not printable characters */
    public static String m893(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65580, null, context)) == null) {
            try {
                return m867(b.t().h());
            } catch (Throwable unused) {
                return C0453.f699;
            }
        }
        return (String) invokeL.objValue;
    }

    /* renamed from: ᐧ  reason: contains not printable characters */
    public static String m894(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65581, null, context)) == null) {
            try {
                return m867(b.t().a());
            } catch (Throwable unused) {
                return C0453.f699;
            }
        }
        return (String) invokeL.objValue;
    }

    /* renamed from: ᐧᐧ  reason: contains not printable characters */
    public static String m895(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65582, null, context)) == null) {
            try {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.name;
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    /* renamed from: ᴵ  reason: contains not printable characters */
    public static String m896(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65583, null, context)) == null) {
            try {
                return m867(b.t().a());
            } catch (Throwable unused) {
                return C0453.f699;
            }
        }
        return (String) invokeL.objValue;
    }

    /* renamed from: ᴵᴵ  reason: contains not printable characters */
    public static String m897(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65584, null, context)) == null) {
            try {
                ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
                if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
                    return C0453.f695;
                }
                JSONArray jSONArray = new JSONArray();
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo != null) {
                        jSONArray.put(runningAppProcessInfo.processName);
                    }
                }
                String jSONArray2 = jSONArray.toString();
                return TextUtils.isEmpty(jSONArray2) ? C0453.f697 : jSONArray2;
            } catch (Throwable unused) {
                return C0453.f699;
            }
        }
        return (String) invokeL.objValue;
    }

    /* renamed from: ᵎ  reason: contains not printable characters */
    public static String m898(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65585, null, context)) == null) {
            try {
                return m867(b.t().g());
            } catch (Throwable unused) {
                return C0453.f699;
            }
        }
        return (String) invokeL.objValue;
    }

    /* renamed from: ᵔ  reason: contains not printable characters */
    public static String m899(Context context) {
        InterceptResult invokeL;
        List<InputMethodInfo> enabledInputMethodList;
        ActivityInfo activityInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65586, null, context)) == null) {
            String str = "";
            if (context != null) {
                try {
                    PackageManager packageManager = context.getPackageManager();
                    String string = Settings.Secure.getString(context.getContentResolver(), "default_input_method");
                    if (string == null) {
                        string = StringUtil.NULL_STRING;
                    }
                    String str2 = "1=" + string + ParamableElem.DIVIDE_PARAM;
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
                            sb.append(ParamableElem.DIVIDE_PARAM);
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
    /* renamed from: ᵢ  reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String m900(Context context) {
        InterceptResult invokeL;
        StringBuilder sb;
        List<AccessibilityServiceInfo> installedAccessibilityServiceList;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65587, null, context)) != null) {
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
                    String m852 = m852(accessibilityServiceInfo);
                    if (sb.indexOf(m852) == -1) {
                        sb.append(m852);
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
    /* renamed from: ⁱ  reason: contains not printable characters */
    public static String m901(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65588, null, context)) == null) {
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

    @TargetApi(22)
    /* renamed from: ﹳ  reason: contains not printable characters */
    public static int m902(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65589, null, context)) == null) {
            return -2;
        }
        return invokeL.intValue;
    }

    /* renamed from: ﹶ  reason: contains not printable characters */
    public static String m903(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65590, null, context)) == null) {
            try {
                return m867(b.t().b());
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    /* renamed from: ﾞ  reason: contains not printable characters */
    public static String m904(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65591, null, context)) == null) {
            StringBuilder sb = new StringBuilder();
            try {
                String[] strArr = {PermissionChecker.READ_PHONE_STATE, "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_CONTACTS", "android.permission.CAMERA", "android.permission.RECORD_AUDIO", PermissionChecker.ACCESS_FINE_LOCATION, PermissionChecker.ACCESS_COARSE_LOCATION, "android.permission.BLUETOOTH", "android.permission.WRITE_CALENDAR", "android.permission.READ_CALENDAR"};
                for (int i = 0; i < 11; i++) {
                    sb.append(C0306.m179(context, strArr[i]) == 0 ? "1" : "0");
                }
            } catch (Exception unused) {
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    @TargetApi(23)
    /* renamed from: ﾞﾞ  reason: contains not printable characters */
    public static int m905(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65592, null, context)) == null) {
            try {
                String m867 = m867(b.t().i());
                if (TextUtils.isEmpty(m867) || m867.startsWith("RISK")) {
                    return -1;
                }
                return Integer.parseInt(m867);
            } catch (Throwable unused) {
                return -2;
            }
        }
        return invokeL.intValue;
    }
}
