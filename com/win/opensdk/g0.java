package com.win.opensdk;
/* loaded from: classes7.dex */
public class g0 implements V1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ i0 f40719a;

    public g0(i0 i0Var) {
        this.f40719a = i0Var;
    }

    @Override // com.win.opensdk.V1
    public void a(String str) {
    }

    @Override // com.win.opensdk.V1
    public boolean a(String str, String str2) {
        i0 i0Var = this.f40719a;
        if (o1.a(i0Var.f40735c, i0Var.f40740h)) {
            this.f40719a.f40740h = System.currentTimeMillis();
            i0 i0Var2 = this.f40719a;
            o1.a(i0Var2.f40733a, str, i0Var2.f40735c, i0Var2.f40739g, str2);
            x0.a(this.f40719a.f40733a).a(new y0(this.f40719a.f40735c), str).a("desc", str2).a();
            PBNativeListener pBNativeListener = this.f40719a.f40738f;
            if (pBNativeListener != null) {
                pBNativeListener.onClicked();
            }
            z.a(this.f40719a.f40735c, str2);
            return true;
        }
        return true;
    }
}
