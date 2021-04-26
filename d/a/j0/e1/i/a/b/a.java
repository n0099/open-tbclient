package d.a.j0.e1.i.a.b;

import d.a.j0.e1.h.l;
import java.util.ArrayList;
import java.util.List;
import tbclient.BroadcastInfo;
import tbclient.GetForumBroadcastList.DataRes;
import tbclient.Page;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public List<b> f53618a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public Page f53619b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f53620c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f53621d;

    public boolean a() {
        return this.f53620c;
    }

    public List<b> b() {
        return this.f53618a;
    }

    public boolean c() {
        return this.f53621d;
    }

    public void d(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        Page page = dataRes.page;
        this.f53619b = page;
        if (page != null) {
            this.f53620c = page.has_more.intValue() == 1;
        }
        List<BroadcastInfo> list = dataRes.bcast_infos;
        if (list != null) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                b bVar = new b();
                bVar.l(list.get(i2));
                this.f53618a.add(bVar);
            }
        }
    }

    public void e(boolean z) {
        this.f53621d = z;
    }

    public void f() {
        List<b> list = this.f53618a;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (b bVar : this.f53618a) {
            if (bVar != null) {
                l.t().x(bVar.e().forum_id.longValue(), bVar.b() * 100, bVar.i());
            }
        }
    }
}
