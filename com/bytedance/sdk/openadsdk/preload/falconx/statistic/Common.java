package com.bytedance.sdk.openadsdk.preload.falconx.statistic;

import android.os.Build;
import androidx.annotation.Keep;
import com.baidu.sapi2.SapiContext;
import com.bytedance.sdk.openadsdk.preload.a.a.c;
@Keep
/* loaded from: classes6.dex */
public class Common {
    @c(a = "app_version")
    public String appVersion;
    @c(a = "device_id")
    public String deviceId;
    @c(a = "region")
    public String region;
    @c(a = SapiContext.KEY_SDK_VERSION)
    public String sdkVersion = "2.0.3-rc.9-pangle";
    @c(a = "device_model")
    public String deviceModel = Build.MODEL;
    @c(a = "os")
    public int os = 0;
}
