package com.vivo.push.b;
/* loaded from: classes7.dex */
public final class b extends c {

    /* renamed from: a  reason: collision with root package name */
    public String f39367a;

    /* renamed from: b  reason: collision with root package name */
    public String f39368b;

    /* renamed from: c  reason: collision with root package name */
    public String f39369c;

    /* renamed from: d  reason: collision with root package name */
    public String f39370d;

    public b(boolean z, String str) {
        super(z ? 2006 : 2007, null, str);
    }

    @Override // com.vivo.push.b.c, com.vivo.push.y
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a("sdk_clients", this.f39367a);
        aVar.a("sdk_version", 293L);
        aVar.a("BaseAppCommand.EXTRA_APPID", this.f39369c);
        aVar.a("BaseAppCommand.EXTRA_APPKEY", this.f39368b);
        aVar.a("PUSH_REGID", this.f39370d);
    }

    public final void d() {
        this.f39369c = null;
    }

    public final void e() {
        this.f39368b = null;
    }

    @Override // com.vivo.push.b.c, com.vivo.push.y
    public final String toString() {
        return "AppCommand:" + b();
    }

    @Override // com.vivo.push.b.c, com.vivo.push.y
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.f39367a = aVar.a("sdk_clients");
        this.f39369c = aVar.a("BaseAppCommand.EXTRA_APPID");
        this.f39368b = aVar.a("BaseAppCommand.EXTRA_APPKEY");
        this.f39370d = aVar.a("PUSH_REGID");
    }
}
