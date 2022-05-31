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
/* loaded from: classes5.dex */
public class cr6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public yr6 A;
    public jr6 B;
    public vr6 C;
    public kr6 D;
    public wr6 E;
    public ConcernEmotionTipAdapter F;
    public gs6 G;
    public ArrayList<wm> H;
    public List<jn> I;
    public List<wm> a;
    public BdTypeRecyclerView b;
    public TbPageContext<?> c;
    public ConcernTipAdapter d;
    public ConcernEmotionTipAdapter e;
    public hr6 f;
    public gr6 g;
    public bs6 h;
    public ArrayList<xr6> i;
    public ds6 j;
    public ds6 k;
    public pr6 l;
    public cs6 m;
    public rr6 n;
    public as6 o;
    public or6 p;
    public nr6 q;
    public mr6 r;
    public lr6 s;
    public es6 t;
    public qr6 u;
    public sr6 v;
    public tr6 w;
    public zr6 x;
    public ur6 y;
    public fs6 z;

    public cr6(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
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

    public List<jn> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.I : (List) invokeV.objValue;
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            for (int i = 0; i < rw5.O.size(); i++) {
                for (int i2 = 0; i2 < rw5.P.size(); i2++) {
                    this.i.add(new xr6(this.c, rw5.Q[i][i2], rw5.O.get(i), rw5.P.get(i2)));
                }
            }
            this.j = new ds6(this.c, ThreadData.TYPE_VIDEO, rw5.D);
            this.k = new ds6(this.c, ThreadData.TYPE_VIDEO_WITH_FORUM_HEADER, rw5.E);
            this.l = new pr6(this.c, ThreadData.TYPE_FAKE_VIDEO, rw5.D);
            this.m = new cs6(this.c, zw5.z0);
            this.n = new rr6(this.c, zw5.A0);
            this.u = new qr6(this.c, zw5.H0);
            this.v = new sr6(this.c, zw5.I0);
            this.o = new as6(this.c, zw5.G0);
            this.p = new or6(this.c, zw5.B0);
            this.q = new nr6(this.c, zw5.C0);
            this.r = new mr6(this.c, zw5.D0);
            this.t = new es6(this.c, ax5.U);
            this.B = new jr6(this.c, uw5.N0);
            this.s = new lr6(this.c, zw5.E0);
            this.A = new yr6(this.c, ip4.e);
            this.w = new tr6(this.c, zw5.J0);
            this.x = new zr6(this.c, zw5.K0);
            this.y = new ur6(this.c, zw5.L0);
            this.z = new fs6(this.c, ThreadData.TYPE_CONTENT_VOICE_ROOM);
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
            this.f = new hr6(this.c, yw5.N0);
            this.g = new gr6(this.c, yw5.O0);
            this.h = new bs6(this.c, zw5.r0);
            this.C = new vr6(this.c, zw5.s0);
            this.D = new kr6(this.c, zw5.t0);
            this.E = new wr6(this.c, zw5.u0);
            this.F = new ConcernEmotionTipAdapter(this.c.getContext(), is6.f);
            this.G = new gs6(this.c, zw5.x0, (byte) 4);
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
            wm<?, ?> g = q78.l().g(this.c, AdvertAppInfo.v, "CONCERN");
            wm<?, ?> g2 = q78.l().g(this.c, AdvertAppInfo.w, "CONCERN");
            wm<?, ?> g3 = q78.l().g(this.c, AdvertAppInfo.x, "CONCERN");
            wm<?, ?> g4 = q78.l().g(this.c, AdvertAppInfo.y, "CONCERN");
            wm<?, ?> g5 = q78.l().g(this.c, AdvertAppInfo.z, "CONCERN");
            wm<?, ?> g6 = q78.l().g(this.c, AdvertAppInfo.B, "CONCERN");
            wm<?, ?> g7 = q78.l().g(this.c, AdvertAppInfo.A, "CONCERN");
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
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || db7.e(this.I)) {
            return;
        }
        Iterator<wm> it = this.H.iterator();
        while (it.hasNext()) {
            wm next = it.next();
            if (next instanceof h78) {
                ((h78) next).onDestroy();
            }
        }
    }

    public final void g(String str) {
        List<wm> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || (list = this.a) == null) {
            return;
        }
        for (wm wmVar : list) {
            if (wmVar instanceof ci5) {
                ((ci5) wmVar).g(str);
            }
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            Iterator<xr6> it = this.i.iterator();
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

    public final void i(pn pnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, pnVar) == null) {
            Iterator<xr6> it = this.i.iterator();
            while (it.hasNext()) {
                it.next().o0(pnVar);
            }
            this.j.j0(pnVar);
            this.k.j0(pnVar);
            this.l.e0(pnVar);
            this.m.e0(pnVar);
            this.n.f0(pnVar);
            this.u.e0(pnVar);
            this.v.e0(pnVar);
            this.o.e0(pnVar);
            this.A.c0(pnVar);
            this.w.b0(pnVar);
            this.x.c0(pnVar);
            this.y.b0(pnVar);
            this.z.e0(pnVar);
            this.p.e0(pnVar);
            this.q.e0(pnVar);
            this.r.e0(pnVar);
            this.t.h0(pnVar);
            this.s.f0(pnVar);
            this.B.f0(pnVar);
            this.D.e0(pnVar);
            this.C.f0(pnVar);
            this.E.f0(pnVar);
            this.G.b0(pnVar);
        }
    }

    public void j(List<jn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            this.I = list;
            this.b.setData(list);
        }
    }
}
