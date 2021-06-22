package d.a.o0.s1.c.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetVipInfo.VipThemeItem;
import tbclient.GetVipInfo.VipThemeList;
/* loaded from: classes4.dex */
public class i implements d.a.c.k.e.n {

    /* renamed from: h  reason: collision with root package name */
    public static final BdUniqueId f64253h = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public d f64254e;

    /* renamed from: f  reason: collision with root package name */
    public List<j> f64255f;

    /* renamed from: g  reason: collision with root package name */
    public List<j> f64256g;

    public i(VipThemeList vipThemeList) {
        if (vipThemeList == null) {
            return;
        }
        String str = vipThemeList.card_id;
        d dVar = new d();
        this.f64254e = dVar;
        dVar.e(2);
        this.f64254e.d(vipThemeList.class_name);
        this.f64254e.f(vipThemeList.class_url_name);
        this.f64254e.g(vipThemeList.class_url);
        if (vipThemeList.item != null) {
            this.f64255f = new ArrayList();
            for (VipThemeItem vipThemeItem : vipThemeList.item) {
                this.f64255f.add(new j(vipThemeItem));
            }
        }
        if (vipThemeList.item_card != null) {
            this.f64256g = new ArrayList();
            for (VipThemeItem vipThemeItem2 : vipThemeList.item_card) {
                this.f64256g.add(new j(vipThemeItem2));
            }
        }
    }

    @Override // d.a.c.k.e.n
    public BdUniqueId getType() {
        return f64253h;
    }
}
