package com.win.opensdk;
/* loaded from: classes7.dex */
public class x0 implements C2 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ y0 f40099a;

    public x0(y0 y0Var) {
        this.f40099a = y0Var;
    }

    @Override // com.win.opensdk.C2
    public void a() {
    }

    @Override // com.win.opensdk.C2
    public void onLoaded() {
        this.f40099a.k.removeMessages(11);
        this.f40099a.f40108d = true;
        a1.a(this.f40099a.f40106b).a(new b1(this.f40099a.f40110f), 200, System.currentTimeMillis() - this.f40099a.j).a();
        y0 y0Var = this.f40099a;
        if (y0Var.f40109e) {
            return;
        }
        y0Var.f40112h.onLoaded();
    }
}
