package d.a.p0.b2.d.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.k.e.n;
import d.a.o0.r.q.b2;
import d.a.o0.r.q.x;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes7.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f54571a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f54572b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f54573c;

    /* renamed from: d  reason: collision with root package name */
    public j f54574d;

    /* renamed from: e  reason: collision with root package name */
    public c f54575e;

    /* renamed from: f  reason: collision with root package name */
    public e f54576f;

    /* renamed from: g  reason: collision with root package name */
    public d f54577g;

    /* renamed from: h  reason: collision with root package name */
    public f f54578h;

    /* renamed from: i  reason: collision with root package name */
    public k f54579i;
    public g j;
    public h k;
    public b l;
    public m m;
    public i n;
    public List<d.a.c.k.e.a> o;

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
        this.f54571a = tbPageContext;
        this.f54572b = bdUniqueId;
        this.f54573c = bdTypeRecyclerView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            j jVar = new j(this.f54571a, b2.U2, this.f54572b);
            this.f54574d = jVar;
            jVar.m0(this.f54573c);
            this.o.add(this.f54574d);
            c cVar = new c(this.f54571a, b2.Z2, this.f54572b);
            this.f54575e = cVar;
            cVar.p0(this.f54573c);
            this.o.add(this.f54575e);
            e eVar = new e(this.f54571a, b2.X2, this.f54572b);
            this.f54576f = eVar;
            eVar.m0(this.f54573c);
            this.o.add(this.f54576f);
            d dVar = new d(this.f54571a, b2.Y2, this.f54572b);
            this.f54577g = dVar;
            dVar.m0(this.f54573c);
            this.o.add(this.f54577g);
            f fVar = new f(this.f54571a, b2.V2, this.f54572b);
            this.f54578h = fVar;
            fVar.m0(this.f54573c);
            this.o.add(this.f54578h);
            k kVar = new k(this.f54571a, b2.l3, this.f54572b);
            this.f54579i = kVar;
            kVar.s0(this.f54573c);
            this.o.add(this.f54579i);
            g gVar = new g(this.f54571a, b2.e3, this.f54572b);
            this.j = gVar;
            gVar.m0(this.f54573c);
            this.o.add(this.j);
            h hVar = new h(this.f54571a, b2.a3, this.f54572b);
            this.k = hVar;
            hVar.m0(this.f54573c);
            this.o.add(this.k);
            b bVar = new b(this.f54571a, b2.d3, this.f54572b);
            this.l = bVar;
            bVar.p0(this.f54573c);
            this.o.add(this.l);
            m mVar = new m(this.f54571a, x.f52811f);
            this.m = mVar;
            mVar.l0(this.f54573c);
            this.o.add(this.m);
            i iVar = new i(this.f54571a, d.a.p0.a0.e0.k.v0);
            this.n = iVar;
            this.o.add(iVar);
            this.f54573c.a(this.o);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            for (d.a.c.k.e.a aVar : this.o) {
                if (aVar instanceof a) {
                    ((a) aVar).g0(z);
                }
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f54573c.getAdapter().notifyDataSetChanged();
        }
    }

    public void d(List<? extends n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.f54573c.setData(list);
        }
    }
}
