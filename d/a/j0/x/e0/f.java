package d.a.j0.x.e0;

import com.baidu.adp.BdUniqueId;
import d.a.i0.r.q.a2;
/* loaded from: classes4.dex */
public class f extends k {
    public static final BdUniqueId M0 = BdUniqueId.gen();

    public f(a2 a2Var) {
        this.f62455e = a2Var;
    }

    public static boolean l0(a2 a2Var) {
        if (a2Var == null) {
            return false;
        }
        return a2Var.P1();
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
