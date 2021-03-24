package com.win.opensdk;
/* loaded from: classes7.dex */
public class n0 implements A2 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ p0 f39982a;

    public n0(p0 p0Var) {
        this.f39982a = p0Var;
    }

    @Override // com.win.opensdk.A2
    public void a(String str) {
    }

    @Override // com.win.opensdk.A2
    public boolean a(String str, String str2) {
        p0 p0Var = this.f39982a;
        if (R1.a(p0Var.f40006c, p0Var.f40011h)) {
            this.f39982a.f40011h = System.currentTimeMillis();
            p0 p0Var2 = this.f39982a;
            R1.a(p0Var2.f40004a, str, p0Var2.f40006c, p0Var2.f40010g, str2);
            a1.a(this.f39982a.f40004a).a(new b1(this.f39982a.f40006c), str).a("desc", str2).a();
            PBNativeListener pBNativeListener = this.f39982a.f40009f;
            if (pBNativeListener != null) {
                pBNativeListener.onClicked();
            }
            G.a(this.f39982a.f40006c, str2);
            return true;
        }
        return true;
    }
}
