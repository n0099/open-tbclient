package com.thunder.livesdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.thunder.livesdk.log.ThunderLog;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes6.dex */
public class ThunderDeviceInfo {
    public String appInfo;
    public String osVersion = Build.VERSION.SDK_INT + "";
    public String manufacturer = Build.MANUFACTURER;
    public String model = Build.MODEL;
    public String deviceID = "";
    public long imsi = 0;

    private String getAppName(Context context) {
        try {
            return context.getResources().getString(context.getApplicationInfo().labelRes);
        } catch (Exception e) {
            e.printStackTrace();
            return "null";
        }
    }

    private String getAppVersion(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception e) {
            ThunderLog.warn(ThunderLog.kLogTagSdk, "read app version exception %s", e == null ? "null" : e.getMessage());
            return "null";
        }
    }

    private static boolean isDebug(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        return (applicationInfo == null || (applicationInfo.flags & 2) == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"HardwareIds"})
    public ThunderDeviceInfo(Context context) {
        this.appInfo = getAppName(context);
        this.appInfo += Constants.ACCEPT_TIME_SEPARATOR_SERVER + getAppVersion(context);
        if (isDebug(context)) {
            this.appInfo += "-Debug";
        }
        ThunderLog.release(ThunderLog.kLogTagSdk, "Device info: %s %s %s, %s, %d, %s", this.manufacturer, this.model, this.osVersion, this.deviceID, Long.valueOf(this.imsi), this.appInfo);
    }
}
