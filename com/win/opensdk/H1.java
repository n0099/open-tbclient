package com.win.opensdk;
/* loaded from: classes7.dex */
public class H1 implements X1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ I1 f40510a;

    public H1(I1 i1) {
        this.f40510a = i1;
    }

    @Override // com.win.opensdk.X1
    public void a() {
    }

    @Override // com.win.opensdk.X1
    public void onLoaded() {
        this.f40510a.k.removeMessages(11);
        this.f40510a.f40516c = true;
        x0.a(this.f40510a.f40515b).a(new y0(this.f40510a.f40519f), 200, System.currentTimeMillis() - this.f40510a.j).a();
        I1 i1 = this.f40510a;
        if (i1.f40518e) {
            return;
        }
        i1.f40521h.onLoaded();
    }
}
