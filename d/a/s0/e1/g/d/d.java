package d.a.s0.e1.g.d;

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
/* loaded from: classes9.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f58666a;

    /* renamed from: b  reason: collision with root package name */
    public List<d.a.c.k.e.a> f58667b;

    /* renamed from: c  reason: collision with root package name */
    public s f58668c;

    /* renamed from: d  reason: collision with root package name */
    public c f58669d;

    /* renamed from: e  reason: collision with root package name */
    public h f58670e;

    /* renamed from: f  reason: collision with root package name */
    public b f58671f;

    /* renamed from: g  reason: collision with root package name */
    public f f58672g;

    /* renamed from: h  reason: collision with root package name */
    public e f58673h;

    /* renamed from: i  reason: collision with root package name */
    public g f58674i;
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
        this.f58666a = tbPageContext;
        this.f58668c = sVar;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f58667b = new ArrayList();
            c cVar = new c(this.f58666a);
            this.f58669d = cVar;
            cVar.i0(this.f58668c);
            this.f58667b.add(this.f58669d);
            h hVar = new h(this.f58666a);
            this.f58670e = hVar;
            hVar.i0(this.f58668c);
            this.f58667b.add(this.f58670e);
            b bVar = new b(this.f58666a);
            this.f58671f = bVar;
            bVar.i0(this.f58668c);
            this.f58667b.add(this.f58671f);
            f fVar = new f(this.f58666a);
            this.f58672g = fVar;
            fVar.i0(this.f58668c);
            this.f58667b.add(this.f58672g);
            e eVar = new e(this.f58666a);
            this.f58673h = eVar;
            eVar.i0(this.f58668c);
            this.f58667b.add(this.f58673h);
            g gVar = new g(this.f58666a);
            this.f58674i = gVar;
            gVar.i0(this.f58668c);
            this.f58667b.add(this.f58674i);
            i iVar = new i(this.f58666a);
            this.j = iVar;
            iVar.i0(this.f58668c);
            this.f58667b.add(this.j);
            this.f58668c.a(this.f58667b);
        }
    }

    public void b() {
        s sVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (sVar = this.f58668c) == null) {
            return;
        }
        sVar.getListAdapter().notifyDataSetChanged();
    }

    public void c(List<n> list) {
        s sVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || (sVar = this.f58668c) == null) {
            return;
        }
        sVar.setData(list);
        b();
    }

    public void d(d.a.r0.m.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            for (d.a.c.k.e.a aVar : this.f58667b) {
                if (aVar instanceof a) {
                    ((a) aVar).h0(fVar);
                }
            }
        }
    }

    public void e(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) {
            for (d.a.c.k.e.a aVar : this.f58667b) {
                aVar.c0(bdUniqueId);
            }
        }
    }
}
