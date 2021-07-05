package d.a.s0.h2.k.c;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.pb.pb.adapter.PbRecomChildTitleAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.k.e.n;
import d.a.c.k.e.s;
import d.a.s0.a0.e0.k;
import d.a.s0.a0.e0.l;
import d.a.s0.h2.h.j;
import d.a.s0.h2.k.e.b0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BdUniqueId f60228a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.s0.h2.o.b f60229b;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext<?> f60230c;

    /* renamed from: d  reason: collision with root package name */
    public List<d.a.c.k.e.a> f60231d;

    /* renamed from: e  reason: collision with root package name */
    public s f60232e;

    /* renamed from: f  reason: collision with root package name */
    public c f60233f;

    /* renamed from: g  reason: collision with root package name */
    public d f60234g;

    /* renamed from: h  reason: collision with root package name */
    public e f60235h;

    /* renamed from: i  reason: collision with root package name */
    public f f60236i;
    public g j;
    public h k;
    public PbRecomChildTitleAdapter l;
    public b0 m;

    public b(d.a.s0.h2.o.b bVar, BdUniqueId bdUniqueId, s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, bdUniqueId, sVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f60231d = new ArrayList();
        this.f60232e = sVar;
        this.f60228a = bdUniqueId;
        this.f60229b = bVar;
        this.f60230c = bVar.getPageContext();
        c();
        g(sVar);
        sVar.a(this.f60231d);
    }

    public List<d.a.c.k.e.a> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f60231d : (List) invokeV.objValue;
    }

    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            PbRecomChildTitleAdapter pbRecomChildTitleAdapter = this.l;
            if (pbRecomChildTitleAdapter == null || pbRecomChildTitleAdapter.h0() == null) {
                return null;
            }
            return this.l.h0().itemView;
        }
        return (View) invokeV.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f60235h = new e(this.f60230c, k.E0);
            this.f60234g = new d(this.f60230c, k.F0);
            this.f60233f = new c(this.f60230c, k.G0);
            this.f60236i = new f(this.f60230c, k.D0);
            this.j = new g(this.f60230c, k.I0);
            this.k = new h(this.f60230c, l.X);
            this.l = new PbRecomChildTitleAdapter(this.f60229b, d.a.s0.a0.f0.e.f57089f);
            this.m = new b0(this.f60229b, j.f60156g, this.f60228a);
            this.f60231d.add(this.f60235h);
            this.f60231d.add(this.f60234g);
            this.f60231d.add(this.f60233f);
            this.f60231d.add(this.f60236i);
            this.f60231d.add(this.j);
            this.f60231d.add(this.k);
            this.f60231d.add(this.l);
            this.f60231d.add(this.m);
        }
    }

    public void d() {
        s sVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (sVar = this.f60232e) == null || sVar.getListAdapter() == null) {
            return;
        }
        this.f60232e.getListAdapter().notifyDataSetChanged();
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            d();
        }
    }

    public void f(d.a.s0.h2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, eVar) == null) {
        }
    }

    public final void g(s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, sVar) == null) {
            this.f60235h.k0(sVar);
            this.f60234g.k0(sVar);
            this.f60233f.k0(sVar);
            this.f60236i.k0(sVar);
            this.j.k0(sVar);
            this.k.p0(sVar);
        }
    }

    public void h(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.f60232e.setData(list);
        }
    }
}
