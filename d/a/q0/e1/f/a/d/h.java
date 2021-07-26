package d.a.q0.e1.f.a.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.LoadingViewAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.k.e.n;
import d.a.d.k.e.s;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f55915a;

    /* renamed from: b  reason: collision with root package name */
    public List<d.a.d.k.e.a> f55916b;

    /* renamed from: c  reason: collision with root package name */
    public s f55917c;

    /* renamed from: d  reason: collision with root package name */
    public g f55918d;

    /* renamed from: e  reason: collision with root package name */
    public k f55919e;

    /* renamed from: f  reason: collision with root package name */
    public b f55920f;

    /* renamed from: g  reason: collision with root package name */
    public d f55921g;

    /* renamed from: h  reason: collision with root package name */
    public c f55922h;

    /* renamed from: i  reason: collision with root package name */
    public e f55923i;
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
        this.f55915a = tbPageContext;
        this.f55917c = sVar;
        b();
    }

    public List<n> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f55917c.getData() : (List) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ArrayList arrayList = new ArrayList();
            this.f55916b = arrayList;
            arrayList.add(new j(this.f55915a));
            this.f55916b.add(new i(this.f55915a));
            this.f55916b.add(new LoadingViewAdapter(this.f55915a));
            g gVar = new g(this.f55915a);
            this.f55918d = gVar;
            gVar.i0(this.f55917c);
            this.f55916b.add(this.f55918d);
            k kVar = new k(this.f55915a);
            this.f55919e = kVar;
            kVar.i0(this.f55917c);
            this.f55916b.add(this.f55919e);
            b bVar = new b(this.f55915a);
            this.f55920f = bVar;
            bVar.i0(this.f55917c);
            this.f55916b.add(this.f55920f);
            d dVar = new d(this.f55915a);
            this.f55921g = dVar;
            dVar.i0(this.f55917c);
            this.f55916b.add(this.f55921g);
            c cVar = new c(this.f55915a);
            this.f55922h = cVar;
            cVar.i0(this.f55917c);
            this.f55916b.add(this.f55922h);
            e eVar = new e(this.f55915a);
            this.f55923i = eVar;
            eVar.i0(this.f55917c);
            this.f55916b.add(this.f55923i);
            f fVar = new f(this.f55915a);
            this.j = fVar;
            fVar.i0(this.f55917c);
            this.f55916b.add(this.j);
            this.f55917c.a(this.f55916b);
        }
    }

    public void c() {
        s sVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (sVar = this.f55917c) == null) {
            return;
        }
        sVar.getListAdapter().notifyDataSetChanged();
    }

    public void d(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.f55917c.setData(list);
        }
    }

    public void e(d.a.p0.n.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, fVar) == null) {
            for (d.a.d.k.e.a aVar : this.f55916b) {
                if (aVar instanceof a) {
                    ((a) aVar).g0(fVar);
                }
            }
        }
    }

    public void f(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bdUniqueId) == null) {
            for (d.a.d.k.e.a aVar : this.f55916b) {
                aVar.c0(bdUniqueId);
            }
        }
    }
}
