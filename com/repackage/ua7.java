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
public class ua7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(la7 la7Var, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65536, null, la7Var, i) == null) || la7Var == null || la7Var.B() == null || ListUtils.isEmpty(la7Var.k()) || la7Var.k().size() < 2) {
            return;
        }
        List<NewFloorInfo> k = la7Var.k();
        if (k.size() > 2) {
            if (StringHelper.equals(la7Var.B().getUserId(), TbadkCoreApplication.getCurrentAccount())) {
                if (k.get(1) != null) {
                    if (k.get(1).is_floor.intValue() == 0) {
                        b(la7Var, 12, i);
                        return;
                    } else if (k.get(1).is_floor.intValue() == 1) {
                        b(la7Var, 13, i);
                        return;
                    } else {
                        return;
                    }
                }
                return;
            } else if (k.get(1) != null) {
                if (k.get(1).is_floor.intValue() == 0) {
                    if (la7Var.v() != null) {
                        if (StringHelper.equals(la7Var.v().getUserId(), TbadkCoreApplication.getCurrentAccount())) {
                            b(la7Var, 14, i);
                            return;
                        } else {
                            b(la7Var, 15, i);
                            return;
                        }
                    }
                    return;
                } else if (k.get(1).is_floor.intValue() == 1) {
                    b(la7Var, 16, i);
                    return;
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        b(la7Var, 11, i);
    }

    public static void b(la7 la7Var, int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(65537, null, la7Var, i, i2) == null) || la7Var == null || la7Var.y() == null || la7Var.m() == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c12928");
        statisticItem.param("tid", la7Var.m().f);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        statisticItem.param("fid", la7Var.m().e);
        statisticItem.param("fname", la7Var.m().d);
        statisticItem.param("pid", la7Var.r());
        statisticItem.param("obj_type", i);
        statisticItem.param("obj_locate", i2);
        TiebaStatic.log(statisticItem);
    }
}
