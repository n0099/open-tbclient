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
/* loaded from: classes7.dex */
public class ys6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ut6 A;
    public ft6 B;
    public rt6 C;
    public gt6 D;
    public st6 E;
    public ConcernEmotionTipAdapter F;
    public cu6 G;
    public ArrayList<eo> H;
    public List<ro> I;
    public List<eo> a;
    public BdTypeRecyclerView b;
    public TbPageContext<?> c;
    public ConcernTipAdapter d;
    public ConcernEmotionTipAdapter e;
    public dt6 f;
    public ct6 g;
    public xt6 h;
    public ArrayList<tt6> i;
    public zt6 j;
    public zt6 k;
    public lt6 l;
    public yt6 m;
    public nt6 n;
    public wt6 o;
    public kt6 p;
    public jt6 q;
    public it6 r;
    public ht6 s;
    public au6 t;
    public mt6 u;
    public ot6 v;
    public pt6 w;
    public vt6 x;
    public qt6 y;
    public bu6 z;

    public ys6(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
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
        this.c = (TbPageContext) f9.a(context);
        b(context);
        i(bdTypeRecyclerView);
        bdTypeRecyclerView.a(this.a);
    }

    public List<ro> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.I : (List) invokeV.objValue;
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            for (int i = 0; i < yx5.O.size(); i++) {
                for (int i2 = 0; i2 < yx5.P.size(); i2++) {
                    this.i.add(new tt6(this.c, yx5.Q[i][i2], yx5.O.get(i), yx5.P.get(i2)));
                }
            }
            this.j = new zt6(this.c, ThreadData.TYPE_VIDEO, yx5.D);
            this.k = new zt6(this.c, ThreadData.TYPE_VIDEO_WITH_FORUM_HEADER, yx5.E);
            this.l = new lt6(this.c, ThreadData.TYPE_FAKE_VIDEO, yx5.D);
            this.m = new yt6(this.c, gy5.z0);
            this.n = new nt6(this.c, gy5.A0);
            this.u = new mt6(this.c, gy5.H0);
            this.v = new ot6(this.c, gy5.I0);
            this.o = new wt6(this.c, gy5.G0);
            this.p = new kt6(this.c, gy5.B0);
            this.q = new jt6(this.c, gy5.C0);
            this.r = new it6(this.c, gy5.D0);
            this.t = new au6(this.c, hy5.U);
            this.B = new ft6(this.c, by5.N0);
            this.s = new ht6(this.c, gy5.E0);
            this.A = new ut6(this.c, tq4.e);
            this.w = new pt6(this.c, gy5.J0);
            this.x = new vt6(this.c, gy5.K0);
            this.y = new qt6(this.c, gy5.L0);
            this.z = new bu6(this.c, ThreadData.TYPE_CONTENT_VOICE_ROOM);
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
            this.a.add(this.A);
            this.a.add(this.w);
            this.a.add(this.x);
            this.a.add(this.y);
            this.a.add(this.z);
            this.d = new ConcernTipAdapter(this.c.getContext());
            this.e = new ConcernEmotionTipAdapter(this.c.getContext());
            this.f = new dt6(this.c, fy5.N0);
            this.g = new ct6(this.c, fy5.O0);
            this.h = new xt6(this.c, gy5.r0);
            this.C = new rt6(this.c, gy5.s0);
            this.D = new gt6(this.c, gy5.t0);
            this.E = new st6(this.c, gy5.u0);
            this.F = new ConcernEmotionTipAdapter(this.c.getContext(), eu6.f);
            this.G = new cu6(this.c, gy5.x0, (byte) 4);
            this.a.add(this.d);
            this.a.add(this.e);
            this.a.add(this.f);
            this.a.add(this.g);
            this.a.add(this.h);
            this.a.add(this.C);
            this.a.add(this.D);
            this.a.add(this.E);
            this.a.add(this.B);
            this.a.add(this.F);
            this.a.add(this.G);
            g("page_concern");
            c();
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (!ThreadData.isRecAppLoaded.get()) {
                AdvertAppInfo.s.set(false);
                return;
            }
            this.H = new ArrayList<>();
            eo<?, ?> g = ja8.l().g(this.c, AdvertAppInfo.v, "CONCERN");
            eo<?, ?> g2 = ja8.l().g(this.c, AdvertAppInfo.w, "CONCERN");
            eo<?, ?> g3 = ja8.l().g(this.c, AdvertAppInfo.x, "CONCERN");
            eo<?, ?> g4 = ja8.l().g(this.c, AdvertAppInfo.y, "CONCERN");
            eo<?, ?> g5 = ja8.l().g(this.c, AdvertAppInfo.z, "CONCERN");
            eo<?, ?> g6 = ja8.l().g(this.c, AdvertAppInfo.B, "CONCERN");
            eo<?, ?> g7 = ja8.l().g(this.c, AdvertAppInfo.A, "CONCERN");
            this.H.add(g);
            this.H.add(g2);
            this.H.add(g3);
            this.H.add(g4);
            this.H.add(g5);
            this.H.add(g6);
            this.H.add(g7);
            this.a.addAll(this.H);
            AdvertAppInfo.s.set(true);
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
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || pd7.e(this.I)) {
            return;
        }
        Iterator<eo> it = this.H.iterator();
        while (it.hasNext()) {
            eo next = it.next();
            if (next instanceof aa8) {
                ((aa8) next).onDestroy();
            }
        }
    }

    public final void g(String str) {
        List<eo> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || (list = this.a) == null) {
            return;
        }
        for (eo eoVar : list) {
            if (eoVar instanceof ij5) {
                ((ij5) eoVar).g(str);
            }
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            Iterator<tt6> it = this.i.iterator();
            while (it.hasNext()) {
                it.next().i = bdUniqueId;
            }
            this.f.i = bdUniqueId;
            this.g.i = bdUniqueId;
            this.h.i = bdUniqueId;
            this.E.i = bdUniqueId;
            this.C.i = bdUniqueId;
            this.D.i = bdUniqueId;
            this.B.i = bdUniqueId;
            this.s.i = bdUniqueId;
            this.A.i = bdUniqueId;
            this.G.j = bdUniqueId;
            this.z.i = bdUniqueId;
        }
    }

    public final void i(xo xoVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, xoVar) == null) {
            Iterator<tt6> it = this.i.iterator();
            while (it.hasNext()) {
                it.next().o0(xoVar);
            }
            this.j.j0(xoVar);
            this.k.j0(xoVar);
            this.l.e0(xoVar);
            this.m.e0(xoVar);
            this.n.f0(xoVar);
            this.u.e0(xoVar);
            this.v.e0(xoVar);
            this.o.e0(xoVar);
            this.A.c0(xoVar);
            this.w.b0(xoVar);
            this.x.c0(xoVar);
            this.y.b0(xoVar);
            this.z.e0(xoVar);
            this.p.e0(xoVar);
            this.q.e0(xoVar);
            this.r.e0(xoVar);
            this.t.h0(xoVar);
            this.s.f0(xoVar);
            this.B.f0(xoVar);
            this.D.e0(xoVar);
            this.C.f0(xoVar);
            this.E.f0(xoVar);
            this.G.b0(xoVar);
        }
    }

    public void j(List<ro> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            this.I = list;
            this.b.setData(list);
        }
    }
}
