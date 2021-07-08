package d.a.p0.e1.f.a;

import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.o0.r.q.b2;
import d.a.p0.e1.f.a.e.e;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(View view, Object obj, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(65536, null, view, obj, i2, str) == null) {
            if (obj instanceof d.a.p0.e1.f.a.e.c) {
                d.a.p0.e1.f.a.e.c cVar = (d.a.p0.e1.f.a.e.c) obj;
                if (cVar.f55394e) {
                    StatisticItem statisticItem = new StatisticItem("c13736");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem.eventStat();
                    return;
                }
                StatisticItem statisticItem2 = new StatisticItem("c13735");
                statisticItem2.param("obj_locate", i2);
                statisticItem2.param("topic_id", cVar.f55390a);
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem2.eventStat();
            } else if (obj instanceof e) {
                b2 b2Var = ((e) obj).j;
                StatisticItem statisticItem3 = new StatisticItem("c13738");
                statisticItem3.param("obj_type", str);
                statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccount());
                if (b2Var != null) {
                    statisticItem3.param("tid", b2Var.n1());
                    statisticItem3.param("fid", b2Var.Q());
                }
                statisticItem3.eventStat();
            } else if ((obj instanceof d.a.o0.r.q.a) && c(view)) {
                b2 threadData = ((d.a.o0.r.q.a) obj).getThreadData();
                StatisticItem statisticItem4 = new StatisticItem("c13738");
                statisticItem4.param("obj_type", str);
                statisticItem4.param("uid", TbadkCoreApplication.getCurrentAccount());
                if (threadData != null) {
                    statisticItem4.param("tid", threadData.n1());
                    statisticItem4.param("fid", threadData.Q());
                }
                statisticItem4.eventStat();
            }
        }
    }

    public static void b(View view, Object obj, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, view, obj, str) == null) {
            if (obj instanceof e) {
                b2 b2Var = ((e) obj).j;
                StatisticItem statisticItem = new StatisticItem("c13825");
                statisticItem.param("obj_type", str);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                if (b2Var != null) {
                    statisticItem.param("tid", b2Var.n1());
                }
                statisticItem.eventStat();
            } else if (obj instanceof d.a.o0.r.q.a) {
                b2 threadData = ((d.a.o0.r.q.a) obj).getThreadData();
                StatisticItem statisticItem2 = new StatisticItem("c13825");
                statisticItem2.param("obj_type", str);
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                if (threadData != null) {
                    statisticItem2.param("tid", threadData.n1());
                }
                statisticItem2.eventStat();
            }
        }
    }

    public static boolean c(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, view)) == null) {
            int id = view.getId();
            return id == R.id.thread_card_root || id == R.id.thread_info_commont_container;
        }
        return invokeL.booleanValue;
    }
}
