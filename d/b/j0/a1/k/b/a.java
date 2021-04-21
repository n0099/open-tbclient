package d.b.j0.a1.k.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import d.b.c.j.e.n;
import d.b.j0.x.e0.k;
import d.b.j0.x.e0.l;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f53424a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f53425b;

    /* renamed from: c  reason: collision with root package name */
    public LinkedList<d.b.c.j.e.a> f53426c = new LinkedList<>();

    /* renamed from: d  reason: collision with root package name */
    public g f53427d;

    /* renamed from: e  reason: collision with root package name */
    public b f53428e;

    /* renamed from: f  reason: collision with root package name */
    public e f53429f;

    /* renamed from: g  reason: collision with root package name */
    public f f53430g;

    /* renamed from: h  reason: collision with root package name */
    public d f53431h;
    public c i;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f53424a = tbPageContext;
        this.f53425b = bdTypeRecyclerView;
        b();
    }

    public List<n> a() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f53425b;
        if (bdTypeRecyclerView != null) {
            return bdTypeRecyclerView.getData();
        }
        return null;
    }

    public final void b() {
        this.f53427d = new g(this.f53424a, k.v0);
        this.f53428e = new b(this.f53424a, l.V);
        this.f53429f = new e(this.f53424a, k.D0);
        this.f53430g = new f(this.f53424a, k.B0);
        this.f53431h = new d(this.f53424a, k.w0);
        this.i = new c(this.f53424a, k.C0);
        this.f53427d.n0(this.f53425b);
        this.f53428e.t0(this.f53425b);
        this.f53429f.m0(this.f53425b);
        this.f53430g.n0(this.f53425b);
        this.f53431h.o0(this.f53425b);
        this.i.q0(this.f53425b);
        this.f53426c.add(this.f53427d);
        this.f53426c.add(this.f53428e);
        this.f53426c.add(this.f53429f);
        this.f53426c.add(this.f53430g);
        this.f53426c.add(this.f53431h);
        this.f53426c.add(this.i);
        this.f53425b.a(this.f53426c);
    }

    public void c() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f53425b;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.getListAdapter().notifyDataSetChanged();
        }
    }

    public void d() {
    }

    public void e() {
        b bVar = this.f53428e;
        if (bVar != null) {
            bVar.onPause();
        }
    }

    public void f(List<n> list) {
        this.f53425b.setData(list);
    }

    public void g(NEGFeedBackView.b bVar) {
        f fVar = this.f53430g;
        if (fVar != null) {
            fVar.l0(bVar);
        }
        g gVar = this.f53427d;
        if (gVar != null) {
            gVar.l0(bVar);
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        g gVar = this.f53427d;
        if (gVar != null) {
            gVar.m0(bdUniqueId);
        }
        b bVar = this.f53428e;
        if (bVar != null) {
            bVar.r0(bdUniqueId);
        }
        e eVar = this.f53429f;
        if (eVar != null) {
            eVar.l0(bdUniqueId);
        }
        f fVar = this.f53430g;
        if (fVar != null) {
            fVar.m0(bdUniqueId);
        }
        d dVar = this.f53431h;
        if (dVar != null) {
            dVar.n0(bdUniqueId);
        }
        c cVar = this.i;
        if (cVar != null) {
            cVar.o0(bdUniqueId);
        }
    }

    public void i(d.b.j0.a1.g.k.e eVar) {
        b bVar = this.f53428e;
        if (bVar != null) {
            bVar.s0(eVar);
        }
        c cVar = this.i;
        if (cVar != null) {
            cVar.p0(eVar);
        }
    }
}
