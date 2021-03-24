package d.b.i0.c3;

import com.baidu.adp.BdUniqueId;
import d.b.h0.r.q.a2;
import d.b.h0.r.q.c2;
import d.b.h0.r.q.f2;
/* loaded from: classes5.dex */
public class e0 extends a2 {
    public static final BdUniqueId H3 = BdUniqueId.gen();
    public c2 E3;
    public f2 F3;
    public boolean G3 = false;

    public boolean A4() {
        return this.G3;
    }

    public void B4(boolean z) {
        this.G3 = z;
    }

    public void C4(c2 c2Var) {
        this.E3 = c2Var;
    }

    public void D4(f2 f2Var) {
        this.F3 = f2Var;
    }

    @Override // d.b.h0.r.q.a2, com.baidu.tieba.card.data.BaseCardInfo, d.b.b.j.e.n
    public BdUniqueId getType() {
        return H3;
    }

    public c2 y4() {
        return this.E3;
    }

    public f2 z4() {
        return this.F3;
    }
}
