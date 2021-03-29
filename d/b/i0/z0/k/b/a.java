package d.b.i0.z0.k.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import d.b.b.j.e.n;
import d.b.i0.x.e0.k;
import d.b.i0.x.e0.l;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f63384a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f63385b;

    /* renamed from: c  reason: collision with root package name */
    public LinkedList<d.b.b.j.e.a> f63386c = new LinkedList<>();

    /* renamed from: d  reason: collision with root package name */
    public g f63387d;

    /* renamed from: e  reason: collision with root package name */
    public b f63388e;

    /* renamed from: f  reason: collision with root package name */
    public e f63389f;

    /* renamed from: g  reason: collision with root package name */
    public f f63390g;

    /* renamed from: h  reason: collision with root package name */
    public d f63391h;
    public c i;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f63384a = tbPageContext;
        this.f63385b = bdTypeRecyclerView;
        b();
    }

    public List<n> a() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f63385b;
        if (bdTypeRecyclerView != null) {
            return bdTypeRecyclerView.getData();
        }
        return null;
    }

    public final void b() {
        this.f63387d = new g(this.f63384a, k.v0);
        this.f63388e = new b(this.f63384a, l.V);
        this.f63389f = new e(this.f63384a, k.D0);
        this.f63390g = new f(this.f63384a, k.B0);
        this.f63391h = new d(this.f63384a, k.w0);
        this.i = new c(this.f63384a, k.C0);
        this.f63387d.n0(this.f63385b);
        this.f63388e.t0(this.f63385b);
        this.f63389f.m0(this.f63385b);
        this.f63390g.n0(this.f63385b);
        this.f63391h.o0(this.f63385b);
        this.i.q0(this.f63385b);
        this.f63386c.add(this.f63387d);
        this.f63386c.add(this.f63388e);
        this.f63386c.add(this.f63389f);
        this.f63386c.add(this.f63390g);
        this.f63386c.add(this.f63391h);
        this.f63386c.add(this.i);
        this.f63385b.a(this.f63386c);
    }

    public void c() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f63385b;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.getListAdapter().notifyDataSetChanged();
        }
    }

    public void d() {
    }

    public void e() {
        b bVar = this.f63388e;
        if (bVar != null) {
            bVar.onPause();
        }
    }

    public void f(List<n> list) {
        this.f63385b.setData(list);
    }

    public void g(NEGFeedBackView.b bVar) {
        f fVar = this.f63390g;
        if (fVar != null) {
            fVar.l0(bVar);
        }
        g gVar = this.f63387d;
        if (gVar != null) {
            gVar.l0(bVar);
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        g gVar = this.f63387d;
        if (gVar != null) {
            gVar.m0(bdUniqueId);
        }
        b bVar = this.f63388e;
        if (bVar != null) {
            bVar.r0(bdUniqueId);
        }
        e eVar = this.f63389f;
        if (eVar != null) {
            eVar.l0(bdUniqueId);
        }
        f fVar = this.f63390g;
        if (fVar != null) {
            fVar.m0(bdUniqueId);
        }
        d dVar = this.f63391h;
        if (dVar != null) {
            dVar.n0(bdUniqueId);
        }
        c cVar = this.i;
        if (cVar != null) {
            cVar.o0(bdUniqueId);
        }
    }

    public void i(d.b.i0.z0.g.k.e eVar) {
        b bVar = this.f63388e;
        if (bVar != null) {
            bVar.s0(eVar);
        }
        c cVar = this.i;
        if (cVar != null) {
            cVar.p0(eVar);
        }
    }
}
