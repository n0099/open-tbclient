package com.sina.deviceidjnisdk;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
/* loaded from: classes2.dex */
class DeviceInfo {
    DeviceInfo() {
    }

    public static String getImei(Context context) {
        String str = "";
        if (checkMyPermission(context, "android.permission.READ_PHONE_STATE").booleanValue()) {
            str = ((TelephonyManager) context.getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE)).getDeviceId();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    public static String getWifiMac(Context context) {
        String str = "";
        if (checkMyPermission(context, "android.permission.ACCESS_WIFI_STATE").booleanValue()) {
            str = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo().getMacAddress();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    private static Boolean checkMyPermission(Context context, String str) {
        return Boolean.valueOf(context.getPackageManager().checkPermission(str, context.getPackageName()) == 0);
    }

    public static String getImsi(Context context) {
        String str = "";
        if (checkMyPermission(context, "android.permission.READ_PHONE_STATE").booleanValue()) {
            str = ((TelephonyManager) context.getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE)).getSubscriberId();
        }
        if (str == null) {
            return "";
        }
        return str;
    }
}
