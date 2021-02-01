package com.qq.e.comm.managers.setting;

import com.qq.e.comm.pi.CustomLandingPageListener;
/* loaded from: classes15.dex */
public final class GlobalSetting {

    /* renamed from: b  reason: collision with root package name */
    private static volatile Integer f11555b;
    private static volatile boolean c;
    private static volatile Boolean d;

    /* renamed from: a  reason: collision with root package name */
    private static volatile CustomLandingPageListener f11554a = null;
    private static volatile String e = null;
    private static volatile String f = null;
    private static volatile String g = null;
    private static volatile String h = null;
    private static volatile String i = null;

    public static Integer getChannel() {
        return f11555b;
    }

    public static String getCustomADActivityClassName() {
        return e;
    }

    public static CustomLandingPageListener getCustomLandingPageListener() {
        return f11554a;
    }

    public static String getCustomLandscapeActivityClassName() {
        return h;
    }

    public static String getCustomPortraitActivityClassName() {
        return f;
    }

    public static String getCustomRewardvideoLandscapeActivityClassName() {
        return i;
    }

    public static String getCustomRewardvideoPortraitActivityClassName() {
        return g;
    }

    public static Boolean isAgreePrivacyStrategy() {
        return d;
    }

    public static boolean isEnableMediationTool() {
        return c;
    }

    public static void setAgreePrivacyStrategy(boolean z) {
        if (d == null) {
            d = Boolean.valueOf(z);
        }
    }

    public static void setChannel(int i2) {
        if (f11555b == null) {
            f11555b = Integer.valueOf(i2);
        }
    }

    public static void setCustomADActivityClassName(String str) {
        e = str;
    }

    public static void setCustomLandingPageListener(CustomLandingPageListener customLandingPageListener) {
        f11554a = customLandingPageListener;
    }

    public static void setCustomLandscapeActivityClassName(String str) {
        h = str;
    }

    public static void setCustomPortraitActivityClassName(String str) {
        f = str;
    }

    public static void setCustomRewardvideoLandscapeActivityClassName(String str) {
        i = str;
    }

    public static void setCustomRewardvideoPortraitActivityClassName(String str) {
        g = str;
    }

    public static void setEnableMediationTool(boolean z) {
        c = z;
    }
}
