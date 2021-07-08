package d.a.p0.e1.l.d;

import android.content.Context;
import android.graphics.Rect;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.o0.r.q.b2;
import d.a.p0.a0.e0.b;
import d.a.p0.a0.m;
import d.a.p0.u0.l;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(b bVar, StatisticItem statisticItem) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65536, null, bVar, statisticItem) == null) || bVar == null || bVar.getThreadData() == null || statisticItem == null) {
            return;
        }
        if (bVar.getThreadData().J() != null) {
            BaijiahaoData J = bVar.getThreadData().J();
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 3);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, J.oriUgcNid);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM6, J.oriUgcVid);
            return;
        }
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 1);
    }

    public static boolean b(b2 b2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, b2Var)) == null) {
            if (b2Var == null || b2Var.v1) {
                return false;
            }
            int i2 = b2Var.Z;
            return i2 == 0 || i2 == 11 || i2 == 40 || b2Var.p2();
        }
        return invokeL.booleanValue;
    }

    public static void c(d.a.o0.r.q.a aVar, Context context, int i2, boolean z, Rect rect) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{aVar, context, Integer.valueOf(i2), Boolean.valueOf(z), rect}) == null) || aVar == null || aVar.getThreadData() == null || context == null) {
            return;
        }
        b2 threadData = aVar.getThreadData();
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(context).createFromThreadCfg(threadData, null, "video_tab", 18003, true, false, false);
        createFromThreadCfg.setForumId(String.valueOf(threadData.Q()));
        createFromThreadCfg.setFrom(PbActivityConfig.KEY_FROM_VIDEO_TAB);
        createFromThreadCfg.setForumName(threadData.W());
        createFromThreadCfg.setStartFrom(i2);
        createFromThreadCfg.setVideoOriginArea(rect);
        if (aVar.getPbInputLocate() != null) {
            createFromThreadCfg.addLocateParam(aVar.getPbInputLocate());
        }
        if (TbSingleton.getInstance().isPbPreloadSwitchOn() && b(threadData)) {
            createFromThreadCfg.setNeedPreLoad(true);
            l.c(threadData);
        }
        createFromThreadCfg.setVideo_source("video_tab");
        createFromThreadCfg.setJumpGodReply(z);
        m.a(threadData.n1());
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
    }

    public static void d(b bVar) {
        StatisticItem w;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, bVar) == null) || bVar == null || (w = bVar.w("c13583", true)) == null) {
            return;
        }
        a(bVar, w);
        TiebaStatic.log(w);
    }

    public static void e(b bVar) {
        StatisticItem w;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bVar) == null) || bVar == null || (w = bVar.w("c13584", true)) == null) {
            return;
        }
        a(bVar, w);
        w.param(TiebaStatic.Params.OBJ_FLOOR, bVar.position + 1);
        TiebaStatic.log(w);
    }

    public static void f(b bVar) {
        StatisticItem w;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, bVar) == null) || bVar == null || (w = bVar.w("c13585", true)) == null) {
            return;
        }
        a(bVar, w);
        TiebaStatic.log(w);
    }

    public static void g(b bVar) {
        StatisticItem w;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, bVar) == null) || bVar == null || (w = bVar.w("c13586", true)) == null) {
            return;
        }
        a(bVar, w);
        TiebaStatic.log(w);
    }

    public static void h(b bVar) {
        StatisticItem w;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, null, bVar) == null) || bVar == null || (w = bVar.w("c13587", true)) == null) {
            return;
        }
        a(bVar, w);
        TiebaStatic.log(w);
    }
}
