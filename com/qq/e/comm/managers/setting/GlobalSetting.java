package com.qq.e.comm.managers.setting;

import com.qq.e.comm.pi.CustomLandingPageListener;
/* loaded from: classes6.dex */
public final class GlobalSetting {

    /* renamed from: a  reason: collision with root package name */
    public static volatile CustomLandingPageListener f38310a = null;

    /* renamed from: b  reason: collision with root package name */
    public static volatile Integer f38311b = null;

    /* renamed from: c  reason: collision with root package name */
    public static volatile boolean f38312c = false;

    /* renamed from: d  reason: collision with root package name */
    public static volatile boolean f38313d = true;

    /* renamed from: e  reason: collision with root package name */
    public static volatile Boolean f38314e;

    /* renamed from: f  reason: collision with root package name */
    public static volatile String f38315f;

    /* renamed from: g  reason: collision with root package name */
    public static volatile String f38316g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile String f38317h;
    public static volatile String i;
    public static volatile String j;

    public static Integer getChannel() {
        return f38311b;
    }

    public static String getCustomADActivityClassName() {
        return f38315f;
    }

    public static CustomLandingPageListener getCustomLandingPageListener() {
        return f38310a;
    }

    public static String getCustomLandscapeActivityClassName() {
        return i;
    }

    public static String getCustomPortraitActivityClassName() {
        return f38316g;
    }

    public static String getCustomRewardvideoLandscapeActivityClassName() {
        return j;
    }

    public static String getCustomRewardvideoPortraitActivityClassName() {
        return f38317h;
    }

    public static Boolean isAgreePrivacyStrategy() {
        return f38314e;
    }

    public static boolean isAgreePrivacyStrategyNonNull() {
        if (f38314e != null) {
            return f38314e.booleanValue();
        }
        return true;
    }

    public static boolean isEnableMediationTool() {
        return f38312c;
    }

    public static boolean isEnableVideoDownloadingCache() {
        return f38313d;
    }

    public static void setAgreePrivacyStrategy(boolean z) {
        if (f38314e == null) {
            f38314e = Boolean.valueOf(z);
        }
    }

    public static void setChannel(int i2) {
        if (f38311b == null) {
            f38311b = Integer.valueOf(i2);
        }
    }

    public static void setCustomADActivityClassName(String str) {
        f38315f = str;
    }

    public static void setCustomLandingPageListener(CustomLandingPageListener customLandingPageListener) {
        f38310a = customLandingPageListener;
    }

    public static void setCustomLandscapeActivityClassName(String str) {
        i = str;
    }

    public static void setCustomPortraitActivityClassName(String str) {
        f38316g = str;
    }

    public static void setCustomRewardvideoLandscapeActivityClassName(String str) {
        j = str;
    }

    public static void setCustomRewardvideoPortraitActivityClassName(String str) {
        f38317h = str;
    }

    public static void setEnableMediationTool(boolean z) {
        f38312c = z;
    }

    public static void setEnableVideoDownloadingCache(boolean z) {
        f38313d = z;
    }
}
