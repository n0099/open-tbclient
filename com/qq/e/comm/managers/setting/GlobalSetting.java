package com.qq.e.comm.managers.setting;

import com.qq.e.comm.pi.CustomLandingPageListener;
/* loaded from: classes6.dex */
public final class GlobalSetting {

    /* renamed from: a  reason: collision with root package name */
    public static volatile CustomLandingPageListener f36271a = null;

    /* renamed from: b  reason: collision with root package name */
    public static volatile Integer f36272b = null;

    /* renamed from: c  reason: collision with root package name */
    public static volatile boolean f36273c = false;

    /* renamed from: d  reason: collision with root package name */
    public static volatile boolean f36274d = true;

    /* renamed from: e  reason: collision with root package name */
    public static volatile Boolean f36275e;

    /* renamed from: f  reason: collision with root package name */
    public static volatile String f36276f;

    /* renamed from: g  reason: collision with root package name */
    public static volatile String f36277g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile String f36278h;

    /* renamed from: i  reason: collision with root package name */
    public static volatile String f36279i;
    public static volatile String j;

    public static Integer getChannel() {
        return f36272b;
    }

    public static String getCustomADActivityClassName() {
        return f36276f;
    }

    public static CustomLandingPageListener getCustomLandingPageListener() {
        return f36271a;
    }

    public static String getCustomLandscapeActivityClassName() {
        return f36279i;
    }

    public static String getCustomPortraitActivityClassName() {
        return f36277g;
    }

    public static String getCustomRewardvideoLandscapeActivityClassName() {
        return j;
    }

    public static String getCustomRewardvideoPortraitActivityClassName() {
        return f36278h;
    }

    public static Boolean isAgreePrivacyStrategy() {
        return f36275e;
    }

    public static boolean isAgreePrivacyStrategyNonNull() {
        if (f36275e != null) {
            return f36275e.booleanValue();
        }
        return true;
    }

    public static boolean isEnableMediationTool() {
        return f36273c;
    }

    public static boolean isEnableVideoDownloadingCache() {
        return f36274d;
    }

    public static void setAgreePrivacyStrategy(boolean z) {
        if (f36275e == null) {
            f36275e = Boolean.valueOf(z);
        }
    }

    public static void setChannel(int i2) {
        if (f36272b == null) {
            f36272b = Integer.valueOf(i2);
        }
    }

    public static void setCustomADActivityClassName(String str) {
        f36276f = str;
    }

    public static void setCustomLandingPageListener(CustomLandingPageListener customLandingPageListener) {
        f36271a = customLandingPageListener;
    }

    public static void setCustomLandscapeActivityClassName(String str) {
        f36279i = str;
    }

    public static void setCustomPortraitActivityClassName(String str) {
        f36277g = str;
    }

    public static void setCustomRewardvideoLandscapeActivityClassName(String str) {
        j = str;
    }

    public static void setCustomRewardvideoPortraitActivityClassName(String str) {
        f36278h = str;
    }

    public static void setEnableMediationTool(boolean z) {
        f36273c = z;
    }

    public static void setEnableVideoDownloadingCache(boolean z) {
        f36274d = z;
    }
}
