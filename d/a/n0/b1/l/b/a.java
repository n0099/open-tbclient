package d.a.n0.b1.l.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import d.a.c.k.e.n;
import d.a.n0.z.e0.k;
import d.a.n0.z.e0.l;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f55705a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f55706b;

    /* renamed from: c  reason: collision with root package name */
    public LinkedList<d.a.c.k.e.a> f55707c = new LinkedList<>();

    /* renamed from: d  reason: collision with root package name */
    public g f55708d;

    /* renamed from: e  reason: collision with root package name */
    public b f55709e;

    /* renamed from: f  reason: collision with root package name */
    public e f55710f;

    /* renamed from: g  reason: collision with root package name */
    public f f55711g;

    /* renamed from: h  reason: collision with root package name */
    public d f55712h;

    /* renamed from: i  reason: collision with root package name */
    public c f55713i;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f55705a = tbPageContext;
        this.f55706b = bdTypeRecyclerView;
        b();
    }

    public List<n> a() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f55706b;
        if (bdTypeRecyclerView != null) {
            return bdTypeRecyclerView.getData();
        }
        return null;
    }

    public final void b() {
        this.f55708d = new g(this.f55705a, k.w0);
        this.f55709e = new b(this.f55705a, l.W);
        this.f55710f = new e(this.f55705a, k.E0);
        this.f55711g = new f(this.f55705a, k.C0);
        this.f55712h = new d(this.f55705a, k.x0);
        this.f55713i = new c(this.f55705a, k.D0);
        this.f55708d.k0(this.f55706b);
        this.f55709e.t0(this.f55706b);
        this.f55710f.j0(this.f55706b);
        this.f55711g.k0(this.f55706b);
        this.f55712h.l0(this.f55706b);
        this.f55713i.p0(this.f55706b);
        this.f55707c.add(this.f55708d);
        this.f55707c.add(this.f55709e);
        this.f55707c.add(this.f55710f);
        this.f55707c.add(this.f55711g);
        this.f55707c.add(this.f55712h);
        this.f55707c.add(this.f55713i);
        this.f55706b.a(this.f55707c);
    }

    public void c() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f55706b;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.getListAdapter().notifyDataSetChanged();
        }
    }

    public void d() {
    }

    public void e() {
        b bVar = this.f55709e;
        if (bVar != null) {
            bVar.onPause();
        }
    }

    public void f(List<n> list) {
        this.f55706b.setData(list);
    }

    public void g(NEGFeedBackView.b bVar) {
        f fVar = this.f55711g;
        if (fVar != null) {
            fVar.i0(bVar);
        }
        g gVar = this.f55708d;
        if (gVar != null) {
            gVar.i0(bVar);
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        g gVar = this.f55708d;
        if (gVar != null) {
            gVar.j0(bdUniqueId);
        }
        b bVar = this.f55709e;
        if (bVar != null) {
            bVar.q0(bdUniqueId);
        }
        e eVar = this.f55710f;
        if (eVar != null) {
            eVar.i0(bdUniqueId);
        }
        f fVar = this.f55711g;
        if (fVar != null) {
            fVar.j0(bdUniqueId);
        }
        d dVar = this.f55712h;
        if (dVar != null) {
            dVar.k0(bdUniqueId);
        }
        c cVar = this.f55713i;
        if (cVar != null) {
            cVar.l0(bdUniqueId);
        }
    }

    public void i(d.a.n0.b1.h.k.e eVar) {
        b bVar = this.f55709e;
        if (bVar != null) {
            bVar.s0(eVar);
        }
        c cVar = this.f55713i;
        if (cVar != null) {
            cVar.m0(eVar);
        }
    }
}
