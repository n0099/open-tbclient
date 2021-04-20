package d.b.i0.o0.c.o;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.BaseActivity;
import d.b.c.j.e.e;
import d.b.i0.o0.b.c;
import d.b.i0.o0.b.d;
import d.b.i0.o0.c.f;
import d.b.i0.o0.c.g;
import d.b.i0.o0.c.h;
import d.b.i0.o0.c.i;
import d.b.i0.o0.c.j;
import d.b.i0.o0.c.k;
import d.b.i0.o0.c.l;
import d.b.i0.o0.c.m;
import d.b.i0.q0.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public List<d.b.c.j.e.a> f58753a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f58754b;

    /* renamed from: c  reason: collision with root package name */
    public k f58755c;

    /* renamed from: d  reason: collision with root package name */
    public m f58756d;

    public a(BaseActivity<?> baseActivity, BdTypeListView bdTypeListView) {
        ArrayList arrayList = new ArrayList();
        this.f58753a = arrayList;
        this.f58754b = bdTypeListView;
        arrayList.add(new g(baseActivity.getPageContext(), h.f58735h));
        this.f58753a.add(new i(baseActivity.getPageContext(), j.f58740g));
        this.f58753a.add(new f(baseActivity.getPageContext(), n.f59603g));
        this.f58753a.add(new d.b.i0.o0.b.a(baseActivity.getPageContext(), d.b.i0.o0.b.b.f58713f));
        this.f58753a.add(new c(baseActivity.getPageContext(), d.k));
        this.f58753a.add(new d.b.i0.o0.c.a(baseActivity.getPageContext()));
        k kVar = new k(baseActivity.getPageContext(), l.i);
        this.f58755c = kVar;
        this.f58753a.add(kVar);
        m mVar = new m(baseActivity.getPageContext(), d.b.i0.o0.c.n.f58749h);
        this.f58756d = mVar;
        this.f58753a.add(mVar);
    }

    public List<d.b.c.j.e.a> a() {
        return this.f58753a;
    }

    public void b() {
        BdTypeListView bdTypeListView = this.f58754b;
        if (bdTypeListView == null || !(bdTypeListView.getAdapter2() instanceof e)) {
            return;
        }
        this.f58754b.getAdapter2().notifyDataSetChanged();
    }

    public void c() {
        this.f58755c.onDestroy();
        this.f58756d.onDestroy();
    }
}
