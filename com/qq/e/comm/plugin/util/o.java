package com.qq.e.comm.plugin.util;

import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.display.DisplayManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.Looper;
import android.os.PowerManager;
import android.os.Process;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.Display;
import android.view.WindowManager;
import android.webkit.WebView;
import com.baidu.searchbox.logsystem.logsys.SnapshotConstant;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.Md5Util;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.List;
/* loaded from: classes3.dex */
public class o {
    private static String c;

    /* renamed from: a  reason: collision with root package name */
    private static String f12886a = "";

    /* renamed from: b  reason: collision with root package name */
    private static String f12887b = "";
    private static String d = "";

    public static Pair<Integer, Integer> a() {
        Display defaultDisplay = ((WindowManager) GDTADManager.getInstance().getAppContext().getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealMetrics(displayMetrics);
        } else {
            defaultDisplay.getMetrics(displayMetrics);
        }
        return new Pair<>(Integer.valueOf(displayMetrics.heightPixels), Integer.valueOf(displayMetrics.widthPixels));
    }

    private static String a(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(i & 255).append(".");
        sb.append((i >> 8) & 255).append(".");
        sb.append((i >> 16) & 255).append(".");
        sb.append((i >> 24) & 255);
        return sb.toString();
    }

    private static String a(String str) throws IOException {
        BufferedReader bufferedReader;
        try {
            StringBuilder sb = new StringBuilder();
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(str), com.qq.e.comm.plugin.f.a.f12289a));
            try {
                String str2 = "";
                for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                    sb.append(str2).append(readLine);
                    str2 = "\n";
                }
                String sb2 = sb.toString();
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                return sb2;
            } catch (Throwable th) {
                th = th;
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
        }
    }

    public static boolean a(Context context) {
        if (Build.VERSION.SDK_INT < 21) {
            try {
                return h(context);
            } catch (SecurityException e) {
                ai.a("no permission : android.permission.GET_TASKS", new Object[0]);
            }
        }
        int myPid = Process.myPid();
        if (new File("/dev/cpuctl/tasks").exists()) {
            try {
                return c(myPid);
            } catch (IOException e2) {
                ai.a("checkForegroundUseCGroup Exception", new Object[0]);
            }
        } else {
            try {
                return b(myPid);
            } catch (IOException e3) {
                ai.a("checkForegroundUseStat Exception", new Object[0]);
            }
        }
        return g(context);
    }

    public static boolean a(Intent intent) {
        if (intent != null) {
            int intExtra = intent.getIntExtra("status", -1);
            return intExtra == 2 || intExtra == 5;
        }
        return false;
    }

    public static String b() {
        if (n()) {
            if (TextUtils.isEmpty(f12886a)) {
                f12886a = com.qq.e.comm.plugin.h.b.IMEI.a().b(GDTADManager.getInstance().getAppContext());
                return f12886a;
            }
            return f12886a;
        }
        return null;
    }

    private static boolean b(int i) throws IOException {
        String a2 = a(String.format("/proc/%d/stat", Integer.valueOf(i)));
        ai.b("gdt_tag_p", "checkForegroundUseStat : stat = %s ", a2);
        if (TextUtils.isEmpty(a2)) {
            throw new IOException("No content");
        }
        String[] split = a2.split("\\s+");
        if (split == null || split.length <= 40) {
            throw new IOException("Invalid format,no match status");
        }
        return Integer.parseInt(split[40]) == 0;
    }

    public static boolean b(Context context) {
        Display[] displayArr;
        if (context != null) {
            if (Build.VERSION.SDK_INT >= 20) {
                DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
                if (displayManager != null) {
                    try {
                        displayArr = displayManager.getDisplays();
                    } catch (Exception e) {
                        displayArr = null;
                    }
                    if (displayArr != null && displayArr.length > 0) {
                        for (Display display : displayArr) {
                            if (display != null && display.getState() == 1) {
                                return true;
                            }
                        }
                    }
                }
            } else {
                PowerManager powerManager = (PowerManager) context.getSystemService("power");
                if (powerManager != null) {
                    return !powerManager.isScreenOn();
                }
            }
        }
        return false;
    }

    public static boolean b(Intent intent) {
        if (intent != null) {
            int intExtra = intent.getIntExtra("plugged", -1);
            return intExtra == 2 || intExtra == 1;
        }
        return false;
    }

    public static String c() {
        if (n()) {
            if (TextUtils.isEmpty(f12887b)) {
                f12887b = com.qq.e.comm.plugin.h.b.IMEI1.a().b(GDTADManager.getInstance().getAppContext());
                return f12887b;
            }
            return f12887b;
        }
        return null;
    }

    private static boolean c(int i) throws IOException {
        String a2 = a(String.format("/proc/%d/cgroup", Integer.valueOf(i)));
        ai.b("gdt_tag_p", "checkForegroundUseCGroup : cgroup = %s ", a2);
        if (TextUtils.isEmpty(a2)) {
            throw new IOException("No content");
        }
        return (a2.contains("bg_non_interactive") || a2.contains("background")) ? false : true;
    }

    public static boolean c(Context context) {
        KeyguardManager keyguardManager;
        if (context == null || (keyguardManager = (KeyguardManager) context.getSystemService("keyguard")) == null) {
            return false;
        }
        return keyguardManager.inKeyguardRestrictedInputMode();
    }

    public static Intent d(Context context) {
        if (context != null) {
            try {
                return context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:21:0x007a */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:26:0x0040 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:27:0x001d */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:29:0x0040 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v8 */
    public static String d() {
        NetworkInfo networkInfo;
        Context appContext;
        ConnectivityManager connectivityManager;
        WifiManager wifiManager;
        WifiInfo connectionInfo;
        try {
            appContext = GDTADManager.getInstance().getAppContext();
            connectivityManager = (ConnectivityManager) appContext.getSystemService("connectivity");
        } catch (Exception e) {
            e = e;
            networkInfo = "0.0.0.0";
        }
        if (connectivityManager != null) {
            NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
            networkInfo = connectivityManager.getNetworkInfo(1);
            try {
                if (networkInfo2 != null && networkInfo2.isConnected()) {
                    String p = p();
                    GDTLogger.d("移动网络ip地址为：" + p);
                    networkInfo = p;
                } else if (networkInfo != 0 && networkInfo.isConnected() && (wifiManager = (WifiManager) appContext.getSystemService("wifi")) != null && (connectionInfo = wifiManager.getConnectionInfo()) != null) {
                    String a2 = a(connectionInfo.getIpAddress());
                    GDTLogger.d("WiFi网络ip地址为：" + a2);
                    networkInfo = a2;
                }
            } catch (Exception e2) {
                e = e2;
                GDTLogger.d("Get ip encounter error: " + e.getMessage());
                return networkInfo;
            }
            return networkInfo;
        }
        networkInfo = "0.0.0.0";
        return networkInfo;
    }

    public static int e(Context context) {
        String f = f(context);
        if (!TextUtils.isEmpty(f)) {
            if (f.equals("46000") || f.equals("46002") || f.equals("46007") || f.equals("46020")) {
                return 1;
            }
            if (f.equals("46001") || f.equals("46006")) {
                return 2;
            }
            if (f.equals("46003") || f.equals("46005")) {
                return 3;
            }
        }
        return 0;
    }

    public static String e() {
        return com.qq.e.comm.plugin.h.b.ANDROIDID.a().b(GDTADManager.getInstance().getAppContext());
    }

    public static String f(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            return telephonyManager != null ? telephonyManager.getNetworkOperator() : "";
        } catch (Exception e) {
            GDTLogger.w("Get operator failed: ", e);
            return "";
        }
    }

    public static boolean f() {
        for (String str : new String[]{"/system/app/Superuser.apk", "/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su", "/su/bin/su"}) {
            if (new File(str).exists()) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x006f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String g() {
        RandomAccessFile randomAccessFile;
        String str = null;
        try {
            try {
                randomAccessFile = new RandomAccessFile(SnapshotConstant.DeviceFilePathConstants.DEVICE_VERSION, "r");
                try {
                    str = randomAccessFile.readLine();
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (FileNotFoundException e2) {
                    e = e2;
                    GDTLogger.d("getProcVersion Exception:" + e.getMessage());
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    return str;
                } catch (IOException e4) {
                    e = e4;
                    GDTLogger.d("getProcVersion Exception:" + e.getMessage());
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    return str;
                }
            } catch (Throwable th) {
                th = th;
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException e7) {
            e = e7;
            randomAccessFile = null;
        } catch (IOException e8) {
            e = e8;
            randomAccessFile = null;
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile = null;
            if (randomAccessFile != null) {
            }
            throw th;
        }
        return str;
    }

    private static boolean g(Context context) {
        if (context != null) {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningAppProcesses();
            if (runningAppProcesses == null || runningAppProcesses.isEmpty()) {
                return false;
            }
            String packageName = context.getPackageName();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.importance == 100 && packageName.equals(runningAppProcessInfo.processName)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static long h() {
        ActivityManager activityManager;
        Context appContext = GDTADManager.getInstance().getAppContext();
        if (appContext == null || (activityManager = (ActivityManager) appContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)) == null) {
            return -1L;
        }
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo.totalMem;
    }

    private static boolean h(Context context) {
        if (context != null) {
            String packageName = context.getPackageName();
            List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningTasks(1);
            if (runningTasks != null) {
                if (runningTasks.isEmpty()) {
                    return false;
                }
                ComponentName componentName = runningTasks.get(0).topActivity;
                return componentName != null && packageName.equals(componentName.getPackageName());
            }
        }
        return false;
    }

    public static long i() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        if (Build.VERSION.SDK_INT >= 18) {
            return statFs.getBlockCountLong() * statFs.getBlockSizeLong();
        }
        return statFs.getBlockCount() * statFs.getBlockSize();
    }

    public static String j() {
        Context appContext;
        if (Looper.myLooper() != Looper.getMainLooper() || (appContext = GDTADManager.getInstance().getAppContext()) == null) {
            return null;
        }
        return new WebView(appContext).getSettings().getUserAgentString();
    }

    public static boolean k() {
        StackTraceElement stackTraceElement;
        StackTraceElement[] stackTrace = Looper.getMainLooper().getThread().getStackTrace();
        return stackTrace != null && stackTrace.length > 0 && (stackTraceElement = stackTrace[stackTrace.length + (-1)]) != null && "de.robv.android.xposed.XposedBridge".equals(stackTraceElement.getClassName());
    }

    public static String l() {
        if (TextUtils.isEmpty(c)) {
            Context appContext = GDTADManager.getInstance().getAppContext();
            if (appContext != null) {
                String a2 = com.qq.e.comm.plugin.h.b.IMEI.a().a(appContext);
                if (!TextUtils.isEmpty(a2)) {
                    c = a2;
                }
            }
            return c;
        }
        return c;
    }

    public static String m() {
        if (n()) {
            if (TextUtils.isEmpty(d)) {
                Context appContext = GDTADManager.getInstance().getAppContext();
                if (appContext.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") != 0) {
                    return null;
                }
                try {
                    TelephonyManager telephonyManager = (TelephonyManager) appContext.getSystemService("phone");
                    String deviceId = telephonyManager != null ? telephonyManager.getDeviceId() : null;
                    if (!TextUtils.isEmpty(deviceId)) {
                        d = Md5Util.encode(deviceId.toLowerCase());
                    }
                } catch (Exception e) {
                }
                return d;
            }
            return d;
        }
        return null;
    }

    public static boolean n() {
        return GDTADManager.getInstance().getSM().getInteger("imeion", 1) == 1;
    }

    public static long o() {
        if ("mounted".equals(Environment.getExternalStorageState()) && Environment.getExternalStorageDirectory() != null && Environment.getExternalStorageDirectory().exists()) {
            try {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                return statFs.getAvailableBlocks() * statFs.getBlockSize();
            } catch (Exception e) {
                e.printStackTrace();
                return 0L;
            }
        }
        return 0L;
    }

    private static String p() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces != null && networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (!nextElement.isLoopbackAddress() && !(nextElement instanceof Inet6Address)) {
                        return nextElement.getHostAddress();
                    }
                }
            }
        } catch (SocketException e) {
            GDTLogger.d("Get mobile ip address encounter error: " + e.toString());
        }
        return "0.0.0.0";
    }
}
