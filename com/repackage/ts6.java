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
public class ts6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ys6 A;
    public qt6 B;
    public bt6 C;
    public nt6 D;
    public ct6 E;
    public ot6 F;
    public ConcernEmotionTipAdapter G;
    public yt6 H;
    public ArrayList<an> I;
    public List<nn> J;
    public List<an> a;
    public BdTypeRecyclerView b;
    public TbPageContext<?> c;
    public ConcernTipAdapter d;
    public ConcernEmotionTipAdapter e;
    public zs6 f;
    public xs6 g;
    public tt6 h;
    public ArrayList<pt6> i;
    public vt6 j;
    public vt6 k;
    public ht6 l;
    public ut6 m;
    public jt6 n;
    public st6 o;
    public gt6 p;
    public ft6 q;
    public et6 r;
    public dt6 s;
    public wt6 t;
    public it6 u;
    public kt6 v;
    public lt6 w;
    public rt6 x;
    public mt6 y;
    public xt6 z;

    public ts6(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
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
            for (int i = 0; i < ny5.O.size(); i++) {
                for (int i2 = 0; i2 < ny5.P.size(); i2++) {
                    this.i.add(new pt6(this.c, ny5.Q[i][i2], ny5.O.get(i), ny5.P.get(i2)));
                }
            }
            this.j = new vt6(this.c, ThreadData.TYPE_VIDEO, ny5.D);
            this.k = new vt6(this.c, ThreadData.TYPE_VIDEO_WITH_FORUM_HEADER, ny5.E);
            this.l = new ht6(this.c, ThreadData.TYPE_FAKE_VIDEO, ny5.D);
            this.m = new ut6(this.c, vy5.z0);
            this.n = new jt6(this.c, vy5.A0);
            this.u = new it6(this.c, vy5.H0);
            this.v = new kt6(this.c, vy5.I0);
            this.o = new st6(this.c, vy5.G0);
            this.p = new gt6(this.c, vy5.B0);
            this.q = new ft6(this.c, vy5.C0);
            this.r = new et6(this.c, vy5.D0);
            this.t = new wt6(this.c, wy5.U);
            this.C = new bt6(this.c, qy5.N0);
            this.s = new dt6(this.c, vy5.E0);
            this.B = new qt6(this.c, iq4.e);
            this.w = new lt6(this.c, vy5.J0);
            this.x = new rt6(this.c, vy5.K0);
            this.y = new mt6(this.c, vy5.L0);
            this.z = new xt6(this.c, ThreadData.TYPE_CONTENT_VOICE_ROOM);
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
            this.f = new zs6(this.c, uy5.N0);
            this.A = new ys6(this.c, au6.b);
            this.g = new xs6(this.c, uy5.O0);
            this.h = new tt6(this.c, vy5.r0);
            this.D = new nt6(this.c, vy5.s0);
            this.E = new ct6(this.c, vy5.t0);
            this.F = new ot6(this.c, vy5.u0);
            this.G = new ConcernEmotionTipAdapter(this.c.getContext(), bu6.f);
            this.H = new yt6(this.c, vy5.x0, (byte) 4);
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
            an<?, ?> g = s98.l().g(this.c, AdvertAppInfo.v, "CONCERN");
            an<?, ?> g2 = s98.l().g(this.c, AdvertAppInfo.w, "CONCERN");
            an<?, ?> g3 = s98.l().g(this.c, AdvertAppInfo.x, "CONCERN");
            an<?, ?> g4 = s98.l().g(this.c, AdvertAppInfo.y, "CONCERN");
            an<?, ?> g5 = s98.l().g(this.c, AdvertAppInfo.z, "CONCERN");
            an<?, ?> g6 = s98.l().g(this.c, AdvertAppInfo.B, "CONCERN");
            an<?, ?> g7 = s98.l().g(this.c, AdvertAppInfo.A, "CONCERN");
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
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || gd7.e(this.J)) {
            return;
        }
        Iterator<an> it = this.I.iterator();
        while (it.hasNext()) {
            an next = it.next();
            if (next instanceof j98) {
                ((j98) next).onDestroy();
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
            if (anVar instanceof ck5) {
                ((ck5) anVar).g(str);
            }
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            Iterator<pt6> it = this.i.iterator();
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
            Iterator<pt6> it = this.i.iterator();
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
