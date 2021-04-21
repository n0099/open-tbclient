package d.b.j0.e1.i.a.b;

import d.b.j0.e1.h.l;
import java.util.ArrayList;
import java.util.List;
import tbclient.BroadcastInfo;
import tbclient.GetForumBroadcastList.DataRes;
import tbclient.Page;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public List<b> f55763a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public Page f55764b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f55765c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f55766d;

    public boolean a() {
        return this.f55765c;
    }

    public List<b> b() {
        return this.f55763a;
    }

    public boolean c() {
        return this.f55766d;
    }

    public void d(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        Page page = dataRes.page;
        this.f55764b = page;
        if (page != null) {
            this.f55765c = page.has_more.intValue() == 1;
        }
        List<BroadcastInfo> list = dataRes.bcast_infos;
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                b bVar = new b();
                bVar.l(list.get(i));
                this.f55763a.add(bVar);
            }
        }
    }

    public void e(boolean z) {
        this.f55766d = z;
    }

    public void f() {
        List<b> list = this.f55763a;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (b bVar : this.f55763a) {
            if (bVar != null) {
                l.t().x(bVar.e().forum_id.longValue(), bVar.b() * 100, bVar.i());
            }
        }
    }
}
