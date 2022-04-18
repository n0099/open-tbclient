package com.repackage;

import android.content.Context;
import android.graphics.Rect;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class i37 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(xx5 xx5Var, StatisticItem statisticItem) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65536, null, xx5Var, statisticItem) == null) || xx5Var == null || xx5Var.getThreadData() == null || statisticItem == null) {
            return;
        }
        if (xx5Var.getThreadData().getBaijiahaoData() != null) {
            BaijiahaoData baijiahaoData = xx5Var.getThreadData().getBaijiahaoData();
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 3);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, baijiahaoData.oriUgcNid);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM6, baijiahaoData.oriUgcVid);
            return;
        }
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 1);
    }

    public static boolean b(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, threadData)) == null) {
            if (threadData == null || threadData.isShareThread) {
                return false;
            }
            int i = threadData.threadType;
            return i == 0 || i == 11 || i == 40 || threadData.isUgcThreadType();
        }
        return invokeL.booleanValue;
    }

    public static void c(pn4 pn4Var, Context context, int i, boolean z, Rect rect) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{pn4Var, context, Integer.valueOf(i), Boolean.valueOf(z), rect}) == null) || pn4Var == null || pn4Var.getThreadData() == null || context == null) {
            return;
        }
        ThreadData threadData = pn4Var.getThreadData();
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(context).createFromThreadCfg(threadData, null, "video_tab", 18003, true, false, false);
        createFromThreadCfg.setForumId(String.valueOf(threadData.getFid()));
        createFromThreadCfg.setFrom("from_video_tab");
        createFromThreadCfg.setForumName(threadData.getForum_name());
        createFromThreadCfg.setStartFrom(i);
        createFromThreadCfg.setVideoOriginArea(rect);
        if (pn4Var.getPbInputLocate() != null) {
            createFromThreadCfg.addLocateParam(pn4Var.getPbInputLocate());
        }
        if (TbSingleton.getInstance().isPbPreloadSwitchOn() && b(threadData)) {
            createFromThreadCfg.setNeedPreLoad(true);
            ld6.update(threadData);
        }
        createFromThreadCfg.setVideo_source("video_tab");
        createFromThreadCfg.setJumpGodReply(z);
        ex5.a(threadData.getTid());
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
    }

    public static void d(xx5 xx5Var) {
        StatisticItem y;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, xx5Var) == null) || xx5Var == null || (y = xx5Var.y("c13583", true)) == null) {
            return;
        }
        a(xx5Var, y);
        TiebaStatic.log(y);
    }

    public static void e(xx5 xx5Var) {
        StatisticItem y;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, xx5Var) == null) || xx5Var == null || (y = xx5Var.y("c13584", true)) == null) {
            return;
        }
        a(xx5Var, y);
        y.param(TiebaStatic.Params.OBJ_FLOOR, xx5Var.position + 1);
        TiebaStatic.log(y);
    }

    public static void f(xx5 xx5Var) {
        StatisticItem y;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, null, xx5Var) == null) || xx5Var == null || (y = xx5Var.y("c13585", true)) == null) {
            return;
        }
        a(xx5Var, y);
        TiebaStatic.log(y);
    }

    public static void g(xx5 xx5Var) {
        StatisticItem y;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65542, null, xx5Var) == null) || xx5Var == null || (y = xx5Var.y("c13586", true)) == null) {
            return;
        }
        a(xx5Var, y);
        TiebaStatic.log(y);
    }

    public static void h(xx5 xx5Var) {
        StatisticItem y;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, null, xx5Var) == null) || xx5Var == null || (y = xx5Var.y("c13587", true)) == null) {
            return;
        }
        a(xx5Var, y);
        TiebaStatic.log(y);
    }
}
