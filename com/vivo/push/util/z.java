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
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.webkit.internal.utils.ZeusInitConfigUtils;
import com.bumptech.glide.manager.DefaultConnectivityMonitorFactory;
import com.bytedance.sdk.component.net.utils.ProcessUtils;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import java.security.PublicKey;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public final class z {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static String[] f42271a;

    /* renamed from: b  reason: collision with root package name */
    public static String[] f42272b;

    /* renamed from: c  reason: collision with root package name */
    public static Boolean f42273c;

    /* renamed from: d  reason: collision with root package name */
    public static String[] f42274d;

    /* renamed from: e  reason: collision with root package name */
    public static String[] f42275e;

    /* renamed from: f  reason: collision with root package name */
    public static String[] f42276f;
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
        f42271a = new String[]{"com.vivo.push.sdk.RegistrationReceiver", "com.vivo.push.sdk.service.PushService", "com.vivo.push.sdk.service.CommonJobService"};
        f42272b = new String[]{"android.permission.INTERNET", "android.permission.READ_PHONE_STATE", DefaultConnectivityMonitorFactory.NETWORK_PERMISSION, "android.permission.WRITE_SETTINGS", "android.permission.VIBRATE", StorageUtils.EXTERNAL_STORAGE_PERMISSION, "android.permission.ACCESS_WIFI_STATE", "android.permission.WAKE_LOCK", "android.permission.GET_ACCOUNTS", "com.bbk.account.permission.READ_ACCOUNTINFO", "android.permission.AUTHENTICATE_ACCOUNTS", "android.permission.MOUNT_UNMOUNT_FILESYSTEMS", "android.permission.GET_TASKS"};
        f42274d = new String[]{"com.vivo.push.sdk.service.CommandService", "com.vivo.push.sdk.service.CommonJobService"};
        f42275e = new String[]{"com.vivo.push.sdk.RegistrationReceiver"};
        f42276f = new String[0];
    }

    public static boolean a(Context context) {
        InterceptResult invokeL;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            Boolean bool = f42273c;
            if (bool != null) {
                return bool.booleanValue();
            }
            String b2 = s.b(context);
            if (context != null && context.getPackageName().equals(b2)) {
                f42273c = Boolean.TRUE;
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
                Boolean valueOf = Boolean.valueOf(str.contains(ProcessUtils.MESSAGE_PROCESS_SERVICE_SUFFIX));
                f42273c = valueOf;
                return valueOf.booleanValue();
            }
        }
        return invokeL.booleanValue;
    }

    public static long b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            String b2 = s.b(context);
            if (TextUtils.isEmpty(b2)) {
                p.a("Utility", "systemPushPkgName is null");
                return -1L;
            }
            return a(context, b2);
        }
        return invokeL.longValue;
    }

    public static void c(Context context) throws VivoPushException {
        String obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, context) == null) {
            p.d("Utility", "check PushService AndroidManifest declearation !");
            String b2 = s.b(context);
            boolean c2 = s.c(context, context.getPackageName());
            boolean d2 = s.d(context, context.getPackageName());
            boolean b3 = s.b(context, context.getPackageName());
            if (d2) {
                f42271a = new String[]{"com.vivo.push.sdk.RegistrationReceiver", "com.vivo.push.sdk.service.PushService", "com.vivo.push.sdk.service.CommonJobService"};
                f42272b = new String[]{"android.permission.INTERNET", "android.permission.READ_PHONE_STATE", DefaultConnectivityMonitorFactory.NETWORK_PERMISSION, "android.permission.WRITE_SETTINGS", "android.permission.VIBRATE", StorageUtils.EXTERNAL_STORAGE_PERMISSION, "android.permission.ACCESS_WIFI_STATE", "android.permission.WAKE_LOCK", "android.permission.GET_ACCOUNTS", "com.bbk.account.permission.READ_ACCOUNTINFO", "android.permission.AUTHENTICATE_ACCOUNTS", "android.permission.MOUNT_UNMOUNT_FILESYSTEMS", "android.permission.GET_TASKS"};
                f42274d = new String[]{"com.vivo.push.sdk.service.CommandService", "com.vivo.push.sdk.service.CommonJobService"};
                f42275e = new String[]{"com.vivo.push.sdk.RegistrationReceiver"};
            } else if (!b3 && !c2) {
                throw new VivoPushException("AndroidManifest.xml中receiver配置项错误，详见接入文档");
            } else {
                if (b3) {
                    f42274d = new String[]{"com.vivo.push.sdk.service.CommandClientService"};
                } else {
                    f42274d = new String[]{"com.vivo.push.sdk.service.CommandService"};
                }
                f42275e = new String[0];
                f42271a = new String[0];
                if (c2) {
                    f42272b = new String[]{"android.permission.INTERNET", "android.permission.WRITE_SETTINGS"};
                } else {
                    f42272b = new String[]{"android.permission.INTERNET"};
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
    }

    public static void d(Context context, String str) throws VivoPushException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65552, null, context, str) == null) || f42276f.length <= 0) {
            return;
        }
        try {
            if (context.getPackageManager() != null) {
                ActivityInfo[] activityInfoArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 1).activities;
                if (activityInfoArr != null) {
                    for (String str2 : f42276f) {
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
                        for (String str2 : f42275e) {
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

    /* JADX WARN: Removed duplicated region for block: B:65:0x007e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Map<String, String> f(Context context) {
        InterceptResult invokeL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65555, null, context)) != null) {
            return (Map) invokeL.objValue;
        }
        Cursor cursor2 = null;
        try {
            if (context == null) {
                p.a("Utility", "getDebugInfo error : context is null");
                return null;
            }
            Cursor query = context.getContentResolver().query(com.vivo.push.z.f42288d, null, null, null, null);
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

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0030, code lost:
        r3 = r3 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void g(Context context) throws VivoPushException {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65556, null, context) == null) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null) {
                    String[] strArr = packageManager.getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
                    if (strArr != null) {
                        String[] strArr2 = f42272b;
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
                                p.a("Utility", IntentConfig.CLOSE, e2);
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
                p.a("Utility", IntentConfig.CLOSE, e4);
            }
            if (context == null) {
                p.a("Utility", "context is null");
                return false;
            }
            String packageName = context.getPackageName();
            Cursor query = context.getContentResolver().query(com.vivo.push.z.f42286b, null, "pushVersion = ? and appPkgName = ? and appCode = ? ", new String[]{"293", packageName, String.valueOf(context.getPackageManager().getPackageInfo(packageName, 0).versionCode)}, null);
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
        return invokeL.booleanValue;
    }

    public static Object b(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Bundle bundle;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65546, null, context, str, str2)) == null) {
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
        return invokeLLL.objValue;
    }

    public static PublicKey d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, context)) == null) {
            Cursor query = context.getContentResolver().query(com.vivo.push.z.f42285a, null, null, null, null);
            if (query == null) {
                return null;
            }
            do {
                try {
                    try {
                        if (query.moveToNext()) {
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    try {
                        query.close();
                    } catch (Exception unused) {
                        return null;
                    }
                } catch (Throwable th) {
                    try {
                        query.close();
                    } catch (Exception unused2) {
                    }
                    throw th;
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
        return (PublicKey) invokeL.objValue;
    }

    public static String b(String str, String str2) {
        String str3;
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, str, str2)) == null) {
            try {
                str3 = (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, str);
            } catch (Exception e2) {
                e2.printStackTrace();
                str3 = str2;
            }
            return (str3 == null || str3.length() == 0) ? str2 : str3;
        }
        return (String) invokeLL.objValue;
    }

    public static long a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, str)) == null) {
            Object b2 = b(context, str, "com.vivo.push.sdk_version");
            if (b2 == null) {
                b2 = b(context, str, ZeusInitConfigUtils.PREF_KEY_SDK_VERSION);
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
        if (interceptable == null || interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, null, str, componentInfoArr, str2) == null) {
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
        if (!(interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, componentInfo, str) == null) || componentInfo.applicationInfo.packageName.equals(str)) {
            return;
        }
        for (String str2 : f42271a) {
            if (str2.equals(componentInfo.name) && !componentInfo.processName.contains(ProcessUtils.MESSAGE_PROCESS_SERVICE_SUFFIX)) {
                throw new VivoPushException("module : " + componentInfo.name + " process :" + componentInfo.processName + "  check process fail");
            }
        }
    }

    public static void a(Context context, String str, String str2, boolean z) throws VivoPushException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65540, null, new Object[]{context, str, str2, Boolean.valueOf(z)}) == null) {
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
    }

    public static void c(Context context, String str) throws VivoPushException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65550, null, context, str) == null) {
            try {
                if (context.getPackageManager() != null) {
                    ServiceInfo[] serviceInfoArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4).services;
                    if (serviceInfoArr != null) {
                        for (String str2 : f42274d) {
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
                                p.a("Utility", IntentConfig.CLOSE, e2);
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
                p.a("Utility", IntentConfig.CLOSE, e4);
            }
            if (context == null) {
                p.a("Utility", "context is null");
                return false;
            }
            Cursor query = context.getContentResolver().query(com.vivo.push.z.f42287c, null, "appPkgName = ? and regId = ? sdkVersion = ? ", new String[]{str, str2, "293"}, null);
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
        return invokeLLL.booleanValue;
    }
}
