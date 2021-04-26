package com.win.opensdk;
/* loaded from: classes6.dex */
public class p0 implements X1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ q0 f37918a;

    public p0(q0 q0Var) {
        this.f37918a = q0Var;
    }

    @Override // com.win.opensdk.X1
    public void a() {
    }

    @Override // com.win.opensdk.X1
    public void onLoaded() {
        this.f37918a.k.removeMessages(11);
        this.f37918a.f37924c = true;
        x0.a(this.f37918a.f37923b).a(new y0(this.f37918a.f37927f), 200, System.currentTimeMillis() - this.f37918a.j).a();
        q0 q0Var = this.f37918a;
        if (q0Var.f37926e) {
            return;
        }
        q0Var.f37929h.onLoaded();
    }
}
