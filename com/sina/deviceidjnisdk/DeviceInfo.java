package com.sina.deviceidjnisdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
/* loaded from: classes2.dex */
public class DeviceInfo {
    @SuppressLint({"MissingPermission"})
    public static String getDeviceId(Context context) {
        String str;
        if (isPermissionGranted(context, "android.permission.READ_PHONE_STATE")) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager == null) {
                    return null;
                }
                if (Build.VERSION.SDK_INT >= 23) {
                    str = telephonyManager.getDeviceId(0);
                } else {
                    str = telephonyManager.getDeviceId();
                }
                if (str == null) {
                    str = "";
                }
            } catch (Exception e) {
                e.printStackTrace();
                str = "";
            }
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    public static String getMacAddress(Context context) {
        String str;
        WifiInfo connectionInfo;
        if (isPermissionGranted(context, "android.permission.ACCESS_WIFI_STATE")) {
            try {
                WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
                if (wifiManager != null && (connectionInfo = wifiManager.getConnectionInfo()) != null) {
                    str = connectionInfo.getMacAddress();
                }
                return null;
            } catch (Exception e) {
                str = "";
            }
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    public static String getImei(Context context) {
        return getDeviceId(context);
    }

    @SuppressLint({"MissingPermission"})
    public static String getImsi(Context context) {
        String str = "";
        if (isPermissionGranted(context, "android.permission.READ_PHONE_STATE")) {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                return null;
            }
            str = telephonyManager.getSubscriberId();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    private static boolean isPermissionGranted(Context context, String str) {
        return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
    }
}
