package com.win.opensdk;
/* loaded from: classes7.dex */
public class H1 implements X1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ I1 f40613a;

    public H1(I1 i1) {
        this.f40613a = i1;
    }

    @Override // com.win.opensdk.X1
    public void a() {
    }

    @Override // com.win.opensdk.X1
    public void onLoaded() {
        this.f40613a.k.removeMessages(11);
        this.f40613a.f40619c = true;
        x0.a(this.f40613a.f40618b).a(new y0(this.f40613a.f40622f), 200, System.currentTimeMillis() - this.f40613a.j).a();
        I1 i1 = this.f40613a;
        if (i1.f40621e) {
            return;
        }
        i1.f40624h.onLoaded();
    }
}
