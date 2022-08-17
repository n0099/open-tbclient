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
import com.repackage.gl8;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
public class hr6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(xp6 xp6Var, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65536, null, xp6Var, str) == null) || TextUtils.isEmpty(str) || xp6Var == null || TextUtils.isEmpty(xp6Var.c)) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c11942");
        statisticItem.param("fid", xp6Var.c);
        statisticItem.param("obj_name", str);
        TiebaStatic.log(statisticItem);
    }

    public static void b(af6 af6Var, FrsViewData frsViewData, String str, boolean z, ThreadData threadData) {
        nx4 adAdSense;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{af6Var, frsViewData, str, Boolean.valueOf(z), threadData}) == null) || af6Var == null || frsViewData == null || TextUtils.isEmpty(str) || (adAdSense = TbadkCoreApplication.getInst().getAdAdSense()) == null || !adAdSense.e()) {
            return;
        }
        tj6 X = af6Var == null ? null : af6Var.X();
        List<on> f = X != null ? X.f() : null;
        List<on> singletonList = threadData != null ? Collections.singletonList(threadData) : f;
        if (singletonList == null || f == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (z) {
            for (on onVar : f) {
                for (on onVar2 : singletonList) {
                    if (onVar == onVar2 && (onVar2 instanceof ThreadData)) {
                        gl8.c cVar = new gl8.c();
                        ((ThreadData) onVar2).getTid();
                        arrayList.add(cVar);
                    }
                }
            }
        } else {
            for (on onVar3 : singletonList) {
                if (onVar3 instanceof ThreadData) {
                    ThreadData threadData2 = (ThreadData) onVar3;
                    if (threadData2.showStatus == 1 && !TextUtils.isEmpty(threadData2.getTid())) {
                        threadData2.showStatus = 2;
                        gl8.c cVar2 = new gl8.c();
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

    public static void c(gr4 gr4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, gr4Var) == null) || gr4Var == null) {
            return;
        }
        String d = gr4Var.d();
        if (StringUtils.isNull(d)) {
            d = gr4Var.f();
        }
        String str = d;
        String b = gr4Var.b();
        String c = gr4Var.c();
        String g = gr4Var.g();
        gl8.c("frs", "CLICK", b, c, g, "tieba.baidu.com/p/" + gr4Var.g(), str);
    }

    public static void d(FrsFragment frsFragment, FrsViewData frsViewData, ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65539, null, frsFragment, frsViewData, threadData) == null) || threadData == null || frsViewData == null) {
            return;
        }
        FrsModelController K0 = frsFragment.K0();
        af6 k1 = frsFragment.k1();
        if (k1 == null || K0 == null) {
            return;
        }
        if (threadData.getAuthor() != null && threadData.getAuthor().getGodInfo() != null) {
            TiebaStatic.log(new StatisticItem("c10806").param("obj_locate", 3).param("tid", threadData.getId()));
        }
        if (frsViewData != null && frsViewData.getForum() != null) {
            xp6 xp6Var = new xp6();
            xp6Var.a = frsViewData.needLog == 1;
            xp6Var.c = frsViewData.getForum().getId();
            xp6Var.d = frsViewData.getForum().getName();
            xp6Var.b = K0.U();
            xp6 xp6Var2 = zp6.p0;
            if (xp6Var2 != null) {
                xp6Var.e = xp6Var2.e;
                xp6Var.f = xp6Var2.f;
            }
            yp6.k().h(xp6Var, threadData, 1);
            wp6.e(threadData, 1, frsFragment.getUniqueId(), xp6Var, frsFragment.getTbPageTag());
        }
        b(k1, frsViewData, frsFragment.d(), true, threadData);
    }

    public static void e(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i, i2) == null) {
            StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SCHEME_JUMP_CALL_NATIVE).param("obj_locate", i).param("obj_type", i2).param("obj_name", TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_PARAM3, 1);
            wj4.a(param, str);
            TiebaStatic.log(param);
        }
    }

    public static void f(FrsModelController frsModelController, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(65541, null, frsModelController, j) == null) || frsModelController == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        TiebaStatic.page(TiebaStatic.OpKey.OP_FRS_ENTER, currentTimeMillis - j, frsModelController.i0() - j, frsModelController.k0(), frsModelController.j0(), currentTimeMillis - frsModelController.h0());
    }

    public static void g(@Nullable ThreadData threadData, @Nullable FrsViewData frsViewData, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(65542, null, threadData, frsViewData, i) == null) || frsViewData == null || frsViewData.getForum() == null) {
            return;
        }
        wp6.d(threadData, frsViewData.getForum().getId(), i);
    }
}
