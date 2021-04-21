package d.b.j0.a1.b.f;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import d.b.c.j.e.n;
import d.b.i0.r.q.a2;
import d.b.i0.r.q.v0;
import d.b.j0.a1.b.f.d;
import d.b.j0.x.e0.k;
import java.util.ArrayList;
import java.util.List;
import tbclient.DiscoverHotForum;
import tbclient.DiscoverTabCard;
import tbclient.RecommendForumInfo;
/* loaded from: classes4.dex */
public class c extends d.b.i0.r.q.a {

    /* renamed from: e  reason: collision with root package name */
    public boolean f52834e = false;

    /* renamed from: f  reason: collision with root package name */
    public List<n> f52835f;

    public static boolean D(DiscoverHotForum discoverHotForum, int i) {
        Integer num;
        return TbadkCoreApplication.isLogin() && d.b.i0.b.d.S() && discoverHotForum != null && (num = discoverHotForum.floor) != null && (i < 0 || i == num.intValue() - 1) && !ListUtils.isEmpty(discoverHotForum.tab_list);
    }

    public boolean A() {
        return this.f52834e;
    }

    public boolean B(List<DiscoverTabCard> list) {
        if (ListUtils.isEmpty(list)) {
            return false;
        }
        List<n> arrayList = new ArrayList<>();
        C(arrayList);
        for (int i = 0; i < list.size(); i++) {
            DiscoverTabCard discoverTabCard = list.get(i);
            List<RecommendForumInfo> list2 = discoverTabCard.forum_list;
            if (list2 != null && list2.size() >= 3) {
                d dVar = new d();
                this.f52834e = StringUtils.isNull(discoverTabCard.name) || this.f52834e;
                dVar.f52836e = discoverTabCard.name;
                Boolean bool = discoverTabCard.is_show_order_number;
                dVar.f52837f = bool == null ? false : bool.booleanValue();
                dVar.f52838g = discoverTabCard.jump_name;
                for (int i2 = 0; i2 < discoverTabCard.forum_list.size() && i2 < 3; i2++) {
                    dVar.f52839h[i2] = new d.a();
                    d.a aVar = dVar.f52839h[i2];
                    aVar.s(discoverTabCard.forum_list.get(i2).forum_name);
                    aVar.r(discoverTabCard.forum_list.get(i2).avatar);
                    aVar.v(discoverTabCard.forum_list.get(i2).hot_text);
                    aVar.x(discoverTabCard.forum_list.get(i2).slogan);
                    aVar.q(discoverTabCard.forum_list.get(i2).member_count.intValue());
                    aVar.t(discoverTabCard.forum_list.get(i2).thread_count.intValue());
                    aVar.p(discoverTabCard.forum_list.get(i2).is_like.intValue() == 1);
                    aVar.u(discoverTabCard.forum_list.get(i2).forum_id);
                    aVar.w(discoverTabCard.forum_list.get(i2).hot_thread_id.longValue());
                }
                arrayList.add(dVar);
                if (arrayList.size() >= 6) {
                    break;
                }
            }
        }
        return arrayList.size() > 0;
    }

    public void C(List<n> list) {
        this.f52835f = list;
    }

    @Override // d.b.i0.r.q.a
    public v0 g() {
        return null;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.c.j.e.n
    public BdUniqueId getType() {
        return k.u0;
    }

    @Override // d.b.i0.r.q.a
    public a2 n() {
        return null;
    }

    public List<n> z() {
        return this.f52835f;
    }
}
