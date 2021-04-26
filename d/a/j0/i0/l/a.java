package d.a.j0.i0.l;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tieba.enterForum.tabfeed.EnterForumTabFeedFragment;
import d.a.c.j.e.n;
import d.a.i0.r.q.a2;
import d.a.i0.r.q.u1;
import d.a.j0.i0.l.c.c;
import d.a.j0.i0.l.c.d;
import d.a.j0.i0.l.c.e;
import d.a.j0.i0.l.c.f;
import d.a.j0.i0.l.c.g;
import d.a.j0.i0.l.c.h;
import d.a.j0.i0.l.c.i;
import d.a.j0.i0.l.c.j;
import d.a.j0.i0.l.c.k;
import d.a.j0.i0.l.c.l;
import d.a.j0.i0.l.c.m;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public EnterForumTabFeedFragment f55139a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f55140b;

    /* renamed from: c  reason: collision with root package name */
    public k f55141c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.j0.i0.l.c.b f55142d;

    /* renamed from: e  reason: collision with root package name */
    public d f55143e;

    /* renamed from: f  reason: collision with root package name */
    public c f55144f;

    /* renamed from: g  reason: collision with root package name */
    public e f55145g;

    /* renamed from: h  reason: collision with root package name */
    public l f55146h;

    /* renamed from: i  reason: collision with root package name */
    public g f55147i;
    public i j;
    public h k;
    public f l;
    public j m;
    public d.a.j0.i0.l.c.a n;
    public m o;
    public List<d.a.c.j.e.a> p = new LinkedList();

    public a(EnterForumTabFeedFragment enterForumTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f55139a = enterForumTabFeedFragment;
        this.f55140b = bdTypeRecyclerView;
        a();
    }

    public final void a() {
        k kVar = new k(this.f55139a.getPageContext(), a2.N2, this.f55139a.getUniqueId(), this.f55139a.G0());
        this.f55141c = kVar;
        kVar.i0(this.f55140b);
        this.p.add(this.f55141c);
        d.a.j0.i0.l.c.b bVar = new d.a.j0.i0.l.c.b(this.f55139a.getPageContext(), a2.S2, this.f55139a.getUniqueId(), this.f55139a.G0());
        this.f55142d = bVar;
        bVar.j0(this.f55140b);
        this.p.add(this.f55142d);
        d dVar = new d(this.f55139a.getPageContext(), a2.Q2, this.f55139a.getUniqueId(), this.f55139a.G0());
        this.f55143e = dVar;
        dVar.i0(this.f55140b);
        this.p.add(this.f55143e);
        c cVar = new c(this.f55139a.getPageContext(), a2.R2, this.f55139a.getUniqueId(), this.f55139a.G0());
        this.f55144f = cVar;
        cVar.i0(this.f55140b);
        this.p.add(this.f55144f);
        e eVar = new e(this.f55139a.getPageContext(), a2.O2, this.f55139a.getUniqueId(), this.f55139a.G0());
        this.f55145g = eVar;
        eVar.i0(this.f55140b);
        this.p.add(this.f55145g);
        l lVar = new l(this.f55139a.getPageContext(), a2.e3, this.f55139a.getUniqueId(), this.f55139a.G0());
        this.f55146h = lVar;
        lVar.n0(this.f55140b);
        this.p.add(this.f55146h);
        g gVar = new g(this.f55139a.getPageContext(), a2.Y2, this.f55139a.getUniqueId(), this.f55139a.G0());
        this.f55147i = gVar;
        gVar.g0(this.f55140b);
        this.p.add(this.f55147i);
        i iVar = new i(this.f55139a.getPageContext(), a2.a3, this.f55139a.getUniqueId(), this.f55139a.G0());
        this.j = iVar;
        iVar.i0(this.f55140b);
        this.p.add(this.j);
        h hVar = new h(this.f55139a.getPageContext(), a2.b3, this.f55139a.getUniqueId(), this.f55139a.G0());
        this.k = hVar;
        hVar.g0(this.f55140b);
        this.p.add(this.k);
        f fVar = new f(this.f55139a.getPageContext(), a2.X2, this.f55139a.getUniqueId(), this.f55139a.G0());
        this.l = fVar;
        fVar.i0(this.f55140b);
        this.p.add(this.l);
        j jVar = new j(this.f55139a.getPageContext(), a2.T2, this.f55139a.getUniqueId(), this.f55139a.G0());
        this.m = jVar;
        jVar.i0(this.f55140b);
        this.p.add(this.m);
        d.a.j0.i0.l.c.a aVar = new d.a.j0.i0.l.c.a(this.f55139a.getPageContext(), a2.W2, this.f55139a.getUniqueId(), this.f55139a.G0());
        this.n = aVar;
        aVar.j0(this.f55140b);
        this.p.add(this.n);
        m mVar = new m(this.f55139a.getPageContext(), u1.f49269h, this.f55139a.getUniqueId(), this.f55139a.G0());
        this.o = mVar;
        mVar.h0(this.f55140b);
        this.p.add(this.o);
        this.f55140b.a(this.p);
    }

    public void b() {
        this.f55140b.getAdapter().notifyDataSetChanged();
    }

    public void c(ArrayList<n> arrayList) {
        this.f55140b.setData(arrayList);
    }

    public void d(boolean z) {
        d.a.j0.i0.l.c.b bVar = this.f55142d;
        if (bVar != null) {
            bVar.setFromCDN(z);
        }
        c cVar = this.f55144f;
        if (cVar != null) {
            cVar.setFromCDN(z);
        }
        d dVar = this.f55143e;
        if (dVar != null) {
            dVar.setFromCDN(z);
        }
    }
}
