package d.b.i0.z0.g.j;

import com.baidu.adp.BdUniqueId;
import d.b.i0.x.m;
/* loaded from: classes3.dex */
public class d extends b {
    public static final BdUniqueId j = BdUniqueId.gen();

    public d() {
        o(m.g());
        s("percard#");
    }

    @Override // d.b.i0.x.e0.i, com.baidu.tieba.card.data.BaseCardInfo, d.b.b.j.e.n
    public BdUniqueId getType() {
        return j;
    }
}
