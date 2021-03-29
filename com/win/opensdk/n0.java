package com.win.opensdk;
/* loaded from: classes7.dex */
public class n0 implements A2 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ p0 f39983a;

    public n0(p0 p0Var) {
        this.f39983a = p0Var;
    }

    @Override // com.win.opensdk.A2
    public void a(String str) {
    }

    @Override // com.win.opensdk.A2
    public boolean a(String str, String str2) {
        p0 p0Var = this.f39983a;
        if (R1.a(p0Var.f40007c, p0Var.f40012h)) {
            this.f39983a.f40012h = System.currentTimeMillis();
            p0 p0Var2 = this.f39983a;
            R1.a(p0Var2.f40005a, str, p0Var2.f40007c, p0Var2.f40011g, str2);
            a1.a(this.f39983a.f40005a).a(new b1(this.f39983a.f40007c), str).a("desc", str2).a();
            PBNativeListener pBNativeListener = this.f39983a.f40010f;
            if (pBNativeListener != null) {
                pBNativeListener.onClicked();
            }
            G.a(this.f39983a.f40007c, str2);
            return true;
        }
        return true;
    }
}
