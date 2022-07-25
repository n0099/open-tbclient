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
public class fv6 {
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

    public static void b(on4 on4Var, Context context, int i, boolean z, Rect rect) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{on4Var, context, Integer.valueOf(i), Boolean.valueOf(z), rect}) == null) || on4Var == null || on4Var.getThreadData() == null || context == null) {
            return;
        }
        ThreadData threadData = on4Var.getThreadData();
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(context).createFromThreadCfg(threadData, null, ImageViewerConfig.FROM_GAME_VIDEO, 18003, true, false, false);
        createFromThreadCfg.setForumId(String.valueOf(threadData.getFid()));
        createFromThreadCfg.setFrom("from_game_video");
        createFromThreadCfg.setForumName(threadData.getForum_name());
        createFromThreadCfg.setStartFrom(i);
        createFromThreadCfg.setVideoOriginArea(rect);
        if (on4Var.getPbInputLocate() != null) {
            createFromThreadCfg.addLocateParam(on4Var.getPbInputLocate());
        }
        if (TbSingleton.getInstance().isPbPreloadSwitchOn() && a(threadData)) {
            createFromThreadCfg.setNeedPreLoad(true);
            dd6.update(threadData);
        }
        createFromThreadCfg.setVideo_source(ImageViewerConfig.FROM_GAME_VIDEO);
        createFromThreadCfg.setJumpGodReply(z);
        ux5.a(threadData.getTid());
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
    }

    public static void c(ny5 ny5Var, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65538, null, ny5Var, i) == null) || ny5Var == null) {
            return;
        }
        int i2 = 1;
        StatisticItem u = ny5Var.u("c13488", true);
        if (u != null) {
            if (ny5Var.getThreadData() != null) {
                ThreadData threadData = ny5Var.getThreadData();
                if (threadData.getTopAgreePost() == null || (threadData.getTopAgreePost().Q() == null && threadData.getTopAgreePost().e0() == null)) {
                    i2 = 0;
                }
                u.param("obj_name", i2);
                if (threadData.getAuthor() != null) {
                    u.param(TiebaStatic.Params.AB_TYPE, threadData.getAuthor().hadConcerned() ? 1 : 0);
                }
            }
            u.param("obj_type", i);
            TiebaStatic.log(u);
        }
    }

    public static void d(ny5 ny5Var, int i) {
        StatisticItem u;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65539, null, ny5Var, i) == null) || ny5Var == null || ny5Var.getThreadData() == null || !wy5.R(ny5Var.a) || (u = ny5Var.u("c13494", true)) == null) {
            return;
        }
        u.param("obj_type", i);
        TbSingleton.getInstance().setCurrentClickTime(System.currentTimeMillis());
        TiebaStatic.log(u);
    }

    public static void e(ny5 ny5Var, int i) {
        StatisticItem u;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, ny5Var, i) == null) || ny5Var == null || !wy5.R(ny5Var.a) || (u = ny5Var.u("c13495", true)) == null) {
            return;
        }
        u.param("obj_type", i);
        TiebaStatic.log(u);
    }

    public static void f(ny5 ny5Var, int i) {
        StatisticItem u;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65541, null, ny5Var, i) == null) || ny5Var == null || ny5Var.getThreadData() == null || (u = ny5Var.u("c13496", true)) == null) {
            return;
        }
        u.param("obj_type", i);
        TiebaStatic.log(u);
    }
}
