package d.b.j0.x.e0;

import com.baidu.adp.BdUniqueId;
import d.b.i0.r.q.a2;
/* loaded from: classes4.dex */
public class e extends k {
    public static final BdUniqueId M0 = BdUniqueId.gen();

    public e(a2 a2Var) {
        this.f64193e = a2Var;
    }

    public static boolean i0(a2 a2Var) {
        return a2Var != null && a2Var.getType() == a2.W2;
    }

    @Override // d.b.j0.x.e0.k, com.baidu.tieba.card.data.BaseCardInfo, d.b.c.j.e.n
    public BdUniqueId getType() {
        return M0;
    }

    @Override // d.b.j0.x.e0.k, d.b.j0.x.e0.b, d.b.i0.r.q.a
    public a2 n() {
        return this.f64193e;
    }
}
