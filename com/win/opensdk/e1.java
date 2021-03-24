package com.win.opensdk;
/* loaded from: classes7.dex */
public class e1 implements S0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ f1 f39927a;

    public e1(f1 f1Var) {
        this.f39927a = f1Var;
    }

    @Override // com.win.opensdk.S0
    public void a() {
    }

    @Override // com.win.opensdk.S0
    public void a(int i, String str) {
        g1 g1Var = this.f39927a.f39929a;
        long currentTimeMillis = System.currentTimeMillis();
        g1 g1Var2 = this.f39927a.f39929a;
        g1Var.f39936c = currentTimeMillis - g1Var2.f39935b;
        a1.a(g1Var2.f39934a).a(i, this.f39927a.f39929a.f39936c).a();
    }

    @Override // com.win.opensdk.S0
    public void a(Object obj) {
        long j;
        g1 g1Var = this.f39927a.f39929a;
        long currentTimeMillis = System.currentTimeMillis();
        j = this.f39927a.f39929a.f39935b;
        g1Var.f39936c = currentTimeMillis - j;
        this.f39927a.f39929a.a((u1) obj);
    }
}
