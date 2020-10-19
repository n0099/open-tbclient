package com.sina.deviceidjnisdk;

import android.content.Context;
/* loaded from: classes12.dex */
public class DeviceId implements IDeviceId {
    private Context mContext;

    private native String getDeviceIdNative(Context context, String str, String str2, String str3);

    static {
        System.loadLibrary("weibosdkcore");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public DeviceId(Context context) {
        this.mContext = context.getApplicationContext();
    }

    @Override // com.sina.deviceidjnisdk.IDeviceId
    public String getDeviceId() {
        return getDeviceIdNative(this.mContext, DeviceInfo.getImei(this.mContext), DeviceInfo.getImsi(this.mContext), DeviceInfo.getMacAddress(this.mContext));
    }

    private String genCheckId(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append(str).append(str2).append(str3);
        return sb.toString();
    }
}
