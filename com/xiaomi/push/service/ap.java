package com.xiaomi.push.service;

import android.app.Notification;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
/* loaded from: classes7.dex */
public class ap {

    /* renamed from: a  reason: collision with root package name */
    public static String f41243a;

    /* renamed from: a  reason: collision with other field name */
    public static final String[] f894a = {"com.mi.globalbrowser", "com.android.browser"};

    public static int a(ContentResolver contentResolver) {
        if (Build.VERSION.SDK_INT >= 17) {
            try {
                return Settings.Global.getInt(contentResolver, "user_aggregate", 0);
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.m55a("get user aggregate failed, " + e2);
            }
        }
        return 0;
    }

    public static int a(Context context, String str) {
        return com.xiaomi.push.g.b(context, str);
    }

    public static String a(Notification notification) {
        Object a2;
        String str = null;
        try {
            if (Build.VERSION.SDK_INT >= 19 && notification.extras != null) {
                str = notification.extras.getString("target_package");
            }
            return (!TextUtils.isEmpty(str) || (a2 = com.xiaomi.push.bh.a(notification, "extraNotification")) == null) ? str : (String) com.xiaomi.push.bh.a(a2, "getTargetPkg", new Object[0]);
        } catch (Exception unused) {
            return str;
        }
    }

    public static void a(Notification notification, String str) {
        try {
            if (Build.VERSION.SDK_INT >= 19 && notification.extras != null) {
                notification.extras.putString("target_package", str);
            }
            Object a2 = com.xiaomi.push.bh.a(notification, "extraNotification");
            if (a2 != null) {
                com.xiaomi.push.bh.a(a2, "setTargetPkg", str);
            }
        } catch (Exception unused) {
        }
    }

    public static void a(Context context, Intent intent) {
        String str;
        int i = -1;
        while (true) {
            str = i < 0 ? f41243a : f894a[i];
            if (!TextUtils.isEmpty(str)) {
                intent.setPackage(str);
                try {
                    if (context.getPackageManager().resolveActivity(intent, 65536) != null) {
                        break;
                    }
                } catch (Exception e2) {
                    com.xiaomi.channel.commonutils.logger.b.m55a("not found xm browser:" + e2);
                }
            }
            i++;
            if (i >= f894a.length) {
                str = null;
                break;
            }
        }
        intent.setPackage(str);
        f41243a = str;
    }

    public static boolean a(Notification.Builder builder, boolean z) {
        if (Build.VERSION.SDK_INT >= 26) {
            builder.setGroupAlertBehavior(z ? 2 : 1);
            return true;
        }
        com.xiaomi.channel.commonutils.logger.b.b("not support setGroupAlertBehavior");
        return false;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m583a(ContentResolver contentResolver) {
        int a2 = a(contentResolver);
        return a2 == 1 || a2 == 2;
    }
}
