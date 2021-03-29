package d.b.i0.z0.b;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.homepage.concern.adapter.ConcernEmotionTipAdapter;
import com.baidu.tieba.homepage.concern.adapter.ConcernTipAdapter;
import d.b.b.j.e.n;
import d.b.h0.r.q.a2;
import d.b.h0.r.q.s1;
import d.b.i0.z0.b.e.e;
import d.b.i0.z0.b.e.f;
import d.b.i0.z0.b.e.g;
import d.b.i0.z0.b.e.h;
import d.b.i0.z0.b.e.i;
import d.b.i0.z0.b.e.j;
import d.b.i0.z0.b.e.k;
import d.b.i0.z0.b.e.l;
import d.b.i0.z0.b.e.m;
import d.b.i0.z0.b.e.o;
import d.b.i0.z0.b.e.p;
import d.b.i0.z0.b.e.q;
import d.b.i0.z0.b.e.r;
import d.b.i0.z0.b.e.s;
import d.b.i0.z0.b.e.t;
import d.b.i0.z0.b.e.u;
import d.b.i0.z0.b.e.v;
import d.b.i0.z0.b.e.w;
import d.b.i0.z0.b.e.x;
import d.b.i0.z0.b.e.y;
import d.b.i0.z0.b.e.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    public d.b.i0.z0.b.e.d A;
    public p B;
    public e C;
    public q D;
    public ConcernEmotionTipAdapter E;
    public z F;
    public ArrayList<d.b.b.j.e.a> G;
    public List<n> H;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f62673b;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext<?> f62674c;

    /* renamed from: d  reason: collision with root package name */
    public ConcernTipAdapter f62675d;

    /* renamed from: e  reason: collision with root package name */
    public ConcernEmotionTipAdapter f62676e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.i0.z0.b.e.b f62677f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.i0.z0.b.e.a f62678g;

    /* renamed from: h  reason: collision with root package name */
    public v f62679h;
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
    public d.b.i0.z0.b.e.n w;
    public t x;
    public o y;
    public s z;
    public ArrayList<r> i = new ArrayList<>();

    /* renamed from: a  reason: collision with root package name */
    public List<d.b.b.j.e.a> f62672a = new ArrayList();

    public a(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f62673b = bdTypeRecyclerView;
        this.f62674c = (TbPageContext) d.b.b.a.j.a(context);
        b(context);
        i(bdTypeRecyclerView);
        bdTypeRecyclerView.a(this.f62672a);
    }

    public List<n> a() {
        return this.H;
    }

    public final void b(Context context) {
        for (int i = 0; i < d.b.i0.x.e0.b.P.size(); i++) {
            for (int i2 = 0; i2 < d.b.i0.x.e0.b.Q.size(); i2++) {
                this.i.add(new r(this.f62674c, d.b.i0.x.e0.b.R[i][i2], d.b.i0.x.e0.b.P.get(i), d.b.i0.x.e0.b.Q.get(i2)));
            }
        }
        this.j = new x(this.f62674c, a2.e3, d.b.i0.x.e0.b.F);
        this.k = new x(this.f62674c, a2.I2, d.b.i0.x.e0.b.G);
        this.l = new j(this.f62674c, a2.x3, d.b.i0.x.e0.b.F);
        this.m = new w(this.f62674c, d.b.i0.x.e0.k.v0);
        this.n = new l(this.f62674c, d.b.i0.x.e0.k.w0);
        this.u = new k(this.f62674c, d.b.i0.x.e0.k.C0);
        this.v = new m(this.f62674c, d.b.i0.x.e0.k.D0);
        this.o = new u(this.f62674c, d.b.i0.x.e0.k.B0);
        this.p = new i(this.f62674c, d.b.i0.x.e0.k.x0);
        this.q = new h(this.f62674c, d.b.i0.x.e0.k.y0);
        this.r = new g(this.f62674c, d.b.i0.x.e0.k.z0);
        this.t = new y(this.f62674c, d.b.i0.x.e0.l.V);
        this.A = new d.b.i0.z0.b.e.d(this.f62674c, d.b.i0.x.e0.e.M0);
        this.s = new f(this.f62674c, d.b.i0.x.e0.k.A0);
        this.z = new s(this.f62674c, s1.i);
        this.w = new d.b.i0.z0.b.e.n(this.f62674c, d.b.i0.x.e0.k.E0);
        this.x = new t(this.f62674c, d.b.i0.x.e0.k.K0);
        this.y = new o(this.f62674c, d.b.i0.x.e0.k.L0);
        this.f62672a.addAll(this.i);
        this.f62672a.add(this.j);
        this.f62672a.add(this.k);
        this.f62672a.add(this.l);
        this.f62672a.add(this.m);
        this.f62672a.add(this.n);
        this.f62672a.add(this.u);
        this.f62672a.add(this.v);
        this.f62672a.add(this.o);
        this.f62672a.add(this.p);
        this.f62672a.add(this.q);
        this.f62672a.add(this.r);
        this.f62672a.add(this.t);
        this.f62672a.add(this.s);
        this.f62672a.add(this.z);
        this.f62672a.add(this.w);
        this.f62672a.add(this.x);
        this.f62672a.add(this.y);
        this.f62675d = new ConcernTipAdapter(this.f62674c.getContext());
        this.f62676e = new ConcernEmotionTipAdapter(this.f62674c.getContext());
        this.f62677f = new d.b.i0.z0.b.e.b(this.f62674c, d.b.i0.x.e0.j.M0);
        this.f62678g = new d.b.i0.z0.b.e.a(this.f62674c, d.b.i0.x.e0.j.N0);
        this.f62679h = new v(this.f62674c, d.b.i0.x.e0.k.o0);
        this.B = new p(this.f62674c, d.b.i0.x.e0.k.p0);
        this.C = new e(this.f62674c, d.b.i0.x.e0.k.q0);
        this.D = new q(this.f62674c, d.b.i0.x.e0.k.r0);
        this.E = new ConcernEmotionTipAdapter(this.f62674c.getContext(), d.b.i0.z0.b.f.b.j);
        this.F = new z(this.f62674c, d.b.i0.x.e0.k.u0, (byte) 4);
        this.f62672a.add(this.f62675d);
        this.f62672a.add(this.f62676e);
        this.f62672a.add(this.f62677f);
        this.f62672a.add(this.f62678g);
        this.f62672a.add(this.f62679h);
        this.f62672a.add(this.B);
        this.f62672a.add(this.C);
        this.f62672a.add(this.D);
        this.f62672a.add(this.A);
        this.f62672a.add(this.E);
        this.f62672a.add(this.F);
        g("page_concern");
        c();
    }

    public final void c() {
        if (!a2.u3.get()) {
            AdvertAppInfo.t4.set(false);
            return;
        }
        this.G = new ArrayList<>();
        d.b.b.j.e.a<?, ?> f2 = d.b.i0.r2.s.o().f(this.f62674c, AdvertAppInfo.j4, "CONCERN");
        d.b.b.j.e.a<?, ?> f3 = d.b.i0.r2.s.o().f(this.f62674c, AdvertAppInfo.k4, "CONCERN");
        d.b.b.j.e.a<?, ?> f4 = d.b.i0.r2.s.o().f(this.f62674c, AdvertAppInfo.o4, "CONCERN");
        d.b.b.j.e.a<?, ?> f5 = d.b.i0.r2.s.o().f(this.f62674c, AdvertAppInfo.p4, "CONCERN");
        d.b.b.j.e.a<?, ?> f6 = d.b.i0.r2.s.o().f(this.f62674c, AdvertAppInfo.q4, "CONCERN");
        d.b.b.j.e.a<?, ?> f7 = d.b.i0.r2.s.o().f(this.f62674c, AdvertAppInfo.s4, "CONCERN");
        d.b.b.j.e.a<?, ?> f8 = d.b.i0.r2.s.o().f(this.f62674c, AdvertAppInfo.r4, "CONCERN");
        this.G.add(f2);
        this.G.add(f3);
        this.G.add(f4);
        this.G.add(f5);
        this.G.add(f6);
        this.G.add(f7);
        this.G.add(f8);
        this.f62672a.addAll(this.G);
        AdvertAppInfo.t4.set(true);
    }

    public void d() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f62673b;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.getListAdapter().notifyDataSetChanged();
        }
    }

    public void e(int i) {
        d();
    }

    public void f() {
        if (d.b.i0.i1.o.k.a.e(this.H)) {
            return;
        }
        Iterator<d.b.b.j.e.a> it = this.G.iterator();
        while (it.hasNext()) {
            d.b.b.j.e.a next = it.next();
            if (next instanceof d.b.i0.r2.l) {
                ((d.b.i0.r2.l) next).onDestroy();
            }
        }
    }

    public final void g(String str) {
        List<d.b.b.j.e.a> list = this.f62672a;
        if (list == null) {
            return;
        }
        for (d.b.b.j.e.a aVar : list) {
            if (aVar instanceof d.b.i0.m.f) {
                ((d.b.i0.m.f) aVar).o(str);
            }
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        Iterator<r> it = this.i.iterator();
        while (it.hasNext()) {
            it.next().m = bdUniqueId;
        }
        this.f62677f.m = bdUniqueId;
        this.f62678g.m = bdUniqueId;
        this.f62679h.m = bdUniqueId;
        this.D.m = bdUniqueId;
        this.B.m = bdUniqueId;
        this.C.m = bdUniqueId;
        this.A.m = bdUniqueId;
        this.s.m = bdUniqueId;
        this.z.m = bdUniqueId;
        this.F.n = bdUniqueId;
    }

    public final void i(d.b.b.j.e.s sVar) {
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
        this.f62673b.setData(list);
    }
}
