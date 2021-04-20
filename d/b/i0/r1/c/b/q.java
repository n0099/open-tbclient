package d.b.i0.r1.c.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetVipInfo.VipTaskItem;
import tbclient.GetVipInfo.VipTaskList;
/* loaded from: classes3.dex */
public class q implements d.b.c.j.e.n {

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f61017g = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public d f61018e;

    /* renamed from: f  reason: collision with root package name */
    public List<r> f61019f;

    public q(VipTaskList vipTaskList) {
        if (vipTaskList == null || vipTaskList.item == null) {
            return;
        }
        String str = vipTaskList.card_id;
        d dVar = new d();
        this.f61018e = dVar;
        dVar.e(3);
        this.f61018e.d(vipTaskList.class_name);
        this.f61018e.f(vipTaskList.class_url_name);
        this.f61018e.g(vipTaskList.class_url);
        this.f61019f = new ArrayList();
        for (VipTaskItem vipTaskItem : vipTaskList.item) {
            this.f61019f.add(new r(vipTaskItem));
        }
    }

    @Override // d.b.c.j.e.n
    public BdUniqueId getType() {
        return f61017g;
    }
}
