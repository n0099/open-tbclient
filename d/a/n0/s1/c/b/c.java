package d.a.n0.s1.c.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetVipInfo.VipBasicList;
import tbclient.GetVipInfo.VipSpecialItem;
/* loaded from: classes3.dex */
public class c implements d.a.c.j.e.n {

    /* renamed from: i  reason: collision with root package name */
    public static final BdUniqueId f60421i = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public d f60422e;

    /* renamed from: f  reason: collision with root package name */
    public List<VipSpecialItem> f60423f;

    /* renamed from: g  reason: collision with root package name */
    public int f60424g;

    /* renamed from: h  reason: collision with root package name */
    public String f60425h;

    public c(VipBasicList vipBasicList) {
        this.f60424g = 0;
        this.f60425h = "";
        if (vipBasicList == null || vipBasicList.item.size() <= 0) {
            return;
        }
        this.f60425h = vipBasicList.card_id;
        this.f60424g = vipBasicList.card_type.intValue();
        d dVar = new d();
        this.f60422e = dVar;
        dVar.e(5);
        this.f60422e.d(vipBasicList.class_name);
        this.f60422e.f(vipBasicList.class_url_name);
        this.f60422e.g(vipBasicList.class_url);
        this.f60423f = new ArrayList();
        for (VipSpecialItem vipSpecialItem : vipBasicList.item) {
            this.f60423f.add(vipSpecialItem);
        }
    }

    public List<VipSpecialItem> c() {
        return this.f60423f;
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return f60421i;
    }
}
