package com.repackage;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class ri8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(qi8 qi8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65536, null, qi8Var) == null) || qi8Var == null || qi8Var.b == 0 || qi8Var.c == 0) {
            return;
        }
        StatisticItem addParam = StatisticItem.make("c14571").addParam("obj_source", qi8Var.b).addParam("obj_type", qi8Var.c).addParam("uid", TbadkCoreApplication.getCurrentAccount());
        int i = qi8Var.a;
        if (i != 0) {
            addParam.addParam("obj_locate", i);
        }
        addParam.eventStat();
    }
}
