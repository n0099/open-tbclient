package d.b.i0.q1.c.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetVipInfo.VipSpecialItem;
import tbclient.GetVipInfo.VipSpecialList;
/* loaded from: classes3.dex */
public class n implements d.b.b.j.e.n {

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f59317g = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public d f59318e;

    /* renamed from: f  reason: collision with root package name */
    public List<o> f59319f;

    public n(VipSpecialList vipSpecialList) {
        List<VipSpecialItem> list;
        if (vipSpecialList == null || (list = vipSpecialList.item) == null || list.size() <= 0) {
            return;
        }
        String str = vipSpecialList.card_id;
        d dVar = new d();
        this.f59318e = dVar;
        dVar.e(1);
        this.f59318e.d(vipSpecialList.class_name);
        this.f59318e.f(vipSpecialList.class_url_name);
        this.f59318e.g(vipSpecialList.class_url);
        this.f59319f = new ArrayList();
        for (VipSpecialItem vipSpecialItem : vipSpecialList.item) {
            this.f59319f.add(new o(vipSpecialItem));
        }
    }

    @Override // d.b.b.j.e.n
    public BdUniqueId getType() {
        return f59317g;
    }
}
