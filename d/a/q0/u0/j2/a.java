package d.a.q0.u0.j2;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiePlusStatic;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.d.e.p.k;
import d.a.d.k.e.n;
import d.a.p0.s.q.b2;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(StatisticItem statisticItem, b2 b2Var, TbPageTag tbPageTag) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, statisticItem, b2Var, tbPageTag) == null) {
            if (!k.isEmpty(b2Var.U0)) {
                statisticItem.param(TiebaStatic.Params.RECOM_WEIGHT, b2Var.U0);
            }
            if (!k.isEmpty(b2Var.W0)) {
                statisticItem.param(TiebaStatic.Params.RECOM_EXTRA, b2Var.W0);
            }
            if (!k.isEmpty(b2Var.T0)) {
                statisticItem.param("recom_source", b2Var.T0);
            }
            if (!k.isEmpty(b2Var.V0)) {
                statisticItem.param(TiebaStatic.Params.RECOM_AB_TAG, b2Var.V0);
            }
            statisticItem.param(TiebaStatic.Params.RECOM_TYPE, b2Var.M0());
            d.a.p0.l0.c.a(statisticItem, tbPageTag);
        }
    }

    public static void b(b2 b2Var, TbPageTag tbPageTag, String str) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, b2Var, tbPageTag, str) == null) {
            int i3 = 2;
            if ("a070".equals(tbPageTag.locatePage)) {
                i2 = 1;
            } else if (!"a071".equals(tbPageTag.locatePage)) {
                return;
            } else {
                i2 = 2;
            }
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.param("tid", b2Var.A);
            statisticItem.param("fid", b2Var.R());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            if (b2Var.H() != null && b2Var.H().getAlaInfo() != null) {
                statisticItem.param("obj_param1", YYLiveUtil.calculateLiveType(b2Var.H().getAlaInfo()));
                if (b2Var.H().getAlaInfo().mYyExtData != null) {
                    TiebaStaticHelper.addYYParam(statisticItem, b2Var.H().getAlaInfo().mYyExtData);
                }
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, (b2Var.H().getAlaInfo().live_status == 1 || b2Var.H().getAlaInfo().friendRoomStatus == 2) ? 1 : 1);
            }
            statisticItem.param("obj_locate", i2);
            TiebaStatic.log(statisticItem);
        }
    }

    @Deprecated
    public static void c(b2 b2Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, b2Var, str) == null) {
            d(b2Var, str, 1);
        }
    }

    public static void d(b2 b2Var, String str, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(65539, null, b2Var, str, i2) == null) && b2Var != null && b2Var.N2) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_HEATING_THREAD_CLICK);
            statisticItem.addParam("obj_locate", 2);
            if (b2Var.t2()) {
                statisticItem.addParam("obj_type", 3);
            } else if (b2Var.s2()) {
                statisticItem.addParam("obj_type", 2);
            } else {
                statisticItem.addParam("obj_type", 1);
            }
            statisticItem.addParam(TiePlusStatic.Params.CLI_LOCATE, i2);
            statisticItem.addParam("tid", b2Var.o1());
            statisticItem.addParam(TiebaStatic.Params.FID_1, b2Var.R());
            statisticItem.addParam(TiebaStatic.Params.FID_2, str);
            TiebaStatic.log(statisticItem);
            d.a.p0.d.a.a(d.a.p0.d.a.f52219e, d.a.p0.d.a.f52216b, b2Var.O2, b2Var.P2, b2Var.Q2, b2Var.P1);
        }
    }

    public static void e(b2 b2Var, int i2, BdUniqueId bdUniqueId, b bVar, TbPageTag tbPageTag) {
        int i3;
        String str;
        boolean z;
        int i4;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{b2Var, Integer.valueOf(i2), bdUniqueId, bVar, tbPageTag}) == null) || b2Var == null) {
            return;
        }
        String str2 = null;
        boolean z2 = (b2Var.h1() == null || b2Var.h1().user_info == null || b2Var.h1().user_info.is_official != 2) ? false : true;
        boolean z3 = z2 && b2Var.h1().frsLiveStageType == 0;
        if (z3) {
            str2 = String.valueOf(b2Var.h1().live_id);
            i3 = 4;
        } else {
            i3 = 0;
        }
        if (!z3) {
            z3 = b2Var.k1() == 41;
            if (z3) {
                if (b2Var.f1() != null) {
                    str2 = b2Var.f1().f();
                }
                i3 = 2;
            }
        }
        if (b2Var.S1) {
            str2 = b2Var.d0();
            i3 = 14;
            z3 = true;
        }
        if (b2Var.m2) {
            str = b2Var.n2;
            z = true;
            i4 = 17;
        } else {
            str = str2;
            z = z3;
            i4 = i3;
        }
        StatisticItem e2 = d.a.q0.g3.a.e(b2Var, "a006", "common_click", i2, b2Var.P1, z, str, null, i4);
        if (e2 == null) {
            return;
        }
        e2.param(TiebaStatic.Params.LIST_ORDER, c.j().k(bVar));
        if (b2Var.S1()) {
            e2.param(TiebaStatic.Params.GUA_TYPE, 1);
        } else if (b2Var.o0() != null) {
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
        a(e2, b2Var, tbPageTag);
        if (b2Var.S1()) {
            e2.param(TiebaStatic.Params.GUA_TYPE, 1);
        }
        if (z2) {
            e2.param(TiebaStatic.Params.IS_OFFICIAL, b2Var.h1().user_info.is_official);
        }
        if (z2 || b2Var.S1 || b2Var.m2) {
            e2.delete("thread_type");
            e2.param("thread_type", b2Var.k1());
        }
        j(e2, tbPageTag, true);
        d.a.q0.g3.c.g().c(bdUniqueId, e2);
        i(b2Var, i2);
        n(b2Var, tbPageTag, i2);
    }

    public static void f(b2 b2Var, BdUniqueId bdUniqueId, TbPageTag tbPageTag) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, b2Var, bdUniqueId, tbPageTag) == null) || b2Var == null || bdUniqueId == null || !b2Var.S1) {
            return;
        }
        boolean z = (b2Var.H() == null || b2Var.H().getUserId() == null || !b2Var.H().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (!b2Var.l2() || b2Var.Q() == null || z) {
            return;
        }
        StatisticItem param = new StatisticItem("common_exp").param("page_type", "a006").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_AD_LOCATE, 15).param("obj_id", b2Var.d0()).param(TiebaStatic.Params.OBJ_FLOOR, b2Var.P1).param("fid", b2Var.R()).param("thread_type", b2Var.k1()).param("tid", b2Var.d0()).param(TiebaStatic.Params.FIRST_DIR, b2Var.S()).param(TiebaStatic.Params.SECOND_DIR, b2Var.U0());
        a(param, b2Var, tbPageTag);
        String c2 = d.a.q0.g3.a.c(b2Var.o1(), "", "", b2Var.J());
        d.a.q0.g3.c g2 = d.a.q0.g3.c.g();
        g2.d(bdUniqueId, c2 + "_15", param);
    }

    public static void g(BdUniqueId bdUniqueId, int i2, ForumData forumData, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{bdUniqueId, Integer.valueOf(i2), forumData, Integer.valueOf(i3), Integer.valueOf(i4)}) == null) || i2 <= 0) {
            return;
        }
        StatisticItem i5 = d.a.q0.g3.a.i("a006", "common_fill", true, i2, i4);
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
        d.a.q0.g3.c.g().c(bdUniqueId, i5);
    }

    public static void h(BdUniqueId bdUniqueId, List<n> list, ForumData forumData, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(65543, null, bdUniqueId, list, forumData, i2) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            if (list.get(i4) instanceof d.a.q0.e.c) {
                i3++;
            }
            if (i3 <= 0) {
                return;
            }
            g(bdUniqueId, i3, forumData, i2, 0);
        }
    }

    public static void i(b2 b2Var, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65544, null, b2Var, i2) == null) {
            TiebaStatic.log(i2 != 2 ? null : d.a.q0.g3.a.n("c13692", b2Var, 2));
        }
    }

    public static void j(StatisticItem statisticItem, TbPageTag tbPageTag, boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(65545, null, statisticItem, tbPageTag, z) == null) || statisticItem == null || tbPageTag == null) {
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

    public static void k(b2 b2Var, TbPageTag tbPageTag) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65546, null, b2Var, tbPageTag) == null) || b2Var == null) {
            return;
        }
        StatisticItem param = new StatisticItem("common_click").param("page_type", "a006").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_AD_LOCATE, 15).param("obj_id", b2Var.d0()).param("fid", b2Var.R()).param(TiebaStatic.Params.OBJ_FLOOR, b2Var.P1).param("tid", b2Var.d0()).param("thread_type", b2Var.k1()).param(TiebaStatic.Params.FIRST_DIR, b2Var.S()).param(TiebaStatic.Params.SECOND_DIR, b2Var.U0()).param("nid", b2Var.B0()).param(TiebaStatic.Params.IS_ZP, b2Var.w2() ? 1 : 0);
        a(param, b2Var, tbPageTag);
        TiebaStatic.log(param);
    }

    public static void l(b2 b2Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65547, null, b2Var, str) == null) && b2Var != null && b2Var.N2) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_HEATING_THREAD_EXPOSE);
            statisticItem.addParam("obj_locate", 2);
            if (b2Var.t2()) {
                statisticItem.addParam("obj_type", 3);
            } else if (b2Var.s2()) {
                statisticItem.addParam("obj_type", 2);
            } else {
                statisticItem.addParam("obj_type", 1);
            }
            statisticItem.addParam("tid", b2Var.o1());
            statisticItem.addParam(TiebaStatic.Params.FID_1, b2Var.R());
            statisticItem.addParam(TiebaStatic.Params.FID_2, str);
            TiebaStatic.log(statisticItem);
            d.a.p0.d.a.a(d.a.p0.d.a.f52218d, d.a.p0.d.a.f52216b, b2Var.O2, b2Var.P2, b2Var.Q2, b2Var.P1);
        }
    }

    public static void m(b2 b2Var, BdUniqueId bdUniqueId, b bVar, TbPageTag tbPageTag) {
        int i2;
        String str;
        boolean z;
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65548, null, b2Var, bdUniqueId, bVar, tbPageTag) == null) || b2Var == null) {
            return;
        }
        String str2 = null;
        boolean z2 = (b2Var.h1() == null || b2Var.h1().user_info == null || b2Var.h1().user_info.is_official != 2) ? false : true;
        boolean z3 = z2 && b2Var.h1().frsLiveStageType == 0;
        if (z3) {
            str2 = String.valueOf(b2Var.h1().live_id);
            i2 = 4;
        } else {
            i2 = 0;
        }
        if (!z3) {
            z3 = b2Var.k1() == 41;
            if (z3) {
                if (b2Var.f1() != null) {
                    str2 = b2Var.f1().f();
                }
                i2 = 2;
            }
        }
        if (b2Var.S1) {
            str2 = b2Var.d0();
            i2 = 14;
            z3 = true;
        }
        if (b2Var.m2) {
            str = b2Var.n2;
            z = true;
            i3 = 17;
        } else {
            str = str2;
            z = z3;
            i3 = i2;
        }
        StatisticItem g2 = d.a.q0.g3.a.g(b2Var, "a006", "common_exp", b2Var.P1, z, str, null, i3);
        if (g2 == null) {
            return;
        }
        g2.param(TiebaStatic.Params.LIST_ORDER, c.j().k(bVar));
        if (b2Var.S1()) {
            g2.param(TiebaStatic.Params.GUA_TYPE, 1);
        } else if (b2Var.o0() != null) {
            g2.param(TiebaStatic.Params.GUA_TYPE, 2);
        } else {
            g2.param(TiebaStatic.Params.GUA_TYPE, 0);
        }
        a(g2, b2Var, tbPageTag);
        if (z2) {
            g2.param(TiebaStatic.Params.IS_OFFICIAL, b2Var.h1().user_info.is_official);
        }
        if (z2 || b2Var.S1 || b2Var.m2) {
            g2.delete("thread_type");
            g2.param("thread_type", b2Var.k1());
        }
        j(g2, tbPageTag, false);
        d.a.q0.g3.c.g().d(bdUniqueId, d.a.q0.g3.a.c(b2Var.o1(), str, "", b2Var.J()), g2);
        if (b2Var.S1) {
            f(b2Var, bdUniqueId, tbPageTag);
        }
        o(b2Var, tbPageTag);
    }

    public static void n(b2 b2Var, TbPageTag tbPageTag, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(65549, null, b2Var, tbPageTag, i2) == null) && b2Var != null && 2 == i2) {
            b(b2Var, tbPageTag, CommonStatisticKey.KEY_YY_FRS_HEAD_SCULPTURE_CLICK);
        }
    }

    public static void o(b2 b2Var, TbPageTag tbPageTag) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65550, null, b2Var, tbPageTag) == null) || b2Var == null) {
            return;
        }
        b(b2Var, tbPageTag, CommonStatisticKey.KEY_YY_FRS_HEAD_SCULPTURE_SHOW);
    }
}
