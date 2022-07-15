package com.repackage;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class hq7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, str) == null) {
            int i = TbadkCoreApplication.getCurrentMemberType() > 0 ? 1 : 0;
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.param("obj_type", i);
            TiebaStatic.log(statisticItem);
        }
    }
}
