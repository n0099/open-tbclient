package d.a.k0.q0.s1.a.e;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import d.a.c.j.e.n;
import d.a.c.j.e.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public d.a.c.a.f f59496a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f59497b;

    /* renamed from: c  reason: collision with root package name */
    public final List<d.a.c.j.e.a> f59498c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public b f59499d;

    public c(d.a.c.a.f fVar, BdTypeListView bdTypeListView) {
        this.f59496a = fVar;
        this.f59497b = bdTypeListView;
        a();
    }

    public final void a() {
        b bVar = new b((TbPageContext) this.f59496a, d.a.k0.q0.s1.a.a.b.f59458f);
        this.f59499d = bVar;
        this.f59498c.add(bVar);
        this.f59497b.a(this.f59498c);
    }

    public void b() {
        if (this.f59497b.getAdapter2() instanceof d.a.c.j.e.e) {
            this.f59497b.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c(w wVar) {
        for (d.a.c.j.e.a aVar : this.f59498c) {
            if (aVar != null) {
                aVar.Z(wVar);
            }
        }
    }

    public void d(List<n> list) {
        BdTypeListView bdTypeListView = this.f59497b;
        if (bdTypeListView != null) {
            bdTypeListView.setData(list);
        }
    }
}
