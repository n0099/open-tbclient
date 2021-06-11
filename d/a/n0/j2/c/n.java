package d.a.n0.j2.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    public m f59958a;

    /* renamed from: b  reason: collision with root package name */
    public b f59959b;

    /* renamed from: c  reason: collision with root package name */
    public i f59960c;

    /* renamed from: d  reason: collision with root package name */
    public a f59961d;

    /* renamed from: e  reason: collision with root package name */
    public c f59962e;

    /* renamed from: f  reason: collision with root package name */
    public h f59963f;

    /* renamed from: g  reason: collision with root package name */
    public e f59964g;

    /* renamed from: h  reason: collision with root package name */
    public k f59965h;

    /* renamed from: i  reason: collision with root package name */
    public d f59966i;
    public d.a.n0.g2.h.d j;
    public d.a.n0.g2.h.a k;
    public p l;
    public d.a.n0.j2.c.q.g m;
    public d.a.n0.j2.c.q.d n;
    public d.a.n0.j2.c.q.i o;
    public d.a.n0.j2.c.q.h p;
    public d.a.n0.j2.c.q.a q;
    public d.a.n0.j2.c.q.c r;
    public d.a.n0.j2.c.q.b s;
    public d.a.n0.j2.c.q.e t;
    public d.a.n0.j2.c.q.f u;
    public List<d.a.c.k.e.a> v = new ArrayList();
    public BdTypeRecyclerView w;

    public n(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, BdUniqueId bdUniqueId) {
        a(tbPageContext, bdTypeRecyclerView);
        e(bdUniqueId);
    }

    public final void a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.w = bdTypeRecyclerView;
        this.f59958a = new m(tbPageContext);
        this.f59959b = new b(tbPageContext);
        this.f59960c = new i(tbPageContext);
        this.f59961d = new a(tbPageContext);
        this.f59962e = new c(tbPageContext);
        this.f59963f = new h(tbPageContext, tbPageContext.getUniqueId());
        this.f59964g = new e(tbPageContext, d.a.n0.j2.e.g.l);
        this.f59965h = new k(tbPageContext);
        this.f59966i = new d(tbPageContext);
        this.j = new d.a.n0.g2.h.d(tbPageContext, d.a.n0.g2.h.f.f58881f);
        this.k = new d.a.n0.g2.h.a(tbPageContext.getPageActivity(), d.a.n0.g2.d.f58853h);
        this.l = new p(tbPageContext, PersonPostModel.PostInfoList.POST_INFO);
        this.m = new d.a.n0.j2.c.q.g(tbPageContext, d.a.n0.z.e0.k.m0);
        this.n = new d.a.n0.j2.c.q.d(tbPageContext, d.a.n0.z.e0.k.o0);
        this.o = new d.a.n0.j2.c.q.i(tbPageContext, d.a.n0.z.e0.l.W);
        this.p = new d.a.n0.j2.c.q.h(tbPageContext, d.a.n0.z.e0.k.p0);
        this.s = new d.a.n0.j2.c.q.b(tbPageContext, d.a.n0.z.e0.k.r0);
        this.t = new d.a.n0.j2.c.q.e(tbPageContext, d.a.n0.z.e0.k.q0);
        this.u = new d.a.n0.j2.c.q.f(tbPageContext, d.a.n0.z.e0.k.s0);
        this.q = new d.a.n0.j2.c.q.a(tbPageContext, d.a.n0.z.e0.e.O0);
        this.r = new d.a.n0.j2.c.q.c(tbPageContext, d.a.n0.z.e0.f.O0);
        this.v.add(this.f59958a);
        this.v.add(this.f59959b);
        this.v.add(this.f59960c);
        this.v.add(this.f59961d);
        this.v.add(this.f59962e);
        this.v.add(this.f59963f);
        this.v.add(this.f59964g);
        this.v.add(this.f59965h);
        this.v.add(this.f59966i);
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
            if (aVar instanceof d.a.n0.o.f) {
                ((d.a.n0.o.f) aVar).g(str);
            }
        }
    }

    public void d(boolean z) {
        this.l.h0(z);
        this.f59960c.j0(z);
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
