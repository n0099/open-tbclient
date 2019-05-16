package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class j {
    public static void a(Context context, String str) {
        ArrayList<com.xiaomi.xmpush.thrift.m> b = g.a(context).b(str);
        if (b == null || b.size() < 1) {
            return;
        }
        if (g.a(context).e(str) == 0) {
            com.xiaomi.channel.commonutils.logger.b.a("appIsUninstalled. failed to delete geofencing with package name. name:" + str);
        }
        Iterator<com.xiaomi.xmpush.thrift.m> it = b.iterator();
        while (it.hasNext()) {
            com.xiaomi.xmpush.thrift.m next = it.next();
            if (next == null) {
                com.xiaomi.channel.commonutils.logger.b.a("appIsUninstalled. failed to find geofence with package name. name:" + str);
                return;
            }
            a(next.a(), context);
            if (i.a(context).b(next.a()) == 0) {
                com.xiaomi.channel.commonutils.logger.b.a("appIsUninstalled. failed to delete geoMessage with package name. name:" + str + ", geoId:" + next.a());
            }
        }
    }

    public static void a(Context context, boolean z) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
        edit.putBoolean("geo_switch", z);
        com.xiaomi.channel.commonutils.android.l.a(edit);
    }

    public static void a(String str, Context context) {
        new com.xiaomi.metoknlp.geofencing.a(context).a(context, "com.xiaomi.xmsf", str);
    }

    public static boolean a(Context context) {
        return a(context, "com.xiaomi.metoknlp", 6);
    }

    public static boolean a(Context context, String str, int i) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e) {
            packageInfo = null;
        }
        return packageInfo != null && packageInfo.versionCode >= i;
    }

    public static boolean b(Context context) {
        return a(context, "com.xiaomi.xmsf", 106) && (a(context, "com.xiaomi.metok", 20) || a(context, "com.xiaomi.metoknlp", 6));
    }

    public static boolean c(Context context) {
        return TextUtils.equals(context.getPackageName(), "com.xiaomi.xmsf");
    }

    public static boolean d(Context context) {
        return a(context);
    }

    public static boolean e(Context context) {
        return context.getSharedPreferences("mipush_extra", 4).getBoolean("geo_switch", false);
    }
}
