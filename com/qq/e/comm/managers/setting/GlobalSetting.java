package com.qq.e.comm.managers.setting;

import com.qq.e.comm.pi.CustomLandingPageListener;
/* loaded from: classes6.dex */
public final class GlobalSetting {

    /* renamed from: a  reason: collision with root package name */
    public static volatile CustomLandingPageListener f38694a = null;

    /* renamed from: b  reason: collision with root package name */
    public static volatile Integer f38695b = null;

    /* renamed from: c  reason: collision with root package name */
    public static volatile boolean f38696c = false;

    /* renamed from: d  reason: collision with root package name */
    public static volatile boolean f38697d = true;

    /* renamed from: e  reason: collision with root package name */
    public static volatile Boolean f38698e;

    /* renamed from: f  reason: collision with root package name */
    public static volatile String f38699f;

    /* renamed from: g  reason: collision with root package name */
    public static volatile String f38700g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile String f38701h;
    public static volatile String i;
    public static volatile String j;

    public static Integer getChannel() {
        return f38695b;
    }

    public static String getCustomADActivityClassName() {
        return f38699f;
    }

    public static CustomLandingPageListener getCustomLandingPageListener() {
        return f38694a;
    }

    public static String getCustomLandscapeActivityClassName() {
        return i;
    }

    public static String getCustomPortraitActivityClassName() {
        return f38700g;
    }

    public static String getCustomRewardvideoLandscapeActivityClassName() {
        return j;
    }

    public static String getCustomRewardvideoPortraitActivityClassName() {
        return f38701h;
    }

    public static Boolean isAgreePrivacyStrategy() {
        return f38698e;
    }

    public static boolean isAgreePrivacyStrategyNonNull() {
        if (f38698e != null) {
            return f38698e.booleanValue();
        }
        return true;
    }

    public static boolean isEnableMediationTool() {
        return f38696c;
    }

    public static boolean isEnableVideoDownloadingCache() {
        return f38697d;
    }

    public static void setAgreePrivacyStrategy(boolean z) {
        if (f38698e == null) {
            f38698e = Boolean.valueOf(z);
        }
    }

    public static void setChannel(int i2) {
        if (f38695b == null) {
            f38695b = Integer.valueOf(i2);
        }
    }

    public static void setCustomADActivityClassName(String str) {
        f38699f = str;
    }

    public static void setCustomLandingPageListener(CustomLandingPageListener customLandingPageListener) {
        f38694a = customLandingPageListener;
    }

    public static void setCustomLandscapeActivityClassName(String str) {
        i = str;
    }

    public static void setCustomPortraitActivityClassName(String str) {
        f38700g = str;
    }

    public static void setCustomRewardvideoLandscapeActivityClassName(String str) {
        j = str;
    }

    public static void setCustomRewardvideoPortraitActivityClassName(String str) {
        f38701h = str;
    }

    public static void setEnableMediationTool(boolean z) {
        f38696c = z;
    }

    public static void setEnableVideoDownloadingCache(boolean z) {
        f38697d = z;
    }
}
