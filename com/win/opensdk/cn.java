package com.win.opensdk;
/* loaded from: classes14.dex */
public class cn implements bh {
    public final /* synthetic */ cr qlB;

    public cn(cr crVar) {
        this.qlB = crVar;
    }

    @Override // com.win.opensdk.bh
    public void a() {
    }

    @Override // com.win.opensdk.bh
    public void a(int i, String str) {
        cu cuVar = this.qlB.qlC;
        long currentTimeMillis = System.currentTimeMillis();
        cu cuVar2 = this.qlB.qlC;
        cuVar.c = currentTimeMillis - cuVar2.b;
        ca.iT(cuVar2.f8147a).H(i, this.qlB.qlC.c).a();
    }

    @Override // com.win.opensdk.bh
    public void a(Object obj) {
        long j;
        cu cuVar = this.qlB.qlC;
        long currentTimeMillis = System.currentTimeMillis();
        j = this.qlB.qlC.b;
        cuVar.c = currentTimeMillis - j;
        this.qlB.qlC.a((ep) obj);
    }
}
