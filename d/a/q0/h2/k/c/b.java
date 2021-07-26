package d.a.q0.h2.k.c;

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
import d.a.d.k.e.n;
import d.a.d.k.e.s;
import d.a.q0.a0.e0.k;
import d.a.q0.a0.e0.l;
import d.a.q0.h2.h.j;
import d.a.q0.h2.k.e.b0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BdUniqueId f57533a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.q0.h2.o.b f57534b;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext<?> f57535c;

    /* renamed from: d  reason: collision with root package name */
    public List<d.a.d.k.e.a> f57536d;

    /* renamed from: e  reason: collision with root package name */
    public s f57537e;

    /* renamed from: f  reason: collision with root package name */
    public c f57538f;

    /* renamed from: g  reason: collision with root package name */
    public d f57539g;

    /* renamed from: h  reason: collision with root package name */
    public e f57540h;

    /* renamed from: i  reason: collision with root package name */
    public f f57541i;
    public g j;
    public h k;
    public PbRecomChildTitleAdapter l;
    public b0 m;

    public b(d.a.q0.h2.o.b bVar, BdUniqueId bdUniqueId, s sVar) {
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
        this.f57536d = new ArrayList();
        this.f57537e = sVar;
        this.f57533a = bdUniqueId;
        this.f57534b = bVar;
        this.f57535c = bVar.getPageContext();
        c();
        g(sVar);
        sVar.a(this.f57536d);
    }

    public List<d.a.d.k.e.a> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f57536d : (List) invokeV.objValue;
    }

    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            PbRecomChildTitleAdapter pbRecomChildTitleAdapter = this.l;
            if (pbRecomChildTitleAdapter == null || pbRecomChildTitleAdapter.g0() == null) {
                return null;
            }
            return this.l.g0().itemView;
        }
        return (View) invokeV.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f57540h = new e(this.f57535c, k.E0);
            this.f57539g = new d(this.f57535c, k.F0);
            this.f57538f = new c(this.f57535c, k.G0);
            this.f57541i = new f(this.f57535c, k.D0);
            this.j = new g(this.f57535c, k.I0);
            this.k = new h(this.f57535c, l.X);
            this.l = new PbRecomChildTitleAdapter(this.f57534b, d.a.q0.a0.f0.e.f54377f);
            this.m = new b0(this.f57534b, j.f57456g, this.f57533a);
            this.f57536d.add(this.f57540h);
            this.f57536d.add(this.f57539g);
            this.f57536d.add(this.f57538f);
            this.f57536d.add(this.f57541i);
            this.f57536d.add(this.j);
            this.f57536d.add(this.k);
            this.f57536d.add(this.l);
            this.f57536d.add(this.m);
        }
    }

    public void d() {
        s sVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (sVar = this.f57537e) == null || sVar.getListAdapter() == null) {
            return;
        }
        this.f57537e.getListAdapter().notifyDataSetChanged();
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            d();
        }
    }

    public void f(d.a.q0.h2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, eVar) == null) {
        }
    }

    public final void g(s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, sVar) == null) {
            this.f57540h.k0(sVar);
            this.f57539g.k0(sVar);
            this.f57538f.k0(sVar);
            this.f57541i.k0(sVar);
            this.j.k0(sVar);
            this.k.n0(sVar);
        }
    }

    public void h(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.f57537e.setData(list);
        }
    }
}
