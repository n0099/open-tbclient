package com.xiaomi.push.service;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.text.TextUtils;
import java.util.List;
/* loaded from: classes7.dex */
class aj {

    /* renamed from: a  reason: collision with other field name */
    private static final String[] f846a = {"com.mi.globalbrowser", "com.android.browser"};
    private static String a = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(Context context, String str) {
        ApplicationInfo applicationInfo = null;
        if (str.equals(context.getPackageName())) {
            applicationInfo = context.getApplicationInfo();
        } else {
            try {
                applicationInfo = context.getPackageManager().getApplicationInfo(str, 0);
            } catch (PackageManager.NameNotFoundException e) {
                com.xiaomi.channel.commonutils.logger.b.m54a("not found app info " + str);
            }
        }
        if (applicationInfo != null) {
            int i = applicationInfo.icon;
            return (i != 0 || Build.VERSION.SDK_INT < 9) ? i : applicationInfo.logo;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(Notification notification) {
        Object a2;
        String str = null;
        try {
            if (Build.VERSION.SDK_INT >= 19 && notification.extras != null) {
                str = notification.extras.getString("target_package");
            }
            try {
                return (!TextUtils.isEmpty(str) || (a2 = com.xiaomi.push.ba.a(notification, "extraNotification")) == null) ? str : (String) com.xiaomi.push.ba.a(a2, "getTargetPkg", new Object[0]);
            } catch (Exception e) {
                return str;
            }
        } catch (Exception e2) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Notification notification, String str) {
        try {
            if (Build.VERSION.SDK_INT >= 19 && notification.extras != null) {
                notification.extras.putString("target_package", str);
            }
            Object a2 = com.xiaomi.push.ba.a(notification, "extraNotification");
            if (a2 != null) {
                com.xiaomi.push.ba.a(a2, "setTargetPkg", str);
            }
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context, Intent intent) {
        String str;
        int i = -1;
        while (true) {
            str = i < 0 ? a : f846a[i];
            if (!TextUtils.isEmpty(str)) {
                intent.setPackage(str);
                try {
                    List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
                    if (queryIntentActivities != null && queryIntentActivities.size() > 0) {
                        break;
                    }
                } catch (Exception e) {
                    com.xiaomi.channel.commonutils.logger.b.m54a("not found xm browser:" + e);
                }
            }
            int i2 = i + 1;
            if (i2 >= f846a.length) {
                str = null;
                break;
            }
            i = i2;
        }
        intent.setPackage(str);
        a = str;
    }
}
