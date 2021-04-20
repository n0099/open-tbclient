package com.win.opensdk;
/* loaded from: classes7.dex */
public class n0 implements A2 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ p0 f40272a;

    public n0(p0 p0Var) {
        this.f40272a = p0Var;
    }

    @Override // com.win.opensdk.A2
    public void a(String str) {
    }

    @Override // com.win.opensdk.A2
    public boolean a(String str, String str2) {
        p0 p0Var = this.f40272a;
        if (R1.a(p0Var.f40296c, p0Var.f40301h)) {
            this.f40272a.f40301h = System.currentTimeMillis();
            p0 p0Var2 = this.f40272a;
            R1.a(p0Var2.f40294a, str, p0Var2.f40296c, p0Var2.f40300g, str2);
            a1.a(this.f40272a.f40294a).a(new b1(this.f40272a.f40296c), str).a("desc", str2).a();
            PBNativeListener pBNativeListener = this.f40272a.f40299f;
            if (pBNativeListener != null) {
                pBNativeListener.onClicked();
            }
            G.a(this.f40272a.f40296c, str2);
            return true;
        }
        return true;
    }
}
