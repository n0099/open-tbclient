package com.vivo.push.b;

import com.baidu.mapapi.UIMsg;
/* loaded from: classes6.dex */
public final class aa extends com.vivo.push.y {
    private String a;

    public aa(String str) {
        super(UIMsg.m_AppUI.MSG_APP_VERSION_FORCE_NAV_MODULE);
        this.a = str;
    }

    public aa() {
        super(UIMsg.m_AppUI.MSG_APP_VERSION_FORCE_NAV_MODULE);
    }

    @Override // com.vivo.push.y
    protected final void c(com.vivo.push.a aVar) {
        aVar.a("package_name", this.a);
    }

    @Override // com.vivo.push.y
    protected final void d(com.vivo.push.a aVar) {
        this.a = aVar.a("package_name");
    }

    @Override // com.vivo.push.y
    public final String toString() {
        return "StopServiceCommand";
    }
}
