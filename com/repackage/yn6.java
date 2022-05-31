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
import com.repackage.fh8;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes7.dex */
public class yn6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(nm6 nm6Var, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65536, null, nm6Var, str) == null) || TextUtils.isEmpty(str) || nm6Var == null || TextUtils.isEmpty(nm6Var.c)) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c11942");
        statisticItem.param("fid", nm6Var.c);
        statisticItem.param("obj_name", str);
        TiebaStatic.log(statisticItem);
    }

    public static void b(lb6 lb6Var, FrsViewData frsViewData, String str, boolean z, ThreadData threadData) {
        kv4 adAdSense;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{lb6Var, frsViewData, str, Boolean.valueOf(z), threadData}) == null) || lb6Var == null || frsViewData == null || TextUtils.isEmpty(str) || (adAdSense = TbadkCoreApplication.getInst().getAdAdSense()) == null || !adAdSense.e()) {
            return;
        }
        dg6 W = lb6Var == null ? null : lb6Var.W();
        List<jn> f = W != null ? W.f() : null;
        List<jn> singletonList = threadData != null ? Collections.singletonList(threadData) : f;
        if (singletonList == null || f == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (z) {
            for (jn jnVar : f) {
                for (jn jnVar2 : singletonList) {
                    if (jnVar == jnVar2 && (jnVar2 instanceof ThreadData)) {
                        fh8.c cVar = new fh8.c();
                        ((ThreadData) jnVar2).getTid();
                        arrayList.add(cVar);
                    }
                }
            }
        } else {
            for (jn jnVar3 : singletonList) {
                if (jnVar3 instanceof ThreadData) {
                    ThreadData threadData2 = (ThreadData) jnVar3;
                    if (threadData2.showStatus == 1 && !TextUtils.isEmpty(threadData2.getTid())) {
                        threadData2.showStatus = 2;
                        fh8.c cVar2 = new fh8.c();
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

    public static void c(pp4 pp4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, pp4Var) == null) || pp4Var == null) {
            return;
        }
        String d = pp4Var.d();
        if (StringUtils.isNull(d)) {
            d = pp4Var.f();
        }
        String str = d;
        String b = pp4Var.b();
        String c = pp4Var.c();
        String g = pp4Var.g();
        fh8.c("frs", "CLICK", b, c, g, "tieba.baidu.com/p/" + pp4Var.g(), str);
    }

    public static void d(FrsFragment frsFragment, FrsViewData frsViewData, ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65539, null, frsFragment, frsViewData, threadData) == null) || threadData == null || frsViewData == null) {
            return;
        }
        FrsModelController c0 = frsFragment.c0();
        lb6 y0 = frsFragment.y0();
        if (y0 == null || c0 == null) {
            return;
        }
        if (threadData.getAuthor() != null && threadData.getAuthor().getGodInfo() != null) {
            TiebaStatic.log(new StatisticItem("c10806").param("obj_locate", 3).param("tid", threadData.getId()));
        }
        if (frsViewData != null && frsViewData.getForum() != null) {
            nm6 nm6Var = new nm6();
            nm6Var.a = frsViewData.needLog == 1;
            nm6Var.c = frsViewData.getForum().getId();
            nm6Var.d = frsViewData.getForum().getName();
            nm6Var.b = c0.T();
            nm6 nm6Var2 = pm6.f0;
            if (nm6Var2 != null) {
                nm6Var.e = nm6Var2.e;
                nm6Var.f = nm6Var2.f;
            }
            om6.k().h(nm6Var, threadData, 1);
            mm6.e(threadData, 1, frsFragment.getUniqueId(), nm6Var, frsFragment.getTbPageTag());
        }
        b(y0, frsViewData, frsFragment.b(), true, threadData);
    }

    public static void e(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i, i2) == null) {
            StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SCHEME_JUMP_CALL_NATIVE).param("obj_locate", i).param("obj_type", i2).param("obj_name", TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_PARAM3, 1);
            fi4.a(param, str);
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
        mm6.d(threadData, frsViewData.getForum().getId(), i);
    }
}
