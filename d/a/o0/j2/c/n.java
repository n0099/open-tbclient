package d.a.o0.j2.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    public m f60083a;

    /* renamed from: b  reason: collision with root package name */
    public b f60084b;

    /* renamed from: c  reason: collision with root package name */
    public i f60085c;

    /* renamed from: d  reason: collision with root package name */
    public a f60086d;

    /* renamed from: e  reason: collision with root package name */
    public c f60087e;

    /* renamed from: f  reason: collision with root package name */
    public h f60088f;

    /* renamed from: g  reason: collision with root package name */
    public e f60089g;

    /* renamed from: h  reason: collision with root package name */
    public k f60090h;

    /* renamed from: i  reason: collision with root package name */
    public d f60091i;
    public d.a.o0.g2.h.d j;
    public d.a.o0.g2.h.a k;
    public p l;
    public d.a.o0.j2.c.q.g m;
    public d.a.o0.j2.c.q.d n;
    public d.a.o0.j2.c.q.i o;
    public d.a.o0.j2.c.q.h p;
    public d.a.o0.j2.c.q.a q;
    public d.a.o0.j2.c.q.c r;
    public d.a.o0.j2.c.q.b s;
    public d.a.o0.j2.c.q.e t;
    public d.a.o0.j2.c.q.f u;
    public List<d.a.c.k.e.a> v = new ArrayList();
    public BdTypeRecyclerView w;

    public n(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, BdUniqueId bdUniqueId) {
        a(tbPageContext, bdTypeRecyclerView);
        e(bdUniqueId);
    }

    public final void a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.w = bdTypeRecyclerView;
        this.f60083a = new m(tbPageContext);
        this.f60084b = new b(tbPageContext);
        this.f60085c = new i(tbPageContext);
        this.f60086d = new a(tbPageContext);
        this.f60087e = new c(tbPageContext);
        this.f60088f = new h(tbPageContext, tbPageContext.getUniqueId());
        this.f60089g = new e(tbPageContext, d.a.o0.j2.e.g.l);
        this.f60090h = new k(tbPageContext);
        this.f60091i = new d(tbPageContext);
        this.j = new d.a.o0.g2.h.d(tbPageContext, d.a.o0.g2.h.f.f59006f);
        this.k = new d.a.o0.g2.h.a(tbPageContext.getPageActivity(), d.a.o0.g2.d.f58978h);
        this.l = new p(tbPageContext, PersonPostModel.PostInfoList.POST_INFO);
        this.m = new d.a.o0.j2.c.q.g(tbPageContext, d.a.o0.z.e0.k.r0);
        this.n = new d.a.o0.j2.c.q.d(tbPageContext, d.a.o0.z.e0.k.t0);
        this.o = new d.a.o0.j2.c.q.i(tbPageContext, d.a.o0.z.e0.l.W);
        this.p = new d.a.o0.j2.c.q.h(tbPageContext, d.a.o0.z.e0.k.u0);
        this.s = new d.a.o0.j2.c.q.b(tbPageContext, d.a.o0.z.e0.k.w0);
        this.t = new d.a.o0.j2.c.q.e(tbPageContext, d.a.o0.z.e0.k.v0);
        this.u = new d.a.o0.j2.c.q.f(tbPageContext, d.a.o0.z.e0.k.x0);
        this.q = new d.a.o0.j2.c.q.a(tbPageContext, d.a.o0.z.e0.e.O0);
        this.r = new d.a.o0.j2.c.q.c(tbPageContext, d.a.o0.z.e0.f.O0);
        this.v.add(this.f60083a);
        this.v.add(this.f60084b);
        this.v.add(this.f60085c);
        this.v.add(this.f60086d);
        this.v.add(this.f60087e);
        this.v.add(this.f60088f);
        this.v.add(this.f60089g);
        this.v.add(this.f60090h);
        this.v.add(this.f60091i);
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
        List<d.a.c.k.e.a> list = this.v;
        if (list == null) {
            return;
        }
        for (d.a.c.k.e.a aVar : list) {
            if (aVar instanceof d.a.o0.o.f) {
                ((d.a.o0.o.f) aVar).g(str);
            }
        }
    }

    public void d(boolean z) {
        this.l.h0(z);
        this.f60085c.j0(z);
        this.m.k0(z);
        this.n.i0(z);
        this.o.j0(z);
        this.p.i0(z);
        this.q.l0(z);
        this.r.k0(z);
        this.s.k0(z);
        this.t.k0(z);
        this.u.k0(z);
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
        this.m.l0(i2);
        this.n.j0(i2);
        this.o.k0(i2);
        this.p.j0(i2);
        this.q.m0(i2);
        this.r.l0(i2);
        this.s.l0(i2);
        this.t.l0(i2);
        this.u.l0(i2);
    }

    public void g(int i2) {
        this.m.m0(i2);
        this.n.k0(i2);
        this.o.l0(i2);
        this.p.k0(i2);
        this.q.p0(i2);
        this.r.m0(i2);
        this.s.m0(i2);
        this.t.m0(i2);
        this.u.m0(i2);
    }

    public void h(int i2) {
        this.m.p0(i2);
        this.n.l0(i2);
        this.o.m0(i2);
        this.p.l0(i2);
        this.q.q0(i2);
        this.r.p0(i2);
        this.s.p0(i2);
        this.t.p0(i2);
        this.u.p0(i2);
    }
}
