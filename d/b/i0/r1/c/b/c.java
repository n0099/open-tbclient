package d.b.i0.r1.c.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetVipInfo.VipBasicList;
import tbclient.GetVipInfo.VipSpecialItem;
/* loaded from: classes3.dex */
public class c implements d.b.c.j.e.n {
    public static final BdUniqueId i = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public d f60989e;

    /* renamed from: f  reason: collision with root package name */
    public List<VipSpecialItem> f60990f;

    /* renamed from: g  reason: collision with root package name */
    public int f60991g;

    /* renamed from: h  reason: collision with root package name */
    public String f60992h;

    public c(VipBasicList vipBasicList) {
        this.f60991g = 0;
        this.f60992h = "";
        if (vipBasicList == null || vipBasicList.item.size() <= 0) {
            return;
        }
        this.f60992h = vipBasicList.card_id;
        this.f60991g = vipBasicList.card_type.intValue();
        d dVar = new d();
        this.f60989e = dVar;
        dVar.e(5);
        this.f60989e.d(vipBasicList.class_name);
        this.f60989e.f(vipBasicList.class_url_name);
        this.f60989e.g(vipBasicList.class_url);
        this.f60990f = new ArrayList();
        for (VipSpecialItem vipSpecialItem : vipBasicList.item) {
            this.f60990f.add(vipSpecialItem);
        }
    }

    public List<VipSpecialItem> a() {
        return this.f60990f;
    }

    @Override // d.b.c.j.e.n
    public BdUniqueId getType() {
        return i;
    }
}
