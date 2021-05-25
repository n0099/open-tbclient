package d.a.n0.j0.l;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tieba.enterForum.tabfeed.EnterForumTabFeedFragment;
import d.a.c.j.e.n;
import d.a.m0.r.q.a2;
import d.a.m0.r.q.u1;
import d.a.n0.j0.l.c.c;
import d.a.n0.j0.l.c.d;
import d.a.n0.j0.l.c.e;
import d.a.n0.j0.l.c.f;
import d.a.n0.j0.l.c.g;
import d.a.n0.j0.l.c.h;
import d.a.n0.j0.l.c.i;
import d.a.n0.j0.l.c.j;
import d.a.n0.j0.l.c.k;
import d.a.n0.j0.l.c.l;
import d.a.n0.j0.l.c.m;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public EnterForumTabFeedFragment f56030a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f56031b;

    /* renamed from: c  reason: collision with root package name */
    public k f56032c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.n0.j0.l.c.b f56033d;

    /* renamed from: e  reason: collision with root package name */
    public d f56034e;

    /* renamed from: f  reason: collision with root package name */
    public c f56035f;

    /* renamed from: g  reason: collision with root package name */
    public e f56036g;

    /* renamed from: h  reason: collision with root package name */
    public l f56037h;

    /* renamed from: i  reason: collision with root package name */
    public g f56038i;
    public i j;
    public h k;
    public f l;
    public j m;
    public d.a.n0.j0.l.c.a n;
    public m o;
    public List<d.a.c.j.e.a> p = new LinkedList();

    public a(EnterForumTabFeedFragment enterForumTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f56030a = enterForumTabFeedFragment;
        this.f56031b = bdTypeRecyclerView;
        a();
    }

    public final void a() {
        k kVar = new k(this.f56030a.getPageContext(), a2.P2, this.f56030a.getUniqueId(), this.f56030a.F0());
        this.f56032c = kVar;
        kVar.i0(this.f56031b);
        this.p.add(this.f56032c);
        d.a.n0.j0.l.c.b bVar = new d.a.n0.j0.l.c.b(this.f56030a.getPageContext(), a2.U2, this.f56030a.getUniqueId(), this.f56030a.F0());
        this.f56033d = bVar;
        bVar.j0(this.f56031b);
        this.p.add(this.f56033d);
        d dVar = new d(this.f56030a.getPageContext(), a2.S2, this.f56030a.getUniqueId(), this.f56030a.F0());
        this.f56034e = dVar;
        dVar.i0(this.f56031b);
        this.p.add(this.f56034e);
        c cVar = new c(this.f56030a.getPageContext(), a2.T2, this.f56030a.getUniqueId(), this.f56030a.F0());
        this.f56035f = cVar;
        cVar.i0(this.f56031b);
        this.p.add(this.f56035f);
        e eVar = new e(this.f56030a.getPageContext(), a2.Q2, this.f56030a.getUniqueId(), this.f56030a.F0());
        this.f56036g = eVar;
        eVar.i0(this.f56031b);
        this.p.add(this.f56036g);
        l lVar = new l(this.f56030a.getPageContext(), a2.g3, this.f56030a.getUniqueId(), this.f56030a.F0());
        this.f56037h = lVar;
        lVar.n0(this.f56031b);
        this.p.add(this.f56037h);
        g gVar = new g(this.f56030a.getPageContext(), a2.a3, this.f56030a.getUniqueId(), this.f56030a.F0());
        this.f56038i = gVar;
        gVar.g0(this.f56031b);
        this.p.add(this.f56038i);
        i iVar = new i(this.f56030a.getPageContext(), a2.c3, this.f56030a.getUniqueId(), this.f56030a.F0());
        this.j = iVar;
        iVar.i0(this.f56031b);
        this.p.add(this.j);
        h hVar = new h(this.f56030a.getPageContext(), a2.d3, this.f56030a.getUniqueId(), this.f56030a.F0());
        this.k = hVar;
        hVar.g0(this.f56031b);
        this.p.add(this.k);
        f fVar = new f(this.f56030a.getPageContext(), a2.Z2, this.f56030a.getUniqueId(), this.f56030a.F0());
        this.l = fVar;
        fVar.i0(this.f56031b);
        this.p.add(this.l);
        j jVar = new j(this.f56030a.getPageContext(), a2.V2, this.f56030a.getUniqueId(), this.f56030a.F0());
        this.m = jVar;
        jVar.i0(this.f56031b);
        this.p.add(this.m);
        d.a.n0.j0.l.c.a aVar = new d.a.n0.j0.l.c.a(this.f56030a.getPageContext(), a2.Y2, this.f56030a.getUniqueId(), this.f56030a.F0());
        this.n = aVar;
        aVar.j0(this.f56031b);
        this.p.add(this.n);
        m mVar = new m(this.f56030a.getPageContext(), u1.f50132h, this.f56030a.getUniqueId(), this.f56030a.F0());
        this.o = mVar;
        mVar.h0(this.f56031b);
        this.p.add(this.o);
        this.f56031b.a(this.p);
    }

    public void b() {
        this.f56031b.getAdapter().notifyDataSetChanged();
    }

    public void c(ArrayList<n> arrayList) {
        this.f56031b.setData(arrayList);
    }

    public void d(boolean z) {
        d.a.n0.j0.l.c.b bVar = this.f56033d;
        if (bVar != null) {
            bVar.setFromCDN(z);
        }
        c cVar = this.f56035f;
        if (cVar != null) {
            cVar.setFromCDN(z);
        }
        d dVar = this.f56034e;
        if (dVar != null) {
            dVar.setFromCDN(z);
        }
    }
}
