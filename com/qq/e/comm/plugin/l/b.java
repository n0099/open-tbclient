package com.qq.e.comm.plugin.l;

import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.s.e;
/* loaded from: classes15.dex */
public class b {
    public static boolean a(e eVar) {
        int integer = GDTADManager.getInstance().getSM().getInteger("expOverlayVideoPage", 0);
        return integer == 1 || (integer != 0 && a.a().a(eVar, String.valueOf(integer), 0) == 2);
    }
}
