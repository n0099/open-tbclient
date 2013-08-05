package com.tencent.mm.sdk.platformtools;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.provider.Settings;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
/* loaded from: classes.dex */
public class NetStatusUtil {
    public static final int CMNET = 6;
    public static final int CMWAP = 5;
    public static final int CTNET = 8;
    public static final int CTWAP = 7;
    public static final int LTE = 10;
    public static final int MOBILE = 9;
    public static final int NET_3G = 4;
    public static final int NON_NETWORK = -1;
    public static final int POLICY_NONE = 0;
    public static final int POLICY_REJECT_METERED_BACKGROUND = 1;
    public static final int TBACKGROUND_DATA_LIMITED = 2;
    public static final int TBACKGROUND_NOT_LIMITED = 0;
    public static final int TBACKGROUND_PROCESS_LIMITED = 1;
    public static final int TBACKGROUND_WIFI_LIMITED = 3;
    public static final int UNINET = 1;
    public static final int UNIWAP = 2;
    public static final int WAP_3G = 3;
    public static final int WIFI = 0;

    private static Intent a(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            List<PackageInfo> installedPackages = packageManager.getInstalledPackages(0);
            if (installedPackages != null && installedPackages.size() > 0) {
                Log.e("MicroMsg.NetStatusUtil", "package  size" + installedPackages.size());
                for (int i = 0; i < installedPackages.size(); i++) {
                    try {
                        Log.e("MicroMsg.NetStatusUtil", "package " + installedPackages.get(i).packageName);
                        Intent intent = new Intent();
                        intent.setPackage(installedPackages.get(i).packageName);
                        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 0);
                        int size = queryIntentActivities != null ? queryIntentActivities.size() : 0;
                        if (size > 0) {
                            try {
                                Log.e("MicroMsg.NetStatusUtil", "activityName count " + size);
                                for (int i2 = 0; i2 < size; i2++) {
                                    ActivityInfo activityInfo = queryIntentActivities.get(i2).activityInfo;
                                    if (activityInfo.name.contains(str)) {
                                        Intent intent2 = new Intent("/");
                                        intent2.setComponent(new ComponentName(activityInfo.packageName, activityInfo.name));
                                        intent2.setAction("android.intent.action.VIEW");
                                        context.startActivity(intent2);
                                        return intent2;
                                    }
                                }
                                continue;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } else {
                            continue;
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        return null;
    }

    public static boolean checkFromXml(int i) {
        try {
            runRootCommand();
            NodeList elementsByTagName = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new FileInputStream(new File("/data/system/netpolicy.xml"))).getDocumentElement().getElementsByTagName("uid-policy");
            for (int i2 = 0; i2 < elementsByTagName.getLength(); i2++) {
                Element element = (Element) elementsByTagName.item(i2);
                String attribute = element.getAttribute("uid");
                String attribute2 = element.getAttribute("policy");
                Log.e("MicroMsg.NetStatusUtil", "uid is " + attribute + "  policy is " + attribute2);
                if (attribute.equals(Integer.toString(i))) {
                    if (Integer.parseInt(attribute2) == 1) {
                        return true;
                    }
                    if (Integer.parseInt(attribute2) == 0) {
                        return false;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void dumpNetStatus(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            Log.e("MicroMsg.NetStatusUtil", "isAvailable " + activeNetworkInfo.isAvailable());
            Log.e("MicroMsg.NetStatusUtil", "isConnected " + activeNetworkInfo.isConnected());
            Log.e("MicroMsg.NetStatusUtil", "isRoaming " + activeNetworkInfo.isRoaming());
            Log.e("MicroMsg.NetStatusUtil", "isFailover " + activeNetworkInfo.isFailover());
            Log.e("MicroMsg.NetStatusUtil", "getSubtypeName " + activeNetworkInfo.getSubtypeName());
            Log.e("MicroMsg.NetStatusUtil", "getExtraInfo " + activeNetworkInfo.getExtraInfo());
            Log.e("MicroMsg.NetStatusUtil", "activeNetInfo " + activeNetworkInfo.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int getBackgroundLimitType(Context context) {
        int wifiSleeepPolicy;
        if (Build.VERSION.SDK_INT >= 14) {
            try {
                Class<?> cls = Class.forName("android.app.ActivityManagerNative");
                Object invoke = cls.getMethod("getDefault", new Class[0]).invoke(cls, new Object[0]);
                if (((Integer) invoke.getClass().getMethod("getProcessLimit", new Class[0]).invoke(invoke, new Object[0])).intValue() == 0) {
                    return 1;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            wifiSleeepPolicy = getWifiSleeepPolicy(context);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (wifiSleeepPolicy == 2) {
            return 0;
        }
        if (wifiSleeepPolicy == 1 || wifiSleeepPolicy == 0) {
            return 3;
        }
        return 0;
    }

    public static int getNetType(Context context) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
            if (activeNetworkInfo.getType() == 1) {
                return 0;
            }
            Log.d("MicroMsg.NetStatusUtil", "activeNetInfo.getExtraInfo()  " + activeNetworkInfo.getExtraInfo());
            Log.d("MicroMsg.NetStatusUtil", "activeNetInfo.getType()  " + activeNetworkInfo.getType());
            if (activeNetworkInfo.getExtraInfo() != null) {
                if (activeNetworkInfo.getExtraInfo().equals("uninet")) {
                    return 1;
                }
                if (activeNetworkInfo.getExtraInfo().equals("uniwap")) {
                    return 2;
                }
                if (activeNetworkInfo.getExtraInfo().equals("3gwap")) {
                    return 3;
                }
                if (activeNetworkInfo.getExtraInfo().equals("3gnet")) {
                    return 4;
                }
                if (activeNetworkInfo.getExtraInfo().equals("cmwap")) {
                    return 5;
                }
                if (activeNetworkInfo.getExtraInfo().equals("cmnet")) {
                    return 6;
                }
                if (activeNetworkInfo.getExtraInfo().equals("ctwap")) {
                    return 7;
                }
                if (activeNetworkInfo.getExtraInfo().equals("ctnet")) {
                    return 8;
                }
                if (activeNetworkInfo.getExtraInfo().equals("LTE")) {
                    return 10;
                }
            }
            return 9;
        }
        return -1;
    }

    public static String getNetTypeString(Context context) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
            return "NON_NETWORK";
        }
        if (activeNetworkInfo.getType() == 1) {
            return "WIFI";
        }
        Log.d("MicroMsg.NetStatusUtil", "activeNetInfo.getExtraInfo()  " + activeNetworkInfo.getExtraInfo());
        Log.d("MicroMsg.NetStatusUtil", "activeNetInfo.getType()  " + activeNetworkInfo.getType());
        return activeNetworkInfo.getExtraInfo() != null ? activeNetworkInfo.getExtraInfo() : "MOBILE";
    }

    public static int getWifiSleeepPolicy(Context context) {
        return Settings.System.getInt(context.getContentResolver(), "wifi_sleep_policy", 2);
    }

    public static boolean is2G(int i) {
        return i == 1 || i == 2 || i == 5 || i == 6 || i == 7 || i == 8;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0021, code lost:
        if (r0.getSubtype() == 1) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean is2G(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo.getType() == 1) {
                return false;
            }
            if (activeNetworkInfo.getSubtype() != 2) {
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean is3G(int i) {
        return i == 3 || i == 4;
    }

    public static boolean is3G(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (activeNetworkInfo.getType() == 1) {
            return false;
        }
        if (activeNetworkInfo.getSubtype() >= 5) {
            if (activeNetworkInfo.getSubtype() < 13) {
                return true;
            }
        }
        return false;
    }

    public static boolean is4G(int i) {
        return i == 10;
    }

    public static boolean is4G(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (activeNetworkInfo.getType() == 1) {
            return false;
        }
        if (activeNetworkInfo.getSubtype() >= 13) {
            return true;
        }
        return false;
    }

    public static boolean isConnected(Context context) {
        try {
            return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo().isConnected();
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isImmediatelyDestroyActivities(Context context) {
        return Settings.System.getInt(context.getContentResolver(), "always_finish_activities", 0) != 0;
    }

    public static boolean isLimited(int i) {
        return i == 2 || i == 1 || i == 3;
    }

    public static boolean isMobile(int i) {
        return is3G(i) || is2G(i) || is4G(i);
    }

    public static boolean isMobile(Context context) {
        int netType = getNetType(context);
        return is3G(netType) || is2G(netType) || is4G(netType);
    }

    public static boolean isRestrictBacground(Context context) {
        int intValue;
        int i = context.getApplicationInfo().uid;
        try {
            Class<?> cls = Class.forName("android.net.NetworkPolicyManager");
            Object invoke = cls.getMethod("getSystemService", Context.class).invoke(cls, context);
            Field declaredField = cls.getDeclaredField("mService");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(invoke);
            intValue = ((Integer) obj.getClass().getMethod("getUidPolicy", Integer.TYPE).invoke(obj, Integer.valueOf(i))).intValue();
            Log.e("MicroMsg.NetStatusUtil", "policy is " + intValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (intValue == 1) {
            return true;
        }
        if (intValue == 0) {
            return false;
        }
        return checkFromXml(i);
    }

    public static boolean isWap(int i) {
        return i == 2 || i == 5 || i == 7 || i == 3;
    }

    public static boolean isWap(Context context) {
        return isWap(getNetType(context));
    }

    public static boolean isWifi(int i) {
        return i == 0;
    }

    public static boolean isWifi(Context context) {
        return isWifi(getNetType(context));
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0062 A[Catch: Exception -> 0x0066, TRY_LEAVE, TryCatch #5 {Exception -> 0x0066, blocks: (B:26:0x005d, B:28:0x0062), top: B:46:0x005d }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x005d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean runRootCommand() {
        DataOutputStream dataOutputStream;
        Process process = null;
        try {
            Process exec = Runtime.getRuntime().exec("su");
            try {
                dataOutputStream = new DataOutputStream(exec.getOutputStream());
                try {
                    dataOutputStream.writeBytes("exit\n");
                    dataOutputStream.flush();
                    exec.waitFor();
                    try {
                        dataOutputStream.close();
                        if (exec != null) {
                            exec.destroy();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return true;
                } catch (Exception e2) {
                    e = e2;
                    process = exec;
                    try {
                        Log.d("MicroMsg.NetStatusUtil", "the device is not rooted， error message： " + e.getMessage());
                        if (dataOutputStream != null) {
                            try {
                                dataOutputStream.close();
                            } catch (Exception e3) {
                                e3.printStackTrace();
                                return false;
                            }
                        }
                        if (process != null) {
                            process.destroy();
                        }
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        if (dataOutputStream != null) {
                            try {
                                dataOutputStream.close();
                            } catch (Exception e4) {
                                e4.printStackTrace();
                                throw th;
                            }
                        }
                        if (process != null) {
                            process.destroy();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    process = exec;
                    if (dataOutputStream != null) {
                    }
                    if (process != null) {
                    }
                    throw th;
                }
            } catch (Exception e5) {
                e = e5;
                dataOutputStream = null;
                process = exec;
            } catch (Throwable th3) {
                th = th3;
                dataOutputStream = null;
                process = exec;
            }
        } catch (Exception e6) {
            e = e6;
            dataOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            dataOutputStream = null;
        }
    }

    public static void startSettingItent(Context context, int i) {
        switch (i) {
            case 0:
            default:
                return;
            case 1:
                try {
                    Intent intent = new Intent("/");
                    intent.setComponent(new ComponentName("com.android.settings", "com.android.settings.DevelopmentSettings"));
                    intent.setAction("android.intent.action.VIEW");
                    context.startActivity(intent);
                    return;
                } catch (Exception e) {
                    a(context, "DevelopmentSettings");
                    return;
                }
            case 2:
                try {
                    Intent intent2 = new Intent("/");
                    intent2.setComponent(new ComponentName("com.android.providers.subscribedfeeds", "com.android.settings.ManageAccountsSettings"));
                    intent2.setAction("android.intent.action.VIEW");
                    context.startActivity(intent2);
                    return;
                } catch (Exception e2) {
                    try {
                        Intent intent3 = new Intent("/");
                        intent3.setComponent(new ComponentName("com.htc.settings.accountsync", "com.htc.settings.accountsync.ManageAccountsSettings"));
                        intent3.setAction("android.intent.action.VIEW");
                        context.startActivity(intent3);
                        return;
                    } catch (Exception e3) {
                        a(context, "ManageAccountsSettings");
                        return;
                    }
                }
            case 3:
                try {
                    Intent intent4 = new Intent();
                    intent4.setAction("android.settings.WIFI_IP_SETTINGS");
                    context.startActivity(intent4);
                    return;
                } catch (Exception e4) {
                    a(context, "AdvancedSettings");
                    return;
                }
        }
    }
}
