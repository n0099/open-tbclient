package d.b.i0.d1.i.a.b;

import d.b.i0.d1.h.l;
import java.util.ArrayList;
import java.util.List;
import tbclient.BroadcastInfo;
import tbclient.GetForumBroadcastList.DataRes;
import tbclient.Page;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public List<b> f53820a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public Page f53821b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f53822c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f53823d;

    public boolean a() {
        return this.f53822c;
    }

    public List<b> b() {
        return this.f53820a;
    }

    public boolean c() {
        return this.f53823d;
    }

    public void d(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        Page page = dataRes.page;
        this.f53821b = page;
        if (page != null) {
            this.f53822c = page.has_more.intValue() == 1;
        }
        List<BroadcastInfo> list = dataRes.bcast_infos;
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                b bVar = new b();
                bVar.l(list.get(i));
                this.f53820a.add(bVar);
            }
        }
    }

    public void e(boolean z) {
        this.f53823d = z;
    }

    public void f() {
        List<b> list = this.f53820a;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (b bVar : this.f53820a) {
            if (bVar != null) {
                l.t().x(bVar.e().forum_id.longValue(), bVar.b() * 100, bVar.i());
            }
        }
    }
}
