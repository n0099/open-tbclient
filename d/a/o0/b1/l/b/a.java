package d.a.o0.b1.l.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import d.a.c.k.e.n;
import d.a.o0.z.e0.k;
import d.a.o0.z.e0.l;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f55830a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f55831b;

    /* renamed from: c  reason: collision with root package name */
    public LinkedList<d.a.c.k.e.a> f55832c = new LinkedList<>();

    /* renamed from: d  reason: collision with root package name */
    public g f55833d;

    /* renamed from: e  reason: collision with root package name */
    public b f55834e;

    /* renamed from: f  reason: collision with root package name */
    public e f55835f;

    /* renamed from: g  reason: collision with root package name */
    public f f55836g;

    /* renamed from: h  reason: collision with root package name */
    public d f55837h;

    /* renamed from: i  reason: collision with root package name */
    public c f55838i;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f55830a = tbPageContext;
        this.f55831b = bdTypeRecyclerView;
        b();
    }

    public List<n> a() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f55831b;
        if (bdTypeRecyclerView != null) {
            return bdTypeRecyclerView.getData();
        }
        return null;
    }

    public final void b() {
        this.f55833d = new g(this.f55830a, k.B0);
        this.f55834e = new b(this.f55830a, l.W);
        this.f55835f = new e(this.f55830a, k.J0);
        this.f55836g = new f(this.f55830a, k.H0);
        this.f55837h = new d(this.f55830a, k.C0);
        this.f55838i = new c(this.f55830a, k.I0);
        this.f55833d.k0(this.f55831b);
        this.f55834e.t0(this.f55831b);
        this.f55835f.j0(this.f55831b);
        this.f55836g.k0(this.f55831b);
        this.f55837h.l0(this.f55831b);
        this.f55838i.p0(this.f55831b);
        this.f55832c.add(this.f55833d);
        this.f55832c.add(this.f55834e);
        this.f55832c.add(this.f55835f);
        this.f55832c.add(this.f55836g);
        this.f55832c.add(this.f55837h);
        this.f55832c.add(this.f55838i);
        this.f55831b.a(this.f55832c);
    }

    public void c() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f55831b;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.getListAdapter().notifyDataSetChanged();
        }
    }

    public void d() {
    }

    public void e() {
        b bVar = this.f55834e;
        if (bVar != null) {
            bVar.onPause();
        }
    }

    public void f(List<n> list) {
        this.f55831b.setData(list);
    }

    public void g(NEGFeedBackView.b bVar) {
        f fVar = this.f55836g;
        if (fVar != null) {
            fVar.i0(bVar);
        }
        g gVar = this.f55833d;
        if (gVar != null) {
            gVar.i0(bVar);
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        g gVar = this.f55833d;
        if (gVar != null) {
            gVar.j0(bdUniqueId);
        }
        b bVar = this.f55834e;
        if (bVar != null) {
            bVar.q0(bdUniqueId);
        }
        e eVar = this.f55835f;
        if (eVar != null) {
            eVar.i0(bdUniqueId);
        }
        f fVar = this.f55836g;
        if (fVar != null) {
            fVar.j0(bdUniqueId);
        }
        d dVar = this.f55837h;
        if (dVar != null) {
            dVar.k0(bdUniqueId);
        }
        c cVar = this.f55838i;
        if (cVar != null) {
            cVar.l0(bdUniqueId);
        }
    }

    public void i(d.a.o0.b1.h.k.e eVar) {
        b bVar = this.f55834e;
        if (bVar != null) {
            bVar.s0(eVar);
        }
        c cVar = this.f55838i;
        if (cVar != null) {
            cVar.m0(eVar);
        }
    }
}
