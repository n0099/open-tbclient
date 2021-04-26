package com.vivo.push.b;
/* loaded from: classes6.dex */
public final class b extends c {

    /* renamed from: a  reason: collision with root package name */
    public String f37355a;

    /* renamed from: b  reason: collision with root package name */
    public String f37356b;

    /* renamed from: c  reason: collision with root package name */
    public String f37357c;

    /* renamed from: d  reason: collision with root package name */
    public String f37358d;

    public b(boolean z, String str) {
        super(z ? 2006 : 2007, null, str);
    }

    @Override // com.vivo.push.b.c, com.vivo.push.y
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a("sdk_clients", this.f37355a);
        aVar.a("sdk_version", 293L);
        aVar.a("BaseAppCommand.EXTRA_APPID", this.f37357c);
        aVar.a("BaseAppCommand.EXTRA_APPKEY", this.f37356b);
        aVar.a("PUSH_REGID", this.f37358d);
    }

    public final void d() {
        this.f37357c = null;
    }

    public final void e() {
        this.f37356b = null;
    }

    @Override // com.vivo.push.b.c, com.vivo.push.y
    public final String toString() {
        return "AppCommand:" + b();
    }

    @Override // com.vivo.push.b.c, com.vivo.push.y
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.f37355a = aVar.a("sdk_clients");
        this.f37357c = aVar.a("BaseAppCommand.EXTRA_APPID");
        this.f37356b = aVar.a("BaseAppCommand.EXTRA_APPKEY");
        this.f37358d = aVar.a("PUSH_REGID");
    }
}
