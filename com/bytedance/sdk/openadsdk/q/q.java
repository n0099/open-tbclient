package com.bytedance.sdk.openadsdk.q;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.StatFs;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebSettings;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.JProtect;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.core.e.x;
import com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView;
import com.bytedance.sdk.openadsdk.core.z;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class q {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static volatile String f68874a = "";

    /* renamed from: b  reason: collision with root package name */
    public static volatile String f68875b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile String f68876c;

    /* renamed from: d  reason: collision with root package name */
    public static volatile String f68877d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(98109789, "Lcom/bytedance/sdk/openadsdk/q/q;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(98109789, "Lcom/bytedance/sdk/openadsdk/q/q;");
        }
    }

    public static int a(AdSlot adSlot) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, adSlot)) == null) {
            if (adSlot == null) {
                return 0;
            }
            try {
                return Integer.parseInt(adSlot.getCodeId());
            } catch (Exception unused) {
                return 0;
            }
        }
        return invokeL.intValue;
    }

    public static int a(com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65538, null, cVar, z)) == null) {
            if (cVar == null || cVar.v() == null || !cVar.v().g()) {
                return 3;
            }
            return !z ? 1 : 0;
        }
        return invokeLZ.intValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int a(String str) {
        InterceptResult invokeL;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            switch (str.hashCode()) {
                case -1695837674:
                    if (str.equals("banner_ad")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1364000502:
                    if (str.equals("rewarded_video")) {
                        c2 = 7;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -764631662:
                    if (str.equals("fullscreen_interstitial_ad")) {
                        c2 = 6;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -712491894:
                    if (str.equals("embeded_ad")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 174971131:
                    if (str.equals("splash_ad")) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 564365438:
                    if (str.equals("cache_splash_ad")) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1844104722:
                    if (str.equals(ThreadAchievementShareDialogView.THREAD_INTERACTION_VIEW_TYPE)) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1912999166:
                    if (str.equals("draw_ad")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            switch (c2) {
                case 1:
                    return 6;
                case 2:
                    return 2;
                case 3:
                    return 3;
                case 4:
                case 5:
                    return 4;
                case 6:
                    return 5;
                case 7:
                    return 7;
                default:
                    return 1;
            }
        }
        return invokeL.intValue;
    }

    public static long a(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(InputDeviceCompat.SOURCE_TRACKBALL, null, j2)) == null) ? (j2 + TimeZone.getDefault().getOffset(j2)) / 86400000 : invokeJ.longValue;
    }

    public static String a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.AD_TEXT_ID, null, i2)) == null) {
            switch (i2) {
                case 1:
                    return "embeded_ad_landingpage";
                case 2:
                    return "banner_ad_landingpage";
                case 3:
                    return "interaction_landingpage";
                case 4:
                    return "splash_ad_landingpage";
                case 5:
                    return "fullscreen_interstitial_ad_landingpage";
                case 6:
                    return "draw_ad_landingpage";
                case 7:
                    return "rewarded_video_landingpage";
                default:
                    return null;
            }
        }
        return (String) invokeI.objValue;
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context)) == null) {
            String b2 = com.bytedance.sdk.openadsdk.core.c.a(context).b("total_memory", (String) null);
            if (b2 == null) {
                String e2 = e(context, "MemTotal");
                com.bytedance.sdk.openadsdk.core.c.a(context).a("total_memory", e2);
                return e2;
            }
            return b2;
        }
        return (String) invokeL.objValue;
    }

    public static String a(com.bytedance.sdk.openadsdk.core.e.m mVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, mVar)) == null) {
            if (mVar == null) {
                return null;
            }
            try {
                return b(c(mVar.ao()));
            } catch (Throwable unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    @Keep
    @JProtect
    public static String a(com.bytedance.sdk.openadsdk.core.e.m mVar, View view) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, mVar, view)) == null) {
            if (mVar == null) {
                return "";
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("rit", d(mVar.ao()));
                jSONObject.put("app_id", com.bytedance.sdk.openadsdk.core.h.d().h());
                jSONObject.put("creative_id", mVar.ak());
                jSONObject.put("ad_sdk_version", 3703);
                jSONObject.put("ad_slot_type", c(mVar.ao()));
                if (view != null) {
                    jSONObject.put("ad_width", view.getWidth());
                    jSONObject.put("ad_height", view.getHeight());
                    int[] iArr = new int[2];
                    view.getLocationOnScreen(iArr);
                    jSONObject.put("ad_x", iArr[0]);
                    jSONObject.put("ad_y", iArr[1]);
                    a(iArr, jSONObject);
                }
                jSONObject.put("screen_width", s.c(com.bytedance.sdk.openadsdk.core.o.a()));
                jSONObject.put("screen_height", s.d(com.bytedance.sdk.openadsdk.core.o.a()));
            } catch (Exception unused) {
            }
            String a2 = com.bytedance.sdk.component.utils.a.a(jSONObject.toString());
            if (TextUtils.isEmpty(a2)) {
                return "";
            }
            return "show_3 " + a2;
        }
        return (String) invokeLL.objValue;
    }

    public static String a(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65545, null, str, z)) == null) {
            String format = String.format("https://%s%s", com.bytedance.sdk.openadsdk.core.o.h().b(), str);
            if (p.a()) {
                if (!z) {
                    format = p.b(format);
                }
                String a2 = p.a("testIp.txt");
                if (a2 != null) {
                    format = p.a(format, a2);
                }
            }
            return z ? p(format) : format;
        }
        return (String) invokeLZ.objValue;
    }

    public static Map<String, Object> a(com.bytedance.sdk.openadsdk.core.e.m mVar, long j2, com.bytedance.sdk.openadsdk.core.video.c.d dVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{mVar, Long.valueOf(j2), dVar})) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("creative_id", mVar.ak());
            hashMap.put("buffers_time", Long.valueOf(j2));
            x V = mVar.V();
            if (V != null) {
                hashMap.put("video_size", Long.valueOf(V.d()));
                hashMap.put("video_resolution", V.f());
            }
            a(hashMap, dVar);
            return hashMap;
        }
        return (Map) invokeCommon.objValue;
    }

    public static Map<String, Object> a(boolean z, com.bytedance.sdk.openadsdk.core.e.m mVar, long j2, long j3, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, null, new Object[]{Boolean.valueOf(z), mVar, Long.valueOf(j2), Long.valueOf(j3), str})) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("creative_id", mVar.ak());
            hashMap.put("load_time", Long.valueOf(j2));
            x V = mVar.V();
            if (V != null) {
                hashMap.put("video_size", Long.valueOf(V.d()));
                hashMap.put("video_resolution", V.f());
                hashMap.put("video_preload_size", Long.valueOf(Build.VERSION.SDK_INT >= 23 ? V.m() : V.d()));
            }
            if (!z) {
                hashMap.put("error_code", Long.valueOf(j3));
                if (TextUtils.isEmpty(str)) {
                    str = "unknown";
                }
                hashMap.put("error_message", str);
            }
            return hashMap;
        }
        return (Map) invokeCommon.objValue;
    }

    public static void a(Map<String, Object> map, com.bytedance.sdk.openadsdk.core.video.c.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65548, null, map, dVar) == null) || map.containsKey("video_resolution") || dVar == null) {
            return;
        }
        try {
            if (dVar.a() != null) {
                map.put("video_resolution", String.format(Locale.getDefault(), "%d×%d", Integer.valueOf(dVar.a().getVideoWidth()), Integer.valueOf(dVar.a().getVideoHeight())));
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(int[] iArr, JSONObject jSONObject) {
        byte[] d2;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, iArr, jSONObject) == null) {
            File file = new File("/sdcard/bytedance/screen.log");
            if (!file.exists() || file.length() <= 0 || (d2 = com.bytedance.sdk.component.utils.f.d(file)) == null || (split = new String(d2).trim().split(",")) == null || split.length <= 1) {
                return;
            }
            try {
                int parseInt = Integer.parseInt(split[0].trim());
                int parseInt2 = Integer.parseInt(split[1].trim());
                jSONObject.put("ad_a_x", parseInt + iArr[0]);
                jSONObject.put("ad_a_y", iArr[1] + parseInt2);
            } catch (Exception unused) {
            }
        }
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? (com.bytedance.sdk.openadsdk.core.h.d() == null || com.bytedance.sdk.openadsdk.core.h.d().a()) ? false : true : invokeV.booleanValue;
    }

    public static boolean a(long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65551, null, new Object[]{Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            long j4 = j3 - j2;
            return j4 < 86400000 && j4 > -86400000 && a(j2) == a(j3);
        }
        return invokeCommon.booleanValue;
    }

    public static boolean a(Context context, Intent intent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, context, intent)) == null) {
            if (intent == null || context == null || !k(context)) {
                return false;
            }
            try {
                List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
                if (queryIntentActivities != null) {
                    return queryIntentActivities.size() > 0;
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static boolean a(Context context, String str) {
        InterceptResult invokeLL;
        Intent b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65553, null, context, str)) == null) {
            if (context != null && !TextUtils.isEmpty(str)) {
                try {
                    if (k(context)) {
                        if (!c(context, str) || (b2 = b(context, str)) == null) {
                            return false;
                        }
                        b2.putExtra("START_ONLY_FOR_ANDROID", true);
                        com.bytedance.sdk.component.utils.b.a(context, b2, null);
                        return true;
                    }
                    Intent b3 = b(context, str);
                    if (b3 == null) {
                        return false;
                    }
                    b3.putExtra("START_ONLY_FOR_ANDROID", true);
                    context.startActivity(b3);
                    return true;
                } catch (Throwable unused) {
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean a(com.bytedance.sdk.openadsdk.core.e.m mVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65554, null, mVar, str)) == null) {
            if (mVar != null) {
                try {
                    String Z = mVar.Z();
                    if (TextUtils.isEmpty(Z) && mVar.an() != null && mVar.an().c() == 1 && !TextUtils.isEmpty(mVar.an().b())) {
                        Z = mVar.an().b();
                    }
                    String str2 = Z;
                    if (!TextUtils.isEmpty(str2)) {
                        z.a(com.bytedance.sdk.openadsdk.core.o.a(), str2, mVar, a(str), str, false, null);
                        return true;
                    }
                } catch (Throwable unused) {
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static Intent b(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65555, null, context, str)) == null) {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
            if (launchIntentForPackage == null) {
                return null;
            }
            if (!launchIntentForPackage.hasCategory("android.intent.category.LAUNCHER")) {
                launchIntentForPackage.addCategory("android.intent.category.LAUNCHER");
            }
            launchIntentForPackage.setPackage(null);
            launchIntentForPackage.addFlags(2097152);
            launchIntentForPackage.addFlags(268435456);
            return launchIntentForPackage;
        }
        return (Intent) invokeLL.objValue;
    }

    public static String b() {
        InterceptResult invokeV;
        String defaultUserAgent;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) {
            if (TextUtils.isEmpty(f68874a)) {
                try {
                    f68874a = com.bytedance.sdk.openadsdk.core.h.a("sdk_local_web_ua", 86400000L);
                    if (TextUtils.isEmpty(f68874a)) {
                        if (Build.VERSION.SDK_INT >= 17) {
                            defaultUserAgent = WebSettings.getDefaultUserAgent(com.bytedance.sdk.openadsdk.core.o.a());
                        } else if (Looper.myLooper() == Looper.getMainLooper()) {
                            defaultUserAgent = new SSWebView(com.bytedance.sdk.openadsdk.core.o.a()).getSettings().getUserAgentString();
                        } else {
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.q.q.1
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

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                        try {
                                            String unused = q.f68874a = new SSWebView(com.bytedance.sdk.openadsdk.core.o.a()).getSettings().getUserAgentString();
                                        } catch (Exception unused2) {
                                        }
                                    }
                                }
                            });
                            com.bytedance.sdk.openadsdk.core.h.a("sdk_local_web_ua", f68874a);
                        }
                        f68874a = defaultUserAgent;
                        com.bytedance.sdk.openadsdk.core.h.a("sdk_local_web_ua", f68874a);
                    }
                } catch (Exception unused) {
                }
                return o(f68874a);
            }
            return f68874a;
        }
        return (String) invokeV.objValue;
    }

    public static String b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65557, null, i2)) == null) {
            switch (i2) {
                case 1:
                    return "banner_ad";
                case 2:
                    return ThreadAchievementShareDialogView.THREAD_INTERACTION_VIEW_TYPE;
                case 3:
                case 4:
                    return "splash_ad";
                case 5:
                default:
                    return "embeded_ad";
                case 6:
                    return "stream";
                case 7:
                    return "rewarded_video";
                case 8:
                    return "fullscreen_interstitial_ad";
                case 9:
                    return "draw_ad";
            }
        }
        return (String) invokeI.objValue;
    }

    public static String b(long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65558, null, new Object[]{Long.valueOf(j2), Long.valueOf(j3)})) == null) ? String.valueOf(((int) (Math.abs(j3 - j2) / 86400000)) + 1) : (String) invokeCommon.objValue;
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65559, null, context)) == null) ? com.bytedance.sdk.openadsdk.core.c.a(context).b("total_memory", "0") : (String) invokeL.objValue;
    }

    public static Map<String, Object> b(boolean z, com.bytedance.sdk.openadsdk.core.e.m mVar, long j2, long j3, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65560, null, new Object[]{Boolean.valueOf(z), mVar, Long.valueOf(j2), Long.valueOf(j3), str})) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("creative_id", mVar.ak());
            hashMap.put("load_time", Long.valueOf(j2));
            if (!z) {
                hashMap.put("error_code", Long.valueOf(j3));
                if (TextUtils.isEmpty(str)) {
                    str = "unknown";
                }
                hashMap.put("error_message", str);
            }
            return hashMap;
        }
        return (Map) invokeCommon.objValue;
    }

    public static JSONObject b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, null, str)) == null) {
            if (TextUtils.isEmpty(str) || str == null || str.isEmpty()) {
                return null;
            }
            try {
                return new JSONObject(str);
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    public static boolean b(com.bytedance.sdk.openadsdk.core.e.m mVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65562, null, mVar)) == null) ? mVar != null && c(mVar.ao()) == 9 : invokeL.booleanValue;
    }

    public static int c(int i2) {
        InterceptResult invokeI;
        BufferedReader bufferedReader;
        Throwable th;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeI = interceptable.invokeI(65563, null, i2)) != null) {
            return invokeI.intValue;
        }
        FileReader fileReader = null;
        BufferedReader bufferedReader2 = null;
        int i3 = 0;
        while (true) {
            i2--;
            if (i2 < 0) {
                return i3;
            }
            try {
                FileReader fileReader2 = new FileReader("/sys/devices/system/cpu/cpu" + i2 + "/cpufreq/cpuinfo_max_freq");
                try {
                    BufferedReader bufferedReader3 = new BufferedReader(fileReader2);
                    try {
                        int parseInt = Integer.parseInt(bufferedReader3.readLine());
                        if (parseInt > i3) {
                            i3 = parseInt;
                        }
                        try {
                            bufferedReader3.close();
                            fileReader2.close();
                        } catch (Exception unused) {
                        }
                        bufferedReader2 = bufferedReader3;
                        fileReader = fileReader2;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader = bufferedReader3;
                        fileReader = fileReader2;
                        try {
                            com.bytedance.sdk.component.utils.k.f("ToolUtils", th.getMessage());
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Exception unused2) {
                                    bufferedReader2 = bufferedReader;
                                }
                            }
                            bufferedReader2 = bufferedReader;
                        } finally {
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Exception unused3) {
                                }
                            }
                            if (fileReader != null) {
                                fileReader.close();
                            }
                        }
                    }
                } catch (Throwable th3) {
                    BufferedReader bufferedReader4 = bufferedReader2;
                    th = th3;
                    fileReader = fileReader2;
                    bufferedReader = bufferedReader4;
                }
            } catch (Throwable th4) {
                bufferedReader = bufferedReader2;
                th = th4;
            }
        }
    }

    public static int c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65564, null, context)) == null) ? com.bytedance.sdk.openadsdk.core.c.a(context).b("cpu_count", 0) : invokeL.intValue;
    }

    public static int c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65565, null, str)) == null) {
            JSONObject b2 = b(str);
            if (b2 != null) {
                return b2.optInt("ad_slot_type", 0);
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65566, null)) == null) ? UUID.randomUUID().toString() : (String) invokeV.objValue;
    }

    public static boolean c(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65567, null, context, str)) == null) {
            if (context == null || !k(context) || TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                return context.getPackageManager().getPackageInfo(str, 0) != null;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static boolean c(com.bytedance.sdk.openadsdk.core.e.m mVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65568, null, mVar)) == null) {
            if (mVar == null || mVar.ao() == null) {
                return false;
            }
            return c(mVar.ao()) == 5 || c(mVar.ao()) == 1 || c(mVar.ao()) == 2;
        }
        return invokeL.booleanValue;
    }

    public static int d(int i2) {
        InterceptResult invokeI;
        BufferedReader bufferedReader;
        Throwable th;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeI = interceptable.invokeI(65569, null, i2)) != null) {
            return invokeI.intValue;
        }
        FileReader fileReader = null;
        BufferedReader bufferedReader2 = null;
        int i3 = 0;
        while (true) {
            i2--;
            if (i2 < 0) {
                return i3;
            }
            try {
                FileReader fileReader2 = new FileReader("/sys/devices/system/cpu/cpu" + i2 + "/cpufreq/cpuinfo_min_freq");
                try {
                    BufferedReader bufferedReader3 = new BufferedReader(fileReader2);
                    try {
                        int parseInt = Integer.parseInt(bufferedReader3.readLine());
                        if (parseInt < i3 || i3 == 0) {
                            i3 = parseInt;
                        }
                        try {
                            bufferedReader3.close();
                            fileReader2.close();
                        } catch (Exception unused) {
                        }
                        bufferedReader2 = bufferedReader3;
                        fileReader = fileReader2;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader = bufferedReader3;
                        fileReader = fileReader2;
                        try {
                            com.bytedance.sdk.component.utils.k.f("ToolUtils", th.getMessage());
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Exception unused2) {
                                    bufferedReader2 = bufferedReader;
                                }
                            }
                            bufferedReader2 = bufferedReader;
                        } finally {
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Exception unused3) {
                                }
                            }
                            if (fileReader != null) {
                                fileReader.close();
                            }
                        }
                    }
                } catch (Throwable th3) {
                    BufferedReader bufferedReader4 = bufferedReader2;
                    th = th3;
                    fileReader = fileReader2;
                    bufferedReader = bufferedReader4;
                }
            } catch (Throwable th4) {
                bufferedReader = bufferedReader2;
                th = th4;
            }
        }
    }

    public static int d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65570, null, context)) == null) ? com.bytedance.sdk.openadsdk.core.c.a(context).b("cpu_max_frequency", 0) : invokeL.intValue;
    }

    public static int d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65571, null, str)) == null) {
            JSONObject b2 = b(str);
            if (b2 != null) {
                return b2.optInt("rit", 0);
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65572, null)) == null) {
            if (TextUtils.isEmpty(f68877d)) {
                if (com.bytedance.sdk.openadsdk.core.o.a() != null) {
                    try {
                        f68877d = com.bytedance.sdk.openadsdk.core.o.a().getPackageName();
                    } catch (Throwable th) {
                        com.bytedance.sdk.component.utils.k.c("ToolUtils", "ToolUtils getPackageName throws exception :", th);
                    }
                }
                return f68877d;
            }
            return f68877d;
        }
        return (String) invokeV.objValue;
    }

    public static boolean d(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65573, null, context, str)) == null) {
            if (context != null && !TextUtils.isEmpty(str)) {
                try {
                    Intent intent = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + Uri.encode(str)));
                    if (!(context instanceof Activity)) {
                        intent.setFlags(268435456);
                    }
                    com.bytedance.sdk.component.utils.b.a(context, intent, null);
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean d(com.bytedance.sdk.openadsdk.core.e.m mVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65574, null, mVar)) == null) {
            if (mVar != null) {
                return c(mVar.ao()) == 3 || c(mVar.ao()) == 4;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static int e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65575, null, context)) == null) ? com.bytedance.sdk.openadsdk.core.c.a(context).b("cpu_min_frequency", 0) : invokeL.intValue;
    }

    public static long e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65576, null, str)) == null) {
            JSONObject b2 = b(str);
            if (b2 != null) {
                return b2.optLong("uid", 0L);
            }
            return 0L;
        }
        return invokeL.longValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65577, null)) == null) {
            if (TextUtils.isEmpty(f68875b) && com.bytedance.sdk.openadsdk.core.o.a() != null) {
                try {
                    PackageInfo packageInfo = com.bytedance.sdk.openadsdk.core.o.a().getPackageManager().getPackageInfo(d(), 0);
                    f68875b = String.valueOf(packageInfo.versionCode);
                    f68876c = packageInfo.versionName;
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.k.c("ToolUtils", "ToolUtils getVersionCode throws exception :", th);
                }
            }
            return f68875b;
        }
        return (String) invokeV.objValue;
    }

    public static String e(Context context, String str) {
        InterceptResult invokeLL;
        FileReader fileReader;
        BufferedReader bufferedReader;
        String readLine;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65578, null, context, str)) != null) {
            return (String) invokeLL.objValue;
        }
        try {
            fileReader = new FileReader("/proc/meminfo");
            try {
                bufferedReader = new BufferedReader(fileReader, 4096);
                do {
                    try {
                        readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                    } catch (Throwable th) {
                        th = th;
                        try {
                            th.printStackTrace();
                            if (fileReader != null) {
                                try {
                                    fileReader.close();
                                } catch (Exception unused) {
                                }
                            }
                            return null;
                        } finally {
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Exception unused2) {
                                }
                            }
                            if (fileReader != null) {
                                try {
                                    fileReader.close();
                                } catch (Exception unused3) {
                                }
                            }
                        }
                    }
                } while (!readLine.contains(str));
                if (readLine == null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception unused4) {
                    }
                    try {
                        fileReader.close();
                    } catch (Exception unused5) {
                    }
                    return null;
                }
                String[] split = readLine.split("\\s+");
                com.bytedance.sdk.component.utils.k.b("ToolUtils", "getTotalMemory = " + split[1]);
                String str2 = split[1];
                try {
                    bufferedReader.close();
                } catch (Exception unused6) {
                }
                try {
                    fileReader.close();
                } catch (Exception unused7) {
                }
                return str2;
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
            }
        } catch (Throwable th3) {
            th = th3;
            fileReader = null;
            bufferedReader = null;
        }
    }

    public static boolean e(com.bytedance.sdk.openadsdk.core.e.m mVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65579, null, mVar)) == null) ? mVar != null && c(mVar.ao()) == 7 : invokeL.booleanValue;
    }

    public static int f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65580, null, str)) == null) {
            JSONObject b2 = b(str);
            if (b2 != null) {
                return b2.optInt("ut", 0);
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static long f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65581, null, context)) == null) ? com.bytedance.sdk.openadsdk.core.c.a(context).b("total_internal_storage", 0L).longValue() : invokeL.longValue;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65582, null)) == null) {
            if (TextUtils.isEmpty(f68876c) && com.bytedance.sdk.openadsdk.core.o.a() != null) {
                try {
                    PackageInfo packageInfo = com.bytedance.sdk.openadsdk.core.o.a().getPackageManager().getPackageInfo(d(), 0);
                    f68875b = String.valueOf(packageInfo.versionCode);
                    f68876c = packageInfo.versionName;
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.k.c("ToolUtils", "ToolUtils getVersionName throws exception :", th);
                }
            }
            return f68876c;
        }
        return (String) invokeV.objValue;
    }

    public static boolean f(com.bytedance.sdk.openadsdk.core.e.m mVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65583, null, mVar)) == null) ? mVar != null && c(mVar.ao()) == 8 : invokeL.booleanValue;
    }

    public static double g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65584, null, str)) == null) {
            JSONObject b2 = b(str);
            if (b2 != null) {
                return b2.optDouble("pack_time", 0.0d);
            }
            return 0.0d;
        }
        return invokeL.doubleValue;
    }

    public static int g() {
        InterceptResult invokeV;
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65585, null)) == null) {
            if (Build.VERSION.SDK_INT >= 17) {
                return Math.max(Runtime.getRuntime().availableProcessors(), 0);
            }
            try {
                File file = new File("/sys/devices/system/cpu/");
                if (!file.exists() || (listFiles = file.listFiles(new FilenameFilter() { // from class: com.bytedance.sdk.openadsdk.q.q.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public Pattern f68878a;

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
                                return;
                            }
                        }
                        this.f68878a = Pattern.compile("^cpu[0-9]+$");
                    }

                    @Override // java.io.FilenameFilter
                    public boolean accept(File file2, String str) {
                        InterceptResult invokeLL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, file2, str)) == null) ? this.f68878a.matcher(str).matches() : invokeLL.booleanValue;
                    }
                })) == null) {
                    return 0;
                }
                return Math.max(listFiles.length, 0);
            } catch (Throwable unused) {
                return 0;
            }
        }
        return invokeV.intValue;
    }

    public static long g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65586, null, context)) == null) ? com.bytedance.sdk.openadsdk.core.c.a(context).b("free_internal_storage", 0L).longValue() : invokeL.longValue;
    }

    public static boolean g(com.bytedance.sdk.openadsdk.core.e.m mVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65587, null, mVar)) == null) ? (mVar == null || mVar.an() == null || TextUtils.isEmpty(mVar.an().a())) ? false : true : invokeL.booleanValue;
    }

    public static long h() {
        long blockSize;
        long blockCount;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65588, null)) == null) {
            try {
                StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                if (Build.VERSION.SDK_INT >= 18) {
                    blockSize = statFs.getBlockSizeLong();
                    blockCount = statFs.getBlockCountLong();
                } else {
                    blockSize = statFs.getBlockSize();
                    blockCount = statFs.getBlockCount();
                }
                return blockCount * blockSize;
            } catch (Throwable unused) {
                return 0L;
            }
        }
        return invokeV.longValue;
    }

    public static long h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65589, null, context)) == null) ? com.bytedance.sdk.openadsdk.core.c.a(context).b("total_sdcard_storage", 0L).longValue() : invokeL.longValue;
    }

    public static String h(com.bytedance.sdk.openadsdk.core.e.m mVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65590, null, mVar)) == null) ? g(mVar) ? "deeplink_fail" : "installed" : (String) invokeL.objValue;
    }

    public static String h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65591, null, str)) == null) {
            JSONObject b2 = b(str);
            return b2 != null ? b2.optString(IAdRequestParam.REQ_ID, "") : "";
        }
        return (String) invokeL.objValue;
    }

    public static int i(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65592, null, context)) == null) ? com.bytedance.sdk.openadsdk.core.c.a(context).b("is_root", -1) : invokeL.intValue;
    }

    public static int i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65593, null, str)) == null) {
            JSONObject b2 = b(str);
            if (b2 != null) {
                return b2.optInt("pricing", 0);
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static long i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65594, null)) == null) {
            try {
                if (p()) {
                    StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                    return statFs.getBlockSize() * statFs.getBlockCount();
                }
                return 0L;
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.k.f("ToolUtils", th.getMessage());
                return 0L;
            }
        }
        return invokeV.longValue;
    }

    public static String i(com.bytedance.sdk.openadsdk.core.e.m mVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65595, null, mVar)) == null) {
            if (mVar == null || mVar.al() == null || TextUtils.isEmpty(mVar.al().b())) {
                return null;
            }
            return mVar.al().b();
        }
        return (String) invokeL.objValue;
    }

    public static String j(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65596, null, context)) == null) {
            try {
                return (Build.VERSION.SDK_INT >= 24 ? context.getResources().getConfiguration().getLocales().get(0) : Locale.getDefault()).getLanguage();
            } catch (Exception e2) {
                com.bytedance.sdk.component.utils.k.f("ToolUtils", e2.toString());
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65597, null)) == null) {
            try {
                if (!new File("/system/bin/su").exists()) {
                    if (!new File("/system/xbin/su").exists()) {
                        return false;
                    }
                }
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean j(com.bytedance.sdk.openadsdk.core.e.m mVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65598, null, mVar)) == null) {
            if (mVar == null) {
                return true;
            }
            int d2 = com.bytedance.sdk.openadsdk.core.o.h().d(d(mVar.ao()));
            if (d2 != 1) {
                if (d2 == 2) {
                    return com.bytedance.sdk.component.utils.n.e(com.bytedance.sdk.openadsdk.core.o.a()) || com.bytedance.sdk.component.utils.n.d(com.bytedance.sdk.openadsdk.core.o.a()) || com.bytedance.sdk.component.utils.n.f(com.bytedance.sdk.openadsdk.core.o.a());
                } else if (d2 != 3) {
                    return d2 != 5 || com.bytedance.sdk.component.utils.n.d(com.bytedance.sdk.openadsdk.core.o.a()) || com.bytedance.sdk.component.utils.n.f(com.bytedance.sdk.openadsdk.core.o.a());
                } else {
                    return false;
                }
            }
            return com.bytedance.sdk.component.utils.n.d(com.bytedance.sdk.openadsdk.core.o.a());
        }
        return invokeL.booleanValue;
    }

    public static byte[] j(String str) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65599, null, str)) == null) {
            if (str == null || str.length() == 0) {
                return null;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            try {
                try {
                    gZIPOutputStream.write(str.getBytes());
                    try {
                        gZIPOutputStream.close();
                    } catch (Exception e2) {
                        com.bytedance.sdk.component.utils.k.c(e2.toString());
                    }
                    return byteArrayOutputStream.toByteArray();
                } catch (Throwable th) {
                    try {
                        gZIPOutputStream.close();
                    } catch (Exception e3) {
                        com.bytedance.sdk.component.utils.k.c(e3.toString());
                    }
                    throw th;
                }
            } catch (Exception e4) {
                com.bytedance.sdk.component.utils.k.c(e4.toString());
                try {
                    gZIPOutputStream.close();
                } catch (Exception e5) {
                    com.bytedance.sdk.component.utils.k.c(e5.toString());
                }
                return null;
            }
        }
        return (byte[]) invokeL.objValue;
    }

    public static String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65600, null)) == null) ? p.b(String.format("https://%s", com.bytedance.sdk.openadsdk.core.o.h().d())) : (String) invokeV.objValue;
    }

    public static boolean k(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65601, null, context)) == null) {
            if (context != null) {
                boolean z = context.getApplicationInfo().targetSdkVersion >= 30 && Build.VERSION.SDK_INT >= 30 && context.checkSelfPermission("android.permission.QUERY_ALL_PACKAGES") != 0;
                StringBuilder sb = new StringBuilder();
                sb.append("can query all package = ");
                sb.append(!z);
                com.bytedance.sdk.component.utils.k.c("ToolUtils", sb.toString());
                return !z;
            }
            throw new IllegalArgumentException("params context is null");
        }
        return invokeL.booleanValue;
    }

    public static boolean k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65602, null, str)) == null) {
            try {
                return Pattern.compile("[一-龥]").matcher(str).find();
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65603, null)) == null) ? p.b(String.format("https://%s", "log.snssdk.com/service/2/app_log_test/")) : (String) invokeV.objValue;
    }

    public static String l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65604, null, str)) == null) ? a(str, false) : (String) invokeL.objValue;
    }

    public static int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65605, null)) == null) {
            try {
                return (int) ((Runtime.getRuntime().maxMemory() * 1.0d) / 1048576.0d);
            } catch (Exception unused) {
                return -1;
            }
        }
        return invokeV.intValue;
    }

    public static String m(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65606, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            String str3 = "KLLK";
            if (str.contains("KLLK")) {
                str2 = "OPPO";
            } else {
                str3 = "kllk";
                if (!str.contains("kllk")) {
                    return "";
                }
                str2 = RomUtils.MANUFACTURER_OPPO;
            }
            return str.replace(str3, str2);
        }
        return (String) invokeL.objValue;
    }

    public static int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65607, null)) == null) {
            try {
                return (int) ((Runtime.getRuntime().freeMemory() * 1.0d) / 1048576.0d);
            } catch (Exception unused) {
                return -1;
            }
        }
        return invokeV.intValue;
    }

    public static int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65609, null)) == null) {
            try {
                return (int) ((Runtime.getRuntime().totalMemory() * 1.0d) / 1048576.0d);
            } catch (Exception unused) {
                return -1;
            }
        }
        return invokeV.intValue;
    }

    public static String o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65610, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            int length = str.length();
            for (int i2 = 0; i2 < length; i2++) {
                char charAt = str.charAt(i2);
                if (charAt <= 31 || charAt >= 127) {
                    sb.append(String.format("\\u%04x", Integer.valueOf(charAt)));
                } else {
                    sb.append(charAt);
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65611, null, str)) == null) {
            try {
                return Uri.parse(str).buildUpon().appendQueryParameter("aid", "1371").appendQueryParameter("device_platform", "android").appendQueryParameter("version_code", e()).toString();
            } catch (Exception unused) {
                return str;
            }
        }
        return (String) invokeL.objValue;
    }

    public static boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65612, null)) == null) {
            try {
                return "mounted".equals(Environment.getExternalStorageState());
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }
}
