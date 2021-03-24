package d.b.i0.q1.c.b;

import com.baidu.adp.BdUniqueId;
import tbclient.GetVipInfo.VipRank;
import tbclient.GetVipInfo.VipUser;
/* loaded from: classes3.dex */
public class p implements d.b.b.j.e.n {

    /* renamed from: f  reason: collision with root package name */
    public static final BdUniqueId f59320f = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public d f59321e;

    public p(VipRank vipRank, VipUser vipUser) {
        if (vipRank == null) {
            return;
        }
        String str = vipRank.card_id;
        d dVar = new d();
        this.f59321e = dVar;
        dVar.d(vipRank.class_name);
        this.f59321e.f(vipRank.class_url_name);
        this.f59321e.g(vipRank.class_url);
        vipRank.my_score_rank.intValue();
        String str2 = vipUser.portrait;
    }

    @Override // d.b.b.j.e.n
    public BdUniqueId getType() {
        return f59320f;
    }
}
