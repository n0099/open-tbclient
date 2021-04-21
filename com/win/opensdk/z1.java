package com.win.opensdk;
/* loaded from: classes7.dex */
public class z1 implements A2 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ B1 f40502a;

    public z1(B1 b1) {
        this.f40502a = b1;
    }

    @Override // com.win.opensdk.A2
    public void a(String str) {
    }

    @Override // com.win.opensdk.A2
    public boolean a(String str, String str2) {
        B1 b1 = this.f40502a;
        if (R1.a(b1.f40011c, b1.f40016h)) {
            this.f40502a.f40016h = System.currentTimeMillis();
            B1 b12 = this.f40502a;
            R1.a(b12.f40009a, str, b12.f40011c, b12.f40015g, str2);
            a1.a(this.f40502a.f40009a).a(new b1(this.f40502a.f40011c), str).a("desc", str2).a();
            r rVar = this.f40502a.f40014f;
            if (rVar != null) {
                rVar.onClicked();
            }
            G.a(this.f40502a.f40011c, str2);
            return true;
        }
        return true;
    }
}
