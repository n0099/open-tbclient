package com.bytedance.sdk.openadsdk.preload.geckox.model;

import android.os.Build;
import androidx.annotation.Keep;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.bytedance.sdk.openadsdk.preload.a.a.c;
@Keep
/* loaded from: classes5.dex */
public class Common {
    @c(a = "ac")
    public String ac;
    @c(a = "aid")
    public long aid;
    @c(a = DpStatConstants.KEY_APP_NAME)
    public String appName;
    @c(a = "app_version")
    public String appVersion;
    @c(a = Constants.KEY_DEVICE_ID)
    public String deviceId;
    @c(a = "region")
    public String region;
    @c(a = "uid")
    public String uid;
    @c(a = IAdRequestParam.OS)
    public int os = 0;
    @c(a = "os_version")
    public String osVersion = Build.VERSION.SDK_INT + "";
    @c(a = "device_model")
    public String deviceModel = Build.MODEL;
    @c(a = "device_platform")
    public String devicePlatform = "android";
    @c(a = "sdk_version")
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
