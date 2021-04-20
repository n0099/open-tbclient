package d.b.i0.q0.s1.a.e;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import d.b.c.j.e.n;
import d.b.c.j.e.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public d.b.c.a.f f60226a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f60227b;

    /* renamed from: c  reason: collision with root package name */
    public final List<d.b.c.j.e.a> f60228c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public b f60229d;

    public c(d.b.c.a.f fVar, BdTypeListView bdTypeListView) {
        this.f60226a = fVar;
        this.f60227b = bdTypeListView;
        a();
    }

    public final void a() {
        b bVar = new b((TbPageContext) this.f60226a, d.b.i0.q0.s1.a.a.b.f60190f);
        this.f60229d = bVar;
        this.f60228c.add(bVar);
        this.f60227b.a(this.f60228c);
    }

    public void b() {
        if (this.f60227b.getAdapter2() instanceof d.b.c.j.e.e) {
            this.f60227b.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c(w wVar) {
        for (d.b.c.j.e.a aVar : this.f60228c) {
            if (aVar != null) {
                aVar.c0(wVar);
            }
        }
    }

    public void d(List<n> list) {
        BdTypeListView bdTypeListView = this.f60227b;
        if (bdTypeListView != null) {
            bdTypeListView.setData(list);
        }
    }
}
