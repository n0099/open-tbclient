package com.kwad.sdk.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
/* loaded from: classes3.dex */
public class v {
    public static boolean a(Context context) {
        ConnectivityManager connectivityManager;
        boolean z;
        try {
            if ((ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE") == 0) && (connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")) != null) {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    if (activeNetworkInfo.isConnected()) {
                        z = true;
                        return z;
                    }
                }
                z = false;
                return z;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean b(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        try {
            if ((ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE") == 0) && (connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")) != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected()) {
                return 1 == activeNetworkInfo.getType();
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean c(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        if (context == null) {
            return false;
        }
        try {
            if (!(ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE") == 0) || (connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected()) {
                return false;
            }
            return activeNetworkInfo.getType() == 0;
        } catch (Exception e) {
            return false;
        }
    }

    public static int d(Context context) {
        return f(context);
    }

    public static int e(Context context) {
        int i;
        TelephonyManager telephonyManager;
        int i2 = 0;
        if (context == null) {
            return 0;
        }
        try {
            telephonyManager = (TelephonyManager) context.getSystemService("phone");
        } catch (Exception e) {
            i = i2;
            com.kwad.sdk.core.d.a.a(e);
        }
        if (telephonyManager != null) {
            if (Build.VERSION.SDK_INT >= 22) {
                String simOperator = telephonyManager.getSimOperator();
                char c = 65535;
                switch (simOperator.hashCode()) {
                    case 49679470:
                        if (simOperator.equals("46000")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 49679471:
                        if (simOperator.equals("46001")) {
                            c = 4;
                            break;
                        }
                        break;
                    case 49679472:
                        if (simOperator.equals("46002")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 49679473:
                        if (simOperator.equals("46003")) {
                            c = 7;
                            break;
                        }
                        break;
                    case 49679475:
                        if (simOperator.equals("46005")) {
                            c = '\b';
                            break;
                        }
                        break;
                    case 49679476:
                        if (simOperator.equals("46006")) {
                            c = 5;
                            break;
                        }
                        break;
                    case 49679477:
                        if (simOperator.equals("46007")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 49679478:
                        if (simOperator.equals("46008")) {
                            c = 3;
                            break;
                        }
                        break;
                    case 49679479:
                        if (simOperator.equals("46009")) {
                            c = 6;
                            break;
                        }
                        break;
                    case 49679502:
                        if (simOperator.equals("46011")) {
                            c = '\t';
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                        i2 = 1;
                        break;
                    case 4:
                    case 5:
                    case 6:
                        i2 = 3;
                        break;
                    case 7:
                    case '\b':
                    case '\t':
                        i2 = 2;
                        break;
                }
            }
            if (i2 == 0 && ContextCompat.checkSelfPermission(context, "android.permission.READ_PHONE_STATE") == 0) {
                String subscriberId = telephonyManager.getSubscriberId();
                if (TextUtils.isEmpty(subscriberId)) {
                    return i2;
                }
                if (subscriberId.startsWith("46000") || subscriberId.startsWith("46002")) {
                    i = 1;
                } else if (subscriberId.startsWith("46001")) {
                    i = 3;
                } else if (subscriberId.startsWith("46003")) {
                    i = 2;
                }
                return i;
            }
            i = i2;
            return i;
        }
        return 0;
    }

    private static byte f(Context context) {
        if (context != null && a(context)) {
            if (b(context)) {
                return (byte) 100;
            }
            TelephonyManager telephonyManager = (TelephonyManager) context.getApplicationContext().getSystemService("phone");
            if (telephonyManager != null) {
                switch (telephonyManager.getNetworkType()) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                    case 16:
                        return (byte) 2;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                        return (byte) 3;
                    case 13:
                        return (byte) 4;
                    default:
                        return (byte) 0;
                }
            }
            return (byte) 0;
        }
        return (byte) 0;
    }
}
