package com.win.opensdk;
/* loaded from: classes7.dex */
public class l2 implements C2 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ m2 f40355a;

    public l2(m2 m2Var) {
        this.f40355a = m2Var;
    }

    @Override // com.win.opensdk.C2
    public void a() {
    }

    @Override // com.win.opensdk.C2
    public void onLoaded() {
        this.f40355a.k.removeMessages(11);
        this.f40355a.f40362d = true;
        a1.a(this.f40355a.f40360b).a(new b1(this.f40355a.f40364f), 200, System.currentTimeMillis() - this.f40355a.j).a();
        m2 m2Var = this.f40355a;
        if (m2Var.f40363e) {
            return;
        }
        m2Var.f40366h.onLoaded();
    }
}
