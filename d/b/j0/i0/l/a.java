package d.b.j0.i0.l;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tieba.enterForum.tabfeed.EnterForumTabFeedFragment;
import d.b.c.j.e.n;
import d.b.i0.r.q.a2;
import d.b.i0.r.q.u1;
import d.b.j0.i0.l.c.c;
import d.b.j0.i0.l.c.d;
import d.b.j0.i0.l.c.e;
import d.b.j0.i0.l.c.f;
import d.b.j0.i0.l.c.g;
import d.b.j0.i0.l.c.h;
import d.b.j0.i0.l.c.i;
import d.b.j0.i0.l.c.j;
import d.b.j0.i0.l.c.k;
import d.b.j0.i0.l.c.l;
import d.b.j0.i0.l.c.m;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public EnterForumTabFeedFragment f57208a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f57209b;

    /* renamed from: c  reason: collision with root package name */
    public k f57210c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.j0.i0.l.c.b f57211d;

    /* renamed from: e  reason: collision with root package name */
    public d f57212e;

    /* renamed from: f  reason: collision with root package name */
    public c f57213f;

    /* renamed from: g  reason: collision with root package name */
    public e f57214g;

    /* renamed from: h  reason: collision with root package name */
    public l f57215h;
    public g i;
    public i j;
    public h k;
    public f l;
    public j m;
    public d.b.j0.i0.l.c.a n;
    public m o;
    public List<d.b.c.j.e.a> p = new LinkedList();

    public a(EnterForumTabFeedFragment enterForumTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f57208a = enterForumTabFeedFragment;
        this.f57209b = bdTypeRecyclerView;
        a();
    }

    public final void a() {
        k kVar = new k(this.f57208a.getPageContext(), a2.N2, this.f57208a.getUniqueId(), this.f57208a.G0());
        this.f57210c = kVar;
        kVar.m0(this.f57209b);
        this.p.add(this.f57210c);
        d.b.j0.i0.l.c.b bVar = new d.b.j0.i0.l.c.b(this.f57208a.getPageContext(), a2.S2, this.f57208a.getUniqueId(), this.f57208a.G0());
        this.f57211d = bVar;
        bVar.n0(this.f57209b);
        this.p.add(this.f57211d);
        d dVar = new d(this.f57208a.getPageContext(), a2.Q2, this.f57208a.getUniqueId(), this.f57208a.G0());
        this.f57212e = dVar;
        dVar.m0(this.f57209b);
        this.p.add(this.f57212e);
        c cVar = new c(this.f57208a.getPageContext(), a2.R2, this.f57208a.getUniqueId(), this.f57208a.G0());
        this.f57213f = cVar;
        cVar.m0(this.f57209b);
        this.p.add(this.f57213f);
        e eVar = new e(this.f57208a.getPageContext(), a2.O2, this.f57208a.getUniqueId(), this.f57208a.G0());
        this.f57214g = eVar;
        eVar.m0(this.f57209b);
        this.p.add(this.f57214g);
        l lVar = new l(this.f57208a.getPageContext(), a2.e3, this.f57208a.getUniqueId(), this.f57208a.G0());
        this.f57215h = lVar;
        lVar.p0(this.f57209b);
        this.p.add(this.f57215h);
        g gVar = new g(this.f57208a.getPageContext(), a2.Y2, this.f57208a.getUniqueId(), this.f57208a.G0());
        this.i = gVar;
        gVar.j0(this.f57209b);
        this.p.add(this.i);
        i iVar = new i(this.f57208a.getPageContext(), a2.a3, this.f57208a.getUniqueId(), this.f57208a.G0());
        this.j = iVar;
        iVar.m0(this.f57209b);
        this.p.add(this.j);
        h hVar = new h(this.f57208a.getPageContext(), a2.b3, this.f57208a.getUniqueId(), this.f57208a.G0());
        this.k = hVar;
        hVar.j0(this.f57209b);
        this.p.add(this.k);
        f fVar = new f(this.f57208a.getPageContext(), a2.X2, this.f57208a.getUniqueId(), this.f57208a.G0());
        this.l = fVar;
        fVar.m0(this.f57209b);
        this.p.add(this.l);
        j jVar = new j(this.f57208a.getPageContext(), a2.T2, this.f57208a.getUniqueId(), this.f57208a.G0());
        this.m = jVar;
        jVar.m0(this.f57209b);
        this.p.add(this.m);
        d.b.j0.i0.l.c.a aVar = new d.b.j0.i0.l.c.a(this.f57208a.getPageContext(), a2.W2, this.f57208a.getUniqueId(), this.f57208a.G0());
        this.n = aVar;
        aVar.n0(this.f57209b);
        this.p.add(this.n);
        m mVar = new m(this.f57208a.getPageContext(), u1.f51636h, this.f57208a.getUniqueId(), this.f57208a.G0());
        this.o = mVar;
        mVar.l0(this.f57209b);
        this.p.add(this.o);
        this.f57209b.a(this.p);
    }

    public void b() {
        this.f57209b.getAdapter().notifyDataSetChanged();
    }

    public void c(ArrayList<n> arrayList) {
        this.f57209b.setData(arrayList);
    }

    public void d(boolean z) {
        d.b.j0.i0.l.c.b bVar = this.f57211d;
        if (bVar != null) {
            bVar.setFromCDN(z);
        }
        c cVar = this.f57213f;
        if (cVar != null) {
            cVar.setFromCDN(z);
        }
        d dVar = this.f57212e;
        if (dVar != null) {
            dVar.setFromCDN(z);
        }
    }
}
