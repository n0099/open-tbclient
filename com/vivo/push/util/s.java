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
/* loaded from: classes3.dex */
public final class s {

    /* renamed from: a  reason: collision with root package name */
    private static Boolean f13996a;

    public static com.vivo.push.model.b a(Context context) {
        com.vivo.push.model.b bVar;
        com.vivo.push.model.b bVar2;
        com.vivo.push.model.b e;
        Context applicationContext = context.getApplicationContext();
        com.vivo.push.model.b e2 = e(applicationContext);
        if (e2 != null) {
            p.d("PushPackageUtils", "get system push info :" + e2);
        } else {
            List<String> f = f(applicationContext);
            com.vivo.push.model.b e3 = e(applicationContext, applicationContext.getPackageName());
            if (f.size() <= 0) {
                if (e3 == null || !e3.d()) {
                    e3 = e2;
                }
                p.a("PushPackageUtils", "findAllPushPackages error: find no package!");
                e2 = e3;
            } else {
                String a2 = y.b(applicationContext).a("com.vivo.push.cur_pkg", null);
                com.vivo.push.model.b bVar3 = (TextUtils.isEmpty(a2) || !a(applicationContext, a2, "com.vivo.pushservice.action.METHOD") || (bVar3 = e(applicationContext, a2)) == null || !bVar3.d()) ? null : null;
                com.vivo.push.model.b bVar4 = (e3 == null || !e3.d()) ? null : e3;
                com.vivo.push.model.b bVar5 = bVar3 != null ? bVar3 : null;
                if (bVar4 != null && (bVar5 == null || (!bVar4.c() ? bVar5.c() || bVar4.b() > bVar5.b() : bVar5.c() && bVar4.b() > bVar5.b()))) {
                    bVar5 = bVar4;
                }
                HashMap hashMap = new HashMap();
                if (bVar5 == null) {
                    e2 = null;
                    bVar = null;
                } else if (bVar5.c()) {
                    e2 = null;
                    bVar = bVar5;
                } else {
                    e2 = bVar5;
                    bVar = null;
                }
                int size = f.size();
                for (int i = 0; i < size; i++) {
                    String str = f.get(i);
                    if (!TextUtils.isEmpty(str) && (e = e(applicationContext, str)) != null) {
                        hashMap.put(str, e);
                        if (e.d()) {
                            if (e.c()) {
                                if (bVar == null || e.b() > bVar.b()) {
                                    bVar2 = e2;
                                    bVar = e;
                                }
                            } else if (e2 == null || e.b() > e2.b()) {
                                bVar2 = e;
                            }
                            e2 = bVar2;
                        }
                    }
                    bVar2 = e2;
                    e2 = bVar2;
                }
                if (e2 == null) {
                    p.d("PushPackageUtils", "findSuitablePushPackage, all push app in balck list.");
                    e2 = bVar;
                }
            }
            if (e2 != null) {
                if (e2.c()) {
                    p.a(applicationContext, "查找最优包为:" + e2.a() + "(" + e2.b() + ", Black)");
                    p.d("PushPackageUtils", "finSuitablePushPackage" + e2.a() + "(" + e2.b() + ", Black)");
                } else {
                    p.a(applicationContext, "查找最优包为:" + e2.a() + "(" + e2.b() + ")");
                    p.d("PushPackageUtils", "finSuitablePushPackage" + e2.a() + "(" + e2.b() + ")");
                }
            } else {
                p.b(applicationContext, "查找最优包为空!");
                p.d("PushPackageUtils", "finSuitablePushPackage is null");
            }
        }
        return e2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [202=6, 203=6, 205=6, 206=6] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00da A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String b(Context context) {
        Cursor cursor;
        String str;
        try {
            try {
                cursor = context.getContentResolver().query(com.vivo.push.z.f14014a, null, null, null, null);
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
                        } catch (Exception e) {
                            e = e;
                        }
                    }
                    if (TextUtils.isEmpty(str)) {
                        if (cursor != null) {
                            try {
                                cursor.close();
                            } catch (Exception e2) {
                                p.a("PushPackageUtils", "close", e2);
                            }
                        }
                        return null;
                    } else if (!z) {
                        if (cursor != null) {
                            try {
                                cursor.close();
                            } catch (Exception e3) {
                                p.a("PushPackageUtils", "close", e3);
                            }
                        }
                        return null;
                    } else if (cursor != null) {
                        try {
                            cursor.close();
                            return str;
                        } catch (Exception e4) {
                            p.a("PushPackageUtils", "close", e4);
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
                        } catch (Exception e5) {
                            p.a("PushPackageUtils", "close", e5);
                        }
                    }
                    return null;
                } catch (Exception e6) {
                    e = e6;
                    str = null;
                }
            } catch (Throwable th) {
                th = th;
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception e7) {
                        p.a("PushPackageUtils", "close", e7);
                    }
                }
                throw th;
            }
        } catch (Exception e8) {
            e = e8;
            cursor = null;
            str = null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
            if (cursor != null) {
            }
            throw th;
        }
        p.a("PushPackageUtils", "getSystemPush", e);
        if (cursor != null) {
            try {
                cursor.close();
                return str;
            } catch (Exception e9) {
                p.a("PushPackageUtils", "close", e9);
                return str;
            }
        }
        return str;
    }

    private static com.vivo.push.model.b e(Context context) {
        ApplicationInfo applicationInfo = null;
        String b2 = b(context);
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
            for (byte b2 : digest) {
                String upperCase = Integer.toHexString(b2 & 255).toUpperCase(Locale.US);
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
        if (f13996a != null) {
            return f13996a.booleanValue();
        }
        if (context != null && !TextUtils.isEmpty("com.vivo.push.sdk.service.SystemPushConfig") && (resolveContentProvider = context.getPackageManager().resolveContentProvider("com.vivo.push.sdk.service.SystemPushConfig", 128)) != null) {
            str = resolveContentProvider.packageName;
        }
        Boolean valueOf = Boolean.valueOf("BCC35D4D3606F154F0402AB7634E8490C0B244C2675C3C6238986987024F0C02".equals(f(context, str)));
        f13996a = valueOf;
        return valueOf.booleanValue();
    }
}
