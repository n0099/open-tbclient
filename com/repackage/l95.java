package com.repackage;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class l95 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, int i, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{str, Integer.valueOf(i), str2, str3, str4}) == null) {
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.param("obj_source", str2);
            if (i > 0) {
                statisticItem.param("obj_locate", i);
            }
            if (!StringUtils.isNull(str3)) {
                statisticItem.param("tid", str3);
            }
            if (!StringUtils.isNull(str4)) {
                statisticItem.param("fid", str4);
            }
            TiebaStatic.log(statisticItem);
        }
    }
}
