package d.a.k0.r1.c.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetVipInfo.VipBasicList;
import tbclient.GetVipInfo.VipSpecialItem;
/* loaded from: classes3.dex */
public class c implements d.a.c.j.e.n {

    /* renamed from: i  reason: collision with root package name */
    public static final BdUniqueId f60298i = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public d f60299e;

    /* renamed from: f  reason: collision with root package name */
    public List<VipSpecialItem> f60300f;

    /* renamed from: g  reason: collision with root package name */
    public int f60301g;

    /* renamed from: h  reason: collision with root package name */
    public String f60302h;

    public c(VipBasicList vipBasicList) {
        this.f60301g = 0;
        this.f60302h = "";
        if (vipBasicList == null || vipBasicList.item.size() <= 0) {
            return;
        }
        this.f60302h = vipBasicList.card_id;
        this.f60301g = vipBasicList.card_type.intValue();
        d dVar = new d();
        this.f60299e = dVar;
        dVar.e(5);
        this.f60299e.d(vipBasicList.class_name);
        this.f60299e.f(vipBasicList.class_url_name);
        this.f60299e.g(vipBasicList.class_url);
        this.f60300f = new ArrayList();
        for (VipSpecialItem vipSpecialItem : vipBasicList.item) {
            this.f60300f.add(vipSpecialItem);
        }
    }

    public List<VipSpecialItem> c() {
        return this.f60300f;
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return f60298i;
    }
}
