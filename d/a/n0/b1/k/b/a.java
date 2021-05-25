package d.a.n0.b1.k.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import d.a.c.j.e.n;
import d.a.n0.z.e0.k;
import d.a.n0.z.e0.l;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f52016a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f52017b;

    /* renamed from: c  reason: collision with root package name */
    public LinkedList<d.a.c.j.e.a> f52018c = new LinkedList<>();

    /* renamed from: d  reason: collision with root package name */
    public g f52019d;

    /* renamed from: e  reason: collision with root package name */
    public b f52020e;

    /* renamed from: f  reason: collision with root package name */
    public e f52021f;

    /* renamed from: g  reason: collision with root package name */
    public f f52022g;

    /* renamed from: h  reason: collision with root package name */
    public d f52023h;

    /* renamed from: i  reason: collision with root package name */
    public c f52024i;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f52016a = tbPageContext;
        this.f52017b = bdTypeRecyclerView;
        b();
    }

    public List<n> a() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f52017b;
        if (bdTypeRecyclerView != null) {
            return bdTypeRecyclerView.getData();
        }
        return null;
    }

    public final void b() {
        this.f52019d = new g(this.f52016a, k.w0);
        this.f52020e = new b(this.f52016a, l.W);
        this.f52021f = new e(this.f52016a, k.E0);
        this.f52022g = new f(this.f52016a, k.C0);
        this.f52023h = new d(this.f52016a, k.x0);
        this.f52024i = new c(this.f52016a, k.D0);
        this.f52019d.j0(this.f52017b);
        this.f52020e.t0(this.f52017b);
        this.f52021f.i0(this.f52017b);
        this.f52022g.j0(this.f52017b);
        this.f52023h.m0(this.f52017b);
        this.f52024i.p0(this.f52017b);
        this.f52018c.add(this.f52019d);
        this.f52018c.add(this.f52020e);
        this.f52018c.add(this.f52021f);
        this.f52018c.add(this.f52022g);
        this.f52018c.add(this.f52023h);
        this.f52018c.add(this.f52024i);
        this.f52017b.a(this.f52018c);
    }

    public void c() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f52017b;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.getListAdapter().notifyDataSetChanged();
        }
    }

    public void d() {
    }

    public void e() {
        b bVar = this.f52020e;
        if (bVar != null) {
            bVar.onPause();
        }
    }

    public void f(List<n> list) {
        this.f52017b.setData(list);
    }

    public void g(NEGFeedBackView.b bVar) {
        f fVar = this.f52022g;
        if (fVar != null) {
            fVar.h0(bVar);
        }
        g gVar = this.f52019d;
        if (gVar != null) {
            gVar.h0(bVar);
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        g gVar = this.f52019d;
        if (gVar != null) {
            gVar.i0(bdUniqueId);
        }
        b bVar = this.f52020e;
        if (bVar != null) {
            bVar.q0(bdUniqueId);
        }
        e eVar = this.f52021f;
        if (eVar != null) {
            eVar.h0(bdUniqueId);
        }
        f fVar = this.f52022g;
        if (fVar != null) {
            fVar.i0(bdUniqueId);
        }
        d dVar = this.f52023h;
        if (dVar != null) {
            dVar.j0(bdUniqueId);
        }
        c cVar = this.f52024i;
        if (cVar != null) {
            cVar.m0(bdUniqueId);
        }
    }

    public void i(d.a.n0.b1.g.k.e eVar) {
        b bVar = this.f52020e;
        if (bVar != null) {
            bVar.s0(eVar);
        }
        c cVar = this.f52024i;
        if (cVar != null) {
            cVar.n0(eVar);
        }
    }
}
