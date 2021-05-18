package com.win.opensdk;
/* loaded from: classes7.dex */
public class H1 implements X1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ I1 f36902a;

    public H1(I1 i1) {
        this.f36902a = i1;
    }

    @Override // com.win.opensdk.X1
    public void a() {
    }

    @Override // com.win.opensdk.X1
    public void onLoaded() {
        this.f36902a.k.removeMessages(11);
        this.f36902a.f36908c = true;
        x0.a(this.f36902a.f36907b).a(new y0(this.f36902a.f36911f), 200, System.currentTimeMillis() - this.f36902a.j).a();
        I1 i1 = this.f36902a;
        if (i1.f36910e) {
            return;
        }
        i1.f36913h.onLoaded();
    }
}
