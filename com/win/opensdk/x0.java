package com.win.opensdk;
/* loaded from: classes7.dex */
public class x0 implements C2 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ y0 f40484a;

    public x0(y0 y0Var) {
        this.f40484a = y0Var;
    }

    @Override // com.win.opensdk.C2
    public void a() {
    }

    @Override // com.win.opensdk.C2
    public void onLoaded() {
        this.f40484a.k.removeMessages(11);
        this.f40484a.f40493d = true;
        a1.a(this.f40484a.f40491b).a(new b1(this.f40484a.f40495f), 200, System.currentTimeMillis() - this.f40484a.j).a();
        y0 y0Var = this.f40484a;
        if (y0Var.f40494e) {
            return;
        }
        y0Var.f40497h.onLoaded();
    }
}
