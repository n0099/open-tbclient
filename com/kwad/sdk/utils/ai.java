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
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobads.container.util.network.NetworkInfoUtils;
import com.baidu.mobstat.Config;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.SdkConfig;
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
/* loaded from: classes6.dex */
public class ai {

    /* renamed from: a  reason: collision with root package name */
    public static String f34096a = "";

    /* renamed from: b  reason: collision with root package name */
    public static String f34097b = "";

    /* renamed from: c  reason: collision with root package name */
    public static String f34098c = "";

    /* renamed from: h  reason: collision with root package name */
    public static String f34103h;

    /* renamed from: i  reason: collision with root package name */
    public static String f34104i;
    public static int q;
    public static long r;

    /* renamed from: d  reason: collision with root package name */
    public static String[] f34099d = {"", ""};

    /* renamed from: e  reason: collision with root package name */
    public static String f34100e = "";

    /* renamed from: f  reason: collision with root package name */
    public static String f34101f = "";

    /* renamed from: g  reason: collision with root package name */
    public static String f34102g = "";
    public static int j = -1;
    public static boolean k = false;
    public static boolean l = false;
    public static boolean m = false;
    public static boolean n = false;
    public static boolean o = false;
    public static boolean p = false;
    public static boolean s = true;
    public static boolean t = true;
    public static final List<String> u = Arrays.asList("a5f5faddde9e9f02", "8e17f7422b35fbea", "b88c3c236923d9d9", "cb36bf76cca443d0", "5d4e49ed381836c5", "cffa38e9136f93e9", "62bd2daa59ea0173", "b7aad49a2d5bc5d9", "f2138912c5e5dd5c", "330a1e81a2bf9f31", "59c0f432ccbef844", "521376155e535f39", "aa5ec6ce14abd680", "5522a09bb500d82f", "6dfe4a96800edfb4", "ecc9a2dded8cdf72", "399f868043955b11", "34dc327c00dbff94", "d1b4e3862c309f8b", "68bdbf71f863ccac", "01558dd995085a35", "351174200a06da52", "fa0988506c76ff4b", "8eb8ef823312c61a", "a72e81be65c4638b", "416d15a015c8f324", "474086ea2d737519", "befdddf908c8d749", "780ee58a6f57aab6", "cfe86fa07cae3601", "704ff4d1534f0ff4", "9298b9e9bbd7cdea", "7b634c42f236c6e8", "11eacf22b9ceab7d", "2941a4f39eec5864", "87d134dc5ba45550", "fdd2313bb1750eb9", "6560ef232d8424bb", "5d876286e1064482", "f66fefb916f4962d", "7baf82d0ac49f596", "57748921d8d88ed4", "120cd57f1a50b8f5", "e164f9610ddd9fc8", "6256f0e8da6389de", "bcb22df712476416", "714fa9aff63f7adb", "cb8252e4da7cf610", "e18f649aa80e140c", "966790a9db5ea8d8", "e1769e681af901dd", "d23f2574a60964a4", "d717e6298d3c9cb2", "f5ea5e8ba730864e", "a8a0a223d1a42232", "6675a4f231f5c8db", "3edb7c2103e5c75a", "8ce6a9a216b326c4", "af606153eb3be0a7", "7ae255c3d760c920", "e50e94c40048c5fd", "55009bca30f9dc4c", "c37566487909214a", "891b74f7e534d14a", "726e190aae663525", "df473127d30fb669", "bfbcc646d92dfd48", "a4a1954c44751936", "da4a44a3d7c4d8be", "5ff5bca4a775dd30", "14917461e1917c53", "14ce20d0a80955fa", "a56a63de4d3f3d39", "f780246adc7bd556", "3495a541aea0da72", "f7f205ce47fed2a5", "f52db3f434279c3a", "dca17088c97dee5e", "dd53a8b3a2a4ccc0", "52e07629290d45e4", "cda522b0f8f50d9a", "b85a1c8bcd51d82c", "e344a00cd3f5e93a", "fa59d8a66d7bdd88", "68fb1f1393a216e8", "4c30ab1fb10af181", "b1376e0578099143", "88752f72d8d305fd", "fddf20078d27bf3c", "dab2120bffa2be8c", "c7c8dde481793471", "e4b1bdbcabfc284d");

    public static int a(Context context) {
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

    public static int a(@NonNull Context context, @NonNull String str) {
        if (str != null) {
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        }
        throw new IllegalArgumentException("permission is null");
    }

    public static long a() {
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
        s = sdkConfig.canReadMacAddress();
        t = sdkConfig.canReadICCID();
    }

    public static boolean a(String str) {
        return u.contains(str.toLowerCase(Locale.US));
    }

    public static long b() {
        if (com.kwad.sdk.core.config.c.a(1024L)) {
            return 0L;
        }
        try {
            return b(Environment.getDataDirectory());
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static long b(Context context) {
        long j2 = r;
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
            r = j3;
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

    public static void b(String str) {
        Context context = KsAdSDKImpl.get().getContext();
        if (context == null) {
            return;
        }
        context.getSharedPreferences("ksadsdk_pref", 0).edit().putString(IAdRequestParam.ANDROID_ID, str).apply();
    }

    public static int c() {
        int i2 = q;
        if (i2 > 0) {
            return i2;
        }
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        q = availableProcessors;
        return availableProcessors;
    }

    public static long c(Context context) {
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

    public static String d() {
        Locale locale = Build.VERSION.SDK_INT >= 24 ? LocaleList.getDefault().get(0) : Locale.getDefault();
        if (locale == null) {
            locale = Locale.CHINESE;
        }
        return String.valueOf(locale);
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    public static String d(@Nullable Context context) {
        if (k) {
            return f34097b;
        }
        if (!TextUtils.isEmpty(f34097b) || context == null) {
            return f34097b;
        }
        if (com.kwad.sdk.core.config.c.a(1L)) {
            return f34097b;
        }
        try {
            r0 = a(context, "android.permission.READ_PHONE_STATE") == 0;
            if (r0) {
                String deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
                f34097b = deviceId;
                if (TextUtils.isEmpty(deviceId)) {
                    k = true;
                }
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
            if (r0) {
                k = true;
            }
        }
        return f34097b;
    }

    public static String e() {
        return Build.MODEL;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0039, code lost:
        if (android.text.TextUtils.isEmpty(r4) != false) goto L21;
     */
    @SuppressLint({"HardwareIds", "MissingPermission"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String e(@Nullable Context context) {
        TelephonyManager telephonyManager;
        if (p) {
            return f34098c;
        }
        if (!TextUtils.isEmpty(f34098c) || context == null) {
            return f34098c;
        }
        try {
            r0 = a(context, "android.permission.READ_PHONE_STATE") == 0;
            if (r0 && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null) {
                if (Build.VERSION.SDK_INT >= 26) {
                    String meid = telephonyManager.getMeid();
                    f34098c = meid;
                } else if (telephonyManager.getPhoneType() == 2) {
                    String deviceId = telephonyManager.getDeviceId();
                    f34098c = deviceId;
                    if (TextUtils.isEmpty(deviceId)) {
                    }
                } else {
                    f34098c = null;
                }
                p = true;
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
            if (r0) {
                p = true;
            }
        }
        return f34098c;
    }

    public static String f() {
        return Build.BRAND;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0072, code lost:
        if (android.text.TextUtils.isEmpty(com.kwad.sdk.utils.ai.f34099d[1]) != false) goto L35;
     */
    @SuppressLint({"HardwareIds", "MissingPermission"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String[] f(@Nullable Context context) {
        if (o) {
            return f34099d;
        }
        boolean z = false;
        if (TextUtils.isEmpty(f34099d[0]) && TextUtils.isEmpty(f34099d[1]) && context != null) {
            if (com.kwad.sdk.core.config.c.a(1L)) {
                return f34099d;
            }
            try {
                boolean z2 = a(context, "android.permission.READ_PHONE_STATE") == 0;
                if (z2) {
                    try {
                        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                        if (telephonyManager != null) {
                            if (Build.VERSION.SDK_INT >= 26) {
                                int min = Math.min(telephonyManager.getPhoneCount(), 2);
                                for (int i2 = 0; i2 < min; i2++) {
                                    f34099d[i2] = telephonyManager.getImei(i2);
                                }
                                if (TextUtils.isEmpty(f34099d[0])) {
                                }
                            } else {
                                if (telephonyManager.getPhoneType() == 1) {
                                    if (Build.VERSION.SDK_INT >= 23) {
                                        int min2 = Math.min(telephonyManager.getPhoneCount(), 2);
                                        for (int i3 = 0; i3 < min2; i3++) {
                                            f34099d[i3] = telephonyManager.getDeviceId(i3);
                                        }
                                    } else {
                                        f34099d[0] = telephonyManager.getDeviceId();
                                        f34099d[1] = null;
                                    }
                                    if (TextUtils.isEmpty(f34099d[0]) && TextUtils.isEmpty(f34099d[1])) {
                                    }
                                } else {
                                    f34099d[0] = null;
                                    f34099d[1] = null;
                                }
                                o = true;
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        z = z2;
                        com.kwad.sdk.core.d.a.a(e);
                        if (z) {
                            o = true;
                        }
                        return f34099d;
                    }
                }
            } catch (Exception e3) {
                e = e3;
            }
            return f34099d;
        }
        return f34099d;
    }

    public static String g() {
        return Build.MANUFACTURER;
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    public static String g(Context context) {
        if (!TextUtils.isEmpty(f34100e) || context == null) {
            return f34100e;
        }
        if (!l && !com.kwad.sdk.core.config.c.a(128L)) {
            try {
                r1 = a(context, "android.permission.READ_PHONE_STATE") == 0;
                if (r1) {
                    f34100e = ((TelephonyManager) context.getApplicationContext().getSystemService("phone")).getSubscriberId();
                }
            } catch (Exception unused) {
                f34100e = null;
            }
            if (r1 && TextUtils.isEmpty(f34100e)) {
                l = true;
            }
            String str = TextUtils.isEmpty(f34100e) ? "" : f34100e;
            f34100e = str;
            return str;
        }
        return f34100e;
    }

    public static int h() {
        if (j == -1) {
            j = o(KsAdSDKImpl.get().getContext()) ? 4 : 3;
        }
        return j;
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    public static String h(Context context) {
        if (!TextUtils.isEmpty(f34101f) || context == null) {
            return f34101f;
        }
        if (!m && t && !com.kwad.sdk.core.config.c.a(128L)) {
            try {
                r1 = a(context, "android.permission.READ_PHONE_STATE") == 0;
                if (r1) {
                    f34101f = ((TelephonyManager) context.getApplicationContext().getSystemService("phone")).getSimSerialNumber();
                }
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
                f34101f = null;
            }
            if (r1 && TextUtils.isEmpty(f34101f)) {
                m = true;
            }
            String str = TextUtils.isEmpty(f34101f) ? "" : f34101f;
            f34101f = str;
            return str;
        }
        return f34101f;
    }

    public static int i(Context context) {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.widthPixels;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static String i() {
        if (TextUtils.isEmpty(f34104i)) {
            f34104i = System.getProperty("os.arch");
        }
        return f34104i;
    }

    public static int j(Context context) {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.heightPixels;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static String j() {
        return Build.VERSION.RELEASE;
    }

    public static int k() {
        return Build.VERSION.SDK_INT;
    }

    @SuppressLint({"HardwareIds"})
    public static String k(Context context) {
        if (!TextUtils.isEmpty(f34102g) || context == null) {
            return f34102g;
        }
        if (!n && !com.kwad.sdk.core.config.c.a(2L)) {
            try {
                f34102g = Settings.Secure.getString(context.getContentResolver(), IAdRequestParam.ANDROID_ID);
            } catch (Exception unused) {
            }
            if (TextUtils.isEmpty(f34102g)) {
                n = true;
            }
            return f34102g;
        }
        return f34102g;
    }

    public static int l(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        if (audioManager != null) {
            return audioManager.getStreamVolume(3);
        }
        return 0;
    }

    public static String l() {
        return Locale.getDefault().getLanguage();
    }

    public static String m() {
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

    @SuppressLint({"MissingPermission"})
    public static String m(@Nullable Context context) {
        if (!TextUtils.isEmpty(f34096a) || context == null) {
            return f34096a;
        }
        if (s && !com.kwad.sdk.core.config.c.a(4L)) {
            if (TextUtils.isEmpty(f34096a)) {
                try {
                    WifiInfo connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
                    if (connectionInfo != null) {
                        f34096a = connectionInfo.getMacAddress();
                    }
                    if (TextUtils.isEmpty(f34096a) || f34096a.equals(Config.DEF_MAC_ID)) {
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
                                    f34096a = sb.toString();
                                }
                            }
                        }
                    }
                    if (TextUtils.isEmpty(f34096a) || f34096a.equals(Config.DEF_MAC_ID)) {
                        f34096a = new LineNumberReader(new InputStreamReader(Runtime.getRuntime().exec("cat /sys/class/net/wlan0/address ").getInputStream())).readLine();
                    }
                    if (!TextUtils.isEmpty(f34096a)) {
                        f34096a = f34096a.toUpperCase(Locale.US);
                    }
                } catch (Exception unused) {
                }
            }
            return f34096a;
        }
        return f34096a;
    }

    public static String n() {
        try {
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.b(e2);
        }
        if (TextUtils.isEmpty(f34103h)) {
            String q2 = q();
            if (!TextUtils.isEmpty(q2)) {
                String str = "ANDROID_" + q2;
                f34103h = str;
                return str;
            }
            String k2 = k(KsAdSDKImpl.get().getContext());
            if (!TextUtils.isEmpty(k2) && !a(k2)) {
                String str2 = "ANDROID_" + k2;
                f34103h = str2;
                return str2;
            }
            String p2 = p();
            if (!TextUtils.isEmpty(p2)) {
                f34103h = "ANDROID_" + p2;
                b(p2);
                return f34103h;
            }
            return "ANDROID_";
        }
        return f34103h;
    }

    public static String n(Context context) {
        try {
            PackageInfo packageInfo = context.getApplicationContext().getPackageManager().getPackageInfo(context.getPackageName(), 64);
            return packageInfo != null ? packageInfo.versionName : "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static long o() {
        BufferedReader bufferedReader;
        Throwable th;
        String readLine;
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

    public static boolean o(Context context) {
        return (context == null || context.getResources() == null || context.getResources().getConfiguration() == null || (context.getResources().getConfiguration().screenLayout & 15) < 3) ? false : true;
    }

    public static String p() {
        try {
            return a(Long.toHexString(new Random(System.currentTimeMillis()).nextLong()), 16, '0');
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String q() {
        Context context = KsAdSDKImpl.get().getContext();
        if (context == null) {
            return null;
        }
        return context.getSharedPreferences("ksadsdk_pref", 0).getString(IAdRequestParam.ANDROID_ID, null);
    }
}
