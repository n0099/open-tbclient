package d.a.q0.m2;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.p0.s.q.b2;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(View view, d.a.p0.s.q.a aVar, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(65536, null, view, aVar, i2) == null) || view == null || aVar == null || aVar.getThreadData() == null || StringUtils.isNull(aVar.getThreadData().o1())) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_DYNAMIC_CARD_CLICK);
        statisticItem.param("obj_source", 3);
        b2 threadData = aVar.getThreadData();
        if (threadData.F1()) {
            statisticItem.param("obj_type", 1);
        } else if (threadData.I1()) {
            statisticItem.param("obj_type", 2);
        } else if (threadData.G1()) {
            statisticItem.param("obj_type", 3);
        } else if (threadData.H1()) {
            statisticItem.param("obj_type", 4);
        } else if (threadData.Z == 0) {
            statisticItem.param("obj_type", 5);
        } else if (threadData.s2()) {
            statisticItem.param("obj_type", 6);
        }
        if (aVar.getThreadData().H() != null) {
            statisticItem.param("uid", aVar.getThreadData().H().getUserId());
        }
        if (threadData.J() != null) {
            statisticItem.param("obj_id", threadData.J().oriUgcNid);
        } else {
            statisticItem.param("obj_id", threadData.o1());
        }
        statisticItem.param("obj_locate", i2);
        TiebaStatic.log(statisticItem);
    }

    public static void b(d.a.p0.s.q.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, aVar) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_DYNAMIC_CARD_SHOW);
            b2 threadData = aVar.getThreadData();
            if (threadData.F1()) {
                statisticItem.param("obj_type", 1);
            } else if (threadData.I1()) {
                statisticItem.param("obj_type", 2);
            } else if (threadData.G1()) {
                statisticItem.param("obj_type", 3);
            } else if (threadData.H1()) {
                statisticItem.param("obj_type", 4);
            } else if (threadData.Z == 0) {
                statisticItem.param("obj_type", 5);
            } else if (threadData.s2()) {
                statisticItem.param("obj_type", 6);
            }
            if (threadData.J() != null) {
                statisticItem.param("obj_id", threadData.J().oriUgcNid);
            } else {
                statisticItem.param("obj_id", threadData.o1());
            }
            statisticItem.param("uid", threadData.H().getUserId());
            TiebaStatic.log(statisticItem);
        }
    }
}
