package d.a.n0.s1.c.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetVipInfo.VipSpecialItem;
import tbclient.GetVipInfo.VipSpecialList;
/* loaded from: classes3.dex */
public class n implements d.a.c.k.e.n {

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f64137g = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public d f64138e;

    /* renamed from: f  reason: collision with root package name */
    public List<o> f64139f;

    public n(VipSpecialList vipSpecialList) {
        List<VipSpecialItem> list;
        if (vipSpecialList == null || (list = vipSpecialList.item) == null || list.size() <= 0) {
            return;
        }
        String str = vipSpecialList.card_id;
        d dVar = new d();
        this.f64138e = dVar;
        dVar.e(1);
        this.f64138e.d(vipSpecialList.class_name);
        this.f64138e.f(vipSpecialList.class_url_name);
        this.f64138e.g(vipSpecialList.class_url);
        this.f64139f = new ArrayList();
        for (VipSpecialItem vipSpecialItem : vipSpecialList.item) {
            this.f64139f.add(new o(vipSpecialItem));
        }
    }

    @Override // d.a.c.k.e.n
    public BdUniqueId getType() {
        return f64137g;
    }
}
