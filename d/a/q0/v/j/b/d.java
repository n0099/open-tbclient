package d.a.q0.v.j.b;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.k.e.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f65462a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f65463b;

    /* renamed from: c  reason: collision with root package name */
    public List<d.a.d.k.e.a> f65464c;

    /* renamed from: d  reason: collision with root package name */
    public List<n> f65465d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.q0.v.j.e.a f65466e;

    /* renamed from: f  reason: collision with root package name */
    public j f65467f;

    public d(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, d.a.q0.v.j.e.a aVar) {
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
        this.f65462a = tbPageContext;
        this.f65463b = bdTypeListView;
        this.f65464c = new ArrayList();
        this.f65465d = new ArrayList();
        this.f65466e = aVar;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c cVar = new c(this.f65462a);
            g gVar = new g(this.f65462a);
            h hVar = new h(this.f65462a);
            a aVar = new a(this.f65462a);
            f fVar = new f(this.f65462a);
            i iVar = new i(this.f65462a);
            e eVar = new e(this.f65462a);
            b bVar = new b(this.f65462a);
            this.f65467f = new j(this.f65462a);
            l lVar = new l(this.f65462a, this.f65466e);
            k kVar = new k(this.f65462a);
            this.f65464c.add(cVar);
            this.f65464c.add(this.f65467f);
            this.f65464c.add(gVar);
            this.f65464c.add(hVar);
            this.f65464c.add(aVar);
            this.f65464c.add(fVar);
            this.f65464c.add(iVar);
            this.f65464c.add(eVar);
            this.f65464c.add(bVar);
            this.f65464c.add(lVar);
            this.f65464c.add(kVar);
            this.f65463b.a(this.f65464c);
        }
    }

    public void b(List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || this.f65463b == null || ListUtils.isEmpty(list)) {
            return;
        }
        this.f65465d.clear();
        this.f65465d.addAll(list);
        this.f65463b.setData(this.f65465d);
    }

    public void c(String str) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || (jVar = this.f65467f) == null) {
            return;
        }
        jVar.r0(str);
    }

    public void d(String str) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || (jVar = this.f65467f) == null) {
            return;
        }
        jVar.a(str);
    }

    public void e(String str) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (jVar = this.f65467f) == null) {
            return;
        }
        jVar.t0(str);
    }

    public void f(boolean z) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || (jVar = this.f65467f) == null) {
            return;
        }
        jVar.u0(z);
    }
}
