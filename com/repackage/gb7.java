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
public class gb7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(wa7 wa7Var, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65536, null, wa7Var, i) == null) || wa7Var == null || wa7Var.B() == null || ListUtils.isEmpty(wa7Var.k()) || wa7Var.k().size() < 2) {
            return;
        }
        List<NewFloorInfo> k = wa7Var.k();
        if (k.size() > 2) {
            if (StringHelper.equals(wa7Var.B().getUserId(), TbadkCoreApplication.getCurrentAccount())) {
                if (k.get(1) != null) {
                    if (k.get(1).is_floor.intValue() == 0) {
                        b(wa7Var, 12, i);
                        return;
                    } else if (k.get(1).is_floor.intValue() == 1) {
                        b(wa7Var, 13, i);
                        return;
                    } else {
                        return;
                    }
                }
                return;
            } else if (k.get(1) != null) {
                if (k.get(1).is_floor.intValue() == 0) {
                    if (wa7Var.v() != null) {
                        if (StringHelper.equals(wa7Var.v().getUserId(), TbadkCoreApplication.getCurrentAccount())) {
                            b(wa7Var, 14, i);
                            return;
                        } else {
                            b(wa7Var, 15, i);
                            return;
                        }
                    }
                    return;
                } else if (k.get(1).is_floor.intValue() == 1) {
                    b(wa7Var, 16, i);
                    return;
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        b(wa7Var, 11, i);
    }

    public static void b(wa7 wa7Var, int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(65537, null, wa7Var, i, i2) == null) || wa7Var == null || wa7Var.y() == null || wa7Var.m() == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c12928");
        statisticItem.param("tid", wa7Var.m().f);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        statisticItem.param("fid", wa7Var.m().e);
        statisticItem.param("fname", wa7Var.m().d);
        statisticItem.param("pid", wa7Var.r());
        statisticItem.param("obj_type", i);
        statisticItem.param("obj_locate", i2);
        TiebaStatic.log(statisticItem);
    }
}
