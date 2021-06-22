package d.a.o0.j0.l;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tieba.enterForum.tabfeed.EnterForumTabFeedFragment;
import d.a.c.k.e.n;
import d.a.n0.r.q.a2;
import d.a.n0.r.q.u1;
import d.a.o0.j0.l.c.c;
import d.a.o0.j0.l.c.d;
import d.a.o0.j0.l.c.e;
import d.a.o0.j0.l.c.f;
import d.a.o0.j0.l.c.g;
import d.a.o0.j0.l.c.h;
import d.a.o0.j0.l.c.i;
import d.a.o0.j0.l.c.j;
import d.a.o0.j0.l.c.k;
import d.a.o0.j0.l.c.l;
import d.a.o0.j0.l.c.m;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public EnterForumTabFeedFragment f59844a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f59845b;

    /* renamed from: c  reason: collision with root package name */
    public k f59846c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.o0.j0.l.c.b f59847d;

    /* renamed from: e  reason: collision with root package name */
    public d f59848e;

    /* renamed from: f  reason: collision with root package name */
    public c f59849f;

    /* renamed from: g  reason: collision with root package name */
    public e f59850g;

    /* renamed from: h  reason: collision with root package name */
    public l f59851h;

    /* renamed from: i  reason: collision with root package name */
    public g f59852i;
    public i j;
    public h k;
    public f l;
    public j m;
    public d.a.o0.j0.l.c.a n;
    public m o;
    public List<d.a.c.k.e.a> p = new LinkedList();

    public a(EnterForumTabFeedFragment enterForumTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f59844a = enterForumTabFeedFragment;
        this.f59845b = bdTypeRecyclerView;
        a();
    }

    public final void a() {
        k kVar = new k(this.f59844a.getPageContext(), a2.S2, this.f59844a.getUniqueId(), this.f59844a.I0());
        this.f59846c = kVar;
        kVar.j0(this.f59845b);
        this.p.add(this.f59846c);
        d.a.o0.j0.l.c.b bVar = new d.a.o0.j0.l.c.b(this.f59844a.getPageContext(), a2.X2, this.f59844a.getUniqueId(), this.f59844a.I0());
        this.f59847d = bVar;
        bVar.k0(this.f59845b);
        this.p.add(this.f59847d);
        d dVar = new d(this.f59844a.getPageContext(), a2.V2, this.f59844a.getUniqueId(), this.f59844a.I0());
        this.f59848e = dVar;
        dVar.j0(this.f59845b);
        this.p.add(this.f59848e);
        c cVar = new c(this.f59844a.getPageContext(), a2.W2, this.f59844a.getUniqueId(), this.f59844a.I0());
        this.f59849f = cVar;
        cVar.j0(this.f59845b);
        this.p.add(this.f59849f);
        e eVar = new e(this.f59844a.getPageContext(), a2.T2, this.f59844a.getUniqueId(), this.f59844a.I0());
        this.f59850g = eVar;
        eVar.j0(this.f59845b);
        this.p.add(this.f59850g);
        l lVar = new l(this.f59844a.getPageContext(), a2.j3, this.f59844a.getUniqueId(), this.f59844a.I0());
        this.f59851h = lVar;
        lVar.m0(this.f59845b);
        this.p.add(this.f59851h);
        g gVar = new g(this.f59844a.getPageContext(), a2.d3, this.f59844a.getUniqueId(), this.f59844a.I0());
        this.f59852i = gVar;
        gVar.h0(this.f59845b);
        this.p.add(this.f59852i);
        i iVar = new i(this.f59844a.getPageContext(), a2.f3, this.f59844a.getUniqueId(), this.f59844a.I0());
        this.j = iVar;
        iVar.j0(this.f59845b);
        this.p.add(this.j);
        h hVar = new h(this.f59844a.getPageContext(), a2.g3, this.f59844a.getUniqueId(), this.f59844a.I0());
        this.k = hVar;
        hVar.h0(this.f59845b);
        this.p.add(this.k);
        f fVar = new f(this.f59844a.getPageContext(), a2.c3, this.f59844a.getUniqueId(), this.f59844a.I0());
        this.l = fVar;
        fVar.j0(this.f59845b);
        this.p.add(this.l);
        j jVar = new j(this.f59844a.getPageContext(), a2.Y2, this.f59844a.getUniqueId(), this.f59844a.I0());
        this.m = jVar;
        jVar.j0(this.f59845b);
        this.p.add(this.m);
        d.a.o0.j0.l.c.a aVar = new d.a.o0.j0.l.c.a(this.f59844a.getPageContext(), a2.b3, this.f59844a.getUniqueId(), this.f59844a.I0());
        this.n = aVar;
        aVar.k0(this.f59845b);
        this.p.add(this.n);
        m mVar = new m(this.f59844a.getPageContext(), u1.f53915h, this.f59844a.getUniqueId(), this.f59844a.I0());
        this.o = mVar;
        mVar.i0(this.f59845b);
        this.p.add(this.o);
        this.f59845b.a(this.p);
    }

    public void b() {
        this.f59845b.getAdapter().notifyDataSetChanged();
    }

    public void c(ArrayList<n> arrayList) {
        this.f59845b.setData(arrayList);
    }

    public void d(boolean z) {
        d.a.o0.j0.l.c.b bVar = this.f59847d;
        if (bVar != null) {
            bVar.setFromCDN(z);
        }
        c cVar = this.f59849f;
        if (cVar != null) {
            cVar.setFromCDN(z);
        }
        d dVar = this.f59848e;
        if (dVar != null) {
            dVar.setFromCDN(z);
        }
    }
}
