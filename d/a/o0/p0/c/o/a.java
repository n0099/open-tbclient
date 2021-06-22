package d.a.o0.p0.c.o;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.BaseActivity;
import d.a.c.k.e.e;
import d.a.o0.p0.b.c;
import d.a.o0.p0.b.d;
import d.a.o0.p0.c.f;
import d.a.o0.p0.c.g;
import d.a.o0.p0.c.h;
import d.a.o0.p0.c.i;
import d.a.o0.p0.c.j;
import d.a.o0.p0.c.k;
import d.a.o0.p0.c.l;
import d.a.o0.p0.c.m;
import d.a.o0.r0.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public List<d.a.c.k.e.a> f61834a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f61835b;

    /* renamed from: c  reason: collision with root package name */
    public k f61836c;

    /* renamed from: d  reason: collision with root package name */
    public m f61837d;

    public a(BaseActivity<?> baseActivity, BdTypeListView bdTypeListView) {
        ArrayList arrayList = new ArrayList();
        this.f61834a = arrayList;
        this.f61835b = bdTypeListView;
        arrayList.add(new g(baseActivity.getPageContext(), h.f61815h));
        this.f61834a.add(new i(baseActivity.getPageContext(), j.f61820g));
        this.f61834a.add(new f(baseActivity.getPageContext(), n.f62802g));
        this.f61834a.add(new d.a.o0.p0.b.a(baseActivity.getPageContext(), d.a.o0.p0.b.b.f61791f));
        this.f61834a.add(new c(baseActivity.getPageContext(), d.k));
        this.f61834a.add(new d.a.o0.p0.c.a(baseActivity.getPageContext()));
        k kVar = new k(baseActivity.getPageContext(), l.f61824i);
        this.f61836c = kVar;
        this.f61834a.add(kVar);
        m mVar = new m(baseActivity.getPageContext(), d.a.o0.p0.c.n.f61830h);
        this.f61837d = mVar;
        this.f61834a.add(mVar);
    }

    public List<d.a.c.k.e.a> a() {
        return this.f61834a;
    }

    public void b() {
        BdTypeListView bdTypeListView = this.f61835b;
        if (bdTypeListView == null || !(bdTypeListView.getAdapter2() instanceof e)) {
            return;
        }
        this.f61835b.getAdapter2().notifyDataSetChanged();
    }

    public void c() {
        this.f61836c.onDestroy();
        this.f61837d.onDestroy();
    }
}
