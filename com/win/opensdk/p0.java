package com.win.opensdk;
/* loaded from: classes7.dex */
public class p0 implements X1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ q0 f40771a;

    public p0(q0 q0Var) {
        this.f40771a = q0Var;
    }

    @Override // com.win.opensdk.X1
    public void a() {
    }

    @Override // com.win.opensdk.X1
    public void onLoaded() {
        this.f40771a.k.removeMessages(11);
        this.f40771a.f40777c = true;
        x0.a(this.f40771a.f40776b).a(new y0(this.f40771a.f40780f), 200, System.currentTimeMillis() - this.f40771a.j).a();
        q0 q0Var = this.f40771a;
        if (q0Var.f40779e) {
            return;
        }
        q0Var.f40782h.onLoaded();
    }
}
