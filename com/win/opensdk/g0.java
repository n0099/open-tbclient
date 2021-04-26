package com.win.opensdk;
/* loaded from: classes6.dex */
public class g0 implements V1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ i0 f37866a;

    public g0(i0 i0Var) {
        this.f37866a = i0Var;
    }

    @Override // com.win.opensdk.V1
    public void a(String str) {
    }

    @Override // com.win.opensdk.V1
    public boolean a(String str, String str2) {
        i0 i0Var = this.f37866a;
        if (o1.a(i0Var.f37882c, i0Var.f37887h)) {
            this.f37866a.f37887h = System.currentTimeMillis();
            i0 i0Var2 = this.f37866a;
            o1.a(i0Var2.f37880a, str, i0Var2.f37882c, i0Var2.f37886g, str2);
            x0.a(this.f37866a.f37880a).a(new y0(this.f37866a.f37882c), str).a("desc", str2).a();
            PBNativeListener pBNativeListener = this.f37866a.f37885f;
            if (pBNativeListener != null) {
                pBNativeListener.onClicked();
            }
            z.a(this.f37866a.f37882c, str2);
            return true;
        }
        return true;
    }
}
