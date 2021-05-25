package d.a.n0.b1.b;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.homepage.concern.adapter.ConcernEmotionTipAdapter;
import com.baidu.tieba.homepage.concern.adapter.ConcernTipAdapter;
import d.a.c.j.e.n;
import d.a.m0.r.q.a2;
import d.a.m0.r.q.s1;
import d.a.n0.b1.b.e.e;
import d.a.n0.b1.b.e.f;
import d.a.n0.b1.b.e.g;
import d.a.n0.b1.b.e.h;
import d.a.n0.b1.b.e.i;
import d.a.n0.b1.b.e.j;
import d.a.n0.b1.b.e.k;
import d.a.n0.b1.b.e.l;
import d.a.n0.b1.b.e.m;
import d.a.n0.b1.b.e.o;
import d.a.n0.b1.b.e.p;
import d.a.n0.b1.b.e.q;
import d.a.n0.b1.b.e.r;
import d.a.n0.b1.b.e.s;
import d.a.n0.b1.b.e.t;
import d.a.n0.b1.b.e.u;
import d.a.n0.b1.b.e.v;
import d.a.n0.b1.b.e.w;
import d.a.n0.b1.b.e.x;
import d.a.n0.b1.b.e.y;
import d.a.n0.b1.b.e.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    public d.a.n0.b1.b.e.d A;
    public p B;
    public e C;
    public q D;
    public ConcernEmotionTipAdapter E;
    public z F;
    public ArrayList<d.a.c.j.e.a> G;
    public List<n> H;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f51260b;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext<?> f51261c;

    /* renamed from: d  reason: collision with root package name */
    public ConcernTipAdapter f51262d;

    /* renamed from: e  reason: collision with root package name */
    public ConcernEmotionTipAdapter f51263e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.n0.b1.b.e.b f51264f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.n0.b1.b.e.a f51265g;

    /* renamed from: h  reason: collision with root package name */
    public v f51266h;
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
    public d.a.n0.b1.b.e.n w;
    public t x;
    public o y;
    public s z;

    /* renamed from: i  reason: collision with root package name */
    public ArrayList<r> f51267i = new ArrayList<>();

    /* renamed from: a  reason: collision with root package name */
    public List<d.a.c.j.e.a> f51259a = new ArrayList();

    public a(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f51260b = bdTypeRecyclerView;
        this.f51261c = (TbPageContext) d.a.c.a.j.a(context);
        b(context);
        i(bdTypeRecyclerView);
        bdTypeRecyclerView.a(this.f51259a);
    }

    public List<n> a() {
        return this.H;
    }

    public final void b(Context context) {
        for (int i2 = 0; i2 < d.a.n0.z.e0.b.Q.size(); i2++) {
            for (int i3 = 0; i3 < d.a.n0.z.e0.b.R.size(); i3++) {
                this.f51267i.add(new r(this.f51261c, d.a.n0.z.e0.b.S[i2][i3], d.a.n0.z.e0.b.Q.get(i2), d.a.n0.z.e0.b.R.get(i3)));
            }
        }
        this.j = new x(this.f51261c, a2.g3, d.a.n0.z.e0.b.G);
        this.k = new x(this.f51261c, a2.K2, d.a.n0.z.e0.b.H);
        this.l = new j(this.f51261c, a2.z3, d.a.n0.z.e0.b.G);
        this.m = new w(this.f51261c, d.a.n0.z.e0.k.w0);
        this.n = new l(this.f51261c, d.a.n0.z.e0.k.x0);
        this.u = new k(this.f51261c, d.a.n0.z.e0.k.D0);
        this.v = new m(this.f51261c, d.a.n0.z.e0.k.E0);
        this.o = new u(this.f51261c, d.a.n0.z.e0.k.C0);
        this.p = new i(this.f51261c, d.a.n0.z.e0.k.y0);
        this.q = new h(this.f51261c, d.a.n0.z.e0.k.z0);
        this.r = new g(this.f51261c, d.a.n0.z.e0.k.A0);
        this.t = new y(this.f51261c, d.a.n0.z.e0.l.W);
        this.A = new d.a.n0.b1.b.e.d(this.f51261c, d.a.n0.z.e0.e.O0);
        this.s = new f(this.f51261c, d.a.n0.z.e0.k.B0);
        this.z = new s(this.f51261c, s1.f50120i);
        this.w = new d.a.n0.b1.b.e.n(this.f51261c, d.a.n0.z.e0.k.K0);
        this.x = new t(this.f51261c, d.a.n0.z.e0.k.L0);
        this.y = new o(this.f51261c, d.a.n0.z.e0.k.M0);
        this.f51259a.addAll(this.f51267i);
        this.f51259a.add(this.j);
        this.f51259a.add(this.k);
        this.f51259a.add(this.l);
        this.f51259a.add(this.m);
        this.f51259a.add(this.n);
        this.f51259a.add(this.u);
        this.f51259a.add(this.v);
        this.f51259a.add(this.o);
        this.f51259a.add(this.p);
        this.f51259a.add(this.q);
        this.f51259a.add(this.r);
        this.f51259a.add(this.t);
        this.f51259a.add(this.s);
        this.f51259a.add(this.z);
        this.f51259a.add(this.w);
        this.f51259a.add(this.x);
        this.f51259a.add(this.y);
        this.f51262d = new ConcernTipAdapter(this.f51261c.getContext());
        this.f51263e = new ConcernEmotionTipAdapter(this.f51261c.getContext());
        this.f51264f = new d.a.n0.b1.b.e.b(this.f51261c, d.a.n0.z.e0.j.O0);
        this.f51265g = new d.a.n0.b1.b.e.a(this.f51261c, d.a.n0.z.e0.j.P0);
        this.f51266h = new v(this.f51261c, d.a.n0.z.e0.k.p0);
        this.B = new p(this.f51261c, d.a.n0.z.e0.k.q0);
        this.C = new e(this.f51261c, d.a.n0.z.e0.k.r0);
        this.D = new q(this.f51261c, d.a.n0.z.e0.k.s0);
        this.E = new ConcernEmotionTipAdapter(this.f51261c.getContext(), d.a.n0.b1.b.f.b.j);
        this.F = new z(this.f51261c, d.a.n0.z.e0.k.v0, (byte) 4);
        this.f51259a.add(this.f51262d);
        this.f51259a.add(this.f51263e);
        this.f51259a.add(this.f51264f);
        this.f51259a.add(this.f51265g);
        this.f51259a.add(this.f51266h);
        this.f51259a.add(this.B);
        this.f51259a.add(this.C);
        this.f51259a.add(this.D);
        this.f51259a.add(this.A);
        this.f51259a.add(this.E);
        this.f51259a.add(this.F);
        g("page_concern");
        c();
    }

    public final void c() {
        if (!a2.w3.get()) {
            AdvertAppInfo.Z3.set(false);
            return;
        }
        this.G = new ArrayList<>();
        d.a.c.j.e.a<?, ?> l = d.a.n0.t2.x.p().l(this.f51261c, AdvertAppInfo.c4, "CONCERN");
        d.a.c.j.e.a<?, ?> l2 = d.a.n0.t2.x.p().l(this.f51261c, AdvertAppInfo.d4, "CONCERN");
        d.a.c.j.e.a<?, ?> l3 = d.a.n0.t2.x.p().l(this.f51261c, AdvertAppInfo.e4, "CONCERN");
        d.a.c.j.e.a<?, ?> l4 = d.a.n0.t2.x.p().l(this.f51261c, AdvertAppInfo.f4, "CONCERN");
        d.a.c.j.e.a<?, ?> l5 = d.a.n0.t2.x.p().l(this.f51261c, AdvertAppInfo.g4, "CONCERN");
        d.a.c.j.e.a<?, ?> l6 = d.a.n0.t2.x.p().l(this.f51261c, AdvertAppInfo.i4, "CONCERN");
        d.a.c.j.e.a<?, ?> l7 = d.a.n0.t2.x.p().l(this.f51261c, AdvertAppInfo.h4, "CONCERN");
        this.G.add(l);
        this.G.add(l2);
        this.G.add(l3);
        this.G.add(l4);
        this.G.add(l5);
        this.G.add(l6);
        this.G.add(l7);
        this.f51259a.addAll(this.G);
        AdvertAppInfo.Z3.set(true);
    }

    public void d() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f51260b;
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
        Iterator<d.a.c.j.e.a> it = this.G.iterator();
        while (it.hasNext()) {
            d.a.c.j.e.a next = it.next();
            if (next instanceof d.a.n0.t2.p) {
                ((d.a.n0.t2.p) next).onDestroy();
            }
        }
    }

    public final void g(String str) {
        List<d.a.c.j.e.a> list = this.f51259a;
        if (list == null) {
            return;
        }
        for (d.a.c.j.e.a aVar : list) {
            if (aVar instanceof d.a.n0.o.f) {
                ((d.a.n0.o.f) aVar).g(str);
            }
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        Iterator<r> it = this.f51267i.iterator();
        while (it.hasNext()) {
            it.next().m = bdUniqueId;
        }
        this.f51264f.m = bdUniqueId;
        this.f51265g.m = bdUniqueId;
        this.f51266h.m = bdUniqueId;
        this.D.m = bdUniqueId;
        this.B.m = bdUniqueId;
        this.C.m = bdUniqueId;
        this.A.m = bdUniqueId;
        this.s.m = bdUniqueId;
        this.z.m = bdUniqueId;
        this.F.n = bdUniqueId;
    }

    public final void i(d.a.c.j.e.s sVar) {
        Iterator<r> it = this.f51267i.iterator();
        while (it.hasNext()) {
            it.next().x0(sVar);
        }
        this.j.s0(sVar);
        this.k.s0(sVar);
        this.l.j0(sVar);
        this.m.j0(sVar);
        this.n.m0(sVar);
        this.u.j0(sVar);
        this.v.j0(sVar);
        this.o.j0(sVar);
        this.z.h0(sVar);
        this.w.g0(sVar);
        this.x.h0(sVar);
        this.y.g0(sVar);
        this.p.j0(sVar);
        this.q.j0(sVar);
        this.r.j0(sVar);
        this.t.p0(sVar);
        this.s.m0(sVar);
        this.A.m0(sVar);
        this.C.j0(sVar);
        this.B.m0(sVar);
        this.D.m0(sVar);
        this.F.g0(sVar);
    }

    public void j(List<n> list) {
        this.H = list;
        this.f51260b.setData(list);
    }
}
