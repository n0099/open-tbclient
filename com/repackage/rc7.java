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
public class rc7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(ic7 ic7Var, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65536, null, ic7Var, i) == null) || ic7Var == null || ic7Var.D() == null || ListUtils.isEmpty(ic7Var.n()) || ic7Var.n().size() < 2) {
            return;
        }
        List<NewFloorInfo> n = ic7Var.n();
        if (n.size() > 2) {
            if (StringHelper.equals(ic7Var.D().getUserId(), TbadkCoreApplication.getCurrentAccount())) {
                if (n.get(1) != null) {
                    if (n.get(1).is_floor.intValue() == 0) {
                        b(ic7Var, 12, i);
                        return;
                    } else if (n.get(1).is_floor.intValue() == 1) {
                        b(ic7Var, 13, i);
                        return;
                    } else {
                        return;
                    }
                }
                return;
            } else if (n.get(1) != null) {
                if (n.get(1).is_floor.intValue() == 0) {
                    if (ic7Var.z() != null) {
                        if (StringHelper.equals(ic7Var.z().getUserId(), TbadkCoreApplication.getCurrentAccount())) {
                            b(ic7Var, 14, i);
                            return;
                        } else {
                            b(ic7Var, 15, i);
                            return;
                        }
                    }
                    return;
                } else if (n.get(1).is_floor.intValue() == 1) {
                    b(ic7Var, 16, i);
                    return;
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        b(ic7Var, 11, i);
    }

    public static void b(ic7 ic7Var, int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(65537, null, ic7Var, i, i2) == null) || ic7Var == null || ic7Var.A() == null || ic7Var.r() == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c12928");
        statisticItem.param("tid", ic7Var.r().f);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        statisticItem.param("fid", ic7Var.r().e);
        statisticItem.param("fname", ic7Var.r().d);
        statisticItem.param("pid", ic7Var.t());
        statisticItem.param("obj_type", i);
        statisticItem.param("obj_locate", i2);
        TiebaStatic.log(statisticItem);
    }
}
