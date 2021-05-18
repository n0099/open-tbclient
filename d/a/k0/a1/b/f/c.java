package d.a.k0.a1.b.f;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import d.a.c.j.e.n;
import d.a.j0.r.q.a2;
import d.a.j0.r.q.v0;
import d.a.k0.a1.b.f.d;
import d.a.k0.x.e0.k;
import java.util.ArrayList;
import java.util.List;
import tbclient.DiscoverHotForum;
import tbclient.DiscoverTabCard;
import tbclient.RecommendForumInfo;
/* loaded from: classes4.dex */
public class c extends d.a.j0.r.q.a {

    /* renamed from: e  reason: collision with root package name */
    public boolean f51226e = false;

    /* renamed from: f  reason: collision with root package name */
    public List<n> f51227f;

    public static boolean D(DiscoverHotForum discoverHotForum, int i2) {
        Integer num;
        return TbadkCoreApplication.isLogin() && d.a.j0.b.d.T() && discoverHotForum != null && (num = discoverHotForum.floor) != null && (i2 < 0 || i2 == num.intValue() - 1) && !ListUtils.isEmpty(discoverHotForum.tab_list);
    }

    public boolean A() {
        return this.f51226e;
    }

    public boolean B(List<DiscoverTabCard> list) {
        if (ListUtils.isEmpty(list)) {
            return false;
        }
        List<n> arrayList = new ArrayList<>();
        C(arrayList);
        for (int i2 = 0; i2 < list.size(); i2++) {
            DiscoverTabCard discoverTabCard = list.get(i2);
            List<RecommendForumInfo> list2 = discoverTabCard.forum_list;
            if (list2 != null && list2.size() >= 3) {
                d dVar = new d();
                this.f51226e = StringUtils.isNull(discoverTabCard.name) || this.f51226e;
                dVar.f51228e = discoverTabCard.name;
                Boolean bool = discoverTabCard.is_show_order_number;
                dVar.f51229f = bool == null ? false : bool.booleanValue();
                dVar.f51230g = discoverTabCard.jump_name;
                for (int i3 = 0; i3 < discoverTabCard.forum_list.size() && i3 < 3; i3++) {
                    dVar.f51231h[i3] = new d.a();
                    d.a aVar = dVar.f51231h[i3];
                    aVar.s(discoverTabCard.forum_list.get(i3).forum_name);
                    aVar.r(discoverTabCard.forum_list.get(i3).avatar);
                    aVar.v(discoverTabCard.forum_list.get(i3).hot_text);
                    aVar.x(discoverTabCard.forum_list.get(i3).slogan);
                    aVar.q(discoverTabCard.forum_list.get(i3).member_count.intValue());
                    aVar.t(discoverTabCard.forum_list.get(i3).thread_count.intValue());
                    aVar.p(discoverTabCard.forum_list.get(i3).is_like.intValue() == 1);
                    aVar.u(discoverTabCard.forum_list.get(i3).forum_id);
                    aVar.w(discoverTabCard.forum_list.get(i3).hot_thread_id.longValue());
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
        this.f51227f = list;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        return k.v0;
    }

    @Override // d.a.j0.r.q.a
    public v0 h() {
        return null;
    }

    @Override // d.a.j0.r.q.a
    public a2 m() {
        return null;
    }

    public List<n> z() {
        return this.f51227f;
    }
}
