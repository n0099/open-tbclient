package com.vivo.push.b;
/* loaded from: classes7.dex */
public final class b extends c {

    /* renamed from: a  reason: collision with root package name */
    public String f39657a;

    /* renamed from: b  reason: collision with root package name */
    public String f39658b;

    /* renamed from: c  reason: collision with root package name */
    public String f39659c;

    /* renamed from: d  reason: collision with root package name */
    public String f39660d;

    public b(boolean z, String str) {
        super(z ? 2006 : 2007, null, str);
    }

    @Override // com.vivo.push.b.c, com.vivo.push.y
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a("sdk_clients", this.f39657a);
        aVar.a("sdk_version", 293L);
        aVar.a("BaseAppCommand.EXTRA_APPID", this.f39659c);
        aVar.a("BaseAppCommand.EXTRA_APPKEY", this.f39658b);
        aVar.a("PUSH_REGID", this.f39660d);
    }

    public final void d() {
        this.f39659c = null;
    }

    public final void e() {
        this.f39658b = null;
    }

    @Override // com.vivo.push.b.c, com.vivo.push.y
    public final String toString() {
        return "AppCommand:" + b();
    }

    @Override // com.vivo.push.b.c, com.vivo.push.y
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.f39657a = aVar.a("sdk_clients");
        this.f39659c = aVar.a("BaseAppCommand.EXTRA_APPID");
        this.f39658b = aVar.a("BaseAppCommand.EXTRA_APPKEY");
        this.f39660d = aVar.a("PUSH_REGID");
    }
}
