package com.repackage;

import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class d85 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, int i, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{str, Integer.valueOf(i), str2, str3, str4}) == null) {
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.param("obj_locate", i);
            statisticItem.param("obj_source", str2);
            statisticItem.param("tid", str3);
            statisticItem.param("fid", str4);
            TiebaStatic.log(statisticItem);
        }
    }

    public static void b(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, str, str2, str3, str4) == null) {
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.param("obj_source", str2);
            statisticItem.param("tid", str3);
            statisticItem.param("fid", str4);
            TiebaStatic.log(statisticItem);
        }
    }
}
