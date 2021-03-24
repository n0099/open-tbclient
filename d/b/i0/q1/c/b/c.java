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
    public d f59294e;

    /* renamed from: f  reason: collision with root package name */
    public List<VipSpecialItem> f59295f;

    /* renamed from: g  reason: collision with root package name */
    public int f59296g;

    /* renamed from: h  reason: collision with root package name */
    public String f59297h;

    public c(VipBasicList vipBasicList) {
        this.f59296g = 0;
        this.f59297h = "";
        if (vipBasicList == null || vipBasicList.item.size() <= 0) {
            return;
        }
        this.f59297h = vipBasicList.card_id;
        this.f59296g = vipBasicList.card_type.intValue();
        d dVar = new d();
        this.f59294e = dVar;
        dVar.e(5);
        this.f59294e.d(vipBasicList.class_name);
        this.f59294e.f(vipBasicList.class_url_name);
        this.f59294e.g(vipBasicList.class_url);
        this.f59295f = new ArrayList();
        for (VipSpecialItem vipSpecialItem : vipBasicList.item) {
            this.f59295f.add(vipSpecialItem);
        }
    }

    public List<VipSpecialItem> a() {
        return this.f59295f;
    }

    @Override // d.b.b.j.e.n
    public BdUniqueId getType() {
        return i;
    }
}
