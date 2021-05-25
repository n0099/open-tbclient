package d.a.n0.b1.g.j;

import com.baidu.adp.BdUniqueId;
import d.a.n0.z.m;
/* loaded from: classes4.dex */
public class d extends b {
    public static final BdUniqueId j = BdUniqueId.gen();

    public d() {
        p(m.g());
        s("percard#");
    }

    @Override // d.a.n0.z.e0.i, com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        return j;
    }
}
