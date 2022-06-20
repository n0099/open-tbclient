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
public class fs6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ks6 A;
    public ct6 B;
    public ns6 C;
    public zs6 D;
    public os6 E;
    public at6 F;
    public ConcernEmotionTipAdapter G;
    public kt6 H;
    public ArrayList<an> I;
    public List<nn> J;
    public List<an> a;
    public BdTypeRecyclerView b;
    public TbPageContext<?> c;
    public ConcernTipAdapter d;
    public ConcernEmotionTipAdapter e;
    public ls6 f;
    public js6 g;
    public ft6 h;
    public ArrayList<bt6> i;
    public ht6 j;
    public ht6 k;
    public ts6 l;
    public gt6 m;
    public vs6 n;
    public et6 o;
    public ss6 p;
    public rs6 q;
    public qs6 r;
    public ps6 s;
    public it6 t;
    public us6 u;
    public ws6 v;
    public xs6 w;
    public dt6 x;
    public ys6 y;
    public jt6 z;

    public fs6(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
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

    public List<nn> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.J : (List) invokeV.objValue;
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            for (int i = 0; i < qx5.O.size(); i++) {
                for (int i2 = 0; i2 < qx5.P.size(); i2++) {
                    this.i.add(new bt6(this.c, qx5.Q[i][i2], qx5.O.get(i), qx5.P.get(i2)));
                }
            }
            this.j = new ht6(this.c, ThreadData.TYPE_VIDEO, qx5.D);
            this.k = new ht6(this.c, ThreadData.TYPE_VIDEO_WITH_FORUM_HEADER, qx5.E);
            this.l = new ts6(this.c, ThreadData.TYPE_FAKE_VIDEO, qx5.D);
            this.m = new gt6(this.c, yx5.z0);
            this.n = new vs6(this.c, yx5.A0);
            this.u = new us6(this.c, yx5.H0);
            this.v = new ws6(this.c, yx5.I0);
            this.o = new et6(this.c, yx5.G0);
            this.p = new ss6(this.c, yx5.B0);
            this.q = new rs6(this.c, yx5.C0);
            this.r = new qs6(this.c, yx5.D0);
            this.t = new it6(this.c, zx5.U);
            this.C = new ns6(this.c, tx5.N0);
            this.s = new ps6(this.c, yx5.E0);
            this.B = new ct6(this.c, sp4.e);
            this.w = new xs6(this.c, yx5.J0);
            this.x = new dt6(this.c, yx5.K0);
            this.y = new ys6(this.c, yx5.L0);
            this.z = new jt6(this.c, ThreadData.TYPE_CONTENT_VOICE_ROOM);
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
            this.f = new ls6(this.c, xx5.N0);
            this.A = new ks6(this.c, mt6.b);
            this.g = new js6(this.c, xx5.O0);
            this.h = new ft6(this.c, yx5.r0);
            this.D = new zs6(this.c, yx5.s0);
            this.E = new os6(this.c, yx5.t0);
            this.F = new at6(this.c, yx5.u0);
            this.G = new ConcernEmotionTipAdapter(this.c.getContext(), nt6.f);
            this.H = new kt6(this.c, yx5.x0, (byte) 4);
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
                AdvertAppInfo.s.set(false);
                return;
            }
            this.I = new ArrayList<>();
            an<?, ?> g = x88.l().g(this.c, AdvertAppInfo.v, "CONCERN");
            an<?, ?> g2 = x88.l().g(this.c, AdvertAppInfo.w, "CONCERN");
            an<?, ?> g3 = x88.l().g(this.c, AdvertAppInfo.x, "CONCERN");
            an<?, ?> g4 = x88.l().g(this.c, AdvertAppInfo.y, "CONCERN");
            an<?, ?> g5 = x88.l().g(this.c, AdvertAppInfo.z, "CONCERN");
            an<?, ?> g6 = x88.l().g(this.c, AdvertAppInfo.B, "CONCERN");
            an<?, ?> g7 = x88.l().g(this.c, AdvertAppInfo.A, "CONCERN");
            this.I.add(g);
            this.I.add(g2);
            this.I.add(g3);
            this.I.add(g4);
            this.I.add(g5);
            this.I.add(g6);
            this.I.add(g7);
            this.a.addAll(this.I);
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
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || oc7.e(this.J)) {
            return;
        }
        Iterator<an> it = this.I.iterator();
        while (it.hasNext()) {
            an next = it.next();
            if (next instanceof o88) {
                ((o88) next).onDestroy();
            }
        }
    }

    public final void g(String str) {
        List<an> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || (list = this.a) == null) {
            return;
        }
        for (an anVar : list) {
            if (anVar instanceof zi5) {
                ((zi5) anVar).g(str);
            }
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            Iterator<bt6> it = this.i.iterator();
            while (it.hasNext()) {
                it.next().i = bdUniqueId;
            }
            this.f.i = bdUniqueId;
            this.g.i = bdUniqueId;
            this.h.i = bdUniqueId;
            this.F.i = bdUniqueId;
            this.D.i = bdUniqueId;
            this.E.i = bdUniqueId;
            this.C.i = bdUniqueId;
            this.s.i = bdUniqueId;
            this.B.i = bdUniqueId;
            this.H.j = bdUniqueId;
            this.z.i = bdUniqueId;
            this.A.b0(bdUniqueId);
        }
    }

    public final void i(tn tnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, tnVar) == null) {
            Iterator<bt6> it = this.i.iterator();
            while (it.hasNext()) {
                it.next().o0(tnVar);
            }
            this.j.j0(tnVar);
            this.k.j0(tnVar);
            this.l.e0(tnVar);
            this.m.e0(tnVar);
            this.n.f0(tnVar);
            this.u.e0(tnVar);
            this.v.e0(tnVar);
            this.o.e0(tnVar);
            this.B.c0(tnVar);
            this.w.b0(tnVar);
            this.x.c0(tnVar);
            this.y.b0(tnVar);
            this.z.e0(tnVar);
            this.p.e0(tnVar);
            this.q.e0(tnVar);
            this.r.e0(tnVar);
            this.t.h0(tnVar);
            this.s.f0(tnVar);
            this.C.f0(tnVar);
            this.E.e0(tnVar);
            this.D.f0(tnVar);
            this.F.f0(tnVar);
            this.H.b0(tnVar);
        }
    }

    public void j(List<nn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            this.J = list;
            this.b.setData(list);
        }
    }
}
