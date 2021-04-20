package com.win.opensdk;
/* loaded from: classes7.dex */
public class w0 implements C2 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ y0 f40376a;

    public w0(y0 y0Var) {
        this.f40376a = y0Var;
    }

    @Override // com.win.opensdk.C2
    public void a() {
    }

    @Override // com.win.opensdk.C2
    public void onLoaded() {
        this.f40376a.k.removeMessages(11);
        this.f40376a.f40397c = true;
        a1.a(this.f40376a.f40396b).a(new b1(this.f40376a.f40400f), 200, System.currentTimeMillis() - this.f40376a.j).a();
        y0 y0Var = this.f40376a;
        if (y0Var.f40399e) {
            return;
        }
        y0Var.f40402h.onLoaded();
    }
}
