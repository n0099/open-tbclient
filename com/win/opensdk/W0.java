package com.win.opensdk;
/* loaded from: classes7.dex */
public class W0 implements V1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Y0 f36970a;

    public W0(Y0 y0) {
        this.f36970a = y0;
    }

    @Override // com.win.opensdk.V1
    public void a(String str) {
    }

    @Override // com.win.opensdk.V1
    public boolean a(String str, String str2) {
        Y0 y0 = this.f36970a;
        if (o1.a(y0.f36983c, y0.f36988h)) {
            this.f36970a.f36988h = System.currentTimeMillis();
            Y0 y02 = this.f36970a;
            o1.a(y02.f36981a, str, y02.f36983c, y02.f36987g, str2);
            x0.a(this.f36970a.f36981a).a(new y0(this.f36970a.f36983c), str).a("desc", str2).a();
            r rVar = this.f36970a.f36986f;
            if (rVar != null) {
                rVar.onClicked();
            }
            z.a(this.f36970a.f36983c, str2);
            return true;
        }
        return true;
    }
}
