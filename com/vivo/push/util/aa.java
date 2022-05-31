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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.stat.ShareLoginStat;
import com.baidu.searchbox.download.center.clearcache.DiskManagerSharedPrefsUtils;
import com.baidu.sofire.sharedpreferences.SharedPreferenceManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.security.PublicKey;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes7.dex */
public final class aa {
    public static /* synthetic */ Interceptable $ic;
    public static String[] a;
    public static String[] b;
    public static Boolean c;
    public static String[] d;
    public static String[] e;
    public static String[] f;
    public static Map<String, Bundle> g;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1594687066, "Lcom/vivo/push/util/aa;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1594687066, "Lcom/vivo/push/util/aa;");
                return;
            }
        }
        a = new String[]{"com.vivo.push.sdk.RegistrationReceiver", "com.vivo.push.sdk.service.PushService", "com.vivo.push.sdk.service.CommonJobService"};
        b = new String[]{"android.permission.INTERNET", "android.permission.READ_PHONE_STATE", "android.permission.ACCESS_NETWORK_STATE", "android.permission.WRITE_SETTINGS", "android.permission.VIBRATE", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.ACCESS_WIFI_STATE", "android.permission.WAKE_LOCK", "android.permission.GET_ACCOUNTS", "com.bbk.account.permission.READ_ACCOUNTINFO", "android.permission.AUTHENTICATE_ACCOUNTS", "android.permission.MOUNT_UNMOUNT_FILESYSTEMS", "android.permission.GET_TASKS"};
        d = new String[]{"com.vivo.push.sdk.service.CommandService", "com.vivo.push.sdk.service.CommonJobService"};
        e = new String[]{"com.vivo.push.sdk.RegistrationReceiver"};
        f = new String[0];
        g = new ConcurrentHashMap();
    }

    public static boolean a(Context context) {
        InterceptResult invokeL;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            Boolean bool = c;
            if (bool != null) {
                return bool.booleanValue();
            }
            if (context == null) {
                p.d("Utility", "isPushProcess context is null");
                return false;
            }
            String b2 = t.b(context);
            if (context != null && context.getPackageName() != null && context.getPackageName().equals(b2)) {
                c = Boolean.TRUE;
                return true;
            }
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
            c = valueOf;
            return valueOf.booleanValue();
        }
        return invokeL.booleanValue;
    }

    public static long b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            String b2 = t.b(context);
            if (TextUtils.isEmpty(b2)) {
                p.a("Utility", "systemPushPkgName is null");
                return -1L;
            }
            return a(context, b2);
        }
        return invokeL.longValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00f0, code lost:
        r12 = r12 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void c(Context context) throws VivoPushException {
        String obj;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, context) == null) {
            p.d("Utility", "check PushService AndroidManifest declearation !");
            String b2 = t.b(context);
            boolean d2 = t.d(context, context.getPackageName());
            boolean e2 = t.e(context, context.getPackageName());
            boolean c2 = t.c(context, context.getPackageName());
            if (e2) {
                a = new String[]{"com.vivo.push.sdk.RegistrationReceiver", "com.vivo.push.sdk.service.PushService", "com.vivo.push.sdk.service.CommonJobService"};
                b = new String[]{"android.permission.INTERNET", "android.permission.READ_PHONE_STATE", "android.permission.ACCESS_NETWORK_STATE", "android.permission.WRITE_SETTINGS", "android.permission.VIBRATE", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.ACCESS_WIFI_STATE", "android.permission.WAKE_LOCK", "android.permission.GET_ACCOUNTS", "com.bbk.account.permission.READ_ACCOUNTINFO", "android.permission.AUTHENTICATE_ACCOUNTS", "android.permission.MOUNT_UNMOUNT_FILESYSTEMS", "android.permission.GET_TASKS"};
                d = new String[]{"com.vivo.push.sdk.service.CommandService", "com.vivo.push.sdk.service.CommonJobService"};
                e = new String[]{"com.vivo.push.sdk.RegistrationReceiver"};
            } else if (!c2 && !d2) {
                throw new VivoPushException("AndroidManifest.xml中receiver配置项错误，详见接入文档");
            } else {
                if (c2) {
                    d = new String[]{"com.vivo.push.sdk.service.CommandClientService"};
                } else {
                    d = new String[]{"com.vivo.push.sdk.service.CommandService"};
                }
                e = new String[0];
                a = new String[0];
                if (d2) {
                    b = new String[]{"android.permission.INTERNET", "android.permission.WRITE_SETTINGS"};
                } else {
                    b = new String[]{"android.permission.INTERNET"};
                }
            }
            if (d2 || e2) {
                long a2 = a(context, context.getPackageName());
                long j = context.getPackageName().equals(b2) ? DiskManagerSharedPrefsUtils.DISK_CHECK_DURATION_DEFAULT : 800L;
                if (a2 == -1) {
                    throw new VivoPushException("AndroidManifest.xml中未配置sdk_version");
                }
                if (a2 != j) {
                    throw new VivoPushException("AndroidManifest.xml中sdk_version配置项错误，请配置当前sdk_version版本为:".concat(String.valueOf(j)));
                }
            }
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null) {
                    String[] strArr = packageManager.getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
                    if (strArr != null) {
                        String[] strArr2 = b;
                        int length = strArr2.length;
                        int i2 = 0;
                        while (i2 < length) {
                            String str = strArr2[i2];
                            int length2 = strArr.length;
                            while (i < length2) {
                                i = str.equals(strArr[i]) ? 0 : i + 1;
                            }
                            throw new VivoPushException("permission : " + str + "  check fail : " + Arrays.toString(strArr));
                        }
                        e(context, b2);
                        c(context, b2);
                        d(context, b2);
                        String packageName = context.getPackageName();
                        Object b3 = b(context, packageName, "com.vivo.push.api_key");
                        if (b3 != null) {
                            obj = b3.toString();
                        } else {
                            Object b4 = b(context, packageName, Constants.API_KEY);
                            obj = b4 != null ? b4.toString() : "";
                        }
                        if (!TextUtils.isEmpty(obj)) {
                            if (!TextUtils.isEmpty(b(context, context.getPackageName()))) {
                                if ((d2 || e2) && a(context, context.getPackageName()) == -1) {
                                    throw new VivoPushException("sdkversion is null");
                                }
                                if (e2) {
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
                    throw new VivoPushException("Permissions is null!");
                }
                throw new VivoPushException("localPackageManager is null");
            } catch (Exception e3) {
                throw new VivoPushException(e3.getMessage());
            }
        }
    }

    public static void d(Context context, String str) throws VivoPushException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65552, null, context, str) == null) || f.length <= 0) {
            return;
        }
        try {
            if (context.getPackageManager() != null) {
                ActivityInfo[] activityInfoArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 1).activities;
                if (activityInfoArr != null) {
                    for (String str2 : f) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65553, null, context, str) == null) {
            try {
                if (context.getPackageManager() != null) {
                    ActivityInfo[] activityInfoArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 2).receivers;
                    if (activityInfoArr != null) {
                        for (String str2 : e) {
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
    }

    public static String b(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, context, str)) == null) {
            Object b2 = b(context, str, "com.vivo.push.app_id");
            if (b2 != null) {
                return b2.toString();
            }
            Object b3 = b(context, str, "app_id");
            return b3 != null ? b3.toString() : "";
        }
        return (String) invokeLL.objValue;
    }

    public static boolean e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, context)) == null) {
            Cursor cursor = null;
            try {
                try {
                    try {
                    } catch (Throwable th) {
                        if (0 != 0) {
                            try {
                                cursor.close();
                            } catch (Exception e2) {
                                p.a("Utility", "close", e2);
                            }
                        }
                        throw th;
                    }
                } catch (Exception e3) {
                    p.a("Utility", "isSupport", e3);
                    if (0 != 0) {
                        cursor.close();
                    }
                }
            } catch (Exception e4) {
                p.a("Utility", "close", e4);
            }
            if (context == null) {
                p.a("Utility", "context is null");
                return false;
            }
            String packageName = context.getPackageName();
            Cursor query = context.getContentResolver().query(com.vivo.push.p.b, null, "pushVersion = ? and appPkgName = ? and appCode = ? ", new String[]{"800", packageName, String.valueOf(context.getPackageManager().getPackageInfo(packageName, 0).versionCode)}, null);
            if (query == null) {
                p.a("Utility", "cursor is null");
                if (query != null) {
                    try {
                        query.close();
                    } catch (Exception e5) {
                        p.a("Utility", "close", e5);
                    }
                }
                return false;
            } else if (!query.moveToFirst() || (query.getInt(query.getColumnIndex(ShareLoginStat.GetShareListStat.KEY_PERMISSION)) & 1) == 0) {
                if (query != null) {
                    query.close();
                }
                return false;
            } else {
                if (query != null) {
                    try {
                        query.close();
                    } catch (Exception e6) {
                        p.a("Utility", "close", e6);
                    }
                }
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public static Object b(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Object obj;
        Bundle bundle;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLL = interceptable.invokeLLL(65546, null, context, str, str2)) != null) {
            return invokeLLL.objValue;
        }
        if (context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Object obj2 = (g == null || g.size() <= 0 || (bundle = g.get(str)) == null) ? null : bundle.get(str2);
            if (obj2 != null) {
                return obj2;
            }
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 128);
                r0 = applicationInfo != null ? applicationInfo.metaData : null;
                obj = r0 != null ? r0.get(str2) : obj2;
            } catch (Exception e2) {
                e = e2;
                r0 = obj2;
            }
            try {
                if (g.size() <= 300) {
                    g.put(str, r0);
                    return obj;
                }
                return obj;
            } catch (Exception e3) {
                r0 = obj;
                e = e3;
                p.a("Utility", "getMetaValue::".concat(String.valueOf(e)));
                return r0;
            }
        } catch (Exception e4) {
            e = e4;
        }
    }

    public static PublicKey d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, context)) == null) {
            Cursor query = context.getContentResolver().query(com.vivo.push.p.a, null, null, null, null);
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
            p.d("Utility", "result key : ".concat(String.valueOf(string)));
            PublicKey a2 = u.a(string);
            try {
                query.close();
            } catch (Exception unused3) {
            }
            return a2;
        }
        return (PublicKey) invokeL.objValue;
    }

    public static long a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, str)) == null) {
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
        return invokeLL.longValue;
    }

    public static String b(String str, String str2) {
        String str3;
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, str, str2)) == null) {
            try {
                str3 = (String) Class.forName("android.os.SystemProperties").getMethod(SharedPreferenceManager.OPERATION_GET_PERFIX, String.class).invoke(null, str);
            } catch (Exception e2) {
                e2.printStackTrace();
                str3 = str2;
            }
            return (str3 == null || str3.length() == 0) ? str2 : str3;
        }
        return (String) invokeLL.objValue;
    }

    public static Object a(String str, String str2) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            Class<?> cls = Class.forName(str);
            return cls.getField(str2).get(cls);
        }
        return invokeLL.objValue;
    }

    public static void a(String str, ComponentInfo[] componentInfoArr, String str2) throws VivoPushException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65542, null, str, componentInfoArr, str2) == null) {
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
    }

    public static void a(ComponentInfo componentInfo, String str) throws VivoPushException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65541, null, componentInfo, str) == null) || componentInfo.applicationInfo.packageName.equals(str)) {
            return;
        }
        for (String str2 : a) {
            if (str2.equals(componentInfo.name) && !componentInfo.processName.contains(":pushservice")) {
                throw new VivoPushException("module : " + componentInfo.name + " process :" + componentInfo.processName + "  check process fail");
            }
        }
    }

    public static void a(Context context, String str, String str2, boolean z) throws VivoPushException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{context, str, str2, Boolean.valueOf(z)}) == null) {
            Intent intent = new Intent(str);
            intent.setPackage(context.getPackageName());
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    throw new VivoPushException("localPackageManager is null");
                }
                if (z) {
                    List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 576);
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
                List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 576);
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
    }

    public static void c(Context context, String str) throws VivoPushException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65550, null, context, str) == null) {
            try {
                if (context.getPackageManager() != null) {
                    ServiceInfo[] serviceInfoArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4).services;
                    if (serviceInfoArr != null) {
                        for (String str2 : d) {
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
    }

    public static void a(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, context, intent) == null) {
            String b2 = t.b(context);
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
    }

    public static boolean a(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65544, null, context, str, str2)) == null) {
            Cursor cursor = null;
            try {
                try {
                    try {
                    } catch (Throwable th) {
                        if (0 != 0) {
                            try {
                                cursor.close();
                            } catch (Exception e2) {
                                p.a("Utility", "close", e2);
                            }
                        }
                        throw th;
                    }
                } catch (Exception e3) {
                    p.a("Utility", "isOverdue", e3);
                    if (0 != 0) {
                        cursor.close();
                    }
                }
            } catch (Exception e4) {
                p.a("Utility", "close", e4);
            }
            if (context == null) {
                p.a("Utility", "context is null");
                return false;
            }
            Cursor query = context.getContentResolver().query(com.vivo.push.p.c, null, "appPkgName = ? and regId = ? sdkVersion = ? ", new String[]{str, str2, "800"}, null);
            if (query == null) {
                p.a("Utility", "cursor is null");
                if (query != null) {
                    try {
                        query.close();
                    } catch (Exception e5) {
                        p.a("Utility", "close", e5);
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
                        p.a("Utility", "close", e6);
                    }
                }
                return parseBoolean;
            }
        }
        return invokeLLL.booleanValue;
    }
}
