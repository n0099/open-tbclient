package com.vivo.push.util;

import android.content.ComponentName;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.database.Cursor;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
/* loaded from: classes10.dex */
public final class aa {
    public static /* synthetic */ Interceptable $ic;
    public static Boolean a;
    public static String b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1594687066, "Lcom/vivo/push/util/aa;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1594687066, "Lcom/vivo/push/util/aa;");
        }
    }

    public static com.vivo.push.model.b a(Context context, o oVar) {
        InterceptResult invokeLL;
        com.vivo.push.model.b f;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, oVar)) == null) {
            Context applicationContext = ContextDelegate.getContext(context).getApplicationContext();
            com.vivo.push.model.b c = c(applicationContext);
            if (c != null) {
                u.d("PushPackageUtils", "get system push info :".concat(String.valueOf(c)));
                return c;
            }
            List<String> a2 = oVar.a(applicationContext);
            com.vivo.push.model.b f2 = f(applicationContext, applicationContext.getPackageName());
            if (a2 != null && a2.size() > 0) {
                com.vivo.push.model.b bVar = null;
                String a3 = af.b(applicationContext).a("com.vivo.push.cur_pkg", null);
                com.vivo.push.model.b bVar2 = (TextUtils.isEmpty(a3) || !a(applicationContext, a3, "com.vivo.pushservice.action.METHOD") || (bVar2 = f(applicationContext, a3)) == null || !bVar2.d()) ? null : null;
                f2 = (f2 == null || !f2.d()) ? null : null;
                if (bVar2 == null) {
                    bVar2 = null;
                }
                if (f2 == null || (bVar2 != null && (!f2.c() ? !(bVar2.c() || f2.b() > bVar2.b()) : !(bVar2.c() && f2.b() > bVar2.b())))) {
                    f2 = bVar2;
                }
                HashMap hashMap = new HashMap();
                if (f2 != null) {
                    if (f2.c()) {
                        bVar = f2;
                        f2 = null;
                    }
                } else {
                    f2 = null;
                }
                int size = a2.size();
                for (int i = 0; i < size; i++) {
                    String str = a2.get(i);
                    if (!TextUtils.isEmpty(str) && (f = f(applicationContext, str)) != null) {
                        hashMap.put(str, f);
                        if (f.d()) {
                            if (f.c()) {
                                if (bVar == null || f.b() > bVar.b()) {
                                    bVar = f;
                                }
                            } else if (f2 == null || f.b() > f2.b()) {
                                f2 = f;
                            }
                        }
                    }
                }
                if (f2 == null) {
                    u.d("PushPackageUtils", "findSuitablePushPackage, all push app in balck list.");
                    f2 = bVar;
                }
            } else {
                if (f2 != null && f2.d()) {
                    c = f2;
                }
                u.a("PushPackageUtils", "findAllPushPackages error: find no package!");
                f2 = c;
            }
            if (f2 != null) {
                if (f2.c()) {
                    u.a(applicationContext, "查找最优包为:" + f2.a() + "(" + f2.b() + ", Black)");
                    u.d("PushPackageUtils", "finSuitablePushPackage" + f2.a() + "(" + f2.b() + ", Black)");
                } else {
                    u.a(applicationContext, "查找最优包为:" + f2.a() + "(" + f2.b() + SmallTailInfo.EMOTION_SUFFIX);
                    u.d("PushPackageUtils", "finSuitablePushPackage" + f2.a() + "(" + f2.b() + SmallTailInfo.EMOTION_SUFFIX);
                }
            } else {
                u.b(applicationContext, "查找最优包为空!");
                u.d("PushPackageUtils", "finSuitablePushPackage is null");
            }
            return f2;
        }
        return (com.vivo.push.model.b) invokeLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:92:0x0114 A[Catch: Exception -> 0x00f4, TRY_ENTER, TryCatch #10 {Exception -> 0x00f4, blocks: (B:75:0x00f0, B:79:0x00f8, B:81:0x00fc, B:92:0x0114, B:94:0x0119, B:96:0x011d), top: B:127:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0119 A[Catch: Exception -> 0x00f4, TryCatch #10 {Exception -> 0x00f4, blocks: (B:75:0x00f0, B:79:0x00f8, B:81:0x00fc, B:92:0x0114, B:94:0x0119, B:96:0x011d), top: B:127:0x0018 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Context context) {
        InterceptResult invokeL;
        String str;
        ContentProviderClient contentProviderClient;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (!TextUtils.isEmpty(b)) {
                return b;
            }
            Cursor cursor2 = null;
            try {
                try {
                    try {
                        if (Build.VERSION.SDK_INT >= 24) {
                            contentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(com.vivo.push.q.a);
                            if (contentProviderClient != null) {
                                try {
                                    u.a("PushPackageUtils", "client is null");
                                    cursor = contentProviderClient.query(com.vivo.push.q.a, null, null, null, null);
                                } catch (Exception e) {
                                    e = e;
                                    str = null;
                                    u.a("PushPackageUtils", "getSystemPush", e);
                                    if (cursor2 != null) {
                                        cursor2.close();
                                    }
                                    if (contentProviderClient != null && Build.VERSION.SDK_INT >= 24) {
                                        contentProviderClient.close();
                                    }
                                    return str;
                                }
                            } else {
                                cursor = null;
                            }
                        } else {
                            contentProviderClient = null;
                            cursor = null;
                        }
                        if (cursor == null) {
                            try {
                                try {
                                    cursor = context.getContentResolver().query(com.vivo.push.q.a, null, null, null, null);
                                } catch (Throwable th) {
                                    th = th;
                                    cursor2 = cursor;
                                    if (cursor2 != null) {
                                        try {
                                            cursor2.close();
                                        } catch (Exception e2) {
                                            u.a("PushPackageUtils", "close", e2);
                                            throw th;
                                        }
                                    }
                                    if (contentProviderClient != null && Build.VERSION.SDK_INT >= 24) {
                                        contentProviderClient.close();
                                    }
                                    throw th;
                                }
                            } catch (Exception e3) {
                                e = e3;
                                str = null;
                                cursor2 = cursor;
                                u.a("PushPackageUtils", "getSystemPush", e);
                                if (cursor2 != null) {
                                }
                                if (contentProviderClient != null) {
                                    contentProviderClient.close();
                                }
                                return str;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Exception e4) {
                    e = e4;
                    contentProviderClient = null;
                    str = null;
                } catch (Throwable th3) {
                    th = th3;
                    contentProviderClient = null;
                }
            } catch (Exception e5) {
                u.a("PushPackageUtils", "close", e5);
            }
            if (cursor == null) {
                u.a("PushPackageUtils", "cursor is null");
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception e6) {
                        u.a("PushPackageUtils", "close", e6);
                    }
                }
                if (contentProviderClient != null && Build.VERSION.SDK_INT >= 24) {
                    contentProviderClient.close();
                }
                return null;
            }
            boolean z = false;
            str = null;
            while (cursor.moveToNext()) {
                try {
                    if ("pushPkgName".equals(cursor.getString(cursor.getColumnIndex("name")))) {
                        str = cursor.getString(cursor.getColumnIndex("value"));
                    } else if ("pushEnable".equals(cursor.getString(cursor.getColumnIndex("name")))) {
                        z = Boolean.parseBoolean(cursor.getString(cursor.getColumnIndex("value")));
                    }
                } catch (Exception e7) {
                    e = e7;
                    cursor2 = cursor;
                    u.a("PushPackageUtils", "getSystemPush", e);
                    if (cursor2 != null) {
                    }
                    if (contentProviderClient != null) {
                    }
                    return str;
                }
            }
            b = str;
            if (TextUtils.isEmpty(str)) {
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception e8) {
                        u.a("PushPackageUtils", "close", e8);
                    }
                }
                if (contentProviderClient != null && Build.VERSION.SDK_INT >= 24) {
                    contentProviderClient.close();
                }
                return null;
            } else if (!z) {
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception e9) {
                        u.a("PushPackageUtils", "close", e9);
                    }
                }
                if (contentProviderClient != null && Build.VERSION.SDK_INT >= 24) {
                    contentProviderClient.close();
                }
                return null;
            } else {
                if (cursor != null) {
                    cursor.close();
                }
                if (contentProviderClient != null && Build.VERSION.SDK_INT >= 24) {
                    contentProviderClient.close();
                }
                return str;
            }
        }
        return (String) invokeL.objValue;
    }

    public static boolean a(Context context, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65539, null, context, j)) == null) {
            com.vivo.push.cache.d a2 = com.vivo.push.cache.b.a().a(context);
            if (a2 != null) {
                return a2.isInBlackList(j);
            }
            return false;
        }
        return invokeLJ.booleanValue;
    }

    public static int b(Context context, String str) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, context, str)) == null) {
            if (a(context, str, "com.vivo.pushservice.action.RECEIVE")) {
                i = 0;
            } else {
                i = -1;
            }
            if (a(context, str, "com.vivo.pushclient.action.RECEIVE")) {
                return 1;
            }
            return i;
        }
        return invokeLL.intValue;
    }

    public static boolean c(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, context, str)) == null) {
            return a(context, str, "com.vivo.pushclient.action.RECEIVE");
        }
        return invokeLL.booleanValue;
    }

    public static boolean d(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, context, str)) == null) {
            return a(context, str, "com.vivo.pushservice.action.RECEIVE");
        }
        return invokeLL.booleanValue;
    }

    public static boolean e(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, context, str)) == null) {
            return a(context, str, "com.vivo.pushservice.action.METHOD");
        }
        return invokeLL.booleanValue;
    }

    public static boolean a(Context context, String str) {
        InterceptResult invokeLL;
        ServiceInfo serviceInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str)) == null) {
            if (!TextUtils.isEmpty(str) && context != null) {
                Intent intent = new Intent("com.vivo.pushservice.action.PUSH_SERVICE");
                intent.setPackage(str);
                PackageManager packageManager = context.getPackageManager();
                List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 576);
                if (queryIntentServices != null && queryIntentServices.size() > 0) {
                    int size = queryIntentServices.size();
                    boolean z = false;
                    for (int i = 0; i < size; i++) {
                        ResolveInfo resolveInfo = queryIntentServices.get(i);
                        if (resolveInfo != null && (serviceInfo = resolveInfo.serviceInfo) != null) {
                            String str2 = serviceInfo.name;
                            boolean z2 = serviceInfo.exported;
                            if ("com.vivo.push.sdk.service.PushService".equals(str2) && z2) {
                                boolean z3 = resolveInfo.serviceInfo.enabled;
                                int componentEnabledSetting = packageManager.getComponentEnabledSetting(new ComponentName(str, "com.vivo.push.sdk.service.PushService"));
                                if (componentEnabledSetting != 1 && (componentEnabledSetting != 0 || !z3)) {
                                    z = false;
                                } else {
                                    z = true;
                                }
                            }
                        }
                    }
                    return z;
                }
                u.a("PushPackageUtils", "isEnablePush error: can not find push service.");
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static com.vivo.push.model.b f(Context context, String str) {
        InterceptResult invokeLL;
        boolean z;
        ApplicationInfo applicationInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, context, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                if (!a(context, str, "com.vivo.pushservice.action.METHOD") && !a(context, str, "com.vivo.pushservice.action.RECEIVE")) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    com.vivo.push.model.b bVar = new com.vivo.push.model.b(str);
                    try {
                        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 128);
                        if (packageInfo != null) {
                            bVar.a(packageInfo.versionCode);
                            bVar.a(packageInfo.versionName);
                            applicationInfo = packageInfo.applicationInfo;
                        } else {
                            applicationInfo = null;
                        }
                        if (applicationInfo != null) {
                            bVar.a(ag.a(context, str));
                        }
                        bVar.b(a(context, str));
                        bVar.a(a(context, bVar.b()));
                        return bVar;
                    } catch (Exception e) {
                        u.a("PushPackageUtils", "getPushPackageInfo exception: ", e);
                    }
                }
            }
            return null;
        }
        return (com.vivo.push.model.b) invokeLL.objValue;
    }

    public static String g(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, context, str)) == null) {
            if (!TextUtils.isEmpty(str) && context != null) {
                try {
                    byte[] digest = MessageDigest.getInstance("SHA256").digest(context.getPackageManager().getPackageInfo(str, 64).signatures[0].toByteArray());
                    StringBuffer stringBuffer = new StringBuffer();
                    for (byte b2 : digest) {
                        String upperCase = Integer.toHexString(b2 & 255).toUpperCase(Locale.US);
                        if (upperCase.length() == 1) {
                            stringBuffer.append("0");
                        }
                        stringBuffer.append(upperCase);
                    }
                    return stringBuffer.toString();
                } catch (Exception e) {
                    u.a("PushPackageUtils", " getSignatureSHA exception ".concat(String.valueOf(e)));
                }
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public static boolean a(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        List<ResolveInfo> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, context, str, str2)) == null) {
            Intent intent = new Intent(str2);
            intent.setPackage(str);
            try {
                list = context.getPackageManager().queryBroadcastReceivers(intent, 576);
            } catch (Exception unused) {
                list = null;
            }
            if (list != null && list.size() > 0) {
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public static boolean b(Context context) {
        InterceptResult invokeL;
        ProviderInfo resolveContentProvider;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            Boolean bool = a;
            if (bool != null) {
                return bool.booleanValue();
            }
            String str = null;
            if (context != null && !TextUtils.isEmpty("com.vivo.push.sdk.service.SystemPushConfig") && (resolveContentProvider = context.getPackageManager().resolveContentProvider("com.vivo.push.sdk.service.SystemPushConfig", 128)) != null) {
                str = resolveContentProvider.packageName;
            }
            Boolean valueOf = Boolean.valueOf("BCC35D4D3606F154F0402AB7634E8490C0B244C2675C3C6238986987024F0C02".equals(g(context, str)));
            a = valueOf;
            return valueOf.booleanValue();
        }
        return invokeL.booleanValue;
    }

    public static com.vivo.push.model.b c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            String a2 = a(context);
            ApplicationInfo applicationInfo = null;
            if (TextUtils.isEmpty(a2)) {
                return null;
            }
            com.vivo.push.model.b bVar = new com.vivo.push.model.b(a2);
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(a2, 128);
                if (packageInfo != null) {
                    bVar.a(packageInfo.versionCode);
                    bVar.a(packageInfo.versionName);
                    applicationInfo = packageInfo.applicationInfo;
                }
                if (applicationInfo != null) {
                    bVar.a(ag.a(context, a2));
                }
                bVar.a(a(context, bVar.b()));
                bVar.b(a(context, a2));
                return bVar;
            } catch (Exception e) {
                e.printStackTrace();
                u.b("PushPackageUtils", "PackageManager NameNotFoundException is null", e);
                return null;
            }
        }
        return (com.vivo.push.model.b) invokeL.objValue;
    }
}
