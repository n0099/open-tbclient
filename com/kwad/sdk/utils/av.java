package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.media.AudioManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Environment;
import android.os.LocaleList;
import android.os.Process;
import android.os.SystemClock;
import android.provider.Settings;
import android.system.Os;
import android.system.StructStat;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.aideviceperformance.utils.HardwareInfoUtils;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.kwad.sdk.service.ServiceProvider;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
/* loaded from: classes5.dex */
public final class av {
    public static String a = null;
    public static String b = "";
    public static boolean c = false;
    public static String d = "";
    public static String e = "";
    public static int f;
    public static boolean g;
    public static int h;
    public static boolean i;
    public static String n;
    public static String o;
    public static int w;
    public static long x;
    public static final String[] j = {"", ""};
    public static String k = "";
    public static String l = "";
    public static String m = "";
    public static int p = -1;
    public static boolean q = false;
    public static boolean r = false;
    public static boolean s = false;
    public static boolean t = false;
    public static boolean u = false;
    public static boolean v = false;
    public static String y = "";
    public static String z = "";
    public static final List<String> A = Arrays.asList("a5f5faddde9e9f02", "8e17f7422b35fbea", "b88c3c236923d9d9", "cb36bf76cca443d0", "5d4e49ed381836c5", "cffa38e9136f93e9", "62bd2daa59ea0173", "b7aad49a2d5bc5d9", "f2138912c5e5dd5c", "330a1e81a2bf9f31", "59c0f432ccbef844", "521376155e535f39", "aa5ec6ce14abd680", "5522a09bb500d82f", "6dfe4a96800edfb4", "ecc9a2dded8cdf72", "399f868043955b11", "34dc327c00dbff94", "d1b4e3862c309f8b", "68bdbf71f863ccac", "01558dd995085a35", "351174200a06da52", "fa0988506c76ff4b", "8eb8ef823312c61a", "a72e81be65c4638b", "416d15a015c8f324", "474086ea2d737519", "befdddf908c8d749", "780ee58a6f57aab6", "cfe86fa07cae3601", "704ff4d1534f0ff4", "9298b9e9bbd7cdea", "7b634c42f236c6e8", "11eacf22b9ceab7d", "2941a4f39eec5864", "87d134dc5ba45550", "fdd2313bb1750eb9", "6560ef232d8424bb", "5d876286e1064482", "f66fefb916f4962d", "7baf82d0ac49f596", "57748921d8d88ed4", "120cd57f1a50b8f5", "e164f9610ddd9fc8", "6256f0e8da6389de", "bcb22df712476416", "714fa9aff63f7adb", "cb8252e4da7cf610", "e18f649aa80e140c", "966790a9db5ea8d8", "e1769e681af901dd", "d23f2574a60964a4", "d717e6298d3c9cb2", "f5ea5e8ba730864e", "a8a0a223d1a42232", "6675a4f231f5c8db", "3edb7c2103e5c75a", "8ce6a9a216b326c4", "af606153eb3be0a7", "7ae255c3d760c920", "e50e94c40048c5fd", "55009bca30f9dc4c", "c37566487909214a", "891b74f7e534d14a", "726e190aae663525", "df473127d30fb669", "bfbcc646d92dfd48", "a4a1954c44751936", "da4a44a3d7c4d8be", "5ff5bca4a775dd30", "14917461e1917c53", "14ce20d0a80955fa", "a56a63de4d3f3d39", "f780246adc7bd556", "3495a541aea0da72", "f7f205ce47fed2a5", "f52db3f434279c3a", "dca17088c97dee5e", "dd53a8b3a2a4ccc0", "52e07629290d45e4", "cda522b0f8f50d9a", "b85a1c8bcd51d82c", "e344a00cd3f5e93a", "fa59d8a66d7bdd88", "68fb1f1393a216e8", "4c30ab1fb10af181", "b1376e0578099143", "88752f72d8d305fd", "fddf20078d27bf3c", "dab2120bffa2be8c", "c7c8dde481793471", "e4b1bdbcabfc284d");

    public static int a(Context context) {
        if (((com.kwad.sdk.service.kwai.f) ServiceProvider.a(com.kwad.sdk.service.kwai.f.class)).a(512L)) {
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

    public static int a(@NonNull Context context, @NonNull String str) {
        return context.checkPermission(str, Process.myPid(), Process.myUid());
    }

    public static long a() {
        return com.kwad.sdk.crash.utils.g.c(Environment.getDataDirectory());
    }

    public static String a(@Nullable Context context, boolean z2) {
        if (!an.c() || TextUtils.isEmpty(an.d())) {
            String q2 = q(context);
            return (TextUtils.isEmpty(q2) && !z2 && TextUtils.isEmpty(com.kwad.sdk.core.e.a.a(context))) ? ((com.kwad.sdk.service.kwai.f) ServiceProvider.a(com.kwad.sdk.service.kwai.f.class)).e() : q2;
        }
        return an.d();
    }

    public static String a(String str) {
        String valueOf;
        if (!TextUtils.isEmpty(z) || TextUtils.isEmpty(str)) {
            return z;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                StructStat stat = Os.stat(str);
                if (stat == null) {
                    return z;
                }
                String str2 = "";
                if (Build.VERSION.SDK_INT >= 27) {
                    if (stat.st_atim == null) {
                        valueOf = "";
                    } else {
                        str2 = String.valueOf(stat.st_atim.tv_sec);
                        valueOf = String.valueOf(stat.st_atim.tv_nsec);
                    }
                    z = str2 + "." + valueOf;
                } else {
                    if (stat.st_atime != 0) {
                        str2 = String.valueOf(stat.st_atime);
                    }
                    z = str2;
                }
            } catch (Exception e2) {
                com.kwad.sdk.core.d.b.a(e2);
            }
        }
        return z;
    }

    public static String a(String str, int i2, char c2) {
        StringBuilder sb = new StringBuilder();
        while (sb.length() + str.length() < 16) {
            sb.append('0');
        }
        sb.append(str);
        return sb.toString();
    }

    public static String a(boolean z2) {
        Context a2 = ((com.kwad.sdk.service.kwai.d) ServiceProvider.a(com.kwad.sdk.service.kwai.d.class)).a();
        String a3 = com.kwad.sdk.core.e.a.a(a2);
        return (TextUtils.isEmpty(a3) && !z2 && TextUtils.isEmpty(q(a2))) ? ((com.kwad.sdk.service.kwai.f) ServiceProvider.a(com.kwad.sdk.service.kwai.f.class)).f() : a3;
    }

    public static long b() {
        if (((com.kwad.sdk.service.kwai.f) ServiceProvider.a(com.kwad.sdk.service.kwai.f.class)).a(1024L)) {
            return 0L;
        }
        return com.kwad.sdk.crash.utils.g.b(Environment.getDataDirectory());
    }

    public static long b(Context context) {
        long j2 = x;
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
                j3 = w();
            }
            x = j3;
            return j3;
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static boolean b(String str) {
        return TextUtils.isEmpty(str) || str.equals(Config.DEF_MAC_ID);
    }

    public static int c() {
        int i2 = w;
        if (i2 > 0) {
            return i2;
        }
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        w = availableProcessors;
        return availableProcessors;
    }

    public static long c(Context context) {
        if (context == null || ((com.kwad.sdk.service.kwai.f) ServiceProvider.a(com.kwad.sdk.service.kwai.f.class)).a(1024L)) {
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

    public static boolean c(String str) {
        return A.contains(str.toLowerCase(Locale.US));
    }

    public static String d() {
        Locale locale = Build.VERSION.SDK_INT >= 24 ? LocaleList.getDefault().get(0) : Locale.getDefault();
        if (locale == null) {
            locale = Locale.CHINESE;
        }
        return String.valueOf(locale);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x004f, code lost:
        if (android.text.TextUtils.isEmpty(r5) != false) goto L28;
     */
    @SuppressLint({"HardwareIds", "MissingPermission"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized String d(@Nullable Context context) {
        TelephonyManager telephonyManager;
        synchronized (av.class) {
            if (v) {
                return e;
            }
            if (TextUtils.isEmpty(e) && context != null) {
                if (an.c() || ((com.kwad.sdk.service.kwai.f) ServiceProvider.a(com.kwad.sdk.service.kwai.f.class)).a(4096L)) {
                    return e;
                }
                boolean z2 = false;
                try {
                    z2 = SystemUtil.a(context);
                    if (z2 && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null) {
                        if (Build.VERSION.SDK_INT >= 26) {
                            String meid = telephonyManager.getMeid();
                            e = meid;
                        } else if (telephonyManager.getPhoneType() == 2) {
                            String deviceId = telephonyManager.getDeviceId();
                            e = deviceId;
                            if (TextUtils.isEmpty(deviceId)) {
                            }
                        } else {
                            e = null;
                        }
                        v = true;
                    }
                } catch (Exception e2) {
                    com.kwad.sdk.core.d.b.a(e2);
                    if (z2) {
                        v = true;
                    }
                }
                return e;
            }
            return e;
        }
    }

    public static boolean d(String str) {
        for (int i2 = 0; i2 < str.length(); i2++) {
            try {
                if (str.charAt(i2) != '0') {
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static String e() {
        return Build.MODEL;
    }

    public static void e(String str) {
        Context a2 = ((com.kwad.sdk.service.kwai.d) ServiceProvider.a(com.kwad.sdk.service.kwai.d.class)).a();
        if (a2 == null) {
            return;
        }
        a2.getSharedPreferences("ksadsdk_pref", 0).edit().putString(HttpRequest.ANDROID_ID, str).apply();
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x0098, code lost:
        if (android.text.TextUtils.isEmpty(com.kwad.sdk.utils.av.j[1]) != false) goto L51;
     */
    @SuppressLint({"HardwareIds", "MissingPermission"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized String[] e(@Nullable Context context) {
        synchronized (av.class) {
            if (an.c() && an.e() != null) {
                return an.e();
            } else if (u) {
                return j;
            } else if (Build.VERSION.SDK_INT >= 29) {
                return j;
            } else {
                boolean z2 = false;
                if (TextUtils.isEmpty(j[0]) && TextUtils.isEmpty(j[1]) && context != null) {
                    if (an.c() || ((com.kwad.sdk.service.kwai.f) ServiceProvider.a(com.kwad.sdk.service.kwai.f.class)).a(1L)) {
                        return j;
                    }
                    try {
                        boolean a2 = SystemUtil.a(context);
                        if (a2) {
                            try {
                                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                                if (telephonyManager != null) {
                                    if (Build.VERSION.SDK_INT >= 26) {
                                        int min = Math.min(f(context), 2);
                                        for (int i2 = 0; i2 < min; i2++) {
                                            j[i2] = telephonyManager.getImei(i2);
                                        }
                                        if (TextUtils.isEmpty(j[0])) {
                                        }
                                    } else {
                                        if (telephonyManager.getPhoneType() == 1) {
                                            if (Build.VERSION.SDK_INT >= 23) {
                                                int min2 = Math.min(f(context), 2);
                                                for (int i3 = 0; i3 < min2; i3++) {
                                                    j[i3] = telephonyManager.getDeviceId(i3);
                                                }
                                            } else {
                                                j[0] = telephonyManager.getDeviceId();
                                                j[1] = null;
                                            }
                                            if (TextUtils.isEmpty(j[0]) && TextUtils.isEmpty(j[1])) {
                                            }
                                        } else {
                                            j[0] = null;
                                            j[1] = null;
                                        }
                                        u = true;
                                    }
                                }
                            } catch (Exception e2) {
                                e = e2;
                                z2 = a2;
                                com.kwad.sdk.core.d.b.b(e);
                                if (z2) {
                                    u = true;
                                }
                                return j;
                            }
                        }
                    } catch (Exception e3) {
                        e = e3;
                    }
                    return j;
                }
                return j;
            }
        }
    }

    public static synchronized int f(Context context) {
        synchronized (av.class) {
            if (g || f > 0 || Build.VERSION.SDK_INT < 23 || context == null || an.c()) {
                return f;
            }
            try {
                f = ((TelephonyManager) context.getSystemService("phone")).getPhoneCount();
            } catch (Exception unused) {
            }
            g = f == 0;
            return f;
        }
    }

    public static synchronized long f() {
        long j2;
        synchronized (av.class) {
            j2 = 0;
            if (an.c() && (!TextUtils.isEmpty(an.d()) || an.e() != null)) {
                j2 = 1;
            }
            if (an.a() && an.b() != null) {
                j2 |= 64;
            }
            if (an.c() && !TextUtils.isEmpty(an.f())) {
                j2 |= 2;
            }
            if (an.g() && !TextUtils.isEmpty(an.h())) {
                j2 |= 4;
            }
            if (an.i() && !TextUtils.isEmpty(an.j())) {
                j2 |= 2048;
            }
            if (an.m()) {
                if (an.n() != null) {
                    j2 |= 16;
                }
            }
        }
        return j2;
    }

    @SuppressLint({"MissingPermission"})
    public static int g(Context context) {
        if (context == null || h > 0 || i || Build.VERSION.SDK_INT < 22 || !SystemUtil.a(context) || an.c()) {
            return h;
        }
        try {
            h = ((SubscriptionManager) context.getSystemService("telephony_subscription_service")).getActiveSubscriptionInfoCount();
        } catch (Throwable unused) {
        }
        i = h != 0;
        return h;
    }

    public static String g() {
        return Build.BRAND;
    }

    public static synchronized long h() {
        long elapsedRealtime;
        synchronized (av.class) {
            elapsedRealtime = SystemClock.elapsedRealtime() / 1000;
        }
        return elapsedRealtime;
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    public static synchronized String h(Context context) {
        synchronized (av.class) {
            if (context != null) {
                if (!r && TextUtils.isEmpty(k) && SystemUtil.a(context) && !an.c() && !((com.kwad.sdk.service.kwai.f) ServiceProvider.a(com.kwad.sdk.service.kwai.f.class)).a(128L)) {
                    try {
                        k = ((TelephonyManager) context.getApplicationContext().getSystemService("phone")).getSubscriberId();
                    } catch (Exception unused) {
                    }
                    r = TextUtils.isEmpty(k);
                    return k;
                }
            }
            return k;
        }
    }

    public static synchronized long i() {
        long j2;
        synchronized (av.class) {
            j2 = Build.TIME;
        }
        return j2;
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    public static String i(Context context) {
        if (!TextUtils.isEmpty(l) || context == null) {
            return l;
        }
        if (s) {
            return l;
        }
        if (an.c() || ((com.kwad.sdk.service.kwai.f) ServiceProvider.a(com.kwad.sdk.service.kwai.f.class)).a(128L)) {
            return l;
        }
        boolean z2 = false;
        try {
            z2 = SystemUtil.a(context);
            if (z2) {
                l = ((TelephonyManager) context.getApplicationContext().getSystemService("phone")).getSimSerialNumber();
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.a(e2);
            l = null;
        }
        if (z2 && TextUtils.isEmpty(l)) {
            s = true;
        }
        String str = TextUtils.isEmpty(l) ? "" : l;
        l = str;
        return str;
    }

    public static synchronized int j(Context context) {
        int ringerMode;
        synchronized (av.class) {
            ringerMode = ((AudioManager) context.getSystemService("audio")).getRingerMode();
        }
        return ringerMode;
    }

    public static synchronized String j() {
        String str;
        synchronized (av.class) {
            str = Build.FINGERPRINT;
        }
        return str;
    }

    public static int k(Context context) {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.widthPixels;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static synchronized String k() {
        synchronized (av.class) {
            if (!TextUtils.isEmpty(a)) {
                return a;
            }
            String radioVersion = Build.getRadioVersion();
            a = radioVersion;
            return radioVersion;
        }
    }

    public static int l(Context context) {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.heightPixels;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static synchronized String l() {
        String d2;
        synchronized (av.class) {
            d2 = am.d();
        }
        return d2;
    }

    public static synchronized String m() {
        String e2;
        synchronized (av.class) {
            e2 = am.e();
        }
        return e2;
    }

    @SuppressLint({"HardwareIds"})
    public static String m(Context context) {
        if (!an.c() || TextUtils.isEmpty(an.f())) {
            if (!TextUtils.isEmpty(m) || context == null) {
                return m;
            }
            if (t) {
                return m;
            }
            if (an.c() || ((com.kwad.sdk.service.kwai.f) ServiceProvider.a(com.kwad.sdk.service.kwai.f.class)).a(2L)) {
                return m;
            }
            try {
                String string = Settings.Secure.getString(context.getContentResolver(), HttpRequest.ANDROID_ID);
                m = string;
                if (!d(string)) {
                    m = "";
                }
            } catch (Exception unused) {
            }
            if (TextUtils.isEmpty(m)) {
                t = true;
            }
            return m;
        }
        return an.f();
    }

    public static String n() {
        return Build.MANUFACTURER;
    }

    @SuppressLint({"HardwareIds"})
    public static synchronized String n(@Nullable Context context) {
        synchronized (av.class) {
            if (TextUtils.isEmpty(b) && context != null && !c) {
                if (an.g()) {
                    String h2 = an.h();
                    b = h2;
                    return h2;
                } else if (((com.kwad.sdk.service.kwai.f) ServiceProvider.a(com.kwad.sdk.service.kwai.f.class)).a(4L)) {
                    return b;
                } else {
                    try {
                        WifiInfo connectionInfo = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
                        if (connectionInfo != null) {
                            b = connectionInfo.getMacAddress();
                        }
                        if (b(b)) {
                            Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                NetworkInterface networkInterface = (NetworkInterface) it.next();
                                if (networkInterface != null && "wlan0".equals(networkInterface.getName())) {
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
                                        b = sb.toString();
                                    }
                                }
                            }
                        }
                        if (b(b)) {
                            b = com.kwad.sdk.crash.utils.g.a(Runtime.getRuntime().exec("cat /sys/class/net/wlan0/address ").getInputStream());
                        }
                        if (!b(b)) {
                            b = b.toUpperCase(Locale.US);
                        }
                    } catch (Exception unused) {
                        c = true;
                    }
                    c = b(b);
                    return b;
                }
            }
            return b;
        }
    }

    public static int o() {
        if (p == -1) {
            p = r(((com.kwad.sdk.service.kwai.d) ServiceProvider.a(com.kwad.sdk.service.kwai.d.class)).a()) ? 4 : 3;
        }
        return p;
    }

    @Nullable
    public static List<String> o(@NonNull Context context) {
        String[] list;
        if (!c.a(context) && p(context)) {
            File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data");
            if (file.exists() && file.isDirectory() && (list = file.list()) != null) {
                ArrayList arrayList = new ArrayList();
                for (String str : list) {
                    if (!TextUtils.isEmpty(str) && !str.startsWith(".")) {
                        arrayList.add(str);
                    }
                }
                return arrayList;
            }
            return null;
        }
        return new ArrayList();
    }

    public static String p() {
        if (TextUtils.isEmpty(o)) {
            o = System.getProperty("os.arch");
        }
        return o;
    }

    public static boolean p(@NonNull Context context) {
        return context.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    public static String q() {
        return Build.VERSION.RELEASE;
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    public static synchronized String q(@Nullable Context context) {
        synchronized (av.class) {
            if (an.c() && !TextUtils.isEmpty(an.d())) {
                return an.d();
            } else if (q) {
                return d;
            } else {
                if (TextUtils.isEmpty(d) && context != null) {
                    if (Build.VERSION.SDK_INT >= 29) {
                        return d;
                    } else if (an.c() || ((com.kwad.sdk.service.kwai.f) ServiceProvider.a(com.kwad.sdk.service.kwai.f.class)).a(1L)) {
                        return d;
                    } else {
                        boolean z2 = false;
                        try {
                            z2 = SystemUtil.a(context);
                            if (z2) {
                                String deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
                                d = deviceId;
                                if (TextUtils.isEmpty(deviceId)) {
                                    q = true;
                                }
                            }
                        } catch (Exception e2) {
                            com.kwad.sdk.core.d.b.a(e2);
                            if (z2) {
                                q = true;
                            }
                        }
                        return d;
                    }
                }
                return d;
            }
        }
    }

    public static int r() {
        return Build.VERSION.SDK_INT;
    }

    public static boolean r(Context context) {
        return (context == null || context.getResources() == null || context.getResources().getConfiguration() == null || (context.getResources().getConfiguration().screenLayout & 15) < 3) ? false : true;
    }

    public static String s() {
        return Locale.getDefault().getLanguage();
    }

    public static String t() {
        if (an.k() || ((com.kwad.sdk.service.kwai.f) ServiceProvider.a(com.kwad.sdk.service.kwai.f.class)).a(8L)) {
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

    public static String u() {
        try {
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.b(e2);
        }
        if (TextUtils.isEmpty(n)) {
            String y2 = y();
            if (!TextUtils.isEmpty(y2)) {
                String str = "ANDROID_" + y2;
                n = str;
                return str;
            }
            String m2 = m(((com.kwad.sdk.service.kwai.d) ServiceProvider.a(com.kwad.sdk.service.kwai.d.class)).a());
            if (!TextUtils.isEmpty(m2) && !c(m2) && d(m2)) {
                String str2 = "ANDROID_" + m2;
                n = str2;
                return str2;
            }
            String x2 = x();
            if (!TextUtils.isEmpty(x2)) {
                n = "ANDROID_" + x2;
                e(x2);
                return n;
            }
            return "ANDROID_";
        }
        return n;
    }

    public static String v() {
        if (TextUtils.isEmpty(y)) {
            try {
                String h2 = o.h(new File("/proc/sys/kernel/random/boot_id"));
                y = TextUtils.isEmpty(h2) ? "" : h2.substring(0, h2.indexOf("\n"));
            } catch (IOException unused) {
            }
            return y;
        }
        return y;
    }

    public static long w() {
        BufferedReader bufferedReader;
        Throwable th;
        String readLine;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(HardwareInfoUtils.MEM_INFO_FILE), 8192);
            do {
                try {
                    readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        com.kwad.sdk.crash.utils.b.a(bufferedReader);
                        return 0L;
                    }
                } catch (Exception unused) {
                    bufferedReader2 = bufferedReader;
                    com.kwad.sdk.crash.utils.b.a(bufferedReader2);
                    return 0L;
                } catch (Throwable th2) {
                    th = th2;
                    com.kwad.sdk.crash.utils.b.a(bufferedReader);
                    throw th;
                }
            } while (!readLine.contains("MemTotal"));
            long longValue = Long.valueOf(readLine.split("\\s+")[1]).longValue() << 10;
            com.kwad.sdk.crash.utils.b.a(bufferedReader);
            return longValue;
        } catch (Exception unused2) {
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
        }
    }

    public static String x() {
        try {
            return a(Long.toHexString(new Random(System.currentTimeMillis()).nextLong()), 16, '0');
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String y() {
        Context a2 = ((com.kwad.sdk.service.kwai.d) ServiceProvider.a(com.kwad.sdk.service.kwai.d.class)).a();
        if (a2 == null) {
            return null;
        }
        return a2.getSharedPreferences("ksadsdk_pref", 0).getString(HttpRequest.ANDROID_ID, null);
    }
}
