package com.qq.e.comm.managers.setting;

import com.qq.e.comm.pi.CustomLandingPageListener;
/* loaded from: classes7.dex */
public final class GlobalSetting {

    /* renamed from: a  reason: collision with root package name */
    public static volatile CustomLandingPageListener f39222a = null;

    /* renamed from: b  reason: collision with root package name */
    public static volatile Integer f39223b = null;

    /* renamed from: c  reason: collision with root package name */
    public static volatile boolean f39224c = false;

    /* renamed from: d  reason: collision with root package name */
    public static volatile boolean f39225d = true;

    /* renamed from: e  reason: collision with root package name */
    public static volatile Boolean f39226e;

    /* renamed from: f  reason: collision with root package name */
    public static volatile String f39227f;

    /* renamed from: g  reason: collision with root package name */
    public static volatile String f39228g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile String f39229h;

    /* renamed from: i  reason: collision with root package name */
    public static volatile String f39230i;
    public static volatile String j;

    public static Integer getChannel() {
        return f39223b;
    }

    public static String getCustomADActivityClassName() {
        return f39227f;
    }

    public static CustomLandingPageListener getCustomLandingPageListener() {
        return f39222a;
    }

    public static String getCustomLandscapeActivityClassName() {
        return f39230i;
    }

    public static String getCustomPortraitActivityClassName() {
        return f39228g;
    }

    public static String getCustomRewardvideoLandscapeActivityClassName() {
        return j;
    }

    public static String getCustomRewardvideoPortraitActivityClassName() {
        return f39229h;
    }

    public static Boolean isAgreePrivacyStrategy() {
        return f39226e;
    }

    public static boolean isAgreePrivacyStrategyNonNull() {
        if (f39226e != null) {
            return f39226e.booleanValue();
        }
        return true;
    }

    public static boolean isEnableMediationTool() {
        return f39224c;
    }

    public static boolean isEnableVideoDownloadingCache() {
        return f39225d;
    }

    public static void setAgreePrivacyStrategy(boolean z) {
        if (f39226e == null) {
            f39226e = Boolean.valueOf(z);
        }
    }

    public static void setChannel(int i2) {
        if (f39223b == null) {
            f39223b = Integer.valueOf(i2);
        }
    }

    public static void setCustomADActivityClassName(String str) {
        f39227f = str;
    }

    public static void setCustomLandingPageListener(CustomLandingPageListener customLandingPageListener) {
        f39222a = customLandingPageListener;
    }

    public static void setCustomLandscapeActivityClassName(String str) {
        f39230i = str;
    }

    public static void setCustomPortraitActivityClassName(String str) {
        f39228g = str;
    }

    public static void setCustomRewardvideoLandscapeActivityClassName(String str) {
        j = str;
    }

    public static void setCustomRewardvideoPortraitActivityClassName(String str) {
        f39229h = str;
    }

    public static void setEnableMediationTool(boolean z) {
        f39224c = z;
    }

    public static void setEnableVideoDownloadingCache(boolean z) {
        f39225d = z;
    }
}
