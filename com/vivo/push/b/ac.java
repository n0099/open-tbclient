package com.vivo.push.b;

import com.baidu.mapapi.UIMsg;
/* loaded from: classes15.dex */
public final class ac extends com.vivo.push.y {

    /* renamed from: a  reason: collision with root package name */
    private String f13570a;

    public ac(String str) {
        super(UIMsg.m_AppUI.MSG_APP_VERSION_FORCE_NAV_MODULE);
        this.f13570a = str;
    }

    public ac() {
        super(UIMsg.m_AppUI.MSG_APP_VERSION_FORCE_NAV_MODULE);
    }

    @Override // com.vivo.push.y
    protected final void c(com.vivo.push.a aVar) {
        aVar.a("package_name", this.f13570a);
    }

    @Override // com.vivo.push.y
    protected final void d(com.vivo.push.a aVar) {
        this.f13570a = aVar.a("package_name");
    }

    @Override // com.vivo.push.y
    public final String toString() {
        return "StopServiceCommand";
    }
}
