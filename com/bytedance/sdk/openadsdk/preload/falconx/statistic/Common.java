package com.bytedance.sdk.openadsdk.preload.falconx.statistic;

import android.os.Build;
import androidx.annotation.Keep;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.bytedance.sdk.openadsdk.preload.a.a.c;
@Keep
/* loaded from: classes5.dex */
public class Common {
    @c(a = "app_version")
    public String appVersion;
    @c(a = Constants.KEY_DEVICE_ID)
    public String deviceId;
    @c(a = "region")
    public String region;
    @c(a = "sdk_version")
    public String sdkVersion = "2.0.3-rc.9-pangle";
    @c(a = "device_model")
    public String deviceModel = Build.MODEL;
    @c(a = IAdRequestParam.OS)
    public int os = 0;
}
