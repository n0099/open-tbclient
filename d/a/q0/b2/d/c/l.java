package d.a.q0.b2.d.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.k.e.n;
import d.a.p0.s.q.b2;
import d.a.p0.s.q.x;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes7.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f55115a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f55116b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f55117c;

    /* renamed from: d  reason: collision with root package name */
    public j f55118d;

    /* renamed from: e  reason: collision with root package name */
    public c f55119e;

    /* renamed from: f  reason: collision with root package name */
    public e f55120f;

    /* renamed from: g  reason: collision with root package name */
    public d f55121g;

    /* renamed from: h  reason: collision with root package name */
    public f f55122h;

    /* renamed from: i  reason: collision with root package name */
    public k f55123i;
    public g j;
    public h k;
    public b l;
    public m m;
    public i n;
    public List<d.a.d.k.e.a> o;

    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, bdTypeRecyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = new LinkedList();
        this.f55115a = tbPageContext;
        this.f55116b = bdUniqueId;
        this.f55117c = bdTypeRecyclerView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            j jVar = new j(this.f55115a, b2.a3, this.f55116b);
            this.f55118d = jVar;
            jVar.m0(this.f55117c);
            this.o.add(this.f55118d);
            c cVar = new c(this.f55115a, b2.f3, this.f55116b);
            this.f55119e = cVar;
            cVar.n0(this.f55117c);
            this.o.add(this.f55119e);
            e eVar = new e(this.f55115a, b2.d3, this.f55116b);
            this.f55120f = eVar;
            eVar.m0(this.f55117c);
            this.o.add(this.f55120f);
            d dVar = new d(this.f55115a, b2.e3, this.f55116b);
            this.f55121g = dVar;
            dVar.m0(this.f55117c);
            this.o.add(this.f55121g);
            f fVar = new f(this.f55115a, b2.b3, this.f55116b);
            this.f55122h = fVar;
            fVar.m0(this.f55117c);
            this.o.add(this.f55122h);
            k kVar = new k(this.f55115a, b2.r3, this.f55116b);
            this.f55123i = kVar;
            kVar.p0(this.f55117c);
            this.o.add(this.f55123i);
            g gVar = new g(this.f55115a, b2.k3, this.f55116b);
            this.j = gVar;
            gVar.m0(this.f55117c);
            this.o.add(this.j);
            h hVar = new h(this.f55115a, b2.g3, this.f55116b);
            this.k = hVar;
            hVar.m0(this.f55117c);
            this.o.add(this.k);
            b bVar = new b(this.f55115a, b2.j3, this.f55116b);
            this.l = bVar;
            bVar.n0(this.f55117c);
            this.o.add(this.l);
            m mVar = new m(this.f55115a, x.f53475f);
            this.m = mVar;
            mVar.l0(this.f55117c);
            this.o.add(this.m);
            i iVar = new i(this.f55115a, d.a.q0.a0.e0.k.v0);
            this.n = iVar;
            this.o.add(iVar);
            this.f55117c.a(this.o);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            for (d.a.d.k.e.a aVar : this.o) {
                if (aVar instanceof a) {
                    ((a) aVar).f0(z);
                }
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f55117c.getAdapter().notifyDataSetChanged();
        }
    }

    public void d(List<? extends n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.f55117c.setData(list);
        }
    }
}
