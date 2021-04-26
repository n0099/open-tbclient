package d.a.j0.o0.c.o;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.BaseActivity;
import d.a.c.j.e.e;
import d.a.j0.o0.b.c;
import d.a.j0.o0.b.d;
import d.a.j0.o0.c.f;
import d.a.j0.o0.c.g;
import d.a.j0.o0.c.h;
import d.a.j0.o0.c.i;
import d.a.j0.o0.c.j;
import d.a.j0.o0.c.k;
import d.a.j0.o0.c.l;
import d.a.j0.o0.c.m;
import d.a.j0.q0.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public List<d.a.c.j.e.a> f57202a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f57203b;

    /* renamed from: c  reason: collision with root package name */
    public k f57204c;

    /* renamed from: d  reason: collision with root package name */
    public m f57205d;

    public a(BaseActivity<?> baseActivity, BdTypeListView bdTypeListView) {
        ArrayList arrayList = new ArrayList();
        this.f57202a = arrayList;
        this.f57203b = bdTypeListView;
        arrayList.add(new g(baseActivity.getPageContext(), h.f57183h));
        this.f57202a.add(new i(baseActivity.getPageContext(), j.f57188g));
        this.f57202a.add(new f(baseActivity.getPageContext(), n.f58103g));
        this.f57202a.add(new d.a.j0.o0.b.a(baseActivity.getPageContext(), d.a.j0.o0.b.b.f57159f));
        this.f57202a.add(new c(baseActivity.getPageContext(), d.k));
        this.f57202a.add(new d.a.j0.o0.c.a(baseActivity.getPageContext()));
        k kVar = new k(baseActivity.getPageContext(), l.f57192i);
        this.f57204c = kVar;
        this.f57202a.add(kVar);
        m mVar = new m(baseActivity.getPageContext(), d.a.j0.o0.c.n.f57198h);
        this.f57205d = mVar;
        this.f57202a.add(mVar);
    }

    public List<d.a.c.j.e.a> a() {
        return this.f57202a;
    }

    public void b() {
        BdTypeListView bdTypeListView = this.f57203b;
        if (bdTypeListView == null || !(bdTypeListView.getAdapter2() instanceof e)) {
            return;
        }
        this.f57203b.getAdapter2().notifyDataSetChanged();
    }

    public void c() {
        this.f57204c.onDestroy();
        this.f57205d.onDestroy();
    }
}
