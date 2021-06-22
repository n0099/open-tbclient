package d.a.o0.r0.s1.a.e;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import d.a.c.k.e.n;
import d.a.c.k.e.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public d.a.c.a.f f63453a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f63454b;

    /* renamed from: c  reason: collision with root package name */
    public final List<d.a.c.k.e.a> f63455c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public b f63456d;

    public c(d.a.c.a.f fVar, BdTypeListView bdTypeListView) {
        this.f63453a = fVar;
        this.f63454b = bdTypeListView;
        a();
    }

    public final void a() {
        b bVar = new b((TbPageContext) this.f63453a, d.a.o0.r0.s1.a.a.b.f63415f);
        this.f63456d = bVar;
        this.f63455c.add(bVar);
        this.f63454b.a(this.f63455c);
    }

    public void b() {
        if (this.f63454b.getAdapter2() instanceof d.a.c.k.e.e) {
            this.f63454b.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c(w wVar) {
        for (d.a.c.k.e.a aVar : this.f63455c) {
            if (aVar != null) {
                aVar.a0(wVar);
            }
        }
    }

    public void d(List<n> list) {
        BdTypeListView bdTypeListView = this.f63454b;
        if (bdTypeListView != null) {
            bdTypeListView.setData(list);
        }
    }
}
