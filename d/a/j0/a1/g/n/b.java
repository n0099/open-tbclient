package d.a.j0.a1.g.n;

import android.content.Context;
import d.a.i.g;
/* loaded from: classes4.dex */
public class b extends g {
    public c D;

    public b(Context context) {
        super(context);
    }

    @Override // d.a.i.g, d.a.i.s0
    public d.a.j0.j2.q.a q() {
        c cVar = new c(this.f47690f, this.m);
        this.D = cVar;
        cVar.setStageType("2001");
        return this.D;
    }

    @Override // d.a.i.s0
    public void s() {
        super.s();
        c cVar = this.D;
        if (cVar != null) {
            cVar.N0();
        }
    }

    @Override // d.a.i.s0
    public void t() {
        super.t();
        c cVar = this.D;
        if (cVar != null) {
            cVar.O0();
        }
    }
}
