package com.qq.e.comm.plugin.intersitial2;

import com.qq.e.comm.managers.GDTADManager;
/* loaded from: classes15.dex */
class h {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static double a() {
        return GDTADManager.getInstance().getSM().getInteger("unifiedIntersitialPaddingRate", 84) / 100.0d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(String str) {
        return GDTADManager.getInstance().getSM().getIntegerForPlacement("unifiedIntersitialAbandonInLandscape", str, 0) == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static double b() {
        return GDTADManager.getInstance().getSM().getInteger("unifiedIntersitialVideoPaddingRate", 84) / 100.0d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean c() {
        return GDTADManager.getInstance().getSM().getInteger("uivdwha", 1) == 1;
    }
}
