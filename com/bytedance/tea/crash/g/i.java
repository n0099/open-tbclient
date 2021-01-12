package com.bytedance.tea.crash.g;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.bytedance.tea.crash.upload.b;
/* loaded from: classes4.dex */
public final class i {
    public static String a(Context context) {
        return a(hZ(context));
    }

    public static String a(b.EnumC1030b enumC1030b) {
        try {
            switch (enumC1030b) {
                case WIFI:
                    return "wifi";
                case MOBILE_2G:
                    return "2g";
                case MOBILE_3G:
                    return "3g";
                case MOBILE_4G:
                    return "4g";
                case MOBILE:
                    return "mobile";
                default:
                    return "";
            }
        } catch (Exception e) {
            return "";
        }
    }

    private static b.EnumC1030b hZ(Context context) {
        b.EnumC1030b enumC1030b;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                enumC1030b = b.EnumC1030b.NONE;
            } else {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
                    enumC1030b = b.EnumC1030b.NONE;
                } else {
                    int type = activeNetworkInfo.getType();
                    if (1 == type) {
                        enumC1030b = b.EnumC1030b.WIFI;
                    } else if (type == 0) {
                        switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
                            case 3:
                            case 5:
                            case 6:
                            case 8:
                            case 9:
                            case 10:
                            case 12:
                            case 14:
                            case 15:
                                enumC1030b = b.EnumC1030b.MOBILE_3G;
                                break;
                            case 4:
                            case 7:
                            case 11:
                            default:
                                enumC1030b = b.EnumC1030b.MOBILE;
                                break;
                            case 13:
                                enumC1030b = b.EnumC1030b.MOBILE_4G;
                                break;
                        }
                    } else {
                        enumC1030b = b.EnumC1030b.MOBILE;
                    }
                }
            }
            return enumC1030b;
        } catch (Throwable th) {
            return b.EnumC1030b.MOBILE;
        }
    }

    public static boolean b(Context context) {
        boolean z;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return false;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.isAvailable()) {
                    z = true;
                    return z;
                }
            }
            z = false;
            return z;
        } catch (Exception e) {
            return false;
        }
    }
}
