package d.a.n0.b1.c;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.homepage.concern.adapter.ConcernEmotionTipAdapter;
import com.baidu.tieba.homepage.concern.adapter.ConcernTipAdapter;
import d.a.c.k.e.n;
import d.a.m0.r.q.a2;
import d.a.m0.r.q.s1;
import d.a.n0.b1.c.e.e;
import d.a.n0.b1.c.e.f;
import d.a.n0.b1.c.e.g;
import d.a.n0.b1.c.e.h;
import d.a.n0.b1.c.e.i;
import d.a.n0.b1.c.e.j;
import d.a.n0.b1.c.e.k;
import d.a.n0.b1.c.e.l;
import d.a.n0.b1.c.e.m;
import d.a.n0.b1.c.e.o;
import d.a.n0.b1.c.e.p;
import d.a.n0.b1.c.e.q;
import d.a.n0.b1.c.e.r;
import d.a.n0.b1.c.e.s;
import d.a.n0.b1.c.e.t;
import d.a.n0.b1.c.e.u;
import d.a.n0.b1.c.e.v;
import d.a.n0.b1.c.e.w;
import d.a.n0.b1.c.e.x;
import d.a.n0.b1.c.e.y;
import d.a.n0.b1.c.e.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    public d.a.n0.b1.c.e.d A;
    public p B;
    public e C;
    public q D;
    public ConcernEmotionTipAdapter E;
    public z F;
    public ArrayList<d.a.c.k.e.a> G;
    public List<n> H;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f54943b;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext<?> f54944c;

    /* renamed from: d  reason: collision with root package name */
    public ConcernTipAdapter f54945d;

    /* renamed from: e  reason: collision with root package name */
    public ConcernEmotionTipAdapter f54946e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.n0.b1.c.e.b f54947f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.n0.b1.c.e.a f54948g;

    /* renamed from: h  reason: collision with root package name */
    public v f54949h;
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
    public d.a.n0.b1.c.e.n w;
    public t x;
    public o y;
    public s z;

    /* renamed from: i  reason: collision with root package name */
    public ArrayList<r> f54950i = new ArrayList<>();

    /* renamed from: a  reason: collision with root package name */
    public List<d.a.c.k.e.a> f54942a = new ArrayList();

    public a(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f54943b = bdTypeRecyclerView;
        this.f54944c = (TbPageContext) d.a.c.a.j.a(context);
        b(context);
        i(bdTypeRecyclerView);
        bdTypeRecyclerView.a(this.f54942a);
    }

    public List<n> a() {
        return this.H;
    }

    public final void b(Context context) {
        for (int i2 = 0; i2 < d.a.n0.z.e0.b.Q.size(); i2++) {
            for (int i3 = 0; i3 < d.a.n0.z.e0.b.R.size(); i3++) {
                this.f54950i.add(new r(this.f54944c, d.a.n0.z.e0.b.S[i2][i3], d.a.n0.z.e0.b.Q.get(i2), d.a.n0.z.e0.b.R.get(i3)));
            }
        }
        this.j = new x(this.f54944c, a2.j3, d.a.n0.z.e0.b.G);
        this.k = new x(this.f54944c, a2.N2, d.a.n0.z.e0.b.H);
        this.l = new j(this.f54944c, a2.C3, d.a.n0.z.e0.b.G);
        this.m = new w(this.f54944c, d.a.n0.z.e0.k.w0);
        this.n = new l(this.f54944c, d.a.n0.z.e0.k.x0);
        this.u = new k(this.f54944c, d.a.n0.z.e0.k.D0);
        this.v = new m(this.f54944c, d.a.n0.z.e0.k.E0);
        this.o = new u(this.f54944c, d.a.n0.z.e0.k.C0);
        this.p = new i(this.f54944c, d.a.n0.z.e0.k.y0);
        this.q = new h(this.f54944c, d.a.n0.z.e0.k.z0);
        this.r = new g(this.f54944c, d.a.n0.z.e0.k.A0);
        this.t = new y(this.f54944c, d.a.n0.z.e0.l.W);
        this.A = new d.a.n0.b1.c.e.d(this.f54944c, d.a.n0.z.e0.e.O0);
        this.s = new f(this.f54944c, d.a.n0.z.e0.k.B0);
        this.z = new s(this.f54944c, s1.f53796i);
        this.w = new d.a.n0.b1.c.e.n(this.f54944c, d.a.n0.z.e0.k.F0);
        this.x = new t(this.f54944c, d.a.n0.z.e0.k.G0);
        this.y = new o(this.f54944c, d.a.n0.z.e0.k.M0);
        this.f54942a.addAll(this.f54950i);
        this.f54942a.add(this.j);
        this.f54942a.add(this.k);
        this.f54942a.add(this.l);
        this.f54942a.add(this.m);
        this.f54942a.add(this.n);
        this.f54942a.add(this.u);
        this.f54942a.add(this.v);
        this.f54942a.add(this.o);
        this.f54942a.add(this.p);
        this.f54942a.add(this.q);
        this.f54942a.add(this.r);
        this.f54942a.add(this.t);
        this.f54942a.add(this.s);
        this.f54942a.add(this.z);
        this.f54942a.add(this.w);
        this.f54942a.add(this.x);
        this.f54942a.add(this.y);
        this.f54945d = new ConcernTipAdapter(this.f54944c.getContext());
        this.f54946e = new ConcernEmotionTipAdapter(this.f54944c.getContext());
        this.f54947f = new d.a.n0.b1.c.e.b(this.f54944c, d.a.n0.z.e0.j.O0);
        this.f54948g = new d.a.n0.b1.c.e.a(this.f54944c, d.a.n0.z.e0.j.P0);
        this.f54949h = new v(this.f54944c, d.a.n0.z.e0.k.p0);
        this.B = new p(this.f54944c, d.a.n0.z.e0.k.q0);
        this.C = new e(this.f54944c, d.a.n0.z.e0.k.r0);
        this.D = new q(this.f54944c, d.a.n0.z.e0.k.s0);
        this.E = new ConcernEmotionTipAdapter(this.f54944c.getContext(), d.a.n0.b1.c.f.b.j);
        this.F = new z(this.f54944c, d.a.n0.z.e0.k.v0, (byte) 4);
        this.f54942a.add(this.f54945d);
        this.f54942a.add(this.f54946e);
        this.f54942a.add(this.f54947f);
        this.f54942a.add(this.f54948g);
        this.f54942a.add(this.f54949h);
        this.f54942a.add(this.B);
        this.f54942a.add(this.C);
        this.f54942a.add(this.D);
        this.f54942a.add(this.A);
        this.f54942a.add(this.E);
        this.f54942a.add(this.F);
        g("page_concern");
        c();
    }

    public final void c() {
        if (!a2.z3.get()) {
            AdvertAppInfo.c4.set(false);
            return;
        }
        this.G = new ArrayList<>();
        d.a.c.k.e.a<?, ?> l = d.a.n0.t2.x.p().l(this.f54944c, AdvertAppInfo.f4, "CONCERN");
        d.a.c.k.e.a<?, ?> l2 = d.a.n0.t2.x.p().l(this.f54944c, AdvertAppInfo.g4, "CONCERN");
        d.a.c.k.e.a<?, ?> l3 = d.a.n0.t2.x.p().l(this.f54944c, AdvertAppInfo.h4, "CONCERN");
        d.a.c.k.e.a<?, ?> l4 = d.a.n0.t2.x.p().l(this.f54944c, AdvertAppInfo.i4, "CONCERN");
        d.a.c.k.e.a<?, ?> l5 = d.a.n0.t2.x.p().l(this.f54944c, AdvertAppInfo.j4, "CONCERN");
        d.a.c.k.e.a<?, ?> l6 = d.a.n0.t2.x.p().l(this.f54944c, AdvertAppInfo.l4, "CONCERN");
        d.a.c.k.e.a<?, ?> l7 = d.a.n0.t2.x.p().l(this.f54944c, AdvertAppInfo.k4, "CONCERN");
        this.G.add(l);
        this.G.add(l2);
        this.G.add(l3);
        this.G.add(l4);
        this.G.add(l5);
        this.G.add(l6);
        this.G.add(l7);
        this.f54942a.addAll(this.G);
        AdvertAppInfo.c4.set(true);
    }

    public void d() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f54943b;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.getListAdapter().notifyDataSetChanged();
        }
    }

    public void e(int i2) {
        d();
    }

    public void f() {
        if (d.a.n0.k1.o.k.a.e(this.H)) {
            return;
        }
        Iterator<d.a.c.k.e.a> it = this.G.iterator();
        while (it.hasNext()) {
            d.a.c.k.e.a next = it.next();
            if (next instanceof d.a.n0.t2.p) {
                ((d.a.n0.t2.p) next).onDestroy();
            }
        }
    }

    public final void g(String str) {
        List<d.a.c.k.e.a> list = this.f54942a;
        if (list == null) {
            return;
        }
        for (d.a.c.k.e.a aVar : list) {
            if (aVar instanceof d.a.n0.o.f) {
                ((d.a.n0.o.f) aVar).g(str);
            }
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        Iterator<r> it = this.f54950i.iterator();
        while (it.hasNext()) {
            it.next().m = bdUniqueId;
        }
        this.f54947f.m = bdUniqueId;
        this.f54948g.m = bdUniqueId;
        this.f54949h.m = bdUniqueId;
        this.D.m = bdUniqueId;
        this.B.m = bdUniqueId;
        this.C.m = bdUniqueId;
        this.A.m = bdUniqueId;
        this.s.m = bdUniqueId;
        this.z.m = bdUniqueId;
        this.F.n = bdUniqueId;
    }

    public final void i(d.a.c.k.e.s sVar) {
        Iterator<r> it = this.f54950i.iterator();
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
        this.f54943b.setData(list);
    }
}
