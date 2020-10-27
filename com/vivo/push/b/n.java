package com.vivo.push.b;
/* loaded from: classes15.dex */
public final class n extends u {

    /* renamed from: a  reason: collision with root package name */
    private int f4642a;

    public n() {
        super(2016);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a("key_dispatch_environment", this.f4642a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.f4642a = aVar.b("key_dispatch_environment", 0);
    }

    public final int d() {
        return this.f4642a;
    }
}
