package d.b.i0.q1.c.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetVipInfo.VipBannerItem;
import tbclient.GetVipInfo.VipBannerList;
/* loaded from: classes3.dex */
public class a implements d.b.b.j.e.n {

    /* renamed from: f  reason: collision with root package name */
    public static final BdUniqueId f59290f = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public List<b> f59291e;

    public a(VipBannerList vipBannerList) {
        if (vipBannerList == null || vipBannerList.item == null) {
            return;
        }
        String str = vipBannerList.card_id;
        this.f59291e = new ArrayList();
        for (VipBannerItem vipBannerItem : vipBannerList.item) {
            this.f59291e.add(new b(vipBannerItem));
        }
    }

    @Override // d.b.b.j.e.n
    public BdUniqueId getType() {
        return f59290f;
    }
}
