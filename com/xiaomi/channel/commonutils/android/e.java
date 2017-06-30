package com.xiaomi.channel.commonutils.android;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
/* loaded from: classes2.dex */
public class e {
    private static String a = null;
    private static String b = null;
    private static String c = null;

    public static String a() {
        if (Build.VERSION.SDK_INT > 8) {
            return Build.SERIAL;
        }
        return null;
    }

    public static String a(Context context) {
        if (b == null) {
            String c2 = c(context);
            String b2 = b(context);
            b = "a-" + com.xiaomi.channel.commonutils.string.d.b(c2 + b2 + a());
        }
        return b;
    }

    public static int b() {
        Object a2;
        if (Build.VERSION.SDK_INT >= 17 && (a2 = com.xiaomi.channel.commonutils.reflect.a.a("android.os.UserHandle", "myUserId", new Object[0])) != null) {
            return ((Integer) Integer.class.cast(a2)).intValue();
        }
        return -1;
    }

    public static String b(Context context) {
        try {
            return Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.a(th);
            return null;
        }
    }

    public static String c(Context context) {
        int i = 10;
        String d = d(context);
        while (d == null) {
            int i2 = i - 1;
            if (i <= 0) {
                break;
            }
            try {
                Thread.sleep(500L);
            } catch (InterruptedException e) {
            }
            d = d(context);
            i = i2;
        }
        return d;
    }

    public static String d(Context context) {
        Object a2;
        Object a3;
        if (a != null) {
            return a;
        }
        try {
            String str = (!g.a() || (a2 = com.xiaomi.channel.commonutils.reflect.a.a("miui.telephony.TelephonyManager", "getDefault", new Object[0])) == null || (a3 = com.xiaomi.channel.commonutils.reflect.a.a(a2, "getMiuiDeviceId", new Object[0])) == null || !(a3 instanceof String)) ? null : (String) String.class.cast(a3);
            if (str == null && h(context)) {
                str = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
            }
            if (str != null) {
                a = str;
                return str;
            }
            return str;
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.a(th);
            return null;
        }
    }

    public static synchronized String e(Context context) {
        String str;
        synchronized (e.class) {
            if (c != null) {
                str = c;
            } else {
                String b2 = b(context);
                c = com.xiaomi.channel.commonutils.string.d.b(b2 + a());
                str = c;
            }
        }
        return str;
    }

    public static String f(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).getSimOperatorName();
    }

    public static String g(Context context) {
        try {
            return ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getMacAddress();
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return null;
        }
    }

    private static boolean h(Context context) {
        return context.getPackageManager().checkPermission("android.permission.READ_PHONE_STATE", context.getPackageName()) == 0;
    }
}
