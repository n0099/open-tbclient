package com.qq.e.comm.managers.setting;

import com.qq.e.comm.pi.CustomLandingPageListener;
/* loaded from: classes7.dex */
public final class GlobalSetting {

    /* renamed from: a  reason: collision with root package name */
    public static volatile CustomLandingPageListener f35445a = null;

    /* renamed from: b  reason: collision with root package name */
    public static volatile Integer f35446b = null;

    /* renamed from: c  reason: collision with root package name */
    public static volatile boolean f35447c = false;

    /* renamed from: d  reason: collision with root package name */
    public static volatile boolean f35448d = true;

    /* renamed from: e  reason: collision with root package name */
    public static volatile Boolean f35449e;

    /* renamed from: f  reason: collision with root package name */
    public static volatile String f35450f;

    /* renamed from: g  reason: collision with root package name */
    public static volatile String f35451g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile String f35452h;

    /* renamed from: i  reason: collision with root package name */
    public static volatile String f35453i;
    public static volatile String j;

    public static Integer getChannel() {
        return f35446b;
    }

    public static String getCustomADActivityClassName() {
        return f35450f;
    }

    public static CustomLandingPageListener getCustomLandingPageListener() {
        return f35445a;
    }

    public static String getCustomLandscapeActivityClassName() {
        return f35453i;
    }

    public static String getCustomPortraitActivityClassName() {
        return f35451g;
    }

    public static String getCustomRewardvideoLandscapeActivityClassName() {
        return j;
    }

    public static String getCustomRewardvideoPortraitActivityClassName() {
        return f35452h;
    }

    public static Boolean isAgreePrivacyStrategy() {
        return f35449e;
    }

    public static boolean isAgreePrivacyStrategyNonNull() {
        if (f35449e != null) {
            return f35449e.booleanValue();
        }
        return true;
    }

    public static boolean isEnableMediationTool() {
        return f35447c;
    }

    public static boolean isEnableVideoDownloadingCache() {
        return f35448d;
    }

    public static void setAgreePrivacyStrategy(boolean z) {
        if (f35449e == null) {
            f35449e = Boolean.valueOf(z);
        }
    }

    public static void setChannel(int i2) {
        if (f35446b == null) {
            f35446b = Integer.valueOf(i2);
        }
    }

    public static void setCustomADActivityClassName(String str) {
        f35450f = str;
    }

    public static void setCustomLandingPageListener(CustomLandingPageListener customLandingPageListener) {
        f35445a = customLandingPageListener;
    }

    public static void setCustomLandscapeActivityClassName(String str) {
        f35453i = str;
    }

    public static void setCustomPortraitActivityClassName(String str) {
        f35451g = str;
    }

    public static void setCustomRewardvideoLandscapeActivityClassName(String str) {
        j = str;
    }

    public static void setCustomRewardvideoPortraitActivityClassName(String str) {
        f35452h = str;
    }

    public static void setEnableMediationTool(boolean z) {
        f35447c = z;
    }

    public static void setEnableVideoDownloadingCache(boolean z) {
        f35448d = z;
    }
}
