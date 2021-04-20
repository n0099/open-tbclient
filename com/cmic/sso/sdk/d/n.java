package com.cmic.sso.sdk.d;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import java.lang.reflect.Method;
/* loaded from: classes5.dex */
public class n {
    public static int a(Context context, String str) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        try {
            connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
            activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
            int type = activeNetworkInfo.getType();
            if (type != 1) {
                if (type == 0) {
                    c.b("TelephonyUtils", "流量");
                    return 1;
                }
                return 0;
            }
            c.b("TelephonyUtils", CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING);
            boolean a2 = g.a(context, "android.permission.CHANGE_NETWORK_STATE");
            StringBuilder sb = new StringBuilder();
            sb.append("CHANGE_NETWORK_STATE=");
            sb.append(a2);
            c.a("TelephonyUtils", sb.toString());
            if (a2 && !TextUtils.isEmpty(str) && a(context, connectivityManager)) {
                c.b("TelephonyUtils", "流量数据 WIFI 同开");
                return 3;
            }
            return 2;
        }
        return 0;
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
        c.a("brand", str);
        return "HUAWEI".equalsIgnoreCase(str);
    }

    public static boolean a(Context context, ConnectivityManager connectivityManager) {
        try {
            Method declaredMethod = ConnectivityManager.class.getDeclaredMethod("getMobileDataEnabled", new Class[0]);
            declaredMethod.setAccessible(true);
            boolean booleanValue = ((Boolean) declaredMethod.invoke(connectivityManager, new Object[0])).booleanValue();
            StringBuilder sb = new StringBuilder();
            sb.append("data is on ---------");
            sb.append(booleanValue);
            c.b("TelephonyUtils", sb.toString());
            return booleanValue;
        } catch (Exception unused) {
            c.a("TelephonyUtils", "isMobileEnabled ----反射出错-----");
            return false;
        }
    }

    public static String a() {
        return Build.BRAND;
    }

    public static boolean a(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        return telephonyManager == null || 1 != telephonyManager.getSimState();
    }
}
