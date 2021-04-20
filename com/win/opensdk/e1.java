package com.win.opensdk;
/* loaded from: classes7.dex */
public class e1 implements S0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ f1 f40217a;

    public e1(f1 f1Var) {
        this.f40217a = f1Var;
    }

    @Override // com.win.opensdk.S0
    public void a() {
    }

    @Override // com.win.opensdk.S0
    public void a(int i, String str) {
        g1 g1Var = this.f40217a.f40219a;
        long currentTimeMillis = System.currentTimeMillis();
        g1 g1Var2 = this.f40217a.f40219a;
        g1Var.f40226c = currentTimeMillis - g1Var2.f40225b;
        a1.a(g1Var2.f40224a).a(i, this.f40217a.f40219a.f40226c).a();
    }

    @Override // com.win.opensdk.S0
    public void a(Object obj) {
        long j;
        g1 g1Var = this.f40217a.f40219a;
        long currentTimeMillis = System.currentTimeMillis();
        j = this.f40217a.f40219a.f40225b;
        g1Var.f40226c = currentTimeMillis - j;
        this.f40217a.f40219a.a((u1) obj);
    }
}
