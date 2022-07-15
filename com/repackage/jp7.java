package com.repackage;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class jp7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, Object obj, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(65536, null, str, obj, i) == null) && (obj instanceof op7)) {
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.param("obj_locate", i);
            statisticItem.param("topic_id", ((op7) obj).a);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.eventStat();
        }
    }
}
