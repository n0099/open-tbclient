package com.win.opensdk;
/* loaded from: classes6.dex */
public class H1 implements X1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ I1 f37657a;

    public H1(I1 i1) {
        this.f37657a = i1;
    }

    @Override // com.win.opensdk.X1
    public void a() {
    }

    @Override // com.win.opensdk.X1
    public void onLoaded() {
        this.f37657a.k.removeMessages(11);
        this.f37657a.f37663c = true;
        x0.a(this.f37657a.f37662b).a(new y0(this.f37657a.f37666f), 200, System.currentTimeMillis() - this.f37657a.j).a();
        I1 i1 = this.f37657a;
        if (i1.f37665e) {
            return;
        }
        i1.f37668h.onLoaded();
    }
}
