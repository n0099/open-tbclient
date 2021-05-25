package d.a.n0.e3;

import com.baidu.adp.BdUniqueId;
import d.a.m0.r.q.a2;
import d.a.m0.r.q.c2;
import d.a.m0.r.q.f2;
/* loaded from: classes5.dex */
public class e0 extends a2 {
    public static final BdUniqueId J3 = BdUniqueId.gen();
    public c2 G3;
    public f2 H3;
    public boolean I3 = false;

    public c2 C4() {
        return this.G3;
    }

    public f2 D4() {
        return this.H3;
    }

    public boolean E4() {
        return this.I3;
    }

    public void F4(boolean z) {
        this.I3 = z;
    }

    public void G4(c2 c2Var) {
        this.G3 = c2Var;
    }

    public void H4(f2 f2Var) {
        this.H3 = f2Var;
    }

    @Override // d.a.m0.r.q.a2, com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        return J3;
    }
}
