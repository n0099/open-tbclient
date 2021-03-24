package com.win.opensdk;
/* loaded from: classes7.dex */
public class l2 implements C2 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ m2 f39970a;

    public l2(m2 m2Var) {
        this.f39970a = m2Var;
    }

    @Override // com.win.opensdk.C2
    public void a() {
    }

    @Override // com.win.opensdk.C2
    public void onLoaded() {
        this.f39970a.k.removeMessages(11);
        this.f39970a.f39977d = true;
        a1.a(this.f39970a.f39975b).a(new b1(this.f39970a.f39979f), 200, System.currentTimeMillis() - this.f39970a.j).a();
        m2 m2Var = this.f39970a;
        if (m2Var.f39978e) {
            return;
        }
        m2Var.f39981h.onLoaded();
    }
}
