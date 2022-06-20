package com.repackage;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import tbclient.NewFloorInfo;
/* loaded from: classes6.dex */
public class fa7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(w97 w97Var, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65536, null, w97Var, i) == null) || w97Var == null || w97Var.B() == null || ListUtils.isEmpty(w97Var.j()) || w97Var.j().size() < 2) {
            return;
        }
        List<NewFloorInfo> j = w97Var.j();
        if (j.size() > 2) {
            if (StringHelper.equals(w97Var.B().getUserId(), TbadkCoreApplication.getCurrentAccount())) {
                if (j.get(1) != null) {
                    if (j.get(1).is_floor.intValue() == 0) {
                        b(w97Var, 12, i);
                        return;
                    } else if (j.get(1).is_floor.intValue() == 1) {
                        b(w97Var, 13, i);
                        return;
                    } else {
                        return;
                    }
                }
                return;
            } else if (j.get(1) != null) {
                if (j.get(1).is_floor.intValue() == 0) {
                    if (w97Var.t() != null) {
                        if (StringHelper.equals(w97Var.t().getUserId(), TbadkCoreApplication.getCurrentAccount())) {
                            b(w97Var, 14, i);
                            return;
                        } else {
                            b(w97Var, 15, i);
                            return;
                        }
                    }
                    return;
                } else if (j.get(1).is_floor.intValue() == 1) {
                    b(w97Var, 16, i);
                    return;
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        b(w97Var, 11, i);
    }

    public static void b(w97 w97Var, int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(65537, null, w97Var, i, i2) == null) || w97Var == null || w97Var.w() == null || w97Var.l() == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c12928");
        statisticItem.param("tid", w97Var.l().f);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        statisticItem.param("fid", w97Var.l().e);
        statisticItem.param("fname", w97Var.l().d);
        statisticItem.param("pid", w97Var.r());
        statisticItem.param("obj_type", i);
        statisticItem.param("obj_locate", i2);
        TiebaStatic.log(statisticItem);
    }
}
