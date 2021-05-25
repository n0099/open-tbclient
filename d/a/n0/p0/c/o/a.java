package d.a.n0.p0.c.o;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.BaseActivity;
import d.a.c.j.e.e;
import d.a.n0.p0.b.c;
import d.a.n0.p0.b.d;
import d.a.n0.p0.c.f;
import d.a.n0.p0.c.g;
import d.a.n0.p0.c.h;
import d.a.n0.p0.c.i;
import d.a.n0.p0.c.j;
import d.a.n0.p0.c.k;
import d.a.n0.p0.c.l;
import d.a.n0.p0.c.m;
import d.a.n0.r0.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public List<d.a.c.j.e.a> f58018a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f58019b;

    /* renamed from: c  reason: collision with root package name */
    public k f58020c;

    /* renamed from: d  reason: collision with root package name */
    public m f58021d;

    public a(BaseActivity<?> baseActivity, BdTypeListView bdTypeListView) {
        ArrayList arrayList = new ArrayList();
        this.f58018a = arrayList;
        this.f58019b = bdTypeListView;
        arrayList.add(new g(baseActivity.getPageContext(), h.f57999h));
        this.f58018a.add(new i(baseActivity.getPageContext(), j.f58004g));
        this.f58018a.add(new f(baseActivity.getPageContext(), n.f58986g));
        this.f58018a.add(new d.a.n0.p0.b.a(baseActivity.getPageContext(), d.a.n0.p0.b.b.f57975f));
        this.f58018a.add(new c(baseActivity.getPageContext(), d.k));
        this.f58018a.add(new d.a.n0.p0.c.a(baseActivity.getPageContext()));
        k kVar = new k(baseActivity.getPageContext(), l.f58008i);
        this.f58020c = kVar;
        this.f58018a.add(kVar);
        m mVar = new m(baseActivity.getPageContext(), d.a.n0.p0.c.n.f58014h);
        this.f58021d = mVar;
        this.f58018a.add(mVar);
    }

    public List<d.a.c.j.e.a> a() {
        return this.f58018a;
    }

    public void b() {
        BdTypeListView bdTypeListView = this.f58019b;
        if (bdTypeListView == null || !(bdTypeListView.getAdapter2() instanceof e)) {
            return;
        }
        this.f58019b.getAdapter2().notifyDataSetChanged();
    }

    public void c() {
        this.f58020c.onDestroy();
        this.f58021d.onDestroy();
    }
}
