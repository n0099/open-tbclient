package d.a.k0.d3;

import com.baidu.adp.BdUniqueId;
import d.a.j0.r.q.a2;
import d.a.j0.r.q.c2;
import d.a.j0.r.q.f2;
/* loaded from: classes5.dex */
public class e0 extends a2 {
    public static final BdUniqueId I3 = BdUniqueId.gen();
    public c2 F3;
    public f2 G3;
    public boolean H3 = false;

    public c2 B4() {
        return this.F3;
    }

    public f2 C4() {
        return this.G3;
    }

    public boolean D4() {
        return this.H3;
    }

    public void E4(boolean z) {
        this.H3 = z;
    }

    public void F4(c2 c2Var) {
        this.F3 = c2Var;
    }

    public void G4(f2 f2Var) {
        this.G3 = f2Var;
    }

    @Override // d.a.j0.r.q.a2, com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        return I3;
    }
}
