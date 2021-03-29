package d.b.i0.q1.c.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetVipInfo.VipDailyList;
import tbclient.GetVipInfo.VipThemeItem;
/* loaded from: classes3.dex */
public class g implements d.b.b.j.e.n {

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f59306g = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public d f59307e;

    /* renamed from: f  reason: collision with root package name */
    public List<h> f59308f;

    public g(VipDailyList vipDailyList) {
        List<VipThemeItem> list;
        if (vipDailyList == null || (list = vipDailyList.item) == null || list.size() <= 0) {
            return;
        }
        String str = vipDailyList.card_id;
        d dVar = new d();
        this.f59307e = dVar;
        dVar.e(1);
        this.f59307e.d(vipDailyList.class_name);
        this.f59307e.f(vipDailyList.class_url_name);
        this.f59307e.g(vipDailyList.class_url);
        this.f59308f = new ArrayList();
        for (VipThemeItem vipThemeItem : vipDailyList.item) {
            this.f59308f.add(new h(vipThemeItem));
        }
    }

    @Override // d.b.b.j.e.n
    public BdUniqueId getType() {
        return f59306g;
    }
}
