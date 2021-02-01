package com.yy.mediaframework.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.provider.Settings;
import com.baidu.mobstat.Config;
import com.yy.mediaframework.YYVideoSDK;
import java.net.NetworkInterface;
import java.util.Collections;
/* loaded from: classes4.dex */
public class InfoUtil {
    private static final String TAG = "InfoUtil";

    public static String getAndroidId() {
        return Settings.Secure.getString(YYVideoSDK.getInstance().getAppContext().getContentResolver(), "android_id");
    }

    public static String getAppPackage() {
        return YYVideoSDK.getInstance().getAppContext().getPackageName();
    }

    public static String getAppVerCode() {
        int i = 0;
        Context appContext = YYVideoSDK.getInstance().getAppContext();
        try {
            i = appContext.getPackageManager().getPackageInfo(getAppPackage(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            YMFLog.error((Object) null, "[Util    ]", "getAppVerCode exception:" + e.toString());
        }
        return i + "";
    }

    public static String getVersionName() {
        PackageInfo packageInfo = null;
        Context appContext = YYVideoSDK.getInstance().getAppContext();
        try {
            packageInfo = appContext.getPackageManager().getPackageInfo(appContext.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            YMFLog.error((Object) null, "[Util    ]", "getVersionName exception:" + e.toString());
        }
        return packageInfo.versionName;
    }

    public static String getMacAddr() {
        try {
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (networkInterface.getName().equalsIgnoreCase("wlan0")) {
                    byte[] hardwareAddress = networkInterface.getHardwareAddress();
                    if (hardwareAddress == null) {
                        return "";
                    }
                    StringBuilder sb = new StringBuilder();
                    int length = hardwareAddress.length;
                    for (int i = 0; i < length; i++) {
                        sb.append(String.format("%02X:", Byte.valueOf(hardwareAddress[i])));
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    return sb.toString();
                }
            }
        } catch (Exception e) {
            YMFLog.error((Object) null, "[Util    ]", "exception:" + e.toString());
        }
        return Config.DEF_MAC_ID;
    }
}
