package com.win.opensdk;
/* loaded from: classes7.dex */
public class w0 implements C2 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ y0 f40087a;

    public w0(y0 y0Var) {
        this.f40087a = y0Var;
    }

    @Override // com.win.opensdk.C2
    public void a() {
    }

    @Override // com.win.opensdk.C2
    public void onLoaded() {
        this.f40087a.k.removeMessages(11);
        this.f40087a.f40108c = true;
        a1.a(this.f40087a.f40107b).a(new b1(this.f40087a.f40111f), 200, System.currentTimeMillis() - this.f40087a.j).a();
        y0 y0Var = this.f40087a;
        if (y0Var.f40110e) {
            return;
        }
        y0Var.f40113h.onLoaded();
    }
}
