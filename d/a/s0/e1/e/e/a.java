package d.a.s0.e1.e.e;

import android.content.Context;
import android.graphics.Rect;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.r0.r.q.b2;
import d.a.s0.a0.e0.b;
import d.a.s0.a0.m;
import d.a.s0.u0.l;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(b2 b2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, b2Var)) == null) {
            if (b2Var == null || b2Var.v1) {
                return false;
            }
            int i2 = b2Var.Z;
            return i2 == 0 || i2 == 11 || i2 == 40 || b2Var.p2();
        }
        return invokeL.booleanValue;
    }

    public static void b(d.a.r0.r.q.a aVar, Context context, int i2, boolean z, Rect rect) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{aVar, context, Integer.valueOf(i2), Boolean.valueOf(z), rect}) == null) || aVar == null || aVar.getThreadData() == null || context == null) {
            return;
        }
        b2 threadData = aVar.getThreadData();
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(context).createFromThreadCfg(threadData, null, ImageViewerConfig.FROM_GAME_VIDEO, 18003, true, false, false);
        createFromThreadCfg.setForumId(String.valueOf(threadData.Q()));
        createFromThreadCfg.setFrom(PbActivityConfig.KEY_FROM_GAME_VIDEO);
        createFromThreadCfg.setForumName(threadData.W());
        createFromThreadCfg.setStartFrom(i2);
        createFromThreadCfg.setVideoOriginArea(rect);
        if (aVar.getPbInputLocate() != null) {
            createFromThreadCfg.addLocateParam(aVar.getPbInputLocate());
        }
        if (TbSingleton.getInstance().isPbPreloadSwitchOn() && a(threadData)) {
            createFromThreadCfg.setNeedPreLoad(true);
            l.c(threadData);
        }
        createFromThreadCfg.setVideo_source(ImageViewerConfig.FROM_GAME_VIDEO);
        createFromThreadCfg.setJumpGodReply(z);
        m.a(threadData.n1());
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
    }

    public static void c(b bVar, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65538, null, bVar, i2) == null) || bVar == null) {
            return;
        }
        int i3 = 1;
        StatisticItem w = bVar.w("c13488", true);
        if (w != null) {
            if (bVar.getThreadData() != null) {
                b2 threadData = bVar.getThreadData();
                if (threadData.p1() == null || (threadData.p1().K() == null && threadData.p1().V() == null)) {
                    i3 = 0;
                }
                w.param("obj_name", i3);
                if (threadData.H() != null) {
                    w.param(TiebaStatic.Params.AB_TYPE, threadData.H().hadConcerned() ? 1 : 0);
                }
            }
            w.param("obj_type", i2);
            TiebaStatic.log(w);
        }
    }

    public static void d(b bVar, int i2) {
        StatisticItem w;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65539, null, bVar, i2) == null) || bVar == null || bVar.getThreadData() == null || !d.a.s0.a0.e0.l.R(bVar.f57050e) || (w = bVar.w("c13494", true)) == null) {
            return;
        }
        w.param("obj_type", i2);
        TiebaStatic.log(w);
    }

    public static void e(b bVar, int i2) {
        StatisticItem w;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65540, null, bVar, i2) == null) || bVar == null || !d.a.s0.a0.e0.l.R(bVar.f57050e) || (w = bVar.w("c13495", true)) == null) {
            return;
        }
        w.param("obj_type", i2);
        TiebaStatic.log(w);
    }

    public static void f(b bVar, int i2) {
        StatisticItem w;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(AdIconUtil.AD_TEXT_ID, null, bVar, i2) == null) || bVar == null || bVar.getThreadData() == null || (w = bVar.w("c13496", true)) == null) {
            return;
        }
        w.param("obj_type", i2);
        TiebaStatic.log(w);
    }
}
