package d.b.j0.a1.b;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.homepage.concern.adapter.ConcernEmotionTipAdapter;
import com.baidu.tieba.homepage.concern.adapter.ConcernTipAdapter;
import d.b.c.j.e.n;
import d.b.i0.r.q.a2;
import d.b.i0.r.q.s1;
import d.b.j0.a1.b.e.e;
import d.b.j0.a1.b.e.f;
import d.b.j0.a1.b.e.g;
import d.b.j0.a1.b.e.h;
import d.b.j0.a1.b.e.i;
import d.b.j0.a1.b.e.j;
import d.b.j0.a1.b.e.k;
import d.b.j0.a1.b.e.l;
import d.b.j0.a1.b.e.m;
import d.b.j0.a1.b.e.o;
import d.b.j0.a1.b.e.p;
import d.b.j0.a1.b.e.q;
import d.b.j0.a1.b.e.r;
import d.b.j0.a1.b.e.s;
import d.b.j0.a1.b.e.t;
import d.b.j0.a1.b.e.u;
import d.b.j0.a1.b.e.v;
import d.b.j0.a1.b.e.w;
import d.b.j0.a1.b.e.x;
import d.b.j0.a1.b.e.y;
import d.b.j0.a1.b.e.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    public d.b.j0.a1.b.e.d A;
    public p B;
    public e C;
    public q D;
    public ConcernEmotionTipAdapter E;
    public z F;
    public ArrayList<d.b.c.j.e.a> G;
    public List<n> H;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f52713b;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext<?> f52714c;

    /* renamed from: d  reason: collision with root package name */
    public ConcernTipAdapter f52715d;

    /* renamed from: e  reason: collision with root package name */
    public ConcernEmotionTipAdapter f52716e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.j0.a1.b.e.b f52717f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.j0.a1.b.e.a f52718g;

    /* renamed from: h  reason: collision with root package name */
    public v f52719h;
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
    public d.b.j0.a1.b.e.n w;
    public t x;
    public o y;
    public s z;
    public ArrayList<r> i = new ArrayList<>();

    /* renamed from: a  reason: collision with root package name */
    public List<d.b.c.j.e.a> f52712a = new ArrayList();

    public a(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f52713b = bdTypeRecyclerView;
        this.f52714c = (TbPageContext) d.b.c.a.j.a(context);
        b(context);
        i(bdTypeRecyclerView);
        bdTypeRecyclerView.a(this.f52712a);
    }

    public List<n> a() {
        return this.H;
    }

    public final void b(Context context) {
        for (int i = 0; i < d.b.j0.x.e0.b.P.size(); i++) {
            for (int i2 = 0; i2 < d.b.j0.x.e0.b.Q.size(); i2++) {
                this.i.add(new r(this.f52714c, d.b.j0.x.e0.b.R[i][i2], d.b.j0.x.e0.b.P.get(i), d.b.j0.x.e0.b.Q.get(i2)));
            }
        }
        this.j = new x(this.f52714c, a2.e3, d.b.j0.x.e0.b.F);
        this.k = new x(this.f52714c, a2.I2, d.b.j0.x.e0.b.G);
        this.l = new j(this.f52714c, a2.x3, d.b.j0.x.e0.b.F);
        this.m = new w(this.f52714c, d.b.j0.x.e0.k.v0);
        this.n = new l(this.f52714c, d.b.j0.x.e0.k.w0);
        this.u = new k(this.f52714c, d.b.j0.x.e0.k.C0);
        this.v = new m(this.f52714c, d.b.j0.x.e0.k.D0);
        this.o = new u(this.f52714c, d.b.j0.x.e0.k.B0);
        this.p = new i(this.f52714c, d.b.j0.x.e0.k.x0);
        this.q = new h(this.f52714c, d.b.j0.x.e0.k.y0);
        this.r = new g(this.f52714c, d.b.j0.x.e0.k.z0);
        this.t = new y(this.f52714c, d.b.j0.x.e0.l.V);
        this.A = new d.b.j0.a1.b.e.d(this.f52714c, d.b.j0.x.e0.e.M0);
        this.s = new f(this.f52714c, d.b.j0.x.e0.k.A0);
        this.z = new s(this.f52714c, s1.i);
        this.w = new d.b.j0.a1.b.e.n(this.f52714c, d.b.j0.x.e0.k.E0);
        this.x = new t(this.f52714c, d.b.j0.x.e0.k.K0);
        this.y = new o(this.f52714c, d.b.j0.x.e0.k.L0);
        this.f52712a.addAll(this.i);
        this.f52712a.add(this.j);
        this.f52712a.add(this.k);
        this.f52712a.add(this.l);
        this.f52712a.add(this.m);
        this.f52712a.add(this.n);
        this.f52712a.add(this.u);
        this.f52712a.add(this.v);
        this.f52712a.add(this.o);
        this.f52712a.add(this.p);
        this.f52712a.add(this.q);
        this.f52712a.add(this.r);
        this.f52712a.add(this.t);
        this.f52712a.add(this.s);
        this.f52712a.add(this.z);
        this.f52712a.add(this.w);
        this.f52712a.add(this.x);
        this.f52712a.add(this.y);
        this.f52715d = new ConcernTipAdapter(this.f52714c.getContext());
        this.f52716e = new ConcernEmotionTipAdapter(this.f52714c.getContext());
        this.f52717f = new d.b.j0.a1.b.e.b(this.f52714c, d.b.j0.x.e0.j.M0);
        this.f52718g = new d.b.j0.a1.b.e.a(this.f52714c, d.b.j0.x.e0.j.N0);
        this.f52719h = new v(this.f52714c, d.b.j0.x.e0.k.o0);
        this.B = new p(this.f52714c, d.b.j0.x.e0.k.p0);
        this.C = new e(this.f52714c, d.b.j0.x.e0.k.q0);
        this.D = new q(this.f52714c, d.b.j0.x.e0.k.r0);
        this.E = new ConcernEmotionTipAdapter(this.f52714c.getContext(), d.b.j0.a1.b.f.b.j);
        this.F = new z(this.f52714c, d.b.j0.x.e0.k.u0, (byte) 4);
        this.f52712a.add(this.f52715d);
        this.f52712a.add(this.f52716e);
        this.f52712a.add(this.f52717f);
        this.f52712a.add(this.f52718g);
        this.f52712a.add(this.f52719h);
        this.f52712a.add(this.B);
        this.f52712a.add(this.C);
        this.f52712a.add(this.D);
        this.f52712a.add(this.A);
        this.f52712a.add(this.E);
        this.f52712a.add(this.F);
        g("page_concern");
        c();
    }

    public final void c() {
        if (!a2.u3.get()) {
            AdvertAppInfo.t4.set(false);
            return;
        }
        this.G = new ArrayList<>();
        d.b.c.j.e.a<?, ?> f2 = d.b.j0.s2.v.p().f(this.f52714c, AdvertAppInfo.j4, "CONCERN");
        d.b.c.j.e.a<?, ?> f3 = d.b.j0.s2.v.p().f(this.f52714c, AdvertAppInfo.k4, "CONCERN");
        d.b.c.j.e.a<?, ?> f4 = d.b.j0.s2.v.p().f(this.f52714c, AdvertAppInfo.o4, "CONCERN");
        d.b.c.j.e.a<?, ?> f5 = d.b.j0.s2.v.p().f(this.f52714c, AdvertAppInfo.p4, "CONCERN");
        d.b.c.j.e.a<?, ?> f6 = d.b.j0.s2.v.p().f(this.f52714c, AdvertAppInfo.q4, "CONCERN");
        d.b.c.j.e.a<?, ?> f7 = d.b.j0.s2.v.p().f(this.f52714c, AdvertAppInfo.s4, "CONCERN");
        d.b.c.j.e.a<?, ?> f8 = d.b.j0.s2.v.p().f(this.f52714c, AdvertAppInfo.r4, "CONCERN");
        this.G.add(f2);
        this.G.add(f3);
        this.G.add(f4);
        this.G.add(f5);
        this.G.add(f6);
        this.G.add(f7);
        this.G.add(f8);
        this.f52712a.addAll(this.G);
        AdvertAppInfo.t4.set(true);
    }

    public void d() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f52713b;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.getListAdapter().notifyDataSetChanged();
        }
    }

    public void e(int i) {
        d();
    }

    public void f() {
        if (d.b.j0.j1.o.k.a.e(this.H)) {
            return;
        }
        Iterator<d.b.c.j.e.a> it = this.G.iterator();
        while (it.hasNext()) {
            d.b.c.j.e.a next = it.next();
            if (next instanceof d.b.j0.s2.o) {
                ((d.b.j0.s2.o) next).onDestroy();
            }
        }
    }

    public final void g(String str) {
        List<d.b.c.j.e.a> list = this.f52712a;
        if (list == null) {
            return;
        }
        for (d.b.c.j.e.a aVar : list) {
            if (aVar instanceof d.b.j0.m.f) {
                ((d.b.j0.m.f) aVar).o(str);
            }
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        Iterator<r> it = this.i.iterator();
        while (it.hasNext()) {
            it.next().m = bdUniqueId;
        }
        this.f52717f.m = bdUniqueId;
        this.f52718g.m = bdUniqueId;
        this.f52719h.m = bdUniqueId;
        this.D.m = bdUniqueId;
        this.B.m = bdUniqueId;
        this.C.m = bdUniqueId;
        this.A.m = bdUniqueId;
        this.s.m = bdUniqueId;
        this.z.m = bdUniqueId;
        this.F.n = bdUniqueId;
    }

    public final void i(d.b.c.j.e.s sVar) {
        Iterator<r> it = this.i.iterator();
        while (it.hasNext()) {
            it.next().x0(sVar);
        }
        this.j.s0(sVar);
        this.k.s0(sVar);
        this.l.n0(sVar);
        this.m.n0(sVar);
        this.n.o0(sVar);
        this.u.n0(sVar);
        this.v.n0(sVar);
        this.o.n0(sVar);
        this.z.l0(sVar);
        this.w.j0(sVar);
        this.x.l0(sVar);
        this.y.j0(sVar);
        this.p.n0(sVar);
        this.q.n0(sVar);
        this.r.n0(sVar);
        this.t.q0(sVar);
        this.s.o0(sVar);
        this.A.o0(sVar);
        this.C.n0(sVar);
        this.B.o0(sVar);
        this.D.o0(sVar);
        this.F.j0(sVar);
    }

    public void j(List<n> list) {
        this.H = list;
        this.f52713b.setData(list);
    }
}
