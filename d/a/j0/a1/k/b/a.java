package d.a.j0.a1.k.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import d.a.c.j.e.n;
import d.a.j0.x.e0.k;
import d.a.j0.x.e0.l;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f51150a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f51151b;

    /* renamed from: c  reason: collision with root package name */
    public LinkedList<d.a.c.j.e.a> f51152c = new LinkedList<>();

    /* renamed from: d  reason: collision with root package name */
    public g f51153d;

    /* renamed from: e  reason: collision with root package name */
    public b f51154e;

    /* renamed from: f  reason: collision with root package name */
    public e f51155f;

    /* renamed from: g  reason: collision with root package name */
    public f f51156g;

    /* renamed from: h  reason: collision with root package name */
    public d f51157h;

    /* renamed from: i  reason: collision with root package name */
    public c f51158i;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f51150a = tbPageContext;
        this.f51151b = bdTypeRecyclerView;
        b();
    }

    public List<n> a() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f51151b;
        if (bdTypeRecyclerView != null) {
            return bdTypeRecyclerView.getData();
        }
        return null;
    }

    public final void b() {
        this.f51153d = new g(this.f51150a, k.v0);
        this.f51154e = new b(this.f51150a, l.V);
        this.f51155f = new e(this.f51150a, k.D0);
        this.f51156g = new f(this.f51150a, k.B0);
        this.f51157h = new d(this.f51150a, k.w0);
        this.f51158i = new c(this.f51150a, k.C0);
        this.f51153d.j0(this.f51151b);
        this.f51154e.t0(this.f51151b);
        this.f51155f.i0(this.f51151b);
        this.f51156g.j0(this.f51151b);
        this.f51157h.m0(this.f51151b);
        this.f51158i.p0(this.f51151b);
        this.f51152c.add(this.f51153d);
        this.f51152c.add(this.f51154e);
        this.f51152c.add(this.f51155f);
        this.f51152c.add(this.f51156g);
        this.f51152c.add(this.f51157h);
        this.f51152c.add(this.f51158i);
        this.f51151b.a(this.f51152c);
    }

    public void c() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f51151b;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.getListAdapter().notifyDataSetChanged();
        }
    }

    public void d() {
    }

    public void e() {
        b bVar = this.f51154e;
        if (bVar != null) {
            bVar.onPause();
        }
    }

    public void f(List<n> list) {
        this.f51151b.setData(list);
    }

    public void g(NEGFeedBackView.b bVar) {
        f fVar = this.f51156g;
        if (fVar != null) {
            fVar.h0(bVar);
        }
        g gVar = this.f51153d;
        if (gVar != null) {
            gVar.h0(bVar);
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        g gVar = this.f51153d;
        if (gVar != null) {
            gVar.i0(bdUniqueId);
        }
        b bVar = this.f51154e;
        if (bVar != null) {
            bVar.q0(bdUniqueId);
        }
        e eVar = this.f51155f;
        if (eVar != null) {
            eVar.h0(bdUniqueId);
        }
        f fVar = this.f51156g;
        if (fVar != null) {
            fVar.i0(bdUniqueId);
        }
        d dVar = this.f51157h;
        if (dVar != null) {
            dVar.j0(bdUniqueId);
        }
        c cVar = this.f51158i;
        if (cVar != null) {
            cVar.m0(bdUniqueId);
        }
    }

    public void i(d.a.j0.a1.g.k.e eVar) {
        b bVar = this.f51154e;
        if (bVar != null) {
            bVar.r0(eVar);
        }
        c cVar = this.f51158i;
        if (cVar != null) {
            cVar.n0(eVar);
        }
    }
}
