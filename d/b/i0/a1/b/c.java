package d.b.i0.a1.b;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import d.b.h0.r.q.a2;
import java.util.List;
import tbclient.DiscoverHotForum;
import tbclient.DiscoverTabCard;
import tbclient.RecommendForumInfo;
/* loaded from: classes4.dex */
public class c {
    public static void a(a2 a2Var, int i) {
        TiebaStatic.log(i != 1 ? null : d.b.i0.c3.a.n("c13692", a2Var, 3));
    }

    public static void b(View view, d.b.h0.r.q.a aVar, int i) {
        if (view == null || aVar == null || aVar.n() == null || StringUtils.isNull(aVar.n().w1())) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.CONCERN_TAB_THREAD_CLICK);
        a2 n = aVar.n();
        if (n.f2()) {
            statisticItem.param("obj_type", 4);
        } else if (n.s1) {
            statisticItem.param("obj_type", 5);
        } else if (n.O1()) {
            statisticItem.param("obj_type", 6);
        } else if (n.P1()) {
            statisticItem.param("obj_type", 7);
        } else if (n.R1()) {
            statisticItem.param("obj_type", 8);
        } else if (n.Q1()) {
            statisticItem.param("obj_type", 9);
        } else if (n.getType() == a2.H2) {
            statisticItem.param("obj_type", 1);
        } else if (n.z2()) {
            statisticItem.param("obj_type", 2);
        }
        statisticItem.param("obj_locate", i);
        statisticItem.param("tid", aVar.n().w1());
        statisticItem.param("fid", aVar.n().c0());
        statisticItem.param("obj_source", 1);
        if (aVar instanceof d.b.i0.x.e0.b) {
            statisticItem.param("obj_param1", ((d.b.i0.x.e0.b) aVar).P() ? 2 : 1);
        }
        if (aVar.n().T() != null) {
            statisticItem.param("uid", aVar.n().T().getUserId());
        }
        if (n.V() != null) {
            statisticItem.param("obj_id", n.V().oriUgcNid);
        } else {
            statisticItem.param("obj_id", n.w1());
        }
        TiebaStatic.log(statisticItem);
        a(n, i);
    }

    public static boolean c(DiscoverHotForum.Builder builder, long j, boolean z) {
        if (j != 0 && builder != null) {
            List<DiscoverTabCard> list = builder.tab_list;
            if (ListUtils.isEmpty(list)) {
                return false;
            }
            for (int i = 0; i < list.size(); i++) {
                DiscoverTabCard.Builder builder2 = new DiscoverTabCard.Builder(list.get(i));
                List<RecommendForumInfo> list2 = builder2.forum_list;
                if (!ListUtils.isEmpty(list2)) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        RecommendForumInfo.Builder builder3 = new RecommendForumInfo.Builder(list2.get(i2));
                        if (builder3.forum_id.longValue() == j && builder3.is_like.intValue() != z) {
                            builder3.is_like = Integer.valueOf(z ? 1 : 0);
                            list2.set(i2, builder3.build(true));
                            list.set(i, builder2.build(true));
                            return true;
                        }
                    }
                    continue;
                }
            }
        }
        return false;
    }
}
