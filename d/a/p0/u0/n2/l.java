package d.a.p0.u0.n2;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.o0.r.q.b2;
import d.a.o0.r.q.z1;
import d.a.p0.h3.j0.a;
import d.a.p0.u0.m1.d.e0;
import d.a.p0.u0.q;
import d.a.p0.w2.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes8.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(d.a.p0.u0.j2.b bVar, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65536, null, bVar, str) == null) || TextUtils.isEmpty(str) || bVar == null || TextUtils.isEmpty(bVar.f62958c)) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c11942");
        statisticItem.param("fid", bVar.f62958c);
        statisticItem.param("obj_name", str);
        TiebaStatic.log(statisticItem);
    }

    public static void b(q qVar, FrsViewData frsViewData, String str, boolean z, b2 b2Var) {
        d.a.o0.s.c.d adAdSense;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{qVar, frsViewData, str, Boolean.valueOf(z), b2Var}) == null) || qVar == null || frsViewData == null || TextUtils.isEmpty(str) || (adAdSense = TbadkCoreApplication.getInst().getAdAdSense()) == null || !adAdSense.h()) {
            return;
        }
        e0 W = qVar == null ? null : qVar.W();
        List<d.a.c.k.e.n> f2 = W != null ? W.f() : null;
        List<d.a.c.k.e.n> singletonList = b2Var != null ? Collections.singletonList(b2Var) : f2;
        if (singletonList == null || f2 == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        if (z) {
            for (d.a.c.k.e.n nVar : f2) {
                i2++;
                for (d.a.c.k.e.n nVar2 : singletonList) {
                    if (nVar == nVar2 && (nVar2 instanceof b2)) {
                        a.c cVar = new a.c();
                        cVar.f58049a = ((b2) nVar2).n1();
                        cVar.f58051c = i2;
                        arrayList.add(cVar);
                    }
                }
            }
        } else {
            for (d.a.c.k.e.n nVar3 : singletonList) {
                if (nVar3 instanceof b2) {
                    b2 b2Var2 = (b2) nVar3;
                    i2++;
                    if (b2Var2.y0 == 1 && !TextUtils.isEmpty(b2Var2.n1())) {
                        b2Var2.y0 = 2;
                        a.c cVar2 = new a.c();
                        cVar2.f58049a = b2Var2.n1();
                        cVar2.f58051c = i2;
                        arrayList.add(cVar2);
                    }
                }
            }
        }
        if (arrayList.size() > 0) {
            x.u(z, frsViewData.getForum().getFirst_class(), frsViewData.getForum().getSecond_class(), str, arrayList, adAdSense.j());
        }
    }

    public static void c(z1 z1Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, z1Var) == null) || z1Var == null) {
            return;
        }
        String d2 = z1Var.d();
        if (StringUtils.isNull(d2)) {
            d2 = z1Var.f();
        }
        String str = d2;
        String b2 = z1Var.b();
        String c2 = z1Var.c();
        String g2 = z1Var.g();
        d.a.p0.h3.j0.a.c("frs", "CLICK", b2, c2, g2, "tieba.baidu.com/p/" + z1Var.g(), str);
    }

    public static void d(FrsFragment frsFragment, FrsViewData frsViewData, b2 b2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65539, null, frsFragment, frsViewData, b2Var) == null) || b2Var == null || frsViewData == null) {
            return;
        }
        FrsModelController d0 = frsFragment.d0();
        q B0 = frsFragment.B0();
        if (B0 == null || d0 == null) {
            return;
        }
        if (b2Var.H() != null && b2Var.H().getGodInfo() != null) {
            TiebaStatic.log(new StatisticItem("c10806").param("obj_locate", 3).param("tid", b2Var.c0()));
        }
        if (frsViewData != null && frsViewData.getForum() != null) {
            d.a.p0.u0.j2.b bVar = new d.a.p0.u0.j2.b();
            bVar.f62956a = frsViewData.needLog == 1;
            bVar.f62958c = frsViewData.getForum().getId();
            bVar.f62957b = d0.R();
            d.a.p0.u0.j2.b bVar2 = d.a.p0.u0.j2.d.h0;
            if (bVar2 != null) {
                bVar.f62959d = bVar2.f62959d;
                bVar.f62960e = bVar2.f62960e;
            }
            d.a.p0.u0.j2.c.j().g(bVar, b2Var, 1);
            d.a.p0.u0.j2.a.c(b2Var, 1, frsFragment.getUniqueId(), bVar, frsFragment.getTbPageTag());
        }
        b(B0, frsViewData, frsFragment.h(), true, b2Var);
    }

    public static void e(String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i2, i3) == null) {
            StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SCHEME_JUMP_CALL_NATIVE).param("obj_locate", i2).param("obj_type", i3).param("obj_name", TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_PARAM3, 1);
            d.a.o0.a.x.a(param, str);
            TiebaStatic.log(param);
        }
    }

    public static void f(FrsModelController frsModelController, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(AdIconUtil.AD_TEXT_ID, null, frsModelController, j) == null) || frsModelController == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        TiebaStatic.page(TiebaStatic.OpKey.OP_FRS_ENTER, currentTimeMillis - j, frsModelController.f0() - j, frsModelController.h0(), frsModelController.g0(), currentTimeMillis - frsModelController.e0());
    }
}
