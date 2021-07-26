package d.a.q0.e1.j;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.homepage.tabfeed.HomePageTabFeedFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.s.q.b2;
import d.a.p0.s.q.t1;
import d.a.p0.s.q.x;
import d.a.q0.e1.j.g.g;
import d.a.q0.e1.j.g.h;
import d.a.q0.e1.j.g.i;
import d.a.q0.e1.j.g.j;
import d.a.q0.e1.j.g.k;
import d.a.q0.e1.j.g.l;
import d.a.q0.e1.j.g.m;
import d.a.q0.e1.j.g.n;
import d.a.q0.e1.j.g.o;
import d.a.q0.e1.j.g.p;
import d.a.q0.e1.j.g.q;
import d.a.q0.e1.j.g.r;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public HomePageTabFeedFragment f56218a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f56219b;

    /* renamed from: c  reason: collision with root package name */
    public q f56220c;

    /* renamed from: d  reason: collision with root package name */
    public j f56221d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.q0.e1.j.g.e f56222e;

    /* renamed from: f  reason: collision with root package name */
    public g f56223f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.q0.e1.j.g.f f56224g;

    /* renamed from: h  reason: collision with root package name */
    public h f56225h;

    /* renamed from: i  reason: collision with root package name */
    public r f56226i;
    public i j;
    public l k;
    public n l;
    public m m;
    public p n;
    public d.a.q0.e1.j.g.d o;
    public d.a.q0.e1.j.g.b p;
    public d.a.q0.e1.j.g.a q;
    public d.a.q0.e1.j.g.c r;
    public k s;
    public o t;
    public List<d.a.d.k.e.a> u;

    public b(HomePageTabFeedFragment homePageTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {homePageTabFeedFragment, bdTypeRecyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.u = new LinkedList();
        this.f56218a = homePageTabFeedFragment;
        this.f56219b = bdTypeRecyclerView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            q qVar = new q(this.f56218a.getPageContext(), b2.a3, this.f56218a.getUniqueId(), this.f56218a.R0());
            this.f56220c = qVar;
            qVar.j0(this.f56219b);
            this.u.add(this.f56220c);
            j jVar = new j(this.f56218a.getPageContext());
            this.f56221d = jVar;
            jVar.i0(this.f56219b);
            this.u.add(this.f56221d);
            d.a.q0.e1.j.g.e eVar = new d.a.q0.e1.j.g.e(this.f56218a.getPageContext(), b2.f3, this.f56218a.getUniqueId(), this.f56218a.R0());
            this.f56222e = eVar;
            eVar.k0(this.f56219b);
            this.u.add(this.f56222e);
            g gVar = new g(this.f56218a.getPageContext(), b2.d3, this.f56218a.getUniqueId(), this.f56218a.R0());
            this.f56223f = gVar;
            gVar.j0(this.f56219b);
            this.u.add(this.f56223f);
            d.a.q0.e1.j.g.f fVar = new d.a.q0.e1.j.g.f(this.f56218a.getPageContext(), b2.e3, this.f56218a.getUniqueId(), this.f56218a.R0());
            this.f56224g = fVar;
            fVar.j0(this.f56219b);
            this.u.add(this.f56224g);
            h hVar = new h(this.f56218a.getPageContext(), b2.b3, this.f56218a.getUniqueId(), this.f56218a.R0());
            this.f56225h = hVar;
            hVar.j0(this.f56219b);
            this.u.add(this.f56225h);
            r rVar = new r(this.f56218a.getPageContext(), b2.r3, this.f56218a.getUniqueId(), this.f56218a.R0());
            this.f56226i = rVar;
            rVar.m0(this.f56219b);
            this.u.add(this.f56226i);
            i iVar = new i(this.f56218a.getPageContext(), b2.k3, this.f56218a.getUniqueId(), this.f56218a.R0());
            this.j = iVar;
            iVar.j0(this.f56219b);
            l lVar = new l(this.f56218a.getPageContext(), b2.l3, this.f56218a.getUniqueId(), this.f56218a.R0());
            this.k = lVar;
            lVar.g0(this.f56219b);
            this.u.add(this.k);
            n nVar = new n(this.f56218a.getPageContext(), b2.n3, this.f56218a.getUniqueId(), this.f56218a.R0());
            this.l = nVar;
            nVar.i0(this.f56219b);
            this.u.add(this.l);
            m mVar = new m(this.f56218a.getPageContext(), b2.o3, this.f56218a.getUniqueId(), this.f56218a.R0());
            this.m = mVar;
            mVar.g0(this.f56219b);
            this.u.add(this.m);
            p pVar = new p(this.f56218a.getPageContext(), b2.g3, this.f56218a.getUniqueId(), this.f56218a.R0());
            this.n = pVar;
            pVar.i0(this.f56219b);
            this.u.add(this.n);
            d.a.q0.e1.j.g.d dVar = new d.a.q0.e1.j.g.d(this.f56218a.getPageContext(), b2.j3, this.f56218a.getUniqueId(), this.f56218a.R0());
            this.o = dVar;
            dVar.k0(this.f56219b);
            this.u.add(this.o);
            d.a.q0.e1.j.g.c cVar = new d.a.q0.e1.j.g.c(this.f56218a.getPageContext(), d.a.q0.a0.e0.j.P0, this.f56218a.R0());
            this.r = cVar;
            this.u.add(cVar);
            d.a.q0.e1.j.g.b bVar = new d.a.q0.e1.j.g.b(this.f56218a.getPageContext(), t1.f53441i);
            this.p = bVar;
            bVar.i0(this.f56219b);
            this.u.add(this.p);
            d.a.q0.e1.j.g.a aVar = new d.a.q0.e1.j.g.a(this.f56218a.getPageContext(), x.f53475f);
            this.q = aVar;
            aVar.l0(this.f56219b);
            this.u.add(this.q);
            k kVar = new k(this.f56218a.getPageContext());
            this.s = kVar;
            kVar.g0(this.f56219b);
            this.u.add(this.s);
            o oVar = new o(this.f56218a.getPageContext());
            this.t = oVar;
            oVar.g0(this.f56219b);
            this.u.add(this.t);
            this.f56219b.a(this.u);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f56219b.getAdapter().notifyDataSetChanged();
        }
    }

    public void c(ArrayList<d.a.d.k.e.n> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) {
            this.f56219b.setData(arrayList);
        }
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            for (d.a.d.k.e.a aVar : this.u) {
                if (aVar instanceof d) {
                    ((d) aVar).i(str);
                }
            }
        }
    }
}
