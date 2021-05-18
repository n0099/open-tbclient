package d.a.k0.a1.b;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.homepage.concern.adapter.ConcernEmotionTipAdapter;
import com.baidu.tieba.homepage.concern.adapter.ConcernTipAdapter;
import d.a.c.j.e.n;
import d.a.j0.r.q.a2;
import d.a.j0.r.q.s1;
import d.a.k0.a1.b.e.e;
import d.a.k0.a1.b.e.f;
import d.a.k0.a1.b.e.g;
import d.a.k0.a1.b.e.h;
import d.a.k0.a1.b.e.i;
import d.a.k0.a1.b.e.j;
import d.a.k0.a1.b.e.k;
import d.a.k0.a1.b.e.l;
import d.a.k0.a1.b.e.m;
import d.a.k0.a1.b.e.o;
import d.a.k0.a1.b.e.p;
import d.a.k0.a1.b.e.q;
import d.a.k0.a1.b.e.r;
import d.a.k0.a1.b.e.s;
import d.a.k0.a1.b.e.t;
import d.a.k0.a1.b.e.u;
import d.a.k0.a1.b.e.v;
import d.a.k0.a1.b.e.w;
import d.a.k0.a1.b.e.x;
import d.a.k0.a1.b.e.y;
import d.a.k0.a1.b.e.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    public d.a.k0.a1.b.e.d A;
    public p B;
    public e C;
    public q D;
    public ConcernEmotionTipAdapter E;
    public z F;
    public ArrayList<d.a.c.j.e.a> G;
    public List<n> H;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f51095b;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext<?> f51096c;

    /* renamed from: d  reason: collision with root package name */
    public ConcernTipAdapter f51097d;

    /* renamed from: e  reason: collision with root package name */
    public ConcernEmotionTipAdapter f51098e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.k0.a1.b.e.b f51099f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.k0.a1.b.e.a f51100g;

    /* renamed from: h  reason: collision with root package name */
    public v f51101h;
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
    public d.a.k0.a1.b.e.n w;
    public t x;
    public o y;
    public s z;

    /* renamed from: i  reason: collision with root package name */
    public ArrayList<r> f51102i = new ArrayList<>();

    /* renamed from: a  reason: collision with root package name */
    public List<d.a.c.j.e.a> f51094a = new ArrayList();

    public a(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f51095b = bdTypeRecyclerView;
        this.f51096c = (TbPageContext) d.a.c.a.j.a(context);
        b(context);
        i(bdTypeRecyclerView);
        bdTypeRecyclerView.a(this.f51094a);
    }

    public List<n> a() {
        return this.H;
    }

    public final void b(Context context) {
        for (int i2 = 0; i2 < d.a.k0.x.e0.b.Q.size(); i2++) {
            for (int i3 = 0; i3 < d.a.k0.x.e0.b.R.size(); i3++) {
                this.f51102i.add(new r(this.f51096c, d.a.k0.x.e0.b.S[i2][i3], d.a.k0.x.e0.b.Q.get(i2), d.a.k0.x.e0.b.R.get(i3)));
            }
        }
        this.j = new x(this.f51096c, a2.f3, d.a.k0.x.e0.b.G);
        this.k = new x(this.f51096c, a2.J2, d.a.k0.x.e0.b.H);
        this.l = new j(this.f51096c, a2.y3, d.a.k0.x.e0.b.G);
        this.m = new w(this.f51096c, d.a.k0.x.e0.k.w0);
        this.n = new l(this.f51096c, d.a.k0.x.e0.k.x0);
        this.u = new k(this.f51096c, d.a.k0.x.e0.k.D0);
        this.v = new m(this.f51096c, d.a.k0.x.e0.k.E0);
        this.o = new u(this.f51096c, d.a.k0.x.e0.k.C0);
        this.p = new i(this.f51096c, d.a.k0.x.e0.k.y0);
        this.q = new h(this.f51096c, d.a.k0.x.e0.k.z0);
        this.r = new g(this.f51096c, d.a.k0.x.e0.k.A0);
        this.t = new y(this.f51096c, d.a.k0.x.e0.l.W);
        this.A = new d.a.k0.a1.b.e.d(this.f51096c, d.a.k0.x.e0.e.O0);
        this.s = new f(this.f51096c, d.a.k0.x.e0.k.B0);
        this.z = new s(this.f51096c, s1.f50076i);
        this.w = new d.a.k0.a1.b.e.n(this.f51096c, d.a.k0.x.e0.k.K0);
        this.x = new t(this.f51096c, d.a.k0.x.e0.k.L0);
        this.y = new o(this.f51096c, d.a.k0.x.e0.k.M0);
        this.f51094a.addAll(this.f51102i);
        this.f51094a.add(this.j);
        this.f51094a.add(this.k);
        this.f51094a.add(this.l);
        this.f51094a.add(this.m);
        this.f51094a.add(this.n);
        this.f51094a.add(this.u);
        this.f51094a.add(this.v);
        this.f51094a.add(this.o);
        this.f51094a.add(this.p);
        this.f51094a.add(this.q);
        this.f51094a.add(this.r);
        this.f51094a.add(this.t);
        this.f51094a.add(this.s);
        this.f51094a.add(this.z);
        this.f51094a.add(this.w);
        this.f51094a.add(this.x);
        this.f51094a.add(this.y);
        this.f51097d = new ConcernTipAdapter(this.f51096c.getContext());
        this.f51098e = new ConcernEmotionTipAdapter(this.f51096c.getContext());
        this.f51099f = new d.a.k0.a1.b.e.b(this.f51096c, d.a.k0.x.e0.j.O0);
        this.f51100g = new d.a.k0.a1.b.e.a(this.f51096c, d.a.k0.x.e0.j.P0);
        this.f51101h = new v(this.f51096c, d.a.k0.x.e0.k.p0);
        this.B = new p(this.f51096c, d.a.k0.x.e0.k.q0);
        this.C = new e(this.f51096c, d.a.k0.x.e0.k.r0);
        this.D = new q(this.f51096c, d.a.k0.x.e0.k.s0);
        this.E = new ConcernEmotionTipAdapter(this.f51096c.getContext(), d.a.k0.a1.b.f.b.j);
        this.F = new z(this.f51096c, d.a.k0.x.e0.k.v0, (byte) 4);
        this.f51094a.add(this.f51097d);
        this.f51094a.add(this.f51098e);
        this.f51094a.add(this.f51099f);
        this.f51094a.add(this.f51100g);
        this.f51094a.add(this.f51101h);
        this.f51094a.add(this.B);
        this.f51094a.add(this.C);
        this.f51094a.add(this.D);
        this.f51094a.add(this.A);
        this.f51094a.add(this.E);
        this.f51094a.add(this.F);
        g("page_concern");
        c();
    }

    public final void c() {
        if (!a2.v3.get()) {
            AdvertAppInfo.Y3.set(false);
            return;
        }
        this.G = new ArrayList<>();
        d.a.c.j.e.a<?, ?> l = d.a.k0.s2.x.p().l(this.f51096c, AdvertAppInfo.b4, "CONCERN");
        d.a.c.j.e.a<?, ?> l2 = d.a.k0.s2.x.p().l(this.f51096c, AdvertAppInfo.c4, "CONCERN");
        d.a.c.j.e.a<?, ?> l3 = d.a.k0.s2.x.p().l(this.f51096c, AdvertAppInfo.d4, "CONCERN");
        d.a.c.j.e.a<?, ?> l4 = d.a.k0.s2.x.p().l(this.f51096c, AdvertAppInfo.e4, "CONCERN");
        d.a.c.j.e.a<?, ?> l5 = d.a.k0.s2.x.p().l(this.f51096c, AdvertAppInfo.f4, "CONCERN");
        d.a.c.j.e.a<?, ?> l6 = d.a.k0.s2.x.p().l(this.f51096c, AdvertAppInfo.h4, "CONCERN");
        d.a.c.j.e.a<?, ?> l7 = d.a.k0.s2.x.p().l(this.f51096c, AdvertAppInfo.g4, "CONCERN");
        this.G.add(l);
        this.G.add(l2);
        this.G.add(l3);
        this.G.add(l4);
        this.G.add(l5);
        this.G.add(l6);
        this.G.add(l7);
        this.f51094a.addAll(this.G);
        AdvertAppInfo.Y3.set(true);
    }

    public void d() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f51095b;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.getListAdapter().notifyDataSetChanged();
        }
    }

    public void e(int i2) {
        d();
    }

    public void f() {
        if (d.a.k0.j1.o.k.a.e(this.H)) {
            return;
        }
        Iterator<d.a.c.j.e.a> it = this.G.iterator();
        while (it.hasNext()) {
            d.a.c.j.e.a next = it.next();
            if (next instanceof d.a.k0.s2.p) {
                ((d.a.k0.s2.p) next).onDestroy();
            }
        }
    }

    public final void g(String str) {
        List<d.a.c.j.e.a> list = this.f51094a;
        if (list == null) {
            return;
        }
        for (d.a.c.j.e.a aVar : list) {
            if (aVar instanceof d.a.k0.m.f) {
                ((d.a.k0.m.f) aVar).g(str);
            }
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        Iterator<r> it = this.f51102i.iterator();
        while (it.hasNext()) {
            it.next().m = bdUniqueId;
        }
        this.f51099f.m = bdUniqueId;
        this.f51100g.m = bdUniqueId;
        this.f51101h.m = bdUniqueId;
        this.D.m = bdUniqueId;
        this.B.m = bdUniqueId;
        this.C.m = bdUniqueId;
        this.A.m = bdUniqueId;
        this.s.m = bdUniqueId;
        this.z.m = bdUniqueId;
        this.F.n = bdUniqueId;
    }

    public final void i(d.a.c.j.e.s sVar) {
        Iterator<r> it = this.f51102i.iterator();
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
        this.f51095b.setData(list);
    }
}
