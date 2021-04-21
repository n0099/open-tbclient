package d.b.j0.r1.c.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetVipInfo.VipThemeItem;
import tbclient.GetVipInfo.VipThemeList;
/* loaded from: classes3.dex */
public class i implements d.b.c.j.e.n {

    /* renamed from: h  reason: collision with root package name */
    public static final BdUniqueId f61424h = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public d f61425e;

    /* renamed from: f  reason: collision with root package name */
    public List<j> f61426f;

    /* renamed from: g  reason: collision with root package name */
    public List<j> f61427g;

    public i(VipThemeList vipThemeList) {
        if (vipThemeList == null) {
            return;
        }
        String str = vipThemeList.card_id;
        d dVar = new d();
        this.f61425e = dVar;
        dVar.e(2);
        this.f61425e.d(vipThemeList.class_name);
        this.f61425e.f(vipThemeList.class_url_name);
        this.f61425e.g(vipThemeList.class_url);
        if (vipThemeList.item != null) {
            this.f61426f = new ArrayList();
            for (VipThemeItem vipThemeItem : vipThemeList.item) {
                this.f61426f.add(new j(vipThemeItem));
            }
        }
        if (vipThemeList.item_card != null) {
            this.f61427g = new ArrayList();
            for (VipThemeItem vipThemeItem2 : vipThemeList.item_card) {
                this.f61427g.add(new j(vipThemeItem2));
            }
        }
    }

    @Override // d.b.c.j.e.n
    public BdUniqueId getType() {
        return f61424h;
    }
}
