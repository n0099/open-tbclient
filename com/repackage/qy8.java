package com.repackage;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class qy8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65536, null, i) == null) || i == -1) {
            return;
        }
        new StatisticItem("c14823").addParam("obj_source", i).addParam("uid", TbadkCoreApplication.getCurrentAccount()).eventStat();
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            new StatisticItem(CommonStatisticKey.KEY_FUNCTION_PANEL_CLIKED).addParam("uid", TbadkCoreApplication.getCurrentAccount()).addParam("obj_locate", 14).eventStat();
        }
    }
}
