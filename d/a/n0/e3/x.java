package d.a.n0.e3;

import com.baidu.adp.BdUniqueId;
import d.a.m0.r.q.a2;
/* loaded from: classes5.dex */
public class x extends a2 {
    public static final BdUniqueId J3 = BdUniqueId.gen();
    public boolean G3;
    public String H3;
    public r I3;

    public String C4() {
        return this.H3;
    }

    public r D4() {
        return this.I3;
    }

    public boolean E4() {
        return this.G3;
    }

    public void F4(boolean z) {
        this.G3 = z;
    }

    public void G4(String str) {
        this.H3 = str;
    }

    public void H4(r rVar) {
        this.I3 = rVar;
    }

    @Override // d.a.m0.r.q.a2, com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        return J3;
    }
}
