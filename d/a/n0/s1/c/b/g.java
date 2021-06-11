package d.a.n0.s1.c.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetVipInfo.VipDailyList;
import tbclient.GetVipInfo.VipThemeItem;
/* loaded from: classes3.dex */
public class g implements d.a.c.k.e.n {

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f64125g = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public d f64126e;

    /* renamed from: f  reason: collision with root package name */
    public List<h> f64127f;

    public g(VipDailyList vipDailyList) {
        List<VipThemeItem> list;
        if (vipDailyList == null || (list = vipDailyList.item) == null || list.size() <= 0) {
            return;
        }
        String str = vipDailyList.card_id;
        d dVar = new d();
        this.f64126e = dVar;
        dVar.e(1);
        this.f64126e.d(vipDailyList.class_name);
        this.f64126e.f(vipDailyList.class_url_name);
        this.f64126e.g(vipDailyList.class_url);
        this.f64127f = new ArrayList();
        for (VipThemeItem vipThemeItem : vipDailyList.item) {
            this.f64127f.add(new h(vipThemeItem));
        }
    }

    @Override // d.a.c.k.e.n
    public BdUniqueId getType() {
        return f64125g;
    }
}
