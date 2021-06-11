package d.a.n0.s1.c.b;

import com.baidu.adp.BdUniqueId;
import tbclient.GetVipInfo.VipRank;
import tbclient.GetVipInfo.VipUser;
/* loaded from: classes3.dex */
public class p implements d.a.c.k.e.n {

    /* renamed from: f  reason: collision with root package name */
    public static final BdUniqueId f64140f = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public d f64141e;

    public p(VipRank vipRank, VipUser vipUser) {
        if (vipRank == null) {
            return;
        }
        String str = vipRank.card_id;
        d dVar = new d();
        this.f64141e = dVar;
        dVar.d(vipRank.class_name);
        this.f64141e.f(vipRank.class_url_name);
        this.f64141e.g(vipRank.class_url);
        vipRank.my_score_rank.intValue();
        String str2 = vipUser.portrait;
    }

    @Override // d.a.c.k.e.n
    public BdUniqueId getType() {
        return f64140f;
    }
}
