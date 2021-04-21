package d.b.j0.i2.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    public m f57438a;

    /* renamed from: b  reason: collision with root package name */
    public b f57439b;

    /* renamed from: c  reason: collision with root package name */
    public i f57440c;

    /* renamed from: d  reason: collision with root package name */
    public a f57441d;

    /* renamed from: e  reason: collision with root package name */
    public c f57442e;

    /* renamed from: f  reason: collision with root package name */
    public h f57443f;

    /* renamed from: g  reason: collision with root package name */
    public e f57444g;

    /* renamed from: h  reason: collision with root package name */
    public k f57445h;
    public d i;
    public d.b.j0.f2.h.d j;
    public d.b.j0.f2.h.a k;
    public p l;
    public d.b.j0.i2.c.q.g m;
    public d.b.j0.i2.c.q.d n;
    public d.b.j0.i2.c.q.i o;
    public d.b.j0.i2.c.q.h p;
    public d.b.j0.i2.c.q.a q;
    public d.b.j0.i2.c.q.c r;
    public d.b.j0.i2.c.q.b s;
    public d.b.j0.i2.c.q.e t;
    public d.b.j0.i2.c.q.f u;
    public List<d.b.c.j.e.a> v = new ArrayList();
    public BdTypeRecyclerView w;

    public n(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, BdUniqueId bdUniqueId) {
        a(tbPageContext, bdTypeRecyclerView);
        e(bdUniqueId);
    }

    public final void a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.w = bdTypeRecyclerView;
        this.f57438a = new m(tbPageContext);
        this.f57439b = new b(tbPageContext);
        this.f57440c = new i(tbPageContext);
        this.f57441d = new a(tbPageContext);
        this.f57442e = new c(tbPageContext);
        this.f57443f = new h(tbPageContext, tbPageContext.getUniqueId());
        this.f57444g = new e(tbPageContext, d.b.j0.i2.e.g.l);
        this.f57445h = new k(tbPageContext);
        this.i = new d(tbPageContext);
        this.j = new d.b.j0.f2.h.d(tbPageContext, d.b.j0.f2.h.f.f56409f);
        this.k = new d.b.j0.f2.h.a(tbPageContext.getPageActivity(), d.b.j0.f2.d.f56382h);
        this.l = new p(tbPageContext, PersonPostModel.PostInfoList.POST_INFO);
        this.m = new d.b.j0.i2.c.q.g(tbPageContext, d.b.j0.x.e0.k.l0);
        this.n = new d.b.j0.i2.c.q.d(tbPageContext, d.b.j0.x.e0.k.n0);
        this.o = new d.b.j0.i2.c.q.i(tbPageContext, d.b.j0.x.e0.l.V);
        this.p = new d.b.j0.i2.c.q.h(tbPageContext, d.b.j0.x.e0.k.o0);
        this.s = new d.b.j0.i2.c.q.b(tbPageContext, d.b.j0.x.e0.k.q0);
        this.t = new d.b.j0.i2.c.q.e(tbPageContext, d.b.j0.x.e0.k.p0);
        this.u = new d.b.j0.i2.c.q.f(tbPageContext, d.b.j0.x.e0.k.r0);
        this.q = new d.b.j0.i2.c.q.a(tbPageContext, d.b.j0.x.e0.e.M0);
        this.r = new d.b.j0.i2.c.q.c(tbPageContext, d.b.j0.x.e0.f.M0);
        this.v.add(this.f57438a);
        this.v.add(this.f57439b);
        this.v.add(this.f57440c);
        this.v.add(this.f57441d);
        this.v.add(this.f57442e);
        this.v.add(this.f57443f);
        this.v.add(this.f57444g);
        this.v.add(this.f57445h);
        this.v.add(this.i);
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
        List<d.b.c.j.e.a> list = this.v;
        if (list == null) {
            return;
        }
        for (d.b.c.j.e.a aVar : list) {
            if (aVar instanceof d.b.j0.m.f) {
                ((d.b.j0.m.f) aVar).o(str);
            }
        }
    }

    public void d(boolean z) {
        this.l.j0(z);
        this.f57440c.m0(z);
        this.m.n0(z);
        this.n.l0(z);
        this.o.m0(z);
        this.p.l0(z);
        this.q.o0(z);
        this.r.n0(z);
        this.s.n0(z);
        this.t.n0(z);
        this.u.n0(z);
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

    public void f(int i) {
        this.m.o0(i);
        this.n.m0(i);
        this.o.n0(i);
        this.p.m0(i);
        this.q.p0(i);
        this.r.o0(i);
        this.s.o0(i);
        this.t.o0(i);
        this.u.o0(i);
    }

    public void g(int i) {
        this.m.p0(i);
        this.n.n0(i);
        this.o.o0(i);
        this.p.n0(i);
        this.q.q0(i);
        this.r.p0(i);
        this.s.p0(i);
        this.t.p0(i);
        this.u.p0(i);
    }

    public void h(int i) {
        this.m.q0(i);
        this.n.o0(i);
        this.o.p0(i);
        this.p.o0(i);
        this.q.r0(i);
        this.r.q0(i);
        this.s.q0(i);
        this.t.q0(i);
        this.u.q0(i);
    }
}
