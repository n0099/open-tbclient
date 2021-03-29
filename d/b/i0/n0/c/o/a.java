package d.b.i0.n0.c.o;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.BaseActivity;
import d.b.b.j.e.e;
import d.b.i0.n0.b.c;
import d.b.i0.n0.b.d;
import d.b.i0.n0.c.f;
import d.b.i0.n0.c.g;
import d.b.i0.n0.c.h;
import d.b.i0.n0.c.i;
import d.b.i0.n0.c.j;
import d.b.i0.n0.c.k;
import d.b.i0.n0.c.l;
import d.b.i0.n0.c.m;
import d.b.i0.p0.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public List<d.b.b.j.e.a> f57054a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f57055b;

    /* renamed from: c  reason: collision with root package name */
    public k f57056c;

    /* renamed from: d  reason: collision with root package name */
    public m f57057d;

    public a(BaseActivity<?> baseActivity, BdTypeListView bdTypeListView) {
        ArrayList arrayList = new ArrayList();
        this.f57054a = arrayList;
        this.f57055b = bdTypeListView;
        arrayList.add(new g(baseActivity.getPageContext(), h.f57036h));
        this.f57054a.add(new i(baseActivity.getPageContext(), j.f57041g));
        this.f57054a.add(new f(baseActivity.getPageContext(), n.f57932g));
        this.f57054a.add(new d.b.i0.n0.b.a(baseActivity.getPageContext(), d.b.i0.n0.b.b.f57014f));
        this.f57054a.add(new c(baseActivity.getPageContext(), d.k));
        this.f57054a.add(new d.b.i0.n0.c.a(baseActivity.getPageContext()));
        k kVar = new k(baseActivity.getPageContext(), l.i);
        this.f57056c = kVar;
        this.f57054a.add(kVar);
        m mVar = new m(baseActivity.getPageContext(), d.b.i0.n0.c.n.f57050h);
        this.f57057d = mVar;
        this.f57054a.add(mVar);
    }

    public List<d.b.b.j.e.a> a() {
        return this.f57054a;
    }

    public void b() {
        BdTypeListView bdTypeListView = this.f57055b;
        if (bdTypeListView == null || !(bdTypeListView.getAdapter2() instanceof e)) {
            return;
        }
        this.f57055b.getAdapter2().notifyDataSetChanged();
    }

    public void c() {
        this.f57056c.onDestroy();
        this.f57057d.onDestroy();
    }
}
