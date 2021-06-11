package com.qq.e.comm.managers.setting;

import com.qq.e.comm.pi.CustomLandingPageListener;
/* loaded from: classes7.dex */
public final class GlobalSetting {

    /* renamed from: a  reason: collision with root package name */
    public static volatile CustomLandingPageListener f39124a = null;

    /* renamed from: b  reason: collision with root package name */
    public static volatile Integer f39125b = null;

    /* renamed from: c  reason: collision with root package name */
    public static volatile boolean f39126c = false;

    /* renamed from: d  reason: collision with root package name */
    public static volatile boolean f39127d = true;

    /* renamed from: e  reason: collision with root package name */
    public static volatile Boolean f39128e;

    /* renamed from: f  reason: collision with root package name */
    public static volatile String f39129f;

    /* renamed from: g  reason: collision with root package name */
    public static volatile String f39130g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile String f39131h;

    /* renamed from: i  reason: collision with root package name */
    public static volatile String f39132i;
    public static volatile String j;

    public static Integer getChannel() {
        return f39125b;
    }

    public static String getCustomADActivityClassName() {
        return f39129f;
    }

    public static CustomLandingPageListener getCustomLandingPageListener() {
        return f39124a;
    }

    public static String getCustomLandscapeActivityClassName() {
        return f39132i;
    }

    public static String getCustomPortraitActivityClassName() {
        return f39130g;
    }

    public static String getCustomRewardvideoLandscapeActivityClassName() {
        return j;
    }

    public static String getCustomRewardvideoPortraitActivityClassName() {
        return f39131h;
    }

    public static Boolean isAgreePrivacyStrategy() {
        return f39128e;
    }

    public static boolean isAgreePrivacyStrategyNonNull() {
        if (f39128e != null) {
            return f39128e.booleanValue();
        }
        return true;
    }

    public static boolean isEnableMediationTool() {
        return f39126c;
    }

    public static boolean isEnableVideoDownloadingCache() {
        return f39127d;
    }

    public static void setAgreePrivacyStrategy(boolean z) {
        if (f39128e == null) {
            f39128e = Boolean.valueOf(z);
        }
    }

    public static void setChannel(int i2) {
        if (f39125b == null) {
            f39125b = Integer.valueOf(i2);
        }
    }

    public static void setCustomADActivityClassName(String str) {
        f39129f = str;
    }

    public static void setCustomLandingPageListener(CustomLandingPageListener customLandingPageListener) {
        f39124a = customLandingPageListener;
    }

    public static void setCustomLandscapeActivityClassName(String str) {
        f39132i = str;
    }

    public static void setCustomPortraitActivityClassName(String str) {
        f39130g = str;
    }

    public static void setCustomRewardvideoLandscapeActivityClassName(String str) {
        j = str;
    }

    public static void setCustomRewardvideoPortraitActivityClassName(String str) {
        f39131h = str;
    }

    public static void setEnableMediationTool(boolean z) {
        f39126c = z;
    }

    public static void setEnableVideoDownloadingCache(boolean z) {
        f39127d = z;
    }
}
