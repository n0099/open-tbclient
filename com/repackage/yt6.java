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
public class yt6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public uu6 A;
    public fu6 B;
    public ru6 C;
    public gu6 D;
    public su6 E;
    public ConcernEmotionTipAdapter F;
    public cv6 G;
    public ArrayList<ho> H;
    public List<uo> I;
    public List<ho> a;
    public BdTypeRecyclerView b;
    public TbPageContext<?> c;
    public ConcernTipAdapter d;
    public ConcernEmotionTipAdapter e;
    public du6 f;
    public cu6 g;
    public xu6 h;
    public ArrayList<tu6> i;
    public zu6 j;
    public zu6 k;
    public lu6 l;
    public yu6 m;
    public nu6 n;
    public wu6 o;
    public ku6 p;
    public ju6 q;
    public iu6 r;
    public hu6 s;
    public av6 t;
    public mu6 u;
    public ou6 v;
    public pu6 w;
    public vu6 x;
    public qu6 y;
    public bv6 z;

    public yt6(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
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

    public List<uo> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.I : (List) invokeV.objValue;
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            for (int i = 0; i < xx5.O.size(); i++) {
                for (int i2 = 0; i2 < xx5.P.size(); i2++) {
                    this.i.add(new tu6(this.c, xx5.Q[i][i2], xx5.O.get(i), xx5.P.get(i2)));
                }
            }
            this.j = new zu6(this.c, ThreadData.TYPE_VIDEO, xx5.D);
            this.k = new zu6(this.c, ThreadData.TYPE_VIDEO_WITH_FORUM_HEADER, xx5.E);
            this.l = new lu6(this.c, ThreadData.TYPE_FAKE_VIDEO, xx5.D);
            this.m = new yu6(this.c, fy5.z0);
            this.n = new nu6(this.c, fy5.A0);
            this.u = new mu6(this.c, fy5.H0);
            this.v = new ou6(this.c, fy5.I0);
            this.o = new wu6(this.c, fy5.G0);
            this.p = new ku6(this.c, fy5.B0);
            this.q = new ju6(this.c, fy5.C0);
            this.r = new iu6(this.c, fy5.D0);
            this.t = new av6(this.c, gy5.U);
            this.B = new fu6(this.c, ay5.N0);
            this.s = new hu6(this.c, fy5.E0);
            this.A = new uu6(this.c, iq4.e);
            this.w = new pu6(this.c, fy5.J0);
            this.x = new vu6(this.c, fy5.K0);
            this.y = new qu6(this.c, fy5.L0);
            this.z = new bv6(this.c, ThreadData.TYPE_CONTENT_VOICE_ROOM);
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
            this.f = new du6(this.c, ey5.N0);
            this.g = new cu6(this.c, ey5.O0);
            this.h = new xu6(this.c, fy5.r0);
            this.C = new ru6(this.c, fy5.s0);
            this.D = new gu6(this.c, fy5.t0);
            this.E = new su6(this.c, fy5.u0);
            this.F = new ConcernEmotionTipAdapter(this.c.getContext(), ev6.f);
            this.G = new cv6(this.c, fy5.x0, (byte) 4);
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
                AdvertAppInfo.v.set(false);
                return;
            }
            this.H = new ArrayList<>();
            ho<?, ?> j = ma8.q().j(this.c, AdvertAppInfo.y, "CONCERN");
            ho<?, ?> j2 = ma8.q().j(this.c, AdvertAppInfo.z, "CONCERN");
            ho<?, ?> j3 = ma8.q().j(this.c, AdvertAppInfo.A, "CONCERN");
            ho<?, ?> j4 = ma8.q().j(this.c, AdvertAppInfo.B, "CONCERN");
            ho<?, ?> j5 = ma8.q().j(this.c, AdvertAppInfo.C, "CONCERN");
            ho<?, ?> j6 = ma8.q().j(this.c, AdvertAppInfo.E, "CONCERN");
            ho<?, ?> j7 = ma8.q().j(this.c, AdvertAppInfo.D, "CONCERN");
            this.H.add(j);
            this.H.add(j2);
            this.H.add(j3);
            this.H.add(j4);
            this.H.add(j5);
            this.H.add(j6);
            this.H.add(j7);
            this.a.addAll(this.H);
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
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || jd7.e(this.I)) {
            return;
        }
        Iterator<ho> it = this.H.iterator();
        while (it.hasNext()) {
            ho next = it.next();
            if (next instanceof ca8) {
                ((ca8) next).onDestroy();
            }
        }
    }

    public final void g(String str) {
        List<ho> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || (list = this.a) == null) {
            return;
        }
        for (ho hoVar : list) {
            if (hoVar instanceof qi5) {
                ((qi5) hoVar).g(str);
            }
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            Iterator<tu6> it = this.i.iterator();
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

    public final void i(zo zoVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, zoVar) == null) {
            Iterator<tu6> it = this.i.iterator();
            while (it.hasNext()) {
                it.next().o0(zoVar);
            }
            this.j.j0(zoVar);
            this.k.j0(zoVar);
            this.l.e0(zoVar);
            this.m.e0(zoVar);
            this.n.f0(zoVar);
            this.u.e0(zoVar);
            this.v.e0(zoVar);
            this.o.e0(zoVar);
            this.A.c0(zoVar);
            this.w.b0(zoVar);
            this.x.c0(zoVar);
            this.y.b0(zoVar);
            this.z.e0(zoVar);
            this.p.e0(zoVar);
            this.q.e0(zoVar);
            this.r.e0(zoVar);
            this.t.h0(zoVar);
            this.s.f0(zoVar);
            this.B.f0(zoVar);
            this.D.e0(zoVar);
            this.C.f0(zoVar);
            this.E.f0(zoVar);
            this.G.b0(zoVar);
        }
    }

    public void j(List<uo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            this.I = list;
            this.b.setData(list);
        }
    }
}
