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
public class sc7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(jc7 jc7Var, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65536, null, jc7Var, i) == null) || jc7Var == null || jc7Var.D() == null || ListUtils.isEmpty(jc7Var.n()) || jc7Var.n().size() < 2) {
            return;
        }
        List<NewFloorInfo> n = jc7Var.n();
        if (n.size() > 2) {
            if (StringHelper.equals(jc7Var.D().getUserId(), TbadkCoreApplication.getCurrentAccount())) {
                if (n.get(1) != null) {
                    if (n.get(1).is_floor.intValue() == 0) {
                        b(jc7Var, 12, i);
                        return;
                    } else if (n.get(1).is_floor.intValue() == 1) {
                        b(jc7Var, 13, i);
                        return;
                    } else {
                        return;
                    }
                }
                return;
            } else if (n.get(1) != null) {
                if (n.get(1).is_floor.intValue() == 0) {
                    if (jc7Var.z() != null) {
                        if (StringHelper.equals(jc7Var.z().getUserId(), TbadkCoreApplication.getCurrentAccount())) {
                            b(jc7Var, 14, i);
                            return;
                        } else {
                            b(jc7Var, 15, i);
                            return;
                        }
                    }
                    return;
                } else if (n.get(1).is_floor.intValue() == 1) {
                    b(jc7Var, 16, i);
                    return;
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        b(jc7Var, 11, i);
    }

    public static void b(jc7 jc7Var, int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(65537, null, jc7Var, i, i2) == null) || jc7Var == null || jc7Var.A() == null || jc7Var.r() == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c12928");
        statisticItem.param("tid", jc7Var.r().f);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        statisticItem.param("fid", jc7Var.r().e);
        statisticItem.param("fname", jc7Var.r().d);
        statisticItem.param("pid", jc7Var.t());
        statisticItem.param("obj_type", i);
        statisticItem.param("obj_locate", i2);
        TiebaStatic.log(statisticItem);
    }
}
