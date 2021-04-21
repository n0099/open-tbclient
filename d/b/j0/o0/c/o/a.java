package d.b.j0.o0.c.o;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.BaseActivity;
import d.b.c.j.e.e;
import d.b.j0.o0.b.c;
import d.b.j0.o0.b.d;
import d.b.j0.o0.c.f;
import d.b.j0.o0.c.g;
import d.b.j0.o0.c.h;
import d.b.j0.o0.c.i;
import d.b.j0.o0.c.j;
import d.b.j0.o0.c.k;
import d.b.j0.o0.c.l;
import d.b.j0.o0.c.m;
import d.b.j0.q0.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public List<d.b.c.j.e.a> f59174a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f59175b;

    /* renamed from: c  reason: collision with root package name */
    public k f59176c;

    /* renamed from: d  reason: collision with root package name */
    public m f59177d;

    public a(BaseActivity<?> baseActivity, BdTypeListView bdTypeListView) {
        ArrayList arrayList = new ArrayList();
        this.f59174a = arrayList;
        this.f59175b = bdTypeListView;
        arrayList.add(new g(baseActivity.getPageContext(), h.f59156h));
        this.f59174a.add(new i(baseActivity.getPageContext(), j.f59161g));
        this.f59174a.add(new f(baseActivity.getPageContext(), n.f60024g));
        this.f59174a.add(new d.b.j0.o0.b.a(baseActivity.getPageContext(), d.b.j0.o0.b.b.f59134f));
        this.f59174a.add(new c(baseActivity.getPageContext(), d.k));
        this.f59174a.add(new d.b.j0.o0.c.a(baseActivity.getPageContext()));
        k kVar = new k(baseActivity.getPageContext(), l.i);
        this.f59176c = kVar;
        this.f59174a.add(kVar);
        m mVar = new m(baseActivity.getPageContext(), d.b.j0.o0.c.n.f59170h);
        this.f59177d = mVar;
        this.f59174a.add(mVar);
    }

    public List<d.b.c.j.e.a> a() {
        return this.f59174a;
    }

    public void b() {
        BdTypeListView bdTypeListView = this.f59175b;
        if (bdTypeListView == null || !(bdTypeListView.getAdapter2() instanceof e)) {
            return;
        }
        this.f59175b.getAdapter2().notifyDataSetChanged();
    }

    public void c() {
        this.f59176c.onDestroy();
        this.f59177d.onDestroy();
    }
}
