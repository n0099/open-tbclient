package com.win.opensdk;
/* loaded from: classes7.dex */
public class W0 implements V1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Y0 f37041a;

    public W0(Y0 y0) {
        this.f37041a = y0;
    }

    @Override // com.win.opensdk.V1
    public void a(String str) {
    }

    @Override // com.win.opensdk.V1
    public boolean a(String str, String str2) {
        Y0 y0 = this.f37041a;
        if (o1.a(y0.f37054c, y0.f37059h)) {
            this.f37041a.f37059h = System.currentTimeMillis();
            Y0 y02 = this.f37041a;
            o1.a(y02.f37052a, str, y02.f37054c, y02.f37058g, str2);
            x0.a(this.f37041a.f37052a).a(new y0(this.f37041a.f37054c), str).a("desc", str2).a();
            r rVar = this.f37041a.f37057f;
            if (rVar != null) {
                rVar.onClicked();
            }
            z.a(this.f37041a.f37054c, str2);
            return true;
        }
        return true;
    }
}
