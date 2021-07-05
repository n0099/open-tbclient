package d.a.s0.e1.c;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.homepage.concern.adapter.ConcernEmotionTipAdapter;
import com.baidu.tieba.homepage.concern.adapter.ConcernTipAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.k.e.n;
import d.a.r0.r.q.b2;
import d.a.r0.r.q.t1;
import d.a.s0.e1.c.e.e;
import d.a.s0.e1.c.e.f;
import d.a.s0.e1.c.e.g;
import d.a.s0.e1.c.e.h;
import d.a.s0.e1.c.e.i;
import d.a.s0.e1.c.e.j;
import d.a.s0.e1.c.e.k;
import d.a.s0.e1.c.e.l;
import d.a.s0.e1.c.e.m;
import d.a.s0.e1.c.e.o;
import d.a.s0.e1.c.e.p;
import d.a.s0.e1.c.e.q;
import d.a.s0.e1.c.e.r;
import d.a.s0.e1.c.e.s;
import d.a.s0.e1.c.e.t;
import d.a.s0.e1.c.e.u;
import d.a.s0.e1.c.e.v;
import d.a.s0.e1.c.e.w;
import d.a.s0.e1.c.e.x;
import d.a.s0.e1.c.e.y;
import d.a.s0.e1.c.e.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d.a.s0.e1.c.e.d A;
    public p B;
    public e C;
    public q D;
    public ConcernEmotionTipAdapter E;
    public z F;
    public ArrayList<d.a.c.k.e.a> G;
    public List<n> H;

    /* renamed from: a  reason: collision with root package name */
    public List<d.a.c.k.e.a> f58331a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f58332b;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext<?> f58333c;

    /* renamed from: d  reason: collision with root package name */
    public ConcernTipAdapter f58334d;

    /* renamed from: e  reason: collision with root package name */
    public ConcernEmotionTipAdapter f58335e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.s0.e1.c.e.b f58336f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.s0.e1.c.e.a f58337g;

    /* renamed from: h  reason: collision with root package name */
    public v f58338h;

    /* renamed from: i  reason: collision with root package name */
    public ArrayList<r> f58339i;
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
    public d.a.s0.e1.c.e.n w;
    public t x;
    public o y;
    public s z;

    public a(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bdTypeRecyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f58339i = new ArrayList<>();
        this.f58331a = new ArrayList();
        this.f58332b = bdTypeRecyclerView;
        this.f58333c = (TbPageContext) d.a.c.a.j.a(context);
        b(context);
        i(bdTypeRecyclerView);
        bdTypeRecyclerView.a(this.f58331a);
    }

    public List<n> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.H : (List) invokeV.objValue;
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            for (int i2 = 0; i2 < d.a.s0.a0.e0.b.R.size(); i2++) {
                for (int i3 = 0; i3 < d.a.s0.a0.e0.b.S.size(); i3++) {
                    this.f58339i.add(new r(this.f58333c, d.a.s0.a0.e0.b.T[i2][i3], d.a.s0.a0.e0.b.R.get(i2), d.a.s0.a0.e0.b.S.get(i3)));
                }
            }
            this.j = new x(this.f58333c, b2.l3, d.a.s0.a0.e0.b.H);
            this.k = new x(this.f58333c, b2.P2, d.a.s0.a0.e0.b.I);
            this.l = new j(this.f58333c, b2.E3, d.a.s0.a0.e0.b.H);
            this.m = new w(this.f58333c, d.a.s0.a0.e0.k.C0);
            this.n = new l(this.f58333c, d.a.s0.a0.e0.k.D0);
            this.u = new k(this.f58333c, d.a.s0.a0.e0.k.J0);
            this.v = new m(this.f58333c, d.a.s0.a0.e0.k.K0);
            this.o = new u(this.f58333c, d.a.s0.a0.e0.k.I0);
            this.p = new i(this.f58333c, d.a.s0.a0.e0.k.E0);
            this.q = new h(this.f58333c, d.a.s0.a0.e0.k.F0);
            this.r = new g(this.f58333c, d.a.s0.a0.e0.k.G0);
            this.t = new y(this.f58333c, d.a.s0.a0.e0.l.X);
            this.A = new d.a.s0.e1.c.e.d(this.f58333c, d.a.s0.a0.e0.e.P0);
            this.s = new f(this.f58333c, d.a.s0.a0.e0.k.H0);
            this.z = new s(this.f58333c, t1.f56058i);
            this.w = new d.a.s0.e1.c.e.n(this.f58333c, d.a.s0.a0.e0.k.L0);
            this.x = new t(this.f58333c, d.a.s0.a0.e0.k.M0);
            this.y = new o(this.f58333c, d.a.s0.a0.e0.k.N0);
            this.f58331a.addAll(this.f58339i);
            this.f58331a.add(this.j);
            this.f58331a.add(this.k);
            this.f58331a.add(this.l);
            this.f58331a.add(this.m);
            this.f58331a.add(this.n);
            this.f58331a.add(this.u);
            this.f58331a.add(this.v);
            this.f58331a.add(this.o);
            this.f58331a.add(this.p);
            this.f58331a.add(this.q);
            this.f58331a.add(this.r);
            this.f58331a.add(this.t);
            this.f58331a.add(this.s);
            this.f58331a.add(this.z);
            this.f58331a.add(this.w);
            this.f58331a.add(this.x);
            this.f58331a.add(this.y);
            this.f58334d = new ConcernTipAdapter(this.f58333c.getContext());
            this.f58335e = new ConcernEmotionTipAdapter(this.f58333c.getContext());
            this.f58336f = new d.a.s0.e1.c.e.b(this.f58333c, d.a.s0.a0.e0.j.P0);
            this.f58337g = new d.a.s0.e1.c.e.a(this.f58333c, d.a.s0.a0.e0.j.Q0);
            this.f58338h = new v(this.f58333c, d.a.s0.a0.e0.k.v0);
            this.B = new p(this.f58333c, d.a.s0.a0.e0.k.w0);
            this.C = new e(this.f58333c, d.a.s0.a0.e0.k.x0);
            this.D = new q(this.f58333c, d.a.s0.a0.e0.k.y0);
            this.E = new ConcernEmotionTipAdapter(this.f58333c.getContext(), d.a.s0.e1.c.f.b.j);
            this.F = new z(this.f58333c, d.a.s0.a0.e0.k.B0, (byte) 4);
            this.f58331a.add(this.f58334d);
            this.f58331a.add(this.f58335e);
            this.f58331a.add(this.f58336f);
            this.f58331a.add(this.f58337g);
            this.f58331a.add(this.f58338h);
            this.f58331a.add(this.B);
            this.f58331a.add(this.C);
            this.f58331a.add(this.D);
            this.f58331a.add(this.A);
            this.f58331a.add(this.E);
            this.f58331a.add(this.F);
            g("page_concern");
            c();
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (!b2.B3.get()) {
                AdvertAppInfo.e4.set(false);
                return;
            }
            this.G = new ArrayList<>();
            d.a.c.k.e.a<?, ?> k = d.a.s0.w2.w.p().k(this.f58333c, AdvertAppInfo.h4, "CONCERN");
            d.a.c.k.e.a<?, ?> k2 = d.a.s0.w2.w.p().k(this.f58333c, AdvertAppInfo.i4, "CONCERN");
            d.a.c.k.e.a<?, ?> k3 = d.a.s0.w2.w.p().k(this.f58333c, AdvertAppInfo.j4, "CONCERN");
            d.a.c.k.e.a<?, ?> k4 = d.a.s0.w2.w.p().k(this.f58333c, AdvertAppInfo.k4, "CONCERN");
            d.a.c.k.e.a<?, ?> k5 = d.a.s0.w2.w.p().k(this.f58333c, AdvertAppInfo.l4, "CONCERN");
            d.a.c.k.e.a<?, ?> k6 = d.a.s0.w2.w.p().k(this.f58333c, AdvertAppInfo.n4, "CONCERN");
            d.a.c.k.e.a<?, ?> k7 = d.a.s0.w2.w.p().k(this.f58333c, AdvertAppInfo.m4, "CONCERN");
            this.G.add(k);
            this.G.add(k2);
            this.G.add(k3);
            this.G.add(k4);
            this.G.add(k5);
            this.G.add(k6);
            this.G.add(k7);
            this.f58331a.addAll(this.G);
            AdvertAppInfo.e4.set(true);
        }
    }

    public void d() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (bdTypeRecyclerView = this.f58332b) == null) {
            return;
        }
        bdTypeRecyclerView.getListAdapter().notifyDataSetChanged();
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            d();
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || d.a.s0.n1.o.k.a.e(this.H)) {
            return;
        }
        Iterator<d.a.c.k.e.a> it = this.G.iterator();
        while (it.hasNext()) {
            d.a.c.k.e.a next = it.next();
            if (next instanceof d.a.s0.w2.o) {
                ((d.a.s0.w2.o) next).onDestroy();
            }
        }
    }

    public final void g(String str) {
        List<d.a.c.k.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || (list = this.f58331a) == null) {
            return;
        }
        for (d.a.c.k.e.a aVar : list) {
            if (aVar instanceof d.a.s0.o.f) {
                ((d.a.s0.o.f) aVar).g(str);
            }
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            Iterator<r> it = this.f58339i.iterator();
            while (it.hasNext()) {
                it.next().m = bdUniqueId;
            }
            this.f58336f.m = bdUniqueId;
            this.f58337g.m = bdUniqueId;
            this.f58338h.m = bdUniqueId;
            this.D.m = bdUniqueId;
            this.B.m = bdUniqueId;
            this.C.m = bdUniqueId;
            this.A.m = bdUniqueId;
            this.s.m = bdUniqueId;
            this.z.m = bdUniqueId;
            this.F.n = bdUniqueId;
        }
    }

    public final void i(d.a.c.k.e.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sVar) == null) {
            Iterator<r> it = this.f58339i.iterator();
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
    }

    public void j(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            this.H = list;
            this.f58332b.setData(list);
        }
    }
}
