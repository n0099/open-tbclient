package com.qq.e.comm.plugin.a;

import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.status.NetworkType;
/* loaded from: classes3.dex */
class i implements a {
    @Override // com.qq.e.comm.plugin.a.a
    public int a() {
        return GDTADManager.getInstance().getDeviceStatus().getNetworkType() == NetworkType.WIFI ? 3 : 1;
    }
}
