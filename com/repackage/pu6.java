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
public class pu6 {
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

    public static void b(ym4 ym4Var, Context context, int i, boolean z, Rect rect) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{ym4Var, context, Integer.valueOf(i), Boolean.valueOf(z), rect}) == null) || ym4Var == null || ym4Var.getThreadData() == null || context == null) {
            return;
        }
        ThreadData threadData = ym4Var.getThreadData();
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(context).createFromThreadCfg(threadData, null, ImageViewerConfig.FROM_GAME_VIDEO, 18003, true, false, false);
        createFromThreadCfg.setForumId(String.valueOf(threadData.getFid()));
        createFromThreadCfg.setFrom("from_game_video");
        createFromThreadCfg.setForumName(threadData.getForum_name());
        createFromThreadCfg.setStartFrom(i);
        createFromThreadCfg.setVideoOriginArea(rect);
        if (ym4Var.getPbInputLocate() != null) {
            createFromThreadCfg.addLocateParam(ym4Var.getPbInputLocate());
        }
        if (TbSingleton.getInstance().isPbPreloadSwitchOn() && a(threadData)) {
            createFromThreadCfg.setNeedPreLoad(true);
            gc6.update(threadData);
        }
        createFromThreadCfg.setVideo_source(ImageViewerConfig.FROM_GAME_VIDEO);
        createFromThreadCfg.setJumpGodReply(z);
        xw5.a(threadData.getTid());
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
    }

    public static void c(qx5 qx5Var, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65538, null, qx5Var, i) == null) || qx5Var == null) {
            return;
        }
        int i2 = 1;
        StatisticItem w = qx5Var.w("c13488", true);
        if (w != null) {
            if (qx5Var.getThreadData() != null) {
                ThreadData threadData = qx5Var.getThreadData();
                if (threadData.getTopAgreePost() == null || (threadData.getTopAgreePost().Q() == null && threadData.getTopAgreePost().c0() == null)) {
                    i2 = 0;
                }
                w.param("obj_name", i2);
                if (threadData.getAuthor() != null) {
                    w.param(TiebaStatic.Params.AB_TYPE, threadData.getAuthor().hadConcerned() ? 1 : 0);
                }
            }
            w.param("obj_type", i);
            TiebaStatic.log(w);
        }
    }

    public static void d(qx5 qx5Var, int i) {
        StatisticItem w;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65539, null, qx5Var, i) == null) || qx5Var == null || qx5Var.getThreadData() == null || !zx5.R(qx5Var.a) || (w = qx5Var.w("c13494", true)) == null) {
            return;
        }
        w.param("obj_type", i);
        TbSingleton.getInstance().setCurrentClickTime(System.currentTimeMillis());
        TiebaStatic.log(w);
    }

    public static void e(qx5 qx5Var, int i) {
        StatisticItem w;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, qx5Var, i) == null) || qx5Var == null || !zx5.R(qx5Var.a) || (w = qx5Var.w("c13495", true)) == null) {
            return;
        }
        w.param("obj_type", i);
        TiebaStatic.log(w);
    }

    public static void f(qx5 qx5Var, int i) {
        StatisticItem w;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65541, null, qx5Var, i) == null) || qx5Var == null || qx5Var.getThreadData() == null || (w = qx5Var.w("c13496", true)) == null) {
            return;
        }
        w.param("obj_type", i);
        TiebaStatic.log(w);
    }
}
