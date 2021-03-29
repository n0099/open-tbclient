package com.vivo.push.b;

import com.baidu.mapapi.UIMsg;
/* loaded from: classes7.dex */
public final class ac extends com.vivo.push.y {

    /* renamed from: a  reason: collision with root package name */
    public String f39366a;

    public ac(String str) {
        super(UIMsg.m_AppUI.MSG_APP_VERSION_FORCE_NAV_MODULE);
        this.f39366a = str;
    }

    @Override // com.vivo.push.y
    public final void c(com.vivo.push.a aVar) {
        aVar.a("package_name", this.f39366a);
    }

    @Override // com.vivo.push.y
    public final void d(com.vivo.push.a aVar) {
        this.f39366a = aVar.a("package_name");
    }

    @Override // com.vivo.push.y
    public final String toString() {
        return "StopServiceCommand";
    }

    public ac() {
        super(UIMsg.m_AppUI.MSG_APP_VERSION_FORCE_NAV_MODULE);
    }
}
