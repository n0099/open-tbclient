package com.win.opensdk;
/* loaded from: classes7.dex */
public class z1 implements A2 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ B1 f40407a;

    public z1(B1 b1) {
        this.f40407a = b1;
    }

    @Override // com.win.opensdk.A2
    public void a(String str) {
    }

    @Override // com.win.opensdk.A2
    public boolean a(String str, String str2) {
        B1 b1 = this.f40407a;
        if (R1.a(b1.f39916c, b1.f39921h)) {
            this.f40407a.f39921h = System.currentTimeMillis();
            B1 b12 = this.f40407a;
            R1.a(b12.f39914a, str, b12.f39916c, b12.f39920g, str2);
            a1.a(this.f40407a.f39914a).a(new b1(this.f40407a.f39916c), str).a("desc", str2).a();
            r rVar = this.f40407a.f39919f;
            if (rVar != null) {
                rVar.onClicked();
            }
            G.a(this.f40407a.f39916c, str2);
            return true;
        }
        return true;
    }
}
