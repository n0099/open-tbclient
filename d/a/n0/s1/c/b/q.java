package d.a.n0.s1.c.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetVipInfo.VipTaskItem;
import tbclient.GetVipInfo.VipTaskList;
/* loaded from: classes3.dex */
public class q implements d.a.c.k.e.n {

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f64142g = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public d f64143e;

    /* renamed from: f  reason: collision with root package name */
    public List<r> f64144f;

    public q(VipTaskList vipTaskList) {
        if (vipTaskList == null || vipTaskList.item == null) {
            return;
        }
        String str = vipTaskList.card_id;
        d dVar = new d();
        this.f64143e = dVar;
        dVar.e(3);
        this.f64143e.d(vipTaskList.class_name);
        this.f64143e.f(vipTaskList.class_url_name);
        this.f64143e.g(vipTaskList.class_url);
        this.f64144f = new ArrayList();
        for (VipTaskItem vipTaskItem : vipTaskList.item) {
            this.f64144f.add(new r(vipTaskItem));
        }
    }

    @Override // d.a.c.k.e.n
    public BdUniqueId getType() {
        return f64142g;
    }
}
