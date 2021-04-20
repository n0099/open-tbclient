package d.b.i0.q0.j2;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.pageInfo.TbPageTag;
import d.b.c.e.p.k;
import d.b.c.j.e.n;
import d.b.h0.r.q.a2;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    public static void a(StatisticItem statisticItem, a2 a2Var, TbPageTag tbPageTag) {
        if (!k.isEmpty(a2Var.S0)) {
            statisticItem.param(TiebaStatic.Params.RECOM_WEIGHT, a2Var.S0);
        }
        if (!k.isEmpty(a2Var.U0)) {
            statisticItem.param(TiebaStatic.Params.RECOM_EXTRA, a2Var.U0);
        }
        if (!k.isEmpty(a2Var.R0)) {
            statisticItem.param("recom_source", a2Var.R0);
        }
        if (!k.isEmpty(a2Var.T0)) {
            statisticItem.param(TiebaStatic.Params.RECOM_AB_TAG, a2Var.T0);
        }
        statisticItem.param(TiebaStatic.Params.RECOM_TYPE, a2Var.U0());
        d.b.h0.j0.c.a(statisticItem, tbPageTag);
    }

    public static void b(a2 a2Var, int i, BdUniqueId bdUniqueId, b bVar, TbPageTag tbPageTag) {
        int i2;
        String str;
        boolean z;
        int i3;
        if (a2Var == null) {
            return;
        }
        String str2 = null;
        boolean z2 = (a2Var.q1() == null || a2Var.q1().user_info == null || a2Var.q1().user_info.is_official != 2) ? false : true;
        boolean z3 = z2 && a2Var.q1().frsLiveStageType == 0;
        if (z3) {
            str2 = String.valueOf(a2Var.q1().live_id);
            i2 = 4;
        } else {
            i2 = 0;
        }
        if (!z3) {
            z3 = a2Var.s1() == 41;
            if (z3) {
                if (a2Var.o1() != null) {
                    str2 = a2Var.o1().f();
                }
                i2 = 2;
            }
        }
        if (a2Var.P1) {
            str2 = a2Var.o0();
            i2 = 14;
            z3 = true;
        }
        if (a2Var.i2) {
            str = a2Var.j2;
            z = true;
            i3 = 17;
        } else {
            str = str2;
            z = z3;
            i3 = i2;
        }
        StatisticItem e2 = d.b.i0.c3.a.e(a2Var, "a006", "common_click", i, a2Var.M1, z, str, null, i3);
        if (e2 == null) {
            return;
        }
        e2.param(TiebaStatic.Params.LIST_ORDER, c.j().k(bVar));
        if (a2Var.b2()) {
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
        a(e2, a2Var, tbPageTag);
        if (a2Var.b2()) {
            e2.param(TiebaStatic.Params.GUA_TYPE, 1);
        }
        if (z2) {
            e2.param(TiebaStatic.Params.IS_OFFICIAL, a2Var.q1().user_info.is_official);
        }
        if (z2 || a2Var.P1 || a2Var.i2) {
            e2.delete("thread_type");
            e2.param("thread_type", a2Var.s1());
        }
        g(e2, tbPageTag, true);
        d.b.i0.c3.c.g().c(bdUniqueId, e2);
        f(a2Var, i);
    }

    public static void c(a2 a2Var, BdUniqueId bdUniqueId, TbPageTag tbPageTag) {
        if (a2Var == null || bdUniqueId == null || !a2Var.P1) {
            return;
        }
        boolean z = (a2Var.T() == null || a2Var.T().getUserId() == null || !a2Var.T().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (!a2Var.t2() || a2Var.b0() == null || z) {
            return;
        }
        StatisticItem param = new StatisticItem("common_exp").param("page_type", "a006").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_AD_LOCATE, 15).param("obj_id", a2Var.o0()).param(TiebaStatic.Params.OBJ_FLOOR, a2Var.M1).param("fid", a2Var.c0()).param("thread_type", a2Var.s1()).param("tid", a2Var.o0()).param(TiebaStatic.Params.FIRST_DIR, a2Var.d0()).param(TiebaStatic.Params.SECOND_DIR, a2Var.d1());
        a(param, a2Var, tbPageTag);
        String c2 = d.b.i0.c3.a.c(a2Var.w1(), "", "", a2Var.V());
        d.b.i0.c3.c g2 = d.b.i0.c3.c.g();
        g2.d(bdUniqueId, c2 + "_15", param);
    }

    public static void d(BdUniqueId bdUniqueId, int i, ForumData forumData, int i2, int i3) {
        if (i <= 0) {
            return;
        }
        StatisticItem i4 = d.b.i0.c3.a.i("a006", "common_fill", true, i, i3);
        if (forumData != null) {
            if (!k.isEmpty(forumData.getId())) {
                i4.param("fid", forumData.getId());
            }
            if (!k.isEmpty(forumData.getName())) {
                i4.param("fname", forumData.getName());
            }
            if (!k.isEmpty(forumData.getFirst_class())) {
                i4.param(TiebaStatic.Params.FIRST_DIR, forumData.getFirst_class());
            }
            if (!k.isEmpty(forumData.getSecond_class())) {
                i4.param(TiebaStatic.Params.SECOND_DIR, forumData.getSecond_class());
            }
        }
        i4.param(TiebaStatic.Params.LIST_ORDER, i2);
        d.b.i0.c3.c.g().c(bdUniqueId, i4);
    }

    public static void e(BdUniqueId bdUniqueId, List<n> list, ForumData forumData, int i) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (list.get(i3) instanceof d.b.i0.e.c) {
                i2++;
            }
            if (i2 <= 0) {
                return;
            }
            d(bdUniqueId, i2, forumData, i, 0);
        }
    }

    public static void f(a2 a2Var, int i) {
        TiebaStatic.log(i != 2 ? null : d.b.i0.c3.a.n("c13692", a2Var, 2));
    }

    public static void g(StatisticItem statisticItem, TbPageTag tbPageTag, boolean z) {
        int i;
        if (statisticItem == null || tbPageTag == null) {
            return;
        }
        int i2 = 0;
        if ("a070".equals(tbPageTag.locatePage)) {
            i = 1;
        } else if ("a071".equals(tbPageTag.locatePage)) {
            i = 2;
        } else if ("a072".equals(tbPageTag.locatePage)) {
            i = 3;
        } else {
            int i3 = tbPageTag.tabId;
            if (502 == i3) {
                i = 5;
            } else {
                int i4 = tbPageTag.tabType;
                if (92 == i4 || 49 == i3 || 1120 == i3 || 1121 == i3) {
                    i = 6;
                } else if (16 == i4) {
                    i = 7;
                } else if (3 == i4) {
                    i = 8;
                } else if (90 == i3) {
                    i = 9;
                } else if (505 == i3) {
                    i = 10;
                } else {
                    i = tbPageTag.isGeneralTab == 1 ? 4 : 0;
                }
            }
        }
        if (z) {
            if (i > 0) {
                statisticItem.delete("obj_name");
                statisticItem.param("obj_name", i);
            }
        } else if (i > 0) {
            statisticItem.delete("obj_locate");
            statisticItem.param("obj_locate", i);
        }
        int i5 = tbPageTag.sortType;
        if (i5 == 1) {
            i2 = 3;
        } else if (i5 == 2) {
            i2 = 1;
        } else if (i5 == 3) {
            i2 = 2;
        } else if (i5 == 4) {
            i2 = 4;
        }
        if (i2 > 0) {
            if (i == 1 || i == 2) {
                statisticItem.delete(TiebaStatic.Params.LIST_ORDER);
                statisticItem.param(TiebaStatic.Params.LIST_ORDER, i2);
            }
        }
    }

    public static void h(a2 a2Var, TbPageTag tbPageTag) {
        if (a2Var == null) {
            return;
        }
        StatisticItem param = new StatisticItem("common_click").param("page_type", "a006").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_AD_LOCATE, 15).param("obj_id", a2Var.o0()).param("fid", a2Var.c0()).param(TiebaStatic.Params.OBJ_FLOOR, a2Var.M1).param("tid", a2Var.o0()).param("thread_type", a2Var.s1()).param(TiebaStatic.Params.FIRST_DIR, a2Var.d0()).param(TiebaStatic.Params.SECOND_DIR, a2Var.d1()).param("nid", a2Var.L0()).param(TiebaStatic.Params.IS_ZP, a2Var.D2() ? 1 : 0);
        a(param, a2Var, tbPageTag);
        TiebaStatic.log(param);
    }

    public static void i(a2 a2Var, BdUniqueId bdUniqueId, b bVar, TbPageTag tbPageTag) {
        int i;
        String str;
        boolean z;
        int i2;
        if (a2Var == null) {
            return;
        }
        String str2 = null;
        boolean z2 = (a2Var.q1() == null || a2Var.q1().user_info == null || a2Var.q1().user_info.is_official != 2) ? false : true;
        boolean z3 = z2 && a2Var.q1().frsLiveStageType == 0;
        if (z3) {
            str2 = String.valueOf(a2Var.q1().live_id);
            i = 4;
        } else {
            i = 0;
        }
        if (!z3) {
            z3 = a2Var.s1() == 41;
            if (z3) {
                if (a2Var.o1() != null) {
                    str2 = a2Var.o1().f();
                }
                i = 2;
            }
        }
        if (a2Var.P1) {
            str2 = a2Var.o0();
            i = 14;
            z3 = true;
        }
        if (a2Var.i2) {
            str = a2Var.j2;
            z = true;
            i2 = 17;
        } else {
            str = str2;
            z = z3;
            i2 = i;
        }
        StatisticItem g2 = d.b.i0.c3.a.g(a2Var, "a006", "common_exp", a2Var.M1, z, str, null, i2);
        if (g2 == null) {
            return;
        }
        g2.param(TiebaStatic.Params.LIST_ORDER, c.j().k(bVar));
        if (a2Var.b2()) {
            g2.param(TiebaStatic.Params.GUA_TYPE, 1);
        } else if (a2Var.y0() != null) {
            g2.param(TiebaStatic.Params.GUA_TYPE, 2);
        } else {
            g2.param(TiebaStatic.Params.GUA_TYPE, 0);
        }
        a(g2, a2Var, tbPageTag);
        if (z2) {
            g2.param(TiebaStatic.Params.IS_OFFICIAL, a2Var.q1().user_info.is_official);
        }
        if (z2 || a2Var.P1 || a2Var.i2) {
            g2.delete("thread_type");
            g2.param("thread_type", a2Var.s1());
        }
        g(g2, tbPageTag, false);
        d.b.i0.c3.c.g().d(bdUniqueId, d.b.i0.c3.a.c(a2Var.w1(), str, "", a2Var.V()), g2);
        if (a2Var.P1) {
            c(a2Var, bdUniqueId, tbPageTag);
        }
    }
}
