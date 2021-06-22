package d.a.o0.e3;

import com.baidu.adp.BdUniqueId;
import d.a.n0.r.q.a2;
/* loaded from: classes5.dex */
public class x extends a2 {
    public static final BdUniqueId M3 = BdUniqueId.gen();
    public boolean J3;
    public String K3;
    public r L3;

    public String D4() {
        return this.K3;
    }

    public r E4() {
        return this.L3;
    }

    public boolean F4() {
        return this.J3;
    }

    public void G4(boolean z) {
        this.J3 = z;
    }

    public void H4(String str) {
        this.K3 = str;
    }

    public void I4(r rVar) {
        this.L3 = rVar;
    }

    @Override // d.a.n0.r.q.a2, com.baidu.tieba.card.data.BaseCardInfo, d.a.c.k.e.n
    public BdUniqueId getType() {
        return M3;
    }
}
