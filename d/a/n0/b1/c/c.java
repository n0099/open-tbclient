package d.a.n0.b1.c;

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
        if (view == null || aVar == null || aVar.i() == null || StringUtils.isNull(aVar.i().z1())) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.CONCERN_TAB_THREAD_CLICK);
        a2 i3 = aVar.i();
        if (i3.i2()) {
            statisticItem.param("obj_type", 4);
        } else if (i3.u1) {
            statisticItem.param("obj_type", 5);
        } else if (i3.R1()) {
            statisticItem.param("obj_type", 6);
        } else if (i3.S1()) {
            statisticItem.param("obj_type", 7);
        } else if (i3.U1()) {
            statisticItem.param("obj_type", 8);
        } else if (i3.T1()) {
            statisticItem.param("obj_type", 9);
        } else if (i3.getType() == a2.M2) {
            statisticItem.param("obj_type", 1);
        } else if (i3.D2()) {
            statisticItem.param("obj_type", 2);
        }
        statisticItem.param("obj_locate", i2);
        statisticItem.param("tid", aVar.i().z1());
        statisticItem.param("fid", aVar.i().c0());
        statisticItem.param("obj_source", 1);
        if (aVar instanceof d.a.n0.z.e0.b) {
            statisticItem.param("obj_param1", ((d.a.n0.z.e0.b) aVar).P() ? 2 : 1);
        }
        if (aVar.i().T() != null) {
            statisticItem.param("uid", aVar.i().T().getUserId());
        }
        if (i3.V() != null) {
            statisticItem.param("obj_id", i3.V().oriUgcNid);
        } else {
            statisticItem.param("obj_id", i3.z1());
        }
        if (aVar.i().s1() != null) {
            int calculateLiveType = YYLiveUtil.calculateLiveType(aVar.i().s1());
            if (aVar.i().s1().mYyExtData != null) {
                TiebaStaticHelper.addYYParam(statisticItem, aVar.i().s1().mYyExtData);
            }
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, calculateLiveType);
        }
        TiebaStatic.log(statisticItem);
        a(i3, i2);
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
