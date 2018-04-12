package com.xiaomi.push.service;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class h {
    public static void a(Context context, String str) {
        ArrayList<com.xiaomi.xmpush.thrift.j> b = e.a(context).b(str);
        if (b == null || b.size() < 1) {
            return;
        }
        if (e.a(context).e(str) == 0) {
            com.xiaomi.channel.commonutils.logger.b.a("appIsUninstalled. failed to delete geofencing with package name. name:" + str);
        }
        Iterator<com.xiaomi.xmpush.thrift.j> it = b.iterator();
        while (it.hasNext()) {
            com.xiaomi.xmpush.thrift.j next = it.next();
            if (next == null) {
                com.xiaomi.channel.commonutils.logger.b.a("appIsUninstalled. failed to find geofence with package name. name:" + str);
                return;
            }
            a(next.a(), context);
            if (g.a(context).b(next.a()) == 0) {
                com.xiaomi.channel.commonutils.logger.b.a("appIsUninstalled. failed to delete geoMessage with package name. name:" + str + ", geoId:" + next.a());
            }
        }
    }

    public static void a(String str, Context context) {
        new com.xiaomi.metok.geofencing.a(context).a(context, "com.xiaomi.xmsf", str);
    }

    public static boolean a(Context context) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo("com.xiaomi.metok", 8192);
        } catch (PackageManager.NameNotFoundException e) {
            packageInfo = null;
        }
        return packageInfo != null && packageInfo.versionCode >= 20;
    }

    public static boolean b(Context context) {
        return TextUtils.equals(context.getPackageName(), "com.xiaomi.xmsf");
    }
}
