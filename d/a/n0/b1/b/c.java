package d.a.n0.b1.b;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.YYLiveUtil;
import d.a.m0.r.q.a2;
import java.util.List;
import tbclient.DiscoverHotForum;
import tbclient.DiscoverTabCard;
import tbclient.RecommendForumInfo;
/* loaded from: classes4.dex */
public class c {
    public static void a(a2 a2Var, int i2) {
        TiebaStatic.log(i2 != 1 ? null : d.a.n0.d3.a.n("c13692", a2Var, 3));
    }

    public static void b(View view, d.a.m0.r.q.a aVar, int i2) {
        if (view == null || aVar == null || aVar.m() == null || StringUtils.isNull(aVar.m().y1())) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.CONCERN_TAB_THREAD_CLICK);
        a2 m = aVar.m();
        if (m.h2()) {
            statisticItem.param("obj_type", 4);
        } else if (m.t1) {
            statisticItem.param("obj_type", 5);
        } else if (m.Q1()) {
            statisticItem.param("obj_type", 6);
        } else if (m.R1()) {
            statisticItem.param("obj_type", 7);
        } else if (m.T1()) {
            statisticItem.param("obj_type", 8);
        } else if (m.S1()) {
            statisticItem.param("obj_type", 9);
        } else if (m.getType() == a2.J2) {
            statisticItem.param("obj_type", 1);
        } else if (m.C2()) {
            statisticItem.param("obj_type", 2);
        }
        statisticItem.param("obj_locate", i2);
        statisticItem.param("tid", aVar.m().y1());
        statisticItem.param("fid", aVar.m().c0());
        statisticItem.param("obj_source", 1);
        if (aVar instanceof d.a.n0.z.e0.b) {
            statisticItem.param("obj_param1", ((d.a.n0.z.e0.b) aVar).P() ? 2 : 1);
        }
        if (aVar.m().T() != null) {
            statisticItem.param("uid", aVar.m().T().getUserId());
        }
        if (m.V() != null) {
            statisticItem.param("obj_id", m.V().oriUgcNid);
        } else {
            statisticItem.param("obj_id", m.y1());
        }
        if (aVar.m().r1() != null) {
            int calculateLiveType = YYLiveUtil.calculateLiveType(aVar.m().r1());
            if (aVar.m().r1().mYyExtData != null) {
                TiebaStaticHelper.addYYParam(statisticItem, aVar.m().r1().mYyExtData);
            }
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, calculateLiveType);
        }
        TiebaStatic.log(statisticItem);
        a(m, i2);
    }

    public static boolean c(DiscoverHotForum.Builder builder, long j, boolean z) {
        if (j != 0 && builder != null) {
            List<DiscoverTabCard> list = builder.tab_list;
            if (ListUtils.isEmpty(list)) {
                return false;
            }
            for (int i2 = 0; i2 < list.size(); i2++) {
                DiscoverTabCard.Builder builder2 = new DiscoverTabCard.Builder(list.get(i2));
                List<RecommendForumInfo> list2 = builder2.forum_list;
                if (!ListUtils.isEmpty(list2)) {
                    for (int i3 = 0; i3 < list2.size(); i3++) {
                        RecommendForumInfo.Builder builder3 = new RecommendForumInfo.Builder(list2.get(i3));
                        if (builder3.forum_id.longValue() == j && builder3.is_like.intValue() != z) {
                            builder3.is_like = Integer.valueOf(z ? 1 : 0);
                            list2.set(i3, builder3.build(true));
                            list.set(i2, builder2.build(true));
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
