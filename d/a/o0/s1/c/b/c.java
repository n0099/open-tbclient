package d.a.o0.s1.c.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetVipInfo.VipBasicList;
import tbclient.GetVipInfo.VipSpecialItem;
/* loaded from: classes4.dex */
public class c implements d.a.c.k.e.n {

    /* renamed from: i  reason: collision with root package name */
    public static final BdUniqueId f64237i = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public d f64238e;

    /* renamed from: f  reason: collision with root package name */
    public List<VipSpecialItem> f64239f;

    /* renamed from: g  reason: collision with root package name */
    public int f64240g;

    /* renamed from: h  reason: collision with root package name */
    public String f64241h;

    public c(VipBasicList vipBasicList) {
        this.f64240g = 0;
        this.f64241h = "";
        if (vipBasicList == null || vipBasicList.item.size() <= 0) {
            return;
        }
        this.f64241h = vipBasicList.card_id;
        this.f64240g = vipBasicList.card_type.intValue();
        d dVar = new d();
        this.f64238e = dVar;
        dVar.e(5);
        this.f64238e.d(vipBasicList.class_name);
        this.f64238e.f(vipBasicList.class_url_name);
        this.f64238e.g(vipBasicList.class_url);
        this.f64239f = new ArrayList();
        for (VipSpecialItem vipSpecialItem : vipBasicList.item) {
            this.f64239f.add(vipSpecialItem);
        }
    }

    public List<VipSpecialItem> b() {
        return this.f64239f;
    }

    @Override // d.a.c.k.e.n
    public BdUniqueId getType() {
        return f64237i;
    }
}
