package com.repackage;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.repackage.hl8;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes7.dex */
public class rq6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(gp6 gp6Var, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65536, null, gp6Var, str) == null) || TextUtils.isEmpty(str) || gp6Var == null || TextUtils.isEmpty(gp6Var.c)) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c11942");
        statisticItem.param("fid", gp6Var.c);
        statisticItem.param("obj_name", str);
        TiebaStatic.log(statisticItem);
    }

    public static void b(qd6 qd6Var, FrsViewData frsViewData, String str, boolean z, ThreadData threadData) {
        hw4 adAdSense;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{qd6Var, frsViewData, str, Boolean.valueOf(z), threadData}) == null) || qd6Var == null || frsViewData == null || TextUtils.isEmpty(str) || (adAdSense = TbadkCoreApplication.getInst().getAdAdSense()) == null || !adAdSense.g()) {
            return;
        }
        hi6 W = qd6Var == null ? null : qd6Var.W();
        List<uo> f = W != null ? W.f() : null;
        List<uo> singletonList = threadData != null ? Collections.singletonList(threadData) : f;
        if (singletonList == null || f == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        if (z) {
            for (uo uoVar : f) {
                i++;
                for (uo uoVar2 : singletonList) {
                    if (uoVar == uoVar2 && (uoVar2 instanceof ThreadData)) {
                        hl8.c cVar = new hl8.c();
                        cVar.a = ((ThreadData) uoVar2).getTid();
                        cVar.c = i;
                        arrayList.add(cVar);
                    }
                }
            }
        } else {
            for (uo uoVar3 : singletonList) {
                if (uoVar3 instanceof ThreadData) {
                    ThreadData threadData2 = (ThreadData) uoVar3;
                    i++;
                    if (threadData2.showStatus == 1 && !TextUtils.isEmpty(threadData2.getTid())) {
                        threadData2.showStatus = 2;
                        hl8.c cVar2 = new hl8.c();
                        cVar2.a = threadData2.getTid();
                        cVar2.c = i;
                        arrayList.add(cVar2);
                    }
                }
            }
        }
        if (arrayList.size() > 0) {
            na8.v(z, frsViewData.getForum().getFirst_class(), frsViewData.getForum().getSecond_class(), str, arrayList, adAdSense.i());
        }
    }

    public static void c(pq4 pq4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, pq4Var) == null) || pq4Var == null) {
            return;
        }
        String d = pq4Var.d();
        if (StringUtils.isNull(d)) {
            d = pq4Var.f();
        }
        String str = d;
        String b = pq4Var.b();
        String c = pq4Var.c();
        String g = pq4Var.g();
        hl8.c("frs", "CLICK", b, c, g, "tieba.baidu.com/p/" + pq4Var.g(), str);
    }

    public static void d(FrsFragment frsFragment, FrsViewData frsViewData, ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65539, null, frsFragment, frsViewData, threadData) == null) || threadData == null || frsViewData == null) {
            return;
        }
        FrsModelController b0 = frsFragment.b0();
        qd6 w0 = frsFragment.w0();
        if (w0 == null || b0 == null) {
            return;
        }
        if (threadData.getAuthor() != null && threadData.getAuthor().getGodInfo() != null) {
            TiebaStatic.log(new StatisticItem("c10806").param("obj_locate", 3).param("tid", threadData.getId()));
        }
        if (frsViewData != null && frsViewData.getForum() != null) {
            gp6 gp6Var = new gp6();
            gp6Var.a = frsViewData.needLog == 1;
            gp6Var.c = frsViewData.getForum().getId();
            gp6Var.d = frsViewData.getForum().getName();
            gp6Var.b = b0.T();
            gp6 gp6Var2 = ip6.f0;
            if (gp6Var2 != null) {
                gp6Var.e = gp6Var2.e;
                gp6Var.f = gp6Var2.f;
            }
            hp6.k().h(gp6Var, threadData, 1);
            fp6.e(threadData, 1, frsFragment.getUniqueId(), gp6Var, frsFragment.getTbPageTag());
        }
        b(w0, frsViewData, frsFragment.b(), true, threadData);
    }

    public static void e(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i, i2) == null) {
            StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SCHEME_JUMP_CALL_NATIVE).param("obj_locate", i).param("obj_type", i2).param("obj_name", TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_PARAM3, 1);
            hj4.a(param, str);
            TiebaStatic.log(param);
        }
    }

    public static void f(FrsModelController frsModelController, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(65541, null, frsModelController, j) == null) || frsModelController == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        TiebaStatic.page(TiebaStatic.OpKey.OP_FRS_ENTER, currentTimeMillis - j, frsModelController.h0() - j, frsModelController.j0(), frsModelController.i0(), currentTimeMillis - frsModelController.g0());
    }

    public static void g(@Nullable ThreadData threadData, @Nullable FrsViewData frsViewData, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(65542, null, threadData, frsViewData, i) == null) || frsViewData == null || frsViewData.getForum() == null) {
            return;
        }
        fp6.d(threadData, frsViewData.getForum().getId(), i);
    }
}
