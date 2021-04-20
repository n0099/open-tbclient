package d.b.i0.r1.c.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetVipInfo.VipThemeItem;
import tbclient.GetVipInfo.VipThemeList;
/* loaded from: classes3.dex */
public class i implements d.b.c.j.e.n {

    /* renamed from: h  reason: collision with root package name */
    public static final BdUniqueId f61003h = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public d f61004e;

    /* renamed from: f  reason: collision with root package name */
    public List<j> f61005f;

    /* renamed from: g  reason: collision with root package name */
    public List<j> f61006g;

    public i(VipThemeList vipThemeList) {
        if (vipThemeList == null) {
            return;
        }
        String str = vipThemeList.card_id;
        d dVar = new d();
        this.f61004e = dVar;
        dVar.e(2);
        this.f61004e.d(vipThemeList.class_name);
        this.f61004e.f(vipThemeList.class_url_name);
        this.f61004e.g(vipThemeList.class_url);
        if (vipThemeList.item != null) {
            this.f61005f = new ArrayList();
            for (VipThemeItem vipThemeItem : vipThemeList.item) {
                this.f61005f.add(new j(vipThemeItem));
            }
        }
        if (vipThemeList.item_card != null) {
            this.f61006g = new ArrayList();
            for (VipThemeItem vipThemeItem2 : vipThemeList.item_card) {
                this.f61006g.add(new j(vipThemeItem2));
            }
        }
    }

    @Override // d.b.c.j.e.n
    public BdUniqueId getType() {
        return f61003h;
    }
}
