package com.qq.e.comm.managers.status;

import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
/* loaded from: classes15.dex */
public class SDKStatus {
    public static final int STUB_IDENTITY = 1;
    public static final boolean isNoPlugin = true;

    public static final String getIntegrationSDKVersion() {
        return "4.291.1161";
    }

    public static final String getSDKVersion() {
        return "4.291";
    }

    public static final int getSDKVersionCode() {
        return IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER;
    }
}
