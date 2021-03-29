package d.b.i0.i0.l;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tieba.enterForum.tabfeed.EnterForumTabFeedFragment;
import d.b.b.j.e.n;
import d.b.h0.r.q.a2;
import d.b.h0.r.q.u1;
import d.b.i0.i0.l.c.c;
import d.b.i0.i0.l.c.d;
import d.b.i0.i0.l.c.e;
import d.b.i0.i0.l.c.f;
import d.b.i0.i0.l.c.g;
import d.b.i0.i0.l.c.h;
import d.b.i0.i0.l.c.i;
import d.b.i0.i0.l.c.j;
import d.b.i0.i0.l.c.k;
import d.b.i0.i0.l.c.l;
import d.b.i0.i0.l.c.m;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public EnterForumTabFeedFragment f55664a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f55665b;

    /* renamed from: c  reason: collision with root package name */
    public k f55666c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.i0.i0.l.c.b f55667d;

    /* renamed from: e  reason: collision with root package name */
    public d f55668e;

    /* renamed from: f  reason: collision with root package name */
    public c f55669f;

    /* renamed from: g  reason: collision with root package name */
    public e f55670g;

    /* renamed from: h  reason: collision with root package name */
    public l f55671h;
    public g i;
    public i j;
    public h k;
    public f l;
    public j m;
    public d.b.i0.i0.l.c.a n;
    public m o;
    public List<d.b.b.j.e.a> p = new LinkedList();

    public a(EnterForumTabFeedFragment enterForumTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f55664a = enterForumTabFeedFragment;
        this.f55665b = bdTypeRecyclerView;
        a();
    }

    public final void a() {
        k kVar = new k(this.f55664a.getPageContext(), a2.N2, this.f55664a.getUniqueId(), this.f55664a.G0());
        this.f55666c = kVar;
        kVar.m0(this.f55665b);
        this.p.add(this.f55666c);
        d.b.i0.i0.l.c.b bVar = new d.b.i0.i0.l.c.b(this.f55664a.getPageContext(), a2.S2, this.f55664a.getUniqueId(), this.f55664a.G0());
        this.f55667d = bVar;
        bVar.n0(this.f55665b);
        this.p.add(this.f55667d);
        d dVar = new d(this.f55664a.getPageContext(), a2.Q2, this.f55664a.getUniqueId(), this.f55664a.G0());
        this.f55668e = dVar;
        dVar.m0(this.f55665b);
        this.p.add(this.f55668e);
        c cVar = new c(this.f55664a.getPageContext(), a2.R2, this.f55664a.getUniqueId(), this.f55664a.G0());
        this.f55669f = cVar;
        cVar.m0(this.f55665b);
        this.p.add(this.f55669f);
        e eVar = new e(this.f55664a.getPageContext(), a2.O2, this.f55664a.getUniqueId(), this.f55664a.G0());
        this.f55670g = eVar;
        eVar.m0(this.f55665b);
        this.p.add(this.f55670g);
        l lVar = new l(this.f55664a.getPageContext(), a2.e3, this.f55664a.getUniqueId(), this.f55664a.G0());
        this.f55671h = lVar;
        lVar.p0(this.f55665b);
        this.p.add(this.f55671h);
        g gVar = new g(this.f55664a.getPageContext(), a2.Y2, this.f55664a.getUniqueId(), this.f55664a.G0());
        this.i = gVar;
        gVar.j0(this.f55665b);
        this.p.add(this.i);
        i iVar = new i(this.f55664a.getPageContext(), a2.a3, this.f55664a.getUniqueId(), this.f55664a.G0());
        this.j = iVar;
        iVar.m0(this.f55665b);
        this.p.add(this.j);
        h hVar = new h(this.f55664a.getPageContext(), a2.b3, this.f55664a.getUniqueId(), this.f55664a.G0());
        this.k = hVar;
        hVar.j0(this.f55665b);
        this.p.add(this.k);
        f fVar = new f(this.f55664a.getPageContext(), a2.X2, this.f55664a.getUniqueId(), this.f55664a.G0());
        this.l = fVar;
        fVar.m0(this.f55665b);
        this.p.add(this.l);
        j jVar = new j(this.f55664a.getPageContext(), a2.T2, this.f55664a.getUniqueId(), this.f55664a.G0());
        this.m = jVar;
        jVar.m0(this.f55665b);
        this.p.add(this.m);
        d.b.i0.i0.l.c.a aVar = new d.b.i0.i0.l.c.a(this.f55664a.getPageContext(), a2.W2, this.f55664a.getUniqueId(), this.f55664a.G0());
        this.n = aVar;
        aVar.n0(this.f55665b);
        this.p.add(this.n);
        m mVar = new m(this.f55664a.getPageContext(), u1.f50893h, this.f55664a.getUniqueId(), this.f55664a.G0());
        this.o = mVar;
        mVar.l0(this.f55665b);
        this.p.add(this.o);
        this.f55665b.a(this.p);
    }

    public void b() {
        this.f55665b.getAdapter().notifyDataSetChanged();
    }

    public void c(ArrayList<n> arrayList) {
        this.f55665b.setData(arrayList);
    }

    public void d(boolean z) {
        d.b.i0.i0.l.c.b bVar = this.f55667d;
        if (bVar != null) {
            bVar.setFromCDN(z);
        }
        c cVar = this.f55669f;
        if (cVar != null) {
            cVar.setFromCDN(z);
        }
        d dVar = this.f55668e;
        if (dVar != null) {
            dVar.setFromCDN(z);
        }
    }
}
