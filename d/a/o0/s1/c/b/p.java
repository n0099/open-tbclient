package d.a.o0.s1.c.b;

import com.baidu.adp.BdUniqueId;
import tbclient.GetVipInfo.VipRank;
import tbclient.GetVipInfo.VipUser;
/* loaded from: classes4.dex */
public class p implements d.a.c.k.e.n {

    /* renamed from: f  reason: collision with root package name */
    public static final BdUniqueId f64265f = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public d f64266e;

    public p(VipRank vipRank, VipUser vipUser) {
        if (vipRank == null) {
            return;
        }
        String str = vipRank.card_id;
        d dVar = new d();
        this.f64266e = dVar;
        dVar.d(vipRank.class_name);
        this.f64266e.f(vipRank.class_url_name);
        this.f64266e.g(vipRank.class_url);
        vipRank.my_score_rank.intValue();
        String str2 = vipUser.portrait;
    }

    @Override // d.a.c.k.e.n
    public BdUniqueId getType() {
        return f64265f;
    }
}
