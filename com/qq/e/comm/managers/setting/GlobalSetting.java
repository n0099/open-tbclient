package com.qq.e.comm.managers.setting;

import com.qq.e.comm.pi.CustomLandingPageListener;
/* loaded from: classes4.dex */
public final class GlobalSetting {
    private static volatile Integer b;
    private static volatile boolean c;
    private static volatile Boolean e;

    /* renamed from: a  reason: collision with root package name */
    private static volatile CustomLandingPageListener f7570a = null;
    private static volatile boolean d = true;
    private static volatile String f = null;
    private static volatile String g = null;
    private static volatile String h = null;
    private static volatile String i = null;
    private static volatile String j = null;

    public static Integer getChannel() {
        return b;
    }

    public static String getCustomADActivityClassName() {
        return f;
    }

    public static CustomLandingPageListener getCustomLandingPageListener() {
        return f7570a;
    }

    public static String getCustomLandscapeActivityClassName() {
        return i;
    }

    public static String getCustomPortraitActivityClassName() {
        return g;
    }

    public static String getCustomRewardvideoLandscapeActivityClassName() {
        return j;
    }

    public static String getCustomRewardvideoPortraitActivityClassName() {
        return h;
    }

    public static Boolean isAgreePrivacyStrategy() {
        return e;
    }

    public static boolean isEnableMediationTool() {
        return c;
    }

    public static boolean isEnableVideoDownloadingCache() {
        return d;
    }

    public static void setAgreePrivacyStrategy(boolean z) {
        if (e == null) {
            e = Boolean.valueOf(z);
        }
    }

    public static void setChannel(int i2) {
        if (b == null) {
            b = Integer.valueOf(i2);
        }
    }

    public static void setCustomADActivityClassName(String str) {
        f = str;
    }

    public static void setCustomLandingPageListener(CustomLandingPageListener customLandingPageListener) {
        f7570a = customLandingPageListener;
    }

    public static void setCustomLandscapeActivityClassName(String str) {
        i = str;
    }

    public static void setCustomPortraitActivityClassName(String str) {
        g = str;
    }

    public static void setCustomRewardvideoLandscapeActivityClassName(String str) {
        j = str;
    }

    public static void setCustomRewardvideoPortraitActivityClassName(String str) {
        h = str;
    }

    public static void setEnableMediationTool(boolean z) {
        c = z;
    }

    public static void setEnableVideoDownloadingCache(boolean z) {
        d = z;
    }
}
