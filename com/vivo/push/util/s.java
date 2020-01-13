package com.vivo.push.util;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes6.dex */
public final class s {
    public static com.vivo.push.model.b a(Context context) {
        com.vivo.push.model.b bVar;
        com.vivo.push.model.b bVar2;
        com.vivo.push.model.b bVar3;
        com.vivo.push.model.b bVar4 = null;
        Context applicationContext = context.getApplicationContext();
        com.vivo.push.model.b d = d(applicationContext);
        if (d != null) {
            p.d("PushPackageUtils", "get system push info :" + d);
        } else {
            List<String> e = e(applicationContext);
            com.vivo.push.model.b e2 = e(applicationContext, applicationContext.getPackageName());
            if (e.size() <= 0) {
                if (e2 == null || !e2.d()) {
                    e2 = d;
                }
                p.a("PushPackageUtils", "findAllPushPackages error: find no package!");
                d = e2;
            } else {
                String a = y.b(applicationContext).a("com.vivo.push.cur_pkg", null);
                if (TextUtils.isEmpty(a) || !a(applicationContext, a, "com.vivo.pushservice.action.METHOD") || (bVar = e(applicationContext, a)) == null || !bVar.d()) {
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
                int size = e.size();
                int i = 0;
                com.vivo.push.model.b bVar7 = bVar4;
                d = bVar6;
                while (i < size) {
                    String str = e.get(i);
                    if (!TextUtils.isEmpty(str) && (bVar3 = e(applicationContext, str)) != null) {
                        hashMap.put(str, bVar3);
                        if (bVar3.d()) {
                            if (bVar3.c()) {
                                if (bVar7 == null || bVar3.b() > bVar7.b()) {
                                    bVar2 = d;
                                }
                            } else if (d == null || bVar3.b() > d.b()) {
                                bVar2 = bVar3;
                                bVar3 = bVar7;
                            }
                            i++;
                            bVar7 = bVar3;
                            d = bVar2;
                        }
                    }
                    bVar2 = d;
                    bVar3 = bVar7;
                    i++;
                    bVar7 = bVar3;
                    d = bVar2;
                }
                if (d == null) {
                    p.d("PushPackageUtils", "findSuitablePushPackage, all push app in balck list.");
                    d = bVar7;
                }
            }
            if (d != null) {
                if (d.c()) {
                    p.a(applicationContext, "查找最优包为:" + d.a() + "(" + d.b() + ", Black)");
                } else {
                    p.a(applicationContext, "查找最优包为:" + d.a() + "(" + d.b() + ")");
                }
            } else {
                p.b(applicationContext, "查找最优包为空!");
            }
        }
        return d;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [197=6, 198=6, 200=6, 201=6] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x010b A[EXC_TOP_SPLITTER, SYNTHETIC] */
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
                                String string = cursor.getString(cursor.getColumnIndex("value"));
                                try {
                                    p.d("PushPackageUtils", "get system app is " + string);
                                    str = string;
                                } catch (Exception e2) {
                                    cursor2 = cursor;
                                    str = string;
                                    e = e2;
                                }
                            } else if ("pushEnable".equals(cursor.getString(cursor.getColumnIndex("name")))) {
                                boolean parseBoolean = Boolean.parseBoolean(cursor.getString(cursor.getColumnIndex("value")));
                                p.d("PushPackageUtils", "get system app isSystemOpen is " + parseBoolean);
                                z = parseBoolean;
                            }
                        } catch (Exception e3) {
                            e = e3;
                            cursor2 = cursor;
                        }
                    }
                    if (TextUtils.isEmpty(str)) {
                        if (cursor != null) {
                            try {
                                cursor.close();
                            } catch (Exception e4) {
                                p.a("PushPackageUtils", "close", e4);
                            }
                        }
                        return null;
                    } else if (!z) {
                        if (cursor != null) {
                            try {
                                cursor.close();
                            } catch (Exception e5) {
                                p.a("PushPackageUtils", "close", e5);
                            }
                        }
                        return null;
                    } else if (cursor != null) {
                        try {
                            cursor.close();
                            return str;
                        } catch (Exception e6) {
                            p.a("PushPackageUtils", "close", e6);
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
                        } catch (Exception e7) {
                            p.a("PushPackageUtils", "close", e7);
                        }
                    }
                    return null;
                } catch (Exception e8) {
                    e = e8;
                    str = null;
                    cursor2 = cursor;
                }
            } catch (Throwable th) {
                th = th;
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception e9) {
                        p.a("PushPackageUtils", "close", e9);
                    }
                }
                throw th;
            }
        } catch (Exception e10) {
            e = e10;
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
                } catch (Exception e11) {
                    p.a("PushPackageUtils", "close", e11);
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

    private static com.vivo.push.model.b d(Context context) {
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
        com.vivo.push.cache.e a = com.vivo.push.cache.b.a().a(context);
        if (a != null) {
            return a.isInBlackList(j);
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

    private static List<String> e(Context context) {
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
}
