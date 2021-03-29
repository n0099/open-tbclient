package com.vivo.push.b;
/* loaded from: classes7.dex */
public final class b extends c {

    /* renamed from: a  reason: collision with root package name */
    public String f39368a;

    /* renamed from: b  reason: collision with root package name */
    public String f39369b;

    /* renamed from: c  reason: collision with root package name */
    public String f39370c;

    /* renamed from: d  reason: collision with root package name */
    public String f39371d;

    public b(boolean z, String str) {
        super(z ? 2006 : 2007, null, str);
    }

    @Override // com.vivo.push.b.c, com.vivo.push.y
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a("sdk_clients", this.f39368a);
        aVar.a("sdk_version", 293L);
        aVar.a("BaseAppCommand.EXTRA_APPID", this.f39370c);
        aVar.a("BaseAppCommand.EXTRA_APPKEY", this.f39369b);
        aVar.a("PUSH_REGID", this.f39371d);
    }

    public final void d() {
        this.f39370c = null;
    }

    public final void e() {
        this.f39369b = null;
    }

    @Override // com.vivo.push.b.c, com.vivo.push.y
    public final String toString() {
        return "AppCommand:" + b();
    }

    @Override // com.vivo.push.b.c, com.vivo.push.y
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.f39368a = aVar.a("sdk_clients");
        this.f39370c = aVar.a("BaseAppCommand.EXTRA_APPID");
        this.f39369b = aVar.a("BaseAppCommand.EXTRA_APPKEY");
        this.f39371d = aVar.a("PUSH_REGID");
    }
}
