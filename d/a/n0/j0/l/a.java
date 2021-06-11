package d.a.n0.j0.l;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tieba.enterForum.tabfeed.EnterForumTabFeedFragment;
import d.a.c.k.e.n;
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
    public EnterForumTabFeedFragment f59719a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f59720b;

    /* renamed from: c  reason: collision with root package name */
    public k f59721c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.n0.j0.l.c.b f59722d;

    /* renamed from: e  reason: collision with root package name */
    public d f59723e;

    /* renamed from: f  reason: collision with root package name */
    public c f59724f;

    /* renamed from: g  reason: collision with root package name */
    public e f59725g;

    /* renamed from: h  reason: collision with root package name */
    public l f59726h;

    /* renamed from: i  reason: collision with root package name */
    public g f59727i;
    public i j;
    public h k;
    public f l;
    public j m;
    public d.a.n0.j0.l.c.a n;
    public m o;
    public List<d.a.c.k.e.a> p = new LinkedList();

    public a(EnterForumTabFeedFragment enterForumTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f59719a = enterForumTabFeedFragment;
        this.f59720b = bdTypeRecyclerView;
        a();
    }

    public final void a() {
        k kVar = new k(this.f59719a.getPageContext(), a2.S2, this.f59719a.getUniqueId(), this.f59719a.I0());
        this.f59721c = kVar;
        kVar.j0(this.f59720b);
        this.p.add(this.f59721c);
        d.a.n0.j0.l.c.b bVar = new d.a.n0.j0.l.c.b(this.f59719a.getPageContext(), a2.X2, this.f59719a.getUniqueId(), this.f59719a.I0());
        this.f59722d = bVar;
        bVar.k0(this.f59720b);
        this.p.add(this.f59722d);
        d dVar = new d(this.f59719a.getPageContext(), a2.V2, this.f59719a.getUniqueId(), this.f59719a.I0());
        this.f59723e = dVar;
        dVar.j0(this.f59720b);
        this.p.add(this.f59723e);
        c cVar = new c(this.f59719a.getPageContext(), a2.W2, this.f59719a.getUniqueId(), this.f59719a.I0());
        this.f59724f = cVar;
        cVar.j0(this.f59720b);
        this.p.add(this.f59724f);
        e eVar = new e(this.f59719a.getPageContext(), a2.T2, this.f59719a.getUniqueId(), this.f59719a.I0());
        this.f59725g = eVar;
        eVar.j0(this.f59720b);
        this.p.add(this.f59725g);
        l lVar = new l(this.f59719a.getPageContext(), a2.j3, this.f59719a.getUniqueId(), this.f59719a.I0());
        this.f59726h = lVar;
        lVar.m0(this.f59720b);
        this.p.add(this.f59726h);
        g gVar = new g(this.f59719a.getPageContext(), a2.d3, this.f59719a.getUniqueId(), this.f59719a.I0());
        this.f59727i = gVar;
        gVar.h0(this.f59720b);
        this.p.add(this.f59727i);
        i iVar = new i(this.f59719a.getPageContext(), a2.f3, this.f59719a.getUniqueId(), this.f59719a.I0());
        this.j = iVar;
        iVar.j0(this.f59720b);
        this.p.add(this.j);
        h hVar = new h(this.f59719a.getPageContext(), a2.g3, this.f59719a.getUniqueId(), this.f59719a.I0());
        this.k = hVar;
        hVar.h0(this.f59720b);
        this.p.add(this.k);
        f fVar = new f(this.f59719a.getPageContext(), a2.c3, this.f59719a.getUniqueId(), this.f59719a.I0());
        this.l = fVar;
        fVar.j0(this.f59720b);
        this.p.add(this.l);
        j jVar = new j(this.f59719a.getPageContext(), a2.Y2, this.f59719a.getUniqueId(), this.f59719a.I0());
        this.m = jVar;
        jVar.j0(this.f59720b);
        this.p.add(this.m);
        d.a.n0.j0.l.c.a aVar = new d.a.n0.j0.l.c.a(this.f59719a.getPageContext(), a2.b3, this.f59719a.getUniqueId(), this.f59719a.I0());
        this.n = aVar;
        aVar.k0(this.f59720b);
        this.p.add(this.n);
        m mVar = new m(this.f59719a.getPageContext(), u1.f53808h, this.f59719a.getUniqueId(), this.f59719a.I0());
        this.o = mVar;
        mVar.i0(this.f59720b);
        this.p.add(this.o);
        this.f59720b.a(this.p);
    }

    public void b() {
        this.f59720b.getAdapter().notifyDataSetChanged();
    }

    public void c(ArrayList<n> arrayList) {
        this.f59720b.setData(arrayList);
    }

    public void d(boolean z) {
        d.a.n0.j0.l.c.b bVar = this.f59722d;
        if (bVar != null) {
            bVar.setFromCDN(z);
        }
        c cVar = this.f59724f;
        if (cVar != null) {
            cVar.setFromCDN(z);
        }
        d dVar = this.f59723e;
        if (dVar != null) {
            dVar.setFromCDN(z);
        }
    }
}
