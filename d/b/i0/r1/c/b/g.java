package d.b.i0.r1.c.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetVipInfo.VipDailyList;
import tbclient.GetVipInfo.VipThemeItem;
/* loaded from: classes3.dex */
public class g implements d.b.c.j.e.n {

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f61000g = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public d f61001e;

    /* renamed from: f  reason: collision with root package name */
    public List<h> f61002f;

    public g(VipDailyList vipDailyList) {
        List<VipThemeItem> list;
        if (vipDailyList == null || (list = vipDailyList.item) == null || list.size() <= 0) {
            return;
        }
        String str = vipDailyList.card_id;
        d dVar = new d();
        this.f61001e = dVar;
        dVar.e(1);
        this.f61001e.d(vipDailyList.class_name);
        this.f61001e.f(vipDailyList.class_url_name);
        this.f61001e.g(vipDailyList.class_url);
        this.f61002f = new ArrayList();
        for (VipThemeItem vipThemeItem : vipDailyList.item) {
            this.f61002f.add(new h(vipThemeItem));
        }
    }

    @Override // d.b.c.j.e.n
    public BdUniqueId getType() {
        return f61000g;
    }
}
