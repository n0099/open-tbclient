package d.a.n0.f1.i.a.b;

import d.a.n0.f1.h.l;
import java.util.ArrayList;
import java.util.List;
import tbclient.BroadcastInfo;
import tbclient.GetForumBroadcastList.DataRes;
import tbclient.Page;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public List<b> f58204a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public Page f58205b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f58206c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f58207d;

    public boolean a() {
        return this.f58206c;
    }

    public List<b> b() {
        return this.f58204a;
    }

    public boolean c() {
        return this.f58207d;
    }

    public void d(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        Page page = dataRes.page;
        this.f58205b = page;
        if (page != null) {
            this.f58206c = page.has_more.intValue() == 1;
        }
        List<BroadcastInfo> list = dataRes.bcast_infos;
        if (list != null) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                b bVar = new b();
                bVar.l(list.get(i2));
                this.f58204a.add(bVar);
            }
        }
    }

    public void e(boolean z) {
        this.f58207d = z;
    }

    public void f() {
        List<b> list = this.f58204a;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (b bVar : this.f58204a) {
            if (bVar != null) {
                l.t().x(bVar.e().forum_id.longValue(), bVar.b() * 100, bVar.i());
            }
        }
    }
}
