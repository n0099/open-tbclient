package com.bytedance.sdk.openadsdk.preload.geckox.model;

import android.os.Build;
import androidx.annotation.Keep;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.sapi2.SapiContext;
import com.bytedance.sdk.openadsdk.preload.a.a.c;
@Keep
/* loaded from: classes6.dex */
public class Common {
    @c(a = "ac")
    public String ac;
    @c(a = "aid")
    public long aid;
    @c(a = "app_name")
    public String appName;
    @c(a = "app_version")
    public String appVersion;
    @c(a = "device_id")
    public String deviceId;
    @c(a = "region")
    public String region;
    @c(a = "uid")
    public String uid;
    @c(a = "os")
    public int os = 0;
    @c(a = "os_version")
    public String osVersion = Build.VERSION.SDK_INT + "";
    @c(a = "device_model")
    public String deviceModel = Build.MODEL;
    @c(a = "device_platform")
    public String devicePlatform = HttpConstants.OS_TYPE_VALUE;
    @c(a = SapiContext.KEY_SDK_VERSION)
    public String sdkVersion = "2.0.3-rc.9-pangle";

    public Common(long j, String str, String str2, String str3, String str4) {
        this.aid = j;
        this.appVersion = str;
        this.deviceId = str2;
        this.appName = str3;
        this.ac = str4;
    }

    public Common(long j, String str, String str2, String str3, String str4, String str5, String str6) {
        this.aid = j;
        this.appVersion = str;
        this.deviceId = str2;
        this.appName = str3;
        this.ac = str4;
        this.uid = str5;
        this.region = str6;
    }
}
