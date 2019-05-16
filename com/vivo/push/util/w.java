package com.vivo.push.util;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.sapi2.SapiContext;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.security.PublicKey;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes3.dex */
public final class w {
    private static Boolean c;
    private static String[] a = {"com.vivo.push.sdk.RegistrationReceiver", "com.vivo.push.sdk.service.PushService", "com.vivo.push.sdk.service.CommonJobService"};
    private static String[] b = {"android.permission.INTERNET", "android.permission.READ_PHONE_STATE", "android.permission.ACCESS_NETWORK_STATE", "android.permission.WRITE_SETTINGS", "android.permission.VIBRATE", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.ACCESS_WIFI_STATE", "android.permission.WAKE_LOCK", "android.permission.GET_ACCOUNTS", "com.bbk.account.permission.READ_ACCOUNTINFO", "android.permission.AUTHENTICATE_ACCOUNTS", "android.permission.MOUNT_UNMOUNT_FILESYSTEMS", "android.permission.GET_TASKS"};
    private static String[] d = {"com.vivo.push.sdk.service.CommandService", "com.vivo.push.sdk.service.CommonJobService"};
    private static String[] e = {"com.vivo.push.sdk.RegistrationReceiver"};
    private static String[] f = {"com.vivo.push.sdk.service.LinkProxyActivity"};

    /* JADX WARN: Removed duplicated region for block: B:22:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0073  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(Context context) {
        String str;
        if (c != null) {
            return c.booleanValue();
        }
        String b2 = p.b(context);
        if (context != null && context.getPackageName().equals(b2)) {
            Boolean bool = true;
            c = bool;
            return bool.booleanValue();
        } else if (context == null) {
            m.d("Utility", "isPushProcess context is null");
            return false;
        } else {
            int myPid = Process.myPid();
            ActivityManager activityManager = (ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME);
            if (activityManager != null) {
                List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
                if (runningAppProcesses != null && runningAppProcesses.size() != 0) {
                    for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                        if (runningAppProcessInfo.pid == myPid) {
                            str = runningAppProcessInfo.processName;
                            break;
                        }
                    }
                } else {
                    str = null;
                }
                if (TextUtils.isEmpty(str)) {
                    Boolean valueOf = Boolean.valueOf(str.contains(":pushservice"));
                    c = valueOf;
                    return valueOf.booleanValue();
                }
                return false;
            }
            str = null;
            if (TextUtils.isEmpty(str)) {
            }
        }
    }

    public static long b(Context context) {
        String b2 = p.b(context);
        if (TextUtils.isEmpty(b2)) {
            m.a("Utility", "systemPushPkgName is null");
            return -1L;
        }
        return a(context, b2);
    }

    public static long a(Context context, String str) {
        Object a2 = a(context, str, "com.vivo.push.sdk_version");
        if (a2 == null) {
            a2 = a(context, str, SapiContext.KEY_SDK_VERSION);
        }
        if (a2 != null) {
            try {
                return Long.parseLong(a2.toString());
            } catch (Exception e2) {
                e2.printStackTrace();
                m.a("Utility", "getSdkVersionCode error ", e2);
                return -1L;
            }
        }
        m.a("Utility", "getSdkVersionCode sdk version is null");
        return -1L;
    }

    private static Object a(Context context, String str, String str2) {
        if (context == null) {
            return null;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 128);
            Bundle bundle = applicationInfo != null ? applicationInfo.metaData : null;
            if (bundle != null) {
                return bundle.get(str2);
            }
            return null;
        } catch (PackageManager.NameNotFoundException e2) {
            return null;
        }
    }

    public static Object a(String str, String str2) throws Exception {
        Class<?> cls = Class.forName(str);
        return cls.getField(str2).get(cls);
    }

    public static void c(Context context) throws VivoPushException {
        String str;
        String str2;
        m.d("Utility", "check PushService AndroidManifest declearation !");
        String b2 = p.b(context);
        boolean c2 = p.c(context, context.getPackageName());
        boolean d2 = p.d(context, context.getPackageName());
        boolean b3 = p.b(context, context.getPackageName());
        if (d2) {
            a = new String[]{"com.vivo.push.sdk.RegistrationReceiver", "com.vivo.push.sdk.service.PushService", "com.vivo.push.sdk.service.CommonJobService"};
            b = new String[]{"android.permission.INTERNET", "android.permission.READ_PHONE_STATE", "android.permission.ACCESS_NETWORK_STATE", "android.permission.WRITE_SETTINGS", "android.permission.VIBRATE", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.ACCESS_WIFI_STATE", "android.permission.WAKE_LOCK", "android.permission.GET_ACCOUNTS", "com.bbk.account.permission.READ_ACCOUNTINFO", "android.permission.AUTHENTICATE_ACCOUNTS", "android.permission.MOUNT_UNMOUNT_FILESYSTEMS", "android.permission.GET_TASKS"};
            d = new String[]{"com.vivo.push.sdk.service.CommandService", "com.vivo.push.sdk.service.CommonJobService"};
            e = new String[]{"com.vivo.push.sdk.RegistrationReceiver"};
            f = new String[]{"com.vivo.push.sdk.service.LinkProxyActivity"};
        } else if (!b3 && !c2) {
            throw new VivoPushException("AndroidManifest.xml中receiver配置项错误，详见接入文档");
        } else {
            if (b3) {
                d = new String[]{"com.vivo.push.sdk.service.CommandClientService"};
                f = new String[]{"com.vivo.push.sdk.LinkProxyClientActivity"};
            } else {
                d = new String[]{"com.vivo.push.sdk.service.CommandService"};
                f = new String[]{"com.vivo.push.sdk.service.LinkProxyActivity"};
            }
            e = new String[0];
            a = new String[0];
            if (c2) {
                b = new String[]{"android.permission.INTERNET", "android.permission.WRITE_SETTINGS"};
            } else {
                b = new String[]{"android.permission.INTERNET"};
            }
        }
        if (c2 || d2) {
            long a2 = a(context, context.getPackageName());
            long j = 225;
            if (context.getPackageName().equals(b2)) {
                j = 1225;
            }
            if (a2 == -1) {
                throw new VivoPushException("AndroidManifest.xml中未配置sdk_version");
            }
            if (a2 != j) {
                throw new VivoPushException("AndroidManifest.xml中sdk_version配置项错误，请配置当前sdk_version版本为:" + j);
            }
        }
        e(context);
        e(context, b2);
        c(context, b2);
        d(context, b2);
        String packageName = context.getPackageName();
        Object a3 = a(context, packageName, "com.vivo.push.api_key");
        if (a3 != null) {
            str = a3.toString();
        } else {
            Object a4 = a(context, packageName, "api_key");
            if (a4 != null) {
                str = a4.toString();
            } else {
                str = "";
            }
        }
        if (TextUtils.isEmpty(str)) {
            throw new VivoPushException("com.vivo.push.api_key is null");
        }
        String packageName2 = context.getPackageName();
        Object a5 = a(context, packageName2, "com.vivo.push.app_id");
        if (a5 != null) {
            str2 = a5.toString();
        } else {
            Object a6 = a(context, packageName2, Constants.APP_ID);
            if (a6 != null) {
                str2 = a6.toString();
            } else {
                str2 = "";
            }
        }
        if (TextUtils.isEmpty(str2)) {
            throw new VivoPushException("com.vivo.push.app_id is null");
        }
        if ((c2 || d2) && a(context, context.getPackageName()) == -1) {
            throw new VivoPushException("sdkversion is null");
        }
        if (d2) {
            a(context, "com.vivo.pushservice.action.METHOD", "com.vivo.push.sdk.RegistrationReceiver", true);
            a(context, "com.vivo.pushservice.action.PUSH_SERVICE", "com.vivo.push.sdk.service.PushService", false);
        }
    }

    private static void c(Context context, String str) throws VivoPushException {
        try {
            if (context.getPackageManager() == null) {
                throw new VivoPushException("localPackageManager is null");
            }
            ServiceInfo[] serviceInfoArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4).services;
            if (serviceInfoArr == null) {
                throw new VivoPushException("serviceInfos is null");
            }
            for (String str2 : d) {
                a(str2, serviceInfoArr, str);
            }
        } catch (Exception e2) {
            throw new VivoPushException("error " + e2.getMessage());
        }
    }

    private static void d(Context context, String str) throws VivoPushException {
        try {
            if (context.getPackageManager() == null) {
                throw new VivoPushException("localPackageManager is null");
            }
            ActivityInfo[] activityInfoArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 1).activities;
            if (activityInfoArr == null) {
                throw new VivoPushException("activityInfos is null");
            }
            for (String str2 : f) {
                a(str2, activityInfoArr, str);
            }
        } catch (Exception e2) {
            throw new VivoPushException("error " + e2.getMessage());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x006e, code lost:
        r2 = r2 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void e(Context context) throws VivoPushException {
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                throw new VivoPushException("localPackageManager is null");
            }
            String[] strArr = packageManager.getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
            if (strArr == null) {
                throw new VivoPushException("Permissions is null!");
            }
            String[] strArr2 = b;
            int length = strArr2.length;
            int i = 0;
            while (i < length) {
                String str = strArr2[i];
                for (String str2 : strArr) {
                    int i2 = str.equals(str2) ? 0 : i2 + 1;
                }
                throw new VivoPushException("permission : " + str + "  check fail : " + Arrays.toString(strArr));
            }
        } catch (Exception e2) {
            throw new VivoPushException(e2.getMessage());
        }
    }

    private static void a(String str, ComponentInfo[] componentInfoArr, String str2) throws VivoPushException {
        for (ComponentInfo componentInfo : componentInfoArr) {
            if (str.equals(componentInfo.name)) {
                if (!componentInfo.enabled) {
                    throw new VivoPushException(componentInfo.name + " module Push-SDK need is illegitmacy !");
                } else {
                    a(componentInfo, str2);
                    return;
                }
            }
        }
        throw new VivoPushException(str + " module Push-SDK need is not exist");
    }

    private static void a(ComponentInfo componentInfo, String str) throws VivoPushException {
        if (!componentInfo.applicationInfo.packageName.equals(str)) {
            for (String str2 : a) {
                if (str2.equals(componentInfo.name) && !componentInfo.processName.contains(":pushservice")) {
                    throw new VivoPushException("module : " + componentInfo.name + " process :" + componentInfo.processName + "  check process fail");
                }
            }
        }
    }

    private static void e(Context context, String str) throws VivoPushException {
        try {
            if (context.getPackageManager() == null) {
                throw new VivoPushException("localPackageManager is null");
            }
            ActivityInfo[] activityInfoArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 2).receivers;
            if (activityInfoArr == null) {
                throw new VivoPushException("receivers is null");
            }
            for (String str2 : e) {
                a(str2, activityInfoArr, str);
            }
        } catch (Exception e2) {
            throw new VivoPushException(e2.getMessage());
        }
    }

    private static void a(Context context, String str, String str2, boolean z) throws VivoPushException {
        Intent intent = new Intent(str);
        intent.setPackage(context.getPackageName());
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                throw new VivoPushException("localPackageManager is null");
            }
            if (z) {
                List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 576);
                if (queryBroadcastReceivers == null || queryBroadcastReceivers.size() <= 0) {
                    throw new VivoPushException("checkModule " + intent + " has no receivers");
                }
                for (ResolveInfo resolveInfo : queryBroadcastReceivers) {
                    if (str2.equals(resolveInfo.activityInfo.name)) {
                        return;
                    }
                }
                throw new VivoPushException(str2 + " is missing");
            }
            List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 576);
            if (queryIntentServices == null || queryIntentServices.size() <= 0) {
                throw new VivoPushException("checkModule " + intent + " has no services");
            }
            for (ResolveInfo resolveInfo2 : queryIntentServices) {
                if (str2.equals(resolveInfo2.serviceInfo.name)) {
                    if (!resolveInfo2.serviceInfo.exported) {
                        throw new VivoPushException(resolveInfo2.serviceInfo.name + " exported is false");
                    }
                    return;
                }
            }
            throw new VivoPushException(str2 + " is missing");
        } catch (Exception e2) {
            m.a("Utility", "error  " + e2.getMessage());
            throw new VivoPushException("checkModule error" + e2.getMessage());
        }
    }

    public static String b(String str, String str2) {
        String str3;
        try {
            str3 = (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, str);
        } catch (Exception e2) {
            e2.printStackTrace();
            str3 = str2;
        }
        return (str3 == null || str3.length() == 0) ? str2 : str3;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[MOVE_EXCEPTION, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x002b, code lost:
        r0 = r1.getString(r1.getColumnIndex(com.baidu.ubc.UBC.CONTENT_KEY_VALUE));
        com.vivo.push.util.m.d("Utility", "result key : " + r0);
        r2 = com.vivo.push.util.q.a(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static PublicKey d(Context context) {
        PublicKey publicKey = null;
        Cursor query = context.getContentResolver().query(com.vivo.push.w.a, null, null, null, null);
        if (query != null) {
            while (true) {
                try {
                    try {
                        if (!query.moveToNext()) {
                            try {
                                query.close();
                                break;
                            } catch (Exception e2) {
                            }
                        } else if ("pushkey".equals(query.getString(query.getColumnIndex("name")))) {
                            break;
                        }
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        try {
                            query.close();
                        } catch (Exception e4) {
                        }
                    }
                } finally {
                    try {
                        query.close();
                    } catch (Exception e5) {
                    }
                }
            }
        }
        return publicKey;
    }

    public static boolean b(Context context, String str) {
        PackageManager packageManager;
        List<ApplicationInfo> installedApplications;
        if (context != null && (packageManager = context.getPackageManager()) != null && (installedApplications = packageManager.getInstalledApplications(128)) != null) {
            String packageName = context.getPackageName();
            for (ApplicationInfo applicationInfo : installedApplications) {
                String str2 = applicationInfo.packageName;
                if (packageName.equals(str2) || str.equals(str2)) {
                    if ((applicationInfo.flags & 129) != 0) {
                        m.d("Utility", " matching " + str2 + " is system app");
                        return true;
                    }
                }
            }
            return false;
        }
        return false;
    }

    public static void a(Context context, Intent intent) {
        String b2 = p.b(context);
        String stringExtra = intent.getStringExtra("client_pkgname");
        if (TextUtils.isEmpty(b2)) {
            m.a("Utility", "illegality abe adapter : push pkg is null");
        } else if (TextUtils.isEmpty(stringExtra)) {
            m.a("Utility", "illegality abe adapter : src pkg is null");
        } else if (b2.equals(context.getPackageName())) {
            m.a("Utility", "illegality abe adapter : abe is not pushservice");
        } else if (!b2.equals(stringExtra)) {
            m.d("Utility", "proxy to core : intent pkg : " + intent.getPackage() + " ; src pkg : " + stringExtra + " ; push pkg : " + b2);
            intent.setPackage(b2);
            intent.setClassName(b2, "com.vivo.push.sdk.service.PushService");
            context.startService(intent);
        } else {
            m.a("Utility", "illegality abe adapter : pushPkg = " + b2 + " ; srcPkg = " + stringExtra);
        }
    }
}
