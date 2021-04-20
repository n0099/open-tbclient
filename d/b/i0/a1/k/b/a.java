package d.b.i0.a1.k.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import d.b.c.j.e.n;
import d.b.i0.x.e0.k;
import d.b.i0.x.e0.l;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f53003a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f53004b;

    /* renamed from: c  reason: collision with root package name */
    public LinkedList<d.b.c.j.e.a> f53005c = new LinkedList<>();

    /* renamed from: d  reason: collision with root package name */
    public g f53006d;

    /* renamed from: e  reason: collision with root package name */
    public b f53007e;

    /* renamed from: f  reason: collision with root package name */
    public e f53008f;

    /* renamed from: g  reason: collision with root package name */
    public f f53009g;

    /* renamed from: h  reason: collision with root package name */
    public d f53010h;
    public c i;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f53003a = tbPageContext;
        this.f53004b = bdTypeRecyclerView;
        b();
    }

    public List<n> a() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f53004b;
        if (bdTypeRecyclerView != null) {
            return bdTypeRecyclerView.getData();
        }
        return null;
    }

    public final void b() {
        this.f53006d = new g(this.f53003a, k.v0);
        this.f53007e = new b(this.f53003a, l.V);
        this.f53008f = new e(this.f53003a, k.D0);
        this.f53009g = new f(this.f53003a, k.B0);
        this.f53010h = new d(this.f53003a, k.w0);
        this.i = new c(this.f53003a, k.C0);
        this.f53006d.n0(this.f53004b);
        this.f53007e.t0(this.f53004b);
        this.f53008f.m0(this.f53004b);
        this.f53009g.n0(this.f53004b);
        this.f53010h.o0(this.f53004b);
        this.i.q0(this.f53004b);
        this.f53005c.add(this.f53006d);
        this.f53005c.add(this.f53007e);
        this.f53005c.add(this.f53008f);
        this.f53005c.add(this.f53009g);
        this.f53005c.add(this.f53010h);
        this.f53005c.add(this.i);
        this.f53004b.a(this.f53005c);
    }

    public void c() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f53004b;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.getListAdapter().notifyDataSetChanged();
        }
    }

    public void d() {
    }

    public void e() {
        b bVar = this.f53007e;
        if (bVar != null) {
            bVar.onPause();
        }
    }

    public void f(List<n> list) {
        this.f53004b.setData(list);
    }

    public void g(NEGFeedBackView.b bVar) {
        f fVar = this.f53009g;
        if (fVar != null) {
            fVar.l0(bVar);
        }
        g gVar = this.f53006d;
        if (gVar != null) {
            gVar.l0(bVar);
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        g gVar = this.f53006d;
        if (gVar != null) {
            gVar.m0(bdUniqueId);
        }
        b bVar = this.f53007e;
        if (bVar != null) {
            bVar.r0(bdUniqueId);
        }
        e eVar = this.f53008f;
        if (eVar != null) {
            eVar.l0(bdUniqueId);
        }
        f fVar = this.f53009g;
        if (fVar != null) {
            fVar.m0(bdUniqueId);
        }
        d dVar = this.f53010h;
        if (dVar != null) {
            dVar.n0(bdUniqueId);
        }
        c cVar = this.i;
        if (cVar != null) {
            cVar.o0(bdUniqueId);
        }
    }

    public void i(d.b.i0.a1.g.k.e eVar) {
        b bVar = this.f53007e;
        if (bVar != null) {
            bVar.s0(eVar);
        }
        c cVar = this.i;
        if (cVar != null) {
            cVar.p0(eVar);
        }
    }
}
