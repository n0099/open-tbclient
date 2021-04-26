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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.bumptech.glide.manager.DefaultConnectivityMonitorFactory;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import java.security.PublicKey;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public final class z {

    /* renamed from: c  reason: collision with root package name */
    public static Boolean f37574c;

    /* renamed from: a  reason: collision with root package name */
    public static String[] f37572a = {"com.vivo.push.sdk.RegistrationReceiver", "com.vivo.push.sdk.service.PushService", "com.vivo.push.sdk.service.CommonJobService"};

    /* renamed from: b  reason: collision with root package name */
    public static String[] f37573b = {"android.permission.INTERNET", "android.permission.READ_PHONE_STATE", DefaultConnectivityMonitorFactory.NETWORK_PERMISSION, "android.permission.WRITE_SETTINGS", "android.permission.VIBRATE", StorageUtils.EXTERNAL_STORAGE_PERMISSION, "android.permission.ACCESS_WIFI_STATE", "android.permission.WAKE_LOCK", "android.permission.GET_ACCOUNTS", "com.bbk.account.permission.READ_ACCOUNTINFO", "android.permission.AUTHENTICATE_ACCOUNTS", "android.permission.MOUNT_UNMOUNT_FILESYSTEMS", "android.permission.GET_TASKS"};

    /* renamed from: d  reason: collision with root package name */
    public static String[] f37575d = {"com.vivo.push.sdk.service.CommandService", "com.vivo.push.sdk.service.CommonJobService"};

    /* renamed from: e  reason: collision with root package name */
    public static String[] f37576e = {"com.vivo.push.sdk.RegistrationReceiver"};

    /* renamed from: f  reason: collision with root package name */
    public static String[] f37577f = new String[0];

    public static boolean a(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        Boolean bool = f37574c;
        if (bool != null) {
            return bool.booleanValue();
        }
        String b2 = s.b(context);
        if (context != null && context.getPackageName().equals(b2)) {
            f37574c = Boolean.TRUE;
            return true;
        } else if (context == null) {
            p.d("Utility", "isPushProcess context is null");
            return false;
        } else {
            int myPid = Process.myPid();
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            String str = null;
            if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null && runningAppProcesses.size() != 0) {
                Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ActivityManager.RunningAppProcessInfo next = it.next();
                    if (next.pid == myPid) {
                        str = next.processName;
                        break;
                    }
                }
            }
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            Boolean valueOf = Boolean.valueOf(str.contains(":pushservice"));
            f37574c = valueOf;
            return valueOf.booleanValue();
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

    public static void c(Context context) throws VivoPushException {
        String obj;
        p.d("Utility", "check PushService AndroidManifest declearation !");
        String b2 = s.b(context);
        boolean c2 = s.c(context, context.getPackageName());
        boolean d2 = s.d(context, context.getPackageName());
        boolean b3 = s.b(context, context.getPackageName());
        if (d2) {
            f37572a = new String[]{"com.vivo.push.sdk.RegistrationReceiver", "com.vivo.push.sdk.service.PushService", "com.vivo.push.sdk.service.CommonJobService"};
            f37573b = new String[]{"android.permission.INTERNET", "android.permission.READ_PHONE_STATE", DefaultConnectivityMonitorFactory.NETWORK_PERMISSION, "android.permission.WRITE_SETTINGS", "android.permission.VIBRATE", StorageUtils.EXTERNAL_STORAGE_PERMISSION, "android.permission.ACCESS_WIFI_STATE", "android.permission.WAKE_LOCK", "android.permission.GET_ACCOUNTS", "com.bbk.account.permission.READ_ACCOUNTINFO", "android.permission.AUTHENTICATE_ACCOUNTS", "android.permission.MOUNT_UNMOUNT_FILESYSTEMS", "android.permission.GET_TASKS"};
            f37575d = new String[]{"com.vivo.push.sdk.service.CommandService", "com.vivo.push.sdk.service.CommonJobService"};
            f37576e = new String[]{"com.vivo.push.sdk.RegistrationReceiver"};
        } else if (!b3 && !c2) {
            throw new VivoPushException("AndroidManifest.xml中receiver配置项错误，详见接入文档");
        } else {
            if (b3) {
                f37575d = new String[]{"com.vivo.push.sdk.service.CommandClientService"};
            } else {
                f37575d = new String[]{"com.vivo.push.sdk.service.CommandService"};
            }
            f37576e = new String[0];
            f37572a = new String[0];
            if (c2) {
                f37573b = new String[]{"android.permission.INTERNET", "android.permission.WRITE_SETTINGS"};
            } else {
                f37573b = new String[]{"android.permission.INTERNET"};
            }
        }
        if (c2 || d2) {
            long a2 = a(context, context.getPackageName());
            long j = context.getPackageName().equals(b2) ? 1293L : 293L;
            if (a2 == -1) {
                throw new VivoPushException("AndroidManifest.xml中未配置sdk_version");
            }
            if (a2 != j) {
                throw new VivoPushException("AndroidManifest.xml中sdk_version配置项错误，请配置当前sdk_version版本为:" + j);
            }
        }
        g(context);
        e(context, b2);
        c(context, b2);
        d(context, b2);
        String packageName = context.getPackageName();
        Object b4 = b(context, packageName, "com.vivo.push.api_key");
        if (b4 != null) {
            obj = b4.toString();
        } else {
            Object b5 = b(context, packageName, Constants.API_KEY);
            obj = b5 != null ? b5.toString() : "";
        }
        if (!TextUtils.isEmpty(obj)) {
            if (!TextUtils.isEmpty(b(context, context.getPackageName()))) {
                if ((c2 || d2) && a(context, context.getPackageName()) == -1) {
                    throw new VivoPushException("sdkversion is null");
                }
                if (d2) {
                    a(context, "com.vivo.pushservice.action.METHOD", "com.vivo.push.sdk.RegistrationReceiver", true);
                    a(context, "com.vivo.pushservice.action.PUSH_SERVICE", "com.vivo.push.sdk.service.PushService", false);
                    return;
                }
                return;
            }
            throw new VivoPushException("com.vivo.push.app_id is null");
        }
        throw new VivoPushException("com.vivo.push.api_key is null");
    }

    public static void d(Context context, String str) throws VivoPushException {
        if (f37577f.length <= 0) {
            return;
        }
        try {
            if (context.getPackageManager() != null) {
                ActivityInfo[] activityInfoArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 1).activities;
                if (activityInfoArr != null) {
                    for (String str2 : f37577f) {
                        a(str2, activityInfoArr, str);
                    }
                    return;
                }
                throw new VivoPushException("activityInfos is null");
            }
            throw new VivoPushException("localPackageManager is null");
        } catch (Exception e2) {
            throw new VivoPushException("error " + e2.getMessage());
        }
    }

    public static void e(Context context, String str) throws VivoPushException {
        try {
            if (context.getPackageManager() != null) {
                ActivityInfo[] activityInfoArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 2).receivers;
                if (activityInfoArr != null) {
                    for (String str2 : f37576e) {
                        a(str2, activityInfoArr, str);
                    }
                    return;
                }
                throw new VivoPushException("receivers is null");
            }
            throw new VivoPushException("localPackageManager is null");
        } catch (Exception e2) {
            throw new VivoPushException(e2.getMessage());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x007a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Map<String, String> f(Context context) {
        Cursor cursor;
        Cursor cursor2 = null;
        try {
            if (context == null) {
                p.a("Utility", "getDebugInfo error : context is null");
                return null;
            }
            Cursor query = context.getContentResolver().query(com.vivo.push.z.f37589d, null, null, null, null);
            try {
                if (query == null) {
                    p.a("Utility", "cursor is null");
                    if (query != null) {
                        try {
                            query.close();
                        } catch (Exception e2) {
                            p.a("Utility", IntentConfig.CLOSE, e2);
                        }
                    }
                    return null;
                }
                HashMap hashMap = new HashMap();
                while (query.moveToNext()) {
                    int columnCount = query.getColumnCount();
                    for (int i2 = 0; i2 < columnCount; i2++) {
                        hashMap.put(query.getColumnName(i2), query.getString(i2));
                    }
                }
                if (query != null) {
                    try {
                        query.close();
                    } catch (Exception e3) {
                        p.a("Utility", IntentConfig.CLOSE, e3);
                    }
                }
                return hashMap;
            } catch (Exception e4) {
                cursor = query;
                e = e4;
                try {
                    p.a("Utility", "isOverdue", e);
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Exception e5) {
                            p.a("Utility", IntentConfig.CLOSE, e5);
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                        try {
                            cursor2.close();
                        } catch (Exception e6) {
                            p.a("Utility", IntentConfig.CLOSE, e6);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                cursor2 = query;
                th = th2;
                if (cursor2 != null) {
                }
                throw th;
            }
        } catch (Exception e7) {
            e = e7;
            cursor = null;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002c, code lost:
        r3 = r3 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void g(Context context) throws VivoPushException {
        int i2;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                String[] strArr = packageManager.getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
                if (strArr != null) {
                    String[] strArr2 = f37573b;
                    int length = strArr2.length;
                    int i3 = 0;
                    while (i3 < length) {
                        String str = strArr2[i3];
                        int length2 = strArr.length;
                        while (i2 < length2) {
                            i2 = str.equals(strArr[i2]) ? 0 : i2 + 1;
                        }
                        throw new VivoPushException("permission : " + str + "  check fail : " + Arrays.toString(strArr));
                    }
                    return;
                }
                throw new VivoPushException("Permissions is null!");
            }
            throw new VivoPushException("localPackageManager is null");
        } catch (Exception e2) {
            throw new VivoPushException(e2.getMessage());
        }
    }

    public static String b(Context context, String str) {
        Object b2 = b(context, str, "com.vivo.push.app_id");
        if (b2 != null) {
            return b2.toString();
        }
        Object b3 = b(context, str, com.xiaomi.mipush.sdk.Constants.APP_ID);
        return b3 != null ? b3.toString() : "";
    }

    public static boolean e(Context context) {
        Cursor cursor = null;
        try {
            try {
                try {
                } catch (Exception e2) {
                    p.a("Utility", IntentConfig.CLOSE, e2);
                }
            } catch (Throwable th) {
                if (0 != 0) {
                    try {
                        cursor.close();
                    } catch (Exception e3) {
                        p.a("Utility", IntentConfig.CLOSE, e3);
                    }
                }
                throw th;
            }
        } catch (Exception e4) {
            p.a("Utility", "isSupport", e4);
            if (0 != 0) {
                cursor.close();
            }
        }
        if (context == null) {
            p.a("Utility", "context is null");
            return false;
        }
        String packageName = context.getPackageName();
        Cursor query = context.getContentResolver().query(com.vivo.push.z.f37587b, null, "pushVersion = ? and appPkgName = ? and appCode = ? ", new String[]{"293", packageName, String.valueOf(context.getPackageManager().getPackageInfo(packageName, 0).versionCode)}, null);
        if (query == null) {
            p.a("Utility", "cursor is null");
            if (query != null) {
                try {
                    query.close();
                } catch (Exception e5) {
                    p.a("Utility", IntentConfig.CLOSE, e5);
                }
            }
            return false;
        } else if (!query.moveToFirst() || (query.getInt(query.getColumnIndex("permission")) & 1) == 0) {
            if (query != null) {
                query.close();
            }
            return false;
        } else {
            if (query != null) {
                try {
                    query.close();
                } catch (Exception e6) {
                    p.a("Utility", IntentConfig.CLOSE, e6);
                }
            }
            return true;
        }
    }

    public static Object b(Context context, String str, String str2) {
        Bundle bundle;
        if (context != null) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 128);
                    bundle = applicationInfo != null ? applicationInfo.metaData : null;
                    if (bundle == null) {
                        return null;
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                    return null;
                }
            }
            return bundle.get(str2);
        }
        return null;
    }

    public static PublicKey d(Context context) {
        Cursor query = context.getContentResolver().query(com.vivo.push.z.f37586a, null, null, null, null);
        if (query == null) {
            return null;
        }
        do {
            try {
                try {
                    if (query.moveToNext()) {
                    }
                } catch (Throwable th) {
                    try {
                        query.close();
                    } catch (Exception unused) {
                    }
                    throw th;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            try {
                query.close();
            } catch (Exception unused2) {
                return null;
            }
        } while (!"pushkey".equals(query.getString(query.getColumnIndex("name"))));
        String string = query.getString(query.getColumnIndex("value"));
        p.d("Utility", "result key : " + string);
        PublicKey a2 = t.a(string);
        try {
            query.close();
        } catch (Exception unused3) {
        }
        return a2;
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

    public static long a(Context context, String str) {
        Object b2 = b(context, str, "com.vivo.push.sdk_version");
        if (b2 == null) {
            b2 = b(context, str, "sdk_version");
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

    public static Object a(String str, String str2) throws Exception {
        Class<?> cls = Class.forName(str);
        return cls.getField(str2).get(cls);
    }

    public static void a(String str, ComponentInfo[] componentInfoArr, String str2) throws VivoPushException {
        for (ComponentInfo componentInfo : componentInfoArr) {
            if (str.equals(componentInfo.name)) {
                if (componentInfo.enabled) {
                    a(componentInfo, str2);
                    return;
                }
                throw new VivoPushException(componentInfo.name + " module Push-SDK need is illegitmacy !");
            }
        }
        throw new VivoPushException(str + " module Push-SDK need is not exist");
    }

    public static void a(ComponentInfo componentInfo, String str) throws VivoPushException {
        if (componentInfo.applicationInfo.packageName.equals(str)) {
            return;
        }
        for (String str2 : f37572a) {
            if (str2.equals(componentInfo.name) && !componentInfo.processName.contains(":pushservice")) {
                throw new VivoPushException("module : " + componentInfo.name + " process :" + componentInfo.processName + "  check process fail");
            }
        }
    }

    public static void a(Context context, String str, String str2, boolean z) throws VivoPushException {
        Intent intent = new Intent(str);
        intent.setPackage(context.getPackageName());
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                throw new VivoPushException("localPackageManager is null");
            }
            if (z) {
                List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, PayBeanFactory.BEAN_ID_SAVE_SWITCH_PAYFREE);
                if (queryBroadcastReceivers != null && queryBroadcastReceivers.size() > 0) {
                    for (ResolveInfo resolveInfo : queryBroadcastReceivers) {
                        if (str2.equals(resolveInfo.activityInfo.name)) {
                            return;
                        }
                    }
                    throw new VivoPushException(str2 + " is missing");
                }
                throw new VivoPushException("checkModule " + intent + " has no receivers");
            }
            List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, PayBeanFactory.BEAN_ID_SAVE_SWITCH_PAYFREE);
            if (queryIntentServices != null && queryIntentServices.size() > 0) {
                for (ResolveInfo resolveInfo2 : queryIntentServices) {
                    if (str2.equals(resolveInfo2.serviceInfo.name)) {
                        if (resolveInfo2.serviceInfo.exported) {
                            return;
                        }
                        throw new VivoPushException(resolveInfo2.serviceInfo.name + " exported is false");
                    }
                }
                throw new VivoPushException(str2 + " is missing");
            }
            throw new VivoPushException("checkModule " + intent + " has no services");
        } catch (Exception e2) {
            p.a("Utility", "error  " + e2.getMessage());
            throw new VivoPushException("checkModule error" + e2.getMessage());
        }
    }

    public static void c(Context context, String str) throws VivoPushException {
        try {
            if (context.getPackageManager() != null) {
                ServiceInfo[] serviceInfoArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4).services;
                if (serviceInfoArr != null) {
                    for (String str2 : f37575d) {
                        a(str2, serviceInfoArr, str);
                    }
                    return;
                }
                throw new VivoPushException("serviceInfos is null");
            }
            throw new VivoPushException("localPackageManager is null");
        } catch (Exception e2) {
            throw new VivoPushException("error " + e2.getMessage());
        }
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

    public static boolean a(Context context, String str, String str2) {
        Cursor cursor = null;
        try {
            try {
                try {
                } catch (Throwable th) {
                    if (0 != 0) {
                        try {
                            cursor.close();
                        } catch (Exception e2) {
                            p.a("Utility", IntentConfig.CLOSE, e2);
                        }
                    }
                    throw th;
                }
            } catch (Exception e3) {
                p.a("Utility", IntentConfig.CLOSE, e3);
            }
        } catch (Exception e4) {
            p.a("Utility", "isOverdue", e4);
            if (0 != 0) {
                cursor.close();
            }
        }
        if (context == null) {
            p.a("Utility", "context is null");
            return false;
        }
        Cursor query = context.getContentResolver().query(com.vivo.push.z.f37588c, null, "appPkgName = ? and regId = ? sdkVersion = ? ", new String[]{str, str2, "293"}, null);
        if (query == null) {
            p.a("Utility", "cursor is null");
            if (query != null) {
                try {
                    query.close();
                } catch (Exception e5) {
                    p.a("Utility", IntentConfig.CLOSE, e5);
                }
            }
            return false;
        } else if (!query.moveToFirst()) {
            if (query != null) {
                query.close();
            }
            return false;
        } else {
            boolean parseBoolean = Boolean.parseBoolean(query.getString(query.getColumnIndex("clientState")));
            if (query != null) {
                try {
                    query.close();
                } catch (Exception e6) {
                    p.a("Utility", IntentConfig.CLOSE, e6);
                }
            }
            return parseBoolean;
        }
    }
}
