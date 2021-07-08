package d.a.p0.m2.c;

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
/* loaded from: classes8.dex */
public class n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public m f60113a;

    /* renamed from: b  reason: collision with root package name */
    public b f60114b;

    /* renamed from: c  reason: collision with root package name */
    public i f60115c;

    /* renamed from: d  reason: collision with root package name */
    public a f60116d;

    /* renamed from: e  reason: collision with root package name */
    public c f60117e;

    /* renamed from: f  reason: collision with root package name */
    public h f60118f;

    /* renamed from: g  reason: collision with root package name */
    public e f60119g;

    /* renamed from: h  reason: collision with root package name */
    public k f60120h;

    /* renamed from: i  reason: collision with root package name */
    public d f60121i;
    public d.a.p0.j2.h.d j;
    public d.a.p0.j2.h.a k;
    public p l;
    public d.a.p0.m2.c.q.g m;
    public d.a.p0.m2.c.q.d n;
    public d.a.p0.m2.c.q.i o;
    public d.a.p0.m2.c.q.h p;
    public d.a.p0.m2.c.q.a q;
    public d.a.p0.m2.c.q.c r;
    public d.a.p0.m2.c.q.b s;
    public d.a.p0.m2.c.q.e t;
    public d.a.p0.m2.c.q.f u;
    public List<d.a.c.k.e.a> v;
    public BdTypeRecyclerView w;

    public n(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeRecyclerView, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            this.f60113a = new m(tbPageContext);
            this.f60114b = new b(tbPageContext);
            this.f60115c = new i(tbPageContext);
            this.f60116d = new a(tbPageContext);
            this.f60117e = new c(tbPageContext);
            this.f60118f = new h(tbPageContext, tbPageContext.getUniqueId());
            this.f60119g = new e(tbPageContext, d.a.p0.m2.e.g.l);
            this.f60120h = new k(tbPageContext);
            this.f60121i = new d(tbPageContext);
            this.j = new d.a.p0.j2.h.d(tbPageContext, d.a.p0.j2.h.f.f59139f);
            this.k = new d.a.p0.j2.h.a(tbPageContext.getPageActivity(), d.a.p0.j2.d.f59111h);
            this.l = new p(tbPageContext, PersonPostModel.PostInfoList.POST_INFO);
            this.m = new d.a.p0.m2.c.q.g(tbPageContext, d.a.p0.a0.e0.k.s0);
            this.n = new d.a.p0.m2.c.q.d(tbPageContext, d.a.p0.a0.e0.k.u0);
            this.o = new d.a.p0.m2.c.q.i(tbPageContext, d.a.p0.a0.e0.l.X);
            this.p = new d.a.p0.m2.c.q.h(tbPageContext, d.a.p0.a0.e0.k.v0);
            this.s = new d.a.p0.m2.c.q.b(tbPageContext, d.a.p0.a0.e0.k.x0);
            this.t = new d.a.p0.m2.c.q.e(tbPageContext, d.a.p0.a0.e0.k.w0);
            this.u = new d.a.p0.m2.c.q.f(tbPageContext, d.a.p0.a0.e0.k.y0);
            this.q = new d.a.p0.m2.c.q.a(tbPageContext, d.a.p0.a0.e0.e.P0);
            this.r = new d.a.p0.m2.c.q.c(tbPageContext, d.a.p0.a0.e0.f.P0);
            this.v.add(this.f60113a);
            this.v.add(this.f60114b);
            this.v.add(this.f60115c);
            this.v.add(this.f60116d);
            this.v.add(this.f60117e);
            this.v.add(this.f60118f);
            this.v.add(this.f60119g);
            this.v.add(this.f60120h);
            this.v.add(this.f60121i);
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
        List<d.a.c.k.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || (list = this.v) == null) {
            return;
        }
        for (d.a.c.k.e.a aVar : list) {
            if (aVar instanceof d.a.p0.o.f) {
                ((d.a.p0.o.f) aVar).g(str);
            }
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.l.h0(z);
            this.f60115c.j0(z);
            this.m.k0(z);
            this.n.i0(z);
            this.o.j0(z);
            this.p.i0(z);
            this.q.l0(z);
            this.r.k0(z);
            this.s.k0(z);
            this.t.k0(z);
            this.u.k0(z);
        }
    }

    public void e(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) {
            this.m.m = bdUniqueId;
            this.n.m = bdUniqueId;
            this.o.m = bdUniqueId;
            this.p.m = bdUniqueId;
            this.s.m = bdUniqueId;
            this.t.m = bdUniqueId;
            this.u.m = bdUniqueId;
            this.q.m = bdUniqueId;
            this.r.m = bdUniqueId;
        }
    }

    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.m.l0(i2);
            this.n.j0(i2);
            this.o.k0(i2);
            this.p.j0(i2);
            this.q.m0(i2);
            this.r.l0(i2);
            this.s.l0(i2);
            this.t.l0(i2);
            this.u.l0(i2);
        }
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.m.m0(i2);
            this.n.k0(i2);
            this.o.l0(i2);
            this.p.k0(i2);
            this.q.p0(i2);
            this.r.m0(i2);
            this.s.m0(i2);
            this.t.m0(i2);
            this.u.m0(i2);
        }
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.m.p0(i2);
            this.n.l0(i2);
            this.o.m0(i2);
            this.p.l0(i2);
            this.q.q0(i2);
            this.r.p0(i2);
            this.s.p0(i2);
            this.t.p0(i2);
            this.u.p0(i2);
        }
    }
}
