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
import com.baidu.mobstat.Config;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.SdkConfig;
import com.meizu.cloud.pushsdk.constants.PushConstants;
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
/* loaded from: classes3.dex */
public class ah {
    private static String f;
    private static int k;
    private static long l;

    /* renamed from: a  reason: collision with root package name */
    private static String f10776a = "";

    /* renamed from: b  reason: collision with root package name */
    private static String f10777b = "";
    private static String c = "";
    private static String d = "";
    private static String e = "";
    private static boolean g = false;
    private static boolean h = false;
    private static boolean i = false;
    private static boolean j = false;
    private static boolean m = true;
    private static boolean n = true;
    private static final List<String> o = Arrays.asList("a5f5faddde9e9f02", "8e17f7422b35fbea", "b88c3c236923d9d9", "cb36bf76cca443d0", "5d4e49ed381836c5", "cffa38e9136f93e9", "62bd2daa59ea0173", "b7aad49a2d5bc5d9", "f2138912c5e5dd5c", "330a1e81a2bf9f31", "59c0f432ccbef844", "521376155e535f39", "aa5ec6ce14abd680", "5522a09bb500d82f", "6dfe4a96800edfb4", "ecc9a2dded8cdf72", "399f868043955b11", "34dc327c00dbff94", "d1b4e3862c309f8b", "68bdbf71f863ccac", "01558dd995085a35", "351174200a06da52", "fa0988506c76ff4b", "8eb8ef823312c61a", "a72e81be65c4638b", "416d15a015c8f324", "474086ea2d737519", "befdddf908c8d749", "780ee58a6f57aab6", "cfe86fa07cae3601", "704ff4d1534f0ff4", "9298b9e9bbd7cdea", "7b634c42f236c6e8", "11eacf22b9ceab7d", "2941a4f39eec5864", "87d134dc5ba45550", "fdd2313bb1750eb9", "6560ef232d8424bb", "5d876286e1064482", "f66fefb916f4962d", "7baf82d0ac49f596", "57748921d8d88ed4", "120cd57f1a50b8f5", "e164f9610ddd9fc8", "6256f0e8da6389de", "bcb22df712476416", "714fa9aff63f7adb", "cb8252e4da7cf610", "e18f649aa80e140c", "966790a9db5ea8d8", "e1769e681af901dd", "d23f2574a60964a4", "d717e6298d3c9cb2", "f5ea5e8ba730864e", "a8a0a223d1a42232", "6675a4f231f5c8db", "3edb7c2103e5c75a", "8ce6a9a216b326c4", "af606153eb3be0a7", "7ae255c3d760c920", "e50e94c40048c5fd", "55009bca30f9dc4c", "c37566487909214a", "891b74f7e534d14a", "726e190aae663525", "df473127d30fb669", "bfbcc646d92dfd48", "a4a1954c44751936", "da4a44a3d7c4d8be", "5ff5bca4a775dd30", "14917461e1917c53", "14ce20d0a80955fa", "a56a63de4d3f3d39", "f780246adc7bd556", "3495a541aea0da72", "f7f205ce47fed2a5", "f52db3f434279c3a", "dca17088c97dee5e", "dd53a8b3a2a4ccc0", "52e07629290d45e4", "cda522b0f8f50d9a", "b85a1c8bcd51d82c", "e344a00cd3f5e93a", "fa59d8a66d7bdd88", "68fb1f1393a216e8", "4c30ab1fb10af181", "b1376e0578099143", "88752f72d8d305fd", "fddf20078d27bf3c", "dab2120bffa2be8c", "c7c8dde481793471", "e4b1bdbcabfc284d");

    public static int a(Context context) {
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                return ((BatteryManager) context.getApplicationContext().getSystemService("batterymanager")).getIntProperty(4);
            }
        } catch (Exception e2) {
        }
        return 0;
    }

    public static int a(@NonNull Context context, @NonNull String str) {
        if (str == null) {
            throw new IllegalArgumentException("permission is null");
        }
        return context.checkPermission(str, Process.myPid(), Process.myUid());
    }

    public static long a() {
        try {
            return a(Environment.getDataDirectory());
        } catch (Exception e2) {
            return 0L;
        }
    }

    private static long a(File file) {
        long j2 = 0;
        if (file != null) {
            try {
                StatFs statFs = new StatFs(file.getPath());
                if (Build.VERSION.SDK_INT < 18) {
                    j2 = statFs.getBlockCount() * statFs.getBlockSize();
                } else {
                    j2 = statFs.getBlockCountLong() * statFs.getBlockSizeLong();
                }
            } catch (Exception e2) {
            }
        }
        return j2;
    }

    private static String a(String str, int i2, char c2) {
        StringBuilder sb = new StringBuilder();
        while (sb.length() + str.length() < i2) {
            sb.append(c2);
        }
        sb.append(str);
        return sb.toString();
    }

    public static void a(SdkConfig sdkConfig) {
        m = sdkConfig.canReadMacAddress();
        n = sdkConfig.canReadICCID();
    }

    private static boolean a(String str) {
        return o.contains(str.toLowerCase(Locale.US));
    }

    public static long b() {
        try {
            return b(Environment.getDataDirectory());
        } catch (Exception e2) {
            return 0L;
        }
    }

    public static long b(Context context) {
        if (l > 0) {
            return l;
        }
        if (context == null) {
            return 0L;
        }
        try {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ((ActivityManager) context.getApplicationContext().getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getMemoryInfo(memoryInfo);
            long j2 = memoryInfo.totalMem;
            if (j2 <= 0) {
                j2 = n();
            }
            l = j2;
            return l;
        } catch (Exception e2) {
            return 0L;
        }
    }

    private static long b(File file) {
        long availableBlocksLong;
        try {
            StatFs statFs = new StatFs(file.getPath());
            if (Build.VERSION.SDK_INT < 18) {
                availableBlocksLong = statFs.getAvailableBlocks() * statFs.getBlockSize();
            } else {
                availableBlocksLong = statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong();
            }
            return availableBlocksLong;
        } catch (Exception e2) {
            return 0L;
        }
    }

    private static void b(String str) {
        Context context = KsAdSDKImpl.get().getContext();
        if (context == null) {
            return;
        }
        context.getSharedPreferences("ksadsdk_pref", 0).edit().putString("android_id", str).apply();
    }

    public static int c() {
        if (k > 0) {
            return k;
        }
        k = Runtime.getRuntime().availableProcessors();
        return k;
    }

    public static long c(Context context) {
        if (context == null) {
            return 0L;
        }
        try {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ((ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getMemoryInfo(memoryInfo);
            return memoryInfo.availMem;
        } catch (Exception e2) {
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
        if (g) {
            return "";
        }
        if (!TextUtils.isEmpty(f10777b) || context == null) {
            return f10777b;
        }
        try {
            r1 = a(context, "android.permission.READ_PHONE_STATE") == 0;
            if (r1) {
                f10777b = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
            f10777b = null;
        }
        if (r1 && c == null) {
            g = true;
        }
        return f10777b;
    }

    public static String e() {
        return Build.MODEL;
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    public static String e(Context context) {
        if (h) {
            return "";
        }
        if (!TextUtils.isEmpty(c) || context == null) {
            return c;
        }
        String str = "";
        try {
            r1 = a(context, "android.permission.READ_PHONE_STATE") == 0;
            if (r1) {
                str = ((TelephonyManager) context.getApplicationContext().getSystemService("phone")).getSubscriberId();
            }
        } catch (Exception e2) {
            str = null;
        }
        if (r1 && str == null) {
            h = true;
        }
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        c = str;
        return c;
    }

    public static String f() {
        return Build.BRAND;
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    public static String f(Context context) {
        if (i) {
            return "";
        }
        if (TextUtils.isEmpty(d)) {
            String str = "";
            if (context == null || !n) {
                return "";
            }
            try {
                r1 = a(context, "android.permission.READ_PHONE_STATE") == 0;
                if (r1) {
                    str = ((TelephonyManager) context.getApplicationContext().getSystemService("phone")).getSimSerialNumber();
                }
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
                str = null;
            }
            if (r1 && str == null) {
                i = true;
            }
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            d = str;
            return d;
        }
        return d;
    }

    public static int g(Context context) {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.widthPixels;
        } catch (Exception e2) {
            return 0;
        }
    }

    public static String g() {
        return Build.MANUFACTURER;
    }

    public static int h() {
        return n(KsAdSDKImpl.get().getContext()) ? 4 : 3;
    }

    public static int h(Context context) {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.heightPixels;
        } catch (Exception e2) {
            return 0;
        }
    }

    public static String i() {
        return Build.VERSION.RELEASE;
    }

    @SuppressLint({"HardwareIds"})
    public static String i(Context context) {
        if (j) {
            return "";
        }
        if (!TextUtils.isEmpty(e) || context == null) {
            return e;
        }
        try {
            e = Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Exception e2) {
        }
        if (TextUtils.isEmpty(e)) {
            j = true;
        }
        return e;
    }

    public static int j() {
        return Build.VERSION.SDK_INT;
    }

    public static int j(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (audioManager != null) {
            return audioManager.getStreamVolume(3);
        }
        return 0;
    }

    public static String k() {
        return Locale.getDefault().getLanguage();
    }

    public static String k(@Nullable Context context) {
        if (context == null || !m) {
            return "";
        }
        if (TextUtils.isEmpty(f10776a)) {
            try {
                WifiInfo connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
                if (connectionInfo != null) {
                    f10776a = connectionInfo.getMacAddress();
                }
                if (TextUtils.isEmpty(f10776a) || f10776a.equals(Config.DEF_MAC_ID)) {
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
                                f10776a = sb.toString();
                            }
                        }
                    }
                }
                if (TextUtils.isEmpty(f10776a) || f10776a.equals(Config.DEF_MAC_ID)) {
                    f10776a = new LineNumberReader(new InputStreamReader(Runtime.getRuntime().exec("cat /sys/class/net/wlan0/address ").getInputStream())).readLine();
                }
                if (!TextUtils.isEmpty(f10776a)) {
                    f10776a = f10776a.toUpperCase(Locale.US);
                }
            } catch (Exception e2) {
            }
        }
        return f10776a;
    }

    public static String l() {
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
        } catch (Throwable th) {
        }
        return "";
    }

    public static String l(Context context) {
        try {
            PackageInfo packageInfo = context.getApplicationContext().getPackageManager().getPackageInfo(context.getPackageName(), 64);
            if (packageInfo != null) {
                return packageInfo.versionName;
            }
        } catch (Exception e2) {
        }
        return "";
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0089 -> B:5:0x000a). Please submit an issue!!! */
    public static String m() {
        try {
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.b(e2);
        }
        if (!TextUtils.isEmpty(f)) {
            return f;
        }
        String p = p();
        if (!TextUtils.isEmpty(p)) {
            f = "ANDROID_" + p;
            return f;
        }
        String i2 = i(KsAdSDKImpl.get().getContext());
        if (!TextUtils.isEmpty(i2) && !a(i2)) {
            f = "ANDROID_" + i2;
            return f;
        }
        String o2 = o();
        if (!TextUtils.isEmpty(o2)) {
            f = "ANDROID_" + o2;
            b(o2);
            return f;
        }
        return "ANDROID_";
    }

    public static String m(Context context) {
        if (context == null) {
            return "";
        }
        int myPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return "";
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == myPid) {
                return runningAppProcessInfo.processName;
            }
        }
        return "";
    }

    private static long n() {
        BufferedReader bufferedReader;
        String readLine;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
        } catch (Exception e2) {
        } catch (Throwable th) {
            th = th;
            bufferedReader = null;
        }
        do {
            try {
                readLine = bufferedReader.readLine();
            } catch (Exception e3) {
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e4) {
                    }
                }
                return 0L;
            } catch (Throwable th2) {
                th = th2;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e5) {
                    }
                }
                throw th;
            }
            if (readLine == null) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e6) {
                    }
                }
                return 0L;
            }
        } while (!readLine.contains("MemTotal"));
        long longValue = Long.valueOf(readLine.split("\\s+")[1]).longValue() << 10;
        if (bufferedReader != null) {
            try {
                bufferedReader.close();
                return longValue;
            } catch (IOException e7) {
                return longValue;
            }
        }
        return longValue;
    }

    private static boolean n(Context context) {
        return (context == null || context.getResources() == null || context.getResources().getConfiguration() == null || (context.getResources().getConfiguration().screenLayout & 15) < 3) ? false : true;
    }

    private static String o() {
        try {
            return a(Long.toHexString(new Random(System.currentTimeMillis()).nextLong()), 16, '0');
        } catch (Throwable th) {
            return null;
        }
    }

    private static String p() {
        Context context = KsAdSDKImpl.get().getContext();
        if (context == null) {
            return null;
        }
        return context.getSharedPreferences("ksadsdk_pref", 0).getString("android_id", null);
    }
}
