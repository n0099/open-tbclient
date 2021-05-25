package com.win.opensdk;
/* loaded from: classes7.dex */
public class p0 implements X1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ q0 f37092a;

    public p0(q0 q0Var) {
        this.f37092a = q0Var;
    }

    @Override // com.win.opensdk.X1
    public void a() {
    }

    @Override // com.win.opensdk.X1
    public void onLoaded() {
        this.f37092a.k.removeMessages(11);
        this.f37092a.f37098c = true;
        x0.a(this.f37092a.f37097b).a(new y0(this.f37092a.f37101f), 200, System.currentTimeMillis() - this.f37092a.j).a();
        q0 q0Var = this.f37092a;
        if (q0Var.f37100e) {
            return;
        }
        q0Var.f37103h.onLoaded();
    }
}
