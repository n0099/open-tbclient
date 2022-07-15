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
public class xa7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(oa7 oa7Var, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65536, null, oa7Var, i) == null) || oa7Var == null || oa7Var.D() == null || ListUtils.isEmpty(oa7Var.m()) || oa7Var.m().size() < 2) {
            return;
        }
        List<NewFloorInfo> m = oa7Var.m();
        if (m.size() > 2) {
            if (StringHelper.equals(oa7Var.D().getUserId(), TbadkCoreApplication.getCurrentAccount())) {
                if (m.get(1) != null) {
                    if (m.get(1).is_floor.intValue() == 0) {
                        b(oa7Var, 12, i);
                        return;
                    } else if (m.get(1).is_floor.intValue() == 1) {
                        b(oa7Var, 13, i);
                        return;
                    } else {
                        return;
                    }
                }
                return;
            } else if (m.get(1) != null) {
                if (m.get(1).is_floor.intValue() == 0) {
                    if (oa7Var.x() != null) {
                        if (StringHelper.equals(oa7Var.x().getUserId(), TbadkCoreApplication.getCurrentAccount())) {
                            b(oa7Var, 14, i);
                            return;
                        } else {
                            b(oa7Var, 15, i);
                            return;
                        }
                    }
                    return;
                } else if (m.get(1).is_floor.intValue() == 1) {
                    b(oa7Var, 16, i);
                    return;
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        b(oa7Var, 11, i);
    }

    public static void b(oa7 oa7Var, int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(65537, null, oa7Var, i, i2) == null) || oa7Var == null || oa7Var.A() == null || oa7Var.o() == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c12928");
        statisticItem.param("tid", oa7Var.o().f);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        statisticItem.param("fid", oa7Var.o().e);
        statisticItem.param("fname", oa7Var.o().d);
        statisticItem.param("pid", oa7Var.t());
        statisticItem.param("obj_type", i);
        statisticItem.param("obj_locate", i2);
        TiebaStatic.log(statisticItem);
    }
}
