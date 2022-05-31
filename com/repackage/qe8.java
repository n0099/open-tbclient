package com.repackage;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class qe8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(pe8 pe8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65536, null, pe8Var) == null) || pe8Var == null || pe8Var.b == 0 || pe8Var.c == 0) {
            return;
        }
        StatisticItem addParam = StatisticItem.make("c14571").addParam("obj_source", pe8Var.b).addParam("obj_type", pe8Var.c).addParam("uid", TbadkCoreApplication.getCurrentAccount());
        int i = pe8Var.a;
        if (i != 0) {
            addParam.addParam("obj_locate", i);
        }
        addParam.eventStat();
    }
}
