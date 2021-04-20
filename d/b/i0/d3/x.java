package d.b.i0.d3;

import com.baidu.adp.BdUniqueId;
import d.b.h0.r.q.a2;
/* loaded from: classes3.dex */
public class x extends a2 {
    public static final BdUniqueId H3 = BdUniqueId.gen();
    public boolean E3;
    public String F3;
    public r G3;

    public r A4() {
        return this.G3;
    }

    public boolean B4() {
        return this.E3;
    }

    public void C4(boolean z) {
        this.E3 = z;
    }

    public void D4(String str) {
        this.F3 = str;
    }

    public void E4(r rVar) {
        this.G3 = rVar;
    }

    @Override // d.b.h0.r.q.a2, com.baidu.tieba.card.data.BaseCardInfo, d.b.c.j.e.n
    public BdUniqueId getType() {
        return H3;
    }

    public String z4() {
        return this.F3;
    }
}
