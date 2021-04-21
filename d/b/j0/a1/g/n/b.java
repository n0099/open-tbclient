package d.b.j0.a1.g.n;

import android.content.Context;
import d.b.i.g;
/* loaded from: classes4.dex */
public class b extends g {
    public c D;

    public b(Context context) {
        super(context);
    }

    @Override // d.b.i.g, d.b.i.s0
    public d.b.j0.j2.q.a q() {
        c cVar = new c(this.f50155f, this.m);
        this.D = cVar;
        cVar.setStageType("2001");
        return this.D;
    }

    @Override // d.b.i.s0
    public void s() {
        super.s();
        c cVar = this.D;
        if (cVar != null) {
            cVar.M0();
        }
    }

    @Override // d.b.i.s0
    public void t() {
        super.t();
        c cVar = this.D;
        if (cVar != null) {
            cVar.N0();
        }
    }
}
