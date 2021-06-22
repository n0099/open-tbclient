package d.a.o0.z.e0;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.StatisticItem;
import d.a.n0.r.q.a2;
/* loaded from: classes4.dex */
public class j extends k {
    public static final BdUniqueId O0 = BdUniqueId.gen();
    public static final BdUniqueId P0 = BdUniqueId.gen();

    public j(a2 a2Var) {
        this.f67302e = a2Var;
    }

    public static boolean i0(a2 a2Var) {
        if (a2Var == null) {
            return false;
        }
        if (a2Var.v1() == 49 || a2Var.v1() == 69) {
            return true;
        }
        return a2Var.v1() == 67 && a2Var.s1() != null && a2Var.s1().friendRoomStatus == 2;
    }

    @Override // d.a.o0.z.e0.k, com.baidu.tieba.card.data.BaseCardInfo, d.a.c.k.e.n
    public BdUniqueId getType() {
        a2 a2Var = this.f67302e;
        if (a2Var != null && a2Var.v1() == 67) {
            return P0;
        }
        return O0;
    }

    @Override // d.a.o0.z.e0.k, d.a.o0.z.e0.b, d.a.n0.r.q.a
    public a2 i() {
        return this.f67302e;
    }

    public StatisticItem l0(String str) {
        StatisticItem A = A(str);
        A.delete("obj_type");
        A.delete("obj_type");
        A.param("obj_type", 3);
        return A;
    }
}
