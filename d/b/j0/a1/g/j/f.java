package d.b.j0.a1.g.j;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import d.b.i0.r.q.a2;
import d.b.i0.r.q.v0;
import java.util.ArrayList;
import java.util.List;
import tbclient.AlaLiveInfo;
import tbclient.Personalized.UserFollowLive;
/* loaded from: classes4.dex */
public class f extends d.b.i0.r.q.a {

    /* renamed from: f  reason: collision with root package name */
    public static final BdUniqueId f53229f = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public List<AlaLiveInfo> f53230e = new ArrayList();

    public StatisticItem A() {
        StatisticItem statisticItem = new StatisticItem("c13620");
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        statisticItem.param("fid", 0);
        return statisticItem;
    }

    public void B(UserFollowLive userFollowLive) {
        this.f53230e.clear();
        if (userFollowLive == null || userFollowLive._switch.intValue() == 0 || ListUtils.isEmpty(userFollowLive.user_follow_live)) {
            return;
        }
        this.f53230e.addAll(userFollowLive.user_follow_live);
    }

    @Override // d.b.i0.r.q.a
    public v0 g() {
        return null;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.c.j.e.n
    public BdUniqueId getType() {
        return f53229f;
    }

    @Override // d.b.i0.r.q.a
    public a2 n() {
        return null;
    }

    public List<AlaLiveInfo> z() {
        return this.f53230e;
    }
}
