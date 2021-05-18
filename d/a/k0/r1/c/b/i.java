package d.a.k0.r1.c.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetVipInfo.VipThemeItem;
import tbclient.GetVipInfo.VipThemeList;
/* loaded from: classes3.dex */
public class i implements d.a.c.j.e.n {

    /* renamed from: h  reason: collision with root package name */
    public static final BdUniqueId f60314h = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public d f60315e;

    /* renamed from: f  reason: collision with root package name */
    public List<j> f60316f;

    /* renamed from: g  reason: collision with root package name */
    public List<j> f60317g;

    public i(VipThemeList vipThemeList) {
        if (vipThemeList == null) {
            return;
        }
        String str = vipThemeList.card_id;
        d dVar = new d();
        this.f60315e = dVar;
        dVar.e(2);
        this.f60315e.d(vipThemeList.class_name);
        this.f60315e.f(vipThemeList.class_url_name);
        this.f60315e.g(vipThemeList.class_url);
        if (vipThemeList.item != null) {
            this.f60316f = new ArrayList();
            for (VipThemeItem vipThemeItem : vipThemeList.item) {
                this.f60316f.add(new j(vipThemeItem));
            }
        }
        if (vipThemeList.item_card != null) {
            this.f60317g = new ArrayList();
            for (VipThemeItem vipThemeItem2 : vipThemeList.item_card) {
                this.f60317g.add(new j(vipThemeItem2));
            }
        }
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return f60314h;
    }
}
