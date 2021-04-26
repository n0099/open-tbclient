package d.a.j0.r1.c.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetVipInfo.VipBasicList;
import tbclient.GetVipInfo.VipSpecialItem;
/* loaded from: classes3.dex */
public class c implements d.a.c.j.e.n {

    /* renamed from: i  reason: collision with root package name */
    public static final BdUniqueId f59553i = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public d f59554e;

    /* renamed from: f  reason: collision with root package name */
    public List<VipSpecialItem> f59555f;

    /* renamed from: g  reason: collision with root package name */
    public int f59556g;

    /* renamed from: h  reason: collision with root package name */
    public String f59557h;

    public c(VipBasicList vipBasicList) {
        this.f59556g = 0;
        this.f59557h = "";
        if (vipBasicList == null || vipBasicList.item.size() <= 0) {
            return;
        }
        this.f59557h = vipBasicList.card_id;
        this.f59556g = vipBasicList.card_type.intValue();
        d dVar = new d();
        this.f59554e = dVar;
        dVar.e(5);
        this.f59554e.d(vipBasicList.class_name);
        this.f59554e.f(vipBasicList.class_url_name);
        this.f59554e.g(vipBasicList.class_url);
        this.f59555f = new ArrayList();
        for (VipSpecialItem vipSpecialItem : vipBasicList.item) {
            this.f59555f.add(vipSpecialItem);
        }
    }

    public List<VipSpecialItem> c() {
        return this.f59555f;
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return f59553i;
    }
}
