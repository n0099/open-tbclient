package d.b.j0.r1.c.b;

import com.baidu.adp.BdUniqueId;
import tbclient.GetVipInfo.VipRank;
import tbclient.GetVipInfo.VipUser;
/* loaded from: classes3.dex */
public class p implements d.b.c.j.e.n {

    /* renamed from: f  reason: collision with root package name */
    public static final BdUniqueId f61436f = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public d f61437e;

    public p(VipRank vipRank, VipUser vipUser) {
        if (vipRank == null) {
            return;
        }
        String str = vipRank.card_id;
        d dVar = new d();
        this.f61437e = dVar;
        dVar.d(vipRank.class_name);
        this.f61437e.f(vipRank.class_url_name);
        this.f61437e.g(vipRank.class_url);
        vipRank.my_score_rank.intValue();
        String str2 = vipUser.portrait;
    }

    @Override // d.b.c.j.e.n
    public BdUniqueId getType() {
        return f61436f;
    }
}
