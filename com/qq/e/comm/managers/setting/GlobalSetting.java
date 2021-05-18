package com.qq.e.comm.managers.setting;

import com.qq.e.comm.pi.CustomLandingPageListener;
/* loaded from: classes7.dex */
public final class GlobalSetting {

    /* renamed from: a  reason: collision with root package name */
    public static volatile CustomLandingPageListener f35516a = null;

    /* renamed from: b  reason: collision with root package name */
    public static volatile Integer f35517b = null;

    /* renamed from: c  reason: collision with root package name */
    public static volatile boolean f35518c = false;

    /* renamed from: d  reason: collision with root package name */
    public static volatile boolean f35519d = true;

    /* renamed from: e  reason: collision with root package name */
    public static volatile Boolean f35520e;

    /* renamed from: f  reason: collision with root package name */
    public static volatile String f35521f;

    /* renamed from: g  reason: collision with root package name */
    public static volatile String f35522g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile String f35523h;

    /* renamed from: i  reason: collision with root package name */
    public static volatile String f35524i;
    public static volatile String j;

    public static Integer getChannel() {
        return f35517b;
    }

    public static String getCustomADActivityClassName() {
        return f35521f;
    }

    public static CustomLandingPageListener getCustomLandingPageListener() {
        return f35516a;
    }

    public static String getCustomLandscapeActivityClassName() {
        return f35524i;
    }

    public static String getCustomPortraitActivityClassName() {
        return f35522g;
    }

    public static String getCustomRewardvideoLandscapeActivityClassName() {
        return j;
    }

    public static String getCustomRewardvideoPortraitActivityClassName() {
        return f35523h;
    }

    public static Boolean isAgreePrivacyStrategy() {
        return f35520e;
    }

    public static boolean isAgreePrivacyStrategyNonNull() {
        if (f35520e != null) {
            return f35520e.booleanValue();
        }
        return true;
    }

    public static boolean isEnableMediationTool() {
        return f35518c;
    }

    public static boolean isEnableVideoDownloadingCache() {
        return f35519d;
    }

    public static void setAgreePrivacyStrategy(boolean z) {
        if (f35520e == null) {
            f35520e = Boolean.valueOf(z);
        }
    }

    public static void setChannel(int i2) {
        if (f35517b == null) {
            f35517b = Integer.valueOf(i2);
        }
    }

    public static void setCustomADActivityClassName(String str) {
        f35521f = str;
    }

    public static void setCustomLandingPageListener(CustomLandingPageListener customLandingPageListener) {
        f35516a = customLandingPageListener;
    }

    public static void setCustomLandscapeActivityClassName(String str) {
        f35524i = str;
    }

    public static void setCustomPortraitActivityClassName(String str) {
        f35522g = str;
    }

    public static void setCustomRewardvideoLandscapeActivityClassName(String str) {
        j = str;
    }

    public static void setCustomRewardvideoPortraitActivityClassName(String str) {
        f35523h = str;
    }

    public static void setEnableMediationTool(boolean z) {
        f35518c = z;
    }

    public static void setEnableVideoDownloadingCache(boolean z) {
        f35519d = z;
    }
}
