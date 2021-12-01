package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Environment;
import android.os.LocaleList;
import android.os.Process;
import android.os.StatFs;
import android.os.SystemClock;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kuaishou.weapon.adsdk.DeviceInfo;
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
public class av {
    public static /* synthetic */ Interceptable $ic = null;
    public static String a = "";

    /* renamed from: b  reason: collision with root package name */
    public static String f59609b = "";

    /* renamed from: c  reason: collision with root package name */
    public static String f59610c = "";

    /* renamed from: d  reason: collision with root package name */
    public static int f59611d;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f59612e;

    /* renamed from: f  reason: collision with root package name */
    public static final String[] f59613f;

    /* renamed from: g  reason: collision with root package name */
    public static String f59614g;

    /* renamed from: h  reason: collision with root package name */
    public static String f59615h;

    /* renamed from: i  reason: collision with root package name */
    public static String f59616i;

    /* renamed from: j  reason: collision with root package name */
    public static String f59617j;

    /* renamed from: k  reason: collision with root package name */
    public static String f59618k;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(408734669, "Lcom/kwad/sdk/utils/av;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(408734669, "Lcom/kwad/sdk/utils/av;");
                return;
            }
        }
        f59613f = new String[]{"", ""};
        f59614g = "";
        f59615h = "";
        f59616i = "";
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
            if (com.kwad.sdk.core.config.b.a(512L)) {
                return 0;
            }
            if (com.kwad.sdk.b.a.booleanValue()) {
                return DeviceInfo.getBatteryPercent(context);
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
            synchronized (av.class) {
                if (!f59612e && f59611d <= 0 && Build.VERSION.SDK_INT >= 23 && (context != null || telephonyManager != null)) {
                    if (com.kwad.sdk.b.a.booleanValue()) {
                        f59611d = DeviceInfo.getPhoneCount(context);
                    } else {
                        if (telephonyManager == null) {
                            try {
                                telephonyManager = (TelephonyManager) context.getSystemService("phone");
                            } catch (Exception unused) {
                                f59612e = true;
                            }
                        }
                        com.kwad.sdk.core.d.a.c("SystemUtils", "getPhoneCount");
                        int phoneCount = telephonyManager.getPhoneCount();
                        f59611d = phoneCount;
                        if (phoneCount == 0) {
                            f59612e = true;
                        }
                    }
                    return f59611d;
                }
                return f59611d;
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
            if (com.kwad.sdk.b.a.booleanValue()) {
                return DeviceInfo.getRomTotalSpace();
            }
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, file)) == null) {
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
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{str, Integer.valueOf(i2), Character.valueOf(c2)})) == null) {
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
            if (com.kwad.sdk.core.config.b.a(1024L)) {
                return 0L;
            }
            if (com.kwad.sdk.b.a.booleanValue()) {
                return DeviceInfo.getRomAvailableSpace();
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
            if (com.kwad.sdk.b.a.booleanValue()) {
                return DeviceInfo.getRamTotalSize(context);
            }
            if (context == null) {
                return 0L;
            }
            try {
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                ((ActivityManager) context.getApplicationContext().getSystemService("activity")).getMemoryInfo(memoryInfo);
                long j3 = memoryInfo.totalMem;
                if (j3 <= 0) {
                    j3 = v();
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

    public static String b(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, context, str)) == null) {
            if (!TextUtils.isEmpty(str) && context != null) {
                try {
                    PackageInfo packageInfo = context.getApplicationContext().getPackageManager().getPackageInfo(str, 64);
                    if (packageInfo != null) {
                        return packageInfo.versionName;
                    }
                } catch (Exception unused) {
                }
            }
            return "";
        }
        return (String) invokeLL.objValue;
    }

    public static void b(String str) {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65549, null, str) == null) || (context = KsAdSDKImpl.get().getContext()) == null) {
            return;
        }
        context.getSharedPreferences("ksadsdk_pref", 0).edit().putString("android_id", str).apply();
    }

    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, context)) == null) {
            if (context == null || com.kwad.sdk.core.config.b.a(1024L)) {
                return 0L;
            }
            if (com.kwad.sdk.b.a.booleanValue()) {
                return DeviceInfo.getRamAvailableSize(context);
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
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, context)) == null) {
            if (!ao.c() || TextUtils.isEmpty(ao.d())) {
                String e2 = e(context);
                return (TextUtils.isEmpty(e2) && TextUtils.isEmpty(com.kwad.sdk.core.f.a.a(context))) ? com.kwad.sdk.core.config.b.ab() : e2;
            }
            return ao.d();
        }
        return (String) invokeL.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) ? Build.MODEL : (String) invokeV.objValue;
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    public static synchronized String e(@Nullable Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, context)) == null) {
            synchronized (av.class) {
                if (!ao.c() || TextUtils.isEmpty(ao.d())) {
                    if (m) {
                        return f59609b;
                    }
                    if (TextUtils.isEmpty(f59609b) && context != null) {
                        if (Build.VERSION.SDK_INT >= 29) {
                            return f59609b;
                        }
                        if (!ao.c() && !com.kwad.sdk.core.config.b.a(1L)) {
                            if (com.kwad.sdk.b.a.booleanValue()) {
                                String imei = DeviceInfo.getImei(context);
                                f59609b = imei;
                                if (imei == null) {
                                    imei = "";
                                }
                                return imei;
                            }
                            boolean z = false;
                            try {
                                z = i(context);
                                if (z) {
                                    String deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
                                    f59609b = deviceId;
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
                            return f59609b;
                        }
                        return f59609b;
                    }
                    return f59609b;
                }
                return ao.d();
            }
        }
        return (String) invokeL.objValue;
    }

    public static synchronized long f() {
        InterceptResult invokeV;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) {
            synchronized (av.class) {
                j2 = 0;
                if (ao.c() && (!TextUtils.isEmpty(ao.d()) || ao.e() != null)) {
                    j2 = 1;
                }
                if (ao.a() && ao.b() != null) {
                    j2 |= 64;
                }
                if (ao.c() && !TextUtils.isEmpty(ao.f())) {
                    j2 |= 2;
                }
                if (ao.g() && !TextUtils.isEmpty(ao.h())) {
                    j2 |= 4;
                }
                if (ao.i() && !TextUtils.isEmpty(ao.j())) {
                    j2 |= 2048;
                }
                if (ao.m()) {
                    if (ao.n() != null) {
                        j2 |= 16;
                    }
                }
            }
            return j2;
        }
        return invokeV.longValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0061, code lost:
        if (android.text.TextUtils.isEmpty(r5) != false) goto L39;
     */
    @SuppressLint({"HardwareIds", "MissingPermission"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized String f(@Nullable Context context) {
        InterceptResult invokeL;
        TelephonyManager telephonyManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, context)) == null) {
            synchronized (av.class) {
                if (r) {
                    return f59610c;
                }
                if (TextUtils.isEmpty(f59610c) && context != null) {
                    if (!ao.c() && !com.kwad.sdk.core.config.b.a(4096L)) {
                        if (com.kwad.sdk.b.a.booleanValue()) {
                            String meid = DeviceInfo.getMeid(context);
                            f59610c = meid;
                            if (meid == null) {
                                meid = "";
                            }
                            return meid;
                        }
                        boolean z = false;
                        try {
                            z = i(context);
                            if (z && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null) {
                                if (Build.VERSION.SDK_INT >= 26) {
                                    String meid2 = telephonyManager.getMeid();
                                    f59610c = meid2;
                                } else if (telephonyManager.getPhoneType() == 2) {
                                    String deviceId = telephonyManager.getDeviceId();
                                    f59610c = deviceId;
                                    if (TextUtils.isEmpty(deviceId)) {
                                    }
                                } else {
                                    f59610c = null;
                                }
                                r = true;
                            }
                        } catch (Exception e2) {
                            com.kwad.sdk.core.d.a.a(e2);
                            if (z) {
                                r = true;
                            }
                        }
                        return f59610c;
                    }
                    return f59610c;
                }
                return f59610c;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65558, null)) == null) ? Build.BRAND : (String) invokeV.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x00bf, code lost:
        if (android.text.TextUtils.isEmpty(com.kwad.sdk.utils.av.f59613f[1]) != false) goto L61;
     */
    @SuppressLint({"HardwareIds", "MissingPermission"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized String[] g(@Nullable Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, context)) == null) {
            synchronized (av.class) {
                if (!ao.c() || ao.e() == null) {
                    if (q) {
                        return f59613f;
                    }
                    if (Build.VERSION.SDK_INT >= 29) {
                        return f59613f;
                    }
                    boolean z = false;
                    if (TextUtils.isEmpty(f59613f[0]) && TextUtils.isEmpty(f59613f[1]) && context != null) {
                        if (!ao.c() && !com.kwad.sdk.core.config.b.a(1L)) {
                            if (!com.kwad.sdk.b.a.booleanValue()) {
                                try {
                                    boolean i2 = i(context);
                                    if (i2) {
                                        try {
                                            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                                            if (telephonyManager != null) {
                                                if (Build.VERSION.SDK_INT >= 26) {
                                                    int min = Math.min(a(context, telephonyManager), 2);
                                                    for (int i3 = 0; i3 < min; i3++) {
                                                        f59613f[i3] = telephonyManager.getImei(i3);
                                                    }
                                                    if (TextUtils.isEmpty(f59613f[0])) {
                                                    }
                                                } else {
                                                    if (telephonyManager.getPhoneType() == 1) {
                                                        if (Build.VERSION.SDK_INT >= 23) {
                                                            int min2 = Math.min(a(context, telephonyManager), 2);
                                                            for (int i4 = 0; i4 < min2; i4++) {
                                                                f59613f[i4] = telephonyManager.getDeviceId(i4);
                                                            }
                                                        } else {
                                                            f59613f[0] = telephonyManager.getDeviceId();
                                                            f59613f[1] = null;
                                                        }
                                                        if (TextUtils.isEmpty(f59613f[0]) && TextUtils.isEmpty(f59613f[1])) {
                                                        }
                                                    } else {
                                                        f59613f[0] = null;
                                                        f59613f[1] = null;
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
                                            return f59613f;
                                        }
                                    }
                                } catch (Exception e3) {
                                    e = e3;
                                }
                            } else if (DeviceInfo.getIMEIs(context) != null && DeviceInfo.getIMEIs(context).length >= 2) {
                                f59613f[0] = DeviceInfo.getIMEIs(context)[0];
                                f59613f[1] = DeviceInfo.getIMEIs(context)[1];
                            }
                            return f59613f;
                        }
                        return f59613f;
                    }
                    return f59613f;
                }
                return ao.e();
            }
        }
        return (String[]) invokeL.objValue;
    }

    public static synchronized long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65560, null)) == null) {
            synchronized (av.class) {
                return com.kwad.sdk.b.a.booleanValue() ? DeviceInfo.getBootTime() : SystemClock.elapsedRealtime() / 1000;
            }
        }
        return invokeV.longValue;
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    public static synchronized String h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, null, context)) == null) {
            synchronized (av.class) {
                if (TextUtils.isEmpty(f59614g) && context != null) {
                    if (Build.VERSION.SDK_INT >= 29) {
                        return f59614g;
                    }
                    if (n) {
                        return f59614g;
                    }
                    if (!ao.c() && !com.kwad.sdk.core.config.b.a(128L)) {
                        if (com.kwad.sdk.b.a.booleanValue()) {
                            f59614g = DeviceInfo.getIMSI(context);
                        } else {
                            boolean z = false;
                            try {
                                z = i(context);
                                if (z) {
                                    f59614g = ((TelephonyManager) context.getApplicationContext().getSystemService("phone")).getSubscriberId();
                                }
                            } catch (Exception unused) {
                                f59614g = null;
                            }
                            if (z && TextUtils.isEmpty(f59614g)) {
                                n = true;
                            }
                        }
                        String str = TextUtils.isEmpty(f59614g) ? "" : f59614g;
                        f59614g = str;
                        return str;
                    }
                    return f59614g;
                }
                return f59614g;
            }
        }
        return (String) invokeL.objValue;
    }

    public static synchronized long i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65562, null)) == null) {
            synchronized (av.class) {
                return com.kwad.sdk.b.a.booleanValue() ? DeviceInfo.getRomBuildTimestamp() : Build.TIME;
            }
        }
        return invokeV.longValue;
    }

    public static boolean i(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, null, context)) == null) {
            boolean hasCarrierPrivileges = (Build.VERSION.SDK_INT < 22 || SystemUtil.e(context) <= 28) ? a(context, com.kuaishou.weapon.un.s.f56838c) == 0 : ((TelephonyManager) context.getSystemService("phone")).hasCarrierPrivileges();
            com.kwad.sdk.core.d.a.a("SystemUtils", "hasDeviceIdsPermission: " + hasCarrierPrivileges);
            return hasCarrierPrivileges;
        }
        return invokeL.booleanValue;
    }

    public static synchronized String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65564, null)) == null) {
            synchronized (av.class) {
                return com.kwad.sdk.b.a.booleanValue() ? DeviceInfo.getFingerPrint() : Build.FINGERPRINT;
            }
        }
        return (String) invokeV.objValue;
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    public static String j(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65565, null, context)) == null) {
            if (!TextUtils.isEmpty(f59615h) || context == null) {
                return f59615h;
            }
            if (!o && v) {
                if (ao.c() || com.kwad.sdk.core.config.b.a(128L)) {
                    return f59615h;
                }
                if (com.kwad.sdk.b.a.booleanValue()) {
                    f59615h = DeviceInfo.getICCID(context);
                } else {
                    boolean z = false;
                    try {
                        z = i(context);
                        if (z) {
                            f59615h = ((TelephonyManager) context.getApplicationContext().getSystemService("phone")).getSimSerialNumber();
                        }
                    } catch (Exception e2) {
                        com.kwad.sdk.core.d.a.a(e2);
                        f59615h = null;
                    }
                    if (z && TextUtils.isEmpty(f59615h)) {
                        o = true;
                    }
                }
                String str = TextUtils.isEmpty(f59615h) ? "" : f59615h;
                f59615h = str;
                return str;
            }
            return f59615h;
        }
        return (String) invokeL.objValue;
    }

    public static synchronized com.kwad.sdk.collector.kwai.f k(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, null, context)) == null) {
            synchronized (av.class) {
                if (com.kwad.sdk.core.config.b.N()) {
                    if (com.kwad.sdk.b.a.booleanValue()) {
                        com.kwad.sdk.collector.kwai.f fVar = new com.kwad.sdk.collector.kwai.f();
                        fVar.a = DeviceInfo.getPhoneCount(context);
                        fVar.f57135b = DeviceInfo.getActivePhoneCount(context);
                        return fVar;
                    }
                    return com.kwad.sdk.collector.i.c();
                }
                return null;
            }
        }
        return (com.kwad.sdk.collector.kwai.f) invokeL.objValue;
    }

    public static synchronized String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65567, null)) == null) {
            synchronized (av.class) {
                return com.kwad.sdk.b.a.booleanValue() ? DeviceInfo.getBaseBandVersion() : Build.getRadioVersion();
            }
        }
        return (String) invokeV.objValue;
    }

    public static synchronized com.kwad.sdk.core.request.model.c l(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65568, null, context)) == null) {
            synchronized (av.class) {
                if (com.kwad.sdk.core.config.b.W()) {
                    if (com.kwad.sdk.b.a.booleanValue()) {
                        int[] baseStationInfo = DeviceInfo.getBaseStationInfo(context);
                        if (baseStationInfo == null || baseStationInfo.length != 3) {
                            return null;
                        }
                        return new com.kwad.sdk.core.request.model.c(baseStationInfo[0], baseStationInfo[1], baseStationInfo[2]);
                    }
                    return com.kwad.sdk.collector.i.a();
                }
                return null;
            }
        }
        return (com.kwad.sdk.core.request.model.c) invokeL.objValue;
    }

    public static synchronized String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65569, null)) == null) {
            synchronized (av.class) {
                return com.kwad.sdk.b.a.booleanValue() ? DeviceInfo.getRomName() : an.d();
            }
        }
        return (String) invokeV.objValue;
    }

    public static synchronized int m(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65570, null, context)) == null) {
            synchronized (av.class) {
                return com.kwad.sdk.b.a.booleanValue() ? DeviceInfo.getRingerMode(context) : ((AudioManager) context.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND)).getRingerMode();
            }
        }
        return invokeL.intValue;
    }

    public static synchronized String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65571, null)) == null) {
            synchronized (av.class) {
                return com.kwad.sdk.b.a.booleanValue() ? DeviceInfo.getRomVersion() : an.e();
            }
        }
        return (String) invokeV.objValue;
    }

    public static int n(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65572, null, context)) == null) {
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

    public static String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65573, null)) == null) ? Build.MANUFACTURER : (String) invokeV.objValue;
    }

    public static int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65574, null)) == null) {
            if (l == -1) {
                l = x(KsAdSDKImpl.get().getContext()) ? 4 : 3;
            }
            return l;
        }
        return invokeV.intValue;
    }

    public static int o(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65575, null, context)) == null) {
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

    public static int p(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65576, null, context)) == null) {
            if (context == null) {
                return 0;
            }
            try {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
                return (int) (displayMetrics.widthPixels / displayMetrics.density);
            } catch (Exception unused) {
                return 0;
            }
        }
        return invokeL.intValue;
    }

    public static String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65577, null)) == null) {
            if (TextUtils.isEmpty(f59618k)) {
                f59618k = System.getProperty("os.arch");
            }
            return f59618k;
        }
        return (String) invokeV.objValue;
    }

    public static int q(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65578, null, context)) == null) {
            if (context == null) {
                return 0;
            }
            try {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
                return (int) (displayMetrics.heightPixels / displayMetrics.density);
            } catch (Exception unused) {
                return 0;
            }
        }
        return invokeL.intValue;
    }

    public static String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65579, null)) == null) ? Build.VERSION.RELEASE : (String) invokeV.objValue;
    }

    public static int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65580, null)) == null) ? Build.VERSION.SDK_INT : invokeV.intValue;
    }

    public static String r(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65581, null, context)) == null) {
            if (ao.k() || com.kwad.sdk.core.config.b.a(8L)) {
                return "";
            }
            if (com.kwad.sdk.b.a.booleanValue()) {
                return DeviceInfo.getWifiIpAddress(context);
            }
            try {
                WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
                if (wifiManager != null) {
                    int ipAddress = wifiManager.getConnectionInfo().getIpAddress();
                    return (ipAddress & 255) + "." + ((ipAddress >> 8) & 255) + "." + ((ipAddress >> 16) & 255) + "." + ((ipAddress >> 24) & 255);
                }
            } catch (Exception unused) {
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static String s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65582, null)) == null) ? Locale.getDefault().getLanguage() : (String) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0047 -> B:24:0x0048). Please submit an issue!!! */
    @NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String s(Context context) {
        InterceptResult invokeL;
        String str;
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65583, null, context)) != null) {
            return (String) invokeL.objValue;
        }
        if (ao.k() || com.kwad.sdk.core.config.b.a(8L)) {
            return "";
        }
        try {
            connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
        } catch (Exception unused) {
        }
        if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected()) {
            if (1 == activeNetworkInfo.getType()) {
                str = r(context);
            } else if (activeNetworkInfo.getType() == 0) {
                str = t();
            }
            return str != null ? "" : str;
        }
        str = "";
        if (str != null) {
        }
    }

    public static String t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65584, null)) == null) {
            if (ao.k() || com.kwad.sdk.core.config.b.a(8L)) {
                return "";
            }
            if (com.kwad.sdk.b.a.booleanValue()) {
                return DeviceInfo.getIpAddressString() != null ? DeviceInfo.getIpAddressString() : "";
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
    public static String t(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65585, null, context)) == null) {
            if (!ao.c() || TextUtils.isEmpty(ao.f())) {
                if (!TextUtils.isEmpty(f59616i) || context == null) {
                    return f59616i;
                }
                if (p) {
                    return f59616i;
                }
                if (ao.c() || com.kwad.sdk.core.config.b.a(2L)) {
                    return f59616i;
                }
                if (com.kwad.sdk.b.a.booleanValue()) {
                    f59616i = DeviceInfo.getAndroidId(context);
                } else {
                    try {
                        f59616i = Settings.Secure.getString(context.getContentResolver(), "android_id");
                    } catch (Exception unused) {
                    }
                }
                if (TextUtils.isEmpty(f59616i)) {
                    p = true;
                }
                return f59616i;
            }
            return ao.f();
        }
        return (String) invokeL.objValue;
    }

    public static int u(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65586, null, context)) == null) {
            AudioManager audioManager = (AudioManager) context.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
            if (audioManager != null) {
                return audioManager.getStreamVolume(3);
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static String u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65587, null)) == null) {
            try {
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.b(e2);
            }
            if (TextUtils.isEmpty(f59617j)) {
                String x = x();
                if (!TextUtils.isEmpty(x)) {
                    String str = "ANDROID_" + x;
                    f59617j = str;
                    return str;
                }
                String t2 = t(KsAdSDKImpl.get().getContext());
                if (!TextUtils.isEmpty(t2) && !a(t2)) {
                    String str2 = "ANDROID_" + t2;
                    f59617j = str2;
                    return str2;
                }
                String w2 = w();
                if (!TextUtils.isEmpty(w2)) {
                    f59617j = "ANDROID_" + w2;
                    b(w2);
                    return f59617j;
                }
                return "ANDROID_";
            }
            return f59617j;
        }
        return (String) invokeV.objValue;
    }

    public static long v() {
        InterceptResult invokeV;
        BufferedReader bufferedReader;
        Throwable th;
        String readLine;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65588, null)) == null) {
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
    public static synchronized String v(@Nullable Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65589, null, context)) == null) {
            synchronized (av.class) {
                if (!ao.g() || TextUtils.isEmpty(ao.h())) {
                    if (TextUtils.isEmpty(a) && context != null) {
                        if (u) {
                            if (!ao.g() && !com.kwad.sdk.core.config.b.a(4L)) {
                                if (com.kwad.sdk.b.a.booleanValue()) {
                                    a = DeviceInfo.getMacAddress(context);
                                } else if (TextUtils.isEmpty(a)) {
                                    try {
                                        WifiInfo connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
                                        if (connectionInfo != null) {
                                            a = connectionInfo.getMacAddress();
                                        }
                                        if (TextUtils.isEmpty(a) || a.equals("02:00:00:00:00:00")) {
                                            Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
                                            while (true) {
                                                if (!it.hasNext()) {
                                                    break;
                                                }
                                                NetworkInterface networkInterface = (NetworkInterface) it.next();
                                                if (networkInterface.getName().equalsIgnoreCase("wlan0")) {
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
                                                        a = sb.toString();
                                                    }
                                                }
                                            }
                                        }
                                        if (TextUtils.isEmpty(a) || a.equals("02:00:00:00:00:00")) {
                                            a = new LineNumberReader(new InputStreamReader(Runtime.getRuntime().exec("cat /sys/class/net/wlan0/address ").getInputStream())).readLine();
                                        }
                                        if (!TextUtils.isEmpty(a)) {
                                            a = a.toUpperCase(Locale.US);
                                        }
                                    } catch (Exception unused) {
                                    }
                                }
                                return a;
                            }
                            return a;
                        }
                        return a;
                    }
                    return a;
                }
                return ao.h();
            }
        }
        return (String) invokeL.objValue;
    }

    public static String w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65590, null)) == null) {
            try {
                return a(Long.toHexString(new Random(System.currentTimeMillis()).nextLong()), 16, '0');
            } catch (Throwable unused) {
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String w(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65591, null, context)) == null) {
            try {
                PackageInfo packageInfo = context.getApplicationContext().getPackageManager().getPackageInfo(context.getPackageName(), 64);
                return packageInfo != null ? packageInfo.versionName : "";
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65592, null)) == null) {
            Context context = KsAdSDKImpl.get().getContext();
            if (context == null) {
                return null;
            }
            return context.getSharedPreferences("ksadsdk_pref", 0).getString("android_id", null);
        }
        return (String) invokeV.objValue;
    }

    public static boolean x(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65593, null, context)) == null) ? (context == null || context.getResources() == null || context.getResources().getConfiguration() == null || (context.getResources().getConfiguration().screenLayout & 15) < 3) ? false : true : invokeL.booleanValue;
    }
}
