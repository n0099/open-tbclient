package d.a.s0.e1.j;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.homepage.tabfeed.HomePageTabFeedFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.r0.r.q.b2;
import d.a.r0.r.q.t1;
import d.a.r0.r.q.x;
import d.a.s0.e1.j.g.g;
import d.a.s0.e1.j.g.h;
import d.a.s0.e1.j.g.i;
import d.a.s0.e1.j.g.j;
import d.a.s0.e1.j.g.k;
import d.a.s0.e1.j.g.l;
import d.a.s0.e1.j.g.m;
import d.a.s0.e1.j.g.n;
import d.a.s0.e1.j.g.o;
import d.a.s0.e1.j.g.p;
import d.a.s0.e1.j.g.q;
import d.a.s0.e1.j.g.r;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public HomePageTabFeedFragment f58929a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f58930b;

    /* renamed from: c  reason: collision with root package name */
    public q f58931c;

    /* renamed from: d  reason: collision with root package name */
    public j f58932d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.s0.e1.j.g.e f58933e;

    /* renamed from: f  reason: collision with root package name */
    public g f58934f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.s0.e1.j.g.f f58935g;

    /* renamed from: h  reason: collision with root package name */
    public h f58936h;

    /* renamed from: i  reason: collision with root package name */
    public r f58937i;
    public i j;
    public l k;
    public n l;
    public m m;
    public p n;
    public d.a.s0.e1.j.g.d o;
    public d.a.s0.e1.j.g.b p;
    public d.a.s0.e1.j.g.a q;
    public d.a.s0.e1.j.g.c r;
    public k s;
    public o t;
    public List<d.a.c.k.e.a> u;

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
        this.f58929a = homePageTabFeedFragment;
        this.f58930b = bdTypeRecyclerView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            q qVar = new q(this.f58929a.getPageContext(), b2.U2, this.f58929a.getUniqueId(), this.f58929a.L0());
            this.f58931c = qVar;
            qVar.j0(this.f58930b);
            this.u.add(this.f58931c);
            j jVar = new j(this.f58929a.getPageContext());
            this.f58932d = jVar;
            jVar.i0(this.f58930b);
            this.u.add(this.f58932d);
            d.a.s0.e1.j.g.e eVar = new d.a.s0.e1.j.g.e(this.f58929a.getPageContext(), b2.Z2, this.f58929a.getUniqueId(), this.f58929a.L0());
            this.f58933e = eVar;
            eVar.k0(this.f58930b);
            this.u.add(this.f58933e);
            g gVar = new g(this.f58929a.getPageContext(), b2.X2, this.f58929a.getUniqueId(), this.f58929a.L0());
            this.f58934f = gVar;
            gVar.j0(this.f58930b);
            this.u.add(this.f58934f);
            d.a.s0.e1.j.g.f fVar = new d.a.s0.e1.j.g.f(this.f58929a.getPageContext(), b2.Y2, this.f58929a.getUniqueId(), this.f58929a.L0());
            this.f58935g = fVar;
            fVar.j0(this.f58930b);
            this.u.add(this.f58935g);
            h hVar = new h(this.f58929a.getPageContext(), b2.V2, this.f58929a.getUniqueId(), this.f58929a.L0());
            this.f58936h = hVar;
            hVar.j0(this.f58930b);
            this.u.add(this.f58936h);
            r rVar = new r(this.f58929a.getPageContext(), b2.l3, this.f58929a.getUniqueId(), this.f58929a.L0());
            this.f58937i = rVar;
            rVar.m0(this.f58930b);
            this.u.add(this.f58937i);
            i iVar = new i(this.f58929a.getPageContext(), b2.e3, this.f58929a.getUniqueId(), this.f58929a.L0());
            this.j = iVar;
            iVar.j0(this.f58930b);
            l lVar = new l(this.f58929a.getPageContext(), b2.f3, this.f58929a.getUniqueId(), this.f58929a.L0());
            this.k = lVar;
            lVar.h0(this.f58930b);
            this.u.add(this.k);
            n nVar = new n(this.f58929a.getPageContext(), b2.h3, this.f58929a.getUniqueId(), this.f58929a.L0());
            this.l = nVar;
            nVar.i0(this.f58930b);
            this.u.add(this.l);
            m mVar = new m(this.f58929a.getPageContext(), b2.i3, this.f58929a.getUniqueId(), this.f58929a.L0());
            this.m = mVar;
            mVar.h0(this.f58930b);
            this.u.add(this.m);
            p pVar = new p(this.f58929a.getPageContext(), b2.a3, this.f58929a.getUniqueId(), this.f58929a.L0());
            this.n = pVar;
            pVar.i0(this.f58930b);
            this.u.add(this.n);
            d.a.s0.e1.j.g.d dVar = new d.a.s0.e1.j.g.d(this.f58929a.getPageContext(), b2.d3, this.f58929a.getUniqueId(), this.f58929a.L0());
            this.o = dVar;
            dVar.k0(this.f58930b);
            this.u.add(this.o);
            d.a.s0.e1.j.g.c cVar = new d.a.s0.e1.j.g.c(this.f58929a.getPageContext(), d.a.s0.a0.e0.j.P0, this.f58929a.L0());
            this.r = cVar;
            this.u.add(cVar);
            d.a.s0.e1.j.g.b bVar = new d.a.s0.e1.j.g.b(this.f58929a.getPageContext(), t1.f56058i);
            this.p = bVar;
            bVar.i0(this.f58930b);
            this.u.add(this.p);
            d.a.s0.e1.j.g.a aVar = new d.a.s0.e1.j.g.a(this.f58929a.getPageContext(), x.f56092f);
            this.q = aVar;
            aVar.l0(this.f58930b);
            this.u.add(this.q);
            k kVar = new k(this.f58929a.getPageContext());
            this.s = kVar;
            kVar.h0(this.f58930b);
            this.u.add(this.s);
            o oVar = new o(this.f58929a.getPageContext());
            this.t = oVar;
            oVar.h0(this.f58930b);
            this.u.add(this.t);
            this.f58930b.a(this.u);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f58930b.getAdapter().notifyDataSetChanged();
        }
    }

    public void c(ArrayList<d.a.c.k.e.n> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) {
            this.f58930b.setData(arrayList);
        }
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            for (d.a.c.k.e.a aVar : this.u) {
                if (aVar instanceof d) {
                    ((d) aVar).i(str);
                }
            }
        }
    }
}
