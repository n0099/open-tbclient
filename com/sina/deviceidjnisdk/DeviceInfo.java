package com.sina.deviceidjnisdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
/* loaded from: classes6.dex */
public class DeviceInfo {
    @SuppressLint({"MissingPermission"})
    public static String getDeviceId(Context context) {
        TelephonyManager telephonyManager;
        String deviceId;
        String str = null;
        if (isPermissionGranted(context, "android.permission.READ_PHONE_STATE")) {
            try {
                telephonyManager = (TelephonyManager) context.getSystemService("phone");
            } catch (Exception unused) {
            }
            if (telephonyManager == null) {
                return null;
            }
            if (Build.VERSION.SDK_INT >= 23) {
                deviceId = telephonyManager.getDeviceId(0);
            } else {
                deviceId = telephonyManager.getDeviceId();
            }
            if (deviceId != null) {
                str = deviceId;
            }
            str = "";
        }
        return str == null ? "" : str;
    }

    public static String getImei(Context context) {
        return getDeviceId(context);
    }

    @SuppressLint({"MissingPermission"})
    public static String getImsi(Context context) {
        String str;
        if (isPermissionGranted(context, "android.permission.READ_PHONE_STATE")) {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                return null;
            }
            str = telephonyManager.getSubscriberId();
        } else {
            str = "";
        }
        return str == null ? "" : str;
    }

    public static String getMacAddress(Context context) {
        WifiInfo connectionInfo;
        String str = null;
        if (isPermissionGranted(context, "android.permission.ACCESS_WIFI_STATE")) {
            try {
                WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
                if (wifiManager == null || (connectionInfo = wifiManager.getConnectionInfo()) == null) {
                    return null;
                }
                str = connectionInfo.getMacAddress();
            } catch (Exception unused) {
                str = "";
            }
        }
        return str == null ? "" : str;
    }

    public static boolean isPermissionGranted(Context context, String str) {
        return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
    }
}
