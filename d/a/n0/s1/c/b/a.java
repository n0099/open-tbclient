package d.a.n0.s1.c.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetVipInfo.VipBannerItem;
import tbclient.GetVipInfo.VipBannerList;
/* loaded from: classes3.dex */
public class a implements d.a.c.j.e.n {

    /* renamed from: f  reason: collision with root package name */
    public static final BdUniqueId f60417f = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public List<b> f60418e;

    public a(VipBannerList vipBannerList) {
        if (vipBannerList == null || vipBannerList.item == null) {
            return;
        }
        String str = vipBannerList.card_id;
        this.f60418e = new ArrayList();
        for (VipBannerItem vipBannerItem : vipBannerList.item) {
            this.f60418e.add(new b(vipBannerItem));
        }
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return f60417f;
    }
}
