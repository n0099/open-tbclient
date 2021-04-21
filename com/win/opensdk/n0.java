package com.win.opensdk;
/* loaded from: classes7.dex */
public class n0 implements A2 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ p0 f40367a;

    public n0(p0 p0Var) {
        this.f40367a = p0Var;
    }

    @Override // com.win.opensdk.A2
    public void a(String str) {
    }

    @Override // com.win.opensdk.A2
    public boolean a(String str, String str2) {
        p0 p0Var = this.f40367a;
        if (R1.a(p0Var.f40391c, p0Var.f40396h)) {
            this.f40367a.f40396h = System.currentTimeMillis();
            p0 p0Var2 = this.f40367a;
            R1.a(p0Var2.f40389a, str, p0Var2.f40391c, p0Var2.f40395g, str2);
            a1.a(this.f40367a.f40389a).a(new b1(this.f40367a.f40391c), str).a("desc", str2).a();
            PBNativeListener pBNativeListener = this.f40367a.f40394f;
            if (pBNativeListener != null) {
                pBNativeListener.onClicked();
            }
            G.a(this.f40367a.f40391c, str2);
            return true;
        }
        return true;
    }
}
