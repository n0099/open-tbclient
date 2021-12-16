package com.vivo.push.util;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
/* loaded from: classes4.dex */
public final class s {
    public static /* synthetic */ Interceptable $ic;
    public static Boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    public static com.vivo.push.model.b a(Context context) {
        InterceptResult invokeL;
        com.vivo.push.model.b e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            Context applicationContext = context.getApplicationContext();
            com.vivo.push.model.b e3 = e(applicationContext);
            if (e3 != null) {
                p.d("PushPackageUtils", "get system push info :" + e3);
                return e3;
            }
            List<String> f2 = f(applicationContext);
            com.vivo.push.model.b e4 = e(applicationContext, applicationContext.getPackageName());
            if (f2.size() <= 0) {
                if (e4 != null && e4.d()) {
                    e3 = e4;
                }
                p.a("PushPackageUtils", "findAllPushPackages error: find no package!");
            } else {
                com.vivo.push.model.b bVar = null;
                String a2 = y.b(applicationContext).a("com.vivo.push.cur_pkg", null);
                com.vivo.push.model.b bVar2 = (TextUtils.isEmpty(a2) || !a(applicationContext, a2, "com.vivo.pushservice.action.METHOD") || (bVar2 = e(applicationContext, a2)) == null || !bVar2.d()) ? null : null;
                e4 = (e4 == null || !e4.d()) ? null : null;
                if (bVar2 == null) {
                    bVar2 = null;
                }
                if (e4 == null || (bVar2 != null && (!e4.c() ? !(bVar2.c() || e4.b() > bVar2.b()) : !(bVar2.c() && e4.b() > bVar2.b())))) {
                    e4 = bVar2;
                }
                HashMap hashMap = new HashMap();
                if (e4 == null) {
                    e4 = null;
                } else if (e4.c()) {
                    bVar = e4;
                    e4 = null;
                }
                int size = f2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    String str = f2.get(i2);
                    if (!TextUtils.isEmpty(str) && (e2 = e(applicationContext, str)) != null) {
                        hashMap.put(str, e2);
                        if (e2.d()) {
                            if (e2.c()) {
                                if (bVar == null || e2.b() > bVar.b()) {
                                    bVar = e2;
                                }
                            } else if (e4 == null || e2.b() > e4.b()) {
                                e4 = e2;
                            }
                        }
                    }
                }
                if (e4 != null) {
                    e3 = e4;
                } else {
                    p.d("PushPackageUtils", "findSuitablePushPackage, all push app in balck list.");
                    e3 = bVar;
                }
            }
            if (e3 != null) {
                if (e3.c()) {
                    p.a(applicationContext, "查找最优包为:" + e3.a() + "(" + e3.b() + ", Black)");
                    p.d("PushPackageUtils", "finSuitablePushPackage" + e3.a() + "(" + e3.b() + ", Black)");
                } else {
                    p.a(applicationContext, "查找最优包为:" + e3.a() + "(" + e3.b() + SmallTailInfo.EMOTION_SUFFIX);
                    p.d("PushPackageUtils", "finSuitablePushPackage" + e3.a() + "(" + e3.b() + SmallTailInfo.EMOTION_SUFFIX);
                }
            } else {
                p.b(applicationContext, "查找最优包为空!");
                p.d("PushPackageUtils", "finSuitablePushPackage is null");
            }
            return e3;
        }
        return (com.vivo.push.model.b) invokeL.objValue;
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        String str;
        Cursor query;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) != null) {
            return (String) invokeL.objValue;
        }
        Cursor cursor = null;
        try {
        } catch (Exception e2) {
            p.a("PushPackageUtils", IntentConfig.CLOSE, e2);
        }
        try {
            try {
                query = context.getContentResolver().query(com.vivo.push.z.a, null, null, null, null);
            } catch (Exception e3) {
                e = e3;
                str = null;
            }
            try {
                if (query == null) {
                    try {
                        p.a("PushPackageUtils", "cursor is null");
                        if (query != null) {
                            try {
                                query.close();
                            } catch (Exception e4) {
                                p.a("PushPackageUtils", IntentConfig.CLOSE, e4);
                            }
                        }
                        return null;
                    } catch (Exception e5) {
                        e = e5;
                        str = null;
                    }
                } else {
                    boolean z = false;
                    str = null;
                    while (query.moveToNext()) {
                        try {
                            if ("pushPkgName".equals(query.getString(query.getColumnIndex("name")))) {
                                str = query.getString(query.getColumnIndex("value"));
                            } else if ("pushEnable".equals(query.getString(query.getColumnIndex("name")))) {
                                z = Boolean.parseBoolean(query.getString(query.getColumnIndex("value")));
                            }
                        } catch (Exception e6) {
                            e = e6;
                        }
                    }
                    if (TextUtils.isEmpty(str)) {
                        if (query != null) {
                            try {
                                query.close();
                            } catch (Exception e7) {
                                p.a("PushPackageUtils", IntentConfig.CLOSE, e7);
                            }
                        }
                        return null;
                    } else if (z) {
                        if (query != null) {
                            query.close();
                        }
                        return str;
                    } else {
                        if (query != null) {
                            try {
                                query.close();
                            } catch (Exception e8) {
                                p.a("PushPackageUtils", IntentConfig.CLOSE, e8);
                            }
                        }
                        return null;
                    }
                }
                cursor = query;
                if (cursor != null) {
                    cursor.close();
                }
                return str;
            } catch (Throwable th) {
                th = th;
                cursor = query;
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception e9) {
                        p.a("PushPackageUtils", IntentConfig.CLOSE, e9);
                    }
                }
                throw th;
            }
            p.a("PushPackageUtils", "getSystemPush", e);
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static Set<String> c(Context context) {
        InterceptResult invokeL;
        List<ResolveInfo> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            HashSet hashSet = new HashSet();
            List<ResolveInfo> list2 = null;
            try {
                list = context.getPackageManager().queryBroadcastReceivers(new Intent("com.vivo.pushservice.action.RECEIVE"), 576);
            } catch (Exception unused) {
                list = null;
            }
            try {
                list2 = context.getPackageManager().queryBroadcastReceivers(new Intent("com.vivo.pushclient.action.RECEIVE"), 576);
            } catch (Exception unused2) {
            }
            if (list == null || list.size() <= 0) {
                list = list2;
            } else if (list2 != null && list2.size() > 0) {
                list.addAll(list2);
            }
            if (list != null && list.size() > 0) {
                for (ResolveInfo resolveInfo : list) {
                    if (resolveInfo != null) {
                        String str = resolveInfo.activityInfo.packageName;
                        if (!TextUtils.isEmpty(str)) {
                            hashSet.add(str);
                        }
                    }
                }
            }
            return hashSet;
        }
        return (Set) invokeL.objValue;
    }

    public static boolean d(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, context, str)) == null) ? a(context, str, "com.vivo.pushservice.action.METHOD") : invokeLL.booleanValue;
    }

    public static com.vivo.push.model.b e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            String b2 = b(context);
            ApplicationInfo applicationInfo = null;
            if (TextUtils.isEmpty(b2)) {
                return null;
            }
            com.vivo.push.model.b bVar = new com.vivo.push.model.b(b2);
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(b2, 128);
                if (packageInfo != null) {
                    bVar.a(packageInfo.versionCode);
                    bVar.a(packageInfo.versionName);
                    applicationInfo = packageInfo.applicationInfo;
                }
                if (applicationInfo != null) {
                    bVar.a(z.a(context, b2));
                }
                bVar.a(a(context, bVar.b()));
                bVar.b(a(context, b2));
                return bVar;
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
                p.d("PushPackageUtils", "PackageManager NameNotFoundException is null");
                return null;
            }
        }
        return (com.vivo.push.model.b) invokeL.objValue;
    }

    public static List<String> f(Context context) {
        InterceptResult invokeL;
        List<ResolveInfo> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, context)) == null) {
            h.a("findAllCoreClientPush");
            ArrayList arrayList = new ArrayList();
            try {
                list = context.getPackageManager().queryIntentServices(new Intent("com.vivo.pushservice.action.PUSH_SERVICE"), 576);
            } catch (Exception unused) {
                list = null;
            }
            if (list != null && list.size() > 0) {
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ResolveInfo resolveInfo = list.get(i2);
                    if (resolveInfo != null) {
                        String str = resolveInfo.serviceInfo.packageName;
                        if (!TextUtils.isEmpty(str)) {
                            arrayList.add(str);
                        }
                    }
                }
            }
            if (arrayList.size() <= 0) {
                p.d("PushPackageUtils", "get all push packages is null");
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static boolean d(Context context) {
        InterceptResult invokeL;
        ProviderInfo resolveContentProvider;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            Boolean bool = a;
            if (bool != null) {
                return bool.booleanValue();
            }
            String str = null;
            if (context != null && !TextUtils.isEmpty("com.vivo.push.sdk.service.SystemPushConfig") && (resolveContentProvider = context.getPackageManager().resolveContentProvider("com.vivo.push.sdk.service.SystemPushConfig", 128)) != null) {
                str = resolveContentProvider.packageName;
            }
            Boolean valueOf = Boolean.valueOf("BCC35D4D3606F154F0402AB7634E8490C0B244C2675C3C6238986987024F0C02".equals(f(context, str)));
            a = valueOf;
            return valueOf.booleanValue();
        }
        return invokeL.booleanValue;
    }

    public static String f(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, context, str)) == null) {
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
                } catch (Exception e2) {
                    p.a("PushPackageUtils", e2);
                }
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public static boolean c(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, context, str)) == null) ? a(context, str, "com.vivo.pushservice.action.RECEIVE") : invokeLL.booleanValue;
    }

    public static com.vivo.push.model.b e(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, context, str)) == null) {
            ApplicationInfo applicationInfo = null;
            if (!TextUtils.isEmpty(str)) {
                if (a(context, str, "com.vivo.pushservice.action.METHOD") || a(context, str, "com.vivo.pushservice.action.RECEIVE")) {
                    com.vivo.push.model.b bVar = new com.vivo.push.model.b(str);
                    try {
                        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 128);
                        if (packageInfo != null) {
                            bVar.a(packageInfo.versionCode);
                            bVar.a(packageInfo.versionName);
                            applicationInfo = packageInfo.applicationInfo;
                        }
                        if (applicationInfo != null) {
                            bVar.a(z.a(context, str));
                        }
                    } catch (PackageManager.NameNotFoundException e2) {
                        p.a("PushPackageUtils", "getPushPackageInfo exception: ", e2);
                    }
                    bVar.b(a(context, str));
                    bVar.a(a(context, bVar.b()));
                    return bVar;
                }
            }
            return null;
        }
        return (com.vivo.push.model.b) invokeLL.objValue;
    }

    public static boolean b(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, context, str)) == null) ? a(context, str, "com.vivo.pushclient.action.RECEIVE") : invokeLL.booleanValue;
    }

    public static boolean a(Context context, String str) {
        InterceptResult invokeLL;
        ServiceInfo serviceInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            if (!TextUtils.isEmpty(str) && context != null) {
                Intent intent = new Intent("com.vivo.pushservice.action.PUSH_SERVICE");
                intent.setPackage(str);
                PackageManager packageManager = context.getPackageManager();
                List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 576);
                if (queryIntentServices != null && queryIntentServices.size() > 0) {
                    int size = queryIntentServices.size();
                    boolean z = false;
                    for (int i2 = 0; i2 < size; i2++) {
                        ResolveInfo resolveInfo = queryIntentServices.get(i2);
                        if (resolveInfo != null && (serviceInfo = resolveInfo.serviceInfo) != null) {
                            String str2 = serviceInfo.name;
                            boolean z2 = serviceInfo.exported;
                            if ("com.vivo.push.sdk.service.PushService".equals(str2) && z2) {
                                boolean z3 = resolveInfo.serviceInfo.enabled;
                                int componentEnabledSetting = packageManager.getComponentEnabledSetting(new ComponentName(str, "com.vivo.push.sdk.service.PushService"));
                                z = componentEnabledSetting == 1 || (componentEnabledSetting == 0 && z3);
                            }
                        }
                    }
                    return z;
                }
                p.a("PushPackageUtils", "isEnablePush error: can not find push service.");
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean a(Context context, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65537, null, context, j2)) == null) {
            com.vivo.push.cache.e a2 = com.vivo.push.cache.b.a().a(context);
            if (a2 != null) {
                return a2.isInBlackList(j2);
            }
            return false;
        }
        return invokeLJ.booleanValue;
    }

    public static boolean a(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        List<ResolveInfo> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, context, str, str2)) == null) {
            Intent intent = new Intent(str2);
            intent.setPackage(str);
            try {
                list = context.getPackageManager().queryBroadcastReceivers(intent, 576);
            } catch (Exception unused) {
                list = null;
            }
            return list != null && list.size() > 0;
        }
        return invokeLLL.booleanValue;
    }
}
