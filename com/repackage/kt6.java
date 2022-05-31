package com.repackage;

import android.content.Context;
import android.graphics.Rect;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class kt6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, threadData)) == null) {
            if (threadData == null || threadData.isShareThread) {
                return false;
            }
            int i = threadData.threadType;
            return i == 0 || i == 11 || i == 40 || threadData.isUgcThreadType();
        }
        return invokeL.booleanValue;
    }

    public static void b(om4 om4Var, Context context, int i, boolean z, Rect rect) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{om4Var, context, Integer.valueOf(i), Boolean.valueOf(z), rect}) == null) || om4Var == null || om4Var.getThreadData() == null || context == null) {
            return;
        }
        ThreadData threadData = om4Var.getThreadData();
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(context).createFromThreadCfg(threadData, null, ImageViewerConfig.FROM_GAME_VIDEO, 18003, true, false, false);
        createFromThreadCfg.setForumId(String.valueOf(threadData.getFid()));
        createFromThreadCfg.setFrom("from_game_video");
        createFromThreadCfg.setForumName(threadData.getForum_name());
        createFromThreadCfg.setStartFrom(i);
        createFromThreadCfg.setVideoOriginArea(rect);
        if (om4Var.getPbInputLocate() != null) {
            createFromThreadCfg.addLocateParam(om4Var.getPbInputLocate());
        }
        if (TbSingleton.getInstance().isPbPreloadSwitchOn() && a(threadData)) {
            createFromThreadCfg.setNeedPreLoad(true);
            gb6.update(threadData);
        }
        createFromThreadCfg.setVideo_source(ImageViewerConfig.FROM_GAME_VIDEO);
        createFromThreadCfg.setJumpGodReply(z);
        yv5.a(threadData.getTid());
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
    }

    public static void c(rw5 rw5Var, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65538, null, rw5Var, i) == null) || rw5Var == null) {
            return;
        }
        int i2 = 1;
        StatisticItem y = rw5Var.y("c13488", true);
        if (y != null) {
            if (rw5Var.getThreadData() != null) {
                ThreadData threadData = rw5Var.getThreadData();
                if (threadData.getTopAgreePost() == null || (threadData.getTopAgreePost().P() == null && threadData.getTopAgreePost().b0() == null)) {
                    i2 = 0;
                }
                y.param("obj_name", i2);
                if (threadData.getAuthor() != null) {
                    y.param(TiebaStatic.Params.AB_TYPE, threadData.getAuthor().hadConcerned() ? 1 : 0);
                }
            }
            y.param("obj_type", i);
            TiebaStatic.log(y);
        }
    }

    public static void d(rw5 rw5Var, int i) {
        StatisticItem y;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65539, null, rw5Var, i) == null) || rw5Var == null || rw5Var.getThreadData() == null || !ax5.R(rw5Var.a) || (y = rw5Var.y("c13494", true)) == null) {
            return;
        }
        y.param("obj_type", i);
        TbSingleton.getInstance().setCurrentClickTime(System.currentTimeMillis());
        TiebaStatic.log(y);
    }

    public static void e(rw5 rw5Var, int i) {
        StatisticItem y;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, rw5Var, i) == null) || rw5Var == null || !ax5.R(rw5Var.a) || (y = rw5Var.y("c13495", true)) == null) {
            return;
        }
        y.param("obj_type", i);
        TiebaStatic.log(y);
    }

    public static void f(rw5 rw5Var, int i) {
        StatisticItem y;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65541, null, rw5Var, i) == null) || rw5Var == null || rw5Var.getThreadData() == null || (y = rw5Var.y("c13496", true)) == null) {
            return;
        }
        y.param("obj_type", i);
        TiebaStatic.log(y);
    }
}
