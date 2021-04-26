package d.a.j0.a1.b;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.homepage.concern.adapter.ConcernEmotionTipAdapter;
import com.baidu.tieba.homepage.concern.adapter.ConcernTipAdapter;
import d.a.c.j.e.n;
import d.a.i0.r.q.a2;
import d.a.i0.r.q.s1;
import d.a.j0.a1.b.e.e;
import d.a.j0.a1.b.e.f;
import d.a.j0.a1.b.e.g;
import d.a.j0.a1.b.e.h;
import d.a.j0.a1.b.e.i;
import d.a.j0.a1.b.e.j;
import d.a.j0.a1.b.e.k;
import d.a.j0.a1.b.e.l;
import d.a.j0.a1.b.e.m;
import d.a.j0.a1.b.e.o;
import d.a.j0.a1.b.e.p;
import d.a.j0.a1.b.e.q;
import d.a.j0.a1.b.e.r;
import d.a.j0.a1.b.e.s;
import d.a.j0.a1.b.e.t;
import d.a.j0.a1.b.e.u;
import d.a.j0.a1.b.e.v;
import d.a.j0.a1.b.e.w;
import d.a.j0.a1.b.e.x;
import d.a.j0.a1.b.e.y;
import d.a.j0.a1.b.e.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    public d.a.j0.a1.b.e.d A;
    public p B;
    public e C;
    public q D;
    public ConcernEmotionTipAdapter E;
    public z F;
    public ArrayList<d.a.c.j.e.a> G;
    public List<n> H;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f50398b;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext<?> f50399c;

    /* renamed from: d  reason: collision with root package name */
    public ConcernTipAdapter f50400d;

    /* renamed from: e  reason: collision with root package name */
    public ConcernEmotionTipAdapter f50401e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.j0.a1.b.e.b f50402f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.j0.a1.b.e.a f50403g;

    /* renamed from: h  reason: collision with root package name */
    public v f50404h;
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
    public d.a.j0.a1.b.e.n w;
    public t x;
    public o y;
    public s z;

    /* renamed from: i  reason: collision with root package name */
    public ArrayList<r> f50405i = new ArrayList<>();

    /* renamed from: a  reason: collision with root package name */
    public List<d.a.c.j.e.a> f50397a = new ArrayList();

    public a(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f50398b = bdTypeRecyclerView;
        this.f50399c = (TbPageContext) d.a.c.a.j.a(context);
        b(context);
        i(bdTypeRecyclerView);
        bdTypeRecyclerView.a(this.f50397a);
    }

    public List<n> a() {
        return this.H;
    }

    public final void b(Context context) {
        for (int i2 = 0; i2 < d.a.j0.x.e0.b.P.size(); i2++) {
            for (int i3 = 0; i3 < d.a.j0.x.e0.b.Q.size(); i3++) {
                this.f50405i.add(new r(this.f50399c, d.a.j0.x.e0.b.R[i2][i3], d.a.j0.x.e0.b.P.get(i2), d.a.j0.x.e0.b.Q.get(i3)));
            }
        }
        this.j = new x(this.f50399c, a2.e3, d.a.j0.x.e0.b.F);
        this.k = new x(this.f50399c, a2.I2, d.a.j0.x.e0.b.G);
        this.l = new j(this.f50399c, a2.x3, d.a.j0.x.e0.b.F);
        this.m = new w(this.f50399c, d.a.j0.x.e0.k.v0);
        this.n = new l(this.f50399c, d.a.j0.x.e0.k.w0);
        this.u = new k(this.f50399c, d.a.j0.x.e0.k.C0);
        this.v = new m(this.f50399c, d.a.j0.x.e0.k.D0);
        this.o = new u(this.f50399c, d.a.j0.x.e0.k.B0);
        this.p = new i(this.f50399c, d.a.j0.x.e0.k.x0);
        this.q = new h(this.f50399c, d.a.j0.x.e0.k.y0);
        this.r = new g(this.f50399c, d.a.j0.x.e0.k.z0);
        this.t = new y(this.f50399c, d.a.j0.x.e0.l.V);
        this.A = new d.a.j0.a1.b.e.d(this.f50399c, d.a.j0.x.e0.e.M0);
        this.s = new f(this.f50399c, d.a.j0.x.e0.k.A0);
        this.z = new s(this.f50399c, s1.f49257i);
        this.w = new d.a.j0.a1.b.e.n(this.f50399c, d.a.j0.x.e0.k.E0);
        this.x = new t(this.f50399c, d.a.j0.x.e0.k.K0);
        this.y = new o(this.f50399c, d.a.j0.x.e0.k.L0);
        this.f50397a.addAll(this.f50405i);
        this.f50397a.add(this.j);
        this.f50397a.add(this.k);
        this.f50397a.add(this.l);
        this.f50397a.add(this.m);
        this.f50397a.add(this.n);
        this.f50397a.add(this.u);
        this.f50397a.add(this.v);
        this.f50397a.add(this.o);
        this.f50397a.add(this.p);
        this.f50397a.add(this.q);
        this.f50397a.add(this.r);
        this.f50397a.add(this.t);
        this.f50397a.add(this.s);
        this.f50397a.add(this.z);
        this.f50397a.add(this.w);
        this.f50397a.add(this.x);
        this.f50397a.add(this.y);
        this.f50400d = new ConcernTipAdapter(this.f50399c.getContext());
        this.f50401e = new ConcernEmotionTipAdapter(this.f50399c.getContext());
        this.f50402f = new d.a.j0.a1.b.e.b(this.f50399c, d.a.j0.x.e0.j.M0);
        this.f50403g = new d.a.j0.a1.b.e.a(this.f50399c, d.a.j0.x.e0.j.N0);
        this.f50404h = new v(this.f50399c, d.a.j0.x.e0.k.o0);
        this.B = new p(this.f50399c, d.a.j0.x.e0.k.p0);
        this.C = new e(this.f50399c, d.a.j0.x.e0.k.q0);
        this.D = new q(this.f50399c, d.a.j0.x.e0.k.r0);
        this.E = new ConcernEmotionTipAdapter(this.f50399c.getContext(), d.a.j0.a1.b.f.b.j);
        this.F = new z(this.f50399c, d.a.j0.x.e0.k.u0, (byte) 4);
        this.f50397a.add(this.f50400d);
        this.f50397a.add(this.f50401e);
        this.f50397a.add(this.f50402f);
        this.f50397a.add(this.f50403g);
        this.f50397a.add(this.f50404h);
        this.f50397a.add(this.B);
        this.f50397a.add(this.C);
        this.f50397a.add(this.D);
        this.f50397a.add(this.A);
        this.f50397a.add(this.E);
        this.f50397a.add(this.F);
        g("page_concern");
        c();
    }

    public final void c() {
        if (!a2.u3.get()) {
            AdvertAppInfo.t4.set(false);
            return;
        }
        this.G = new ArrayList<>();
        d.a.c.j.e.a<?, ?> l = d.a.j0.s2.w.p().l(this.f50399c, AdvertAppInfo.j4, "CONCERN");
        d.a.c.j.e.a<?, ?> l2 = d.a.j0.s2.w.p().l(this.f50399c, AdvertAppInfo.k4, "CONCERN");
        d.a.c.j.e.a<?, ?> l3 = d.a.j0.s2.w.p().l(this.f50399c, AdvertAppInfo.o4, "CONCERN");
        d.a.c.j.e.a<?, ?> l4 = d.a.j0.s2.w.p().l(this.f50399c, AdvertAppInfo.p4, "CONCERN");
        d.a.c.j.e.a<?, ?> l5 = d.a.j0.s2.w.p().l(this.f50399c, AdvertAppInfo.q4, "CONCERN");
        d.a.c.j.e.a<?, ?> l6 = d.a.j0.s2.w.p().l(this.f50399c, AdvertAppInfo.s4, "CONCERN");
        d.a.c.j.e.a<?, ?> l7 = d.a.j0.s2.w.p().l(this.f50399c, AdvertAppInfo.r4, "CONCERN");
        this.G.add(l);
        this.G.add(l2);
        this.G.add(l3);
        this.G.add(l4);
        this.G.add(l5);
        this.G.add(l6);
        this.G.add(l7);
        this.f50397a.addAll(this.G);
        AdvertAppInfo.t4.set(true);
    }

    public void d() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f50398b;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.getListAdapter().notifyDataSetChanged();
        }
    }

    public void e(int i2) {
        d();
    }

    public void f() {
        if (d.a.j0.j1.o.k.a.e(this.H)) {
            return;
        }
        Iterator<d.a.c.j.e.a> it = this.G.iterator();
        while (it.hasNext()) {
            d.a.c.j.e.a next = it.next();
            if (next instanceof d.a.j0.s2.o) {
                ((d.a.j0.s2.o) next).onDestroy();
            }
        }
    }

    public final void g(String str) {
        List<d.a.c.j.e.a> list = this.f50397a;
        if (list == null) {
            return;
        }
        for (d.a.c.j.e.a aVar : list) {
            if (aVar instanceof d.a.j0.m.f) {
                ((d.a.j0.m.f) aVar).g(str);
            }
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        Iterator<r> it = this.f50405i.iterator();
        while (it.hasNext()) {
            it.next().m = bdUniqueId;
        }
        this.f50402f.m = bdUniqueId;
        this.f50403g.m = bdUniqueId;
        this.f50404h.m = bdUniqueId;
        this.D.m = bdUniqueId;
        this.B.m = bdUniqueId;
        this.C.m = bdUniqueId;
        this.A.m = bdUniqueId;
        this.s.m = bdUniqueId;
        this.z.m = bdUniqueId;
        this.F.n = bdUniqueId;
    }

    public final void i(d.a.c.j.e.s sVar) {
        Iterator<r> it = this.f50405i.iterator();
        while (it.hasNext()) {
            it.next().x0(sVar);
        }
        this.j.r0(sVar);
        this.k.r0(sVar);
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
        this.f50398b.setData(list);
    }
}
