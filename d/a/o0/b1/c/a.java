package d.a.o0.b1.c;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.homepage.concern.adapter.ConcernEmotionTipAdapter;
import com.baidu.tieba.homepage.concern.adapter.ConcernTipAdapter;
import d.a.c.k.e.n;
import d.a.n0.r.q.a2;
import d.a.n0.r.q.s1;
import d.a.o0.b1.c.e.e;
import d.a.o0.b1.c.e.f;
import d.a.o0.b1.c.e.g;
import d.a.o0.b1.c.e.h;
import d.a.o0.b1.c.e.i;
import d.a.o0.b1.c.e.j;
import d.a.o0.b1.c.e.k;
import d.a.o0.b1.c.e.l;
import d.a.o0.b1.c.e.m;
import d.a.o0.b1.c.e.o;
import d.a.o0.b1.c.e.p;
import d.a.o0.b1.c.e.q;
import d.a.o0.b1.c.e.r;
import d.a.o0.b1.c.e.s;
import d.a.o0.b1.c.e.t;
import d.a.o0.b1.c.e.u;
import d.a.o0.b1.c.e.v;
import d.a.o0.b1.c.e.w;
import d.a.o0.b1.c.e.x;
import d.a.o0.b1.c.e.y;
import d.a.o0.b1.c.e.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    public d.a.o0.b1.c.e.d A;
    public p B;
    public e C;
    public q D;
    public ConcernEmotionTipAdapter E;
    public z F;
    public ArrayList<d.a.c.k.e.a> G;
    public List<n> H;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f55068b;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext<?> f55069c;

    /* renamed from: d  reason: collision with root package name */
    public ConcernTipAdapter f55070d;

    /* renamed from: e  reason: collision with root package name */
    public ConcernEmotionTipAdapter f55071e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.o0.b1.c.e.b f55072f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.o0.b1.c.e.a f55073g;

    /* renamed from: h  reason: collision with root package name */
    public v f55074h;
    public x j;
    public x k;
    public j l;
    public w m;
    public l n;
    public u o;
    public i p;
    public h q;
    public g r;
    public f s;
    public y t;
    public k u;
    public m v;
    public d.a.o0.b1.c.e.n w;
    public t x;
    public o y;
    public s z;

    /* renamed from: i  reason: collision with root package name */
    public ArrayList<r> f55075i = new ArrayList<>();

    /* renamed from: a  reason: collision with root package name */
    public List<d.a.c.k.e.a> f55067a = new ArrayList();

    public a(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f55068b = bdTypeRecyclerView;
        this.f55069c = (TbPageContext) d.a.c.a.j.a(context);
        b(context);
        i(bdTypeRecyclerView);
        bdTypeRecyclerView.a(this.f55067a);
    }

    public List<n> a() {
        return this.H;
    }

    public final void b(Context context) {
        for (int i2 = 0; i2 < d.a.o0.z.e0.b.Q.size(); i2++) {
            for (int i3 = 0; i3 < d.a.o0.z.e0.b.R.size(); i3++) {
                this.f55075i.add(new r(this.f55069c, d.a.o0.z.e0.b.S[i2][i3], d.a.o0.z.e0.b.Q.get(i2), d.a.o0.z.e0.b.R.get(i3)));
            }
        }
        this.j = new x(this.f55069c, a2.j3, d.a.o0.z.e0.b.G);
        this.k = new x(this.f55069c, a2.N2, d.a.o0.z.e0.b.H);
        this.l = new j(this.f55069c, a2.C3, d.a.o0.z.e0.b.G);
        this.m = new w(this.f55069c, d.a.o0.z.e0.k.B0);
        this.n = new l(this.f55069c, d.a.o0.z.e0.k.C0);
        this.u = new k(this.f55069c, d.a.o0.z.e0.k.I0);
        this.v = new m(this.f55069c, d.a.o0.z.e0.k.J0);
        this.o = new u(this.f55069c, d.a.o0.z.e0.k.H0);
        this.p = new i(this.f55069c, d.a.o0.z.e0.k.D0);
        this.q = new h(this.f55069c, d.a.o0.z.e0.k.E0);
        this.r = new g(this.f55069c, d.a.o0.z.e0.k.F0);
        this.t = new y(this.f55069c, d.a.o0.z.e0.l.W);
        this.A = new d.a.o0.b1.c.e.d(this.f55069c, d.a.o0.z.e0.e.O0);
        this.s = new f(this.f55069c, d.a.o0.z.e0.k.G0);
        this.z = new s(this.f55069c, s1.f53903i);
        this.w = new d.a.o0.b1.c.e.n(this.f55069c, d.a.o0.z.e0.k.K0);
        this.x = new t(this.f55069c, d.a.o0.z.e0.k.L0);
        this.y = new o(this.f55069c, d.a.o0.z.e0.k.M0);
        this.f55067a.addAll(this.f55075i);
        this.f55067a.add(this.j);
        this.f55067a.add(this.k);
        this.f55067a.add(this.l);
        this.f55067a.add(this.m);
        this.f55067a.add(this.n);
        this.f55067a.add(this.u);
        this.f55067a.add(this.v);
        this.f55067a.add(this.o);
        this.f55067a.add(this.p);
        this.f55067a.add(this.q);
        this.f55067a.add(this.r);
        this.f55067a.add(this.t);
        this.f55067a.add(this.s);
        this.f55067a.add(this.z);
        this.f55067a.add(this.w);
        this.f55067a.add(this.x);
        this.f55067a.add(this.y);
        this.f55070d = new ConcernTipAdapter(this.f55069c.getContext());
        this.f55071e = new ConcernEmotionTipAdapter(this.f55069c.getContext());
        this.f55072f = new d.a.o0.b1.c.e.b(this.f55069c, d.a.o0.z.e0.j.O0);
        this.f55073g = new d.a.o0.b1.c.e.a(this.f55069c, d.a.o0.z.e0.j.P0);
        this.f55074h = new v(this.f55069c, d.a.o0.z.e0.k.u0);
        this.B = new p(this.f55069c, d.a.o0.z.e0.k.v0);
        this.C = new e(this.f55069c, d.a.o0.z.e0.k.w0);
        this.D = new q(this.f55069c, d.a.o0.z.e0.k.x0);
        this.E = new ConcernEmotionTipAdapter(this.f55069c.getContext(), d.a.o0.b1.c.f.b.j);
        this.F = new z(this.f55069c, d.a.o0.z.e0.k.A0, (byte) 4);
        this.f55067a.add(this.f55070d);
        this.f55067a.add(this.f55071e);
        this.f55067a.add(this.f55072f);
        this.f55067a.add(this.f55073g);
        this.f55067a.add(this.f55074h);
        this.f55067a.add(this.B);
        this.f55067a.add(this.C);
        this.f55067a.add(this.D);
        this.f55067a.add(this.A);
        this.f55067a.add(this.E);
        this.f55067a.add(this.F);
        g("page_concern");
        c();
    }

    public final void c() {
        if (!a2.z3.get()) {
            AdvertAppInfo.c4.set(false);
            return;
        }
        this.G = new ArrayList<>();
        d.a.c.k.e.a<?, ?> l = d.a.o0.t2.x.p().l(this.f55069c, AdvertAppInfo.f4, "CONCERN");
        d.a.c.k.e.a<?, ?> l2 = d.a.o0.t2.x.p().l(this.f55069c, AdvertAppInfo.g4, "CONCERN");
        d.a.c.k.e.a<?, ?> l3 = d.a.o0.t2.x.p().l(this.f55069c, AdvertAppInfo.h4, "CONCERN");
        d.a.c.k.e.a<?, ?> l4 = d.a.o0.t2.x.p().l(this.f55069c, AdvertAppInfo.i4, "CONCERN");
        d.a.c.k.e.a<?, ?> l5 = d.a.o0.t2.x.p().l(this.f55069c, AdvertAppInfo.j4, "CONCERN");
        d.a.c.k.e.a<?, ?> l6 = d.a.o0.t2.x.p().l(this.f55069c, AdvertAppInfo.l4, "CONCERN");
        d.a.c.k.e.a<?, ?> l7 = d.a.o0.t2.x.p().l(this.f55069c, AdvertAppInfo.k4, "CONCERN");
        this.G.add(l);
        this.G.add(l2);
        this.G.add(l3);
        this.G.add(l4);
        this.G.add(l5);
        this.G.add(l6);
        this.G.add(l7);
        this.f55067a.addAll(this.G);
        AdvertAppInfo.c4.set(true);
    }

    public void d() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f55068b;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.getListAdapter().notifyDataSetChanged();
        }
    }

    public void e(int i2) {
        d();
    }

    public void f() {
        if (d.a.o0.k1.o.k.a.e(this.H)) {
            return;
        }
        Iterator<d.a.c.k.e.a> it = this.G.iterator();
        while (it.hasNext()) {
            d.a.c.k.e.a next = it.next();
            if (next instanceof d.a.o0.t2.p) {
                ((d.a.o0.t2.p) next).onDestroy();
            }
        }
    }

    public final void g(String str) {
        List<d.a.c.k.e.a> list = this.f55067a;
        if (list == null) {
            return;
        }
        for (d.a.c.k.e.a aVar : list) {
            if (aVar instanceof d.a.o0.o.f) {
                ((d.a.o0.o.f) aVar).g(str);
            }
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        Iterator<r> it = this.f55075i.iterator();
        while (it.hasNext()) {
            it.next().m = bdUniqueId;
        }
        this.f55072f.m = bdUniqueId;
        this.f55073g.m = bdUniqueId;
        this.f55074h.m = bdUniqueId;
        this.D.m = bdUniqueId;
        this.B.m = bdUniqueId;
        this.C.m = bdUniqueId;
        this.A.m = bdUniqueId;
        this.s.m = bdUniqueId;
        this.z.m = bdUniqueId;
        this.F.n = bdUniqueId;
    }

    public final void i(d.a.c.k.e.s sVar) {
        Iterator<r> it = this.f55075i.iterator();
        while (it.hasNext()) {
            it.next().y0(sVar);
        }
        this.j.s0(sVar);
        this.k.s0(sVar);
        this.l.k0(sVar);
        this.m.k0(sVar);
        this.n.l0(sVar);
        this.u.k0(sVar);
        this.v.k0(sVar);
        this.o.k0(sVar);
        this.z.i0(sVar);
        this.w.h0(sVar);
        this.x.i0(sVar);
        this.y.h0(sVar);
        this.p.k0(sVar);
        this.q.k0(sVar);
        this.r.k0(sVar);
        this.t.p0(sVar);
        this.s.l0(sVar);
        this.A.l0(sVar);
        this.C.k0(sVar);
        this.B.l0(sVar);
        this.D.l0(sVar);
        this.F.h0(sVar);
    }

    public void j(List<n> list) {
        this.H = list;
        this.f55068b.setData(list);
    }
}
