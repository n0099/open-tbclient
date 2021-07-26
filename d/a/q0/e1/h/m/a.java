package d.a.q0.e1.h.m;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiePlusStatic;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.p0.s.q.b2;
import d.a.q0.e1.h.g;
import d.a.q0.g3.c;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Deprecated
    public static void a(b2 b2Var, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65536, null, b2Var, i2) == null) {
            b(b2Var, i2, 1);
        }
    }

    public static void b(b2 b2Var, int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(65537, null, b2Var, i2, i3) == null) && b2Var != null && b2Var.N2) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_HEATING_THREAD_CLICK);
            statisticItem.addParam("obj_locate", 1);
            if (b2Var.t2()) {
                statisticItem.addParam("obj_type", 3);
            } else if (b2Var.s2()) {
                statisticItem.addParam("obj_type", 2);
            } else {
                statisticItem.addParam("obj_type", 1);
            }
            statisticItem.addParam(TiePlusStatic.Params.CLI_LOCATE, i3);
            statisticItem.addParam("tid", b2Var.o1());
            statisticItem.addParam(TiebaStatic.Params.FID_1, b2Var.R());
            TiebaStatic.log(statisticItem);
            d.a.p0.d.a.a(d.a.p0.d.a.f52219e, d.a.p0.d.a.f52215a, b2Var.O2, b2Var.P2, b2Var.Q2, i2);
        }
    }

    public static void c(b2 b2Var, BdUniqueId bdUniqueId, int i2, int i3) {
        String str;
        boolean z;
        int i4;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLII(65538, null, b2Var, bdUniqueId, i2, i3) == null) || b2Var == null) {
            return;
        }
        if (b2Var.m2) {
            str = b2Var.n2;
            z = true;
            i4 = 20;
        } else {
            str = null;
            z = false;
            i4 = 0;
        }
        StatisticItem e2 = d.a.q0.g3.a.e(b2Var, "a002", "common_click", i3, i2, z, str, null, i4);
        if (e2 == null) {
            return;
        }
        if (b2Var.S1()) {
            e2.param(TiebaStatic.Params.GUA_TYPE, 1);
        } else if (b2Var.o0() != null) {
            e2.param(TiebaStatic.Params.GUA_TYPE, 2);
            int indexOf = e2.getParams().indexOf("obj_locate");
            if (indexOf >= 0) {
                int i5 = indexOf + 1;
                e2.getParams().remove(i5);
                e2.getParams().add(i5, 16);
            } else {
                e2.param("obj_locate", 16);
            }
        } else {
            e2.param(TiebaStatic.Params.GUA_TYPE, 0);
        }
        if (b2Var.m2) {
            e2.delete("thread_type");
            e2.param("thread_type", b2Var.k1());
        }
        c.g().c(bdUniqueId, e2);
        d(b2Var, i3);
    }

    public static void d(b2 b2Var, int i2) {
        StatisticItem n;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65539, null, b2Var, i2) == null) {
            if (i2 != 2) {
                n = i2 != 9 ? null : d.a.q0.g3.a.n("c13693", b2Var, 1);
            } else {
                n = d.a.q0.g3.a.n("c13692", b2Var, 1);
            }
            TiebaStatic.log(n);
        }
    }

    public static void e(b2 b2Var, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, b2Var, i2) == null) && b2Var != null && b2Var.N2) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_HEATING_THREAD_EXPOSE);
            statisticItem.addParam("obj_locate", 1);
            if (b2Var.t2()) {
                statisticItem.addParam("obj_type", 3);
            } else if (b2Var.s2()) {
                statisticItem.addParam("obj_type", 2);
            } else {
                statisticItem.addParam("obj_type", 1);
            }
            statisticItem.addParam("tid", b2Var.o1());
            statisticItem.addParam(TiebaStatic.Params.FID_1, b2Var.R());
            TiebaStatic.log(statisticItem);
            d.a.p0.d.a.a(d.a.p0.d.a.f52218d, d.a.p0.d.a.f52215a, b2Var.O2, b2Var.P2, b2Var.Q2, i2);
        }
    }

    public static void f(b2 b2Var, BdUniqueId bdUniqueId, int i2) {
        String str;
        boolean z;
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(AdIconUtil.AD_TEXT_ID, null, b2Var, bdUniqueId, i2) == null) || b2Var == null) {
            return;
        }
        if (b2Var.m2) {
            str = b2Var.n2;
            z = true;
            i3 = 20;
        } else {
            str = null;
            z = false;
            i3 = 0;
        }
        String c2 = d.a.q0.g3.a.c(b2Var.o1(), str, "", b2Var.J());
        StatisticItem g2 = d.a.q0.g3.a.g(b2Var, "a002", "common_exp", i2, z, str, null, i3);
        if (g2 == null) {
            return;
        }
        if (b2Var.m2) {
            g2.delete("thread_type");
            g2.param("thread_type", b2Var.k1());
        }
        if (b2Var.S1()) {
            g2.param(TiebaStatic.Params.GUA_TYPE, 1);
        } else if (b2Var.o0() != null) {
            g2.param(TiebaStatic.Params.GUA_TYPE, 2);
        } else {
            g2.param(TiebaStatic.Params.GUA_TYPE, 0);
        }
        c.g().d(bdUniqueId, c2, g2);
        if (g.d()) {
            g.c(c2);
            if (g.b() >= 10) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921482));
                g.e(false);
            }
        }
    }
}
