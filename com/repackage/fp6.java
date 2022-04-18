package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.ThreadData;
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
import java.util.List;
/* loaded from: classes6.dex */
public class fp6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(StatisticItem statisticItem, ThreadData threadData, TbPageTag tbPageTag) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, statisticItem, threadData, tbPageTag) == null) {
            if (!ni.isEmpty(threadData.mRecomWeight)) {
                statisticItem.param(TiebaStatic.Params.RECOM_WEIGHT, threadData.mRecomWeight);
            }
            if (!ni.isEmpty(threadData.mRecomExtra)) {
                statisticItem.param(TiebaStatic.Params.RECOM_EXTRA, threadData.mRecomExtra);
            }
            if (!ni.isEmpty(threadData.mRecomSource)) {
                statisticItem.param("recom_source", threadData.mRecomSource);
            }
            if (!ni.isEmpty(threadData.mRecomAbTag)) {
                statisticItem.param(TiebaStatic.Params.RECOM_AB_TAG, threadData.mRecomAbTag);
            }
            statisticItem.param(TiebaStatic.Params.RECOM_TYPE, threadData.getRecomCardType());
            u75.a(statisticItem, tbPageTag);
        }
    }

    public static void b(ThreadData threadData, TbPageTag tbPageTag, String str) {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65537, null, threadData, tbPageTag, str) == null) || threadData == null) {
            return;
        }
        int i2 = 2;
        if ("a070".equals(tbPageTag.locatePage)) {
            i = 1;
        } else if (!"a071".equals(tbPageTag.locatePage)) {
            return;
        } else {
            i = 2;
        }
        StatisticItem statisticItem = new StatisticItem(str);
        statisticItem.param("tid", threadData.tid);
        statisticItem.param("fid", threadData.getFid());
        statisticItem.param("fname", threadData.getForum_name());
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        if (threadData.getAuthor() != null && threadData.getAuthor().getAlaInfo() != null) {
            statisticItem.param("obj_param1", YYLiveUtil.calculateLiveType(threadData.getAuthor().getAlaInfo()));
            if (threadData.getAuthor().getAlaInfo().mYyExtData != null) {
                TiebaStaticHelper.addYYParam(statisticItem, threadData.getAuthor().getAlaInfo().mYyExtData);
            }
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, (threadData.getAuthor().getAlaInfo().live_status == 1 || threadData.getAuthor().getAlaInfo().friendRoomStatus == 2) ? 1 : 1);
        }
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, threadData.getYYStaticticType());
        statisticItem.param("obj_locate", i);
        TiebaStatic.log(statisticItem);
    }

    @Deprecated
    public static void c(ThreadData threadData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, threadData, str) == null) {
            d(threadData, str, 1);
        }
    }

    public static void d(ThreadData threadData, String str, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(65539, null, threadData, str, i) == null) || threadData == null) {
            return;
        }
        if (threadData.isTiebaPlusAdThread) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_HEATING_THREAD_CLICK);
            statisticItem.addParam("obj_locate", threadData.tiePlusFrsStaticLocate);
            if (threadData.isVideoWorksInfo()) {
                statisticItem.addParam("obj_type", 3);
            } else if (threadData.isVideoThreadType()) {
                statisticItem.addParam("obj_type", 2);
            } else {
                statisticItem.addParam("obj_type", 1);
            }
            statisticItem.addParam(TiePlusStatic.Params.CLI_LOCATE, i);
            statisticItem.addParam("tid", threadData.getTid());
            statisticItem.addParam(TiebaStatic.Params.FID_1, threadData.getFid());
            statisticItem.addParam(TiebaStatic.Params.FID_2, str);
            statisticItem.addParam("order_id", threadData.tiebaPlusOrderId);
            TiebaStatic.log(statisticItem);
            sk4.a(sk4.e, sk4.b, threadData.tiebaPlusOrderId, threadData.tiebaPlusToken, threadData.tiebaPlusExtraParam, threadData.statFloor);
        }
        if (threadData.getRecomSource() == null || !threadData.getRecomSource().startsWith("manual")) {
            return;
        }
        sk4.a(sk4.l, sk4.b, threadData.tiebaPlusOrderId, threadData.tiebaPlusToken, threadData.tiebaPlusExtraParam, threadData.statFloor);
    }

    public static void e(ThreadData threadData, int i, BdUniqueId bdUniqueId, gp6 gp6Var, TbPageTag tbPageTag) {
        int i2;
        String str;
        boolean z;
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{threadData, Integer.valueOf(i), bdUniqueId, gp6Var, tbPageTag}) == null) || threadData == null) {
            return;
        }
        String str2 = null;
        boolean z2 = (threadData.getThreadAlaInfo() == null || threadData.getThreadAlaInfo().user_info == null || threadData.getThreadAlaInfo().user_info.is_official != 2) ? false : true;
        boolean z3 = z2 && threadData.getThreadAlaInfo().frsLiveStageType == 0;
        if (z3) {
            str2 = String.valueOf(threadData.getThreadAlaInfo().live_id);
            i2 = 4;
        } else {
            i2 = 0;
        }
        if (!z3) {
            z3 = threadData.getThreadType() == 41;
            if (z3) {
                if (threadData.getTaskInfoData() != null) {
                    str2 = threadData.getTaskInfoData().f();
                }
                i2 = 2;
            }
        }
        if (threadData.isHeadLinePost) {
            str2 = threadData.getId();
            i2 = 14;
            z3 = true;
        }
        if (threadData.isSCard) {
            str = threadData.scardPacketId;
            z = true;
            i3 = 17;
        } else {
            str = str2;
            z = z3;
            i3 = i2;
        }
        StatisticItem d = bj8.d(threadData, "a006", "common_click", i, threadData.statFloor, z, str, null, i3);
        if (d == null) {
            return;
        }
        d.param(TiebaStatic.Params.LIST_ORDER, hp6.k().l(gp6Var));
        eo6.a(d);
        if (threadData.isGoods()) {
            d.param(TiebaStatic.Params.GUA_TYPE, 1);
        } else if (threadData.getItem() != null) {
            d.param(TiebaStatic.Params.GUA_TYPE, 2);
            int indexOf = d.getParams().indexOf("obj_locate");
            if (indexOf >= 0) {
                int i4 = indexOf + 1;
                d.getParams().remove(i4);
                d.getParams().add(i4, 16);
            } else {
                d.param("obj_locate", 16);
            }
        } else if (ef5.t(threadData)) {
            d.param(TiebaStatic.Params.GUA_TYPE, 4);
        } else {
            d.param(TiebaStatic.Params.GUA_TYPE, 0);
        }
        a(d, threadData, tbPageTag);
        if (threadData.isGoods()) {
            d.param(TiebaStatic.Params.GUA_TYPE, 1);
        }
        if (z2) {
            d.param(TiebaStatic.Params.IS_OFFICIAL, threadData.getThreadAlaInfo().user_info.is_official);
        }
        if (z2 || threadData.isHeadLinePost || threadData.isSCard) {
            d.delete("thread_type");
            d.param("thread_type", threadData.getThreadType());
        }
        j(d, tbPageTag, true);
        dj8.g().c(bdUniqueId, d);
        i(threadData, i);
        o(threadData, tbPageTag, i);
    }

    public static void f(ThreadData threadData, BdUniqueId bdUniqueId, TbPageTag tbPageTag) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65541, null, threadData, bdUniqueId, tbPageTag) == null) || threadData == null || bdUniqueId == null || !threadData.isHeadLinePost) {
            return;
        }
        boolean z = (threadData.getAuthor() == null || threadData.getAuthor().getUserId() == null || !threadData.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (!threadData.isSmartFrsThread() || threadData.getFeedBackReasonMap() == null || z) {
            return;
        }
        StatisticItem param = new StatisticItem("common_exp").param("page_type", "a006").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_AD_LOCATE, 15).param("obj_id", threadData.getId()).param(TiebaStatic.Params.OBJ_FLOOR, threadData.statFloor).param("fid", threadData.getFid()).param("thread_type", threadData.getThreadType()).param("tid", threadData.getId()).param(TiebaStatic.Params.FIRST_DIR, threadData.getFirstClassName()).param(TiebaStatic.Params.SECOND_DIR, threadData.getSecondClassName());
        a(param, threadData, tbPageTag);
        String c = bj8.c(threadData.getTid(), "", "", threadData.getBaijiahaoData());
        dj8 g = dj8.g();
        g.d(bdUniqueId, c + "_15", param);
    }

    public static void g(BdUniqueId bdUniqueId, int i, ForumData forumData, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{bdUniqueId, Integer.valueOf(i), forumData, Integer.valueOf(i2), Integer.valueOf(i3)}) == null) || i <= 0) {
            return;
        }
        StatisticItem g = bj8.g("a006", "common_fill", true, i, i3);
        if (forumData != null) {
            if (!ni.isEmpty(forumData.getId())) {
                g.param("fid", forumData.getId());
            }
            if (!ni.isEmpty(forumData.getName())) {
                g.param("fname", forumData.getName());
            }
            if (!ni.isEmpty(forumData.getFirst_class())) {
                g.param(TiebaStatic.Params.FIRST_DIR, forumData.getFirst_class());
            }
            if (!ni.isEmpty(forumData.getSecond_class())) {
                g.param(TiebaStatic.Params.SECOND_DIR, forumData.getSecond_class());
            }
        }
        g.param(TiebaStatic.Params.LIST_ORDER, i2);
        dj8.g().c(bdUniqueId, g);
    }

    public static void h(BdUniqueId bdUniqueId, List<uo> list, ForumData forumData, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(65543, null, bdUniqueId, list, forumData, i) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (list.get(i3) instanceof dh5) {
                i2++;
            }
            if (i2 <= 0) {
                return;
            }
            g(bdUniqueId, i2, forumData, i, 0);
        }
    }

    public static void i(ThreadData threadData, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65544, null, threadData, i) == null) {
            TiebaStatic.log(i != 2 ? null : bj8.l("c13692", threadData, 2));
        }
    }

    public static void j(StatisticItem statisticItem, TbPageTag tbPageTag, boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(65545, null, statisticItem, tbPageTag, z) == null) || statisticItem == null || tbPageTag == null) {
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
                if (92 == i4 || 49 == i3 || 1120 == i3) {
                    i = 6;
                } else if (16 == i4) {
                    i = 7;
                } else if (3 == i4) {
                    i = 8;
                } else if (90 == i3) {
                    i = 9;
                } else if (505 == i3) {
                    i = 10;
                } else if (100 == i4) {
                    i = 11;
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

    public static void k(ThreadData threadData, TbPageTag tbPageTag) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65546, null, threadData, tbPageTag) == null) || threadData == null) {
            return;
        }
        StatisticItem param = new StatisticItem("common_click").param("page_type", "a006").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_AD_LOCATE, 15).param("obj_id", threadData.getId()).param("fid", threadData.getFid()).param(TiebaStatic.Params.OBJ_FLOOR, threadData.statFloor).param("tid", threadData.getId()).param("thread_type", threadData.getThreadType()).param(TiebaStatic.Params.FIRST_DIR, threadData.getFirstClassName()).param(TiebaStatic.Params.SECOND_DIR, threadData.getSecondClassName()).param("nid", threadData.getNid()).param(TiebaStatic.Params.IS_ZP, threadData.isWorksInfo() ? 1 : 0);
        a(param, threadData, tbPageTag);
        TiebaStatic.log(param);
    }

    public static void l(ThreadData threadData, TbPageTag tbPageTag) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65547, null, threadData, tbPageTag) == null) || threadData == null || tbPageTag == null || !threadData.isTiebaPlusAdThread) {
            return;
        }
        int i = 2;
        if ("a071".equals(tbPageTag.locatePage)) {
            i = 3;
        } else if ("a072".equals(tbPageTag.locatePage)) {
            i = 5;
        } else if (tbPageTag.isGeneralTab == 1) {
            i = 4;
        }
        threadData.tiePlusFrsStaticLocate = i;
    }

    public static void m(ThreadData threadData, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65548, null, threadData, str) == null) || threadData == null) {
            return;
        }
        if (threadData.isTiebaPlusAdThread) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_HEATING_THREAD_EXPOSE);
            statisticItem.addParam("obj_locate", threadData.tiePlusFrsStaticLocate);
            if (threadData.isVideoWorksInfo()) {
                statisticItem.addParam("obj_type", 3);
            } else if (threadData.isVideoThreadType()) {
                statisticItem.addParam("obj_type", 2);
            } else {
                statisticItem.addParam("obj_type", 1);
            }
            statisticItem.addParam("tid", threadData.getTid());
            statisticItem.addParam(TiebaStatic.Params.FID_1, threadData.getFid());
            statisticItem.addParam(TiebaStatic.Params.FID_2, str);
            statisticItem.addParam("order_id", threadData.tiebaPlusOrderId);
            TiebaStatic.log(statisticItem);
            sk4.a(sk4.d, sk4.b, threadData.tiebaPlusOrderId, threadData.tiebaPlusToken, threadData.tiebaPlusExtraParam, threadData.statFloor);
        }
        if (threadData.getRecomSource() == null || !threadData.getRecomSource().startsWith("manual")) {
            return;
        }
        sk4.a(sk4.k, sk4.b, threadData.tiebaPlusOrderId, threadData.tiebaPlusToken, threadData.tiebaPlusExtraParam, threadData.statFloor);
    }

    public static void n(ThreadData threadData, BdUniqueId bdUniqueId, gp6 gp6Var, TbPageTag tbPageTag) {
        int i;
        String str;
        boolean z;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65549, null, threadData, bdUniqueId, gp6Var, tbPageTag) == null) || threadData == null) {
            return;
        }
        String str2 = null;
        boolean z2 = (threadData.getThreadAlaInfo() == null || threadData.getThreadAlaInfo().user_info == null || threadData.getThreadAlaInfo().user_info.is_official != 2) ? false : true;
        boolean z3 = z2 && threadData.getThreadAlaInfo().frsLiveStageType == 0;
        if (z3) {
            str2 = String.valueOf(threadData.getThreadAlaInfo().live_id);
            i = 4;
        } else {
            i = 0;
        }
        if (!z3) {
            z3 = threadData.getThreadType() == 41;
            if (z3) {
                if (threadData.getTaskInfoData() != null) {
                    str2 = threadData.getTaskInfoData().f();
                }
                i = 2;
            }
        }
        if (threadData.isHeadLinePost) {
            str2 = threadData.getId();
            i = 14;
            z3 = true;
        }
        if (threadData.isSCard) {
            str = threadData.scardPacketId;
            z = true;
            i2 = 17;
        } else {
            str = str2;
            z = z3;
            i2 = i;
        }
        String str3 = str;
        StatisticItem e = bj8.e(threadData, "a006", "common_exp", threadData.statFloor, z, str, null, i2);
        if (e == null) {
            return;
        }
        eo6.a(e);
        e.param(TiebaStatic.Params.LIST_ORDER, hp6.k().l(gp6Var));
        if (threadData.isGoods()) {
            e.param(TiebaStatic.Params.GUA_TYPE, 1);
        } else if (threadData.getItem() != null) {
            e.param(TiebaStatic.Params.GUA_TYPE, 2);
        } else if (ef5.t(threadData)) {
            e.param(TiebaStatic.Params.GUA_TYPE, 4);
        } else {
            e.param(TiebaStatic.Params.GUA_TYPE, 0);
        }
        a(e, threadData, tbPageTag);
        if (z2) {
            e.param(TiebaStatic.Params.IS_OFFICIAL, threadData.getThreadAlaInfo().user_info.is_official);
        }
        if (z2 || threadData.isHeadLinePost || threadData.isSCard) {
            e.delete("thread_type");
            e.param("thread_type", threadData.getThreadType());
        }
        j(e, tbPageTag, false);
        dj8.g().d(bdUniqueId, bj8.c(threadData.getTid(), str3, "", threadData.getBaijiahaoData()), e);
        if (threadData.isHeadLinePost) {
            f(threadData, bdUniqueId, tbPageTag);
        }
        p(threadData, tbPageTag);
    }

    public static void o(ThreadData threadData, TbPageTag tbPageTag, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(65550, null, threadData, tbPageTag, i) == null) && threadData != null && 2 == i) {
            b(threadData, tbPageTag, CommonStatisticKey.KEY_YY_FRS_HEAD_SCULPTURE_CLICK);
        }
    }

    public static void p(ThreadData threadData, TbPageTag tbPageTag) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65551, null, threadData, tbPageTag) == null) || threadData == null) {
            return;
        }
        b(threadData, tbPageTag, CommonStatisticKey.KEY_YY_FRS_HEAD_SCULPTURE_SHOW);
    }
}
