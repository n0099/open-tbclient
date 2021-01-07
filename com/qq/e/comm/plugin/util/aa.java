package com.qq.e.comm.plugin.util;

import android.text.TextUtils;
import com.qq.e.comm.managers.GDTADManager;
/* loaded from: classes4.dex */
public class aa {
    public static void a(String str) {
        if (GDTADManager.getInstance().getSM().getInteger("mmaEnabled", 1) == 0 || TextUtils.isEmpty(str)) {
            return;
        }
        com.tencent.ams.a.a.a.a.a().a(GDTADManager.getInstance().getAppContext(), GDTADManager.getInstance().getSM().getString("mmaConfigUrl"));
        af.a(com.tencent.ams.a.a.a.a.a().a(str));
    }

    public static boolean a() {
        return GDTADManager.getInstance().getSM().getInteger("mma_disable_get_mac", 0) == 0;
    }

    public static boolean b() {
        return GDTADManager.getInstance().getSM().getInteger("mma_disable_get_imei", 0) == 0;
    }

    public static boolean c() {
        return GDTADManager.getInstance().getSM().getInteger("mma_disable_get_androidid", 0) == 0;
    }
}
