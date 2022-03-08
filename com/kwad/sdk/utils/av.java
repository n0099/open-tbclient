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
import com.baidu.searchbox.aideviceperformance.utils.HardwareInfoUtils;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
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
/* loaded from: classes8.dex */
public class av {
    public static String a = "";

    /* renamed from: b  reason: collision with root package name */
    public static String f56468b = "";

    /* renamed from: c  reason: collision with root package name */
    public static String f56469c = "";

    /* renamed from: d  reason: collision with root package name */
    public static int f56470d;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f56471e;

    /* renamed from: j  reason: collision with root package name */
    public static String f56476j;
    public static String k;
    public static int s;
    public static long t;

    /* renamed from: f  reason: collision with root package name */
    public static final String[] f56472f = {"", ""};

    /* renamed from: g  reason: collision with root package name */
    public static String f56473g = "";

    /* renamed from: h  reason: collision with root package name */
    public static String f56474h = "";

    /* renamed from: i  reason: collision with root package name */
    public static String f56475i = "";
    public static int l = -1;
    public static boolean m = false;
    public static boolean n = false;
    public static boolean o = false;
    public static boolean p = false;
    public static boolean q = false;
    public static boolean r = false;
    public static boolean u = true;
    public static boolean v = true;
    public static final List<String> w = Arrays.asList("a5f5faddde9e9f02", "8e17f7422b35fbea", "b88c3c236923d9d9", "cb36bf76cca443d0", "5d4e49ed381836c5", "cffa38e9136f93e9", "62bd2daa59ea0173", "b7aad49a2d5bc5d9", "f2138912c5e5dd5c", "330a1e81a2bf9f31", "59c0f432ccbef844", "521376155e535f39", "aa5ec6ce14abd680", "5522a09bb500d82f", "6dfe4a96800edfb4", "ecc9a2dded8cdf72", "399f868043955b11", "34dc327c00dbff94", "d1b4e3862c309f8b", "68bdbf71f863ccac", "01558dd995085a35", "351174200a06da52", "fa0988506c76ff4b", "8eb8ef823312c61a", "a72e81be65c4638b", "416d15a015c8f324", "474086ea2d737519", "befdddf908c8d749", "780ee58a6f57aab6", "cfe86fa07cae3601", "704ff4d1534f0ff4", "9298b9e9bbd7cdea", "7b634c42f236c6e8", "11eacf22b9ceab7d", "2941a4f39eec5864", "87d134dc5ba45550", "fdd2313bb1750eb9", "6560ef232d8424bb", "5d876286e1064482", "f66fefb916f4962d", "7baf82d0ac49f596", "57748921d8d88ed4", "120cd57f1a50b8f5", "e164f9610ddd9fc8", "6256f0e8da6389de", "bcb22df712476416", "714fa9aff63f7adb", "cb8252e4da7cf610", "e18f649aa80e140c", "966790a9db5ea8d8", "e1769e681af901dd", "d23f2574a60964a4", "d717e6298d3c9cb2", "f5ea5e8ba730864e", "a8a0a223d1a42232", "6675a4f231f5c8db", "3edb7c2103e5c75a", "8ce6a9a216b326c4", "af606153eb3be0a7", "7ae255c3d760c920", "e50e94c40048c5fd", "55009bca30f9dc4c", "c37566487909214a", "891b74f7e534d14a", "726e190aae663525", "df473127d30fb669", "bfbcc646d92dfd48", "a4a1954c44751936", "da4a44a3d7c4d8be", "5ff5bca4a775dd30", "14917461e1917c53", "14ce20d0a80955fa", "a56a63de4d3f3d39", "f780246adc7bd556", "3495a541aea0da72", "f7f205ce47fed2a5", "f52db3f434279c3a", "dca17088c97dee5e", "dd53a8b3a2a4ccc0", "52e07629290d45e4", "cda522b0f8f50d9a", "b85a1c8bcd51d82c", "e344a00cd3f5e93a", "fa59d8a66d7bdd88", "68fb1f1393a216e8", "4c30ab1fb10af181", "b1376e0578099143", "88752f72d8d305fd", "fddf20078d27bf3c", "dab2120bffa2be8c", "c7c8dde481793471", "e4b1bdbcabfc284d");

    public static int a(Context context) {
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

    public static synchronized int a(Context context, @Nullable TelephonyManager telephonyManager) {
        synchronized (av.class) {
            if (!f56471e && f56470d <= 0 && Build.VERSION.SDK_INT >= 23 && (context != null || telephonyManager != null)) {
                if (com.kwad.sdk.b.a.booleanValue()) {
                    f56470d = DeviceInfo.getPhoneCount(context);
                } else {
                    if (telephonyManager == null) {
                        try {
                            telephonyManager = (TelephonyManager) context.getSystemService("phone");
                        } catch (Exception unused) {
                            f56471e = true;
                        }
                    }
                    com.kwad.sdk.core.d.a.c("SystemUtils", "getPhoneCount");
                    int phoneCount = telephonyManager.getPhoneCount();
                    f56470d = phoneCount;
                    if (phoneCount == 0) {
                        f56471e = true;
                    }
                }
                return f56470d;
            }
            return f56470d;
        }
    }

    public static int a(@NonNull Context context, @NonNull String str) {
        if (str != null) {
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        }
        throw new IllegalArgumentException("permission is null");
    }

    public static long a() {
        if (com.kwad.sdk.b.a.booleanValue()) {
            return DeviceInfo.getRomTotalSpace();
        }
        try {
            return a(Environment.getDataDirectory());
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static long a(File file) {
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

    public static String a(String str, int i2, char c2) {
        StringBuilder sb = new StringBuilder();
        while (sb.length() + str.length() < i2) {
            sb.append(c2);
        }
        sb.append(str);
        return sb.toString();
    }

    public static void a(SdkConfig sdkConfig) {
        u = sdkConfig.canReadMacAddress();
        v = sdkConfig.canReadICCID();
    }

    public static boolean a(String str) {
        return w.contains(str.toLowerCase(Locale.US));
    }

    public static long b() {
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

    public static long b(Context context) {
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

    public static long b(File file) {
        try {
            StatFs statFs = new StatFs(file.getPath());
            return Build.VERSION.SDK_INT < 18 ? statFs.getBlockSize() * statFs.getAvailableBlocks() : statFs.getBlockSizeLong() * statFs.getAvailableBlocksLong();
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static String b(Context context, String str) {
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

    public static void b(String str) {
        Context context = KsAdSDKImpl.get().getContext();
        if (context == null) {
            return;
        }
        context.getSharedPreferences("ksadsdk_pref", 0).edit().putString(HttpRequest.ANDROID_ID, str).apply();
    }

    public static int c() {
        int i2 = s;
        if (i2 > 0) {
            return i2;
        }
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        s = availableProcessors;
        return availableProcessors;
    }

    public static long c(Context context) {
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

    public static String d() {
        Locale locale = Build.VERSION.SDK_INT >= 24 ? LocaleList.getDefault().get(0) : Locale.getDefault();
        if (locale == null) {
            locale = Locale.CHINESE;
        }
        return String.valueOf(locale);
    }

    public static String d(@Nullable Context context) {
        if (!ao.c() || TextUtils.isEmpty(ao.d())) {
            String e2 = e(context);
            return (TextUtils.isEmpty(e2) && TextUtils.isEmpty(com.kwad.sdk.core.f.a.a(context))) ? com.kwad.sdk.core.config.b.ab() : e2;
        }
        return ao.d();
    }

    public static String e() {
        return Build.MODEL;
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    public static synchronized String e(@Nullable Context context) {
        synchronized (av.class) {
            if (ao.c() && !TextUtils.isEmpty(ao.d())) {
                return ao.d();
            } else if (m) {
                return f56468b;
            } else {
                if (TextUtils.isEmpty(f56468b) && context != null) {
                    if (Build.VERSION.SDK_INT >= 29) {
                        return f56468b;
                    }
                    if (!ao.c() && !com.kwad.sdk.core.config.b.a(1L)) {
                        if (com.kwad.sdk.b.a.booleanValue()) {
                            String imei = DeviceInfo.getImei(context);
                            f56468b = imei;
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
                                f56468b = deviceId;
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
                        return f56468b;
                    }
                    return f56468b;
                }
                return f56468b;
            }
        }
    }

    public static synchronized long f() {
        long j2;
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

    /* JADX WARN: Code restructure failed: missing block: B:34:0x005d, code lost:
        if (android.text.TextUtils.isEmpty(r5) != false) goto L37;
     */
    @SuppressLint({"HardwareIds", "MissingPermission"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized String f(@Nullable Context context) {
        TelephonyManager telephonyManager;
        synchronized (av.class) {
            if (r) {
                return f56469c;
            }
            if (TextUtils.isEmpty(f56469c) && context != null) {
                if (!ao.c() && !com.kwad.sdk.core.config.b.a(4096L)) {
                    if (com.kwad.sdk.b.a.booleanValue()) {
                        String meid = DeviceInfo.getMeid(context);
                        f56469c = meid;
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
                                f56469c = meid2;
                            } else if (telephonyManager.getPhoneType() == 2) {
                                String deviceId = telephonyManager.getDeviceId();
                                f56469c = deviceId;
                                if (TextUtils.isEmpty(deviceId)) {
                                }
                            } else {
                                f56469c = null;
                            }
                            r = true;
                        }
                    } catch (Exception e2) {
                        com.kwad.sdk.core.d.a.a(e2);
                        if (z) {
                            r = true;
                        }
                    }
                    return f56469c;
                }
                return f56469c;
            }
            return f56469c;
        }
    }

    public static String g() {
        return Build.BRAND;
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x00bb, code lost:
        if (android.text.TextUtils.isEmpty(com.kwad.sdk.utils.av.f56472f[1]) != false) goto L59;
     */
    @SuppressLint({"HardwareIds", "MissingPermission"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized String[] g(@Nullable Context context) {
        synchronized (av.class) {
            if (ao.c() && ao.e() != null) {
                return ao.e();
            } else if (q) {
                return f56472f;
            } else if (Build.VERSION.SDK_INT >= 29) {
                return f56472f;
            } else {
                boolean z = false;
                if (TextUtils.isEmpty(f56472f[0]) && TextUtils.isEmpty(f56472f[1]) && context != null) {
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
                                                    f56472f[i3] = telephonyManager.getImei(i3);
                                                }
                                                if (TextUtils.isEmpty(f56472f[0])) {
                                                }
                                            } else {
                                                if (telephonyManager.getPhoneType() == 1) {
                                                    if (Build.VERSION.SDK_INT >= 23) {
                                                        int min2 = Math.min(a(context, telephonyManager), 2);
                                                        for (int i4 = 0; i4 < min2; i4++) {
                                                            f56472f[i4] = telephonyManager.getDeviceId(i4);
                                                        }
                                                    } else {
                                                        f56472f[0] = telephonyManager.getDeviceId();
                                                        f56472f[1] = null;
                                                    }
                                                    if (TextUtils.isEmpty(f56472f[0]) && TextUtils.isEmpty(f56472f[1])) {
                                                    }
                                                } else {
                                                    f56472f[0] = null;
                                                    f56472f[1] = null;
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
                                        return f56472f;
                                    }
                                }
                            } catch (Exception e3) {
                                e = e3;
                            }
                        } else if (DeviceInfo.getIMEIs(context) != null && DeviceInfo.getIMEIs(context).length >= 2) {
                            f56472f[0] = DeviceInfo.getIMEIs(context)[0];
                            f56472f[1] = DeviceInfo.getIMEIs(context)[1];
                        }
                        return f56472f;
                    }
                    return f56472f;
                }
                return f56472f;
            }
        }
    }

    public static synchronized long h() {
        synchronized (av.class) {
            if (com.kwad.sdk.b.a.booleanValue()) {
                return DeviceInfo.getBootTime();
            }
            return SystemClock.elapsedRealtime() / 1000;
        }
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    public static synchronized String h(Context context) {
        synchronized (av.class) {
            if (TextUtils.isEmpty(f56473g) && context != null) {
                if (Build.VERSION.SDK_INT >= 29) {
                    return f56473g;
                } else if (n) {
                    return f56473g;
                } else {
                    if (!ao.c() && !com.kwad.sdk.core.config.b.a(128L)) {
                        if (com.kwad.sdk.b.a.booleanValue()) {
                            f56473g = DeviceInfo.getIMSI(context);
                        } else {
                            boolean z = false;
                            try {
                                z = i(context);
                                if (z) {
                                    f56473g = ((TelephonyManager) context.getApplicationContext().getSystemService("phone")).getSubscriberId();
                                }
                            } catch (Exception unused) {
                                f56473g = null;
                            }
                            if (z && TextUtils.isEmpty(f56473g)) {
                                n = true;
                            }
                        }
                        String str = TextUtils.isEmpty(f56473g) ? "" : f56473g;
                        f56473g = str;
                        return str;
                    }
                    return f56473g;
                }
            }
            return f56473g;
        }
    }

    public static synchronized long i() {
        synchronized (av.class) {
            if (com.kwad.sdk.b.a.booleanValue()) {
                return DeviceInfo.getRomBuildTimestamp();
            }
            return Build.TIME;
        }
    }

    public static boolean i(Context context) {
        boolean hasCarrierPrivileges = (Build.VERSION.SDK_INT < 22 || SystemUtil.e(context) <= 28) ? a(context, com.kuaishou.weapon.un.s.f53804c) == 0 : ((TelephonyManager) context.getSystemService("phone")).hasCarrierPrivileges();
        com.kwad.sdk.core.d.a.a("SystemUtils", "hasDeviceIdsPermission: " + hasCarrierPrivileges);
        return hasCarrierPrivileges;
    }

    public static synchronized String j() {
        synchronized (av.class) {
            if (com.kwad.sdk.b.a.booleanValue()) {
                return DeviceInfo.getFingerPrint();
            }
            return Build.FINGERPRINT;
        }
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    public static String j(Context context) {
        if (!TextUtils.isEmpty(f56474h) || context == null) {
            return f56474h;
        }
        if (!o && v) {
            if (ao.c() || com.kwad.sdk.core.config.b.a(128L)) {
                return f56474h;
            }
            if (com.kwad.sdk.b.a.booleanValue()) {
                f56474h = DeviceInfo.getICCID(context);
            } else {
                boolean z = false;
                try {
                    z = i(context);
                    if (z) {
                        f56474h = ((TelephonyManager) context.getApplicationContext().getSystemService("phone")).getSimSerialNumber();
                    }
                } catch (Exception e2) {
                    com.kwad.sdk.core.d.a.a(e2);
                    f56474h = null;
                }
                if (z && TextUtils.isEmpty(f56474h)) {
                    o = true;
                }
            }
            String str = TextUtils.isEmpty(f56474h) ? "" : f56474h;
            f56474h = str;
            return str;
        }
        return f56474h;
    }

    public static synchronized com.kwad.sdk.collector.kwai.f k(Context context) {
        synchronized (av.class) {
            if (com.kwad.sdk.core.config.b.N()) {
                if (!com.kwad.sdk.b.a.booleanValue()) {
                    return com.kwad.sdk.collector.i.c();
                }
                com.kwad.sdk.collector.kwai.f fVar = new com.kwad.sdk.collector.kwai.f();
                fVar.a = DeviceInfo.getPhoneCount(context);
                fVar.f54092b = DeviceInfo.getActivePhoneCount(context);
                return fVar;
            }
            return null;
        }
    }

    public static synchronized String k() {
        synchronized (av.class) {
            if (com.kwad.sdk.b.a.booleanValue()) {
                return DeviceInfo.getBaseBandVersion();
            }
            return Build.getRadioVersion();
        }
    }

    public static synchronized com.kwad.sdk.core.request.model.c l(Context context) {
        synchronized (av.class) {
            if (com.kwad.sdk.core.config.b.W()) {
                if (!com.kwad.sdk.b.a.booleanValue()) {
                    return com.kwad.sdk.collector.i.a();
                }
                int[] baseStationInfo = DeviceInfo.getBaseStationInfo(context);
                if (baseStationInfo == null || baseStationInfo.length != 3) {
                    return null;
                }
                return new com.kwad.sdk.core.request.model.c(baseStationInfo[0], baseStationInfo[1], baseStationInfo[2]);
            }
            return null;
        }
    }

    public static synchronized String l() {
        synchronized (av.class) {
            if (com.kwad.sdk.b.a.booleanValue()) {
                return DeviceInfo.getRomName();
            }
            return an.d();
        }
    }

    public static synchronized int m(Context context) {
        synchronized (av.class) {
            if (com.kwad.sdk.b.a.booleanValue()) {
                return DeviceInfo.getRingerMode(context);
            }
            return ((AudioManager) context.getSystemService("audio")).getRingerMode();
        }
    }

    public static synchronized String m() {
        synchronized (av.class) {
            if (com.kwad.sdk.b.a.booleanValue()) {
                return DeviceInfo.getRomVersion();
            }
            return an.e();
        }
    }

    public static int n(Context context) {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.widthPixels;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static String n() {
        return Build.MANUFACTURER;
    }

    public static int o() {
        if (l == -1) {
            l = x(KsAdSDKImpl.get().getContext()) ? 4 : 3;
        }
        return l;
    }

    public static int o(Context context) {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.heightPixels;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static int p(Context context) {
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

    public static String p() {
        if (TextUtils.isEmpty(k)) {
            k = System.getProperty("os.arch");
        }
        return k;
    }

    public static int q(Context context) {
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

    public static String q() {
        return Build.VERSION.RELEASE;
    }

    public static int r() {
        return Build.VERSION.SDK_INT;
    }

    public static String r(Context context) {
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

    public static String s() {
        return Locale.getDefault().getLanguage();
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0043 -> B:22:0x0044). Please submit an issue!!! */
    @NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String s(Context context) {
        String str;
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
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

    @SuppressLint({"HardwareIds"})
    public static String t(Context context) {
        if (!ao.c() || TextUtils.isEmpty(ao.f())) {
            if (!TextUtils.isEmpty(f56475i) || context == null) {
                return f56475i;
            }
            if (p) {
                return f56475i;
            }
            if (ao.c() || com.kwad.sdk.core.config.b.a(2L)) {
                return f56475i;
            }
            if (com.kwad.sdk.b.a.booleanValue()) {
                f56475i = DeviceInfo.getAndroidId(context);
            } else {
                try {
                    f56475i = Settings.Secure.getString(context.getContentResolver(), HttpRequest.ANDROID_ID);
                } catch (Exception unused) {
                }
            }
            if (TextUtils.isEmpty(f56475i)) {
                p = true;
            }
            return f56475i;
        }
        return ao.f();
    }

    public static int u(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (audioManager != null) {
            return audioManager.getStreamVolume(3);
        }
        return 0;
    }

    public static String u() {
        try {
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.b(e2);
        }
        if (TextUtils.isEmpty(f56476j)) {
            String x = x();
            if (!TextUtils.isEmpty(x)) {
                String str = "ANDROID_" + x;
                f56476j = str;
                return str;
            }
            String t2 = t(KsAdSDKImpl.get().getContext());
            if (!TextUtils.isEmpty(t2) && !a(t2)) {
                String str2 = "ANDROID_" + t2;
                f56476j = str2;
                return str2;
            }
            String w2 = w();
            if (!TextUtils.isEmpty(w2)) {
                f56476j = "ANDROID_" + w2;
                b(w2);
                return f56476j;
            }
            return "ANDROID_";
        }
        return f56476j;
    }

    public static long v() {
        BufferedReader bufferedReader;
        Throwable th;
        String readLine;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new FileReader(HardwareInfoUtils.MEM_INFO_FILE), 8192);
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

    @SuppressLint({"MissingPermission"})
    public static synchronized String v(@Nullable Context context) {
        synchronized (av.class) {
            if (ao.g() && !TextUtils.isEmpty(ao.h())) {
                return ao.h();
            }
            if (TextUtils.isEmpty(a) && context != null) {
                if (!u) {
                    return a;
                }
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
    }

    public static String w() {
        try {
            return a(Long.toHexString(new Random(System.currentTimeMillis()).nextLong()), 16, '0');
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String w(Context context) {
        try {
            PackageInfo packageInfo = context.getApplicationContext().getPackageManager().getPackageInfo(context.getPackageName(), 64);
            return packageInfo != null ? packageInfo.versionName : "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static String x() {
        Context context = KsAdSDKImpl.get().getContext();
        if (context == null) {
            return null;
        }
        return context.getSharedPreferences("ksadsdk_pref", 0).getString(HttpRequest.ANDROID_ID, null);
    }

    public static boolean x(Context context) {
        return (context == null || context.getResources() == null || context.getResources().getConfiguration() == null || (context.getResources().getConfiguration().screenLayout & 15) < 3) ? false : true;
    }
}
