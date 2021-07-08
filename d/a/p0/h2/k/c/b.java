package d.a.p0.h2.k.c;

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
import d.a.p0.a0.e0.k;
import d.a.p0.a0.e0.l;
import d.a.p0.h2.h.j;
import d.a.p0.h2.k.e.b0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BdUniqueId f56984a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.p0.h2.o.b f56985b;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext<?> f56986c;

    /* renamed from: d  reason: collision with root package name */
    public List<d.a.c.k.e.a> f56987d;

    /* renamed from: e  reason: collision with root package name */
    public s f56988e;

    /* renamed from: f  reason: collision with root package name */
    public c f56989f;

    /* renamed from: g  reason: collision with root package name */
    public d f56990g;

    /* renamed from: h  reason: collision with root package name */
    public e f56991h;

    /* renamed from: i  reason: collision with root package name */
    public f f56992i;
    public g j;
    public h k;
    public PbRecomChildTitleAdapter l;
    public b0 m;

    public b(d.a.p0.h2.o.b bVar, BdUniqueId bdUniqueId, s sVar) {
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
        this.f56987d = new ArrayList();
        this.f56988e = sVar;
        this.f56984a = bdUniqueId;
        this.f56985b = bVar;
        this.f56986c = bVar.getPageContext();
        c();
        g(sVar);
        sVar.a(this.f56987d);
    }

    public List<d.a.c.k.e.a> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f56987d : (List) invokeV.objValue;
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
            this.f56991h = new e(this.f56986c, k.E0);
            this.f56990g = new d(this.f56986c, k.F0);
            this.f56989f = new c(this.f56986c, k.G0);
            this.f56992i = new f(this.f56986c, k.D0);
            this.j = new g(this.f56986c, k.I0);
            this.k = new h(this.f56986c, l.X);
            this.l = new PbRecomChildTitleAdapter(this.f56985b, d.a.p0.a0.f0.e.f53834f);
            this.m = new b0(this.f56985b, j.f56912g, this.f56984a);
            this.f56987d.add(this.f56991h);
            this.f56987d.add(this.f56990g);
            this.f56987d.add(this.f56989f);
            this.f56987d.add(this.f56992i);
            this.f56987d.add(this.j);
            this.f56987d.add(this.k);
            this.f56987d.add(this.l);
            this.f56987d.add(this.m);
        }
    }

    public void d() {
        s sVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (sVar = this.f56988e) == null || sVar.getListAdapter() == null) {
            return;
        }
        this.f56988e.getListAdapter().notifyDataSetChanged();
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            d();
        }
    }

    public void f(d.a.p0.h2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, eVar) == null) {
        }
    }

    public final void g(s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, sVar) == null) {
            this.f56991h.k0(sVar);
            this.f56990g.k0(sVar);
            this.f56989f.k0(sVar);
            this.f56992i.k0(sVar);
            this.j.k0(sVar);
            this.k.p0(sVar);
        }
    }

    public void h(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.f56988e.setData(list);
        }
    }
}
