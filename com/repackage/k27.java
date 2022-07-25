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
public class k27 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(ny5 ny5Var, StatisticItem statisticItem) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65536, null, ny5Var, statisticItem) == null) || ny5Var == null || ny5Var.getThreadData() == null || statisticItem == null) {
            return;
        }
        if (ny5Var.getThreadData().getBaijiahaoData() != null) {
            BaijiahaoData baijiahaoData = ny5Var.getThreadData().getBaijiahaoData();
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

    public static void c(on4 on4Var, Context context, int i, boolean z, Rect rect) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{on4Var, context, Integer.valueOf(i), Boolean.valueOf(z), rect}) == null) || on4Var == null || on4Var.getThreadData() == null || context == null) {
            return;
        }
        ThreadData threadData = on4Var.getThreadData();
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(context).createFromThreadCfg(threadData, null, "video_tab", 18003, true, false, false);
        createFromThreadCfg.setForumId(String.valueOf(threadData.getFid()));
        createFromThreadCfg.setFrom("from_video_tab");
        createFromThreadCfg.setForumName(threadData.getForum_name());
        createFromThreadCfg.setStartFrom(i);
        createFromThreadCfg.setVideoOriginArea(rect);
        if (on4Var.getPbInputLocate() != null) {
            createFromThreadCfg.addLocateParam(on4Var.getPbInputLocate());
        }
        if (TbSingleton.getInstance().isPbPreloadSwitchOn() && b(threadData)) {
            createFromThreadCfg.setNeedPreLoad(true);
            dd6.update(threadData);
        }
        createFromThreadCfg.setVideo_source("video_tab");
        createFromThreadCfg.setJumpGodReply(z);
        ux5.a(threadData.getTid());
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
    }

    public static void d(ny5 ny5Var) {
        StatisticItem u;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, ny5Var) == null) || ny5Var == null || (u = ny5Var.u("c13583", true)) == null) {
            return;
        }
        a(ny5Var, u);
        TiebaStatic.log(u);
    }

    public static void e(ny5 ny5Var) {
        StatisticItem u;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, ny5Var) == null) || ny5Var == null || (u = ny5Var.u("c13584", true)) == null) {
            return;
        }
        a(ny5Var, u);
        u.param(TiebaStatic.Params.OBJ_FLOOR, ny5Var.position + 1);
        TiebaStatic.log(u);
    }

    public static void f(ny5 ny5Var) {
        StatisticItem u;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, null, ny5Var) == null) || ny5Var == null || (u = ny5Var.u("c13585", true)) == null) {
            return;
        }
        a(ny5Var, u);
        TiebaStatic.log(u);
    }

    public static void g(ny5 ny5Var) {
        StatisticItem u;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65542, null, ny5Var) == null) || ny5Var == null || (u = ny5Var.u("c13586", true)) == null) {
            return;
        }
        a(ny5Var, u);
        TiebaStatic.log(u);
    }

    public static void h(ny5 ny5Var) {
        StatisticItem u;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, null, ny5Var) == null) || ny5Var == null || (u = ny5Var.u("c13587", true)) == null) {
            return;
        }
        a(ny5Var, u);
        TiebaStatic.log(u);
    }
}
