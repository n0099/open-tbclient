package com.qq.e.comm.plugin.a.c;

import com.baidu.live.tbadk.data.Config;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.status.NetworkType;
import com.qq.e.comm.plugin.a.c;
/* loaded from: classes3.dex */
public class a implements b {
    @Override // com.qq.e.comm.plugin.a.c.b
    public boolean a(c cVar) {
        if (cVar.r()) {
            if (System.currentTimeMillis() - cVar.d() <= 432000000) {
                return false;
            }
        } else if (System.currentTimeMillis() - cVar.d() <= Config.THREAD_IMAGE_SAVE_MAX_TIME) {
            return false;
        }
        return true;
    }

    @Override // com.qq.e.comm.plugin.a.c.b
    public boolean b(c cVar) {
        return GDTADManager.getInstance().getDeviceStatus().getNetworkType() == NetworkType.WIFI;
    }
}
