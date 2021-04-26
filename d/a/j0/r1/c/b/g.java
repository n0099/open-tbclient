package d.a.j0.r1.c.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetVipInfo.VipDailyList;
import tbclient.GetVipInfo.VipThemeItem;
/* loaded from: classes3.dex */
public class g implements d.a.c.j.e.n {

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f59566g = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public d f59567e;

    /* renamed from: f  reason: collision with root package name */
    public List<h> f59568f;

    public g(VipDailyList vipDailyList) {
        List<VipThemeItem> list;
        if (vipDailyList == null || (list = vipDailyList.item) == null || list.size() <= 0) {
            return;
        }
        String str = vipDailyList.card_id;
        d dVar = new d();
        this.f59567e = dVar;
        dVar.e(1);
        this.f59567e.d(vipDailyList.class_name);
        this.f59567e.f(vipDailyList.class_url_name);
        this.f59567e.g(vipDailyList.class_url);
        this.f59568f = new ArrayList();
        for (VipThemeItem vipThemeItem : vipDailyList.item) {
            this.f59568f.add(new h(vipThemeItem));
        }
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return f59566g;
    }
}
