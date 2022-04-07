package com.repackage;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ki8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(ji8 ji8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65536, null, ji8Var) == null) || ji8Var == null || ji8Var.b == 0 || ji8Var.c == 0) {
            return;
        }
        StatisticItem addParam = StatisticItem.make("c14571").addParam("obj_source", ji8Var.b).addParam("obj_type", ji8Var.c).addParam("uid", TbadkCoreApplication.getCurrentAccount());
        int i = ji8Var.a;
        if (i != 0) {
            addParam.addParam("obj_locate", i);
        }
        addParam.eventStat();
    }
}
