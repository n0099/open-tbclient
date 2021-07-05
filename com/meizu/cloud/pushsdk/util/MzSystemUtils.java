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
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import com.meizu.cloud.pushsdk.base.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
/* loaded from: classes7.dex */
public class MzSystemUtils {
    public static final String TAG = "MzSystemUtils";

    public static boolean compareVersion(String str, String str2) {
        String[] split = str.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
        String[] split2 = str2.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
        int min = Math.min(split.length, split2.length);
        int i2 = 0;
        for (int i3 = 0; i3 < min; i3++) {
            i2 = split[i3].length() - split2[i3].length();
            if (i2 != 0 || (i2 = split[i3].compareTo(split2[i3])) != 0) {
                break;
            }
        }
        if (i2 == 0) {
            i2 = split.length - split2.length;
        }
        return i2 >= 0;
    }

    public static boolean compatApi(int i2) {
        return Build.VERSION.SDK_INT >= i2;
    }

    public static String findReceiver(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            Intent intent = new Intent(str);
            intent.setPackage(str2);
            List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 0);
            if (queryBroadcastReceivers != null && queryBroadcastReceivers.size() > 0) {
                return queryBroadcastReceivers.get(0).activityInfo.name;
            }
        }
        return null;
    }

    public static int getAppVersionCode(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static String getAppVersionName(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception unused) {
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
        } catch (Exception e2) {
            d.h.a.a.a.b("VersionInfo", "Exception message " + e2.getMessage());
            return "";
        }
    }

    public static String getBSSID(Context context) {
        try {
            return (String) Class.forName("com.meizu.cloud.pushsdk.util.AllergySystemUtils").getDeclaredMethod("getBSSID", Context.class).invoke(null, context);
        } catch (Exception e2) {
            d.h.a.a.a.b(TAG, "getBSSID error " + e2.getMessage());
            return null;
        }
    }

    public static String getCurrentLanguage() {
        try {
            return Locale.getDefault().getLanguage();
        } catch (Exception e2) {
            d.h.a.a.a.b(TAG, "getCurrentLanguage error " + e2.getMessage());
            return null;
        }
    }

    public static String getDeviceId(Context context) {
        try {
            return com.meizu.cloud.pushsdk.base.c.a(context);
        } catch (Exception e2) {
            d.h.a.a.a.b(TAG, "getDeviceId error " + e2.getMessage());
            return null;
        }
    }

    public static List<String> getInstalledPackage(Context context) {
        ArrayList arrayList = new ArrayList();
        try {
            return (List) Class.forName("com.meizu.cloud.pushsdk.util.AllergySystemUtils").getDeclaredMethod("getInstalledPackage", Context.class).invoke(null, context);
        } catch (Exception e2) {
            d.h.a.a.a.b(TAG, "getInstalledPackage error " + e2.getMessage());
            return arrayList;
        }
    }

    public static String getLineNumber(Context context) {
        try {
            return (String) Class.forName("com.meizu.cloud.pushsdk.util.AllergySystemUtils").getDeclaredMethod("getLineNumber", Context.class).invoke(null, context);
        } catch (Exception e2) {
            d.h.a.a.a.b(TAG, "getLineNumber error " + e2.getMessage());
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
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        d.h.a.a.a.d("SystemUtils", "startservice package name " + packageName);
        return packageName;
    }

    public static String getNetWorkType(Context context) {
        String str;
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                int type = activeNetworkInfo.getType();
                if (type == 0) {
                    switch (activeNetworkInfo.getSubtype()) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                            str = "MOBILE_2G";
                            break;
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                            str = "MOBILE_3G";
                            break;
                        case 13:
                            str = "MOBILE_4G";
                            break;
                        default:
                            str = "MOBILE_XG";
                            break;
                    }
                } else if (type == 1) {
                    return CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING;
                } else {
                    if (type == 7) {
                        return "BLUETOOTH";
                    }
                    if (type == 9) {
                        return "ETHERNET";
                    }
                }
                return "OTHER";
            }
            return "";
        } catch (Exception e2) {
            d.h.a.a.a.b(TAG, "Security exception checking connection: " + e2.getMessage());
            return "";
        }
    }

    public static String getOperator(Context context) {
        try {
            return (String) Class.forName("com.meizu.cloud.pushsdk.util.AllergySystemUtils").getDeclaredMethod("getOperator", Context.class).invoke(null, context);
        } catch (Exception e2) {
            d.h.a.a.a.b(TAG, "getOperator error " + e2.getMessage());
            return null;
        }
    }

    public static String getProcessName(Context context) {
        try {
            int myPid = Process.myPid();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getApplicationContext().getSystemService("activity")).getRunningAppProcesses()) {
                d.h.a.a.a.d(TAG, "processName " + runningAppProcessInfo.processName);
                if (runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.processName;
                }
            }
            return "";
        } catch (Exception e2) {
            d.h.a.a.a.b(TAG, "getProcessName error " + e2.getMessage());
            return null;
        }
    }

    public static String getServicesByPackageName(Context context, String str) {
        ServiceInfo[] serviceInfoArr;
        try {
            serviceInfoArr = context.getPackageManager().getPackageInfo(str, 4).services;
        } catch (Exception unused) {
            serviceInfoArr = null;
        }
        if (serviceInfoArr == null) {
            return null;
        }
        for (int i2 = 0; i2 < serviceInfoArr.length; i2++) {
            if ("com.meizu.cloud.pushsdk.pushservice.MzPushService".equals(serviceInfoArr[i2].name)) {
                return serviceInfoArr[i2].processName;
            }
        }
        return null;
    }

    public static int getSubId(Context context, int i2) {
        try {
            return ((Integer) Class.forName("com.meizu.cloud.pushsdk.util.AllergySystemUtils").getDeclaredMethod("getSubId", Context.class, Integer.TYPE).invoke(null, context, Integer.valueOf(i2))).intValue();
        } catch (Exception e2) {
            d.h.a.a.a.b(TAG, "getSubId error " + e2.getMessage());
            return -1;
        }
    }

    public static String getSubscriberId(Context context, int i2) {
        try {
            return (String) Class.forName("com.meizu.cloud.pushsdk.util.AllergySystemUtils").getDeclaredMethod("getSubscriberId", Context.class, Integer.TYPE).invoke(null, context, Integer.valueOf(i2));
        } catch (Exception e2) {
            d.h.a.a.a.b(TAG, "getSubscriberId error " + e2.getMessage());
            return null;
        }
    }

    public static List<String> getWifiList(Context context) {
        ArrayList arrayList = new ArrayList();
        try {
            return (List) Class.forName("com.meizu.cloud.pushsdk.util.AllergySystemUtils").getDeclaredMethod("getWifiList", Context.class).invoke(null, context);
        } catch (Exception e2) {
            d.h.a.a.a.b(TAG, "getWifiList error " + e2.getMessage());
            return arrayList;
        }
    }

    public static boolean isApplicationDebug(Context context) {
        try {
            return (context.getApplicationInfo().flags & 2) != 0;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean isBrandMeizu(Context context) {
        boolean z = !TextUtils.isEmpty(j.a("ro.meizu.product.model")) || "meizu".equalsIgnoreCase(Build.BRAND) || "22c4185e".equalsIgnoreCase(Build.BRAND);
        if (!z) {
            com.meizu.cloud.pushsdk.a.a.b(context.getApplicationContext());
        }
        return z;
    }

    public static boolean isHuaWei() {
        String a2 = j.a("ro.build.version.emui");
        d.h.a.a.a.b(TAG, "huawei eui " + a2);
        return !TextUtils.isEmpty(a2);
    }

    public static boolean isIndiaLocal() {
        return "india".equals(j.a("ro.meizu.locale.region"));
    }

    public static boolean isInternational() {
        if (com.meizu.cloud.pushsdk.base.a.a().f40284a) {
            return com.meizu.cloud.pushsdk.base.a.a().f40285b.booleanValue();
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
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isRunningProcess(Context context, String str) {
        try {
            Iterator<ActivityManager.RunningAppProcessInfo> it = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses().iterator();
            boolean z = false;
            while (it.hasNext() && !(z = it.next().processName.contains(str))) {
            }
            d.h.a.a.a.d(TAG, str + " is running " + z);
            return z;
        } catch (Exception unused) {
            d.h.a.a.a.b(TAG, "can not get running process info so set running true");
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
