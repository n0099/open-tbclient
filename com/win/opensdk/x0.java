package com.win.opensdk;
/* loaded from: classes7.dex */
public class x0 implements C2 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ y0 f40389a;

    public x0(y0 y0Var) {
        this.f40389a = y0Var;
    }

    @Override // com.win.opensdk.C2
    public void a() {
    }

    @Override // com.win.opensdk.C2
    public void onLoaded() {
        this.f40389a.k.removeMessages(11);
        this.f40389a.f40398d = true;
        a1.a(this.f40389a.f40396b).a(new b1(this.f40389a.f40400f), 200, System.currentTimeMillis() - this.f40389a.j).a();
        y0 y0Var = this.f40389a;
        if (y0Var.f40399e) {
            return;
        }
        y0Var.f40402h.onLoaded();
    }
}
