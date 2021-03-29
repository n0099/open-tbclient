package com.win.opensdk;
/* loaded from: classes7.dex */
public class k2 implements C2 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ m2 f39965a;

    public k2(m2 m2Var) {
        this.f39965a = m2Var;
    }

    @Override // com.win.opensdk.C2
    public void a() {
    }

    @Override // com.win.opensdk.C2
    public void onLoaded() {
        this.f39965a.k.removeMessages(11);
        this.f39965a.f39977c = true;
        a1.a(this.f39965a.f39976b).a(new b1(this.f39965a.f39980f), 200, System.currentTimeMillis() - this.f39965a.j).a();
        m2 m2Var = this.f39965a;
        if (m2Var.f39979e) {
            return;
        }
        m2Var.f39982h.onLoaded();
    }
}
