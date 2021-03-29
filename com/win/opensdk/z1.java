package com.win.opensdk;
/* loaded from: classes7.dex */
public class z1 implements A2 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ B1 f40118a;

    public z1(B1 b1) {
        this.f40118a = b1;
    }

    @Override // com.win.opensdk.A2
    public void a(String str) {
    }

    @Override // com.win.opensdk.A2
    public boolean a(String str, String str2) {
        B1 b1 = this.f40118a;
        if (R1.a(b1.f39627c, b1.f39632h)) {
            this.f40118a.f39632h = System.currentTimeMillis();
            B1 b12 = this.f40118a;
            R1.a(b12.f39625a, str, b12.f39627c, b12.f39631g, str2);
            a1.a(this.f40118a.f39625a).a(new b1(this.f40118a.f39627c), str).a("desc", str2).a();
            r rVar = this.f40118a.f39630f;
            if (rVar != null) {
                rVar.onClicked();
            }
            G.a(this.f40118a.f39627c, str2);
            return true;
        }
        return true;
    }
}
