package d.a.q0.e1.c;

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
import d.a.d.k.e.n;
import d.a.p0.s.q.b2;
import d.a.p0.s.q.t1;
import d.a.q0.e1.c.e.e;
import d.a.q0.e1.c.e.f;
import d.a.q0.e1.c.e.g;
import d.a.q0.e1.c.e.h;
import d.a.q0.e1.c.e.i;
import d.a.q0.e1.c.e.j;
import d.a.q0.e1.c.e.k;
import d.a.q0.e1.c.e.l;
import d.a.q0.e1.c.e.m;
import d.a.q0.e1.c.e.o;
import d.a.q0.e1.c.e.p;
import d.a.q0.e1.c.e.q;
import d.a.q0.e1.c.e.r;
import d.a.q0.e1.c.e.s;
import d.a.q0.e1.c.e.t;
import d.a.q0.e1.c.e.u;
import d.a.q0.e1.c.e.v;
import d.a.q0.e1.c.e.w;
import d.a.q0.e1.c.e.x;
import d.a.q0.e1.c.e.y;
import d.a.q0.e1.c.e.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d.a.q0.e1.c.e.d A;
    public p B;
    public e C;
    public q D;
    public ConcernEmotionTipAdapter E;
    public z F;
    public ArrayList<d.a.d.k.e.a> G;
    public List<n> H;

    /* renamed from: a  reason: collision with root package name */
    public List<d.a.d.k.e.a> f55620a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f55621b;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext<?> f55622c;

    /* renamed from: d  reason: collision with root package name */
    public ConcernTipAdapter f55623d;

    /* renamed from: e  reason: collision with root package name */
    public ConcernEmotionTipAdapter f55624e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.q0.e1.c.e.b f55625f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.q0.e1.c.e.a f55626g;

    /* renamed from: h  reason: collision with root package name */
    public v f55627h;

    /* renamed from: i  reason: collision with root package name */
    public ArrayList<r> f55628i;
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
    public d.a.q0.e1.c.e.n w;
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
        this.f55628i = new ArrayList<>();
        this.f55620a = new ArrayList();
        this.f55621b = bdTypeRecyclerView;
        this.f55622c = (TbPageContext) d.a.d.a.j.a(context);
        b(context);
        i(bdTypeRecyclerView);
        bdTypeRecyclerView.a(this.f55620a);
    }

    public List<n> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.H : (List) invokeV.objValue;
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            for (int i2 = 0; i2 < d.a.q0.a0.e0.b.R.size(); i2++) {
                for (int i3 = 0; i3 < d.a.q0.a0.e0.b.S.size(); i3++) {
                    this.f55628i.add(new r(this.f55622c, d.a.q0.a0.e0.b.T[i2][i3], d.a.q0.a0.e0.b.R.get(i2), d.a.q0.a0.e0.b.S.get(i3)));
                }
            }
            this.j = new x(this.f55622c, b2.r3, d.a.q0.a0.e0.b.H);
            this.k = new x(this.f55622c, b2.V2, d.a.q0.a0.e0.b.I);
            this.l = new j(this.f55622c, b2.K3, d.a.q0.a0.e0.b.H);
            this.m = new w(this.f55622c, d.a.q0.a0.e0.k.C0);
            this.n = new l(this.f55622c, d.a.q0.a0.e0.k.D0);
            this.u = new k(this.f55622c, d.a.q0.a0.e0.k.J0);
            this.v = new m(this.f55622c, d.a.q0.a0.e0.k.K0);
            this.o = new u(this.f55622c, d.a.q0.a0.e0.k.I0);
            this.p = new i(this.f55622c, d.a.q0.a0.e0.k.E0);
            this.q = new h(this.f55622c, d.a.q0.a0.e0.k.F0);
            this.r = new g(this.f55622c, d.a.q0.a0.e0.k.G0);
            this.t = new y(this.f55622c, d.a.q0.a0.e0.l.X);
            this.A = new d.a.q0.e1.c.e.d(this.f55622c, d.a.q0.a0.e0.e.P0);
            this.s = new f(this.f55622c, d.a.q0.a0.e0.k.H0);
            this.z = new s(this.f55622c, t1.f53441i);
            this.w = new d.a.q0.e1.c.e.n(this.f55622c, d.a.q0.a0.e0.k.L0);
            this.x = new t(this.f55622c, d.a.q0.a0.e0.k.M0);
            this.y = new o(this.f55622c, d.a.q0.a0.e0.k.N0);
            this.f55620a.addAll(this.f55628i);
            this.f55620a.add(this.j);
            this.f55620a.add(this.k);
            this.f55620a.add(this.l);
            this.f55620a.add(this.m);
            this.f55620a.add(this.n);
            this.f55620a.add(this.u);
            this.f55620a.add(this.v);
            this.f55620a.add(this.o);
            this.f55620a.add(this.p);
            this.f55620a.add(this.q);
            this.f55620a.add(this.r);
            this.f55620a.add(this.t);
            this.f55620a.add(this.s);
            this.f55620a.add(this.z);
            this.f55620a.add(this.w);
            this.f55620a.add(this.x);
            this.f55620a.add(this.y);
            this.f55623d = new ConcernTipAdapter(this.f55622c.getContext());
            this.f55624e = new ConcernEmotionTipAdapter(this.f55622c.getContext());
            this.f55625f = new d.a.q0.e1.c.e.b(this.f55622c, d.a.q0.a0.e0.j.P0);
            this.f55626g = new d.a.q0.e1.c.e.a(this.f55622c, d.a.q0.a0.e0.j.Q0);
            this.f55627h = new v(this.f55622c, d.a.q0.a0.e0.k.v0);
            this.B = new p(this.f55622c, d.a.q0.a0.e0.k.w0);
            this.C = new e(this.f55622c, d.a.q0.a0.e0.k.x0);
            this.D = new q(this.f55622c, d.a.q0.a0.e0.k.y0);
            this.E = new ConcernEmotionTipAdapter(this.f55622c.getContext(), d.a.q0.e1.c.f.b.j);
            this.F = new z(this.f55622c, d.a.q0.a0.e0.k.B0, (byte) 4);
            this.f55620a.add(this.f55623d);
            this.f55620a.add(this.f55624e);
            this.f55620a.add(this.f55625f);
            this.f55620a.add(this.f55626g);
            this.f55620a.add(this.f55627h);
            this.f55620a.add(this.B);
            this.f55620a.add(this.C);
            this.f55620a.add(this.D);
            this.f55620a.add(this.A);
            this.f55620a.add(this.E);
            this.f55620a.add(this.F);
            g("page_concern");
            c();
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (!b2.H3.get()) {
                AdvertAppInfo.k4.set(false);
                return;
            }
            this.G = new ArrayList<>();
            d.a.d.k.e.a<?, ?> j = d.a.q0.w2.w.o().j(this.f55622c, AdvertAppInfo.n4, "CONCERN");
            d.a.d.k.e.a<?, ?> j2 = d.a.q0.w2.w.o().j(this.f55622c, AdvertAppInfo.o4, "CONCERN");
            d.a.d.k.e.a<?, ?> j3 = d.a.q0.w2.w.o().j(this.f55622c, AdvertAppInfo.p4, "CONCERN");
            d.a.d.k.e.a<?, ?> j4 = d.a.q0.w2.w.o().j(this.f55622c, AdvertAppInfo.q4, "CONCERN");
            d.a.d.k.e.a<?, ?> j5 = d.a.q0.w2.w.o().j(this.f55622c, AdvertAppInfo.r4, "CONCERN");
            d.a.d.k.e.a<?, ?> j6 = d.a.q0.w2.w.o().j(this.f55622c, AdvertAppInfo.t4, "CONCERN");
            d.a.d.k.e.a<?, ?> j7 = d.a.q0.w2.w.o().j(this.f55622c, AdvertAppInfo.s4, "CONCERN");
            this.G.add(j);
            this.G.add(j2);
            this.G.add(j3);
            this.G.add(j4);
            this.G.add(j5);
            this.G.add(j6);
            this.G.add(j7);
            this.f55620a.addAll(this.G);
            AdvertAppInfo.k4.set(true);
        }
    }

    public void d() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (bdTypeRecyclerView = this.f55621b) == null) {
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
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || d.a.q0.n1.o.k.a.e(this.H)) {
            return;
        }
        Iterator<d.a.d.k.e.a> it = this.G.iterator();
        while (it.hasNext()) {
            d.a.d.k.e.a next = it.next();
            if (next instanceof d.a.q0.w2.o) {
                ((d.a.q0.w2.o) next).onDestroy();
            }
        }
    }

    public final void g(String str) {
        List<d.a.d.k.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || (list = this.f55620a) == null) {
            return;
        }
        for (d.a.d.k.e.a aVar : list) {
            if (aVar instanceof d.a.q0.o.f) {
                ((d.a.q0.o.f) aVar).g(str);
            }
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            Iterator<r> it = this.f55628i.iterator();
            while (it.hasNext()) {
                it.next().m = bdUniqueId;
            }
            this.f55625f.m = bdUniqueId;
            this.f55626g.m = bdUniqueId;
            this.f55627h.m = bdUniqueId;
            this.D.m = bdUniqueId;
            this.B.m = bdUniqueId;
            this.C.m = bdUniqueId;
            this.A.m = bdUniqueId;
            this.s.m = bdUniqueId;
            this.z.m = bdUniqueId;
            this.F.n = bdUniqueId;
        }
    }

    public final void i(d.a.d.k.e.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sVar) == null) {
            Iterator<r> it = this.f55628i.iterator();
            while (it.hasNext()) {
                it.next().x0(sVar);
            }
            this.j.p0(sVar);
            this.k.p0(sVar);
            this.l.k0(sVar);
            this.m.k0(sVar);
            this.n.l0(sVar);
            this.u.k0(sVar);
            this.v.k0(sVar);
            this.o.k0(sVar);
            this.z.i0(sVar);
            this.w.g0(sVar);
            this.x.i0(sVar);
            this.y.g0(sVar);
            this.p.k0(sVar);
            this.q.k0(sVar);
            this.r.k0(sVar);
            this.t.n0(sVar);
            this.s.l0(sVar);
            this.A.l0(sVar);
            this.C.k0(sVar);
            this.B.l0(sVar);
            this.D.l0(sVar);
            this.F.g0(sVar);
        }
    }

    public void j(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            this.H = list;
            this.f55621b.setData(list);
        }
    }
}
