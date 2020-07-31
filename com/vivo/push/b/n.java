package com.vivo.push.b;
/* loaded from: classes3.dex */
public final class n extends u {
    private int a;

    public n() {
        super(2016);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a("key_dispatch_environment", this.a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.a = aVar.b("key_dispatch_environment", 0);
    }

    public final int d() {
        return this.a;
    }
}
