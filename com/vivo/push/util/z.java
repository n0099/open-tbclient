package com.vivo.push.util;

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
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.stat.ShareLoginStat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.security.PublicKey;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes8.dex */
public final class z {
    public static /* synthetic */ Interceptable $ic;
    public static String[] a;
    public static String[] b;
    public static String[] c;
    public static String[] d;
    public static String[] e;
    public static Map<String, Bundle> f;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(744178914, "Lcom/vivo/push/util/z;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(744178914, "Lcom/vivo/push/util/z;");
                return;
            }
        }
        a = new String[]{"com.vivo.push.sdk.RegistrationReceiver", "com.vivo.push.sdk.service.PushService", "com.vivo.push.sdk.service.CommonJobService"};
        b = new String[]{com.kuaishou.weapon.p0.h.a, com.kuaishou.weapon.p0.h.c, "android.permission.ACCESS_NETWORK_STATE", "android.permission.WRITE_SETTINGS", "android.permission.VIBRATE", "android.permission.WRITE_EXTERNAL_STORAGE", com.kuaishou.weapon.p0.h.d, "android.permission.WAKE_LOCK", com.kuaishou.weapon.p0.h.f, "com.bbk.account.permission.READ_ACCOUNTINFO", "android.permission.AUTHENTICATE_ACCOUNTS", "android.permission.MOUNT_UNMOUNT_FILESYSTEMS", com.kuaishou.weapon.p0.h.e};
        c = new String[]{"com.vivo.push.sdk.service.CommandService", "com.vivo.push.sdk.service.CommonJobService"};
        d = new String[]{"com.vivo.push.sdk.RegistrationReceiver"};
        e = new String[0];
        f = new ConcurrentHashMap();
    }

    public static long a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            String b2 = t.b(context);
            if (TextUtils.isEmpty(b2)) {
                p.a("Utility", "systemPushPkgName is null");
                return -1L;
            }
            return a(context, b2);
        }
        return invokeL.longValue;
    }

    public static long a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            Object a2 = a(context, str, "com.vivo.push.sdk_version");
            if (a2 == null) {
                a2 = a(context, str, "sdk_version");
            }
            if (a2 != null) {
                try {
                    return Long.parseLong(a2.toString());
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
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, str, str2)) == null) {
            try {
                str3 = (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, str);
            } catch (Exception e2) {
                e2.printStackTrace();
                str3 = str2;
            }
            if (str3 != null && str3.length() != 0) {
                return str3;
            }
            return str2;
        }
        return (String) invokeLL.objValue;
    }

    public static Object a(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Object obj;
        Object obj2;
        Bundle bundle;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, context, str, str2)) == null) {
            Bundle bundle2 = null;
            if (context == null || str2 == null || TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                if (f != null && f.size() > 0 && (bundle = f.get(str)) != null) {
                    obj = bundle.get(str2);
                } else {
                    obj = null;
                }
                if (obj != null) {
                    return obj;
                }
                try {
                    ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 128);
                    if (applicationInfo != null) {
                        bundle2 = applicationInfo.metaData;
                    }
                    if (bundle2 != null) {
                        obj2 = bundle2.get(str2);
                    } else {
                        obj2 = obj;
                    }
                } catch (Exception e2) {
                    e = e2;
                    bundle2 = obj;
                }
                try {
                    if (f.size() <= 300) {
                        f.put(str, bundle2);
                        return obj2;
                    }
                    return obj2;
                } catch (Exception e3) {
                    bundle2 = obj2;
                    e = e3;
                    p.a("Utility", "getMetaValue::".concat(String.valueOf(e)));
                    return bundle2;
                }
            } catch (Exception e4) {
                e = e4;
            }
        } else {
            return invokeLLL.objValue;
        }
    }

    public static boolean b(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65548, null, context, str, str2)) == null) {
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
            Cursor query = context.getContentResolver().query(com.vivo.push.p.c, null, "appPkgName = ? and regId = ? sdkVersion = ? ", new String[]{str, str2, "323"}, null);
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
            } else if (query.moveToFirst()) {
                boolean parseBoolean = Boolean.parseBoolean(query.getString(query.getColumnIndex("clientState")));
                if (query != null) {
                    try {
                        query.close();
                    } catch (Exception e6) {
                        p.a("Utility", "close", e6);
                    }
                }
                return parseBoolean;
            } else {
                if (query != null) {
                    query.close();
                }
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    public static Object a(String str, String str2) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2)) == null) {
            Class<?> cls = Class.forName(str);
            return cls.getField(str2).get(cls);
        }
        return invokeLL.objValue;
    }

    public static String b(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, context, str)) == null) {
            Object a2 = a(context, str, "com.vivo.push.app_id");
            if (a2 != null) {
                return a2.toString();
            }
            Object a3 = a(context, str, "app_id");
            if (a3 != null) {
                return a3.toString();
            }
            return "";
        }
        return (String) invokeLL.objValue;
    }

    public static String c(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, context, str)) == null) {
            Object a2 = a(context, str, "verification_status");
            if (a2 != null) {
                return a2.toString();
            }
            return "";
        }
        return (String) invokeLL.objValue;
    }

    public static void a(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, context, intent) == null) {
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

    public static void e(Context context, String str) throws VivoPushException {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65553, null, context, str) != null) || e.length <= 0) {
            return;
        }
        try {
            if (context.getPackageManager() != null) {
                ActivityInfo[] activityInfoArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 1).activities;
                if (activityInfoArr != null) {
                    for (String str2 : e) {
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

    public static void a(Context context, String str, String str2, boolean z) throws VivoPushException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{context, str, str2, Boolean.valueOf(z)}) == null) {
            Intent intent = new Intent(str);
            intent.setPackage(context.getPackageName());
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null) {
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
                }
                throw new VivoPushException("localPackageManager is null");
            } catch (Exception e2) {
                p.a("Utility", "error  " + e2.getMessage());
                throw new VivoPushException("checkModule error" + e2.getMessage());
            }
        }
    }

    public static void a(ComponentInfo componentInfo, String str) throws VivoPushException {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65543, null, componentInfo, str) != null) || componentInfo.applicationInfo.packageName.equals(str)) {
            return;
        }
        for (String str2 : a) {
            if (str2.equals(componentInfo.name) && !componentInfo.processName.contains(":pushservice")) {
                throw new VivoPushException("module : " + componentInfo.name + " process :" + componentInfo.processName + "  check process fail");
            }
        }
    }

    public static void d(Context context, String str) throws VivoPushException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65551, null, context, str) == null) {
            try {
                if (context.getPackageManager() != null) {
                    ServiceInfo[] serviceInfoArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4).services;
                    if (serviceInfoArr != null) {
                        for (String str2 : c) {
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

    public static void f(Context context, String str) throws VivoPushException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65554, null, context, str) == null) {
            try {
                if (context.getPackageManager() != null) {
                    ActivityInfo[] activityInfoArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 2).receivers;
                    if (activityInfoArr != null) {
                        for (String str2 : d) {
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

    public static void a(String str, ComponentInfo[] componentInfoArr, String str2) throws VivoPushException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65544, null, str, componentInfoArr, str2) == null) {
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

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00cb, code lost:
        r10 = r10 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void b(Context context) throws VivoPushException {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, context) == null) {
            p.d("Utility", "check PushService AndroidManifest declearation !");
            String b2 = t.b(context);
            boolean d2 = t.d(context, context.getPackageName());
            boolean e2 = t.e(context, context.getPackageName());
            boolean c2 = t.c(context, context.getPackageName());
            if (e2) {
                a = new String[]{"com.vivo.push.sdk.RegistrationReceiver", "com.vivo.push.sdk.service.PushService", "com.vivo.push.sdk.service.CommonJobService"};
                b = new String[]{com.kuaishou.weapon.p0.h.a, com.kuaishou.weapon.p0.h.c, "android.permission.ACCESS_NETWORK_STATE", "android.permission.WRITE_SETTINGS", "android.permission.VIBRATE", "android.permission.WRITE_EXTERNAL_STORAGE", com.kuaishou.weapon.p0.h.d, "android.permission.WAKE_LOCK", com.kuaishou.weapon.p0.h.f, "com.bbk.account.permission.READ_ACCOUNTINFO", "android.permission.AUTHENTICATE_ACCOUNTS", "android.permission.MOUNT_UNMOUNT_FILESYSTEMS", com.kuaishou.weapon.p0.h.e};
                c = new String[]{"com.vivo.push.sdk.service.CommandService", "com.vivo.push.sdk.service.CommonJobService"};
                d = new String[]{"com.vivo.push.sdk.RegistrationReceiver"};
            } else if (!c2 && !d2) {
                throw new VivoPushException("AndroidManifest.xml中receiver配置项错误，详见接入文档");
            } else {
                if (c2) {
                    c = new String[]{"com.vivo.push.sdk.service.CommandClientService"};
                } else {
                    c = new String[]{"com.vivo.push.sdk.service.CommandService"};
                }
                d = new String[0];
                a = new String[0];
                if (d2) {
                    b = new String[]{com.kuaishou.weapon.p0.h.a, "android.permission.WRITE_SETTINGS"};
                } else {
                    b = new String[]{com.kuaishou.weapon.p0.h.a};
                }
            }
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null) {
                    String[] strArr = packageManager.getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
                    if (strArr != null) {
                        String[] strArr2 = b;
                        int length = strArr2.length;
                        int i = 0;
                        while (i < length) {
                            String str2 = strArr2[i];
                            for (String str3 : strArr) {
                                if (!str2.equals(str3)) {
                                }
                            }
                            throw new VivoPushException("permission : " + str2 + "  check fail : " + Arrays.toString(strArr));
                        }
                        f(context, b2);
                        d(context, b2);
                        e(context, b2);
                        try {
                            if (a(context, context.getPackageName(), "local_iv") != null) {
                                String packageName = context.getPackageName();
                                Object a2 = a(context, packageName, "com.vivo.push.api_key");
                                if (a2 != null) {
                                    str = a2.toString();
                                } else {
                                    Object a3 = a(context, packageName, Constants.API_KEY);
                                    if (a3 != null) {
                                        str = a3.toString();
                                    } else {
                                        str = "";
                                    }
                                }
                                if (!TextUtils.isEmpty(str)) {
                                    if (!TextUtils.isEmpty(b(context, context.getPackageName()))) {
                                        if ((!d2 && !e2) || a(context, context.getPackageName()) != -1) {
                                            if (e2) {
                                                a(context, "com.vivo.pushservice.action.METHOD", "com.vivo.push.sdk.RegistrationReceiver", true);
                                                a(context, "com.vivo.pushservice.action.PUSH_SERVICE", "com.vivo.push.sdk.service.PushService", false);
                                                return;
                                            }
                                            return;
                                        }
                                        throw new VivoPushException("sdkversion is null");
                                    }
                                    throw new VivoPushException("com.vivo.push.app_id is null");
                                }
                                throw new VivoPushException("com.vivo.push.api_key is null");
                            }
                            throw new VivoPushException("AndroidManifest.xml中未配置".concat("local_iv"));
                        } catch (Exception e3) {
                            throw new VivoPushException("getMetaValue error " + e3.getMessage());
                        }
                    }
                    throw new VivoPushException("Permissions is null!");
                }
                throw new VivoPushException("localPackageManager is null");
            } catch (Exception e4) {
                throw new VivoPushException(e4.getMessage());
            }
        }
    }

    public static PublicKey c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, context)) == null) {
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

    public static boolean d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, context)) == null) {
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
            Cursor query = context.getContentResolver().query(com.vivo.push.p.b, null, "pushVersion = ? and appPkgName = ? and appCode = ? ", new String[]{"323", packageName, String.valueOf(context.getPackageManager().getPackageInfo(packageName, 0).versionCode)}, null);
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
            } else if (query.moveToFirst() && (query.getInt(query.getColumnIndex(ShareLoginStat.GetShareListStat.KEY_PERMISSION)) & 1) != 0) {
                if (query != null) {
                    try {
                        query.close();
                    } catch (Exception e6) {
                        p.a("Utility", "close", e6);
                    }
                }
                return true;
            } else {
                if (query != null) {
                    query.close();
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }
}
