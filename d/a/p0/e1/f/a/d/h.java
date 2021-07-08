package d.a.p0.e1.f.a.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.LoadingViewAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.k.e.n;
import d.a.c.k.e.s;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f55371a;

    /* renamed from: b  reason: collision with root package name */
    public List<d.a.c.k.e.a> f55372b;

    /* renamed from: c  reason: collision with root package name */
    public s f55373c;

    /* renamed from: d  reason: collision with root package name */
    public g f55374d;

    /* renamed from: e  reason: collision with root package name */
    public k f55375e;

    /* renamed from: f  reason: collision with root package name */
    public b f55376f;

    /* renamed from: g  reason: collision with root package name */
    public d f55377g;

    /* renamed from: h  reason: collision with root package name */
    public c f55378h;

    /* renamed from: i  reason: collision with root package name */
    public e f55379i;
    public f j;

    public h(TbPageContext tbPageContext, s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, sVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f55371a = tbPageContext;
        this.f55373c = sVar;
        b();
    }

    public List<n> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f55373c.getData() : (List) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ArrayList arrayList = new ArrayList();
            this.f55372b = arrayList;
            arrayList.add(new j(this.f55371a));
            this.f55372b.add(new i(this.f55371a));
            this.f55372b.add(new LoadingViewAdapter(this.f55371a));
            g gVar = new g(this.f55371a);
            this.f55374d = gVar;
            gVar.i0(this.f55373c);
            this.f55372b.add(this.f55374d);
            k kVar = new k(this.f55371a);
            this.f55375e = kVar;
            kVar.i0(this.f55373c);
            this.f55372b.add(this.f55375e);
            b bVar = new b(this.f55371a);
            this.f55376f = bVar;
            bVar.i0(this.f55373c);
            this.f55372b.add(this.f55376f);
            d dVar = new d(this.f55371a);
            this.f55377g = dVar;
            dVar.i0(this.f55373c);
            this.f55372b.add(this.f55377g);
            c cVar = new c(this.f55371a);
            this.f55378h = cVar;
            cVar.i0(this.f55373c);
            this.f55372b.add(this.f55378h);
            e eVar = new e(this.f55371a);
            this.f55379i = eVar;
            eVar.i0(this.f55373c);
            this.f55372b.add(this.f55379i);
            f fVar = new f(this.f55371a);
            this.j = fVar;
            fVar.i0(this.f55373c);
            this.f55372b.add(this.j);
            this.f55373c.a(this.f55372b);
        }
    }

    public void c() {
        s sVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (sVar = this.f55373c) == null) {
            return;
        }
        sVar.getListAdapter().notifyDataSetChanged();
    }

    public void d(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.f55373c.setData(list);
        }
    }

    public void e(d.a.o0.m.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, fVar) == null) {
            for (d.a.c.k.e.a aVar : this.f55372b) {
                if (aVar instanceof a) {
                    ((a) aVar).h0(fVar);
                }
            }
        }
    }

    public void f(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bdUniqueId) == null) {
            for (d.a.c.k.e.a aVar : this.f55372b) {
                aVar.c0(bdUniqueId);
            }
        }
    }
}
