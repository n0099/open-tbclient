package d.a.o0.b1.h.j;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import d.a.n0.r.q.a2;
import d.a.n0.r.q.v0;
import java.util.ArrayList;
import java.util.List;
import tbclient.AlaLiveInfo;
import tbclient.Personalized.UserFollowLive;
/* loaded from: classes4.dex */
public class f extends d.a.n0.r.q.a {

    /* renamed from: f  reason: collision with root package name */
    public static final BdUniqueId f55619f = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public List<AlaLiveInfo> f55620e = new ArrayList();

    public StatisticItem A() {
        StatisticItem statisticItem = new StatisticItem("c13620");
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        statisticItem.param("fid", 0);
        return statisticItem;
    }

    public void B(UserFollowLive userFollowLive) {
        this.f55620e.clear();
        if (userFollowLive == null || userFollowLive._switch.intValue() == 0 || ListUtils.isEmpty(userFollowLive.user_follow_live)) {
            return;
        }
        this.f55620e.addAll(userFollowLive.user_follow_live);
    }

    @Override // d.a.n0.r.q.a
    public v0 c() {
        return null;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.k.e.n
    public BdUniqueId getType() {
        return f55619f;
    }

    @Override // d.a.n0.r.q.a
    public a2 i() {
        return null;
    }

    public List<AlaLiveInfo> z() {
        return this.f55620e;
    }
}
