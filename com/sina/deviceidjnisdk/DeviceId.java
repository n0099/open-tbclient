package com.sina.deviceidjnisdk;

import android.content.Context;
/* loaded from: classes6.dex */
public class DeviceId implements IDeviceId {
    public Context mContext;

    static {
        System.loadLibrary("weibosdkcore");
    }

    public DeviceId(Context context) {
        this.mContext = context.getApplicationContext();
    }

    private String genCheckId(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    private native String getDeviceIdNative(Context context, String str, String str2, String str3);

    @Override // com.sina.deviceidjnisdk.IDeviceId
    public String getDeviceId() {
        Context context = this.mContext;
        return getDeviceIdNative(context, DeviceInfo.getImei(context), DeviceInfo.getImsi(this.mContext), DeviceInfo.getMacAddress(this.mContext));
    }
}
