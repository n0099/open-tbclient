package com.sina.deviceidjnisdk;

import android.content.Context;
import android.text.TextUtils;
/* loaded from: classes6.dex */
public class DeviceIdFactory {
    public static volatile IDeviceId sInstance;

    static {
        System.loadLibrary("weibosdkcore");
    }

    public static native String calculateM(Context context, String str, String str2);

    public static synchronized String getIValue(Context context) {
        synchronized (DeviceIdFactory.class) {
            try {
                String deviceId = DeviceInfo.getDeviceId(context);
                if (TextUtils.isEmpty(deviceId)) {
                    deviceId = DeviceInfo.getMacAddress(context);
                }
                if (TextUtils.isEmpty(deviceId)) {
                    deviceId = "000000000000000";
                }
                if (!TextUtils.isEmpty(deviceId)) {
                    return getIValueNative(context, deviceId);
                }
            } catch (Exception unused) {
            }
            return null;
        }
    }

    public static native String getIValueNative(Context context, String str);

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

    public static native IDeviceId getInstanceNative(Context context, int i2);
}
