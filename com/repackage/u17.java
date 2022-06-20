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
/* loaded from: classes7.dex */
public class u17 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(qx5 qx5Var, StatisticItem statisticItem) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65536, null, qx5Var, statisticItem) == null) || qx5Var == null || qx5Var.getThreadData() == null || statisticItem == null) {
            return;
        }
        if (qx5Var.getThreadData().getBaijiahaoData() != null) {
            BaijiahaoData baijiahaoData = qx5Var.getThreadData().getBaijiahaoData();
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

    public static void c(ym4 ym4Var, Context context, int i, boolean z, Rect rect) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{ym4Var, context, Integer.valueOf(i), Boolean.valueOf(z), rect}) == null) || ym4Var == null || ym4Var.getThreadData() == null || context == null) {
            return;
        }
        ThreadData threadData = ym4Var.getThreadData();
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(context).createFromThreadCfg(threadData, null, "video_tab", 18003, true, false, false);
        createFromThreadCfg.setForumId(String.valueOf(threadData.getFid()));
        createFromThreadCfg.setFrom("from_video_tab");
        createFromThreadCfg.setForumName(threadData.getForum_name());
        createFromThreadCfg.setStartFrom(i);
        createFromThreadCfg.setVideoOriginArea(rect);
        if (ym4Var.getPbInputLocate() != null) {
            createFromThreadCfg.addLocateParam(ym4Var.getPbInputLocate());
        }
        if (TbSingleton.getInstance().isPbPreloadSwitchOn() && b(threadData)) {
            createFromThreadCfg.setNeedPreLoad(true);
            gc6.update(threadData);
        }
        createFromThreadCfg.setVideo_source("video_tab");
        createFromThreadCfg.setJumpGodReply(z);
        xw5.a(threadData.getTid());
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
    }

    public static void d(qx5 qx5Var) {
        StatisticItem w;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, qx5Var) == null) || qx5Var == null || (w = qx5Var.w("c13583", true)) == null) {
            return;
        }
        a(qx5Var, w);
        TiebaStatic.log(w);
    }

    public static void e(qx5 qx5Var) {
        StatisticItem w;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, qx5Var) == null) || qx5Var == null || (w = qx5Var.w("c13584", true)) == null) {
            return;
        }
        a(qx5Var, w);
        w.param(TiebaStatic.Params.OBJ_FLOOR, qx5Var.position + 1);
        TiebaStatic.log(w);
    }

    public static void f(qx5 qx5Var) {
        StatisticItem w;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, null, qx5Var) == null) || qx5Var == null || (w = qx5Var.w("c13585", true)) == null) {
            return;
        }
        a(qx5Var, w);
        TiebaStatic.log(w);
    }

    public static void g(qx5 qx5Var) {
        StatisticItem w;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65542, null, qx5Var) == null) || qx5Var == null || (w = qx5Var.w("c13586", true)) == null) {
            return;
        }
        a(qx5Var, w);
        TiebaStatic.log(w);
    }

    public static void h(qx5 qx5Var) {
        StatisticItem w;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, null, qx5Var) == null) || qx5Var == null || (w = qx5Var.w("c13587", true)) == null) {
            return;
        }
        a(qx5Var, w);
        TiebaStatic.log(w);
    }
}
