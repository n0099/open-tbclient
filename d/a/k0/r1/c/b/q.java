package d.a.k0.r1.c.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetVipInfo.VipTaskItem;
import tbclient.GetVipInfo.VipTaskList;
/* loaded from: classes3.dex */
public class q implements d.a.c.j.e.n {

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f60328g = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public d f60329e;

    /* renamed from: f  reason: collision with root package name */
    public List<r> f60330f;

    public q(VipTaskList vipTaskList) {
        if (vipTaskList == null || vipTaskList.item == null) {
            return;
        }
        String str = vipTaskList.card_id;
        d dVar = new d();
        this.f60329e = dVar;
        dVar.e(3);
        this.f60329e.d(vipTaskList.class_name);
        this.f60329e.f(vipTaskList.class_url_name);
        this.f60329e.g(vipTaskList.class_url);
        this.f60330f = new ArrayList();
        for (VipTaskItem vipTaskItem : vipTaskList.item) {
            this.f60330f.add(new r(vipTaskItem));
        }
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return f60328g;
    }
}
