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
    public d.b.b.a.f f58557a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f58558b;

    /* renamed from: c  reason: collision with root package name */
    public final List<d.b.b.j.e.a> f58559c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public b f58560d;

    public c(d.b.b.a.f fVar, BdTypeListView bdTypeListView) {
        this.f58557a = fVar;
        this.f58558b = bdTypeListView;
        a();
    }

    public final void a() {
        b bVar = new b((TbPageContext) this.f58557a, d.b.i0.p0.s1.a.a.b.f58521f);
        this.f58560d = bVar;
        this.f58559c.add(bVar);
        this.f58558b.a(this.f58559c);
    }

    public void b() {
        if (this.f58558b.getAdapter2() instanceof d.b.b.j.e.e) {
            this.f58558b.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c(w wVar) {
        for (d.b.b.j.e.a aVar : this.f58559c) {
            if (aVar != null) {
                aVar.c0(wVar);
            }
        }
    }

    public void d(List<n> list) {
        BdTypeListView bdTypeListView = this.f58558b;
        if (bdTypeListView != null) {
            bdTypeListView.setData(list);
        }
    }
}
