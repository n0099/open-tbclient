package com.repackage;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class i18 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public h18 a;
    public w08 b;
    public d18 c;
    public v08 d;
    public x08 e;
    public c18 f;
    public z08 g;
    public f18 h;
    public y08 i;
    public ly7 j;
    public iy7 k;
    public k18 l;
    public r18 m;
    public o18 n;
    public t18 o;
    public s18 p;
    public l18 q;
    public n18 r;
    public m18 s;
    public p18 t;
    public q18 u;
    public List<wm> v;
    public BdTypeRecyclerView w;

    public i18(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeRecyclerView, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.v = new ArrayList();
        a(tbPageContext, bdTypeRecyclerView);
        e(bdUniqueId);
    }

    public final void a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, tbPageContext, bdTypeRecyclerView) == null) {
            this.w = bdTypeRecyclerView;
            this.a = new h18(tbPageContext);
            this.b = new w08(tbPageContext);
            this.c = new d18(tbPageContext);
            this.d = new v08(tbPageContext);
            this.e = new x08(tbPageContext);
            this.f = new c18(tbPageContext, tbPageContext.getUniqueId());
            this.g = new z08(tbPageContext, l28.h);
            this.h = new f18(tbPageContext);
            this.i = new y08(tbPageContext);
            this.j = new ly7(tbPageContext, ny7.b);
            this.k = new iy7(tbPageContext.getPageActivity(), ey7.d);
            this.l = new k18(tbPageContext, PersonPostModel.PostInfoList.POST_INFO);
            this.m = new r18(tbPageContext, zw5.o0);
            this.n = new o18(tbPageContext, zw5.q0);
            this.o = new t18(tbPageContext, ax5.U);
            this.p = new s18(tbPageContext, zw5.r0);
            this.s = new m18(tbPageContext, zw5.t0);
            this.t = new p18(tbPageContext, zw5.s0);
            this.u = new q18(tbPageContext, zw5.u0);
            this.q = new l18(tbPageContext, uw5.N0);
            this.r = new n18(tbPageContext, vw5.N0);
            this.v.add(this.a);
            this.v.add(this.b);
            this.v.add(this.c);
            this.v.add(this.d);
            this.v.add(this.e);
            this.v.add(this.f);
            this.v.add(this.g);
            this.v.add(this.h);
            this.v.add(this.i);
            this.v.add(this.j);
            this.v.add(this.k);
            this.v.add(this.l);
            this.v.add(this.m);
            this.v.add(this.n);
            this.v.add(this.o);
            this.v.add(this.p);
            this.v.add(this.s);
            this.v.add(this.t);
            this.v.add(this.u);
            this.v.add(this.q);
            this.v.add(this.r);
            bdTypeRecyclerView.a(this.v);
            c("page_recommend");
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.w.getListAdapter() == null) {
            return;
        }
        this.w.getListAdapter().notifyDataSetChanged();
    }

    public final void c(String str) {
        List<wm> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || (list = this.v) == null) {
            return;
        }
        for (wm wmVar : list) {
            if (wmVar instanceof ci5) {
                ((ci5) wmVar).g(str);
            }
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.l.b0(z);
            this.c.d0(z);
            this.m.e0(z);
            this.n.c0(z);
            this.o.d0(z);
            this.p.c0(z);
            this.q.f0(z);
            this.r.e0(z);
            this.s.e0(z);
            this.t.e0(z);
            this.u.e0(z);
        }
    }

    public void e(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) {
            this.m.i = bdUniqueId;
            this.n.i = bdUniqueId;
            this.o.i = bdUniqueId;
            this.p.i = bdUniqueId;
            this.s.i = bdUniqueId;
            this.t.i = bdUniqueId;
            this.u.i = bdUniqueId;
            this.q.i = bdUniqueId;
            this.r.i = bdUniqueId;
        }
    }

    public void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.m.f0(i);
            this.n.d0(i);
            this.o.e0(i);
            this.p.d0(i);
            this.q.g0(i);
            this.r.f0(i);
            this.s.f0(i);
            this.t.f0(i);
            this.u.f0(i);
        }
    }

    public void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.m.g0(i);
            this.n.e0(i);
            this.o.f0(i);
            this.p.e0(i);
            this.q.h0(i);
            this.r.g0(i);
            this.s.g0(i);
            this.t.g0(i);
            this.u.g0(i);
        }
    }

    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.m.h0(i);
            this.n.f0(i);
            this.o.g0(i);
            this.p.f0(i);
            this.q.i0(i);
            this.r.h0(i);
            this.s.h0(i);
            this.t.h0(i);
            this.u.h0(i);
        }
    }
}
