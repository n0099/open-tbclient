package d.b.j0.r1.c.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetVipInfo.VipBasicList;
import tbclient.GetVipInfo.VipSpecialItem;
/* loaded from: classes3.dex */
public class c implements d.b.c.j.e.n {
    public static final BdUniqueId i = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public d f61410e;

    /* renamed from: f  reason: collision with root package name */
    public List<VipSpecialItem> f61411f;

    /* renamed from: g  reason: collision with root package name */
    public int f61412g;

    /* renamed from: h  reason: collision with root package name */
    public String f61413h;

    public c(VipBasicList vipBasicList) {
        this.f61412g = 0;
        this.f61413h = "";
        if (vipBasicList == null || vipBasicList.item.size() <= 0) {
            return;
        }
        this.f61413h = vipBasicList.card_id;
        this.f61412g = vipBasicList.card_type.intValue();
        d dVar = new d();
        this.f61410e = dVar;
        dVar.e(5);
        this.f61410e.d(vipBasicList.class_name);
        this.f61410e.f(vipBasicList.class_url_name);
        this.f61410e.g(vipBasicList.class_url);
        this.f61411f = new ArrayList();
        for (VipSpecialItem vipSpecialItem : vipBasicList.item) {
            this.f61411f.add(vipSpecialItem);
        }
    }

    public List<VipSpecialItem> a() {
        return this.f61411f;
    }

    @Override // d.b.c.j.e.n
    public BdUniqueId getType() {
        return i;
    }
}
