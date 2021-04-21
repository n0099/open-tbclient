package com.win.opensdk;
/* loaded from: classes7.dex */
public class e1 implements S0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ f1 f40312a;

    public e1(f1 f1Var) {
        this.f40312a = f1Var;
    }

    @Override // com.win.opensdk.S0
    public void a() {
    }

    @Override // com.win.opensdk.S0
    public void a(int i, String str) {
        g1 g1Var = this.f40312a.f40314a;
        long currentTimeMillis = System.currentTimeMillis();
        g1 g1Var2 = this.f40312a.f40314a;
        g1Var.f40321c = currentTimeMillis - g1Var2.f40320b;
        a1.a(g1Var2.f40319a).a(i, this.f40312a.f40314a.f40321c).a();
    }

    @Override // com.win.opensdk.S0
    public void a(Object obj) {
        long j;
        g1 g1Var = this.f40312a.f40314a;
        long currentTimeMillis = System.currentTimeMillis();
        j = this.f40312a.f40314a.f40320b;
        g1Var.f40321c = currentTimeMillis - j;
        this.f40312a.f40314a.a((u1) obj);
    }
}
