package com.win.opensdk;
/* loaded from: classes7.dex */
public class w0 implements C2 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ y0 f40471a;

    public w0(y0 y0Var) {
        this.f40471a = y0Var;
    }

    @Override // com.win.opensdk.C2
    public void a() {
    }

    @Override // com.win.opensdk.C2
    public void onLoaded() {
        this.f40471a.k.removeMessages(11);
        this.f40471a.f40492c = true;
        a1.a(this.f40471a.f40491b).a(new b1(this.f40471a.f40495f), 200, System.currentTimeMillis() - this.f40471a.j).a();
        y0 y0Var = this.f40471a;
        if (y0Var.f40494e) {
            return;
        }
        y0Var.f40497h.onLoaded();
    }
}
