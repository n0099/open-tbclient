package com.win.opensdk;
/* loaded from: classes7.dex */
public class W0 implements V1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Y0 f40649a;

    public W0(Y0 y0) {
        this.f40649a = y0;
    }

    @Override // com.win.opensdk.V1
    public void a(String str) {
    }

    @Override // com.win.opensdk.V1
    public boolean a(String str, String str2) {
        Y0 y0 = this.f40649a;
        if (o1.a(y0.f40662c, y0.f40667h)) {
            this.f40649a.f40667h = System.currentTimeMillis();
            Y0 y02 = this.f40649a;
            o1.a(y02.f40660a, str, y02.f40662c, y02.f40666g, str2);
            x0.a(this.f40649a.f40660a).a(new y0(this.f40649a.f40662c), str).a("desc", str2).a();
            r rVar = this.f40649a.f40665f;
            if (rVar != null) {
                rVar.onClicked();
            }
            z.a(this.f40649a.f40662c, str2);
            return true;
        }
        return true;
    }
}
