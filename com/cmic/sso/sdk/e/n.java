package com.cmic.sso.sdk.e;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.reflect.Method;
/* loaded from: classes8.dex */
public class n {
    public static int a(Context context, String str) {
        ConnectivityManager connectivityManager;
        NetworkInfo networkInfo;
        try {
            connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
            networkInfo = null;
            if (connectivityManager != null) {
                networkInfo = connectivityManager.getActiveNetworkInfo();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (networkInfo == null || !networkInfo.isAvailable()) {
            return 0;
        }
        int type = networkInfo.getType();
        if (type == 1) {
            c.b("TelephonyUtils", "WIFI");
            boolean a2 = g.a(context, "android.permission.CHANGE_NETWORK_STATE");
            c.a("TelephonyUtils", "CHANGE_NETWORK_STATE=" + a2);
            if (a2 && !TextUtils.isEmpty(str) && a(context, connectivityManager)) {
                c.b("TelephonyUtils", "流量数据 WIFI 同开");
                return 3;
            }
            return 2;
        }
        if (type == 0) {
            c.b("TelephonyUtils", "流量");
            return 1;
        }
        return 0;
    }

    private static boolean a(Context context, ConnectivityManager connectivityManager) {
        try {
            Method declaredMethod = ConnectivityManager.class.getDeclaredMethod("getMobileDataEnabled", new Class[0]);
            declaredMethod.setAccessible(true);
            boolean booleanValue = ((Boolean) declaredMethod.invoke(connectivityManager, new Object[0])).booleanValue();
            c.b("TelephonyUtils", "data is on ---------" + booleanValue);
            return booleanValue;
        } catch (Exception e) {
            c.a("TelephonyUtils", "isMobileEnabled ----反射出错-----");
            return false;
        }
    }

    public static String a() {
        return Build.BRAND;
    }

    public static String b() {
        return Build.MODEL;
    }

    public static String c() {
        return "android" + Build.VERSION.RELEASE;
    }

    public static boolean d() {
        return Build.VERSION.SDK_INT <= 28;
    }

    public static boolean e() {
        String str = Build.MANUFACTURER;
        c.a(Constants.PHONE_BRAND, str);
        return "HUAWEI".equalsIgnoreCase(str);
    }

    public static boolean a(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        return telephonyManager == null || 1 != telephonyManager.getSimState();
    }
}
