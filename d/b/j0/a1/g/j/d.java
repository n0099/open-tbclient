package d.b.j0.a1.g.j;

import com.baidu.adp.BdUniqueId;
import d.b.j0.x.m;
/* loaded from: classes4.dex */
public class d extends b {
    public static final BdUniqueId j = BdUniqueId.gen();

    public d() {
        o(m.g());
        s("percard#");
    }

    @Override // d.b.j0.x.e0.i, com.baidu.tieba.card.data.BaseCardInfo, d.b.c.j.e.n
    public BdUniqueId getType() {
        return j;
    }
}
