package com.win.opensdk;
/* loaded from: classes6.dex */
public class W0 implements V1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Y0 f37796a;

    public W0(Y0 y0) {
        this.f37796a = y0;
    }

    @Override // com.win.opensdk.V1
    public void a(String str) {
    }

    @Override // com.win.opensdk.V1
    public boolean a(String str, String str2) {
        Y0 y0 = this.f37796a;
        if (o1.a(y0.f37809c, y0.f37814h)) {
            this.f37796a.f37814h = System.currentTimeMillis();
            Y0 y02 = this.f37796a;
            o1.a(y02.f37807a, str, y02.f37809c, y02.f37813g, str2);
            x0.a(this.f37796a.f37807a).a(new y0(this.f37796a.f37809c), str).a("desc", str2).a();
            r rVar = this.f37796a.f37812f;
            if (rVar != null) {
                rVar.onClicked();
            }
            z.a(this.f37796a.f37809c, str2);
            return true;
        }
        return true;
    }
}
