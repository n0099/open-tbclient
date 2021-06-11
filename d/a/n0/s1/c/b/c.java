package d.a.n0.s1.c.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetVipInfo.VipBasicList;
import tbclient.GetVipInfo.VipSpecialItem;
/* loaded from: classes3.dex */
public class c implements d.a.c.k.e.n {

    /* renamed from: i  reason: collision with root package name */
    public static final BdUniqueId f64112i = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public d f64113e;

    /* renamed from: f  reason: collision with root package name */
    public List<VipSpecialItem> f64114f;

    /* renamed from: g  reason: collision with root package name */
    public int f64115g;

    /* renamed from: h  reason: collision with root package name */
    public String f64116h;

    public c(VipBasicList vipBasicList) {
        this.f64115g = 0;
        this.f64116h = "";
        if (vipBasicList == null || vipBasicList.item.size() <= 0) {
            return;
        }
        this.f64116h = vipBasicList.card_id;
        this.f64115g = vipBasicList.card_type.intValue();
        d dVar = new d();
        this.f64113e = dVar;
        dVar.e(5);
        this.f64113e.d(vipBasicList.class_name);
        this.f64113e.f(vipBasicList.class_url_name);
        this.f64113e.g(vipBasicList.class_url);
        this.f64114f = new ArrayList();
        for (VipSpecialItem vipSpecialItem : vipBasicList.item) {
            this.f64114f.add(vipSpecialItem);
        }
    }

    public List<VipSpecialItem> b() {
        return this.f64114f;
    }

    @Override // d.a.c.k.e.n
    public BdUniqueId getType() {
        return f64112i;
    }
}
