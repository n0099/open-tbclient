package com.qq.e.comm.plugin.splash;

import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.managers.GDTADManager;
/* loaded from: classes4.dex */
class i {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static long a() {
        return GDTADManager.getInstance().getSM().getInteger("splashADExpireDuration", 1800) * 1000;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(long j) {
        GDTADManager.getInstance().getSM().setDEVCodeSetting(Constants.KEYS.SPLASH_LOADTIMEOUT, Long.valueOf(j));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(String str) {
        GDTADManager.getInstance().getSM().setDEVCodeSetting("splashContractWXAppId", str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(String str) {
        return GDTADManager.getInstance().getSM().getIntegerForPlacement(Constants.KEYS.SPLASH_EXPOSURE_TIME, str, 5000);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b() {
        return GDTADManager.getInstance().getSM().getInteger("splashLoadedEnqueueHead", 0) == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean c() {
        return GDTADManager.getInstance().getSM().getInteger("SplashGuideBanner", 1) == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean c(String str) {
        return GDTADManager.getInstance().getSM().getIntegerForPlacement("deepLink_confirm", str, 0) == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(String str) {
        return GDTADManager.getInstance().getSM().getIntegerForPlacement(Constants.KEYS.DownConfirm, str, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object d() {
        return GDTADManager.getInstance().getSM().get("splashContractWXAppId");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean e() {
        return GDTADManager.getInstance().getSM().getInteger("splashVideoMd5Check", 1) == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long f() {
        return GDTADManager.getInstance().getSM().getInteger("splashVideoAnimationDuration", 400);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int g() {
        return GDTADManager.getInstance().getSM().getInteger(Constants.KEYS.SPLASH_LOADTIMEOUT, 3000);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean h() {
        return GDTADManager.getInstance().getSM().getInteger("preloadMarkEnable", 1) == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int i() {
        return GDTADManager.getInstance().getSM().getInteger("splashSkipShowDelay", 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int j() {
        return GDTADManager.getInstance().getSM().getInteger("splashSkipPos", 0);
    }
}
