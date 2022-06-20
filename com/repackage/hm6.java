package com.repackage;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class hm6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65536, null, i, i2) == null) {
            StatisticItem statisticItem = new StatisticItem("c13513");
            statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.addParam("obj_type", i);
            if (i2 != -1) {
                statisticItem.addParam("obj_locate", i2);
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public static void b(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65537, null, str, i) == null) {
            StatisticItem statisticItem = new StatisticItem("c13512");
            statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.addParam("fid", str);
            statisticItem.addParam("obj_source", i);
            TiebaStatic.log(statisticItem);
        }
    }
}
