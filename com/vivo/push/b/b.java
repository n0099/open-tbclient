package com.vivo.push.b;

import com.baidu.mapapi.UIMsg;
import com.baidu.sapi2.SapiContext;
/* loaded from: classes6.dex */
public final class b extends c {
    private String a;
    private String b;
    private String c;
    private String d;

    public b(boolean z, String str) {
        super(z ? UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND : UIMsg.m_AppUI.MSG_APP_VERSION_NAV_MODULE, null, str);
    }

    public final void d() {
        this.c = null;
    }

    public final void e() {
        this.b = null;
    }

    @Override // com.vivo.push.b.c, com.vivo.push.y
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a("sdk_clients", this.a);
        aVar.a(SapiContext.KEY_SDK_VERSION, 280L);
        aVar.a("BaseAppCommand.EXTRA_APPID", this.c);
        aVar.a("BaseAppCommand.EXTRA_APPKEY", this.b);
        aVar.a("PUSH_REGID", this.d);
    }

    @Override // com.vivo.push.b.c, com.vivo.push.y
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.a = aVar.a("sdk_clients");
        this.c = aVar.a("BaseAppCommand.EXTRA_APPID");
        this.b = aVar.a("BaseAppCommand.EXTRA_APPKEY");
        this.d = aVar.a("PUSH_REGID");
    }

    @Override // com.vivo.push.b.c, com.vivo.push.y
    public final String toString() {
        return "AppCommand:" + b();
    }
}
