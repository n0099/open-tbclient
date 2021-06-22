package d.a.o0.b1.h.n;

import android.content.Context;
import d.a.i.g;
/* loaded from: classes4.dex */
public class b extends g {
    public c D;

    public b(Context context) {
        super(context);
    }

    @Override // d.a.i.g, d.a.i.t0
    public d.a.o0.k2.q.a q() {
        c cVar = new c(this.f43782f, this.m);
        this.D = cVar;
        cVar.setStageType("2001");
        return this.D;
    }

    @Override // d.a.i.t0
    public void s() {
        super.s();
        c cVar = this.D;
        if (cVar != null) {
            cVar.O0();
        }
    }

    @Override // d.a.i.t0
    public void t() {
        super.t();
        c cVar = this.D;
        if (cVar != null) {
            cVar.P0();
        }
    }
}
