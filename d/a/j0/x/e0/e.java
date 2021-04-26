package d.a.j0.x.e0;

import com.baidu.adp.BdUniqueId;
import d.a.i0.r.q.a2;
/* loaded from: classes4.dex */
public class e extends k {
    public static final BdUniqueId M0 = BdUniqueId.gen();

    public e(a2 a2Var) {
        this.f62455e = a2Var;
    }

    public static boolean i0(a2 a2Var) {
        return a2Var != null && a2Var.getType() == a2.W2;
    }

    @Override // d.a.j0.x.e0.k, com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        return M0;
    }

    @Override // d.a.j0.x.e0.k, d.a.j0.x.e0.b, d.a.i0.r.q.a
    public a2 m() {
        return this.f62455e;
    }
}
