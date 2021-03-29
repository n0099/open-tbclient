package com.win.opensdk;
/* loaded from: classes7.dex */
public class e1 implements S0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ f1 f39928a;

    public e1(f1 f1Var) {
        this.f39928a = f1Var;
    }

    @Override // com.win.opensdk.S0
    public void a() {
    }

    @Override // com.win.opensdk.S0
    public void a(int i, String str) {
        g1 g1Var = this.f39928a.f39930a;
        long currentTimeMillis = System.currentTimeMillis();
        g1 g1Var2 = this.f39928a.f39930a;
        g1Var.f39937c = currentTimeMillis - g1Var2.f39936b;
        a1.a(g1Var2.f39935a).a(i, this.f39928a.f39930a.f39937c).a();
    }

    @Override // com.win.opensdk.S0
    public void a(Object obj) {
        long j;
        g1 g1Var = this.f39928a.f39930a;
        long currentTimeMillis = System.currentTimeMillis();
        j = this.f39928a.f39930a.f39936b;
        g1Var.f39937c = currentTimeMillis - j;
        this.f39928a.f39930a.a((u1) obj);
    }
}
