package com.win.opensdk;
/* loaded from: classes7.dex */
public class p0 implements X1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ q0 f40874a;

    public p0(q0 q0Var) {
        this.f40874a = q0Var;
    }

    @Override // com.win.opensdk.X1
    public void a() {
    }

    @Override // com.win.opensdk.X1
    public void onLoaded() {
        this.f40874a.k.removeMessages(11);
        this.f40874a.f40880c = true;
        x0.a(this.f40874a.f40879b).a(new y0(this.f40874a.f40883f), 200, System.currentTimeMillis() - this.f40874a.j).a();
        q0 q0Var = this.f40874a;
        if (q0Var.f40882e) {
            return;
        }
        q0Var.f40885h.onLoaded();
    }
}
