package com.win.opensdk;
/* loaded from: classes7.dex */
public class H1 implements X1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ I1 f36831a;

    public H1(I1 i1) {
        this.f36831a = i1;
    }

    @Override // com.win.opensdk.X1
    public void a() {
    }

    @Override // com.win.opensdk.X1
    public void onLoaded() {
        this.f36831a.k.removeMessages(11);
        this.f36831a.f36837c = true;
        x0.a(this.f36831a.f36836b).a(new y0(this.f36831a.f36840f), 200, System.currentTimeMillis() - this.f36831a.j).a();
        I1 i1 = this.f36831a;
        if (i1.f36839e) {
            return;
        }
        i1.f36842h.onLoaded();
    }
}
