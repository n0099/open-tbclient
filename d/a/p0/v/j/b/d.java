package d.a.p0.v.j.b;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.k.e.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f64817a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f64818b;

    /* renamed from: c  reason: collision with root package name */
    public List<d.a.c.k.e.a> f64819c;

    /* renamed from: d  reason: collision with root package name */
    public List<n> f64820d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.p0.v.j.e.a f64821e;

    /* renamed from: f  reason: collision with root package name */
    public j f64822f;

    public d(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, d.a.p0.v.j.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeListView, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f64817a = tbPageContext;
        this.f64818b = bdTypeListView;
        this.f64819c = new ArrayList();
        this.f64820d = new ArrayList();
        this.f64821e = aVar;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c cVar = new c(this.f64817a);
            g gVar = new g(this.f64817a);
            h hVar = new h(this.f64817a);
            a aVar = new a(this.f64817a);
            f fVar = new f(this.f64817a);
            i iVar = new i(this.f64817a);
            e eVar = new e(this.f64817a);
            b bVar = new b(this.f64817a);
            this.f64822f = new j(this.f64817a);
            l lVar = new l(this.f64817a, this.f64821e);
            k kVar = new k(this.f64817a);
            this.f64819c.add(cVar);
            this.f64819c.add(this.f64822f);
            this.f64819c.add(gVar);
            this.f64819c.add(hVar);
            this.f64819c.add(aVar);
            this.f64819c.add(fVar);
            this.f64819c.add(iVar);
            this.f64819c.add(eVar);
            this.f64819c.add(bVar);
            this.f64819c.add(lVar);
            this.f64819c.add(kVar);
            this.f64818b.a(this.f64819c);
        }
    }

    public void b(List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || this.f64818b == null || ListUtils.isEmpty(list)) {
            return;
        }
        this.f64820d.clear();
        this.f64820d.addAll(list);
        this.f64818b.setData(this.f64820d);
    }

    public void c(String str) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || (jVar = this.f64822f) == null) {
            return;
        }
        jVar.t0(str);
    }

    public void d(String str) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || (jVar = this.f64822f) == null) {
            return;
        }
        jVar.a(str);
    }

    public void e(String str) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (jVar = this.f64822f) == null) {
            return;
        }
        jVar.v0(str);
    }

    public void f(boolean z) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || (jVar = this.f64822f) == null) {
            return;
        }
        jVar.w0(z);
    }
}
