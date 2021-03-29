package d.b.i0.q1.c.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetVipInfo.VipBannerItem;
import tbclient.GetVipInfo.VipBannerList;
/* loaded from: classes3.dex */
public class a implements d.b.b.j.e.n {

    /* renamed from: f  reason: collision with root package name */
    public static final BdUniqueId f59291f = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public List<b> f59292e;

    public a(VipBannerList vipBannerList) {
        if (vipBannerList == null || vipBannerList.item == null) {
            return;
        }
        String str = vipBannerList.card_id;
        this.f59292e = new ArrayList();
        for (VipBannerItem vipBannerItem : vipBannerList.item) {
            this.f59292e.add(new b(vipBannerItem));
        }
    }

    @Override // d.b.b.j.e.n
    public BdUniqueId getType() {
        return f59291f;
    }
}
