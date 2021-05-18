package d.a.k0.d3;

import com.baidu.adp.BdUniqueId;
import d.a.j0.r.q.a2;
/* loaded from: classes5.dex */
public class x extends a2 {
    public static final BdUniqueId I3 = BdUniqueId.gen();
    public boolean F3;
    public String G3;
    public r H3;

    public String B4() {
        return this.G3;
    }

    public r C4() {
        return this.H3;
    }

    public boolean D4() {
        return this.F3;
    }

    public void E4(boolean z) {
        this.F3 = z;
    }

    public void F4(String str) {
        this.G3 = str;
    }

    public void G4(r rVar) {
        this.H3 = rVar;
    }

    @Override // d.a.j0.r.q.a2, com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        return I3;
    }
}
