package com.vivo.push.b;

import android.content.Intent;
import com.baidu.mapapi.UIMsg;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes3.dex */
public final class z extends com.vivo.push.v {
    private String a;

    public z(String str) {
        super(UIMsg.m_AppUI.MSG_APP_VERSION_FORCE_NAV_MODULE);
        this.a = str;
    }

    public z() {
        super(UIMsg.m_AppUI.MSG_APP_VERSION_FORCE_NAV_MODULE);
    }

    @Override // com.vivo.push.v
    protected final void d(Intent intent) {
        intent.putExtra(Constants.PACKAGE_NAME, this.a);
    }

    @Override // com.vivo.push.v
    protected final void e(Intent intent) {
        this.a = intent.getStringExtra(Constants.PACKAGE_NAME);
    }

    @Override // com.vivo.push.v
    public final String toString() {
        return "StopServiceCommand";
    }
}
