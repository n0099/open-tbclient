package com.meizu.cloud.pushsdk.util;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.android.util.devices.RomUtils;
import com.meizu.cloud.pushsdk.base.j;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
/* loaded from: classes16.dex */
public class MzSystemUtils {
    private static final String TAG = "MzSystemUtils";

    public static boolean compareVersion(String str, String str2) {
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        int min = Math.min(split.length, split2.length);
        int i = 0;
        for (int i2 = 0; i2 < min; i2++) {
            i = split[i2].length() - split2[i2].length();
            if (i != 0 || (i = split[i2].compareTo(split2[i2])) != 0) {
                break;
            }
        }
        if (i == 0) {
            i = split.length - split2.length;
        }
        return i >= 0;
    }

    public static boolean compatApi(int i) {
        return Build.VERSION.SDK_INT >= i;
    }

    public static String findReceiver(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        Intent intent = new Intent(str);
        intent.setPackage(str2);
        List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 0);
        if (queryBroadcastReceivers == null || queryBroadcastReceivers.size() <= 0) {
            return null;
        }
        return queryBroadcastReceivers.get(0).activityInfo.name;
    }

    public static int getAppVersionCode(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Exception e) {
            return 0;
        }
    }

    public static String getAppVersionName(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception e) {
            return "";
        }
    }

    public static String getAppVersionName(Context context, String str) {
        try {
            String str2 = context.getPackageManager().getPackageInfo(str, 0).versionName;
            if (str2 != null) {
                if (str2.length() > 0) {
                    return str2;
                }
            }
            return "";
        } catch (Exception e) {
            com.meizu.cloud.a.a.e("VersionInfo", "Exception message " + e.getMessage());
            return "";
        }
    }

    public static String getBSSID(Context context) {
        try {
            return (String) Class.forName("com.meizu.cloud.pushsdk.util.AllergySystemUtils").getDeclaredMethod("getBSSID", Context.class).invoke(null, context);
        } catch (Exception e) {
            com.meizu.cloud.a.a.e(TAG, "getBSSID error " + e.getMessage());
            return null;
        }
    }

    public static String getCurrentLanguage() {
        try {
            return Locale.getDefault().getLanguage();
        } catch (Exception e) {
            com.meizu.cloud.a.a.e(TAG, "getCurrentLanguage error " + e.getMessage());
            return null;
        }
    }

    public static String getDeviceId(Context context) {
        try {
            return com.meizu.cloud.pushsdk.base.c.a(context);
        } catch (Exception e) {
            com.meizu.cloud.a.a.e(TAG, "getDeviceId error " + e.getMessage());
            return null;
        }
    }

    public static List<String> getInstalledPackage(Context context) {
        ArrayList arrayList = new ArrayList();
        try {
            return (List) Class.forName("com.meizu.cloud.pushsdk.util.AllergySystemUtils").getDeclaredMethod("getInstalledPackage", Context.class).invoke(null, context);
        } catch (Exception e) {
            com.meizu.cloud.a.a.e(TAG, "getInstalledPackage error " + e.getMessage());
            return arrayList;
        }
    }

    public static String getLineNumber(Context context) {
        try {
            return (String) Class.forName("com.meizu.cloud.pushsdk.util.AllergySystemUtils").getDeclaredMethod("getLineNumber", Context.class).invoke(null, context);
        } catch (Exception e) {
            com.meizu.cloud.a.a.e(TAG, "getLineNumber error " + e.getMessage());
            return null;
        }
    }

    public static String getMzPushServicePackageName(Context context) {
        String packageName = context.getPackageName();
        try {
            String servicesByPackageName = getServicesByPackageName(context, "com.meizu.cloud");
            if (!TextUtils.isEmpty(servicesByPackageName)) {
                if (servicesByPackageName.contains("mzservice_v1")) {
                    return "com.meizu.cloud";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.meizu.cloud.a.a.i("SystemUtils", "startservice package name " + packageName);
        return packageName;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static String getNetWorkType(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                switch (activeNetworkInfo.getType()) {
                    case 0:
                        switch (activeNetworkInfo.getSubtype()) {
                        }
                    case 1:
                        return "WIFI";
                    case 7:
                        return "BLUETOOTH";
                    case 9:
                        return "ETHERNET";
                }
                return "OTHER";
            }
            return "";
        } catch (Exception e) {
            com.meizu.cloud.a.a.e(TAG, "Security exception checking connection: " + e.getMessage());
            return "";
        }
    }

    public static String getOperator(Context context) {
        try {
            return (String) Class.forName("com.meizu.cloud.pushsdk.util.AllergySystemUtils").getDeclaredMethod("getOperator", Context.class).invoke(null, context);
        } catch (Exception e) {
            com.meizu.cloud.a.a.e(TAG, "getOperator error " + e.getMessage());
            return null;
        }
    }

    public static String getProcessName(Context context) {
        try {
            int myPid = Process.myPid();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getApplicationContext().getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningAppProcesses()) {
                com.meizu.cloud.a.a.i(TAG, "processName " + runningAppProcessInfo.processName);
                if (runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.processName;
                }
            }
            return "";
        } catch (Exception e) {
            com.meizu.cloud.a.a.e(TAG, "getProcessName error " + e.getMessage());
            return null;
        }
    }

    private static String getServicesByPackageName(Context context, String str) {
        ServiceInfo[] serviceInfoArr;
        try {
            serviceInfoArr = context.getPackageManager().getPackageInfo(str, 4).services;
        } catch (Exception e) {
            serviceInfoArr = null;
        }
        if (serviceInfoArr == null) {
            return null;
        }
        for (int i = 0; i < serviceInfoArr.length; i++) {
            if ("com.meizu.cloud.pushsdk.pushservice.MzPushService".equals(serviceInfoArr[i].name)) {
                return serviceInfoArr[i].processName;
            }
        }
        return null;
    }

    public static int getSubId(Context context, int i) {
        try {
            return ((Integer) Class.forName("com.meizu.cloud.pushsdk.util.AllergySystemUtils").getDeclaredMethod("getSubId", Context.class, Integer.TYPE).invoke(null, context, Integer.valueOf(i))).intValue();
        } catch (Exception e) {
            com.meizu.cloud.a.a.e(TAG, "getSubId error " + e.getMessage());
            return -1;
        }
    }

    public static String getSubscriberId(Context context, int i) {
        try {
            return (String) Class.forName("com.meizu.cloud.pushsdk.util.AllergySystemUtils").getDeclaredMethod("getSubscriberId", Context.class, Integer.TYPE).invoke(null, context, Integer.valueOf(i));
        } catch (Exception e) {
            com.meizu.cloud.a.a.e(TAG, "getSubscriberId error " + e.getMessage());
            return null;
        }
    }

    public static List<String> getWifiList(Context context) {
        ArrayList arrayList = new ArrayList();
        try {
            return (List) Class.forName("com.meizu.cloud.pushsdk.util.AllergySystemUtils").getDeclaredMethod("getWifiList", Context.class).invoke(null, context);
        } catch (Exception e) {
            com.meizu.cloud.a.a.e(TAG, "getWifiList error " + e.getMessage());
            return arrayList;
        }
    }

    public static boolean isApplicationDebug(Context context) {
        try {
            return (context.getApplicationInfo().flags & 2) != 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isBrandMeizu(Context context) {
        boolean z = !TextUtils.isEmpty(j.a("ro.meizu.product.model")) || RomUtils.MANUFACTURER_MEIZU.equalsIgnoreCase(Build.BRAND) || "22c4185e".equalsIgnoreCase(Build.BRAND);
        if (!z) {
            com.meizu.cloud.pushsdk.a.a.b(context.getApplicationContext());
        }
        return z;
    }

    public static boolean isHuaWei() {
        String a2 = j.a("ro.build.version.emui");
        com.meizu.cloud.a.a.e(TAG, "huawei eui " + a2);
        return !TextUtils.isEmpty(a2);
    }

    public static boolean isIndiaLocal() {
        return "india".equals(j.a("ro.meizu.locale.region"));
    }

    public static boolean isInternational() {
        if (com.meizu.cloud.pushsdk.base.a.a().f4137a) {
            return com.meizu.cloud.pushsdk.base.a.a().b.booleanValue();
        }
        return false;
    }

    public static boolean isMeizu(Context context) {
        return isBrandMeizu(context);
    }

    public static boolean isPackageInstalled(Context context, String str) {
        try {
            context.getPackageManager().getPackageInfo(str, 0);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isRunningProcess(Context context, String str) {
        try {
            Iterator<ActivityManager.RunningAppProcessInfo> it = ((ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningAppProcesses().iterator();
            boolean z = false;
            while (it.hasNext() && !(z = it.next().processName.contains(str))) {
            }
            com.meizu.cloud.a.a.i(TAG, str + " is running " + z);
            return z;
        } catch (Exception e) {
            com.meizu.cloud.a.a.e(TAG, "can not get running process info so set running true");
            return true;
        }
    }

    public static boolean isXiaoMi() {
        return "Xiaomi".equals(Build.MODEL) || "Xiaomi".equals(Build.MANUFACTURER);
    }

    public static void sendMessageFromBroadcast(Context context, Intent intent, String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            intent.setAction(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            intent.setPackage(str2);
        }
        String findReceiver = findReceiver(context, str, str2);
        if (!TextUtils.isEmpty(findReceiver)) {
            intent.setClassName(str2, findReceiver);
        }
        context.sendBroadcast(intent);
    }
}
