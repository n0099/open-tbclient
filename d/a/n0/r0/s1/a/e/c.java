package d.a.n0.r0.s1.a.e;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import d.a.c.k.e.n;
import d.a.c.k.e.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public d.a.c.a.f f63328a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f63329b;

    /* renamed from: c  reason: collision with root package name */
    public final List<d.a.c.k.e.a> f63330c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public b f63331d;

    public c(d.a.c.a.f fVar, BdTypeListView bdTypeListView) {
        this.f63328a = fVar;
        this.f63329b = bdTypeListView;
        a();
    }

    public final void a() {
        b bVar = new b((TbPageContext) this.f63328a, d.a.n0.r0.s1.a.a.b.f63290f);
        this.f63331d = bVar;
        this.f63330c.add(bVar);
        this.f63329b.a(this.f63330c);
    }

    public void b() {
        if (this.f63329b.getAdapter2() instanceof d.a.c.k.e.e) {
            this.f63329b.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c(w wVar) {
        for (d.a.c.k.e.a aVar : this.f63330c) {
            if (aVar != null) {
                aVar.a0(wVar);
            }
        }
    }

    public void d(List<n> list) {
        BdTypeListView bdTypeListView = this.f63329b;
        if (bdTypeListView != null) {
            bdTypeListView.setData(list);
        }
    }
}
