package d.b.i0.x.e0;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.StatisticItem;
import d.b.h0.r.q.a2;
/* loaded from: classes4.dex */
public class j extends k {
    public static final BdUniqueId M0 = BdUniqueId.gen();
    public static final BdUniqueId N0 = BdUniqueId.gen();

    public j(a2 a2Var) {
        this.f62196e = a2Var;
    }

    public static boolean i0(a2 a2Var) {
        if (a2Var == null) {
            return false;
        }
        if (a2Var.s1() == 49) {
            return true;
        }
        return a2Var.s1() == 67 && a2Var.q1() != null && a2Var.q1().friendRoomStatus == 2;
    }

    @Override // d.b.i0.x.e0.k, com.baidu.tieba.card.data.BaseCardInfo, d.b.b.j.e.n
    public BdUniqueId getType() {
        a2 a2Var = this.f62196e;
        if (a2Var != null && a2Var.s1() == 67) {
            return N0;
        }
        return M0;
    }

    public StatisticItem l0(String str) {
        StatisticItem A = A(str);
        A.delete("obj_type");
        A.delete("obj_type");
        A.param("obj_type", 3);
        return A;
    }

    @Override // d.b.i0.x.e0.k, d.b.i0.x.e0.b, d.b.h0.r.q.a
    public a2 n() {
        return this.f62196e;
    }
}
