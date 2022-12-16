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
import com.baidu.tbadk.core.util.ApiReplaceUtil;
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
/* loaded from: classes8.dex */
public final class az {
    public static String aoE = null;
    public static String aoF = "";
    public static boolean aoG = false;
    public static String aoH = "";
    public static String aoI = "";
    public static int aoJ;
    public static boolean aoK;
    public static int aoL;
    public static boolean aoM;
    public static String aoR;
    public static String aoS;
    public static int apa;
    public static long apb;
    public static final String[] aoN = {"", ""};
    public static String aoO = "";
    public static String aoP = "";
    public static String aoQ = "";
    public static int aoT = -1;
    public static boolean aoU = false;
    public static boolean aoV = false;
    public static boolean aoW = false;
    public static boolean aoX = false;
    public static boolean aoY = false;
    public static boolean aoZ = false;
    public static String apc = "";
    public static String apd = "";
    public static final List<String> ape = Arrays.asList("a5f5faddde9e9f02", "8e17f7422b35fbea", "b88c3c236923d9d9", "cb36bf76cca443d0", "5d4e49ed381836c5", "cffa38e9136f93e9", "62bd2daa59ea0173", "b7aad49a2d5bc5d9", "f2138912c5e5dd5c", "330a1e81a2bf9f31", "59c0f432ccbef844", "521376155e535f39", "aa5ec6ce14abd680", "5522a09bb500d82f", "6dfe4a96800edfb4", "ecc9a2dded8cdf72", "399f868043955b11", "34dc327c00dbff94", "d1b4e3862c309f8b", "68bdbf71f863ccac", "01558dd995085a35", "351174200a06da52", "fa0988506c76ff4b", "8eb8ef823312c61a", "a72e81be65c4638b", "416d15a015c8f324", "474086ea2d737519", "befdddf908c8d749", "780ee58a6f57aab6", "cfe86fa07cae3601", "704ff4d1534f0ff4", "9298b9e9bbd7cdea", "7b634c42f236c6e8", "11eacf22b9ceab7d", "2941a4f39eec5864", "87d134dc5ba45550", "fdd2313bb1750eb9", "6560ef232d8424bb", "5d876286e1064482", "f66fefb916f4962d", "7baf82d0ac49f596", "57748921d8d88ed4", "120cd57f1a50b8f5", "e164f9610ddd9fc8", "6256f0e8da6389de", "bcb22df712476416", "714fa9aff63f7adb", "cb8252e4da7cf610", "e18f649aa80e140c", "966790a9db5ea8d8", "e1769e681af901dd", "d23f2574a60964a4", "d717e6298d3c9cb2", "f5ea5e8ba730864e", "a8a0a223d1a42232", "6675a4f231f5c8db", "3edb7c2103e5c75a", "8ce6a9a216b326c4", "af606153eb3be0a7", "7ae255c3d760c920", "e50e94c40048c5fd", "55009bca30f9dc4c", "c37566487909214a", "891b74f7e534d14a", "726e190aae663525", "df473127d30fb669", "bfbcc646d92dfd48", "a4a1954c44751936", "da4a44a3d7c4d8be", "5ff5bca4a775dd30", "14917461e1917c53", "14ce20d0a80955fa", "a56a63de4d3f3d39", "f780246adc7bd556", "3495a541aea0da72", "f7f205ce47fed2a5", "f52db3f434279c3a", "dca17088c97dee5e", "dd53a8b3a2a4ccc0", "52e07629290d45e4", "cda522b0f8f50d9a", "b85a1c8bcd51d82c", "e344a00cd3f5e93a", "fa59d8a66d7bdd88", "68fb1f1393a216e8", "4c30ab1fb10af181", "b1376e0578099143", "88752f72d8d305fd", "fddf20078d27bf3c", "dab2120bffa2be8c", "c7c8dde481793471", "e4b1bdbcabfc284d");

    public static long AB() {
        return com.kwad.sdk.crash.utils.g.H(Environment.getDataDirectory());
    }

    public static long AC() {
        if (((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).i(1024L)) {
            return 0L;
        }
        return com.kwad.sdk.crash.utils.g.G(Environment.getDataDirectory());
    }

    public static int AD() {
        int i = apa;
        if (i > 0) {
            return i;
        }
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        apa = availableProcessors;
        return availableProcessors;
    }

    public static String AE() {
        return Build.MODEL;
    }

    public static synchronized long AF() {
        long j;
        synchronized (az.class) {
            j = 0;
            if (aq.zV() && (!TextUtils.isEmpty(aq.zW()) || aq.zX() != null)) {
                j = 1;
            }
            if (aq.zT() && aq.zU() != null) {
                j |= 64;
            }
            if (aq.zV() && !TextUtils.isEmpty(aq.zY())) {
                j |= 2;
            }
            if (aq.zZ() && !TextUtils.isEmpty(aq.Aa())) {
                j |= 4;
            }
            if (aq.Ab() && !TextUtils.isEmpty(aq.Ac())) {
                j |= 2048;
            }
            if (aq.Af()) {
                if (aq.Ag() != null) {
                    j |= 16;
                }
            }
        }
        return j;
    }

    public static String AG() {
        return Build.BRAND;
    }

    public static synchronized long AH() {
        long elapsedRealtime;
        synchronized (az.class) {
            elapsedRealtime = SystemClock.elapsedRealtime() / 1000;
        }
        return elapsedRealtime;
    }

    public static synchronized long AI() {
        long j;
        synchronized (az.class) {
            j = Build.TIME;
        }
        return j;
    }

    public static synchronized String AJ() {
        String str;
        synchronized (az.class) {
            str = Build.FINGERPRINT;
        }
        return str;
    }

    public static synchronized String AK() {
        synchronized (az.class) {
            if (!TextUtils.isEmpty(aoE)) {
                return aoE;
            }
            String radioVersion = Build.getRadioVersion();
            aoE = radioVersion;
            return radioVersion;
        }
    }

    public static synchronized String AL() {
        String name;
        synchronized (az.class) {
            name = ap.getName();
        }
        return name;
    }

    public static synchronized String AM() {
        String version;
        synchronized (az.class) {
            version = ap.getVersion();
        }
        return version;
    }

    public static String AN() {
        return Build.MANUFACTURER;
    }

    public static int AO() {
        if (aoT == -1) {
            aoT = dv(((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).getContext()) ? 4 : 3;
        }
        return aoT;
    }

    public static String AP() {
        if (TextUtils.isEmpty(aoS)) {
            aoS = System.getProperty("os.arch");
        }
        return aoS;
    }

    public static int AQ() {
        return Build.VERSION.SDK_INT;
    }

    public static String AR() {
        if (aq.Ad() || ((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).i(8L)) {
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

    public static String AS() {
        try {
            return a(Long.toHexString(new Random(System.currentTimeMillis()).nextLong()), 16, '0');
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String AT() {
        if (((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).getContext() == null) {
            return null;
        }
        String f = w.f("ksadsdk_pref", HttpRequest.ANDROID_ID, (String) null);
        w.g(f, "ksadsdk_pref", HttpRequest.ANDROID_ID);
        return f;
    }

    public static String AU() {
        if (TextUtils.isEmpty(apc)) {
            try {
                String S = o.S(new File("/proc/sys/kernel/random/boot_id"));
                apc = TextUtils.isEmpty(S) ? "" : S.substring(0, S.indexOf("\n"));
            } catch (IOException unused) {
            }
            return apc;
        }
        return apc;
    }

    public static long Az() {
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

    public static String a(String str, int i, char c) {
        StringBuilder sb = new StringBuilder();
        while (sb.length() + str.length() < 16) {
            sb.append('0');
        }
        sb.append(str);
        return sb.toString();
    }

    public static String br(boolean z) {
        Context context = ((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).getContext();
        String bv = com.kwad.sdk.core.f.a.bv(context);
        return (TextUtils.isEmpty(bv) && !z && TextUtils.isEmpty(m87do(context))) ? ((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).lC() : bv;
    }

    @SuppressLint({"HardwareIds"})
    public static String cJ(Context context) {
        if (!aq.zV() || TextUtils.isEmpty(aq.zY())) {
            if (!TextUtils.isEmpty(aoQ) || context == null) {
                return aoQ;
            }
            if (aoX) {
                return aoQ;
            }
            if (aq.zV() || ((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).i(2L)) {
                return aoQ;
            }
            try {
                String string = ApiReplaceUtil.Overload.getString(context.getContentResolver(), HttpRequest.ANDROID_ID);
                aoQ = string;
                if (!dY(string)) {
                    aoQ = "";
                }
            } catch (Exception unused) {
            }
            if (TextUtils.isEmpty(aoQ)) {
                aoX = true;
            }
            return aoQ;
        }
        return aq.zY();
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    public static synchronized String cN(Context context) {
        synchronized (az.class) {
            if (context != null) {
                if (!aoV && TextUtils.isEmpty(aoO) && SystemUtil.dk(context) && !aq.zV() && !((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).i(128L)) {
                    try {
                        aoO = ApiReplaceUtil.getSubscriberId((TelephonyManager) context.getApplicationContext().getSystemService("phone"));
                    } catch (Exception unused) {
                    }
                    aoV = TextUtils.isEmpty(aoO);
                    return aoO;
                }
            }
            return aoO;
        }
    }

    public static int checkSelfPermission(@NonNull Context context, @NonNull String str) {
        return context.checkPermission(str, Process.myPid(), Process.myUid());
    }

    public static boolean dW(String str) {
        return TextUtils.isEmpty(str) || str.equals(Config.DEF_MAC_ID);
    }

    public static boolean dX(String str) {
        return ape.contains(str.toLowerCase(Locale.US));
    }

    public static boolean dY(String str) {
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

    public static void dZ(String str) {
        if (((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).getContext() == null) {
            return;
        }
        w.a("ksadsdk_pref", HttpRequest.ANDROID_ID, str, true);
    }

    public static long dl(Context context) {
        if (context == null || ((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).i(1024L)) {
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

    public static int dm(Context context) {
        if (((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).i(512L)) {
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

    public static long dn(Context context) {
        long j = apb;
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
                j2 = Az();
            }
            apb = j2;
            return j2;
        } catch (Exception unused) {
            return 0L;
        }
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    /* renamed from: do  reason: not valid java name */
    public static synchronized String m87do(@Nullable Context context) {
        synchronized (az.class) {
            if (aq.zV() && !TextUtils.isEmpty(aq.zW())) {
                return aq.zW();
            } else if (aoU) {
                return aoH;
            } else {
                if (TextUtils.isEmpty(aoH) && context != null) {
                    if (Build.VERSION.SDK_INT >= 29) {
                        return aoH;
                    } else if (aq.zV() || ((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).i(1L)) {
                        return aoH;
                    } else {
                        boolean z = false;
                        try {
                            z = SystemUtil.dk(context);
                            if (z) {
                                String deviceId = ApiReplaceUtil.getDeviceId((TelephonyManager) context.getSystemService("phone"));
                                aoH = deviceId;
                                if (TextUtils.isEmpty(deviceId)) {
                                    aoU = true;
                                }
                            }
                        } catch (Exception e) {
                            com.kwad.sdk.core.e.b.printStackTrace(e);
                            if (z) {
                                aoU = true;
                            }
                        }
                        return aoH;
                    }
                }
                return aoH;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x004f, code lost:
        if (android.text.TextUtils.isEmpty(r5) != false) goto L28;
     */
    @SuppressLint({"HardwareIds", "MissingPermission"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized String dp(@Nullable Context context) {
        TelephonyManager telephonyManager;
        synchronized (az.class) {
            if (aoZ) {
                return aoI;
            }
            if (TextUtils.isEmpty(aoI) && context != null) {
                if (aq.zV() || ((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).i(4096L)) {
                    return aoI;
                }
                boolean z = false;
                try {
                    z = SystemUtil.dk(context);
                    if (z && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null) {
                        if (Build.VERSION.SDK_INT >= 26) {
                            String meid = telephonyManager.getMeid();
                            aoI = meid;
                        } else if (telephonyManager.getPhoneType() == 2) {
                            String deviceId = ApiReplaceUtil.getDeviceId(telephonyManager);
                            aoI = deviceId;
                            if (TextUtils.isEmpty(deviceId)) {
                            }
                        } else {
                            aoI = null;
                        }
                        aoZ = true;
                    }
                } catch (Exception e) {
                    com.kwad.sdk.core.e.b.printStackTrace(e);
                    if (z) {
                        aoZ = true;
                    }
                }
                return aoI;
            }
            return aoI;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x0098, code lost:
        if (android.text.TextUtils.isEmpty(com.kwad.sdk.utils.az.aoN[1]) != false) goto L51;
     */
    @SuppressLint({"HardwareIds", "MissingPermission"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized String[] dq(@Nullable Context context) {
        synchronized (az.class) {
            if (aq.zV() && aq.zX() != null) {
                return aq.zX();
            } else if (aoY) {
                return aoN;
            } else if (Build.VERSION.SDK_INT >= 29) {
                return aoN;
            } else {
                boolean z = false;
                if (TextUtils.isEmpty(aoN[0]) && TextUtils.isEmpty(aoN[1]) && context != null) {
                    if (aq.zV() || ((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).i(1L)) {
                        return aoN;
                    }
                    try {
                        boolean dk = SystemUtil.dk(context);
                        if (dk) {
                            try {
                                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                                if (telephonyManager != null) {
                                    if (Build.VERSION.SDK_INT >= 26) {
                                        int min = Math.min(dr(context), 2);
                                        for (int i = 0; i < min; i++) {
                                            aoN[i] = telephonyManager.getImei(i);
                                        }
                                        if (TextUtils.isEmpty(aoN[0])) {
                                        }
                                    } else {
                                        if (telephonyManager.getPhoneType() == 1) {
                                            if (Build.VERSION.SDK_INT >= 23) {
                                                int min2 = Math.min(dr(context), 2);
                                                for (int i2 = 0; i2 < min2; i2++) {
                                                    aoN[i2] = telephonyManager.getDeviceId(i2);
                                                }
                                            } else {
                                                aoN[0] = ApiReplaceUtil.getDeviceId(telephonyManager);
                                                aoN[1] = null;
                                            }
                                            if (TextUtils.isEmpty(aoN[0]) && TextUtils.isEmpty(aoN[1])) {
                                            }
                                        } else {
                                            aoN[0] = null;
                                            aoN[1] = null;
                                        }
                                        aoY = true;
                                    }
                                }
                            } catch (Exception e) {
                                e = e;
                                z = dk;
                                com.kwad.sdk.core.e.b.printStackTraceOnly(e);
                                if (z) {
                                    aoY = true;
                                }
                                return aoN;
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                    }
                    return aoN;
                }
                return aoN;
            }
        }
    }

    public static synchronized int dr(Context context) {
        synchronized (az.class) {
            if (aoK || aoJ > 0 || Build.VERSION.SDK_INT < 23 || context == null || aq.zV()) {
                return aoJ;
            }
            try {
                aoJ = ((TelephonyManager) context.getSystemService("phone")).getPhoneCount();
            } catch (Exception unused) {
            }
            aoK = aoJ == 0;
            return aoJ;
        }
    }

    @SuppressLint({"MissingPermission"})
    public static int ds(Context context) {
        if (context == null || aoL > 0 || aoM || Build.VERSION.SDK_INT < 22 || !SystemUtil.dk(context) || aq.zV()) {
            return aoL;
        }
        try {
            aoL = ((SubscriptionManager) context.getSystemService("telephony_subscription_service")).getActiveSubscriptionInfoCount();
        } catch (Throwable unused) {
        }
        aoM = aoL != 0;
        return aoL;
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    public static String dt(Context context) {
        if (!TextUtils.isEmpty(aoP) || context == null) {
            return aoP;
        }
        if (aoW) {
            return aoP;
        }
        if (aq.zV() || ((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).i(128L)) {
            return aoP;
        }
        boolean z = false;
        try {
            z = SystemUtil.dk(context);
            if (z) {
                aoP = ApiReplaceUtil.getSimSerialNumber((TelephonyManager) context.getApplicationContext().getSystemService("phone"));
            }
        } catch (Exception e) {
            com.kwad.sdk.core.e.b.printStackTrace(e);
            aoP = null;
        }
        if (z && TextUtils.isEmpty(aoP)) {
            aoW = true;
        }
        String str = TextUtils.isEmpty(aoP) ? "" : aoP;
        aoP = str;
        return str;
    }

    public static synchronized int du(Context context) {
        int ringerMode;
        synchronized (az.class) {
            ringerMode = ((AudioManager) context.getSystemService("audio")).getRingerMode();
        }
        return ringerMode;
    }

    public static boolean dv(Context context) {
        return (context == null || context.getResources() == null || context.getResources().getConfiguration() == null || (context.getResources().getConfiguration().screenLayout & 15) < 3) ? false : true;
    }

    @SuppressLint({"HardwareIds"})
    public static synchronized String dw(@Nullable Context context) {
        synchronized (az.class) {
            if (TextUtils.isEmpty(aoF) && context != null && !aoG) {
                if (aq.zZ()) {
                    String Aa = aq.Aa();
                    aoF = Aa;
                    return Aa;
                } else if (((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).i(4L)) {
                    return aoF;
                } else {
                    try {
                        WifiInfo connectionInfo = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
                        if (connectionInfo != null) {
                            aoF = ApiReplaceUtil.getMacAddress(connectionInfo);
                        }
                        if (dW(aoF)) {
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
                                        aoF = sb.toString();
                                    }
                                }
                            }
                        }
                        if (dW(aoF)) {
                            aoF = com.kwad.sdk.crash.utils.g.d(Runtime.getRuntime().exec("cat /sys/class/net/wlan0/address ").getInputStream());
                        }
                        if (!dW(aoF)) {
                            aoF = aoF.toUpperCase(Locale.US);
                        }
                    } catch (Exception unused) {
                        aoG = true;
                    }
                    aoG = dW(aoF);
                    return aoF;
                }
            }
            return aoF;
        }
    }

    @Nullable
    public static List<String> dx(@NonNull Context context) {
        String[] list;
        if (!c.bQ(context) && dy(context)) {
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

    public static boolean dy(@NonNull Context context) {
        return context.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    public static String ea(String str) {
        String valueOf;
        if (!TextUtils.isEmpty(apd) || TextUtils.isEmpty(str)) {
            return apd;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                StructStat stat = Os.stat(str);
                if (stat == null) {
                    return apd;
                }
                String str2 = "";
                if (Build.VERSION.SDK_INT >= 27) {
                    if (stat.st_atim == null) {
                        valueOf = "";
                    } else {
                        str2 = String.valueOf(stat.st_atim.tv_sec);
                        valueOf = String.valueOf(stat.st_atim.tv_nsec);
                    }
                    apd = str2 + "." + valueOf;
                } else {
                    if (stat.st_atime != 0) {
                        str2 = String.valueOf(stat.st_atime);
                    }
                    apd = str2;
                }
            } catch (Exception e) {
                com.kwad.sdk.core.e.b.printStackTrace(e);
            }
        }
        return apd;
    }

    public static String getDeviceId() {
        try {
        } catch (Exception e) {
            com.kwad.sdk.core.e.b.printStackTraceOnly(e);
        }
        if (TextUtils.isEmpty(aoR)) {
            String AT = AT();
            if (!TextUtils.isEmpty(AT)) {
                String str = "ANDROID_" + AT;
                aoR = str;
                return str;
            }
            String cJ = cJ(((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).getContext());
            if (!TextUtils.isEmpty(cJ) && !dX(cJ) && dY(cJ)) {
                String str2 = "ANDROID_" + cJ;
                aoR = str2;
                return str2;
            }
            String AS = AS();
            if (!TextUtils.isEmpty(AS)) {
                aoR = "ANDROID_" + AS;
                dZ(AS);
                return aoR;
            }
            return "ANDROID_";
        }
        return aoR;
    }

    public static String getLanguage() {
        return Locale.getDefault().getLanguage();
    }

    public static String getLocale() {
        Locale locale = Build.VERSION.SDK_INT >= 24 ? LocaleList.getDefault().get(0) : Locale.getDefault();
        if (locale == null) {
            locale = Locale.CHINESE;
        }
        return String.valueOf(locale);
    }

    public static String getOsVersion() {
        return Build.VERSION.RELEASE;
    }

    public static int getScreenHeight(Context context) {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.heightPixels;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static int getScreenWidth(Context context) {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.widthPixels;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static String u(@Nullable Context context, boolean z) {
        if (!aq.zV() || TextUtils.isEmpty(aq.zW())) {
            String m87do = m87do(context);
            return (TextUtils.isEmpty(m87do) && !z && TextUtils.isEmpty(com.kwad.sdk.core.f.a.bv(context))) ? ((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).lB() : m87do;
        }
        return aq.zW();
    }
}
