package d.a.n0.r0.j2;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.pageInfo.TbPageTag;
import d.a.c.e.p.k;
import d.a.c.j.e.n;
import d.a.m0.r.q.a2;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    public static void a(StatisticItem statisticItem, a2 a2Var, TbPageTag tbPageTag) {
        if (!k.isEmpty(a2Var.T0)) {
            statisticItem.param(TiebaStatic.Params.RECOM_WEIGHT, a2Var.T0);
        }
        if (!k.isEmpty(a2Var.V0)) {
            statisticItem.param(TiebaStatic.Params.RECOM_EXTRA, a2Var.V0);
        }
        if (!k.isEmpty(a2Var.S0)) {
            statisticItem.param("recom_source", a2Var.S0);
        }
        if (!k.isEmpty(a2Var.U0)) {
            statisticItem.param(TiebaStatic.Params.RECOM_AB_TAG, a2Var.U0);
        }
        statisticItem.param(TiebaStatic.Params.RECOM_TYPE, a2Var.V0());
        d.a.m0.j0.c.a(statisticItem, tbPageTag);
    }

    public static void b(a2 a2Var, TbPageTag tbPageTag, String str) {
        int i2;
        int i3 = 2;
        if ("a070".equals(tbPageTag.locatePage)) {
            i2 = 1;
        } else if (!"a071".equals(tbPageTag.locatePage)) {
            return;
        } else {
            i2 = 2;
        }
        StatisticItem statisticItem = new StatisticItem(str);
        statisticItem.param("tid", a2Var.A);
        statisticItem.param("fid", a2Var.c0());
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        if (a2Var.T() != null && a2Var.T().getAlaInfo() != null) {
            statisticItem.param("obj_param1", YYLiveUtil.calculateLiveType(a2Var.T().getAlaInfo()));
            if (a2Var.T().getAlaInfo().mYyExtData != null) {
                TiebaStaticHelper.addYYParam(statisticItem, a2Var.T().getAlaInfo().mYyExtData);
            }
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, (a2Var.T().getAlaInfo().live_status == 1 || a2Var.T().getAlaInfo().friendRoomStatus == 2) ? 1 : 1);
        }
        statisticItem.param("obj_locate", i2);
        TiebaStatic.log(statisticItem);
    }

    public static void c(a2 a2Var, int i2, BdUniqueId bdUniqueId, b bVar, TbPageTag tbPageTag) {
        int i3;
        String str;
        boolean z;
        int i4;
        if (a2Var == null) {
            return;
        }
        String str2 = null;
        boolean z2 = (a2Var.r1() == null || a2Var.r1().user_info == null || a2Var.r1().user_info.is_official != 2) ? false : true;
        boolean z3 = z2 && a2Var.r1().frsLiveStageType == 0;
        if (z3) {
            str2 = String.valueOf(a2Var.r1().live_id);
            i3 = 4;
        } else {
            i3 = 0;
        }
        if (!z3) {
            z3 = a2Var.u1() == 41;
            if (z3) {
                if (a2Var.p1() != null) {
                    str2 = a2Var.p1().f();
                }
                i3 = 2;
            }
        }
        if (a2Var.Q1) {
            str2 = a2Var.o0();
            i3 = 14;
            z3 = true;
        }
        if (a2Var.j2) {
            str = a2Var.k2;
            z = true;
            i4 = 17;
        } else {
            str = str2;
            z = z3;
            i4 = i3;
        }
        StatisticItem e2 = d.a.n0.d3.a.e(a2Var, "a006", "common_click", i2, a2Var.N1, z, str, null, i4);
        if (e2 == null) {
            return;
        }
        e2.param(TiebaStatic.Params.LIST_ORDER, c.j().k(bVar));
        if (a2Var.d2()) {
            e2.param(TiebaStatic.Params.GUA_TYPE, 1);
        } else if (a2Var.z0() != null) {
            e2.param(TiebaStatic.Params.GUA_TYPE, 2);
            int indexOf = e2.getParams().indexOf("obj_locate");
            if (indexOf >= 0) {
                int i5 = indexOf + 1;
                e2.getParams().remove(i5);
                e2.getParams().add(i5, 16);
            } else {
                e2.param("obj_locate", 16);
            }
        } else {
            e2.param(TiebaStatic.Params.GUA_TYPE, 0);
        }
        a(e2, a2Var, tbPageTag);
        if (a2Var.d2()) {
            e2.param(TiebaStatic.Params.GUA_TYPE, 1);
        }
        if (z2) {
            e2.param(TiebaStatic.Params.IS_OFFICIAL, a2Var.r1().user_info.is_official);
        }
        if (z2 || a2Var.Q1 || a2Var.j2) {
            e2.delete("thread_type");
            e2.param("thread_type", a2Var.u1());
        }
        h(e2, tbPageTag, true);
        d.a.n0.d3.c.g().c(bdUniqueId, e2);
        g(a2Var, i2);
        k(a2Var, tbPageTag, i2);
    }

    public static void d(a2 a2Var, BdUniqueId bdUniqueId, TbPageTag tbPageTag) {
        if (a2Var == null || bdUniqueId == null || !a2Var.Q1) {
            return;
        }
        boolean z = (a2Var.T() == null || a2Var.T().getUserId() == null || !a2Var.T().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (!a2Var.w2() || a2Var.b0() == null || z) {
            return;
        }
        StatisticItem param = new StatisticItem("common_exp").param("page_type", "a006").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_AD_LOCATE, 15).param("obj_id", a2Var.o0()).param(TiebaStatic.Params.OBJ_FLOOR, a2Var.N1).param("fid", a2Var.c0()).param("thread_type", a2Var.u1()).param("tid", a2Var.o0()).param(TiebaStatic.Params.FIRST_DIR, a2Var.d0()).param(TiebaStatic.Params.SECOND_DIR, a2Var.e1());
        a(param, a2Var, tbPageTag);
        String c2 = d.a.n0.d3.a.c(a2Var.y1(), "", "", a2Var.V());
        d.a.n0.d3.c g2 = d.a.n0.d3.c.g();
        g2.d(bdUniqueId, c2 + "_15", param);
    }

    public static void e(BdUniqueId bdUniqueId, int i2, ForumData forumData, int i3, int i4) {
        if (i2 <= 0) {
            return;
        }
        StatisticItem i5 = d.a.n0.d3.a.i("a006", "common_fill", true, i2, i4);
        if (forumData != null) {
            if (!k.isEmpty(forumData.getId())) {
                i5.param("fid", forumData.getId());
            }
            if (!k.isEmpty(forumData.getName())) {
                i5.param("fname", forumData.getName());
            }
            if (!k.isEmpty(forumData.getFirst_class())) {
                i5.param(TiebaStatic.Params.FIRST_DIR, forumData.getFirst_class());
            }
            if (!k.isEmpty(forumData.getSecond_class())) {
                i5.param(TiebaStatic.Params.SECOND_DIR, forumData.getSecond_class());
            }
        }
        i5.param(TiebaStatic.Params.LIST_ORDER, i3);
        d.a.n0.d3.c.g().c(bdUniqueId, i5);
    }

    public static void f(BdUniqueId bdUniqueId, List<n> list, ForumData forumData, int i2) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            if (list.get(i4) instanceof d.a.n0.e.c) {
                i3++;
            }
            if (i3 <= 0) {
                return;
            }
            e(bdUniqueId, i3, forumData, i2, 0);
        }
    }

    public static void g(a2 a2Var, int i2) {
        TiebaStatic.log(i2 != 2 ? null : d.a.n0.d3.a.n("c13692", a2Var, 2));
    }

    public static void h(StatisticItem statisticItem, TbPageTag tbPageTag, boolean z) {
        int i2;
        if (statisticItem == null || tbPageTag == null) {
            return;
        }
        int i3 = 0;
        if ("a070".equals(tbPageTag.locatePage)) {
            i2 = 1;
        } else if ("a071".equals(tbPageTag.locatePage)) {
            i2 = 2;
        } else if ("a072".equals(tbPageTag.locatePage)) {
            i2 = 3;
        } else {
            int i4 = tbPageTag.tabId;
            if (502 == i4) {
                i2 = 5;
            } else {
                int i5 = tbPageTag.tabType;
                if (92 == i5 || 49 == i4 || 1120 == i4) {
                    i2 = 6;
                } else if (16 == i5) {
                    i2 = 7;
                } else if (3 == i5) {
                    i2 = 8;
                } else if (90 == i4) {
                    i2 = 9;
                } else if (505 == i4) {
                    i2 = 10;
                } else {
                    i2 = tbPageTag.isGeneralTab == 1 ? 4 : 0;
                }
            }
        }
        if (z) {
            if (i2 > 0) {
                statisticItem.delete("obj_name");
                statisticItem.param("obj_name", i2);
            }
        } else if (i2 > 0) {
            statisticItem.delete("obj_locate");
            statisticItem.param("obj_locate", i2);
        }
        int i6 = tbPageTag.sortType;
        if (i6 == 1) {
            i3 = 3;
        } else if (i6 == 2) {
            i3 = 1;
        } else if (i6 == 3) {
            i3 = 2;
        } else if (i6 == 4) {
            i3 = 4;
        }
        if (i3 > 0) {
            if (i2 == 1 || i2 == 2) {
                statisticItem.delete(TiebaStatic.Params.LIST_ORDER);
                statisticItem.param(TiebaStatic.Params.LIST_ORDER, i3);
            }
        }
    }

    public static void i(a2 a2Var, TbPageTag tbPageTag) {
        if (a2Var == null) {
            return;
        }
        StatisticItem param = new StatisticItem("common_click").param("page_type", "a006").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_AD_LOCATE, 15).param("obj_id", a2Var.o0()).param("fid", a2Var.c0()).param(TiebaStatic.Params.OBJ_FLOOR, a2Var.N1).param("tid", a2Var.o0()).param("thread_type", a2Var.u1()).param(TiebaStatic.Params.FIRST_DIR, a2Var.d0()).param(TiebaStatic.Params.SECOND_DIR, a2Var.e1()).param("nid", a2Var.M0()).param(TiebaStatic.Params.IS_ZP, a2Var.G2() ? 1 : 0);
        a(param, a2Var, tbPageTag);
        TiebaStatic.log(param);
    }

    public static void j(a2 a2Var, BdUniqueId bdUniqueId, b bVar, TbPageTag tbPageTag) {
        int i2;
        String str;
        boolean z;
        int i3;
        if (a2Var == null) {
            return;
        }
        String str2 = null;
        boolean z2 = (a2Var.r1() == null || a2Var.r1().user_info == null || a2Var.r1().user_info.is_official != 2) ? false : true;
        boolean z3 = z2 && a2Var.r1().frsLiveStageType == 0;
        if (z3) {
            str2 = String.valueOf(a2Var.r1().live_id);
            i2 = 4;
        } else {
            i2 = 0;
        }
        if (!z3) {
            z3 = a2Var.u1() == 41;
            if (z3) {
                if (a2Var.p1() != null) {
                    str2 = a2Var.p1().f();
                }
                i2 = 2;
            }
        }
        if (a2Var.Q1) {
            str2 = a2Var.o0();
            i2 = 14;
            z3 = true;
        }
        if (a2Var.j2) {
            str = a2Var.k2;
            z = true;
            i3 = 17;
        } else {
            str = str2;
            z = z3;
            i3 = i2;
        }
        StatisticItem g2 = d.a.n0.d3.a.g(a2Var, "a006", "common_exp", a2Var.N1, z, str, null, i3);
        if (g2 == null) {
            return;
        }
        g2.param(TiebaStatic.Params.LIST_ORDER, c.j().k(bVar));
        if (a2Var.d2()) {
            g2.param(TiebaStatic.Params.GUA_TYPE, 1);
        } else if (a2Var.z0() != null) {
            g2.param(TiebaStatic.Params.GUA_TYPE, 2);
        } else {
            g2.param(TiebaStatic.Params.GUA_TYPE, 0);
        }
        a(g2, a2Var, tbPageTag);
        if (z2) {
            g2.param(TiebaStatic.Params.IS_OFFICIAL, a2Var.r1().user_info.is_official);
        }
        if (z2 || a2Var.Q1 || a2Var.j2) {
            g2.delete("thread_type");
            g2.param("thread_type", a2Var.u1());
        }
        h(g2, tbPageTag, false);
        d.a.n0.d3.c.g().d(bdUniqueId, d.a.n0.d3.a.c(a2Var.y1(), str, "", a2Var.V()), g2);
        if (a2Var.Q1) {
            d(a2Var, bdUniqueId, tbPageTag);
        }
        l(a2Var, tbPageTag);
    }

    public static void k(a2 a2Var, TbPageTag tbPageTag, int i2) {
        if (a2Var != null && 2 == i2) {
            b(a2Var, tbPageTag, CommonStatisticKey.KEY_YY_FRS_HEAD_SCULPTURE_CLICK);
        }
    }

    public static void l(a2 a2Var, TbPageTag tbPageTag) {
        if (a2Var == null) {
            return;
        }
        b(a2Var, tbPageTag, CommonStatisticKey.KEY_YY_FRS_HEAD_SCULPTURE_SHOW);
    }
}
