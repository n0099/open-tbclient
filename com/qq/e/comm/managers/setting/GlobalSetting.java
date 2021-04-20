package com.qq.e.comm.managers.setting;

import com.qq.e.comm.pi.CustomLandingPageListener;
/* loaded from: classes6.dex */
public final class GlobalSetting {

    /* renamed from: a  reason: collision with root package name */
    public static volatile CustomLandingPageListener f38599a = null;

    /* renamed from: b  reason: collision with root package name */
    public static volatile Integer f38600b = null;

    /* renamed from: c  reason: collision with root package name */
    public static volatile boolean f38601c = false;

    /* renamed from: d  reason: collision with root package name */
    public static volatile boolean f38602d = true;

    /* renamed from: e  reason: collision with root package name */
    public static volatile Boolean f38603e;

    /* renamed from: f  reason: collision with root package name */
    public static volatile String f38604f;

    /* renamed from: g  reason: collision with root package name */
    public static volatile String f38605g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile String f38606h;
    public static volatile String i;
    public static volatile String j;

    public static Integer getChannel() {
        return f38600b;
    }

    public static String getCustomADActivityClassName() {
        return f38604f;
    }

    public static CustomLandingPageListener getCustomLandingPageListener() {
        return f38599a;
    }

    public static String getCustomLandscapeActivityClassName() {
        return i;
    }

    public static String getCustomPortraitActivityClassName() {
        return f38605g;
    }

    public static String getCustomRewardvideoLandscapeActivityClassName() {
        return j;
    }

    public static String getCustomRewardvideoPortraitActivityClassName() {
        return f38606h;
    }

    public static Boolean isAgreePrivacyStrategy() {
        return f38603e;
    }

    public static boolean isAgreePrivacyStrategyNonNull() {
        if (f38603e != null) {
            return f38603e.booleanValue();
        }
        return true;
    }

    public static boolean isEnableMediationTool() {
        return f38601c;
    }

    public static boolean isEnableVideoDownloadingCache() {
        return f38602d;
    }

    public static void setAgreePrivacyStrategy(boolean z) {
        if (f38603e == null) {
            f38603e = Boolean.valueOf(z);
        }
    }

    public static void setChannel(int i2) {
        if (f38600b == null) {
            f38600b = Integer.valueOf(i2);
        }
    }

    public static void setCustomADActivityClassName(String str) {
        f38604f = str;
    }

    public static void setCustomLandingPageListener(CustomLandingPageListener customLandingPageListener) {
        f38599a = customLandingPageListener;
    }

    public static void setCustomLandscapeActivityClassName(String str) {
        i = str;
    }

    public static void setCustomPortraitActivityClassName(String str) {
        f38605g = str;
    }

    public static void setCustomRewardvideoLandscapeActivityClassName(String str) {
        j = str;
    }

    public static void setCustomRewardvideoPortraitActivityClassName(String str) {
        f38606h = str;
    }

    public static void setEnableMediationTool(boolean z) {
        f38601c = z;
    }

    public static void setEnableVideoDownloadingCache(boolean z) {
        f38602d = z;
    }
}
