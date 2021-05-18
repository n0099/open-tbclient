package d.a.k0.o0.c.o;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.BaseActivity;
import d.a.c.j.e.e;
import d.a.k0.o0.b.c;
import d.a.k0.o0.b.d;
import d.a.k0.o0.c.f;
import d.a.k0.o0.c.g;
import d.a.k0.o0.c.h;
import d.a.k0.o0.c.i;
import d.a.k0.o0.c.j;
import d.a.k0.o0.c.k;
import d.a.k0.o0.c.l;
import d.a.k0.o0.c.m;
import d.a.k0.q0.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public List<d.a.c.j.e.a> f57909a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f57910b;

    /* renamed from: c  reason: collision with root package name */
    public k f57911c;

    /* renamed from: d  reason: collision with root package name */
    public m f57912d;

    public a(BaseActivity<?> baseActivity, BdTypeListView bdTypeListView) {
        ArrayList arrayList = new ArrayList();
        this.f57909a = arrayList;
        this.f57910b = bdTypeListView;
        arrayList.add(new g(baseActivity.getPageContext(), h.f57890h));
        this.f57909a.add(new i(baseActivity.getPageContext(), j.f57895g));
        this.f57909a.add(new f(baseActivity.getPageContext(), n.f58845g));
        this.f57909a.add(new d.a.k0.o0.b.a(baseActivity.getPageContext(), d.a.k0.o0.b.b.f57866f));
        this.f57909a.add(new c(baseActivity.getPageContext(), d.k));
        this.f57909a.add(new d.a.k0.o0.c.a(baseActivity.getPageContext()));
        k kVar = new k(baseActivity.getPageContext(), l.f57899i);
        this.f57911c = kVar;
        this.f57909a.add(kVar);
        m mVar = new m(baseActivity.getPageContext(), d.a.k0.o0.c.n.f57905h);
        this.f57912d = mVar;
        this.f57909a.add(mVar);
    }

    public List<d.a.c.j.e.a> a() {
        return this.f57909a;
    }

    public void b() {
        BdTypeListView bdTypeListView = this.f57910b;
        if (bdTypeListView == null || !(bdTypeListView.getAdapter2() instanceof e)) {
            return;
        }
        this.f57910b.getAdapter2().notifyDataSetChanged();
    }

    public void c() {
        this.f57911c.onDestroy();
        this.f57912d.onDestroy();
    }
}
