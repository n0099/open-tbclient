package d.b.i0.z0.g.m;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import d.b.h0.r.q.a2;
import d.b.i0.b3.c;
import d.b.i0.z0.g.g;
/* loaded from: classes4.dex */
public class a {
    public static void a(a2 a2Var, BdUniqueId bdUniqueId, int i, int i2) {
        String str;
        boolean z;
        int i3;
        if (a2Var == null) {
            return;
        }
        if (a2Var.i2) {
            str = a2Var.j2;
            z = true;
            i3 = 20;
        } else {
            str = null;
            z = false;
            i3 = 0;
        }
        StatisticItem e2 = d.b.i0.b3.a.e(a2Var, "a002", "common_click", i2, i, z, str, null, i3);
        if (e2 == null) {
            return;
        }
        if (a2Var.a2()) {
            e2.param(TiebaStatic.Params.GUA_TYPE, 1);
        } else if (a2Var.y0() != null) {
            e2.param(TiebaStatic.Params.GUA_TYPE, 2);
            int indexOf = e2.getParams().indexOf("obj_locate");
            if (indexOf >= 0) {
                int i4 = indexOf + 1;
                e2.getParams().remove(i4);
                e2.getParams().add(i4, 16);
            } else {
                e2.param("obj_locate", 16);
            }
        } else {
            e2.param(TiebaStatic.Params.GUA_TYPE, 0);
        }
        if (a2Var.i2) {
            e2.delete("thread_type");
            e2.param("thread_type", a2Var.s1());
        }
        c.g().c(bdUniqueId, e2);
        b(a2Var, i2);
    }

    public static void b(a2 a2Var, int i) {
        StatisticItem n;
        if (i != 2) {
            n = i != 9 ? null : d.b.i0.b3.a.n("c13693", a2Var, 1);
        } else {
            n = d.b.i0.b3.a.n("c13692", a2Var, 1);
        }
        TiebaStatic.log(n);
    }

    public static void c(a2 a2Var, BdUniqueId bdUniqueId, int i) {
        String str;
        boolean z;
        int i2;
        if (a2Var == null) {
            return;
        }
        if (a2Var.i2) {
            str = a2Var.j2;
            z = true;
            i2 = 20;
        } else {
            str = null;
            z = false;
            i2 = 0;
        }
        String c2 = d.b.i0.b3.a.c(a2Var.w1(), str, "", a2Var.V());
        StatisticItem g2 = d.b.i0.b3.a.g(a2Var, "a002", "common_exp", i, z, str, null, i2);
        if (g2 == null) {
            return;
        }
        if (a2Var.i2) {
            g2.delete("thread_type");
            g2.param("thread_type", a2Var.s1());
        }
        if (a2Var.a2()) {
            g2.param(TiebaStatic.Params.GUA_TYPE, 1);
        } else if (a2Var.y0() != null) {
            g2.param(TiebaStatic.Params.GUA_TYPE, 2);
        } else {
            g2.param(TiebaStatic.Params.GUA_TYPE, 0);
        }
        c.g().d(bdUniqueId, c2, g2);
        if (g.d()) {
            g.c(c2);
            if (g.b() >= 10) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921482));
                g.e(false);
            }
        }
    }
}
