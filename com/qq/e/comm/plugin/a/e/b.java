package com.qq.e.comm.plugin.a.e;

import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.status.NetworkType;
/* loaded from: classes4.dex */
public class b {
    public static boolean a() {
        return GDTADManager.getInstance().getSM().getInteger("appLandingPageWifiAutoDownload", 0) == 1 && NetworkType.WIFI == GDTADManager.getInstance().getDeviceStatus().getNetworkType();
    }

    public static boolean a(int i, String str) {
        return (!a(str) || i == 1 || i == 4) ? false : true;
    }

    public static boolean a(String str) {
        return GDTADManager.getInstance().getSM().getIntegerForPlacement("appAutoDownload", str, 0) == 1;
    }
}
