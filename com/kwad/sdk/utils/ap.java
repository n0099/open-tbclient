package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.media.AudioManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Environment;
import android.os.LocaleList;
import android.os.Process;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.mobads.container.util.network.NetworkInfoUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.crash.utils.SystemUtil;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes2.dex */
public class ap {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static String f67549a = "";

    /* renamed from: b  reason: collision with root package name */
    public static String f67550b = "";

    /* renamed from: c  reason: collision with root package name */
    public static String f67551c = "";

    /* renamed from: d  reason: collision with root package name */
    public static int f67552d;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f67553e;

    /* renamed from: f  reason: collision with root package name */
    public static final String[] f67554f;

    /* renamed from: g  reason: collision with root package name */
    public static String f67555g;

    /* renamed from: h  reason: collision with root package name */
    public static String f67556h;

    /* renamed from: i  reason: collision with root package name */
    public static String f67557i;
    public static String j;
    public static String k;
    public static int l;
    public static boolean m;
    public static boolean n;
    public static boolean o;
    public static boolean p;
    public static boolean q;
    public static boolean r;
    public static int s;
    public static long t;
    public static boolean u;
    public static boolean v;
    public static final List<String> w;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(408734483, "Lcom/kwad/sdk/utils/ap;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(408734483, "Lcom/kwad/sdk/utils/ap;");
                return;
            }
        }
        f67554f = new String[]{"", ""};
        f67555g = "";
        f67556h = "";
        f67557i = "";
        l = -1;
        m = false;
        n = false;
        o = false;
        p = false;
        q = false;
        r = false;
        u = true;
        v = true;
        w = Arrays.asList("a5f5faddde9e9f02", "8e17f7422b35fbea", "b88c3c236923d9d9", "cb36bf76cca443d0", "5d4e49ed381836c5", "cffa38e9136f93e9", "62bd2daa59ea0173", "b7aad49a2d5bc5d9", "f2138912c5e5dd5c", "330a1e81a2bf9f31", "59c0f432ccbef844", "521376155e535f39", "aa5ec6ce14abd680", "5522a09bb500d82f", "6dfe4a96800edfb4", "ecc9a2dded8cdf72", "399f868043955b11", "34dc327c00dbff94", "d1b4e3862c309f8b", "68bdbf71f863ccac", "01558dd995085a35", "351174200a06da52", "fa0988506c76ff4b", "8eb8ef823312c61a", "a72e81be65c4638b", "416d15a015c8f324", "474086ea2d737519", "befdddf908c8d749", "780ee58a6f57aab6", "cfe86fa07cae3601", "704ff4d1534f0ff4", "9298b9e9bbd7cdea", "7b634c42f236c6e8", "11eacf22b9ceab7d", "2941a4f39eec5864", "87d134dc5ba45550", "fdd2313bb1750eb9", "6560ef232d8424bb", "5d876286e1064482", "f66fefb916f4962d", "7baf82d0ac49f596", "57748921d8d88ed4", "120cd57f1a50b8f5", "e164f9610ddd9fc8", "6256f0e8da6389de", "bcb22df712476416", "714fa9aff63f7adb", "cb8252e4da7cf610", "e18f649aa80e140c", "966790a9db5ea8d8", "e1769e681af901dd", "d23f2574a60964a4", "d717e6298d3c9cb2", "f5ea5e8ba730864e", "a8a0a223d1a42232", "6675a4f231f5c8db", "3edb7c2103e5c75a", "8ce6a9a216b326c4", "af606153eb3be0a7", "7ae255c3d760c920", "e50e94c40048c5fd", "55009bca30f9dc4c", "c37566487909214a", "891b74f7e534d14a", "726e190aae663525", "df473127d30fb669", "bfbcc646d92dfd48", "a4a1954c44751936", "da4a44a3d7c4d8be", "5ff5bca4a775dd30", "14917461e1917c53", "14ce20d0a80955fa", "a56a63de4d3f3d39", "f780246adc7bd556", "3495a541aea0da72", "f7f205ce47fed2a5", "f52db3f434279c3a", "dca17088c97dee5e", "dd53a8b3a2a4ccc0", "52e07629290d45e4", "cda522b0f8f50d9a", "b85a1c8bcd51d82c", "e344a00cd3f5e93a", "fa59d8a66d7bdd88", "68fb1f1393a216e8", "4c30ab1fb10af181", "b1376e0578099143", "88752f72d8d305fd", "fddf20078d27bf3c", "dab2120bffa2be8c", "c7c8dde481793471", "e4b1bdbcabfc284d");
    }

    public static int a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (com.kwad.sdk.core.config.c.a(512L)) {
                return 0;
            }
            try {
                if (Build.VERSION.SDK_INT >= 21) {
                    return ((BatteryManager) context.getApplicationContext().getSystemService("batterymanager")).getIntProperty(4);
                }
            } catch (Exception unused) {
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static synchronized int a(Context context, @Nullable TelephonyManager telephonyManager) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, telephonyManager)) == null) {
            synchronized (ap.class) {
                if (f67553e || f67552d > 0 || Build.VERSION.SDK_INT < 23 || (context == null && telephonyManager == null)) {
                    return f67552d;
                }
                if (telephonyManager == null) {
                    try {
                        telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    } catch (Exception unused) {
                        f67553e = true;
                    }
                }
                com.kwad.sdk.core.d.a.c("SystemUtils", "getPhoneCount");
                int phoneCount = telephonyManager.getPhoneCount();
                f67552d = phoneCount;
                if (phoneCount == 0) {
                    f67553e = true;
                }
                return f67552d;
            }
        }
        return invokeLL.intValue;
    }

    public static int a(@NonNull Context context, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, str)) == null) {
            if (str != null) {
                return context.checkPermission(str, Process.myPid(), Process.myUid());
            }
            throw new IllegalArgumentException("permission is null");
        }
        return invokeLL.intValue;
    }

    public static long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            try {
                return a(Environment.getDataDirectory());
            } catch (Exception unused) {
                return 0L;
            }
        }
        return invokeV.longValue;
    }

    public static long a(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, file)) == null) {
            if (file == null) {
                return 0L;
            }
            try {
                StatFs statFs = new StatFs(file.getPath());
                return Build.VERSION.SDK_INT < 18 ? statFs.getBlockSize() * statFs.getBlockCount() : statFs.getBlockSizeLong() * statFs.getBlockCountLong();
            } catch (Exception unused) {
                return 0L;
            }
        }
        return invokeL.longValue;
    }

    public static String a(String str, int i2, char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{str, Integer.valueOf(i2), Character.valueOf(c2)})) == null) {
            StringBuilder sb = new StringBuilder();
            while (sb.length() + str.length() < i2) {
                sb.append(c2);
            }
            sb.append(str);
            return sb.toString();
        }
        return (String) invokeCommon.objValue;
    }

    public static void a(SdkConfig sdkConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, sdkConfig) == null) {
            u = sdkConfig.canReadMacAddress();
            v = sdkConfig.canReadICCID();
        }
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) ? w.contains(str.toLowerCase(Locale.US)) : invokeL.booleanValue;
    }

    public static long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (com.kwad.sdk.core.config.c.a(1024L)) {
                return 0L;
            }
            try {
                return b(Environment.getDataDirectory());
            } catch (Exception unused) {
                return 0L;
            }
        }
        return invokeV.longValue;
    }

    public static long b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            long j2 = t;
            if (j2 > 0) {
                return j2;
            }
            if (context == null) {
                return 0L;
            }
            try {
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                ((ActivityManager) context.getApplicationContext().getSystemService("activity")).getMemoryInfo(memoryInfo);
                long j3 = memoryInfo.totalMem;
                if (j3 <= 0) {
                    j3 = o();
                }
                t = j3;
                return j3;
            } catch (Exception unused) {
                return 0L;
            }
        }
        return invokeL.longValue;
    }

    public static long b(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, file)) == null) {
            try {
                StatFs statFs = new StatFs(file.getPath());
                return Build.VERSION.SDK_INT < 18 ? statFs.getBlockSize() * statFs.getAvailableBlocks() : statFs.getBlockSizeLong() * statFs.getAvailableBlocksLong();
            } catch (Exception unused) {
                return 0L;
            }
        }
        return invokeL.longValue;
    }

    public static void b(String str) {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65548, null, str) == null) || (context = KsAdSDKImpl.get().getContext()) == null) {
            return;
        }
        context.getSharedPreferences("ksadsdk_pref", 0).edit().putString(IAdRequestParam.ANDROID_ID, str).apply();
    }

    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            int i2 = s;
            if (i2 > 0) {
                return i2;
            }
            int availableProcessors = Runtime.getRuntime().availableProcessors();
            s = availableProcessors;
            return availableProcessors;
        }
        return invokeV.intValue;
    }

    public static long c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, context)) == null) {
            if (context == null || com.kwad.sdk.core.config.c.a(1024L)) {
                return 0L;
            }
            try {
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
                return memoryInfo.availMem;
            } catch (Exception unused) {
                return 0L;
            }
        }
        return invokeL.longValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            Locale locale = Build.VERSION.SDK_INT >= 24 ? LocaleList.getDefault().get(0) : Locale.getDefault();
            if (locale == null) {
                locale = Locale.CHINESE;
            }
            return String.valueOf(locale);
        }
        return (String) invokeV.objValue;
    }

    public static String d(@Nullable Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, context)) == null) {
            String e2 = e(context);
            return (TextUtils.isEmpty(e2) && TextUtils.isEmpty(com.kwad.sdk.core.f.a.a(context))) ? com.kwad.sdk.core.config.c.X() : e2;
        }
        return (String) invokeL.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) ? Build.MODEL : (String) invokeV.objValue;
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    public static synchronized String e(@Nullable Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, context)) == null) {
            synchronized (ap.class) {
                if (m) {
                    return f67550b;
                }
                if (TextUtils.isEmpty(f67550b) && context != null) {
                    if (Build.VERSION.SDK_INT >= 29) {
                        return f67550b;
                    }
                    if (com.kwad.sdk.core.config.c.a(1L)) {
                        return f67550b;
                    }
                    boolean z = false;
                    try {
                        z = i(context);
                        if (z) {
                            String deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
                            f67550b = deviceId;
                            if (TextUtils.isEmpty(deviceId)) {
                                m = true;
                            }
                        }
                    } catch (Exception e2) {
                        com.kwad.sdk.core.d.a.a(e2);
                        if (z) {
                            m = true;
                        }
                    }
                    return f67550b;
                }
                return f67550b;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) ? Build.BRAND : (String) invokeV.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x003c, code lost:
        if (android.text.TextUtils.isEmpty(r5) != false) goto L25;
     */
    @SuppressLint({"HardwareIds", "MissingPermission"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized String f(@Nullable Context context) {
        InterceptResult invokeL;
        TelephonyManager telephonyManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, context)) == null) {
            synchronized (ap.class) {
                if (r) {
                    return f67551c;
                }
                if (!TextUtils.isEmpty(f67551c) || context == null) {
                    return f67551c;
                }
                boolean z = false;
                try {
                    z = i(context);
                    if (z && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null) {
                        if (Build.VERSION.SDK_INT >= 26) {
                            String meid = telephonyManager.getMeid();
                            f67551c = meid;
                        } else if (telephonyManager.getPhoneType() == 2) {
                            String deviceId = telephonyManager.getDeviceId();
                            f67551c = deviceId;
                            if (TextUtils.isEmpty(deviceId)) {
                            }
                        } else {
                            f67551c = null;
                        }
                        r = true;
                    }
                } catch (Exception e2) {
                    com.kwad.sdk.core.d.a.a(e2);
                    if (z) {
                        r = true;
                    }
                }
                return f67551c;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) ? Build.MANUFACTURER : (String) invokeV.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x007e, code lost:
        if (android.text.TextUtils.isEmpty(com.kwad.sdk.utils.ap.f67554f[1]) != false) goto L47;
     */
    @SuppressLint({"HardwareIds", "MissingPermission"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized String[] g(@Nullable Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, context)) == null) {
            synchronized (ap.class) {
                if (q) {
                    return f67554f;
                }
                if (Build.VERSION.SDK_INT >= 29) {
                    return f67554f;
                }
                boolean z = false;
                if (TextUtils.isEmpty(f67554f[0]) && TextUtils.isEmpty(f67554f[1]) && context != null) {
                    if (com.kwad.sdk.core.config.c.a(1L)) {
                        return f67554f;
                    }
                    try {
                        boolean i2 = i(context);
                        if (i2) {
                            try {
                                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                                if (telephonyManager != null) {
                                    if (Build.VERSION.SDK_INT >= 26) {
                                        int min = Math.min(a(context, telephonyManager), 2);
                                        for (int i3 = 0; i3 < min; i3++) {
                                            f67554f[i3] = telephonyManager.getImei(i3);
                                        }
                                        if (TextUtils.isEmpty(f67554f[0])) {
                                        }
                                    } else {
                                        if (telephonyManager.getPhoneType() == 1) {
                                            if (Build.VERSION.SDK_INT >= 23) {
                                                int min2 = Math.min(a(context, telephonyManager), 2);
                                                for (int i4 = 0; i4 < min2; i4++) {
                                                    f67554f[i4] = telephonyManager.getDeviceId(i4);
                                                }
                                            } else {
                                                f67554f[0] = telephonyManager.getDeviceId();
                                                f67554f[1] = null;
                                            }
                                            if (TextUtils.isEmpty(f67554f[0]) && TextUtils.isEmpty(f67554f[1])) {
                                            }
                                        } else {
                                            f67554f[0] = null;
                                            f67554f[1] = null;
                                        }
                                        q = true;
                                    }
                                }
                            } catch (Exception e2) {
                                e = e2;
                                z = i2;
                                com.kwad.sdk.core.d.a.b(e);
                                if (z) {
                                    q = true;
                                }
                                return f67554f;
                            }
                        }
                    } catch (Exception e3) {
                        e = e3;
                    }
                    return f67554f;
                }
                return f67554f;
            }
        }
        return (String[]) invokeL.objValue;
    }

    public static int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65559, null)) == null) {
            if (l == -1) {
                l = q(KsAdSDKImpl.get().getContext()) ? 4 : 3;
            }
            return l;
        }
        return invokeV.intValue;
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    public static synchronized String h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, context)) == null) {
            synchronized (ap.class) {
                if (TextUtils.isEmpty(f67555g) && context != null) {
                    if (Build.VERSION.SDK_INT >= 29) {
                        return f67555g;
                    }
                    if (n) {
                        return f67555g;
                    }
                    if (com.kwad.sdk.core.config.c.a(128L)) {
                        return f67555g;
                    }
                    boolean z = false;
                    try {
                        z = i(context);
                        if (z) {
                            f67555g = ((TelephonyManager) context.getApplicationContext().getSystemService("phone")).getSubscriberId();
                        }
                    } catch (Exception unused) {
                        f67555g = null;
                    }
                    if (z && TextUtils.isEmpty(f67555g)) {
                        n = true;
                    }
                    String str = TextUtils.isEmpty(f67555g) ? "" : f67555g;
                    f67555g = str;
                    return str;
                }
                return f67555g;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65561, null)) == null) {
            if (TextUtils.isEmpty(k)) {
                k = System.getProperty("os.arch");
            }
            return k;
        }
        return (String) invokeV.objValue;
    }

    public static boolean i(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, null, context)) == null) {
            boolean hasCarrierPrivileges = (Build.VERSION.SDK_INT < 22 || SystemUtil.e(context) <= 28) ? a(context, "android.permission.READ_PHONE_STATE") == 0 : ((TelephonyManager) context.getSystemService("phone")).hasCarrierPrivileges();
            com.kwad.sdk.core.d.a.a("SystemUtils", "hasDeviceIdsPermission: " + hasCarrierPrivileges);
            return hasCarrierPrivileges;
        }
        return invokeL.booleanValue;
    }

    public static String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65563, null)) == null) ? Build.VERSION.RELEASE : (String) invokeV.objValue;
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    public static String j(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65564, null, context)) == null) {
            if (!TextUtils.isEmpty(f67556h) || context == null) {
                return f67556h;
            }
            if (!o && v && !com.kwad.sdk.core.config.c.a(128L)) {
                boolean z = false;
                try {
                    z = i(context);
                    if (z) {
                        f67556h = ((TelephonyManager) context.getApplicationContext().getSystemService("phone")).getSimSerialNumber();
                    }
                } catch (Exception e2) {
                    com.kwad.sdk.core.d.a.a(e2);
                    f67556h = null;
                }
                if (z && TextUtils.isEmpty(f67556h)) {
                    o = true;
                }
                String str = TextUtils.isEmpty(f67556h) ? "" : f67556h;
                f67556h = str;
                return str;
            }
            return f67556h;
        }
        return (String) invokeL.objValue;
    }

    public static int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65565, null)) == null) ? Build.VERSION.SDK_INT : invokeV.intValue;
    }

    public static int k(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, null, context)) == null) {
            try {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
                return displayMetrics.widthPixels;
            } catch (Exception unused) {
                return 0;
            }
        }
        return invokeL.intValue;
    }

    public static int l(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65567, null, context)) == null) {
            try {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
                return displayMetrics.heightPixels;
            } catch (Exception unused) {
                return 0;
            }
        }
        return invokeL.intValue;
    }

    public static String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65568, null)) == null) ? Locale.getDefault().getLanguage() : (String) invokeV.objValue;
    }

    public static String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65569, null)) == null) {
            if (com.kwad.sdk.core.config.c.a(8L)) {
                return "";
            }
            try {
                Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
                while (networkInterfaces.hasMoreElements()) {
                    Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                    while (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement = inetAddresses.nextElement();
                        if ((nextElement instanceof Inet4Address) && !nextElement.isLoopbackAddress()) {
                            return nextElement.getHostAddress();
                        }
                    }
                }
            } catch (Throwable unused) {
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @SuppressLint({"HardwareIds"})
    public static String m(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65570, null, context)) == null) {
            if (!TextUtils.isEmpty(f67557i) || context == null) {
                return f67557i;
            }
            if (!p && !com.kwad.sdk.core.config.c.a(2L)) {
                try {
                    f67557i = Settings.Secure.getString(context.getContentResolver(), IAdRequestParam.ANDROID_ID);
                } catch (Exception unused) {
                }
                if (TextUtils.isEmpty(f67557i)) {
                    p = true;
                }
                return f67557i;
            }
            return f67557i;
        }
        return (String) invokeL.objValue;
    }

    public static int n(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65571, null, context)) == null) {
            AudioManager audioManager = (AudioManager) context.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
            if (audioManager != null) {
                return audioManager.getStreamVolume(3);
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65572, null)) == null) {
            try {
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.b(e2);
            }
            if (TextUtils.isEmpty(j)) {
                String q2 = q();
                if (!TextUtils.isEmpty(q2)) {
                    String str = "ANDROID_" + q2;
                    j = str;
                    return str;
                }
                String m2 = m(KsAdSDKImpl.get().getContext());
                if (!TextUtils.isEmpty(m2) && !a(m2)) {
                    String str2 = "ANDROID_" + m2;
                    j = str2;
                    return str2;
                }
                String p2 = p();
                if (!TextUtils.isEmpty(p2)) {
                    j = "ANDROID_" + p2;
                    b(p2);
                    return j;
                }
                return "ANDROID_";
            }
            return j;
        }
        return (String) invokeV.objValue;
    }

    public static long o() {
        InterceptResult invokeV;
        BufferedReader bufferedReader;
        Throwable th;
        String readLine;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65573, null)) == null) {
            BufferedReader bufferedReader2 = null;
            try {
                try {
                    bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
                } catch (IOException unused) {
                    return 0L;
                }
            } catch (Exception unused2) {
            } catch (Throwable th2) {
                bufferedReader = null;
                th = th2;
            }
            do {
                try {
                    readLine = bufferedReader.readLine();
                } catch (Exception unused3) {
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 != null) {
                        bufferedReader2.close();
                        return 0L;
                    }
                    return 0L;
                } catch (Throwable th3) {
                    th = th3;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException unused4) {
                        }
                    }
                    throw th;
                }
                if (readLine == null) {
                    bufferedReader.close();
                    return 0L;
                }
            } while (!readLine.contains("MemTotal"));
            long longValue = Long.valueOf(readLine.split("\\s+")[1]).longValue() << 10;
            try {
                bufferedReader.close();
            } catch (IOException unused5) {
            }
            return longValue;
        }
        return invokeV.longValue;
    }

    @SuppressLint({"MissingPermission"})
    public static synchronized String o(@Nullable Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65574, null, context)) == null) {
            synchronized (ap.class) {
                if (TextUtils.isEmpty(f67549a) && context != null) {
                    if (u) {
                        if (com.kwad.sdk.core.config.c.a(4L)) {
                            return f67549a;
                        }
                        if (TextUtils.isEmpty(f67549a)) {
                            try {
                                WifiInfo connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
                                if (connectionInfo != null) {
                                    f67549a = connectionInfo.getMacAddress();
                                }
                                if (TextUtils.isEmpty(f67549a) || f67549a.equals("02:00:00:00:00:00")) {
                                    Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        NetworkInterface networkInterface = (NetworkInterface) it.next();
                                        if (networkInterface.getName().equalsIgnoreCase(NetworkInfoUtils.NETWORK_NAME)) {
                                            byte[] hardwareAddress = networkInterface.getHardwareAddress();
                                            if (hardwareAddress != null && hardwareAddress.length != 0) {
                                                StringBuilder sb = new StringBuilder();
                                                int length = hardwareAddress.length;
                                                for (int i2 = 0; i2 < length; i2++) {
                                                    sb.append(String.format("%02X:", Byte.valueOf(hardwareAddress[i2])));
                                                }
                                                if (sb.length() > 0) {
                                                    sb.deleteCharAt(sb.length() - 1);
                                                }
                                                f67549a = sb.toString();
                                            }
                                        }
                                    }
                                }
                                if (TextUtils.isEmpty(f67549a) || f67549a.equals("02:00:00:00:00:00")) {
                                    f67549a = new LineNumberReader(new InputStreamReader(Runtime.getRuntime().exec("cat /sys/class/net/wlan0/address ").getInputStream())).readLine();
                                }
                                if (!TextUtils.isEmpty(f67549a)) {
                                    f67549a = f67549a.toUpperCase(Locale.US);
                                }
                            } catch (Exception unused) {
                            }
                        }
                        return f67549a;
                    }
                    return f67549a;
                }
                return f67549a;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65575, null)) == null) {
            try {
                return a(Long.toHexString(new Random(System.currentTimeMillis()).nextLong()), 16, '0');
            } catch (Throwable unused) {
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String p(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65576, null, context)) == null) {
            try {
                PackageInfo packageInfo = context.getApplicationContext().getPackageManager().getPackageInfo(context.getPackageName(), 64);
                return packageInfo != null ? packageInfo.versionName : "";
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65577, null)) == null) {
            Context context = KsAdSDKImpl.get().getContext();
            if (context == null) {
                return null;
            }
            return context.getSharedPreferences("ksadsdk_pref", 0).getString(IAdRequestParam.ANDROID_ID, null);
        }
        return (String) invokeV.objValue;
    }

    public static boolean q(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65578, null, context)) == null) ? (context == null || context.getResources() == null || context.getResources().getConfiguration() == null || (context.getResources().getConfiguration().screenLayout & 15) < 3) ? false : true : invokeL.booleanValue;
    }
}
