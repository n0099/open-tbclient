package com.vivo.push.b;

import com.baidu.mapapi.UIMsg;
/* loaded from: classes6.dex */
public final class ac extends com.vivo.push.y {

    /* renamed from: a  reason: collision with root package name */
    public String f37353a;

    public ac(String str) {
        super(UIMsg.m_AppUI.MSG_APP_VERSION_FORCE_NAV_MODULE);
        this.f37353a = str;
    }

    @Override // com.vivo.push.y
    public final void c(com.vivo.push.a aVar) {
        aVar.a("package_name", this.f37353a);
    }

    @Override // com.vivo.push.y
    public final void d(com.vivo.push.a aVar) {
        this.f37353a = aVar.a("package_name");
    }

    @Override // com.vivo.push.y
    public final String toString() {
        return "StopServiceCommand";
    }

    public ac() {
        super(UIMsg.m_AppUI.MSG_APP_VERSION_FORCE_NAV_MODULE);
    }
}
