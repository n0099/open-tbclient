package d.a.o0.j2;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import d.a.n0.r.q.a2;
/* loaded from: classes5.dex */
public class a {
    public static void a(View view, d.a.n0.r.q.a aVar, int i2) {
        if (view == null || aVar == null || aVar.i() == null || StringUtils.isNull(aVar.i().z1())) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_DYNAMIC_CARD_CLICK);
        statisticItem.param("obj_source", 3);
        a2 i3 = aVar.i();
        if (i3.R1()) {
            statisticItem.param("obj_type", 1);
        } else if (i3.U1()) {
            statisticItem.param("obj_type", 2);
        } else if (i3.S1()) {
            statisticItem.param("obj_type", 3);
        } else if (i3.T1()) {
            statisticItem.param("obj_type", 4);
        } else if (i3.Z == 0) {
            statisticItem.param("obj_type", 5);
        } else if (i3.D2()) {
            statisticItem.param("obj_type", 6);
        }
        if (aVar.i().T() != null) {
            statisticItem.param("uid", aVar.i().T().getUserId());
        }
        if (i3.V() != null) {
            statisticItem.param("obj_id", i3.V().oriUgcNid);
        } else {
            statisticItem.param("obj_id", i3.z1());
        }
        statisticItem.param("obj_locate", i2);
        TiebaStatic.log(statisticItem);
    }

    public static void b(d.a.n0.r.q.a aVar) {
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_DYNAMIC_CARD_SHOW);
        a2 i2 = aVar.i();
        if (i2.R1()) {
            statisticItem.param("obj_type", 1);
        } else if (i2.U1()) {
            statisticItem.param("obj_type", 2);
        } else if (i2.S1()) {
            statisticItem.param("obj_type", 3);
        } else if (i2.T1()) {
            statisticItem.param("obj_type", 4);
        } else if (i2.Z == 0) {
            statisticItem.param("obj_type", 5);
        } else if (i2.D2()) {
            statisticItem.param("obj_type", 6);
        }
        if (i2.V() != null) {
            statisticItem.param("obj_id", i2.V().oriUgcNid);
        } else {
            statisticItem.param("obj_id", i2.z1());
        }
        statisticItem.param("uid", i2.T().getUserId());
        TiebaStatic.log(statisticItem);
    }
}
