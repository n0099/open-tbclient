package d.b.i0.q1.c.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetVipInfo.VipTaskItem;
import tbclient.GetVipInfo.VipTaskList;
/* loaded from: classes3.dex */
public class q implements d.b.b.j.e.n {

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f59322g = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public d f59323e;

    /* renamed from: f  reason: collision with root package name */
    public List<r> f59324f;

    public q(VipTaskList vipTaskList) {
        if (vipTaskList == null || vipTaskList.item == null) {
            return;
        }
        String str = vipTaskList.card_id;
        d dVar = new d();
        this.f59323e = dVar;
        dVar.e(3);
        this.f59323e.d(vipTaskList.class_name);
        this.f59323e.f(vipTaskList.class_url_name);
        this.f59323e.g(vipTaskList.class_url);
        this.f59324f = new ArrayList();
        for (VipTaskItem vipTaskItem : vipTaskList.item) {
            this.f59324f.add(new r(vipTaskItem));
        }
    }

    @Override // d.b.b.j.e.n
    public BdUniqueId getType() {
        return f59322g;
    }
}
