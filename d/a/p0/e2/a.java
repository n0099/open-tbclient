package d.a.p0.e2;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, Object obj, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(65536, null, str, obj, i2) == null) && (obj instanceof d.a.p0.e2.d.b)) {
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.param("obj_locate", i2);
            statisticItem.param("topic_id", ((d.a.p0.e2.d.b) obj).f55895e);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.eventStat();
        }
    }
}
