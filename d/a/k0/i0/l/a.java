package d.a.k0.i0.l;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tieba.enterForum.tabfeed.EnterForumTabFeedFragment;
import d.a.c.j.e.n;
import d.a.j0.r.q.a2;
import d.a.j0.r.q.u1;
import d.a.k0.i0.l.c.c;
import d.a.k0.i0.l.c.d;
import d.a.k0.i0.l.c.e;
import d.a.k0.i0.l.c.f;
import d.a.k0.i0.l.c.g;
import d.a.k0.i0.l.c.h;
import d.a.k0.i0.l.c.i;
import d.a.k0.i0.l.c.j;
import d.a.k0.i0.l.c.k;
import d.a.k0.i0.l.c.l;
import d.a.k0.i0.l.c.m;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public EnterForumTabFeedFragment f55846a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f55847b;

    /* renamed from: c  reason: collision with root package name */
    public k f55848c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.k0.i0.l.c.b f55849d;

    /* renamed from: e  reason: collision with root package name */
    public d f55850e;

    /* renamed from: f  reason: collision with root package name */
    public c f55851f;

    /* renamed from: g  reason: collision with root package name */
    public e f55852g;

    /* renamed from: h  reason: collision with root package name */
    public l f55853h;

    /* renamed from: i  reason: collision with root package name */
    public g f55854i;
    public i j;
    public h k;
    public f l;
    public j m;
    public d.a.k0.i0.l.c.a n;
    public m o;
    public List<d.a.c.j.e.a> p = new LinkedList();

    public a(EnterForumTabFeedFragment enterForumTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f55846a = enterForumTabFeedFragment;
        this.f55847b = bdTypeRecyclerView;
        a();
    }

    public final void a() {
        k kVar = new k(this.f55846a.getPageContext(), a2.O2, this.f55846a.getUniqueId(), this.f55846a.F0());
        this.f55848c = kVar;
        kVar.i0(this.f55847b);
        this.p.add(this.f55848c);
        d.a.k0.i0.l.c.b bVar = new d.a.k0.i0.l.c.b(this.f55846a.getPageContext(), a2.T2, this.f55846a.getUniqueId(), this.f55846a.F0());
        this.f55849d = bVar;
        bVar.j0(this.f55847b);
        this.p.add(this.f55849d);
        d dVar = new d(this.f55846a.getPageContext(), a2.R2, this.f55846a.getUniqueId(), this.f55846a.F0());
        this.f55850e = dVar;
        dVar.i0(this.f55847b);
        this.p.add(this.f55850e);
        c cVar = new c(this.f55846a.getPageContext(), a2.S2, this.f55846a.getUniqueId(), this.f55846a.F0());
        this.f55851f = cVar;
        cVar.i0(this.f55847b);
        this.p.add(this.f55851f);
        e eVar = new e(this.f55846a.getPageContext(), a2.P2, this.f55846a.getUniqueId(), this.f55846a.F0());
        this.f55852g = eVar;
        eVar.i0(this.f55847b);
        this.p.add(this.f55852g);
        l lVar = new l(this.f55846a.getPageContext(), a2.f3, this.f55846a.getUniqueId(), this.f55846a.F0());
        this.f55853h = lVar;
        lVar.n0(this.f55847b);
        this.p.add(this.f55853h);
        g gVar = new g(this.f55846a.getPageContext(), a2.Z2, this.f55846a.getUniqueId(), this.f55846a.F0());
        this.f55854i = gVar;
        gVar.g0(this.f55847b);
        this.p.add(this.f55854i);
        i iVar = new i(this.f55846a.getPageContext(), a2.b3, this.f55846a.getUniqueId(), this.f55846a.F0());
        this.j = iVar;
        iVar.i0(this.f55847b);
        this.p.add(this.j);
        h hVar = new h(this.f55846a.getPageContext(), a2.c3, this.f55846a.getUniqueId(), this.f55846a.F0());
        this.k = hVar;
        hVar.g0(this.f55847b);
        this.p.add(this.k);
        f fVar = new f(this.f55846a.getPageContext(), a2.Y2, this.f55846a.getUniqueId(), this.f55846a.F0());
        this.l = fVar;
        fVar.i0(this.f55847b);
        this.p.add(this.l);
        j jVar = new j(this.f55846a.getPageContext(), a2.U2, this.f55846a.getUniqueId(), this.f55846a.F0());
        this.m = jVar;
        jVar.i0(this.f55847b);
        this.p.add(this.m);
        d.a.k0.i0.l.c.a aVar = new d.a.k0.i0.l.c.a(this.f55846a.getPageContext(), a2.X2, this.f55846a.getUniqueId(), this.f55846a.F0());
        this.n = aVar;
        aVar.j0(this.f55847b);
        this.p.add(this.n);
        m mVar = new m(this.f55846a.getPageContext(), u1.f50088h, this.f55846a.getUniqueId(), this.f55846a.F0());
        this.o = mVar;
        mVar.h0(this.f55847b);
        this.p.add(this.o);
        this.f55847b.a(this.p);
    }

    public void b() {
        this.f55847b.getAdapter().notifyDataSetChanged();
    }

    public void c(ArrayList<n> arrayList) {
        this.f55847b.setData(arrayList);
    }

    public void d(boolean z) {
        d.a.k0.i0.l.c.b bVar = this.f55849d;
        if (bVar != null) {
            bVar.setFromCDN(z);
        }
        c cVar = this.f55851f;
        if (cVar != null) {
            cVar.setFromCDN(z);
        }
        d dVar = this.f55850e;
        if (dVar != null) {
            dVar.setFromCDN(z);
        }
    }
}
