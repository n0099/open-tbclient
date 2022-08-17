package com.repackage;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tieba.homepage.concern.adapter.ConcernEmotionTipAdapter;
import com.baidu.tieba.homepage.concern.adapter.ConcernTipAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class lu6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public qu6 A;
    public iv6 B;
    public tu6 C;
    public fv6 D;
    public uu6 E;
    public gv6 F;
    public ConcernEmotionTipAdapter G;
    public qv6 H;
    public ArrayList<bn> I;
    public List<on> J;
    public List<bn> a;
    public BdTypeRecyclerView b;
    public TbPageContext<?> c;
    public ConcernTipAdapter d;
    public ConcernEmotionTipAdapter e;
    public ru6 f;
    public pu6 g;
    public lv6 h;
    public ArrayList<hv6> i;
    public nv6 j;
    public nv6 k;
    public zu6 l;
    public mv6 m;
    public bv6 n;
    public kv6 o;
    public yu6 p;
    public xu6 q;
    public wu6 r;
    public vu6 s;
    public ov6 t;
    public av6 u;
    public cv6 v;
    public dv6 w;
    public jv6 x;
    public ev6 y;
    public pv6 z;

    public lu6(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bdTypeRecyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = new ArrayList<>();
        this.a = new ArrayList();
        this.b = bdTypeRecyclerView;
        this.c = (TbPageContext) h9.a(context);
        b(context);
        i(bdTypeRecyclerView);
        bdTypeRecyclerView.a(this.a);
    }

    public List<on> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.J : (List) invokeV.objValue;
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            for (int i = 0; i < f06.O.size(); i++) {
                for (int i2 = 0; i2 < f06.P.size(); i2++) {
                    this.i.add(new hv6(this.c, f06.Q[i][i2], f06.O.get(i), f06.P.get(i2)));
                }
            }
            this.j = new nv6(this.c, ThreadData.TYPE_VIDEO, f06.D);
            this.k = new nv6(this.c, ThreadData.TYPE_VIDEO_WITH_FORUM_HEADER, f06.E);
            this.l = new zu6(this.c, ThreadData.TYPE_FAKE_VIDEO, f06.D);
            this.m = new mv6(this.c, n06.z0);
            this.n = new bv6(this.c, n06.A0);
            this.u = new av6(this.c, n06.H0);
            this.v = new cv6(this.c, n06.I0);
            this.o = new kv6(this.c, n06.G0);
            this.p = new yu6(this.c, n06.B0);
            this.q = new xu6(this.c, n06.C0);
            this.r = new wu6(this.c, n06.D0);
            this.t = new ov6(this.c, o06.U);
            this.C = new tu6(this.c, i06.N0);
            this.s = new vu6(this.c, n06.E0);
            this.B = new iv6(this.c, zq4.e);
            this.w = new dv6(this.c, n06.J0);
            this.x = new jv6(this.c, n06.K0);
            this.y = new ev6(this.c, n06.L0);
            this.z = new pv6(this.c, ThreadData.TYPE_CONTENT_VOICE_ROOM);
            this.a.addAll(this.i);
            this.a.add(this.j);
            this.a.add(this.k);
            this.a.add(this.l);
            this.a.add(this.m);
            this.a.add(this.n);
            this.a.add(this.u);
            this.a.add(this.v);
            this.a.add(this.o);
            this.a.add(this.p);
            this.a.add(this.q);
            this.a.add(this.r);
            this.a.add(this.t);
            this.a.add(this.s);
            this.a.add(this.B);
            this.a.add(this.w);
            this.a.add(this.x);
            this.a.add(this.y);
            this.a.add(this.z);
            this.d = new ConcernTipAdapter(this.c.getContext());
            this.e = new ConcernEmotionTipAdapter(this.c.getContext());
            this.f = new ru6(this.c, m06.N0);
            this.A = new qu6(this.c, sv6.b);
            this.g = new pu6(this.c, m06.O0);
            this.h = new lv6(this.c, n06.r0);
            this.D = new fv6(this.c, n06.s0);
            this.E = new uu6(this.c, n06.t0);
            this.F = new gv6(this.c, n06.u0);
            this.G = new ConcernEmotionTipAdapter(this.c.getContext(), tv6.f);
            this.H = new qv6(this.c, n06.x0, (byte) 4);
            this.a.add(this.d);
            this.a.add(this.e);
            this.a.add(this.f);
            this.a.add(this.A);
            this.a.add(this.g);
            this.a.add(this.h);
            this.a.add(this.D);
            this.a.add(this.E);
            this.a.add(this.F);
            this.a.add(this.C);
            this.a.add(this.G);
            this.a.add(this.H);
            g("page_concern");
            c();
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (!ThreadData.isRecAppLoaded.get()) {
                AdvertAppInfo.v.set(false);
                return;
            }
            this.I = new ArrayList<>();
            bn<?, ?> g = yb8.l().g(this.c, AdvertAppInfo.y, "CONCERN");
            bn<?, ?> g2 = yb8.l().g(this.c, AdvertAppInfo.z, "CONCERN");
            bn<?, ?> g3 = yb8.l().g(this.c, AdvertAppInfo.A, "CONCERN");
            bn<?, ?> g4 = yb8.l().g(this.c, AdvertAppInfo.B, "CONCERN");
            bn<?, ?> g5 = yb8.l().g(this.c, AdvertAppInfo.C, "CONCERN");
            bn<?, ?> g6 = yb8.l().g(this.c, AdvertAppInfo.E, "CONCERN");
            bn<?, ?> g7 = yb8.l().g(this.c, AdvertAppInfo.D, "CONCERN");
            this.I.add(g);
            this.I.add(g2);
            this.I.add(g3);
            this.I.add(g4);
            this.I.add(g5);
            this.I.add(g6);
            this.I.add(g7);
            this.a.addAll(this.I);
            AdvertAppInfo.v.set(true);
        }
    }

    public void d() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (bdTypeRecyclerView = this.b) == null) {
            return;
        }
        bdTypeRecyclerView.getListAdapter().notifyDataSetChanged();
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            d();
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || af7.e(this.J)) {
            return;
        }
        Iterator<bn> it = this.I.iterator();
        while (it.hasNext()) {
            bn next = it.next();
            if (next instanceof pb8) {
                ((pb8) next).onDestroy();
            }
        }
    }

    public final void g(String str) {
        List<bn> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || (list = this.a) == null) {
            return;
        }
        for (bn bnVar : list) {
            if (bnVar instanceof pl5) {
                ((pl5) bnVar).g(str);
            }
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            Iterator<hv6> it = this.i.iterator();
            while (it.hasNext()) {
                it.next().a = bdUniqueId;
            }
            this.f.a = bdUniqueId;
            this.g.a = bdUniqueId;
            this.h.a = bdUniqueId;
            this.F.a = bdUniqueId;
            this.D.a = bdUniqueId;
            this.E.a = bdUniqueId;
            this.C.a = bdUniqueId;
            this.s.a = bdUniqueId;
            this.B.a = bdUniqueId;
            this.H.b = bdUniqueId;
            this.z.a = bdUniqueId;
            this.A.u(bdUniqueId);
        }
    }

    public final void i(un unVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, unVar) == null) {
            Iterator<hv6> it = this.i.iterator();
            while (it.hasNext()) {
                it.next().H(unVar);
            }
            this.j.C(unVar);
            this.k.C(unVar);
            this.l.x(unVar);
            this.m.x(unVar);
            this.n.y(unVar);
            this.u.x(unVar);
            this.v.x(unVar);
            this.o.x(unVar);
            this.B.v(unVar);
            this.w.u(unVar);
            this.x.v(unVar);
            this.y.u(unVar);
            this.z.x(unVar);
            this.p.x(unVar);
            this.q.x(unVar);
            this.r.x(unVar);
            this.t.A(unVar);
            this.s.y(unVar);
            this.C.y(unVar);
            this.E.x(unVar);
            this.D.y(unVar);
            this.F.y(unVar);
            this.H.u(unVar);
        }
    }

    public void j(List<on> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            this.J = list;
            this.b.setData(list);
        }
    }
}
