package com.qq.e.comm.managers.setting;

import com.qq.e.comm.pi.CustomLandingPageListener;
/* loaded from: classes6.dex */
public final class GlobalSetting {

    /* renamed from: a  reason: collision with root package name */
    public static volatile CustomLandingPageListener f38309a = null;

    /* renamed from: b  reason: collision with root package name */
    public static volatile Integer f38310b = null;

    /* renamed from: c  reason: collision with root package name */
    public static volatile boolean f38311c = false;

    /* renamed from: d  reason: collision with root package name */
    public static volatile boolean f38312d = true;

    /* renamed from: e  reason: collision with root package name */
    public static volatile Boolean f38313e;

    /* renamed from: f  reason: collision with root package name */
    public static volatile String f38314f;

    /* renamed from: g  reason: collision with root package name */
    public static volatile String f38315g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile String f38316h;
    public static volatile String i;
    public static volatile String j;

    public static Integer getChannel() {
        return f38310b;
    }

    public static String getCustomADActivityClassName() {
        return f38314f;
    }

    public static CustomLandingPageListener getCustomLandingPageListener() {
        return f38309a;
    }

    public static String getCustomLandscapeActivityClassName() {
        return i;
    }

    public static String getCustomPortraitActivityClassName() {
        return f38315g;
    }

    public static String getCustomRewardvideoLandscapeActivityClassName() {
        return j;
    }

    public static String getCustomRewardvideoPortraitActivityClassName() {
        return f38316h;
    }

    public static Boolean isAgreePrivacyStrategy() {
        return f38313e;
    }

    public static boolean isAgreePrivacyStrategyNonNull() {
        if (f38313e != null) {
            return f38313e.booleanValue();
        }
        return true;
    }

    public static boolean isEnableMediationTool() {
        return f38311c;
    }

    public static boolean isEnableVideoDownloadingCache() {
        return f38312d;
    }

    public static void setAgreePrivacyStrategy(boolean z) {
        if (f38313e == null) {
            f38313e = Boolean.valueOf(z);
        }
    }

    public static void setChannel(int i2) {
        if (f38310b == null) {
            f38310b = Integer.valueOf(i2);
        }
    }

    public static void setCustomADActivityClassName(String str) {
        f38314f = str;
    }

    public static void setCustomLandingPageListener(CustomLandingPageListener customLandingPageListener) {
        f38309a = customLandingPageListener;
    }

    public static void setCustomLandscapeActivityClassName(String str) {
        i = str;
    }

    public static void setCustomPortraitActivityClassName(String str) {
        f38315g = str;
    }

    public static void setCustomRewardvideoLandscapeActivityClassName(String str) {
        j = str;
    }

    public static void setCustomRewardvideoPortraitActivityClassName(String str) {
        f38316h = str;
    }

    public static void setEnableMediationTool(boolean z) {
        f38311c = z;
    }

    public static void setEnableVideoDownloadingCache(boolean z) {
        f38312d = z;
    }
}
