package d.a.o0.z.e0;

import com.baidu.adp.BdUniqueId;
import d.a.n0.r.q.a2;
/* loaded from: classes4.dex */
public class e extends k {
    public static final BdUniqueId O0 = BdUniqueId.gen();

    public e(a2 a2Var) {
        this.f67302e = a2Var;
    }

    public static boolean i0(a2 a2Var) {
        return a2Var != null && a2Var.getType() == a2.b3;
    }

    @Override // d.a.o0.z.e0.k, com.baidu.tieba.card.data.BaseCardInfo, d.a.c.k.e.n
    public BdUniqueId getType() {
        return O0;
    }

    @Override // d.a.o0.z.e0.k, d.a.o0.z.e0.b, d.a.n0.r.q.a
    public a2 i() {
        return this.f67302e;
    }
}
