package com.vivo.push.util;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.text.TextUtils;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
/* loaded from: classes9.dex */
public final class s {
    private static Boolean a;

    public static com.vivo.push.model.b a(Context context) {
        com.vivo.push.model.b bVar;
        com.vivo.push.model.b bVar2;
        com.vivo.push.model.b bVar3;
        com.vivo.push.model.b bVar4 = null;
        Context applicationContext = context.getApplicationContext();
        com.vivo.push.model.b e = e(applicationContext);
        if (e != null) {
            p.d("PushPackageUtils", "get system push info :" + e);
        } else {
            List<String> f = f(applicationContext);
            com.vivo.push.model.b e2 = e(applicationContext, applicationContext.getPackageName());
            if (f.size() <= 0) {
                if (e2 == null || !e2.d()) {
                    e2 = e;
                }
                p.a("PushPackageUtils", "findAllPushPackages error: find no package!");
                e = e2;
            } else {
                String a2 = y.b(applicationContext).a("com.vivo.push.cur_pkg", null);
                if (TextUtils.isEmpty(a2) || !a(applicationContext, a2, "com.vivo.pushservice.action.METHOD") || (bVar = e(applicationContext, a2)) == null || !bVar.d()) {
                    bVar = null;
                }
                com.vivo.push.model.b bVar5 = (e2 == null || !e2.d()) ? null : e2;
                com.vivo.push.model.b bVar6 = bVar != null ? bVar : null;
                if (bVar5 != null && (bVar6 == null || (!bVar5.c() ? bVar6.c() || bVar5.b() > bVar6.b() : bVar6.c() && bVar5.b() > bVar6.b()))) {
                    bVar6 = bVar5;
                }
                HashMap hashMap = new HashMap();
                if (bVar6 == null) {
                    bVar6 = null;
                } else if (bVar6.c()) {
                    bVar4 = bVar6;
                    bVar6 = null;
                }
                int size = f.size();
                int i = 0;
                com.vivo.push.model.b bVar7 = bVar4;
                e = bVar6;
                while (i < size) {
                    String str = f.get(i);
                    if (!TextUtils.isEmpty(str) && (bVar3 = e(applicationContext, str)) != null) {
                        hashMap.put(str, bVar3);
                        if (bVar3.d()) {
                            if (bVar3.c()) {
                                if (bVar7 == null || bVar3.b() > bVar7.b()) {
                                    bVar2 = e;
                                }
                            } else if (e == null || bVar3.b() > e.b()) {
                                bVar2 = bVar3;
                                bVar3 = bVar7;
                            }
                            i++;
                            bVar7 = bVar3;
                            e = bVar2;
                        }
                    }
                    bVar2 = e;
                    bVar3 = bVar7;
                    i++;
                    bVar7 = bVar3;
                    e = bVar2;
                }
                if (e == null) {
                    p.d("PushPackageUtils", "findSuitablePushPackage, all push app in balck list.");
                    e = bVar7;
                }
            }
            if (e != null) {
                if (e.c()) {
                    p.a(applicationContext, "查找最优包为:" + e.a() + "(" + e.b() + ", Black)");
                    p.d("PushPackageUtils", "finSuitablePushPackage" + e.a() + "(" + e.b() + ", Black)");
                } else {
                    p.a(applicationContext, "查找最优包为:" + e.a() + "(" + e.b() + ")");
                    p.d("PushPackageUtils", "finSuitablePushPackage" + e.a() + "(" + e.b() + ")");
                }
            } else {
                p.b(applicationContext, "查找最优包为空!");
                p.d("PushPackageUtils", "finSuitablePushPackage is null");
            }
        }
        return e;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [202=6, 203=6, 205=6, 206=6] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00db A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String b(Context context) {
        Cursor cursor;
        Exception e;
        String str;
        Cursor cursor2 = null;
        try {
            cursor = context.getContentResolver().query(com.vivo.push.z.a, null, null, null, null);
            try {
                if (cursor != null) {
                    boolean z = false;
                    str = null;
                    while (cursor.moveToNext()) {
                        try {
                            if ("pushPkgName".equals(cursor.getString(cursor.getColumnIndex("name")))) {
                                str = cursor.getString(cursor.getColumnIndex("value"));
                            } else if ("pushEnable".equals(cursor.getString(cursor.getColumnIndex("name")))) {
                                z = Boolean.parseBoolean(cursor.getString(cursor.getColumnIndex("value")));
                            }
                        } catch (Exception e2) {
                            e = e2;
                            cursor2 = cursor;
                        }
                    }
                    if (TextUtils.isEmpty(str)) {
                        if (cursor != null) {
                            try {
                                cursor.close();
                            } catch (Exception e3) {
                                p.a("PushPackageUtils", "close", e3);
                            }
                        }
                        return null;
                    } else if (!z) {
                        if (cursor != null) {
                            try {
                                cursor.close();
                            } catch (Exception e4) {
                                p.a("PushPackageUtils", "close", e4);
                            }
                        }
                        return null;
                    } else if (cursor != null) {
                        try {
                            cursor.close();
                            return str;
                        } catch (Exception e5) {
                            p.a("PushPackageUtils", "close", e5);
                            return str;
                        }
                    } else {
                        return str;
                    }
                }
                try {
                    p.a("PushPackageUtils", "cursor is null");
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Exception e6) {
                            p.a("PushPackageUtils", "close", e6);
                        }
                    }
                    return null;
                } catch (Exception e7) {
                    e = e7;
                    str = null;
                    cursor2 = cursor;
                }
            } catch (Throwable th) {
                th = th;
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception e8) {
                        p.a("PushPackageUtils", "close", e8);
                    }
                }
                throw th;
            }
        } catch (Exception e9) {
            e = e9;
            str = null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
        try {
            p.a("PushPackageUtils", "getSystemPush", e);
            if (cursor2 != null) {
                try {
                    cursor2.close();
                    return str;
                } catch (Exception e10) {
                    p.a("PushPackageUtils", "close", e10);
                    return str;
                }
            }
            return str;
        } catch (Throwable th3) {
            th = th3;
            cursor = cursor2;
            if (cursor != null) {
            }
            throw th;
        }
    }

    private static com.vivo.push.model.b e(Context context) {
        ApplicationInfo applicationInfo = null;
        String b = b(context);
        if (TextUtils.isEmpty(b)) {
            return null;
        }
        com.vivo.push.model.b bVar = new com.vivo.push.model.b(b);
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(b, 128);
            if (packageInfo != null) {
                bVar.a(packageInfo.versionCode);
                bVar.a(packageInfo.versionName);
                applicationInfo = packageInfo.applicationInfo;
            }
            if (applicationInfo != null) {
                bVar.a(z.a(context, b));
            }
            bVar.a(a(context, bVar.b()));
            bVar.b(a(context, b));
            return bVar;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            p.d("PushPackageUtils", "PackageManager NameNotFoundException is null");
            return null;
        }
    }

    private static com.vivo.push.model.b e(Context context, String str) {
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
                } catch (PackageManager.NameNotFoundException e) {
                    p.a("PushPackageUtils", "getPushPackageInfo exception: ", e);
                }
                bVar.b(a(context, str));
                bVar.a(a(context, bVar.b()));
                return bVar;
            }
        }
        return null;
    }

    public static Set<String> c(Context context) {
        List<ResolveInfo> list;
        List<ResolveInfo> list2 = null;
        HashSet hashSet = new HashSet();
        try {
            list = context.getPackageManager().queryBroadcastReceivers(new Intent("com.vivo.pushservice.action.RECEIVE"), 576);
        } catch (Exception e) {
            list = null;
        }
        try {
            list2 = context.getPackageManager().queryBroadcastReceivers(new Intent("com.vivo.pushclient.action.RECEIVE"), 576);
        } catch (Exception e2) {
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

    public static boolean a(Context context, String str) {
        boolean z;
        if (TextUtils.isEmpty(str) || context == null) {
            return false;
        }
        Intent intent = new Intent("com.vivo.pushservice.action.PUSH_SERVICE");
        intent.setPackage(str);
        PackageManager packageManager = context.getPackageManager();
        List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 576);
        if (queryIntentServices == null || queryIntentServices.size() <= 0) {
            p.a("PushPackageUtils", "isEnablePush error: can not find push service.");
            return false;
        }
        int size = queryIntentServices.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            ResolveInfo resolveInfo = queryIntentServices.get(i);
            if (resolveInfo != null && resolveInfo.serviceInfo != null) {
                String str2 = resolveInfo.serviceInfo.name;
                boolean z3 = resolveInfo.serviceInfo.exported;
                if ("com.vivo.push.sdk.service.PushService".equals(str2) && z3) {
                    boolean z4 = resolveInfo.serviceInfo.enabled;
                    int componentEnabledSetting = packageManager.getComponentEnabledSetting(new ComponentName(str, "com.vivo.push.sdk.service.PushService"));
                    z = componentEnabledSetting == 1 || (componentEnabledSetting == 0 && z4);
                    i++;
                    z2 = z;
                }
            }
            z = z2;
            i++;
            z2 = z;
        }
        return z2;
    }

    private static boolean a(Context context, long j) {
        com.vivo.push.cache.e a2 = com.vivo.push.cache.b.a().a(context);
        if (a2 != null) {
            return a2.isInBlackList(j);
        }
        return false;
    }

    private static boolean a(Context context, String str, String str2) {
        Intent intent = new Intent(str2);
        intent.setPackage(str);
        List<ResolveInfo> list = null;
        try {
            list = context.getPackageManager().queryBroadcastReceivers(intent, 576);
        } catch (Exception e) {
        }
        if (list == null || list.size() <= 0) {
            return false;
        }
        return true;
    }

    public static boolean b(Context context, String str) {
        return a(context, str, "com.vivo.pushclient.action.RECEIVE");
    }

    public static boolean c(Context context, String str) {
        return a(context, str, "com.vivo.pushservice.action.RECEIVE");
    }

    public static boolean d(Context context, String str) {
        return a(context, str, "com.vivo.pushservice.action.METHOD");
    }

    private static List<String> f(Context context) {
        List<ResolveInfo> list;
        h.a("findAllCoreClientPush");
        ArrayList arrayList = new ArrayList();
        try {
            list = context.getPackageManager().queryIntentServices(new Intent("com.vivo.pushservice.action.PUSH_SERVICE"), 576);
        } catch (Exception e) {
            list = null;
        }
        if (list != null && list.size() > 0) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ResolveInfo resolveInfo = list.get(i);
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

    private static String f(Context context, String str) {
        if (TextUtils.isEmpty(str) || context == null) {
            return null;
        }
        try {
            byte[] digest = MessageDigest.getInstance("SHA256").digest(context.getPackageManager().getPackageInfo(str, 64).signatures[0].toByteArray());
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                String upperCase = Integer.toHexString(b & 255).toUpperCase(Locale.US);
                if (upperCase.length() == 1) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(upperCase);
            }
            return stringBuffer.toString();
        } catch (Exception e) {
            p.a("PushPackageUtils", e);
            return null;
        }
    }

    public static boolean d(Context context) {
        ProviderInfo resolveContentProvider;
        String str = null;
        if (a != null) {
            return a.booleanValue();
        }
        if (context != null && !TextUtils.isEmpty("com.vivo.push.sdk.service.SystemPushConfig") && (resolveContentProvider = context.getPackageManager().resolveContentProvider("com.vivo.push.sdk.service.SystemPushConfig", 128)) != null) {
            str = resolveContentProvider.packageName;
        }
        Boolean valueOf = Boolean.valueOf("BCC35D4D3606F154F0402AB7634E8490C0B244C2675C3C6238986987024F0C02".equals(f(context, str)));
        a = valueOf;
        return valueOf.booleanValue();
    }
}
