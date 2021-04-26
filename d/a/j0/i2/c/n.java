package d.a.j0.i2.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    public m f55378a;

    /* renamed from: b  reason: collision with root package name */
    public b f55379b;

    /* renamed from: c  reason: collision with root package name */
    public i f55380c;

    /* renamed from: d  reason: collision with root package name */
    public a f55381d;

    /* renamed from: e  reason: collision with root package name */
    public c f55382e;

    /* renamed from: f  reason: collision with root package name */
    public h f55383f;

    /* renamed from: g  reason: collision with root package name */
    public e f55384g;

    /* renamed from: h  reason: collision with root package name */
    public k f55385h;

    /* renamed from: i  reason: collision with root package name */
    public d f55386i;
    public d.a.j0.f2.h.d j;
    public d.a.j0.f2.h.a k;
    public p l;
    public d.a.j0.i2.c.q.g m;
    public d.a.j0.i2.c.q.d n;
    public d.a.j0.i2.c.q.i o;
    public d.a.j0.i2.c.q.h p;
    public d.a.j0.i2.c.q.a q;
    public d.a.j0.i2.c.q.c r;
    public d.a.j0.i2.c.q.b s;
    public d.a.j0.i2.c.q.e t;
    public d.a.j0.i2.c.q.f u;
    public List<d.a.c.j.e.a> v = new ArrayList();
    public BdTypeRecyclerView w;

    public n(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, BdUniqueId bdUniqueId) {
        a(tbPageContext, bdTypeRecyclerView);
        e(bdUniqueId);
    }

    public final void a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.w = bdTypeRecyclerView;
        this.f55378a = new m(tbPageContext);
        this.f55379b = new b(tbPageContext);
        this.f55380c = new i(tbPageContext);
        this.f55381d = new a(tbPageContext);
        this.f55382e = new c(tbPageContext);
        this.f55383f = new h(tbPageContext, tbPageContext.getUniqueId());
        this.f55384g = new e(tbPageContext, d.a.j0.i2.e.g.l);
        this.f55385h = new k(tbPageContext);
        this.f55386i = new d(tbPageContext);
        this.j = new d.a.j0.f2.h.d(tbPageContext, d.a.j0.f2.h.f.f54297f);
        this.k = new d.a.j0.f2.h.a(tbPageContext.getPageActivity(), d.a.j0.f2.d.f54269h);
        this.l = new p(tbPageContext, PersonPostModel.PostInfoList.POST_INFO);
        this.m = new d.a.j0.i2.c.q.g(tbPageContext, d.a.j0.x.e0.k.l0);
        this.n = new d.a.j0.i2.c.q.d(tbPageContext, d.a.j0.x.e0.k.n0);
        this.o = new d.a.j0.i2.c.q.i(tbPageContext, d.a.j0.x.e0.l.V);
        this.p = new d.a.j0.i2.c.q.h(tbPageContext, d.a.j0.x.e0.k.o0);
        this.s = new d.a.j0.i2.c.q.b(tbPageContext, d.a.j0.x.e0.k.q0);
        this.t = new d.a.j0.i2.c.q.e(tbPageContext, d.a.j0.x.e0.k.p0);
        this.u = new d.a.j0.i2.c.q.f(tbPageContext, d.a.j0.x.e0.k.r0);
        this.q = new d.a.j0.i2.c.q.a(tbPageContext, d.a.j0.x.e0.e.M0);
        this.r = new d.a.j0.i2.c.q.c(tbPageContext, d.a.j0.x.e0.f.M0);
        this.v.add(this.f55378a);
        this.v.add(this.f55379b);
        this.v.add(this.f55380c);
        this.v.add(this.f55381d);
        this.v.add(this.f55382e);
        this.v.add(this.f55383f);
        this.v.add(this.f55384g);
        this.v.add(this.f55385h);
        this.v.add(this.f55386i);
        this.v.add(this.j);
        this.v.add(this.k);
        this.v.add(this.l);
        this.v.add(this.m);
        this.v.add(this.n);
        this.v.add(this.o);
        this.v.add(this.p);
        this.v.add(this.s);
        this.v.add(this.t);
        this.v.add(this.u);
        this.v.add(this.q);
        this.v.add(this.r);
        bdTypeRecyclerView.a(this.v);
        c("page_recommend");
    }

    public void b() {
        if (this.w.getListAdapter() != null) {
            this.w.getListAdapter().notifyDataSetChanged();
        }
    }

    public final void c(String str) {
        List<d.a.c.j.e.a> list = this.v;
        if (list == null) {
            return;
        }
        for (d.a.c.j.e.a aVar : list) {
            if (aVar instanceof d.a.j0.m.f) {
                ((d.a.j0.m.f) aVar).g(str);
            }
        }
    }

    public void d(boolean z) {
        this.l.g0(z);
        this.f55380c.i0(z);
        this.m.j0(z);
        this.n.h0(z);
        this.o.i0(z);
        this.p.h0(z);
        this.q.m0(z);
        this.r.j0(z);
        this.s.j0(z);
        this.t.j0(z);
        this.u.j0(z);
    }

    public void e(BdUniqueId bdUniqueId) {
        this.m.m = bdUniqueId;
        this.n.m = bdUniqueId;
        this.o.m = bdUniqueId;
        this.p.m = bdUniqueId;
        this.s.m = bdUniqueId;
        this.t.m = bdUniqueId;
        this.u.m = bdUniqueId;
        this.q.m = bdUniqueId;
        this.r.m = bdUniqueId;
    }

    public void f(int i2) {
        this.m.m0(i2);
        this.n.i0(i2);
        this.o.j0(i2);
        this.p.i0(i2);
        this.q.n0(i2);
        this.r.m0(i2);
        this.s.m0(i2);
        this.t.m0(i2);
        this.u.m0(i2);
    }

    public void g(int i2) {
        this.m.n0(i2);
        this.n.j0(i2);
        this.o.m0(i2);
        this.p.j0(i2);
        this.q.p0(i2);
        this.r.n0(i2);
        this.s.n0(i2);
        this.t.n0(i2);
        this.u.n0(i2);
    }

    public void h(int i2) {
        this.m.p0(i2);
        this.n.m0(i2);
        this.o.n0(i2);
        this.p.m0(i2);
        this.q.q0(i2);
        this.r.p0(i2);
        this.s.p0(i2);
        this.t.p0(i2);
        this.u.p0(i2);
    }
}
