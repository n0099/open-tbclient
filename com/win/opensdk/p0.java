package com.win.opensdk;
/* loaded from: classes7.dex */
public class p0 implements X1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ q0 f37163a;

    public p0(q0 q0Var) {
        this.f37163a = q0Var;
    }

    @Override // com.win.opensdk.X1
    public void a() {
    }

    @Override // com.win.opensdk.X1
    public void onLoaded() {
        this.f37163a.k.removeMessages(11);
        this.f37163a.f37169c = true;
        x0.a(this.f37163a.f37168b).a(new y0(this.f37163a.f37172f), 200, System.currentTimeMillis() - this.f37163a.j).a();
        q0 q0Var = this.f37163a;
        if (q0Var.f37171e) {
            return;
        }
        q0Var.f37174h.onLoaded();
    }
}
