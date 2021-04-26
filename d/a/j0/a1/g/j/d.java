package d.a.j0.a1.g.j;

import com.baidu.adp.BdUniqueId;
import d.a.j0.x.m;
/* loaded from: classes4.dex */
public class d extends b {
    public static final BdUniqueId j = BdUniqueId.gen();

    public d() {
        p(m.g());
        s("percard#");
    }

    @Override // d.a.j0.x.e0.i, com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        return j;
    }
}
