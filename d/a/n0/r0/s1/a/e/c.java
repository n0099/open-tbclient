package d.a.n0.r0.s1.a.e;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import d.a.c.j.e.n;
import d.a.c.j.e.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public d.a.c.a.f f59637a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f59638b;

    /* renamed from: c  reason: collision with root package name */
    public final List<d.a.c.j.e.a> f59639c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public b f59640d;

    public c(d.a.c.a.f fVar, BdTypeListView bdTypeListView) {
        this.f59637a = fVar;
        this.f59638b = bdTypeListView;
        a();
    }

    public final void a() {
        b bVar = new b((TbPageContext) this.f59637a, d.a.n0.r0.s1.a.a.b.f59599f);
        this.f59640d = bVar;
        this.f59639c.add(bVar);
        this.f59638b.a(this.f59639c);
    }

    public void b() {
        if (this.f59638b.getAdapter2() instanceof d.a.c.j.e.e) {
            this.f59638b.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c(w wVar) {
        for (d.a.c.j.e.a aVar : this.f59639c) {
            if (aVar != null) {
                aVar.Z(wVar);
            }
        }
    }

    public void d(List<n> list) {
        BdTypeListView bdTypeListView = this.f59638b;
        if (bdTypeListView != null) {
            bdTypeListView.setData(list);
        }
    }
}
