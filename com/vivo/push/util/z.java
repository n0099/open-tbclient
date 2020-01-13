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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public final class z {
    private static Boolean c;
    private static String[] a = {"com.vivo.push.sdk.RegistrationReceiver", "com.vivo.push.sdk.service.PushService", "com.vivo.push.sdk.service.CommonJobService"};
    private static String[] b = {"android.permission.INTERNET", "android.permission.READ_PHONE_STATE", "android.permission.ACCESS_NETWORK_STATE", "android.permission.WRITE_SETTINGS", "android.permission.VIBRATE", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.ACCESS_WIFI_STATE", "android.permission.WAKE_LOCK", "android.permission.GET_ACCOUNTS", "com.bbk.account.permission.READ_ACCOUNTINFO", "android.permission.AUTHENTICATE_ACCOUNTS", "android.permission.MOUNT_UNMOUNT_FILESYSTEMS", "android.permission.GET_TASKS"};
    private static String[] d = {"com.vivo.push.sdk.service.CommandService", "com.vivo.push.sdk.service.CommonJobService"};
    private static String[] e = {"com.vivo.push.sdk.RegistrationReceiver"};
    private static String[] f = new String[0];

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
        String b2 = s.b(context);
        if (context != null && context.getPackageName().equals(b2)) {
            Boolean bool = true;
            c = bool;
            return bool.booleanValue();
        } else if (context == null) {
            p.d("Utility", "isPushProcess context is null");
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
        String b2 = s.b(context);
        if (TextUtils.isEmpty(b2)) {
            p.a("Utility", "systemPushPkgName is null");
            return -1L;
        }
        return a(context, b2);
    }

    public static long a(Context context, String str) {
        Object b2 = b(context, str, "com.vivo.push.sdk_version");
        if (b2 == null) {
            b2 = b(context, str, SapiContext.KEY_SDK_VERSION);
        }
        if (b2 != null) {
            try {
                return Long.parseLong(b2.toString());
            } catch (Exception e2) {
                e2.printStackTrace();
                p.a("Utility", "getSdkVersionCode error ", e2);
                return -1L;
            }
        }
        p.a("Utility", "getSdkVersionCode sdk version is null");
        return -1L;
    }

    public static String b(Context context, String str) {
        Object b2 = b(context, str, "com.vivo.push.app_id");
        if (b2 != null) {
            return b2.toString();
        }
        Object b3 = b(context, str, Constants.APP_ID);
        if (b3 != null) {
            return b3.toString();
        }
        return "";
    }

    private static Object b(Context context, String str, String str2) {
        if (context == null || TextUtils.isEmpty(str)) {
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
        p.d("Utility", "check PushService AndroidManifest declearation !");
        String b2 = s.b(context);
        boolean c2 = s.c(context, context.getPackageName());
        boolean d2 = s.d(context, context.getPackageName());
        boolean b3 = s.b(context, context.getPackageName());
        if (d2) {
            a = new String[]{"com.vivo.push.sdk.RegistrationReceiver", "com.vivo.push.sdk.service.PushService", "com.vivo.push.sdk.service.CommonJobService"};
            b = new String[]{"android.permission.INTERNET", "android.permission.READ_PHONE_STATE", "android.permission.ACCESS_NETWORK_STATE", "android.permission.WRITE_SETTINGS", "android.permission.VIBRATE", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.ACCESS_WIFI_STATE", "android.permission.WAKE_LOCK", "android.permission.GET_ACCOUNTS", "com.bbk.account.permission.READ_ACCOUNTINFO", "android.permission.AUTHENTICATE_ACCOUNTS", "android.permission.MOUNT_UNMOUNT_FILESYSTEMS", "android.permission.GET_TASKS"};
            d = new String[]{"com.vivo.push.sdk.service.CommandService", "com.vivo.push.sdk.service.CommonJobService"};
            e = new String[]{"com.vivo.push.sdk.RegistrationReceiver"};
        } else if (!b3 && !c2) {
            throw new VivoPushException("AndroidManifest.xml中receiver配置项错误，详见接入文档");
        } else {
            if (b3) {
                d = new String[]{"com.vivo.push.sdk.service.CommandClientService"};
            } else {
                d = new String[]{"com.vivo.push.sdk.service.CommandService"};
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
            long j = 280;
            if (context.getPackageName().equals(b2)) {
                j = 1280;
            }
            if (a2 == -1) {
                throw new VivoPushException("AndroidManifest.xml中未配置sdk_version");
            }
            if (a2 != j) {
                throw new VivoPushException("AndroidManifest.xml中sdk_version配置项错误，请配置当前sdk_version版本为:" + j);
            }
        }
        g(context);
        f(context, b2);
        d(context, b2);
        e(context, b2);
        String packageName = context.getPackageName();
        Object b4 = b(context, packageName, "com.vivo.push.api_key");
        if (b4 != null) {
            str = b4.toString();
        } else {
            Object b5 = b(context, packageName, com.baidu.android.imsdk.internal.Constants.API_KEY);
            if (b5 != null) {
                str = b5.toString();
            } else {
                str = "";
            }
        }
        if (TextUtils.isEmpty(str)) {
            throw new VivoPushException("com.vivo.push.api_key is null");
        }
        if (TextUtils.isEmpty(b(context, context.getPackageName()))) {
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

    private static void d(Context context, String str) throws VivoPushException {
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

    private static void e(Context context, String str) throws VivoPushException {
        if (f.length > 0) {
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
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x006e, code lost:
        r2 = r2 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void g(Context context) throws VivoPushException {
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

    private static void f(Context context, String str) throws VivoPushException {
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
            p.a("Utility", "error  " + e2.getMessage());
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
        r0 = r1.getString(r1.getColumnIndex("value"));
        com.vivo.push.util.p.d("Utility", "result key : " + r0);
        r2 = com.vivo.push.util.t.a(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static PublicKey d(Context context) {
        PublicKey publicKey = null;
        Cursor query = context.getContentResolver().query(com.vivo.push.z.a, null, null, null, null);
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

    public static boolean c(Context context, String str) {
        PackageManager packageManager;
        List<ApplicationInfo> installedApplications;
        if (context != null && (packageManager = context.getPackageManager()) != null && (installedApplications = packageManager.getInstalledApplications(128)) != null) {
            String packageName = context.getPackageName();
            for (ApplicationInfo applicationInfo : installedApplications) {
                String str2 = applicationInfo.packageName;
                if (packageName.equals(str2) || str.equals(str2)) {
                    if ((applicationInfo.flags & 129) != 0) {
                        p.d("Utility", " matching " + str2 + " is system app");
                        return true;
                    }
                }
            }
            return false;
        }
        return false;
    }

    public static void a(Context context, Intent intent) {
        String b2 = s.b(context);
        String stringExtra = intent.getStringExtra("client_pkgname");
        if (TextUtils.isEmpty(b2)) {
            p.a("Utility", "illegality abe adapter : push pkg is null");
        } else if (TextUtils.isEmpty(stringExtra)) {
            p.a("Utility", "illegality abe adapter : src pkg is null");
        } else if (b2.equals(context.getPackageName())) {
            p.a("Utility", "illegality abe adapter : abe is not pushservice");
        } else if (!b2.equals(stringExtra)) {
            p.d("Utility", "proxy to core : intent pkg : " + intent.getPackage() + " ; src pkg : " + stringExtra + " ; push pkg : " + b2);
            intent.setPackage(b2);
            intent.setClassName(b2, "com.vivo.push.sdk.service.PushService");
            context.startService(intent);
        } else {
            p.a("Utility", "illegality abe adapter : pushPkg = " + b2 + " ; srcPkg = " + stringExtra);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [768=5, 764=5, 765=5, 767=5] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:24:0x0085 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:45:0x00c8 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 1, insn: 0x00c6: MOVE  (r8 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:44:0x00c6 */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00b6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00a4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v10, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v3, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x00c8 -> B:31:0x0099). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x000f -> B:5:0x000f). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean e(Context context) {
        ?? r1;
        Cursor cursor;
        boolean z;
        Cursor cursor2 = null;
        try {
            try {
            } catch (Throwable th) {
                th = th;
                cursor2 = cursor;
                if (cursor2 != null) {
                    try {
                        cursor2.close();
                    } catch (Exception e2) {
                        p.a("Utility", "close", e2);
                    }
                }
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            r1 = 0;
            p.a("Utility", "isSupport", e);
            if (r1 != 0) {
            }
            z = false;
            r1 = r1;
            return z;
        } catch (Throwable th2) {
            th = th2;
            if (cursor2 != null) {
            }
            throw th;
        }
        if (context == null) {
            p.a("Utility", "context is null");
            return false;
        }
        String packageName = context.getPackageName();
        r1 = context.getContentResolver().query(com.vivo.push.z.b, null, "pushVersion = ? and appPkgName = ? and appCode = ? ", new String[]{"280", packageName, String.valueOf(context.getPackageManager().getPackageInfo(packageName, 0).versionCode)}, null);
        try {
        } catch (Exception e4) {
            e = e4;
            p.a("Utility", "isSupport", e);
            if (r1 != 0) {
                try {
                    r1.close();
                } catch (Exception e5) {
                    r1 = "Utility";
                    p.a("Utility", "close", e5);
                }
            }
            z = false;
            r1 = r1;
            return z;
        }
        if (r1 == 0) {
            p.a("Utility", "cursor is null");
            String str = r1;
            if (r1 != 0) {
                try {
                    r1.close();
                    str = r1;
                } catch (Exception e6) {
                    p.a("Utility", "close", e6);
                    str = "Utility";
                }
            }
            z = false;
            r1 = str;
        } else {
            if (r1.moveToFirst()) {
                int i = r1.getInt(r1.getColumnIndex("permission")) & 1;
                String str2 = r1;
                if (i != 0) {
                    if (r1 != 0) {
                        try {
                            r1.close();
                            str2 = r1;
                        } catch (Exception e7) {
                            p.a("Utility", "close", e7);
                            str2 = "Utility";
                        }
                    }
                    z = true;
                    r1 = str2;
                }
            }
            if (r1 != 0) {
                try {
                    r1.close();
                } catch (Exception e8) {
                    r1 = "Utility";
                    p.a("Utility", "close", e8);
                }
            }
            z = false;
            r1 = r1;
        }
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [794=5, 795=5, 797=5, 798=5] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:42:0x00ab */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:44:0x00ad */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:46:0x009c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0089 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v12, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v13, types: [java.lang.Throwable, java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r1v14, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.lang.String] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x00ad -> B:29:0x007e). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x000e -> B:5:0x000e). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(Context context, String str, String str2) {
        Cursor cursor;
        Cursor cursor2;
        boolean z;
        try {
            try {
            } catch (Throwable th) {
                th = th;
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception e2) {
                        p.a("Utility", "close", e2);
                    }
                }
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            cursor = null;
            p.a("Utility", "isOverdue", e);
            cursor2 = cursor;
            if (cursor != null) {
            }
            z = false;
            cursor = cursor2;
            return z;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
            if (cursor != null) {
            }
            throw th;
        }
        if (context == null) {
            p.a("Utility", "context is null");
            return false;
        }
        Cursor query = context.getContentResolver().query(com.vivo.push.z.c, null, "appPkgName = ? and regId = ? ", new String[]{str, str2}, null);
        try {
        } catch (Exception e4) {
            e = e4;
            p.a("Utility", "isOverdue", e);
            cursor2 = cursor;
            if (cursor != null) {
                try {
                    cursor.close();
                    cursor2 = cursor;
                } catch (Exception e5) {
                    p.a("Utility", "close", e5);
                    cursor2 = "Utility";
                }
            }
            z = false;
            cursor = cursor2;
            return z;
        }
        if (query == null) {
            p.a("Utility", "cursor is null");
            Cursor cursor3 = query;
            if (query != null) {
                try {
                    query.close();
                    cursor3 = query;
                } catch (Exception e6) {
                    p.a("Utility", "close", e6);
                    cursor3 = "Utility";
                }
            }
            z = false;
            cursor = cursor3;
        } else {
            boolean moveToFirst = query.moveToFirst();
            cursor2 = query;
            if (moveToFirst) {
                z = Boolean.parseBoolean(query.getString(query.getColumnIndex("clientState")));
                cursor = query;
                if (query != null) {
                    try {
                        query.close();
                        cursor = query;
                    } catch (Exception e7) {
                        p.a("Utility", "close", e7);
                        cursor = e7;
                    }
                }
            } else {
                if (query != null) {
                    try {
                        query.close();
                        cursor2 = query;
                    } catch (Exception e8) {
                        p.a("Utility", "close", e8);
                        cursor2 = "Utility";
                    }
                }
                z = false;
                cursor = cursor2;
            }
        }
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [832=4, 834=4, 835=4, 831=4] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x008b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Map<String, String> f(Context context) {
        Cursor cursor;
        HashMap hashMap;
        Cursor cursor2 = null;
        try {
            try {
                if (context == null) {
                    p.a("Utility", "getDebugInfo error : context is null");
                    hashMap = null;
                } else {
                    cursor = context.getContentResolver().query(com.vivo.push.z.d, null, null, null, null);
                    try {
                        if (cursor == null) {
                            p.a("Utility", "cursor is null");
                            if (cursor != null) {
                                try {
                                    cursor.close();
                                } catch (Exception e2) {
                                    p.a("Utility", "close", e2);
                                }
                            }
                            hashMap = null;
                        } else {
                            hashMap = new HashMap();
                            while (cursor.moveToNext()) {
                                int columnCount = cursor.getColumnCount();
                                for (int i = 0; i < columnCount; i++) {
                                    hashMap.put(cursor.getColumnName(i), cursor.getString(i));
                                }
                            }
                            if (cursor != null) {
                                try {
                                    cursor.close();
                                } catch (Exception e3) {
                                    p.a("Utility", "close", e3);
                                }
                            }
                        }
                    } catch (Exception e4) {
                        e = e4;
                        p.a("Utility", "isOverdue", e);
                        if (cursor != null) {
                            try {
                                cursor.close();
                            } catch (Exception e5) {
                                p.a("Utility", "close", e5);
                            }
                        }
                        return null;
                    }
                }
                return hashMap;
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                    try {
                        cursor2.close();
                    } catch (Exception e6) {
                        p.a("Utility", "close", e6);
                    }
                }
                throw th;
            }
        } catch (Exception e7) {
            e = e7;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            if (0 != 0) {
            }
            throw th;
        }
    }
}
