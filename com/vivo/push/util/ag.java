package com.vivo.push.util;

import android.content.ContentProviderClient;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.sapi2.stat.ShareLoginStat;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.huawei.hms.framework.network.grs.local.model.CountryCodeBean;
import java.security.PublicKey;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes10.dex */
public final class ag {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1594687252, "Lcom/vivo/push/util/ag;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1594687252, "Lcom/vivo/push/util/ag;");
                return;
            }
        }
        a = new String[]{"com.vivo.push.sdk.RegistrationReceiver", "com.vivo.push.sdk.service.PushService", "com.vivo.push.sdk.service.CommonJobService"};
        b = new String[]{com.kuaishou.weapon.p0.g.a, "android.permission.ACCESS_NETWORK_STATE", "android.permission.WRITE_SETTINGS", "android.permission.VIBRATE", com.kuaishou.weapon.p0.g.d, "android.permission.WAKE_LOCK", "com.bbk.account.permission.READ_ACCOUNTINFO", "android.permission.AUTHENTICATE_ACCOUNTS", "android.permission.MOUNT_UNMOUNT_FILESYSTEMS", com.kuaishou.weapon.p0.g.e};
        c = new String[]{"com.vivo.push.sdk.service.CommandService", "com.vivo.push.sdk.service.CommonJobService"};
        d = new String[]{"com.vivo.push.sdk.RegistrationReceiver"};
        e = new String[0];
        f = new ConcurrentHashMap();
    }

    public static long a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            String a2 = aa.a(context);
            if (TextUtils.isEmpty(a2)) {
                u.a("Utility", "systemPushPkgName is null");
                return -1L;
            }
            return a(context, a2);
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
                    u.a("Utility", "getSdkVersionCode error ", e2);
                    return -1L;
                }
            }
            u.a("Utility", "getSdkVersionCode sdk version is null");
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
                str3 = (String) Class.forName(CountryCodeBean.ANDRIOD_SYSTEMPROP).getMethod(CommandUBCHelper.COMMAND_UBC_SOURCE_RECEIVE, String.class).invoke(null, str);
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
                    u.a("Utility", "getMetaValue::".concat(String.valueOf(e)));
                    return bundle2;
                }
            } catch (Exception e4) {
                e = e4;
            }
        } else {
            return invokeLLL.objValue;
        }
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
            Object a2 = a(context, str, "verification_status");
            if (a2 != null) {
                return a2.toString();
            }
            return "";
        }
        return (String) invokeLL.objValue;
    }

    public static int c(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, context, str)) == null) {
            if (context != null && !TextUtils.isEmpty(str)) {
                int a2 = (int) a(context, str);
                if (a2 <= 0) {
                    return g(context, str);
                }
                return a2;
            }
            u.a("Utility", "getClientSdkVersionCode() error, context is null or pkgName is empty");
            return 0;
        }
        return invokeLL.intValue;
    }

    public static void a(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, context, intent) == null) {
            String a2 = aa.a(context);
            String stringExtra = intent.getStringExtra("client_pkgname");
            if (TextUtils.isEmpty(a2)) {
                u.a("Utility", "illegality abe adapter : push pkg is null");
            } else if (TextUtils.isEmpty(stringExtra)) {
                u.a("Utility", "illegality abe adapter : src pkg is null");
            } else if (a2.equals(context.getPackageName())) {
                u.a("Utility", "illegality abe adapter : abe is not pushservice");
            } else if (!a2.equals(stringExtra)) {
                u.d("Utility", "proxy to core : intent pkg : " + intent.getPackage() + " ; src pkg : " + stringExtra + " ; push pkg : " + a2);
                intent.setPackage(a2);
                intent.setClassName(a2, "com.vivo.push.sdk.service.PushService");
                context.startService(intent);
            } else {
                u.a("Utility", "illegality abe adapter : pushPkg = " + a2 + " ; srcPkg = " + stringExtra);
            }
        }
    }

    public static void e(Context context, String str) throws VivoPushException {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65552, null, context, str) != null) || e.length <= 0) {
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
                u.a("Utility", "error  " + e2.getMessage());
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
        if (interceptable == null || interceptable.invokeLL(65550, null, context, str) == null) {
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
        if (interceptable == null || interceptable.invokeLL(65553, null, context, str) == null) {
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

    /* JADX WARN: Removed duplicated region for block: B:19:0x0035 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0036 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int g(Context context, String str) {
        InterceptResult invokeLL;
        String obj;
        int intValue;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65554, null, context, str)) == null) {
            if (context != null && !TextUtils.isEmpty(str)) {
                Object a2 = a(context, str, "sdk_version_vivo");
                if (a2 instanceof String) {
                    obj = (String) a2;
                } else if (a2 instanceof Integer) {
                    intValue = ((Integer) a2).intValue();
                    str2 = "";
                    if (intValue <= 0) {
                        return intValue;
                    }
                    try {
                        return Integer.parseInt(str2);
                    } catch (Exception e2) {
                        u.a("Utility", "getClientSdkVersion: ".concat(String.valueOf(e2)));
                        return 0;
                    }
                } else if (a2 == null) {
                    return 0;
                } else {
                    obj = a2.toString();
                }
                str2 = obj;
                intValue = 0;
                if (intValue <= 0) {
                }
            } else {
                u.a("Utility", "getClientSdkVersion() error, context is null or pkgName is empty");
                return 0;
            }
        } else {
            return invokeLL.intValue;
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

    /* JADX WARN: Code restructure failed: missing block: B:44:0x0101, code lost:
        r12 = r12 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void b(Context context) throws VivoPushException {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, context) == null) {
            u.d("Utility", "check PushService AndroidManifest declearation !");
            String a2 = aa.a(context);
            boolean d2 = aa.d(context, context.getPackageName());
            boolean e2 = aa.e(context, context.getPackageName());
            boolean c2 = aa.c(context, context.getPackageName());
            if (e2) {
                a = new String[]{"com.vivo.push.sdk.RegistrationReceiver", "com.vivo.push.sdk.service.PushService", "com.vivo.push.sdk.service.CommonJobService"};
                b = new String[]{com.kuaishou.weapon.p0.g.a, "android.permission.ACCESS_NETWORK_STATE", "android.permission.WRITE_SETTINGS", "android.permission.VIBRATE", com.kuaishou.weapon.p0.g.d, "android.permission.WAKE_LOCK", "com.bbk.account.permission.READ_ACCOUNTINFO", "android.permission.AUTHENTICATE_ACCOUNTS", "android.permission.MOUNT_UNMOUNT_FILESYSTEMS", com.kuaishou.weapon.p0.g.e};
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
                    b = new String[]{com.kuaishou.weapon.p0.g.a, "android.permission.WRITE_SETTINGS"};
                } else {
                    b = new String[]{com.kuaishou.weapon.p0.g.a};
                }
            }
            if (d2) {
                long a3 = a(context, context.getPackageName());
                long j = 334;
                if (context.getPackageName().equals(a2)) {
                    j = 1334;
                }
                if (a3 != -1) {
                    if (a3 != j) {
                        throw new VivoPushException("AndroidManifest.xml中sdk_version配置项错误，请配置当前sdk_version版本为:".concat(String.valueOf(j)));
                    }
                } else {
                    throw new VivoPushException("AndroidManifest.xml中未配置sdk_version");
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
                        f(context, a2);
                        d(context, a2);
                        e(context, a2);
                        try {
                            if (a(context, context.getPackageName(), "local_iv") != null) {
                                String packageName = context.getPackageName();
                                Object a4 = a(context, packageName, "com.vivo.push.api_key");
                                String str4 = "";
                                if (a4 != null) {
                                    str = a4.toString();
                                } else {
                                    Object a5 = a(context, packageName, "api_key");
                                    if (a5 == null) {
                                        str = "";
                                    } else {
                                        str = a5.toString();
                                    }
                                }
                                if (!TextUtils.isEmpty(str)) {
                                    String packageName2 = context.getPackageName();
                                    Object a6 = a(context, packageName2, "com.vivo.push.app_id");
                                    if (a6 != null) {
                                        str4 = a6.toString();
                                    } else {
                                        Object a7 = a(context, packageName2, "app_id");
                                        if (a7 != null) {
                                            str4 = a7.toString();
                                        }
                                    }
                                    if (!TextUtils.isEmpty(str4)) {
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

    /* JADX WARN: Code restructure failed: missing block: B:47:0x00a5, code lost:
        if (android.os.Build.VERSION.SDK_INT >= 24) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00a7, code lost:
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00bd, code lost:
        if (android.os.Build.VERSION.SDK_INT >= 24) goto L49;
     */
    /* JADX WARN: Not initialized variable reg: 4, insn: 0x00c2: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:63:0x00c2 */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00b6 A[Catch: Exception -> 0x00c0, TRY_ENTER, TryCatch #0 {Exception -> 0x00c0, blocks: (B:44:0x009e, B:46:0x00a3, B:48:0x00a7, B:56:0x00b6, B:58:0x00bb), top: B:79:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00bb A[Catch: Exception -> 0x00c0, TRY_LEAVE, TryCatch #0 {Exception -> 0x00c0, blocks: (B:44:0x009e, B:46:0x00a3, B:48:0x00a7, B:56:0x00b6, B:58:0x00bb), top: B:79:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static PublicKey c(Context context) {
        InterceptResult invokeL;
        Cursor cursor;
        ContentProviderClient contentProviderClient;
        Cursor cursor2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, context)) == null) {
            Cursor cursor3 = null;
            try {
                try {
                    try {
                        if (Build.VERSION.SDK_INT >= 24) {
                            contentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(com.vivo.push.q.a);
                            if (contentProviderClient != null) {
                                try {
                                    u.a("Utility", "client is null");
                                    cursor2 = contentProviderClient.query(com.vivo.push.q.a, null, null, null, null);
                                } catch (Exception e2) {
                                    e = e2;
                                    cursor2 = null;
                                    e.printStackTrace();
                                    if (cursor2 != null) {
                                    }
                                    if (contentProviderClient != null) {
                                    }
                                    return null;
                                } catch (Throwable th) {
                                    th = th;
                                    if (cursor3 != null) {
                                        try {
                                            cursor3.close();
                                        } catch (Exception unused) {
                                            throw th;
                                        }
                                    }
                                    if (contentProviderClient != null && Build.VERSION.SDK_INT >= 24) {
                                        contentProviderClient.close();
                                    }
                                    throw th;
                                }
                            } else {
                                cursor2 = null;
                            }
                        } else {
                            contentProviderClient = null;
                            cursor2 = null;
                        }
                        if (cursor2 == null) {
                            try {
                                cursor2 = context.getContentResolver().query(com.vivo.push.q.a, null, null, null, null);
                            } catch (Exception e3) {
                                e = e3;
                                e.printStackTrace();
                                if (cursor2 != null) {
                                    cursor2.close();
                                }
                                if (contentProviderClient != null) {
                                }
                                return null;
                            }
                        }
                    } catch (Exception unused2) {
                    }
                } catch (Exception e4) {
                    e = e4;
                    contentProviderClient = null;
                    cursor2 = null;
                } catch (Throwable th2) {
                    th = th2;
                    contentProviderClient = null;
                }
                if (cursor2 == null) {
                    if (cursor2 != null) {
                        try {
                            cursor2.close();
                        } catch (Exception unused3) {
                        }
                    }
                    if (contentProviderClient != null && Build.VERSION.SDK_INT >= 24) {
                        contentProviderClient.close();
                    }
                    return null;
                }
                while (cursor2.moveToNext()) {
                    if ("pushkey".equals(cursor2.getString(cursor2.getColumnIndex("name")))) {
                        String string = cursor2.getString(cursor2.getColumnIndex("value"));
                        u.d("Utility", "result key : ".concat(String.valueOf(string)));
                        PublicKey a2 = ab.a(string);
                        if (cursor2 != null) {
                            try {
                                cursor2.close();
                            } catch (Exception unused4) {
                            }
                        }
                        if (contentProviderClient != null && Build.VERSION.SDK_INT >= 24) {
                            contentProviderClient.close();
                        }
                        return a2;
                    }
                }
                if (cursor2 != null) {
                    cursor2.close();
                }
                if (contentProviderClient != null) {
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                cursor3 = cursor;
            }
        } else {
            return (PublicKey) invokeL.objValue;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:15:0x0058 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00f6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.content.ContentProviderClient, android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean d(Context context) {
        InterceptResult invokeL;
        Throwable th;
        ContentProviderClient contentProviderClient;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, context)) == null) {
            Cursor cursor = 0;
            cursor = 0;
            try {
                try {
                    try {
                    } catch (Throwable th2) {
                        th = th2;
                        if (0 != 0) {
                            try {
                                cursor.close();
                            } catch (Exception e2) {
                                u.a("Utility", "close", e2);
                                throw th;
                            }
                        }
                        if (0 != 0 && Build.VERSION.SDK_INT >= 24) {
                            cursor.close();
                        }
                        throw th;
                    }
                } catch (Exception e3) {
                    u.a("Utility", "close", e3);
                }
            } catch (Exception e4) {
                e = e4;
                contentProviderClient = null;
            } catch (Throwable th3) {
                th = th3;
                if (0 != 0) {
                }
                if (0 != 0) {
                    cursor.close();
                }
                throw th;
            }
            if (context == null) {
                u.a("Utility", "context is null");
                return false;
            }
            String packageName = context.getPackageName();
            int i = context.getPackageManager().getPackageInfo(packageName, 0).versionCode;
            if (Build.VERSION.SDK_INT >= 24) {
                contentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(com.vivo.push.q.b);
                if (contentProviderClient != null) {
                    try {
                        u.a("Utility", "client is null");
                        cursor = contentProviderClient.query(com.vivo.push.q.b, null, "pushVersion = ? and appPkgName = ? and appCode = ? ", new String[]{"334", packageName, String.valueOf(i)}, null);
                    } catch (Exception e5) {
                        e = e5;
                        u.a("Utility", "isSupport", e);
                        if (0 != 0) {
                            cursor.close();
                        }
                        if (contentProviderClient != null && Build.VERSION.SDK_INT >= 24) {
                            contentProviderClient.close();
                        }
                        return false;
                    }
                }
            } else {
                contentProviderClient = null;
            }
            if (cursor == 0) {
                cursor = context.getContentResolver().query(com.vivo.push.q.b, null, "pushVersion = ? and appPkgName = ? and appCode = ? ", new String[]{"334", packageName, String.valueOf(i)}, null);
            }
            if (cursor == 0) {
                u.a("Utility", "cursor is null");
                if (cursor != 0) {
                    try {
                        cursor.close();
                    } catch (Exception e6) {
                        u.a("Utility", "close", e6);
                    }
                }
                if (contentProviderClient != null && Build.VERSION.SDK_INT >= 24) {
                    contentProviderClient.close();
                }
                return false;
            } else if (cursor.moveToFirst() && (cursor.getInt(cursor.getColumnIndex(ShareLoginStat.GetShareListStat.KEY_PERMISSION)) & 1) != 0) {
                if (cursor != 0) {
                    try {
                        cursor.close();
                    } catch (Exception e7) {
                        u.a("Utility", "close", e7);
                    }
                }
                if (contentProviderClient != null && Build.VERSION.SDK_INT >= 24) {
                    contentProviderClient.close();
                }
                return true;
            } else {
                if (cursor != 0) {
                    cursor.close();
                }
                if (contentProviderClient != null && Build.VERSION.SDK_INT >= 24) {
                    contentProviderClient.close();
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }
}
