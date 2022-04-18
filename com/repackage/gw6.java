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
public class gw6 {
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

    public static void b(pn4 pn4Var, Context context, int i, boolean z, Rect rect) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{pn4Var, context, Integer.valueOf(i), Boolean.valueOf(z), rect}) == null) || pn4Var == null || pn4Var.getThreadData() == null || context == null) {
            return;
        }
        ThreadData threadData = pn4Var.getThreadData();
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(context).createFromThreadCfg(threadData, null, ImageViewerConfig.FROM_GAME_VIDEO, 18003, true, false, false);
        createFromThreadCfg.setForumId(String.valueOf(threadData.getFid()));
        createFromThreadCfg.setFrom("from_game_video");
        createFromThreadCfg.setForumName(threadData.getForum_name());
        createFromThreadCfg.setStartFrom(i);
        createFromThreadCfg.setVideoOriginArea(rect);
        if (pn4Var.getPbInputLocate() != null) {
            createFromThreadCfg.addLocateParam(pn4Var.getPbInputLocate());
        }
        if (TbSingleton.getInstance().isPbPreloadSwitchOn() && a(threadData)) {
            createFromThreadCfg.setNeedPreLoad(true);
            ld6.update(threadData);
        }
        createFromThreadCfg.setVideo_source(ImageViewerConfig.FROM_GAME_VIDEO);
        createFromThreadCfg.setJumpGodReply(z);
        ex5.a(threadData.getTid());
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
    }

    public static void c(xx5 xx5Var, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65538, null, xx5Var, i) == null) || xx5Var == null) {
            return;
        }
        int i2 = 1;
        StatisticItem y = xx5Var.y("c13488", true);
        if (y != null) {
            if (xx5Var.getThreadData() != null) {
                ThreadData threadData = xx5Var.getThreadData();
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

    public static void d(xx5 xx5Var, int i) {
        StatisticItem y;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65539, null, xx5Var, i) == null) || xx5Var == null || xx5Var.getThreadData() == null || !gy5.R(xx5Var.a) || (y = xx5Var.y("c13494", true)) == null) {
            return;
        }
        y.param("obj_type", i);
        TbSingleton.getInstance().setCurrentClickTime(System.currentTimeMillis());
        TiebaStatic.log(y);
    }

    public static void e(xx5 xx5Var, int i) {
        StatisticItem y;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, xx5Var, i) == null) || xx5Var == null || !gy5.R(xx5Var.a) || (y = xx5Var.y("c13495", true)) == null) {
            return;
        }
        y.param("obj_type", i);
        TiebaStatic.log(y);
    }

    public static void f(xx5 xx5Var, int i) {
        StatisticItem y;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65541, null, xx5Var, i) == null) || xx5Var == null || xx5Var.getThreadData() == null || (y = xx5Var.y("c13496", true)) == null) {
            return;
        }
        y.param("obj_type", i);
        TiebaStatic.log(y);
    }
}
