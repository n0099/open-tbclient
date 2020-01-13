package com.vivo.push.b;
/* loaded from: classes6.dex */
public final class x extends com.vivo.push.y {
    private int a;

    public x() {
        super(2011);
        this.a = 0;
    }

    public final int d() {
        return this.a;
    }

    public final void a(int i) {
        this.a = i;
    }

    @Override // com.vivo.push.y
    protected final void c(com.vivo.push.a aVar) {
        aVar.a("com.bbk.push.ikey.MODE_TYPE", this.a);
    }

    @Override // com.vivo.push.y
    protected final void d(com.vivo.push.a aVar) {
        this.a = aVar.b("com.bbk.push.ikey.MODE_TYPE", 0);
    }

    @Override // com.vivo.push.y
    public final String toString() {
        return "PushModeCommand";
    }

    @Override // com.vivo.push.y
    public final boolean c() {
        return true;
    }
}
