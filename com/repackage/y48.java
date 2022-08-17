package com.repackage;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class y48 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(View view2, fo4 fo4Var, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(65536, null, view2, fo4Var, i) == null) || view2 == null || fo4Var == null || fo4Var.getThreadData() == null || StringUtils.isNull(fo4Var.getThreadData().getTid())) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_DYNAMIC_CARD_CLICK);
        statisticItem.param("obj_source", 3);
        ThreadData threadData = fo4Var.getThreadData();
        if (threadData.isBJHArticleThreadType()) {
            statisticItem.param("obj_type", 1);
        } else if (threadData.isBJHVideoThreadType()) {
            statisticItem.param("obj_type", 2);
        } else if (threadData.isBJHNormalThreadType()) {
            statisticItem.param("obj_type", 3);
        } else if (threadData.isBJHVideoDynamicThreadType()) {
            statisticItem.param("obj_type", 4);
        } else if (threadData.threadType == 0) {
            statisticItem.param("obj_type", 5);
        } else if (threadData.isVideoThreadType()) {
            statisticItem.param("obj_type", 6);
        }
        if (fo4Var.getThreadData().getAuthor() != null) {
            statisticItem.param("uid", fo4Var.getThreadData().getAuthor().getUserId());
        }
        if (threadData.getBaijiahaoData() != null) {
            statisticItem.param("obj_id", threadData.getBaijiahaoData().oriUgcNid);
        } else {
            statisticItem.param("obj_id", threadData.getTid());
        }
        statisticItem.param("obj_locate", i);
        TiebaStatic.log(statisticItem);
    }

    public static void b(fo4 fo4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, fo4Var) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_DYNAMIC_CARD_SHOW);
            ThreadData threadData = fo4Var.getThreadData();
            if (threadData.isBJHArticleThreadType()) {
                statisticItem.param("obj_type", 1);
            } else if (threadData.isBJHVideoThreadType()) {
                statisticItem.param("obj_type", 2);
            } else if (threadData.isBJHNormalThreadType()) {
                statisticItem.param("obj_type", 3);
            } else if (threadData.isBJHVideoDynamicThreadType()) {
                statisticItem.param("obj_type", 4);
            } else if (threadData.threadType == 0) {
                statisticItem.param("obj_type", 5);
            } else if (threadData.isVideoThreadType()) {
                statisticItem.param("obj_type", 6);
            }
            if (threadData.getBaijiahaoData() != null) {
                statisticItem.param("obj_id", threadData.getBaijiahaoData().oriUgcNid);
            } else {
                statisticItem.param("obj_id", threadData.getTid());
            }
            statisticItem.param("uid", threadData.getAuthor().getUserId());
            TiebaStatic.log(statisticItem);
        }
    }
}
