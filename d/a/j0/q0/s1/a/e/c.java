package d.a.j0.q0.s1.a.e;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import d.a.c.j.e.n;
import d.a.c.j.e.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public d.a.c.a.f f58754a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f58755b;

    /* renamed from: c  reason: collision with root package name */
    public final List<d.a.c.j.e.a> f58756c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public b f58757d;

    public c(d.a.c.a.f fVar, BdTypeListView bdTypeListView) {
        this.f58754a = fVar;
        this.f58755b = bdTypeListView;
        a();
    }

    public final void a() {
        b bVar = new b((TbPageContext) this.f58754a, d.a.j0.q0.s1.a.a.b.f58716f);
        this.f58757d = bVar;
        this.f58756c.add(bVar);
        this.f58755b.a(this.f58756c);
    }

    public void b() {
        if (this.f58755b.getAdapter2() instanceof d.a.c.j.e.e) {
            this.f58755b.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c(w wVar) {
        for (d.a.c.j.e.a aVar : this.f58756c) {
            if (aVar != null) {
                aVar.Z(wVar);
            }
        }
    }

    public void d(List<n> list) {
        BdTypeListView bdTypeListView = this.f58755b;
        if (bdTypeListView != null) {
            bdTypeListView.setData(list);
        }
    }
}
