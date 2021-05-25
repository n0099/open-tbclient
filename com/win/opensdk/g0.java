package com.win.opensdk;
/* loaded from: classes7.dex */
public class g0 implements V1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ i0 f37040a;

    public g0(i0 i0Var) {
        this.f37040a = i0Var;
    }

    @Override // com.win.opensdk.V1
    public void a(String str) {
    }

    @Override // com.win.opensdk.V1
    public boolean a(String str, String str2) {
        i0 i0Var = this.f37040a;
        if (o1.a(i0Var.f37056c, i0Var.f37061h)) {
            this.f37040a.f37061h = System.currentTimeMillis();
            i0 i0Var2 = this.f37040a;
            o1.a(i0Var2.f37054a, str, i0Var2.f37056c, i0Var2.f37060g, str2);
            x0.a(this.f37040a.f37054a).a(new y0(this.f37040a.f37056c), str).a("desc", str2).a();
            PBNativeListener pBNativeListener = this.f37040a.f37059f;
            if (pBNativeListener != null) {
                pBNativeListener.onClicked();
            }
            z.a(this.f37040a.f37056c, str2);
            return true;
        }
        return true;
    }
}
