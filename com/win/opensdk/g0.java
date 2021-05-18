package com.win.opensdk;
/* loaded from: classes7.dex */
public class g0 implements V1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ i0 f37111a;

    public g0(i0 i0Var) {
        this.f37111a = i0Var;
    }

    @Override // com.win.opensdk.V1
    public void a(String str) {
    }

    @Override // com.win.opensdk.V1
    public boolean a(String str, String str2) {
        i0 i0Var = this.f37111a;
        if (o1.a(i0Var.f37127c, i0Var.f37132h)) {
            this.f37111a.f37132h = System.currentTimeMillis();
            i0 i0Var2 = this.f37111a;
            o1.a(i0Var2.f37125a, str, i0Var2.f37127c, i0Var2.f37131g, str2);
            x0.a(this.f37111a.f37125a).a(new y0(this.f37111a.f37127c), str).a("desc", str2).a();
            PBNativeListener pBNativeListener = this.f37111a.f37130f;
            if (pBNativeListener != null) {
                pBNativeListener.onClicked();
            }
            z.a(this.f37111a.f37127c, str2);
            return true;
        }
        return true;
    }
}
