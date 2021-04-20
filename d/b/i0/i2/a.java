package d.b.i0.i2;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import d.b.h0.r.q.a2;
/* loaded from: classes3.dex */
public class a {
    public static void a(View view, d.b.h0.r.q.a aVar, int i) {
        if (view == null || aVar == null || aVar.n() == null || StringUtils.isNull(aVar.n().w1())) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_DYNAMIC_CARD_CLICK);
        statisticItem.param("obj_source", 3);
        a2 n = aVar.n();
        if (n.O1()) {
            statisticItem.param("obj_type", 1);
        } else if (n.R1()) {
            statisticItem.param("obj_type", 2);
        } else if (n.P1()) {
            statisticItem.param("obj_type", 3);
        } else if (n.Q1()) {
            statisticItem.param("obj_type", 4);
        } else if (n.Z == 0) {
            statisticItem.param("obj_type", 5);
        } else if (n.z2()) {
            statisticItem.param("obj_type", 6);
        }
        if (aVar.n().T() != null) {
            statisticItem.param("uid", aVar.n().T().getUserId());
        }
        if (n.V() != null) {
            statisticItem.param("obj_id", n.V().oriUgcNid);
        } else {
            statisticItem.param("obj_id", n.w1());
        }
        statisticItem.param("obj_locate", i);
        TiebaStatic.log(statisticItem);
    }

    public static void b(d.b.h0.r.q.a aVar) {
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_DYNAMIC_CARD_SHOW);
        a2 n = aVar.n();
        if (n.O1()) {
            statisticItem.param("obj_type", 1);
        } else if (n.R1()) {
            statisticItem.param("obj_type", 2);
        } else if (n.P1()) {
            statisticItem.param("obj_type", 3);
        } else if (n.Q1()) {
            statisticItem.param("obj_type", 4);
        } else if (n.Z == 0) {
            statisticItem.param("obj_type", 5);
        } else if (n.z2()) {
            statisticItem.param("obj_type", 6);
        }
        if (n.V() != null) {
            statisticItem.param("obj_id", n.V().oriUgcNid);
        } else {
            statisticItem.param("obj_id", n.w1());
        }
        statisticItem.param("uid", n.T().getUserId());
        TiebaStatic.log(statisticItem);
    }
}
