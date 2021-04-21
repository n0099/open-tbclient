package d.b.j0.r1.c.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetVipInfo.VipDailyList;
import tbclient.GetVipInfo.VipThemeItem;
/* loaded from: classes3.dex */
public class g implements d.b.c.j.e.n {

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f61421g = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public d f61422e;

    /* renamed from: f  reason: collision with root package name */
    public List<h> f61423f;

    public g(VipDailyList vipDailyList) {
        List<VipThemeItem> list;
        if (vipDailyList == null || (list = vipDailyList.item) == null || list.size() <= 0) {
            return;
        }
        String str = vipDailyList.card_id;
        d dVar = new d();
        this.f61422e = dVar;
        dVar.e(1);
        this.f61422e.d(vipDailyList.class_name);
        this.f61422e.f(vipDailyList.class_url_name);
        this.f61422e.g(vipDailyList.class_url);
        this.f61423f = new ArrayList();
        for (VipThemeItem vipThemeItem : vipDailyList.item) {
            this.f61423f.add(new h(vipThemeItem));
        }
    }

    @Override // d.b.c.j.e.n
    public BdUniqueId getType() {
        return f61421g;
    }
}
