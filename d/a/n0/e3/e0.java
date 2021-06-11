package d.a.n0.e3;

import com.baidu.adp.BdUniqueId;
import d.a.m0.r.q.a2;
import d.a.m0.r.q.c2;
import d.a.m0.r.q.f2;
/* loaded from: classes5.dex */
public class e0 extends a2 {
    public static final BdUniqueId M3 = BdUniqueId.gen();
    public c2 J3;
    public f2 K3;
    public boolean L3 = false;

    public c2 D4() {
        return this.J3;
    }

    public f2 E4() {
        return this.K3;
    }

    public boolean F4() {
        return this.L3;
    }

    public void G4(boolean z) {
        this.L3 = z;
    }

    public void H4(c2 c2Var) {
        this.J3 = c2Var;
    }

    public void I4(f2 f2Var) {
        this.K3 = f2Var;
    }

    @Override // d.a.m0.r.q.a2, com.baidu.tieba.card.data.BaseCardInfo, d.a.c.k.e.n
    public BdUniqueId getType() {
        return M3;
    }
}
