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
/* loaded from: classes7.dex */
public class u87 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(l87 l87Var, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65536, null, l87Var, i) == null) || l87Var == null || l87Var.B() == null || ListUtils.isEmpty(l87Var.k()) || l87Var.k().size() < 2) {
            return;
        }
        List<NewFloorInfo> k = l87Var.k();
        if (k.size() > 2) {
            if (StringHelper.equals(l87Var.B().getUserId(), TbadkCoreApplication.getCurrentAccount())) {
                if (k.get(1) != null) {
                    if (k.get(1).is_floor.intValue() == 0) {
                        b(l87Var, 12, i);
                        return;
                    } else if (k.get(1).is_floor.intValue() == 1) {
                        b(l87Var, 13, i);
                        return;
                    } else {
                        return;
                    }
                }
                return;
            } else if (k.get(1) != null) {
                if (k.get(1).is_floor.intValue() == 0) {
                    if (l87Var.v() != null) {
                        if (StringHelper.equals(l87Var.v().getUserId(), TbadkCoreApplication.getCurrentAccount())) {
                            b(l87Var, 14, i);
                            return;
                        } else {
                            b(l87Var, 15, i);
                            return;
                        }
                    }
                    return;
                } else if (k.get(1).is_floor.intValue() == 1) {
                    b(l87Var, 16, i);
                    return;
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        b(l87Var, 11, i);
    }

    public static void b(l87 l87Var, int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(65537, null, l87Var, i, i2) == null) || l87Var == null || l87Var.y() == null || l87Var.m() == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c12928");
        statisticItem.param("tid", l87Var.m().f);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        statisticItem.param("fid", l87Var.m().e);
        statisticItem.param("fname", l87Var.m().d);
        statisticItem.param("pid", l87Var.r());
        statisticItem.param("obj_type", i);
        statisticItem.param("obj_locate", i2);
        TiebaStatic.log(statisticItem);
    }
}
