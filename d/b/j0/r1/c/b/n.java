package d.b.j0.r1.c.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetVipInfo.VipSpecialItem;
import tbclient.GetVipInfo.VipSpecialList;
/* loaded from: classes3.dex */
public class n implements d.b.c.j.e.n {

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f61433g = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public d f61434e;

    /* renamed from: f  reason: collision with root package name */
    public List<o> f61435f;

    public n(VipSpecialList vipSpecialList) {
        List<VipSpecialItem> list;
        if (vipSpecialList == null || (list = vipSpecialList.item) == null || list.size() <= 0) {
            return;
        }
        String str = vipSpecialList.card_id;
        d dVar = new d();
        this.f61434e = dVar;
        dVar.e(1);
        this.f61434e.d(vipSpecialList.class_name);
        this.f61434e.f(vipSpecialList.class_url_name);
        this.f61434e.g(vipSpecialList.class_url);
        this.f61435f = new ArrayList();
        for (VipSpecialItem vipSpecialItem : vipSpecialList.item) {
            this.f61435f.add(new o(vipSpecialItem));
        }
    }

    @Override // d.b.c.j.e.n
    public BdUniqueId getType() {
        return f61433g;
    }
}
