package d.b.j0.x.e0;

import com.baidu.adp.BdUniqueId;
import d.b.i0.r.q.a2;
/* loaded from: classes4.dex */
public class f extends k {
    public static final BdUniqueId M0 = BdUniqueId.gen();

    public f(a2 a2Var) {
        this.f64193e = a2Var;
    }

    public static boolean l0(a2 a2Var) {
        if (a2Var == null) {
            return false;
        }
        return a2Var.P1();
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
