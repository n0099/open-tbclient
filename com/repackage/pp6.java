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
import com.repackage.ti8;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
public class pp6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(eo6 eo6Var, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65536, null, eo6Var, str) == null) || TextUtils.isEmpty(str) || eo6Var == null || TextUtils.isEmpty(eo6Var.c)) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c11942");
        statisticItem.param("fid", eo6Var.c);
        statisticItem.param("obj_name", str);
        TiebaStatic.log(statisticItem);
    }

    public static void b(id6 id6Var, FrsViewData frsViewData, String str, boolean z, ThreadData threadData) {
        sw4 adAdSense;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{id6Var, frsViewData, str, Boolean.valueOf(z), threadData}) == null) || id6Var == null || frsViewData == null || TextUtils.isEmpty(str) || (adAdSense = TbadkCoreApplication.getInst().getAdAdSense()) == null || !adAdSense.e()) {
            return;
        }
        ai6 X = id6Var == null ? null : id6Var.X();
        List<nn> f = X != null ? X.f() : null;
        List<nn> singletonList = threadData != null ? Collections.singletonList(threadData) : f;
        if (singletonList == null || f == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (z) {
            for (nn nnVar : f) {
                for (nn nnVar2 : singletonList) {
                    if (nnVar == nnVar2 && (nnVar2 instanceof ThreadData)) {
                        ti8.c cVar = new ti8.c();
                        ((ThreadData) nnVar2).getTid();
                        arrayList.add(cVar);
                    }
                }
            }
        } else {
            for (nn nnVar3 : singletonList) {
                if (nnVar3 instanceof ThreadData) {
                    ThreadData threadData2 = (ThreadData) nnVar3;
                    if (threadData2.showStatus == 1 && !TextUtils.isEmpty(threadData2.getTid())) {
                        threadData2.showStatus = 2;
                        ti8.c cVar2 = new ti8.c();
                        threadData2.getTid();
                        arrayList.add(cVar2);
                    }
                }
            }
        }
        if (arrayList.size() > 0) {
            frsViewData.getForum().getFirst_class();
            frsViewData.getForum().getSecond_class();
        }
    }

    public static void c(oq4 oq4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, oq4Var) == null) || oq4Var == null) {
            return;
        }
        String d = oq4Var.d();
        if (StringUtils.isNull(d)) {
            d = oq4Var.f();
        }
        String str = d;
        String b = oq4Var.b();
        String c = oq4Var.c();
        String g = oq4Var.g();
        ti8.c("frs", "CLICK", b, c, g, "tieba.baidu.com/p/" + oq4Var.g(), str);
    }

    public static void d(FrsFragment frsFragment, FrsViewData frsViewData, ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65539, null, frsFragment, frsViewData, threadData) == null) || threadData == null || frsViewData == null) {
            return;
        }
        FrsModelController L0 = frsFragment.L0();
        id6 l1 = frsFragment.l1();
        if (l1 == null || L0 == null) {
            return;
        }
        if (threadData.getAuthor() != null && threadData.getAuthor().getGodInfo() != null) {
            TiebaStatic.log(new StatisticItem("c10806").param("obj_locate", 3).param("tid", threadData.getId()));
        }
        if (frsViewData != null && frsViewData.getForum() != null) {
            eo6 eo6Var = new eo6();
            eo6Var.a = frsViewData.needLog == 1;
            eo6Var.c = frsViewData.getForum().getId();
            eo6Var.d = frsViewData.getForum().getName();
            eo6Var.b = L0.V();
            eo6 eo6Var2 = go6.f0;
            if (eo6Var2 != null) {
                eo6Var.e = eo6Var2.e;
                eo6Var.f = eo6Var2.f;
            }
            fo6.k().h(eo6Var, threadData, 1);
            do6.e(threadData, 1, frsFragment.getUniqueId(), eo6Var, frsFragment.getTbPageTag());
        }
        b(l1, frsViewData, frsFragment.d(), true, threadData);
    }

    public static void e(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i, i2) == null) {
            StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SCHEME_JUMP_CALL_NATIVE).param("obj_locate", i).param("obj_type", i2).param("obj_name", TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_PARAM3, 1);
            ej4.a(param, str);
            TiebaStatic.log(param);
        }
    }

    public static void f(FrsModelController frsModelController, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(65541, null, frsModelController, j) == null) || frsModelController == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        TiebaStatic.page(TiebaStatic.OpKey.OP_FRS_ENTER, currentTimeMillis - j, frsModelController.j0() - j, frsModelController.l0(), frsModelController.k0(), currentTimeMillis - frsModelController.i0());
    }

    public static void g(@Nullable ThreadData threadData, @Nullable FrsViewData frsViewData, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(65542, null, threadData, frsViewData, i) == null) || frsViewData == null || frsViewData.getForum() == null) {
            return;
        }
        do6.d(threadData, frsViewData.getForum().getId(), i);
    }
}
