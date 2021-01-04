package com.vivo.push.b;

import com.baidu.sapi2.SapiContext;
/* loaded from: classes3.dex */
public final class b extends c {

    /* renamed from: a  reason: collision with root package name */
    private String f13869a;

    /* renamed from: b  reason: collision with root package name */
    private String f13870b;
    private String c;
    private String d;

    public b(boolean z, String str) {
        super(z ? 2006 : 2007, null, str);
    }

    public final void d() {
        this.c = null;
    }

    public final void e() {
        this.f13870b = null;
    }

    @Override // com.vivo.push.b.c, com.vivo.push.y
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a("sdk_clients", this.f13869a);
        aVar.a(SapiContext.KEY_SDK_VERSION, 293L);
        aVar.a("BaseAppCommand.EXTRA_APPID", this.c);
        aVar.a("BaseAppCommand.EXTRA_APPKEY", this.f13870b);
        aVar.a("PUSH_REGID", this.d);
    }

    @Override // com.vivo.push.b.c, com.vivo.push.y
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.f13869a = aVar.a("sdk_clients");
        this.c = aVar.a("BaseAppCommand.EXTRA_APPID");
        this.f13870b = aVar.a("BaseAppCommand.EXTRA_APPKEY");
        this.d = aVar.a("PUSH_REGID");
    }

    @Override // com.vivo.push.b.c, com.vivo.push.y
    public final String toString() {
        return "AppCommand:" + b();
    }
}
