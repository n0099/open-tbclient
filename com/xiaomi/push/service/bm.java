package com.xiaomi.push.service;

import android.annotation.TargetApi;
import android.app.Notification;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.MIPushNotificationHelper4Hybrid;
import java.util.Map;
/* loaded from: classes3.dex */
public class bm {
    public static Runnable a;

    private static String a(Context context, String str) {
        return context.getSharedPreferences("typed_shield_pref", 4).getString(str + "_title", str);
    }

    public static String a(com.xiaomi.xmpush.thrift.af afVar) {
        Map<String, String> s = afVar.m().s();
        if (s == null) {
            return null;
        }
        return s.get("__typed_shield_type");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(19)
    public static void a(Context context, com.xiaomi.xmpush.thrift.af afVar, Notification notification) {
        if (Build.VERSION.SDK_INT < 19) {
            return;
        }
        String a2 = a(afVar);
        if (TextUtils.isEmpty(a2) || !"com.xiaomi.xmsf".equals(ah.a(afVar))) {
            return;
        }
        Bundle bundle = notification.extras;
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString(MIPushNotificationHelper4Hybrid.KEY_CATEGORY, a2);
        bundle.putString(MIPushNotificationHelper4Hybrid.KEY_SUBST_NAME, a(context, a2));
        notification.extras = bundle;
    }

    public static boolean a(Context context, com.xiaomi.xmpush.thrift.af afVar) {
        if ("com.xiaomi.xmsf".equals(ah.a(afVar))) {
            String a2 = a(afVar);
            if (TextUtils.isEmpty(a2)) {
                return false;
            }
            SharedPreferences sharedPreferences = context.getSharedPreferences("typed_shield_pref", 4);
            if (!sharedPreferences.contains(a2 + "_shield") && a != null) {
                a.run();
            }
            return sharedPreferences.getBoolean(a2 + "_shield", true);
        }
        return false;
    }
}
