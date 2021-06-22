package com.win.opensdk;
/* loaded from: classes7.dex */
public class g0 implements V1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ i0 f40822a;

    public g0(i0 i0Var) {
        this.f40822a = i0Var;
    }

    @Override // com.win.opensdk.V1
    public void a(String str) {
    }

    @Override // com.win.opensdk.V1
    public boolean a(String str, String str2) {
        i0 i0Var = this.f40822a;
        if (o1.a(i0Var.f40838c, i0Var.f40843h)) {
            this.f40822a.f40843h = System.currentTimeMillis();
            i0 i0Var2 = this.f40822a;
            o1.a(i0Var2.f40836a, str, i0Var2.f40838c, i0Var2.f40842g, str2);
            x0.a(this.f40822a.f40836a).a(new y0(this.f40822a.f40838c), str).a("desc", str2).a();
            PBNativeListener pBNativeListener = this.f40822a.f40841f;
            if (pBNativeListener != null) {
                pBNativeListener.onClicked();
            }
            z.a(this.f40822a.f40838c, str2);
            return true;
        }
        return true;
    }
}
