package d.b.j0.t.e.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import d.b.c.j.e.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public d.b.c.a.f f62660a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f62661b;

    /* renamed from: c  reason: collision with root package name */
    public final List<d.b.c.j.e.a> f62662c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public f f62663d;

    /* renamed from: e  reason: collision with root package name */
    public c f62664e;

    /* renamed from: f  reason: collision with root package name */
    public a f62665f;

    /* renamed from: g  reason: collision with root package name */
    public b f62666g;

    public g(d.b.c.a.f fVar, BdTypeListView bdTypeListView, boolean z) {
        this.f62660a = fVar;
        this.f62661b = bdTypeListView;
        a(z);
    }

    public final void a(boolean z) {
        if (z) {
            c cVar = new c((TbPageContext) this.f62660a, d.b.j0.t.h.b.a.f62757g);
            this.f62664e = cVar;
            this.f62662c.add(cVar);
        } else {
            f fVar = new f((TbPageContext) this.f62660a, d.b.j0.t.h.b.a.f62757g);
            this.f62663d = fVar;
            this.f62662c.add(fVar);
        }
        this.f62665f = new a((TbPageContext) this.f62660a, d.b.j0.t.e.b.a.f62667e);
        this.f62666g = new b((TbPageContext) this.f62660a, d.b.j0.t.e.b.b.f62668e);
        this.f62662c.add(this.f62665f);
        this.f62662c.add(this.f62666g);
        this.f62661b.a(this.f62662c);
    }

    public void b(d.b.j0.t.c cVar) {
        f fVar = this.f62663d;
        if (fVar != null) {
            fVar.j0(cVar);
        }
        c cVar2 = this.f62664e;
        if (cVar2 != null) {
            cVar2.j0(cVar);
        }
    }

    public void c(List<n> list) {
        BdTypeListView bdTypeListView = this.f62661b;
        if (bdTypeListView != null) {
            bdTypeListView.setData(list);
        }
    }
}
