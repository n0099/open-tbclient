package com.xiaomi.push.service;

import android.app.Notification;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.Map;
/* loaded from: classes2.dex */
public class ay {
    public static Runnable a;

    private static String a(Context context, String str) {
        return context.getSharedPreferences("typed_shield_pref", 0).getString(str + "_title", str);
    }

    public static String a(com.xiaomi.xmpush.thrift.ab abVar) {
        Map<String, String> s = abVar.m().s();
        if (s == null) {
            return null;
        }
        return s.get("__typed_shield_type");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context, com.xiaomi.xmpush.thrift.ab abVar, Notification notification) {
        if (Build.VERSION.SDK_INT < 19) {
            return;
        }
        String a2 = a(abVar);
        if (TextUtils.isEmpty(a2) || !"com.xiaomi.xmsf".equals(ac.a(abVar))) {
            return;
        }
        Bundle bundle = notification.extras;
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString("miui.category", a2);
        bundle.putString("miui.substName", a(context, a2));
        notification.extras = bundle;
    }

    public static boolean a(Context context, com.xiaomi.xmpush.thrift.ab abVar) {
        if ("com.xiaomi.xmsf".equals(ac.a(abVar))) {
            String a2 = a(abVar);
            if (TextUtils.isEmpty(a2)) {
                return false;
            }
            SharedPreferences sharedPreferences = context.getSharedPreferences("typed_shield_pref", 0);
            if (!sharedPreferences.contains(a2 + "_shield") && a != null) {
                a.run();
            }
            return sharedPreferences.getBoolean(a2 + "_shield", true);
        }
        return false;
    }
}
