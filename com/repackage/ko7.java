package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.newdetail.HotTopicDetailActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ko7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, Object obj, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(65536, null, str, obj, i, str2) == null) {
            StatisticItem statisticItem = new StatisticItem(str);
            if (obj instanceof uq4) {
                statisticItem.param("fid", ((uq4) obj).j());
            } else if (obj instanceof bp7) {
                bp7 bp7Var = (bp7) obj;
                ThreadData threadData = bp7Var.h;
                if (threadData != null) {
                    statisticItem.param("tid", threadData.getTid());
                }
                statisticItem.param("obj_locate", bp7Var.a());
            }
            statisticItem.param("topic_id", str2);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.eventStat();
        }
    }

    public static void b(no7 no7Var, fo4 fo4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, no7Var, fo4Var) == null) {
            d(no7Var, fo4Var, true);
        }
    }

    public static void c(no7 no7Var, fo4 fo4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, no7Var, fo4Var) == null) {
            d(no7Var, fo4Var, false);
        }
    }

    public static void d(no7 no7Var, fo4 fo4Var, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(65539, null, no7Var, fo4Var, z) == null) || fo4Var == null || fo4Var.getThreadData() == null) {
            return;
        }
        ThreadData threadData = fo4Var.getThreadData();
        boolean s = no7Var.s();
        StatisticItem statisticItem = new StatisticItem(z ? s ? "c13823" : "c13822" : s ? "c13824" : "c13821");
        statisticItem.param("tid", threadData.getTid());
        statisticItem.param("fid", threadData.getFid());
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        if (no7Var.t().getOrignalPage() instanceof HotTopicDetailActivity) {
            statisticItem.param("topic_id", ((HotTopicDetailActivity) no7Var.t().getOrignalPage()).B1());
        }
        statisticItem.eventStat();
    }

    public static void e(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, threadData) == null) || threadData == null) {
            return;
        }
        new StatisticItem("c13022").addParam("tid", threadData.getTid()).addParam("fid", threadData.getFid()).addParam("fname", threadData.getForum_name()).addParam("uid", TbadkCoreApplication.getCurrentAccount()).addParam(TiebaStatic.Params.OBJ_TO, UbsABTestHelper.isImgClickToPb() ? 1 : 2).eventStat();
    }

    public static void f(TbPageContext<HotTopicDetailActivity> tbPageContext, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65541, null, tbPageContext, str) == null) || tbPageContext == null || StringUtils.isNull(str)) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(str);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem.param("topic_id", tbPageContext.getOrignalPage().B1());
        statisticItem.eventStat();
    }

    public static void g(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65542, null, str, str2) == null) || StringUtils.isNull(str) || StringUtils.isNull(str2)) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(str);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem.param("topic_id", str2);
        statisticItem.eventStat();
    }

    public static void h(TbPageContext<HotTopicDetailActivity> tbPageContext, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65543, null, tbPageContext, str) == null) || tbPageContext == null || StringUtils.isNull(str)) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(str);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem.param("topic_id", tbPageContext.getOrignalPage().B1());
        statisticItem.eventStat();
    }
}
