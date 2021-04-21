package com.win.opensdk;
/* loaded from: classes7.dex */
public class k2 implements C2 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ m2 f40349a;

    public k2(m2 m2Var) {
        this.f40349a = m2Var;
    }

    @Override // com.win.opensdk.C2
    public void a() {
    }

    @Override // com.win.opensdk.C2
    public void onLoaded() {
        this.f40349a.k.removeMessages(11);
        this.f40349a.f40361c = true;
        a1.a(this.f40349a.f40360b).a(new b1(this.f40349a.f40364f), 200, System.currentTimeMillis() - this.f40349a.j).a();
        m2 m2Var = this.f40349a;
        if (m2Var.f40363e) {
            return;
        }
        m2Var.f40366h.onLoaded();
    }
}
