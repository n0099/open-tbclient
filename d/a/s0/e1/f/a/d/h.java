package d.a.s0.e1.f.a.d;

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
/* loaded from: classes9.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f58626a;

    /* renamed from: b  reason: collision with root package name */
    public List<d.a.c.k.e.a> f58627b;

    /* renamed from: c  reason: collision with root package name */
    public s f58628c;

    /* renamed from: d  reason: collision with root package name */
    public g f58629d;

    /* renamed from: e  reason: collision with root package name */
    public k f58630e;

    /* renamed from: f  reason: collision with root package name */
    public b f58631f;

    /* renamed from: g  reason: collision with root package name */
    public d f58632g;

    /* renamed from: h  reason: collision with root package name */
    public c f58633h;

    /* renamed from: i  reason: collision with root package name */
    public e f58634i;
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
        this.f58626a = tbPageContext;
        this.f58628c = sVar;
        b();
    }

    public List<n> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f58628c.getData() : (List) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ArrayList arrayList = new ArrayList();
            this.f58627b = arrayList;
            arrayList.add(new j(this.f58626a));
            this.f58627b.add(new i(this.f58626a));
            this.f58627b.add(new LoadingViewAdapter(this.f58626a));
            g gVar = new g(this.f58626a);
            this.f58629d = gVar;
            gVar.i0(this.f58628c);
            this.f58627b.add(this.f58629d);
            k kVar = new k(this.f58626a);
            this.f58630e = kVar;
            kVar.i0(this.f58628c);
            this.f58627b.add(this.f58630e);
            b bVar = new b(this.f58626a);
            this.f58631f = bVar;
            bVar.i0(this.f58628c);
            this.f58627b.add(this.f58631f);
            d dVar = new d(this.f58626a);
            this.f58632g = dVar;
            dVar.i0(this.f58628c);
            this.f58627b.add(this.f58632g);
            c cVar = new c(this.f58626a);
            this.f58633h = cVar;
            cVar.i0(this.f58628c);
            this.f58627b.add(this.f58633h);
            e eVar = new e(this.f58626a);
            this.f58634i = eVar;
            eVar.i0(this.f58628c);
            this.f58627b.add(this.f58634i);
            f fVar = new f(this.f58626a);
            this.j = fVar;
            fVar.i0(this.f58628c);
            this.f58627b.add(this.j);
            this.f58628c.a(this.f58627b);
        }
    }

    public void c() {
        s sVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (sVar = this.f58628c) == null) {
            return;
        }
        sVar.getListAdapter().notifyDataSetChanged();
    }

    public void d(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.f58628c.setData(list);
        }
    }

    public void e(d.a.r0.m.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, fVar) == null) {
            for (d.a.c.k.e.a aVar : this.f58627b) {
                if (aVar instanceof a) {
                    ((a) aVar).h0(fVar);
                }
            }
        }
    }

    public void f(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bdUniqueId) == null) {
            for (d.a.c.k.e.a aVar : this.f58627b) {
                aVar.c0(bdUniqueId);
            }
        }
    }
}
