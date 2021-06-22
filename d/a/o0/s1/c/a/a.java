package d.a.o0.s1.c.a;

import com.baidu.adp.BdUniqueId;
import d.a.c.k.e.n;
import tbclient.GetVipInfo.DataRes;
import tbclient.GetVipInfo.VipUpgrade;
/* loaded from: classes4.dex */
public class a implements n {

    /* renamed from: e  reason: collision with root package name */
    public static final BdUniqueId f64232e = BdUniqueId.gen();

    public void b(DataRes dataRes) {
        VipUpgrade vipUpgrade;
        if (dataRes == null || (vipUpgrade = dataRes.upgrade) == null) {
            return;
        }
        String str = vipUpgrade.svip;
        String str2 = vipUpgrade.link;
        String str3 = vipUpgrade.button;
        String str4 = vipUpgrade.text;
        vipUpgrade.pay.intValue();
        dataRes.upgrade.normal.intValue();
        VipUpgrade vipUpgrade2 = dataRes.upgrade;
        String str5 = vipUpgrade2.card_id;
        String str6 = vipUpgrade2.expire;
    }

    @Override // d.a.c.k.e.n
    public BdUniqueId getType() {
        return f64232e;
    }
}
