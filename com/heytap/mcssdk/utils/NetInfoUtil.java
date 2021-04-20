package com.heytap.mcssdk.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.apollon.statistics.g;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
@SuppressLint({"DefaultLocale"})
/* loaded from: classes6.dex */
public class NetInfoUtil {
    public static final int NETWORK_CLASS_2_G = 1;
    public static final int NETWORK_CLASS_3_G = 2;
    public static final int NETWORK_CLASS_4_G = 3;
    public static final int NETWORK_CLASS_UNAVAILABLE = -1;
    public static final int NETWORK_CLASS_UNKNOWN = 0;
    public static final int NETWORK_CLASS_WIFI = -101;
    public static final int NETWORK_TYPE_1xRTT = 7;
    public static final int NETWORK_TYPE_CDMA = 4;
    public static final int NETWORK_TYPE_EDGE = 2;
    public static final int NETWORK_TYPE_EHRPD = 14;
    public static final int NETWORK_TYPE_EVDO_0 = 5;
    public static final int NETWORK_TYPE_EVDO_A = 6;
    public static final int NETWORK_TYPE_EVDO_B = 12;
    public static final int NETWORK_TYPE_GPRS = 1;
    public static final int NETWORK_TYPE_HSDPA = 8;
    public static final int NETWORK_TYPE_HSPA = 10;
    public static final int NETWORK_TYPE_HSPAP = 15;
    public static final int NETWORK_TYPE_HSUPA = 9;
    public static final int NETWORK_TYPE_IDEN = 11;
    public static final int NETWORK_TYPE_LTE = 13;
    public static final int NETWORK_TYPE_UMTS = 3;
    public static final int NETWORK_TYPE_UNAVAILABLE = -1;
    public static final int NETWORK_TYPE_UNKNOWN = 0;
    public static final int NETWORK_TYPE_WIFI = -101;

    @SuppressLint({"DefaultLocale"})
    public static String getNetType(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
            if (activeNetworkInfo != null) {
                String upperCase = activeNetworkInfo.getTypeName().toUpperCase();
                if (upperCase.equals("MOBILE")) {
                    String extraInfo = activeNetworkInfo.getExtraInfo();
                    return !TextUtils.isEmpty(extraInfo) ? extraInfo.toUpperCase() : upperCase;
                }
                return upperCase;
            }
            return "0";
        } catch (Exception e2) {
            LogUtil.e(e2);
            return "0";
        }
    }

    public static int getNetworkClassByType(int i) {
        int i2 = -101;
        if (i != -101) {
            i2 = -1;
            if (i != -1) {
                switch (i) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        return 1;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                        return 2;
                    case 13:
                        return 3;
                    default:
                        return 0;
                }
            }
        }
        return i2;
    }

    public static String getNetworkType(Context context) {
        TelephonyManager telephonyManager;
        int i = 0;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnected()) {
                int type = activeNetworkInfo.getType();
                if (type == 1) {
                    i = -101;
                } else if (type == 0 && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null) {
                    i = telephonyManager.getNetworkType();
                }
            } else {
                i = -1;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        int networkClassByType = getNetworkClassByType(i);
        return networkClassByType != -101 ? (networkClassByType == -1 || networkClassByType == 0) ? RomUtils.UNKNOWN : networkClassByType != 1 ? networkClassByType != 2 ? networkClassByType != 3 ? RomUtils.UNKNOWN : "4G" : g.f3909b : "2G" : CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING;
    }

    public static boolean is2GNetwork(Context context) {
        try {
            String netType = getNetType(context);
            if (!netType.equals("UNINET") && !netType.equals("UNIWAP") && !netType.equals("CMNET") && !netType.equals("CMWAP") && !netType.equals("CTNET")) {
                if (!netType.equals("CTWAP")) {
                    return false;
                }
            }
            return true;
        } catch (Exception e2) {
            LogUtil.e(e2);
            return false;
        }
    }

    public static boolean is3GNetwork(Context context) {
        try {
            String netType = getNetType(context);
            if (!netType.equals("3GNET")) {
                if (!netType.equals("3GWAP")) {
                    return false;
                }
            }
            return true;
        } catch (Exception e2) {
            LogUtil.e(e2);
            return false;
        }
    }

    public static boolean isConnectNet(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isConnected();
            }
            return false;
        } catch (Exception e2) {
            LogUtil.e(e2);
            return false;
        }
    }

    public static boolean isWapNet(Context context) {
        String netType = getNetType(context);
        return netType.equals("CMWAP") || netType.equals("3GWAP") || netType.equals("UNIWAP");
    }

    public static boolean isWifiNetWork(Context context) {
        try {
            return getNetType(context).equals(CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING);
        } catch (Exception e2) {
            LogUtil.e(e2);
            return false;
        }
    }
}
