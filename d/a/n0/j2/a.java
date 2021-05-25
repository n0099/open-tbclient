package d.a.n0.j2;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import d.a.m0.r.q.a2;
/* loaded from: classes5.dex */
public class a {
    public static void a(View view, d.a.m0.r.q.a aVar, int i2) {
        if (view == null || aVar == null || aVar.m() == null || StringUtils.isNull(aVar.m().y1())) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_DYNAMIC_CARD_CLICK);
        statisticItem.param("obj_source", 3);
        a2 m = aVar.m();
        if (m.Q1()) {
            statisticItem.param("obj_type", 1);
        } else if (m.T1()) {
            statisticItem.param("obj_type", 2);
        } else if (m.R1()) {
            statisticItem.param("obj_type", 3);
        } else if (m.S1()) {
            statisticItem.param("obj_type", 4);
        } else if (m.Z == 0) {
            statisticItem.param("obj_type", 5);
        } else if (m.C2()) {
            statisticItem.param("obj_type", 6);
        }
        if (aVar.m().T() != null) {
            statisticItem.param("uid", aVar.m().T().getUserId());
        }
        if (m.V() != null) {
            statisticItem.param("obj_id", m.V().oriUgcNid);
        } else {
            statisticItem.param("obj_id", m.y1());
        }
        statisticItem.param("obj_locate", i2);
        TiebaStatic.log(statisticItem);
    }

    public static void b(d.a.m0.r.q.a aVar) {
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_DYNAMIC_CARD_SHOW);
        a2 m = aVar.m();
        if (m.Q1()) {
            statisticItem.param("obj_type", 1);
        } else if (m.T1()) {
            statisticItem.param("obj_type", 2);
        } else if (m.R1()) {
            statisticItem.param("obj_type", 3);
        } else if (m.S1()) {
            statisticItem.param("obj_type", 4);
        } else if (m.Z == 0) {
            statisticItem.param("obj_type", 5);
        } else if (m.C2()) {
            statisticItem.param("obj_type", 6);
        }
        if (m.V() != null) {
            statisticItem.param("obj_id", m.V().oriUgcNid);
        } else {
            statisticItem.param("obj_id", m.y1());
        }
        statisticItem.param("uid", m.T().getUserId());
        TiebaStatic.log(statisticItem);
    }
}
