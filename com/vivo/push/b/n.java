package com.vivo.push.b;
/* loaded from: classes7.dex */
public final class n extends u {

    /* renamed from: a  reason: collision with root package name */
    public int f36618a;

    public n() {
        super(2016);
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a("key_dispatch_environment", this.f36618a);
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.f36618a = aVar.b("key_dispatch_environment", 0);
    }

    public final int d() {
        return this.f36618a;
    }
}
