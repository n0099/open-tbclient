package com.kwad.sdk.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
/* loaded from: classes5.dex */
public class ad {
    public static boolean a(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        try {
            if (!(ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE") == 0) || (connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return false;
            }
            return activeNetworkInfo.isConnected();
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static int c(Context context) {
        return e(context);
    }

    public static int d(Context context) {
        TelephonyManager telephonyManager;
        int i = 0;
        if (context == null) {
            return 0;
        }
        try {
            telephonyManager = (TelephonyManager) context.getSystemService("phone");
        } catch (Exception e) {
            com.kwad.sdk.core.d.a.b(e);
        }
        if (telephonyManager == null) {
            return 0;
        }
        if (Build.VERSION.SDK_INT >= 22) {
            String simOperator = telephonyManager.getSimOperator();
            char c = 65535;
            int hashCode = simOperator.hashCode();
            if (hashCode != 49679502) {
                switch (hashCode) {
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
                    default:
                        switch (hashCode) {
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
                        }
                }
            } else if (simOperator.equals("46011")) {
                c = '\t';
            }
            switch (c) {
                case 0:
                case 1:
                case 2:
                case 3:
                    i = 1;
                    break;
                case 4:
                case 5:
                case 6:
                    i = 3;
                    break;
                case 7:
                case '\b':
                case '\t':
                    i = 2;
                    break;
            }
        }
        if (i == 0) {
            String h = av.h(context);
            if (TextUtils.isEmpty(h)) {
                return i;
            }
            if (!h.startsWith("46000") && !h.startsWith("46002")) {
                if (h.startsWith("46001")) {
                    return 3;
                }
                if (h.startsWith("46003")) {
                    return 2;
                }
            }
            return 1;
        }
        return i;
    }

    public static byte e(Context context) {
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
