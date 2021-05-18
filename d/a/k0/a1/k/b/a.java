package d.a.k0.a1.k.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import d.a.c.j.e.n;
import d.a.k0.x.e0.k;
import d.a.k0.x.e0.l;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f51849a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f51850b;

    /* renamed from: c  reason: collision with root package name */
    public LinkedList<d.a.c.j.e.a> f51851c = new LinkedList<>();

    /* renamed from: d  reason: collision with root package name */
    public g f51852d;

    /* renamed from: e  reason: collision with root package name */
    public b f51853e;

    /* renamed from: f  reason: collision with root package name */
    public e f51854f;

    /* renamed from: g  reason: collision with root package name */
    public f f51855g;

    /* renamed from: h  reason: collision with root package name */
    public d f51856h;

    /* renamed from: i  reason: collision with root package name */
    public c f51857i;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f51849a = tbPageContext;
        this.f51850b = bdTypeRecyclerView;
        b();
    }

    public List<n> a() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f51850b;
        if (bdTypeRecyclerView != null) {
            return bdTypeRecyclerView.getData();
        }
        return null;
    }

    public final void b() {
        this.f51852d = new g(this.f51849a, k.w0);
        this.f51853e = new b(this.f51849a, l.W);
        this.f51854f = new e(this.f51849a, k.E0);
        this.f51855g = new f(this.f51849a, k.C0);
        this.f51856h = new d(this.f51849a, k.x0);
        this.f51857i = new c(this.f51849a, k.D0);
        this.f51852d.j0(this.f51850b);
        this.f51853e.t0(this.f51850b);
        this.f51854f.i0(this.f51850b);
        this.f51855g.j0(this.f51850b);
        this.f51856h.m0(this.f51850b);
        this.f51857i.p0(this.f51850b);
        this.f51851c.add(this.f51852d);
        this.f51851c.add(this.f51853e);
        this.f51851c.add(this.f51854f);
        this.f51851c.add(this.f51855g);
        this.f51851c.add(this.f51856h);
        this.f51851c.add(this.f51857i);
        this.f51850b.a(this.f51851c);
    }

    public void c() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f51850b;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.getListAdapter().notifyDataSetChanged();
        }
    }

    public void d() {
    }

    public void e() {
        b bVar = this.f51853e;
        if (bVar != null) {
            bVar.onPause();
        }
    }

    public void f(List<n> list) {
        this.f51850b.setData(list);
    }

    public void g(NEGFeedBackView.b bVar) {
        f fVar = this.f51855g;
        if (fVar != null) {
            fVar.h0(bVar);
        }
        g gVar = this.f51852d;
        if (gVar != null) {
            gVar.h0(bVar);
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        g gVar = this.f51852d;
        if (gVar != null) {
            gVar.i0(bdUniqueId);
        }
        b bVar = this.f51853e;
        if (bVar != null) {
            bVar.q0(bdUniqueId);
        }
        e eVar = this.f51854f;
        if (eVar != null) {
            eVar.h0(bdUniqueId);
        }
        f fVar = this.f51855g;
        if (fVar != null) {
            fVar.i0(bdUniqueId);
        }
        d dVar = this.f51856h;
        if (dVar != null) {
            dVar.j0(bdUniqueId);
        }
        c cVar = this.f51857i;
        if (cVar != null) {
            cVar.m0(bdUniqueId);
        }
    }

    public void i(d.a.k0.a1.g.k.e eVar) {
        b bVar = this.f51853e;
        if (bVar != null) {
            bVar.s0(eVar);
        }
        c cVar = this.f51857i;
        if (cVar != null) {
            cVar.n0(eVar);
        }
    }
}
