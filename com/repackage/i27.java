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
public class i27 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(yx5 yx5Var, StatisticItem statisticItem) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65536, null, yx5Var, statisticItem) == null) || yx5Var == null || yx5Var.getThreadData() == null || statisticItem == null) {
            return;
        }
        if (yx5Var.getThreadData().getBaijiahaoData() != null) {
            BaijiahaoData baijiahaoData = yx5Var.getThreadData().getBaijiahaoData();
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

    public static void c(zn4 zn4Var, Context context, int i, boolean z, Rect rect) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{zn4Var, context, Integer.valueOf(i), Boolean.valueOf(z), rect}) == null) || zn4Var == null || zn4Var.getThreadData() == null || context == null) {
            return;
        }
        ThreadData threadData = zn4Var.getThreadData();
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(context).createFromThreadCfg(threadData, null, "video_tab", 18003, true, false, false);
        createFromThreadCfg.setForumId(String.valueOf(threadData.getFid()));
        createFromThreadCfg.setFrom("from_video_tab");
        createFromThreadCfg.setForumName(threadData.getForum_name());
        createFromThreadCfg.setStartFrom(i);
        createFromThreadCfg.setVideoOriginArea(rect);
        if (zn4Var.getPbInputLocate() != null) {
            createFromThreadCfg.addLocateParam(zn4Var.getPbInputLocate());
        }
        if (TbSingleton.getInstance().isPbPreloadSwitchOn() && b(threadData)) {
            createFromThreadCfg.setNeedPreLoad(true);
            qc6.update(threadData);
        }
        createFromThreadCfg.setVideo_source("video_tab");
        createFromThreadCfg.setJumpGodReply(z);
        fx5.a(threadData.getTid());
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
    }

    public static void d(yx5 yx5Var) {
        StatisticItem y;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, yx5Var) == null) || yx5Var == null || (y = yx5Var.y("c13583", true)) == null) {
            return;
        }
        a(yx5Var, y);
        TiebaStatic.log(y);
    }

    public static void e(yx5 yx5Var) {
        StatisticItem y;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, yx5Var) == null) || yx5Var == null || (y = yx5Var.y("c13584", true)) == null) {
            return;
        }
        a(yx5Var, y);
        y.param(TiebaStatic.Params.OBJ_FLOOR, yx5Var.position + 1);
        TiebaStatic.log(y);
    }

    public static void f(yx5 yx5Var) {
        StatisticItem y;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, null, yx5Var) == null) || yx5Var == null || (y = yx5Var.y("c13585", true)) == null) {
            return;
        }
        a(yx5Var, y);
        TiebaStatic.log(y);
    }

    public static void g(yx5 yx5Var) {
        StatisticItem y;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65542, null, yx5Var) == null) || yx5Var == null || (y = yx5Var.y("c13586", true)) == null) {
            return;
        }
        a(yx5Var, y);
        TiebaStatic.log(y);
    }

    public static void h(yx5 yx5Var) {
        StatisticItem y;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, null, yx5Var) == null) || yx5Var == null || (y = yx5Var.y("c13587", true)) == null) {
            return;
        }
        a(yx5Var, y);
        TiebaStatic.log(y);
    }
}
