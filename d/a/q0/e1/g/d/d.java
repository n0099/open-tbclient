package d.a.q0.e1.g.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.k.e.n;
import d.a.d.k.e.s;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f55955a;

    /* renamed from: b  reason: collision with root package name */
    public List<d.a.d.k.e.a> f55956b;

    /* renamed from: c  reason: collision with root package name */
    public s f55957c;

    /* renamed from: d  reason: collision with root package name */
    public c f55958d;

    /* renamed from: e  reason: collision with root package name */
    public h f55959e;

    /* renamed from: f  reason: collision with root package name */
    public b f55960f;

    /* renamed from: g  reason: collision with root package name */
    public f f55961g;

    /* renamed from: h  reason: collision with root package name */
    public e f55962h;

    /* renamed from: i  reason: collision with root package name */
    public g f55963i;
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
        this.f55955a = tbPageContext;
        this.f55957c = sVar;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f55956b = new ArrayList();
            c cVar = new c(this.f55955a);
            this.f55958d = cVar;
            cVar.i0(this.f55957c);
            this.f55956b.add(this.f55958d);
            h hVar = new h(this.f55955a);
            this.f55959e = hVar;
            hVar.i0(this.f55957c);
            this.f55956b.add(this.f55959e);
            b bVar = new b(this.f55955a);
            this.f55960f = bVar;
            bVar.i0(this.f55957c);
            this.f55956b.add(this.f55960f);
            f fVar = new f(this.f55955a);
            this.f55961g = fVar;
            fVar.i0(this.f55957c);
            this.f55956b.add(this.f55961g);
            e eVar = new e(this.f55955a);
            this.f55962h = eVar;
            eVar.i0(this.f55957c);
            this.f55956b.add(this.f55962h);
            g gVar = new g(this.f55955a);
            this.f55963i = gVar;
            gVar.i0(this.f55957c);
            this.f55956b.add(this.f55963i);
            i iVar = new i(this.f55955a);
            this.j = iVar;
            iVar.i0(this.f55957c);
            this.f55956b.add(this.j);
            this.f55957c.a(this.f55956b);
        }
    }

    public void b() {
        s sVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (sVar = this.f55957c) == null) {
            return;
        }
        sVar.getListAdapter().notifyDataSetChanged();
    }

    public void c(List<n> list) {
        s sVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || (sVar = this.f55957c) == null) {
            return;
        }
        sVar.setData(list);
        b();
    }

    public void d(d.a.p0.n.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            for (d.a.d.k.e.a aVar : this.f55956b) {
                if (aVar instanceof a) {
                    ((a) aVar).g0(fVar);
                }
            }
        }
    }

    public void e(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) {
            for (d.a.d.k.e.a aVar : this.f55956b) {
                aVar.c0(bdUniqueId);
            }
        }
    }
}
