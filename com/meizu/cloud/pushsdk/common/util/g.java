package com.meizu.cloud.pushsdk.common.util;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.meizu.cloud.pushsdk.common.util.d;
/* loaded from: classes3.dex */
public class g {
    public static boolean a(int i) {
        return Build.VERSION.SDK_INT >= i;
    }

    public static String a(Context context) {
        if (c.a().a) {
            return c.a().b;
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE);
        if (telephonyManager != null) {
            return telephonyManager.getDeviceId();
        }
        return null;
    }

    public static boolean a() {
        d.c a = e.a("ro.meizu.product.model");
        return (a.a && !TextUtils.isEmpty((CharSequence) a.b)) || "meizu".equalsIgnoreCase(Build.BRAND) || "22c4185e".equalsIgnoreCase(Build.BRAND);
    }

    public static boolean b() {
        if (a.a().a) {
            return a.a().b.booleanValue();
        }
        return false;
    }

    public static boolean c() {
        d.c a = e.a("ro.meizu.locale.region");
        if (a.a) {
            return "india".equals(a.b);
        }
        return false;
    }

    public static boolean b(Context context) {
        try {
            return (context.getApplicationInfo().flags & 2) != 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
