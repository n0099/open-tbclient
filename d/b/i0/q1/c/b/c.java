package d.b.i0.q1.c.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetVipInfo.VipBasicList;
import tbclient.GetVipInfo.VipSpecialItem;
/* loaded from: classes3.dex */
public class c implements d.b.b.j.e.n {
    public static final BdUniqueId i = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public d f59295e;

    /* renamed from: f  reason: collision with root package name */
    public List<VipSpecialItem> f59296f;

    /* renamed from: g  reason: collision with root package name */
    public int f59297g;

    /* renamed from: h  reason: collision with root package name */
    public String f59298h;

    public c(VipBasicList vipBasicList) {
        this.f59297g = 0;
        this.f59298h = "";
        if (vipBasicList == null || vipBasicList.item.size() <= 0) {
            return;
        }
        this.f59298h = vipBasicList.card_id;
        this.f59297g = vipBasicList.card_type.intValue();
        d dVar = new d();
        this.f59295e = dVar;
        dVar.e(5);
        this.f59295e.d(vipBasicList.class_name);
        this.f59295e.f(vipBasicList.class_url_name);
        this.f59295e.g(vipBasicList.class_url);
        this.f59296f = new ArrayList();
        for (VipSpecialItem vipSpecialItem : vipBasicList.item) {
            this.f59296f.add(vipSpecialItem);
        }
    }

    public List<VipSpecialItem> a() {
        return this.f59296f;
    }

    @Override // d.b.b.j.e.n
    public BdUniqueId getType() {
        return i;
    }
}
