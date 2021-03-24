package com.win.opensdk;
/* loaded from: classes7.dex */
public class z1 implements A2 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ B1 f40117a;

    public z1(B1 b1) {
        this.f40117a = b1;
    }

    @Override // com.win.opensdk.A2
    public void a(String str) {
    }

    @Override // com.win.opensdk.A2
    public boolean a(String str, String str2) {
        B1 b1 = this.f40117a;
        if (R1.a(b1.f39626c, b1.f39631h)) {
            this.f40117a.f39631h = System.currentTimeMillis();
            B1 b12 = this.f40117a;
            R1.a(b12.f39624a, str, b12.f39626c, b12.f39630g, str2);
            a1.a(this.f40117a.f39624a).a(new b1(this.f40117a.f39626c), str).a("desc", str2).a();
            r rVar = this.f40117a.f39629f;
            if (rVar != null) {
                rVar.onClicked();
            }
            G.a(this.f40117a.f39626c, str2);
            return true;
        }
        return true;
    }
}
