package d.a.s0.b2.d.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.k.e.n;
import d.a.r0.r.q.b2;
import d.a.r0.r.q.x;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f57826a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f57827b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f57828c;

    /* renamed from: d  reason: collision with root package name */
    public j f57829d;

    /* renamed from: e  reason: collision with root package name */
    public c f57830e;

    /* renamed from: f  reason: collision with root package name */
    public e f57831f;

    /* renamed from: g  reason: collision with root package name */
    public d f57832g;

    /* renamed from: h  reason: collision with root package name */
    public f f57833h;

    /* renamed from: i  reason: collision with root package name */
    public k f57834i;
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
        this.f57826a = tbPageContext;
        this.f57827b = bdUniqueId;
        this.f57828c = bdTypeRecyclerView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            j jVar = new j(this.f57826a, b2.U2, this.f57827b);
            this.f57829d = jVar;
            jVar.m0(this.f57828c);
            this.o.add(this.f57829d);
            c cVar = new c(this.f57826a, b2.Z2, this.f57827b);
            this.f57830e = cVar;
            cVar.p0(this.f57828c);
            this.o.add(this.f57830e);
            e eVar = new e(this.f57826a, b2.X2, this.f57827b);
            this.f57831f = eVar;
            eVar.m0(this.f57828c);
            this.o.add(this.f57831f);
            d dVar = new d(this.f57826a, b2.Y2, this.f57827b);
            this.f57832g = dVar;
            dVar.m0(this.f57828c);
            this.o.add(this.f57832g);
            f fVar = new f(this.f57826a, b2.V2, this.f57827b);
            this.f57833h = fVar;
            fVar.m0(this.f57828c);
            this.o.add(this.f57833h);
            k kVar = new k(this.f57826a, b2.l3, this.f57827b);
            this.f57834i = kVar;
            kVar.s0(this.f57828c);
            this.o.add(this.f57834i);
            g gVar = new g(this.f57826a, b2.e3, this.f57827b);
            this.j = gVar;
            gVar.m0(this.f57828c);
            this.o.add(this.j);
            h hVar = new h(this.f57826a, b2.a3, this.f57827b);
            this.k = hVar;
            hVar.m0(this.f57828c);
            this.o.add(this.k);
            b bVar = new b(this.f57826a, b2.d3, this.f57827b);
            this.l = bVar;
            bVar.p0(this.f57828c);
            this.o.add(this.l);
            m mVar = new m(this.f57826a, x.f56092f);
            this.m = mVar;
            mVar.l0(this.f57828c);
            this.o.add(this.m);
            i iVar = new i(this.f57826a, d.a.s0.a0.e0.k.v0);
            this.n = iVar;
            this.o.add(iVar);
            this.f57828c.a(this.o);
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
            this.f57828c.getAdapter().notifyDataSetChanged();
        }
    }

    public void d(List<? extends n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.f57828c.setData(list);
        }
    }
}
