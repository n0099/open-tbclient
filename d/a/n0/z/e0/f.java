package d.a.n0.z.e0;

import com.baidu.adp.BdUniqueId;
import d.a.m0.r.q.a2;
/* loaded from: classes4.dex */
public class f extends k {
    public static final BdUniqueId O0 = BdUniqueId.gen();

    public f(a2 a2Var) {
        this.f63459e = a2Var;
    }

    public static boolean l0(a2 a2Var) {
        if (a2Var == null) {
            return false;
        }
        return a2Var.R1();
    }

    @Override // d.a.n0.z.e0.k, com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        return O0;
    }

    @Override // d.a.n0.z.e0.k, d.a.n0.z.e0.b, d.a.m0.r.q.a
    public a2 m() {
        return this.f63459e;
    }
}
