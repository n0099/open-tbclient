package d.a.j0.r1.c.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetVipInfo.VipThemeItem;
import tbclient.GetVipInfo.VipThemeList;
/* loaded from: classes3.dex */
public class i implements d.a.c.j.e.n {

    /* renamed from: h  reason: collision with root package name */
    public static final BdUniqueId f59569h = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public d f59570e;

    /* renamed from: f  reason: collision with root package name */
    public List<j> f59571f;

    /* renamed from: g  reason: collision with root package name */
    public List<j> f59572g;

    public i(VipThemeList vipThemeList) {
        if (vipThemeList == null) {
            return;
        }
        String str = vipThemeList.card_id;
        d dVar = new d();
        this.f59570e = dVar;
        dVar.e(2);
        this.f59570e.d(vipThemeList.class_name);
        this.f59570e.f(vipThemeList.class_url_name);
        this.f59570e.g(vipThemeList.class_url);
        if (vipThemeList.item != null) {
            this.f59571f = new ArrayList();
            for (VipThemeItem vipThemeItem : vipThemeList.item) {
                this.f59571f.add(new j(vipThemeItem));
            }
        }
        if (vipThemeList.item_card != null) {
            this.f59572g = new ArrayList();
            for (VipThemeItem vipThemeItem2 : vipThemeList.item_card) {
                this.f59572g.add(new j(vipThemeItem2));
            }
        }
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return f59569h;
    }
}
