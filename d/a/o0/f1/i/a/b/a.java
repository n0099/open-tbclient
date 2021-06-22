package d.a.o0.f1.i.a.b;

import d.a.o0.f1.h.l;
import java.util.ArrayList;
import java.util.List;
import tbclient.BroadcastInfo;
import tbclient.GetForumBroadcastList.DataRes;
import tbclient.Page;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public List<b> f58329a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public Page f58330b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f58331c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f58332d;

    public boolean a() {
        return this.f58331c;
    }

    public List<b> b() {
        return this.f58329a;
    }

    public boolean c() {
        return this.f58332d;
    }

    public void d(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        Page page = dataRes.page;
        this.f58330b = page;
        if (page != null) {
            this.f58331c = page.has_more.intValue() == 1;
        }
        List<BroadcastInfo> list = dataRes.bcast_infos;
        if (list != null) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                b bVar = new b();
                bVar.l(list.get(i2));
                this.f58329a.add(bVar);
            }
        }
    }

    public void e(boolean z) {
        this.f58332d = z;
    }

    public void f() {
        List<b> list = this.f58329a;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (b bVar : this.f58329a) {
            if (bVar != null) {
                l.t().x(bVar.e().forum_id.longValue(), bVar.b() * 100, bVar.i());
            }
        }
    }
}
