package com.meizu.cloud.pushsdk.util;

import android.os.Build;
/* loaded from: classes16.dex */
public class MinSdkChecker {
    public static boolean isSupportBigTextStyleAndAction() {
        return Build.VERSION.SDK_INT >= 16;
    }

    public static boolean isSupportDeviceDefaultLight() {
        return Build.VERSION.SDK_INT >= 14;
    }

    public static boolean isSupportKeyguardState() {
        return Build.VERSION.SDK_INT >= 16;
    }

    public static boolean isSupportNotificationBuild() {
        return Build.VERSION.SDK_INT >= 16;
    }

    public static boolean isSupportNotificationChannel() {
        return Build.VERSION.SDK_INT >= 26;
    }

    public static boolean isSupportSendNotification() {
        return Build.VERSION.SDK_INT >= 21;
    }

    public static boolean isSupportSetDrawableSmallIcon() {
        return Build.VERSION.SDK_INT >= 23;
    }

    public static boolean isSupportVideoNotification() {
        return Build.VERSION.SDK_INT >= 19;
    }
}
