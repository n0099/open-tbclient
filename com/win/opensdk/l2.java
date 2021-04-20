package com.win.opensdk;
/* loaded from: classes7.dex */
public class l2 implements C2 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ m2 f40260a;

    public l2(m2 m2Var) {
        this.f40260a = m2Var;
    }

    @Override // com.win.opensdk.C2
    public void a() {
    }

    @Override // com.win.opensdk.C2
    public void onLoaded() {
        this.f40260a.k.removeMessages(11);
        this.f40260a.f40267d = true;
        a1.a(this.f40260a.f40265b).a(new b1(this.f40260a.f40269f), 200, System.currentTimeMillis() - this.f40260a.j).a();
        m2 m2Var = this.f40260a;
        if (m2Var.f40268e) {
            return;
        }
        m2Var.f40271h.onLoaded();
    }
}
