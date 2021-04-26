package com.kwad.sdk.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.bumptech.glide.manager.DefaultConnectivityMonitorFactory;
/* loaded from: classes6.dex */
public class t {
    public static boolean a(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        try {
            if (!(ContextCompat.checkSelfPermission(context, DefaultConnectivityMonitorFactory.NETWORK_PERMISSION) == 0) || (connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return false;
            }
            return activeNetworkInfo.isConnected();
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean b(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        try {
            if ((ContextCompat.checkSelfPermission(context, DefaultConnectivityMonitorFactory.NETWORK_PERMISSION) == 0) && (connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")) != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected()) {
                return 1 == activeNetworkInfo.getType();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return false;
    }

    public static int c(Context context) {
        return e(context);
    }

    public static int d(Context context) {
        TelephonyManager telephonyManager;
        int i2 = 0;
        if (context == null) {
            return 0;
        }
        try {
            telephonyManager = (TelephonyManager) context.getSystemService("phone");
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
        if (telephonyManager == null) {
            return 0;
        }
        if (Build.VERSION.SDK_INT >= 22) {
            String simOperator = telephonyManager.getSimOperator();
            char c2 = 65535;
            int hashCode = simOperator.hashCode();
            if (hashCode != 49679502) {
                switch (hashCode) {
                    case 49679470:
                        if (simOperator.equals("46000")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case 49679471:
                        if (simOperator.equals("46001")) {
                            c2 = 4;
                            break;
                        }
                        break;
                    case 49679472:
                        if (simOperator.equals("46002")) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case 49679473:
                        if (simOperator.equals("46003")) {
                            c2 = 7;
                            break;
                        }
                        break;
                    default:
                        switch (hashCode) {
                            case 49679475:
                                if (simOperator.equals("46005")) {
                                    c2 = '\b';
                                    break;
                                }
                                break;
                            case 49679476:
                                if (simOperator.equals("46006")) {
                                    c2 = 5;
                                    break;
                                }
                                break;
                            case 49679477:
                                if (simOperator.equals("46007")) {
                                    c2 = 2;
                                    break;
                                }
                                break;
                            case 49679478:
                                if (simOperator.equals("46008")) {
                                    c2 = 3;
                                    break;
                                }
                                break;
                            case 49679479:
                                if (simOperator.equals("46009")) {
                                    c2 = 6;
                                    break;
                                }
                                break;
                        }
                }
            } else if (simOperator.equals("46011")) {
                c2 = '\t';
            }
            switch (c2) {
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
            if (!subscriberId.startsWith("46000") && !subscriberId.startsWith("46002")) {
                if (subscriberId.startsWith("46001")) {
                    return 3;
                }
                if (subscriberId.startsWith("46003")) {
                    return 2;
                }
            }
            return 1;
        }
        return i2;
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
