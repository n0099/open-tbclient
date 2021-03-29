package com.win.opensdk;
/* loaded from: classes7.dex */
public class x0 implements C2 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ y0 f40100a;

    public x0(y0 y0Var) {
        this.f40100a = y0Var;
    }

    @Override // com.win.opensdk.C2
    public void a() {
    }

    @Override // com.win.opensdk.C2
    public void onLoaded() {
        this.f40100a.k.removeMessages(11);
        this.f40100a.f40109d = true;
        a1.a(this.f40100a.f40107b).a(new b1(this.f40100a.f40111f), 200, System.currentTimeMillis() - this.f40100a.j).a();
        y0 y0Var = this.f40100a;
        if (y0Var.f40110e) {
            return;
        }
        y0Var.f40113h.onLoaded();
    }
}
