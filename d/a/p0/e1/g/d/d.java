package d.a.p0.e1.g.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.k.e.n;
import d.a.c.k.e.s;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f55411a;

    /* renamed from: b  reason: collision with root package name */
    public List<d.a.c.k.e.a> f55412b;

    /* renamed from: c  reason: collision with root package name */
    public s f55413c;

    /* renamed from: d  reason: collision with root package name */
    public c f55414d;

    /* renamed from: e  reason: collision with root package name */
    public h f55415e;

    /* renamed from: f  reason: collision with root package name */
    public b f55416f;

    /* renamed from: g  reason: collision with root package name */
    public f f55417g;

    /* renamed from: h  reason: collision with root package name */
    public e f55418h;

    /* renamed from: i  reason: collision with root package name */
    public g f55419i;
    public i j;

    public d(TbPageContext tbPageContext, s sVar) {
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
        this.f55411a = tbPageContext;
        this.f55413c = sVar;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f55412b = new ArrayList();
            c cVar = new c(this.f55411a);
            this.f55414d = cVar;
            cVar.i0(this.f55413c);
            this.f55412b.add(this.f55414d);
            h hVar = new h(this.f55411a);
            this.f55415e = hVar;
            hVar.i0(this.f55413c);
            this.f55412b.add(this.f55415e);
            b bVar = new b(this.f55411a);
            this.f55416f = bVar;
            bVar.i0(this.f55413c);
            this.f55412b.add(this.f55416f);
            f fVar = new f(this.f55411a);
            this.f55417g = fVar;
            fVar.i0(this.f55413c);
            this.f55412b.add(this.f55417g);
            e eVar = new e(this.f55411a);
            this.f55418h = eVar;
            eVar.i0(this.f55413c);
            this.f55412b.add(this.f55418h);
            g gVar = new g(this.f55411a);
            this.f55419i = gVar;
            gVar.i0(this.f55413c);
            this.f55412b.add(this.f55419i);
            i iVar = new i(this.f55411a);
            this.j = iVar;
            iVar.i0(this.f55413c);
            this.f55412b.add(this.j);
            this.f55413c.a(this.f55412b);
        }
    }

    public void b() {
        s sVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (sVar = this.f55413c) == null) {
            return;
        }
        sVar.getListAdapter().notifyDataSetChanged();
    }

    public void c(List<n> list) {
        s sVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || (sVar = this.f55413c) == null) {
            return;
        }
        sVar.setData(list);
        b();
    }

    public void d(d.a.o0.m.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            for (d.a.c.k.e.a aVar : this.f55412b) {
                if (aVar instanceof a) {
                    ((a) aVar).h0(fVar);
                }
            }
        }
    }

    public void e(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) {
            for (d.a.c.k.e.a aVar : this.f55412b) {
                aVar.c0(bdUniqueId);
            }
        }
    }
}
