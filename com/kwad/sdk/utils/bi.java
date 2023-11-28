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
import com.baidu.searchbox.download.apkcheck.ApkCheckUBCManagerKt;
import com.baidu.tbadk.core.util.ApiReplaceUtil;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.huawei.hms.common.internal.TransactionIdCreater;
import com.kwad.sdk.service.ServiceProvider;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
/* loaded from: classes10.dex */
public final class bi {
    public static String aON = null;
    public static String aOO = "";
    public static boolean aOP = false;
    public static String aOQ = "";
    public static String aOR = "";
    public static int aOS;
    public static boolean aOT;
    public static int aOU;
    public static boolean aOV;
    public static String aPa;
    public static String aPb;
    public static int aPj;
    public static long aPk;
    public static final String[] aOW = {"", ""};
    public static String aOX = "";
    public static String aOY = "";
    public static String aOZ = "";
    public static int aPc = -1;
    public static boolean aPd = false;
    public static boolean aPe = false;
    public static boolean aPf = false;
    public static boolean aPg = false;
    public static boolean aPh = false;
    public static boolean aPi = false;
    public static String aPl = "";
    public static String aPm = "";
    public static String aPn = "";
    public static final List<String> aPo = Arrays.asList("a5f5faddde9e9f02", "8e17f7422b35fbea", "b88c3c236923d9d9", "cb36bf76cca443d0", "5d4e49ed381836c5", "cffa38e9136f93e9", "62bd2daa59ea0173", "b7aad49a2d5bc5d9", "f2138912c5e5dd5c", "330a1e81a2bf9f31", "59c0f432ccbef844", "521376155e535f39", "aa5ec6ce14abd680", "5522a09bb500d82f", "6dfe4a96800edfb4", "ecc9a2dded8cdf72", "399f868043955b11", "34dc327c00dbff94", "d1b4e3862c309f8b", "68bdbf71f863ccac", "01558dd995085a35", "351174200a06da52", "fa0988506c76ff4b", "8eb8ef823312c61a", "a72e81be65c4638b", "416d15a015c8f324", "474086ea2d737519", "befdddf908c8d749", "780ee58a6f57aab6", "cfe86fa07cae3601", "704ff4d1534f0ff4", "9298b9e9bbd7cdea", "7b634c42f236c6e8", "11eacf22b9ceab7d", "2941a4f39eec5864", "87d134dc5ba45550", "fdd2313bb1750eb9", "6560ef232d8424bb", "5d876286e1064482", "f66fefb916f4962d", "7baf82d0ac49f596", "57748921d8d88ed4", "120cd57f1a50b8f5", "e164f9610ddd9fc8", "6256f0e8da6389de", "bcb22df712476416", "714fa9aff63f7adb", "cb8252e4da7cf610", "e18f649aa80e140c", "966790a9db5ea8d8", "e1769e681af901dd", "d23f2574a60964a4", "d717e6298d3c9cb2", "f5ea5e8ba730864e", "a8a0a223d1a42232", "6675a4f231f5c8db", "3edb7c2103e5c75a", "8ce6a9a216b326c4", "af606153eb3be0a7", "7ae255c3d760c920", "e50e94c40048c5fd", "55009bca30f9dc4c", "c37566487909214a", "891b74f7e534d14a", "726e190aae663525", "df473127d30fb669", "bfbcc646d92dfd48", "a4a1954c44751936", "da4a44a3d7c4d8be", "5ff5bca4a775dd30", "14917461e1917c53", "14ce20d0a80955fa", "a56a63de4d3f3d39", "f780246adc7bd556", "3495a541aea0da72", "f7f205ce47fed2a5", "f52db3f434279c3a", "dca17088c97dee5e", "dd53a8b3a2a4ccc0", "52e07629290d45e4", "cda522b0f8f50d9a", "b85a1c8bcd51d82c", "e344a00cd3f5e93a", "fa59d8a66d7bdd88", "68fb1f1393a216e8", "4c30ab1fb10af181", "b1376e0578099143", "88752f72d8d305fd", "fddf20078d27bf3c", "dab2120bffa2be8c", "c7c8dde481793471", "e4b1bdbcabfc284d");

    public static synchronized String LA() {
        synchronized (bi.class) {
            if (!TextUtils.isEmpty(aON)) {
                return aON;
            }
            String radioVersion = Build.getRadioVersion();
            aON = radioVersion;
            return radioVersion;
        }
    }

    public static synchronized String LB() {
        String name;
        synchronized (bi.class) {
            name = at.getName();
        }
        return name;
    }

    public static synchronized String LC() {
        String version;
        synchronized (bi.class) {
            version = at.getVersion();
        }
        return version;
    }

    public static String LD() {
        return Build.MANUFACTURER;
    }

    public static int LE() {
        int i;
        if (aPc == -1) {
            if (df(((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext())) {
                i = 4;
            } else {
                i = 3;
            }
            aPc = i;
        }
        return aPc;
    }

    public static String LF() {
        if (TextUtils.isEmpty(aPb)) {
            aPb = System.getProperty("os.arch");
        }
        return aPb;
    }

    public static int LG() {
        return Build.VERSION.SDK_INT;
    }

    public static String LI() {
        try {
            return a(Long.toHexString(new Random(System.currentTimeMillis()).nextLong()), 16, TransactionIdCreater.FILL_BYTE);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String LJ() {
        if (((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext() == null) {
            return null;
        }
        String i = y.i("ksadsdk_pref", HttpRequest.ANDROID_ID, null);
        y.j(i, "ksadsdk_pref", HttpRequest.ANDROID_ID);
        return i;
    }

    public static String LK() {
        String substring;
        if (!TextUtils.isEmpty(aPl)) {
            return aPl;
        }
        try {
            String V = q.V(new File("/proc/sys/kernel/random/boot_id"));
            if (TextUtils.isEmpty(V)) {
                substring = "";
            } else {
                substring = V.substring(0, V.indexOf("\n"));
            }
            aPl = substring;
        } catch (Throwable unused) {
        }
        return aPl;
    }

    public static long Lq() {
        return com.kwad.sdk.crash.utils.h.K(Environment.getDataDirectory());
    }

    public static long Lr() {
        if (((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).T(1024L)) {
            return 0L;
        }
        return com.kwad.sdk.crash.utils.h.J(Environment.getDataDirectory());
    }

    public static long Ls() {
        long freeMemory;
        try {
            freeMemory = Runtime.getRuntime().freeMemory();
        } catch (Throwable unused) {
        }
        if (freeMemory <= 0) {
            return 0L;
        }
        return freeMemory;
    }

    public static int Lt() {
        int i = aPj;
        if (i > 0) {
            return i;
        }
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        aPj = availableProcessors;
        return availableProcessors;
    }

    public static String Lu() {
        return Build.MODEL;
    }

    public static String Lw() {
        return Build.BRAND;
    }

    public static synchronized long Lx() {
        long elapsedRealtime;
        synchronized (bi.class) {
            elapsedRealtime = SystemClock.elapsedRealtime() / 1000;
        }
        return elapsedRealtime;
    }

    public static synchronized long Ly() {
        long j;
        synchronized (bi.class) {
            j = Build.TIME;
        }
        return j;
    }

    public static synchronized String Lz() {
        String str;
        synchronized (bi.class) {
            str = Build.FINGERPRINT;
        }
        return str;
    }

    public static String getLanguage() {
        return Locale.getDefault().getLanguage();
    }

    public static String getLocale() {
        Locale locale;
        if (Build.VERSION.SDK_INT >= 24) {
            locale = LocaleList.getDefault().get(0);
        } else {
            locale = Locale.getDefault();
        }
        if (locale == null) {
            locale = Locale.CHINESE;
        }
        return String.valueOf(locale);
    }

    public static String getOsVersion() {
        return Build.VERSION.RELEASE;
    }

    public static String LH() {
        if (au.KO() || ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).T(8L)) {
            return "";
        }
        if (TextUtils.isEmpty(aPn)) {
            return aPn;
        }
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if ((nextElement instanceof Inet4Address) && !nextElement.isLoopbackAddress()) {
                        String hostAddress = nextElement.getHostAddress();
                        aPn = hostAddress;
                        return hostAddress;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    public static long Lo() {
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
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                        return 0L;
                    }
                } catch (Exception unused) {
                    bufferedReader2 = bufferedReader;
                    com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader2);
                    return 0L;
                } catch (Throwable th2) {
                    th = th2;
                    com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                    throw th;
                }
            } while (!readLine.contains("MemTotal"));
            long longValue = Long.valueOf(readLine.split("\\s+")[1]).longValue() << 10;
            com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
            return longValue;
        } catch (Exception unused2) {
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
        }
    }

    public static synchronized long Lv() {
        long j;
        synchronized (bi.class) {
            j = 0;
            if (au.usePhoneStateDisable() && (!TextUtils.isEmpty(au.KH()) || au.KI() != null)) {
                j = 1;
            }
            if (au.KF() && au.KG() != null) {
                j |= 64;
            }
            if (au.usePhoneStateDisable() && !TextUtils.isEmpty(au.KJ())) {
                j |= 2;
            }
            if (au.KK() && !TextUtils.isEmpty(au.KL())) {
                j |= 4;
            }
            if (au.KM() && !TextUtils.isEmpty(au.KN())) {
                j |= 2048;
            }
            if (au.KQ()) {
                if (au.KR() != null) {
                    j |= 16;
                }
            }
        }
        return j;
    }

    public static String getDeviceId() {
        try {
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e);
        }
        if (!TextUtils.isEmpty(aPa)) {
            return aPa;
        }
        String LJ = LJ();
        if (!TextUtils.isEmpty(LJ)) {
            String str = "ANDROID_" + LJ;
            aPa = str;
            return str;
        }
        String cw = cw(((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext());
        if (!TextUtils.isEmpty(cw) && !gp(cw) && gq(cw)) {
            String str2 = "ANDROID_" + cw;
            aPa = str2;
            return str2;
        }
        String LI = LI();
        if (!TextUtils.isEmpty(LI)) {
            aPa = "ANDROID_" + LI;
            gr(LI);
            return aPa;
        }
        return "ANDROID_";
    }

    public static String a(String str, int i, char c) {
        StringBuilder sb = new StringBuilder();
        while (sb.length() + str.length() < 16) {
            sb.append(TransactionIdCreater.FILL_BYTE);
        }
        sb.append(str);
        return sb.toString();
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    public static synchronized String cA(Context context) {
        synchronized (bi.class) {
            if (context != null) {
                if (!aPe && TextUtils.isEmpty(aOX) && SystemUtil.cU(context) && !au.usePhoneStateDisable() && o.JN()) {
                    try {
                        aOX = ApiReplaceUtil.getSubscriberId((TelephonyManager) context.getApplicationContext().getSystemService("phone"));
                    } catch (Exception unused) {
                    }
                    aPe = TextUtils.isEmpty(aOX);
                    return aOX;
                }
            }
            return aOX;
        }
    }

    @SuppressLint({"HardwareIds"})
    public static String cw(Context context) {
        if (TextUtils.isEmpty(aOZ) && context != null && !aPg) {
            if (au.usePhoneStateDisable()) {
                return au.KJ();
            }
            if (!o.JH()) {
                return aOZ;
            }
            try {
                String string = ApiReplaceUtil.Overload.getString(context.getContentResolver(), HttpRequest.ANDROID_ID);
                aOZ = string;
                if (!gq(string)) {
                    aOZ = "";
                }
            } catch (Exception unused) {
            }
            if (TextUtils.isEmpty(aOZ)) {
                aPg = true;
            }
            return aOZ;
        }
        return aOZ;
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    public static String dd(Context context) {
        String str;
        if (TextUtils.isEmpty(aOY) && context != null) {
            if (aPf) {
                return aOY;
            }
            if (au.usePhoneStateDisable()) {
                return aOY;
            }
            if (!o.JO()) {
                return aOY;
            }
            try {
                if (SystemUtil.cU(context)) {
                    aOY = ApiReplaceUtil.getSimSerialNumber((TelephonyManager) context.getApplicationContext().getSystemService("phone"));
                }
            } catch (Exception e) {
                com.kwad.sdk.core.e.c.printStackTrace(e);
                aOY = null;
            }
            if (TextUtils.isEmpty(aOY)) {
                aPf = true;
            }
            if (TextUtils.isEmpty(aOY)) {
                str = "";
            } else {
                str = aOY;
            }
            aOY = str;
            return str;
        }
        return aOY;
    }

    public static long cV(Context context) {
        if (context == null || ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).T(1024L)) {
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

    public static int cW(Context context) {
        if (((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).T(512L)) {
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

    public static long cX(Context context) {
        long j = aPk;
        if (j > 0) {
            return j;
        }
        if (context == null) {
            return 0L;
        }
        try {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ((ActivityManager) context.getApplicationContext().getSystemService("activity")).getMemoryInfo(memoryInfo);
            long j2 = memoryInfo.totalMem;
            if (j2 <= 0) {
                j2 = Lo();
            }
            aPk = j2;
            return j2;
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static String ca(boolean z) {
        Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
        String bc = com.kwad.sdk.core.f.a.bc(context);
        if (!TextUtils.isEmpty(bc)) {
            return bc;
        }
        if (z) {
            return bc;
        }
        if (TextUtils.isEmpty(cY(context))) {
            return ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).yp();
        }
        return bc;
    }

    public static synchronized int de(Context context) {
        int ringerMode;
        synchronized (bi.class) {
            ringerMode = ((AudioManager) context.getSystemService("audio")).getRingerMode();
        }
        return ringerMode;
    }

    public static boolean df(Context context) {
        if (context == null || context.getResources() == null || context.getResources().getConfiguration() == null || (context.getResources().getConfiguration().screenLayout & 15) < 3) {
            return false;
        }
        return true;
    }

    public static boolean di(@NonNull Context context) {
        if (context.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            return true;
        }
        return false;
    }

    public static int getScreenHeight(Context context) {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService(ApkCheckUBCManagerKt.VALUE_WINDOW)).getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.heightPixels;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static int getScreenWidth(Context context) {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService(ApkCheckUBCManagerKt.VALUE_WINDOW)).getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.widthPixels;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static boolean go(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(Config.DEF_MAC_ID)) {
            return false;
        }
        return true;
    }

    public static boolean gp(String str) {
        return aPo.contains(str.toLowerCase(Locale.US));
    }

    public static boolean gq(String str) {
        for (int i = 0; i < str.length(); i++) {
            try {
                if (str.charAt(i) != '0') {
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static void gr(String str) {
        if (((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext() == null) {
            return;
        }
        y.a("ksadsdk_pref", HttpRequest.ANDROID_ID, str, true);
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    public static synchronized String cY(@Nullable Context context) {
        synchronized (bi.class) {
            if (au.usePhoneStateDisable() && !TextUtils.isEmpty(au.KH())) {
                return au.KH();
            } else if (aPd) {
                return aOQ;
            } else {
                if (TextUtils.isEmpty(aOQ) && context != null) {
                    if (Build.VERSION.SDK_INT >= 29) {
                        return aOQ;
                    } else if (au.usePhoneStateDisable()) {
                        return aOQ;
                    } else if (!o.JM()) {
                        return aOQ;
                    } else {
                        boolean z = false;
                        try {
                            z = SystemUtil.cU(context);
                            if (z) {
                                String deviceId = ApiReplaceUtil.getDeviceId((TelephonyManager) context.getSystemService("phone"));
                                aOQ = deviceId;
                                if (TextUtils.isEmpty(deviceId)) {
                                    aPd = true;
                                }
                            }
                        } catch (Exception e) {
                            com.kwad.sdk.core.e.c.printStackTrace(e);
                            if (z) {
                                aPd = true;
                            }
                        }
                        return aOQ;
                    }
                }
                return aOQ;
            }
        }
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    public static synchronized String cZ(@Nullable Context context) {
        TelephonyManager telephonyManager;
        synchronized (bi.class) {
            if (aPi) {
                return aOR;
            }
            if (TextUtils.isEmpty(aOR) && context != null) {
                if (au.usePhoneStateDisable()) {
                    return aOR;
                }
                if (!o.JL()) {
                    return aOZ;
                }
                boolean z = false;
                try {
                    z = SystemUtil.cU(context);
                    if (z && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null) {
                        if (Build.VERSION.SDK_INT >= 26) {
                            String meid = telephonyManager.getMeid();
                            aOR = meid;
                            if (TextUtils.isEmpty(meid)) {
                                aPi = true;
                            }
                        } else if (telephonyManager.getPhoneType() == 2) {
                            String deviceId = ApiReplaceUtil.getDeviceId(telephonyManager);
                            aOR = deviceId;
                            if (TextUtils.isEmpty(deviceId)) {
                                aPi = true;
                            }
                        } else {
                            aOR = null;
                            aPi = true;
                        }
                    }
                } catch (Exception e) {
                    com.kwad.sdk.core.e.c.printStackTrace(e);
                    if (z) {
                        aPi = true;
                    }
                }
                return aOR;
            }
            return aOR;
        }
    }

    @Nullable
    public static List<String> dh(@NonNull Context context) {
        String[] list;
        if (c.bF(context)) {
            return new ArrayList();
        }
        if (!di(context)) {
            return new ArrayList();
        }
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data");
        if (!file.exists() || !file.isDirectory() || (list = file.list()) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (!TextUtils.isEmpty(str) && !str.startsWith(".")) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public static String gs(String str) {
        String valueOf;
        if (TextUtils.isEmpty(aPm) && !TextUtils.isEmpty(str)) {
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    StructStat stat = Os.stat(str);
                    if (stat == null) {
                        return aPm;
                    }
                    String str2 = "";
                    if (Build.VERSION.SDK_INT >= 27) {
                        if (stat.st_atim == null) {
                            valueOf = "";
                        } else {
                            str2 = String.valueOf(stat.st_atim.tv_sec);
                            valueOf = String.valueOf(stat.st_atim.tv_nsec);
                        }
                        aPm = str2 + "." + valueOf;
                    } else {
                        if (stat.st_atime != 0) {
                            str2 = String.valueOf(stat.st_atime);
                        }
                        aPm = str2;
                    }
                } catch (Exception e) {
                    com.kwad.sdk.core.e.c.printStackTrace(e);
                }
            }
            return aPm;
        }
        return aPm;
    }

    public static int checkSelfPermission(@NonNull Context context, @NonNull String str) {
        return context.checkPermission(str, Process.myPid(), Process.myUid());
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    public static synchronized String[] da(@Nullable Context context) {
        synchronized (bi.class) {
            if (au.usePhoneStateDisable() && au.KI() != null) {
                return au.KI();
            } else if (aPh) {
                return aOW;
            } else if (Build.VERSION.SDK_INT >= 29) {
                return aOW;
            } else {
                boolean z = false;
                if (TextUtils.isEmpty(aOW[0]) && TextUtils.isEmpty(aOW[1]) && context != null) {
                    if (au.usePhoneStateDisable()) {
                        return aOW;
                    } else if (!o.JM()) {
                        return aOW;
                    } else {
                        try {
                            boolean cU = SystemUtil.cU(context);
                            if (cU) {
                                try {
                                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                                    if (telephonyManager != null) {
                                        if (Build.VERSION.SDK_INT >= 26) {
                                            int min = Math.min(db(context), 2);
                                            for (int i = 0; i < min; i++) {
                                                aOW[i] = telephonyManager.getImei(i);
                                            }
                                            if (TextUtils.isEmpty(aOW[0]) && TextUtils.isEmpty(aOW[1])) {
                                                aPh = true;
                                            }
                                        } else if (telephonyManager.getPhoneType() == 1) {
                                            if (Build.VERSION.SDK_INT >= 23) {
                                                int min2 = Math.min(db(context), 2);
                                                for (int i2 = 0; i2 < min2; i2++) {
                                                    aOW[i2] = telephonyManager.getDeviceId(i2);
                                                }
                                            } else {
                                                aOW[0] = ApiReplaceUtil.getDeviceId(telephonyManager);
                                                aOW[1] = null;
                                            }
                                            if (TextUtils.isEmpty(aOW[0]) && TextUtils.isEmpty(aOW[1])) {
                                                aPh = true;
                                            }
                                        } else {
                                            aOW[0] = null;
                                            aOW[1] = null;
                                            aPh = true;
                                        }
                                    }
                                } catch (Exception e) {
                                    e = e;
                                    z = cU;
                                    com.kwad.sdk.core.e.c.printStackTraceOnly(e);
                                    if (z) {
                                        aPh = true;
                                    }
                                    return aOW;
                                }
                            }
                        } catch (Exception e2) {
                            e = e2;
                        }
                        return aOW;
                    }
                }
                return aOW;
            }
        }
    }

    @SuppressLint({"HardwareIds"})
    public static synchronized String dg(@Nullable Context context) {
        synchronized (bi.class) {
            if (TextUtils.isEmpty(aOO) && context != null && !aOP) {
                if (au.KK()) {
                    String KL = au.KL();
                    aOO = KL;
                    return KL;
                } else if (!o.JI()) {
                    return aOO;
                } else {
                    try {
                        WifiInfo connectionInfo = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
                        if (connectionInfo != null) {
                            aOO = ApiReplaceUtil.getMacAddress(connectionInfo);
                        }
                        if (go(aOO)) {
                            Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                NetworkInterface networkInterface = (NetworkInterface) it.next();
                                if (networkInterface != null && "wlan0".equals(networkInterface.getName())) {
                                    byte[] hardwareAddress = ApiReplaceUtil.getHardwareAddress(networkInterface);
                                    if (hardwareAddress != null && hardwareAddress.length != 0) {
                                        StringBuilder sb = new StringBuilder();
                                        int length = hardwareAddress.length;
                                        for (int i = 0; i < length; i++) {
                                            sb.append(String.format("%02X:", Byte.valueOf(hardwareAddress[i])));
                                        }
                                        if (sb.length() > 0) {
                                            sb.deleteCharAt(sb.length() - 1);
                                        }
                                        aOO = sb.toString();
                                    }
                                }
                            }
                        }
                        if (go(aOO)) {
                            aOO = com.kwad.sdk.crash.utils.h.c(Runtime.getRuntime().exec("cat /sys/class/net/wlan0/address ").getInputStream());
                        }
                        if (!go(aOO)) {
                            aOO = aOO.toUpperCase(Locale.US);
                        }
                    } catch (Exception unused) {
                        aOP = true;
                    }
                    aOP = go(aOO);
                    return aOO;
                }
            }
            return aOO;
        }
    }

    public static synchronized int db(Context context) {
        boolean z;
        synchronized (bi.class) {
            if (!aOT && aOS <= 0 && Build.VERSION.SDK_INT >= 23 && context != null && !au.usePhoneStateDisable()) {
                try {
                    aOS = ((TelephonyManager) context.getSystemService("phone")).getPhoneCount();
                } catch (Exception unused) {
                }
                if (aOS == 0) {
                    z = true;
                } else {
                    z = false;
                }
                aOT = z;
                return aOS;
            }
            return aOS;
        }
    }

    @SuppressLint({"MissingPermission"})
    public static int dc(Context context) {
        boolean z;
        if (context != null && aOU <= 0 && !aOV && Build.VERSION.SDK_INT >= 22 && SystemUtil.cU(context) && !au.usePhoneStateDisable()) {
            try {
                aOU = ((SubscriptionManager) context.getSystemService("telephony_subscription_service")).getActiveSubscriptionInfoCount();
            } catch (Throwable unused) {
            }
            if (aOU != 0) {
                z = true;
            } else {
                z = false;
            }
            aOV = z;
            return aOU;
        }
        return aOU;
    }

    public static String u(@Nullable Context context, boolean z) {
        if (au.usePhoneStateDisable() && !TextUtils.isEmpty(au.KH())) {
            return au.KH();
        }
        String cY = cY(context);
        if (!TextUtils.isEmpty(cY)) {
            return cY;
        }
        if (z) {
            return cY;
        }
        if (TextUtils.isEmpty(com.kwad.sdk.core.f.a.bc(context))) {
            return ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).yo();
        }
        return cY;
    }
}
