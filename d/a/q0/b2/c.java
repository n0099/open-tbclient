package d.a.q0.b2;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.p0.s.q.b2;
import d.a.p0.s.q.o1;
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, Object obj, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65536, null, str, obj, i2) == null) {
            if (obj instanceof o1) {
                StatisticItem statisticItem = new StatisticItem(str);
                statisticItem.param("fid", ((o1) obj).h());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.eventStat();
            } else if (obj instanceof d.a.q0.b2.e.b) {
                StatisticItem statisticItem2 = new StatisticItem(str);
                b2 b2Var = ((d.a.q0.b2.e.b) obj).k;
                if (b2Var != null) {
                    statisticItem2.param("tid", b2Var.o1());
                }
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem2.eventStat();
            }
        }
    }

    public static void b(d.a.q0.b2.d.c.a aVar, d.a.p0.s.q.a aVar2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, aVar, aVar2) == null) || aVar2 == null || aVar2.getThreadData() == null) {
            return;
        }
        b2 threadData = aVar2.getThreadData();
        StatisticItem statisticItem = new StatisticItem(aVar.e0() ? "c13823" : "c13822");
        statisticItem.param("tid", threadData.o1());
        statisticItem.param("fid", threadData.R());
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem.eventStat();
    }

    public static void c(d.a.q0.b2.d.c.a aVar, d.a.p0.s.q.a aVar2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, aVar, aVar2) == null) || aVar2 == null || aVar2.getThreadData() == null) {
            return;
        }
        b2 threadData = aVar2.getThreadData();
        StatisticItem statisticItem = new StatisticItem(aVar.e0() ? "c13824" : "c13821");
        statisticItem.param("tid", threadData.o1());
        statisticItem.param("fid", threadData.R());
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem.eventStat();
    }
}
