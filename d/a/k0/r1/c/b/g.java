package d.a.k0.r1.c.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetVipInfo.VipDailyList;
import tbclient.GetVipInfo.VipThemeItem;
/* loaded from: classes3.dex */
public class g implements d.a.c.j.e.n {

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f60311g = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public d f60312e;

    /* renamed from: f  reason: collision with root package name */
    public List<h> f60313f;

    public g(VipDailyList vipDailyList) {
        List<VipThemeItem> list;
        if (vipDailyList == null || (list = vipDailyList.item) == null || list.size() <= 0) {
            return;
        }
        String str = vipDailyList.card_id;
        d dVar = new d();
        this.f60312e = dVar;
        dVar.e(1);
        this.f60312e.d(vipDailyList.class_name);
        this.f60312e.f(vipDailyList.class_url_name);
        this.f60312e.g(vipDailyList.class_url);
        this.f60313f = new ArrayList();
        for (VipThemeItem vipThemeItem : vipDailyList.item) {
            this.f60313f.add(new h(vipThemeItem));
        }
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return f60311g;
    }
}
