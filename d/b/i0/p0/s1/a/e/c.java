package d.b.i0.p0.s1.a.e;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import d.b.b.j.e.n;
import d.b.b.j.e.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public d.b.b.a.f f58558a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f58559b;

    /* renamed from: c  reason: collision with root package name */
    public final List<d.b.b.j.e.a> f58560c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public b f58561d;

    public c(d.b.b.a.f fVar, BdTypeListView bdTypeListView) {
        this.f58558a = fVar;
        this.f58559b = bdTypeListView;
        a();
    }

    public final void a() {
        b bVar = new b((TbPageContext) this.f58558a, d.b.i0.p0.s1.a.a.b.f58522f);
        this.f58561d = bVar;
        this.f58560c.add(bVar);
        this.f58559b.a(this.f58560c);
    }

    public void b() {
        if (this.f58559b.getAdapter2() instanceof d.b.b.j.e.e) {
            this.f58559b.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c(w wVar) {
        for (d.b.b.j.e.a aVar : this.f58560c) {
            if (aVar != null) {
                aVar.c0(wVar);
            }
        }
    }

    public void d(List<n> list) {
        BdTypeListView bdTypeListView = this.f58559b;
        if (bdTypeListView != null) {
            bdTypeListView.setData(list);
        }
    }
}
