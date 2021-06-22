package d.a.o0.s1.c.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetVipInfo.VipTaskItem;
import tbclient.GetVipInfo.VipTaskList;
/* loaded from: classes4.dex */
public class q implements d.a.c.k.e.n {

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f64267g = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public d f64268e;

    /* renamed from: f  reason: collision with root package name */
    public List<r> f64269f;

    public q(VipTaskList vipTaskList) {
        if (vipTaskList == null || vipTaskList.item == null) {
            return;
        }
        String str = vipTaskList.card_id;
        d dVar = new d();
        this.f64268e = dVar;
        dVar.e(3);
        this.f64268e.d(vipTaskList.class_name);
        this.f64268e.f(vipTaskList.class_url_name);
        this.f64268e.g(vipTaskList.class_url);
        this.f64269f = new ArrayList();
        for (VipTaskItem vipTaskItem : vipTaskList.item) {
            this.f64269f.add(new r(vipTaskItem));
        }
    }

    @Override // d.a.c.k.e.n
    public BdUniqueId getType() {
        return f64267g;
    }
}
