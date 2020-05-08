package com.vivo.push.b;
/* loaded from: classes8.dex */
public final class g extends com.vivo.push.y {
    private int a;

    public g() {
        super(2015);
        this.a = -1;
    }

    @Override // com.vivo.push.y
    protected final void c(com.vivo.push.a aVar) {
        if (a(this.a)) {
            aVar.a("environment", this.a);
        }
    }

    @Override // com.vivo.push.y
    protected final void d(com.vivo.push.a aVar) {
        this.a = aVar.b("environment", 1);
    }

    public static boolean a(int i) {
        return i > 0 && i <= 4;
    }

    public final void b(int i) {
        this.a = i;
    }
}
