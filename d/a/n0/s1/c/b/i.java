package d.a.n0.s1.c.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetVipInfo.VipThemeItem;
import tbclient.GetVipInfo.VipThemeList;
/* loaded from: classes3.dex */
public class i implements d.a.c.j.e.n {

    /* renamed from: h  reason: collision with root package name */
    public static final BdUniqueId f60437h = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public d f60438e;

    /* renamed from: f  reason: collision with root package name */
    public List<j> f60439f;

    /* renamed from: g  reason: collision with root package name */
    public List<j> f60440g;

    public i(VipThemeList vipThemeList) {
        if (vipThemeList == null) {
            return;
        }
        String str = vipThemeList.card_id;
        d dVar = new d();
        this.f60438e = dVar;
        dVar.e(2);
        this.f60438e.d(vipThemeList.class_name);
        this.f60438e.f(vipThemeList.class_url_name);
        this.f60438e.g(vipThemeList.class_url);
        if (vipThemeList.item != null) {
            this.f60439f = new ArrayList();
            for (VipThemeItem vipThemeItem : vipThemeList.item) {
                this.f60439f.add(new j(vipThemeItem));
            }
        }
        if (vipThemeList.item_card != null) {
            this.f60440g = new ArrayList();
            for (VipThemeItem vipThemeItem2 : vipThemeList.item_card) {
                this.f60440g.add(new j(vipThemeItem2));
            }
        }
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return f60437h;
    }
}
