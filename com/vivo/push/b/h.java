package com.vivo.push.b;

import android.content.Intent;
import com.baidu.mapapi.UIMsg;
/* loaded from: classes3.dex */
public final class h extends com.vivo.push.v {
    public h() {
        super(UIMsg.m_AppUI.V_WM_PERMCHECK);
    }

    @Override // com.vivo.push.v
    public final String toString() {
        return "KillProcessCommand";
    }

    @Override // com.vivo.push.v
    protected final void d(Intent intent) {
        intent.putExtra("extra_stop_service_flag", 2);
    }

    @Override // com.vivo.push.v
    protected final void e(Intent intent) {
    }
}
