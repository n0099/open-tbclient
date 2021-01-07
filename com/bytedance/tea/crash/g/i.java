package com.bytedance.tea.crash.g;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.bytedance.tea.crash.upload.b;
/* loaded from: classes4.dex */
public final class i {
    public static String a(Context context) {
        return a(ib(context));
    }

    public static String a(b.EnumC1047b enumC1047b) {
        try {
            switch (enumC1047b) {
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

    private static b.EnumC1047b ib(Context context) {
        b.EnumC1047b enumC1047b;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                enumC1047b = b.EnumC1047b.NONE;
            } else {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
                    enumC1047b = b.EnumC1047b.NONE;
                } else {
                    int type = activeNetworkInfo.getType();
                    if (1 == type) {
                        enumC1047b = b.EnumC1047b.WIFI;
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
                                enumC1047b = b.EnumC1047b.MOBILE_3G;
                                break;
                            case 4:
                            case 7:
                            case 11:
                            default:
                                enumC1047b = b.EnumC1047b.MOBILE;
                                break;
                            case 13:
                                enumC1047b = b.EnumC1047b.MOBILE_4G;
                                break;
                        }
                    } else {
                        enumC1047b = b.EnumC1047b.MOBILE;
                    }
                }
            }
            return enumC1047b;
        } catch (Throwable th) {
            return b.EnumC1047b.MOBILE;
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
