package com.win.opensdk;
/* loaded from: classes7.dex */
public class l2 implements C2 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ m2 f39971a;

    public l2(m2 m2Var) {
        this.f39971a = m2Var;
    }

    @Override // com.win.opensdk.C2
    public void a() {
    }

    @Override // com.win.opensdk.C2
    public void onLoaded() {
        this.f39971a.k.removeMessages(11);
        this.f39971a.f39978d = true;
        a1.a(this.f39971a.f39976b).a(new b1(this.f39971a.f39980f), 200, System.currentTimeMillis() - this.f39971a.j).a();
        m2 m2Var = this.f39971a;
        if (m2Var.f39979e) {
            return;
        }
        m2Var.f39982h.onLoaded();
    }
}
