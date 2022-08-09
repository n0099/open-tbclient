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
public class e47 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(f06 f06Var, StatisticItem statisticItem) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65536, null, f06Var, statisticItem) == null) || f06Var == null || f06Var.getThreadData() == null || statisticItem == null) {
            return;
        }
        if (f06Var.getThreadData().getBaijiahaoData() != null) {
            BaijiahaoData baijiahaoData = f06Var.getThreadData().getBaijiahaoData();
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

    public static void c(fo4 fo4Var, Context context, int i, boolean z, Rect rect) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{fo4Var, context, Integer.valueOf(i), Boolean.valueOf(z), rect}) == null) || fo4Var == null || fo4Var.getThreadData() == null || context == null) {
            return;
        }
        ThreadData threadData = fo4Var.getThreadData();
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(context).createFromThreadCfg(threadData, null, "video_tab", 18003, true, false, false);
        createFromThreadCfg.setForumId(String.valueOf(threadData.getFid()));
        createFromThreadCfg.setFrom("from_video_tab");
        createFromThreadCfg.setForumName(threadData.getForum_name());
        createFromThreadCfg.setStartFrom(i);
        createFromThreadCfg.setVideoOriginArea(rect);
        if (fo4Var.getPbInputLocate() != null) {
            createFromThreadCfg.addLocateParam(fo4Var.getPbInputLocate());
        }
        if (TbSingleton.getInstance().isPbPreloadSwitchOn() && b(threadData)) {
            createFromThreadCfg.setNeedPreLoad(true);
            ve6.update(threadData);
        }
        createFromThreadCfg.setVideo_source("video_tab");
        createFromThreadCfg.setJumpGodReply(z);
        mz5.a(threadData.getTid());
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
    }

    public static void d(f06 f06Var) {
        StatisticItem w;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, f06Var) == null) || f06Var == null || (w = f06Var.w("c13583", true)) == null) {
            return;
        }
        a(f06Var, w);
        TiebaStatic.log(w);
    }

    public static void e(f06 f06Var) {
        StatisticItem w;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, f06Var) == null) || f06Var == null || (w = f06Var.w("c13584", true)) == null) {
            return;
        }
        a(f06Var, w);
        w.param(TiebaStatic.Params.OBJ_FLOOR, f06Var.position + 1);
        TiebaStatic.log(w);
    }

    public static void f(f06 f06Var) {
        StatisticItem w;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, null, f06Var) == null) || f06Var == null || (w = f06Var.w("c13585", true)) == null) {
            return;
        }
        a(f06Var, w);
        TiebaStatic.log(w);
    }

    public static void g(f06 f06Var) {
        StatisticItem w;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65542, null, f06Var) == null) || f06Var == null || (w = f06Var.w("c13586", true)) == null) {
            return;
        }
        a(f06Var, w);
        TiebaStatic.log(w);
    }

    public static void h(f06 f06Var) {
        StatisticItem w;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, null, f06Var) == null) || f06Var == null || (w = f06Var.w("c13587", true)) == null) {
            return;
        }
        a(f06Var, w);
        TiebaStatic.log(w);
    }
}
