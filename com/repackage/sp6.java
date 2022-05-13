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
import com.repackage.ek8;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes7.dex */
public class sp6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(ho6 ho6Var, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65536, null, ho6Var, str) == null) || TextUtils.isEmpty(str) || ho6Var == null || TextUtils.isEmpty(ho6Var.c)) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c11942");
        statisticItem.param("fid", ho6Var.c);
        statisticItem.param("obj_name", str);
        TiebaStatic.log(statisticItem);
    }

    public static void b(vc6 vc6Var, FrsViewData frsViewData, String str, boolean z, ThreadData threadData) {
        uw4 adAdSense;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{vc6Var, frsViewData, str, Boolean.valueOf(z), threadData}) == null) || vc6Var == null || frsViewData == null || TextUtils.isEmpty(str) || (adAdSense = TbadkCoreApplication.getInst().getAdAdSense()) == null || !adAdSense.e()) {
            return;
        }
        mh6 W = vc6Var == null ? null : vc6Var.W();
        List<ro> f = W != null ? W.f() : null;
        List<ro> singletonList = threadData != null ? Collections.singletonList(threadData) : f;
        if (singletonList == null || f == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (z) {
            for (ro roVar : f) {
                for (ro roVar2 : singletonList) {
                    if (roVar == roVar2 && (roVar2 instanceof ThreadData)) {
                        ek8.c cVar = new ek8.c();
                        ((ThreadData) roVar2).getTid();
                        arrayList.add(cVar);
                    }
                }
            }
        } else {
            for (ro roVar3 : singletonList) {
                if (roVar3 instanceof ThreadData) {
                    ThreadData threadData2 = (ThreadData) roVar3;
                    if (threadData2.showStatus == 1 && !TextUtils.isEmpty(threadData2.getTid())) {
                        threadData2.showStatus = 2;
                        ek8.c cVar2 = new ek8.c();
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

    public static void c(ar4 ar4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, ar4Var) == null) || ar4Var == null) {
            return;
        }
        String d = ar4Var.d();
        if (StringUtils.isNull(d)) {
            d = ar4Var.f();
        }
        String str = d;
        String b = ar4Var.b();
        String c = ar4Var.c();
        String g = ar4Var.g();
        ek8.c("frs", "CLICK", b, c, g, "tieba.baidu.com/p/" + ar4Var.g(), str);
    }

    public static void d(FrsFragment frsFragment, FrsViewData frsViewData, ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65539, null, frsFragment, frsViewData, threadData) == null) || threadData == null || frsViewData == null) {
            return;
        }
        FrsModelController b0 = frsFragment.b0();
        vc6 w0 = frsFragment.w0();
        if (w0 == null || b0 == null) {
            return;
        }
        if (threadData.getAuthor() != null && threadData.getAuthor().getGodInfo() != null) {
            TiebaStatic.log(new StatisticItem("c10806").param("obj_locate", 3).param("tid", threadData.getId()));
        }
        if (frsViewData != null && frsViewData.getForum() != null) {
            ho6 ho6Var = new ho6();
            ho6Var.a = frsViewData.needLog == 1;
            ho6Var.c = frsViewData.getForum().getId();
            ho6Var.d = frsViewData.getForum().getName();
            ho6Var.b = b0.T();
            ho6 ho6Var2 = jo6.f0;
            if (ho6Var2 != null) {
                ho6Var.e = ho6Var2.e;
                ho6Var.f = ho6Var2.f;
            }
            io6.k().h(ho6Var, threadData, 1);
            go6.e(threadData, 1, frsFragment.getUniqueId(), ho6Var, frsFragment.getTbPageTag());
        }
        b(w0, frsViewData, frsFragment.b(), true, threadData);
    }

    public static void e(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i, i2) == null) {
            StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SCHEME_JUMP_CALL_NATIVE).param("obj_locate", i).param("obj_type", i2).param("obj_name", TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_PARAM3, 1);
            sj4.a(param, str);
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
        go6.d(threadData, frsViewData.getForum().getId(), i);
    }
}
