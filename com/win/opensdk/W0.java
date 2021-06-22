package com.win.opensdk;
/* loaded from: classes7.dex */
public class W0 implements V1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Y0 f40752a;

    public W0(Y0 y0) {
        this.f40752a = y0;
    }

    @Override // com.win.opensdk.V1
    public void a(String str) {
    }

    @Override // com.win.opensdk.V1
    public boolean a(String str, String str2) {
        Y0 y0 = this.f40752a;
        if (o1.a(y0.f40765c, y0.f40770h)) {
            this.f40752a.f40770h = System.currentTimeMillis();
            Y0 y02 = this.f40752a;
            o1.a(y02.f40763a, str, y02.f40765c, y02.f40769g, str2);
            x0.a(this.f40752a.f40763a).a(new y0(this.f40752a.f40765c), str).a("desc", str2).a();
            r rVar = this.f40752a.f40768f;
            if (rVar != null) {
                rVar.onClicked();
            }
            z.a(this.f40752a.f40765c, str2);
            return true;
        }
        return true;
    }
}
