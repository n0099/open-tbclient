package d.b.i0.e1.i.a.b;

import d.b.i0.e1.h.l;
import java.util.ArrayList;
import java.util.List;
import tbclient.BroadcastInfo;
import tbclient.GetForumBroadcastList.DataRes;
import tbclient.Page;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public List<b> f55342a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public Page f55343b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f55344c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f55345d;

    public boolean a() {
        return this.f55344c;
    }

    public List<b> b() {
        return this.f55342a;
    }

    public boolean c() {
        return this.f55345d;
    }

    public void d(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        Page page = dataRes.page;
        this.f55343b = page;
        if (page != null) {
            this.f55344c = page.has_more.intValue() == 1;
        }
        List<BroadcastInfo> list = dataRes.bcast_infos;
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                b bVar = new b();
                bVar.l(list.get(i));
                this.f55342a.add(bVar);
            }
        }
    }

    public void e(boolean z) {
        this.f55345d = z;
    }

    public void f() {
        List<b> list = this.f55342a;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (b bVar : this.f55342a) {
            if (bVar != null) {
                l.t().x(bVar.e().forum_id.longValue(), bVar.b() * 100, bVar.i());
            }
        }
    }
}
