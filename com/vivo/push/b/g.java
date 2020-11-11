package com.vivo.push.b;
/* loaded from: classes15.dex */
public final class g extends com.vivo.push.y {

    /* renamed from: a  reason: collision with root package name */
    private int f4640a;

    public g() {
        super(2015);
        this.f4640a = -1;
    }

    @Override // com.vivo.push.y
    protected final void c(com.vivo.push.a aVar) {
        if (a(this.f4640a)) {
            aVar.a("environment", this.f4640a);
        }
    }

    @Override // com.vivo.push.y
    protected final void d(com.vivo.push.a aVar) {
        this.f4640a = aVar.b("environment", 1);
    }

    public static boolean a(int i) {
        return i > 0 && i <= 4;
    }

    public final void b(int i) {
        this.f4640a = i;
    }
}
