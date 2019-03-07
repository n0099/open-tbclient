package com.sina.deviceidjnisdk;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
/* loaded from: classes2.dex */
public class DeviceIdFactory {
    private static volatile IDeviceId sInstance;

    public static native String calculateM(Context context, String str, String str2);

    private static native String getIValueNative(Context context, String str);

    private static native IDeviceId getInstanceNative(Context context, int i);

    static {
        System.loadLibrary("weibosdkcore");
    }

    private DeviceIdFactory() {
    }

    public static synchronized IDeviceId getInstance(Context context) {
        IDeviceId iDeviceId;
        synchronized (DeviceIdFactory.class) {
            if (sInstance == null) {
                sInstance = new DeviceId(context);
            }
            iDeviceId = sInstance;
        }
        return iDeviceId;
    }

    public static synchronized String getIValue(Context context) {
        String str;
        String deviceId;
        synchronized (DeviceIdFactory.class) {
            try {
                deviceId = ((TelephonyManager) context.getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE)).getDeviceId();
                if (TextUtils.isEmpty(deviceId)) {
                    WifiInfo connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
                    deviceId = connectionInfo != null ? connectionInfo.getMacAddress() : "";
                }
                if (TextUtils.isEmpty(deviceId)) {
                    deviceId = "000000000000000";
                }
            } catch (Exception e) {
            }
            if (!TextUtils.isEmpty(deviceId)) {
                str = getIValueNative(context, deviceId);
            }
            str = "";
        }
        return str;
    }
}
