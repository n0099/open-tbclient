package d.a.s0.v.j.b;

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
/* loaded from: classes9.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f68035a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f68036b;

    /* renamed from: c  reason: collision with root package name */
    public List<d.a.c.k.e.a> f68037c;

    /* renamed from: d  reason: collision with root package name */
    public List<n> f68038d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.s0.v.j.e.a f68039e;

    /* renamed from: f  reason: collision with root package name */
    public j f68040f;

    public d(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, d.a.s0.v.j.e.a aVar) {
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
        this.f68035a = tbPageContext;
        this.f68036b = bdTypeListView;
        this.f68037c = new ArrayList();
        this.f68038d = new ArrayList();
        this.f68039e = aVar;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c cVar = new c(this.f68035a);
            g gVar = new g(this.f68035a);
            h hVar = new h(this.f68035a);
            a aVar = new a(this.f68035a);
            f fVar = new f(this.f68035a);
            i iVar = new i(this.f68035a);
            e eVar = new e(this.f68035a);
            b bVar = new b(this.f68035a);
            this.f68040f = new j(this.f68035a);
            l lVar = new l(this.f68035a, this.f68039e);
            k kVar = new k(this.f68035a);
            this.f68037c.add(cVar);
            this.f68037c.add(this.f68040f);
            this.f68037c.add(gVar);
            this.f68037c.add(hVar);
            this.f68037c.add(aVar);
            this.f68037c.add(fVar);
            this.f68037c.add(iVar);
            this.f68037c.add(eVar);
            this.f68037c.add(bVar);
            this.f68037c.add(lVar);
            this.f68037c.add(kVar);
            this.f68036b.a(this.f68037c);
        }
    }

    public void b(List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || this.f68036b == null || ListUtils.isEmpty(list)) {
            return;
        }
        this.f68038d.clear();
        this.f68038d.addAll(list);
        this.f68036b.setData(this.f68038d);
    }

    public void c(String str) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || (jVar = this.f68040f) == null) {
            return;
        }
        jVar.t0(str);
    }

    public void d(String str) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || (jVar = this.f68040f) == null) {
            return;
        }
        jVar.a(str);
    }

    public void e(String str) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (jVar = this.f68040f) == null) {
            return;
        }
        jVar.v0(str);
    }

    public void f(boolean z) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || (jVar = this.f68040f) == null) {
            return;
        }
        jVar.w0(z);
    }
}
