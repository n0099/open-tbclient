package d.a.p0.l0.l;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.enterForum.tabfeed.EnterForumTabFeedFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.k.e.n;
import d.a.o0.r.q.b2;
import d.a.o0.r.q.v1;
import d.a.p0.l0.l.c.c;
import d.a.p0.l0.l.c.d;
import d.a.p0.l0.l.c.e;
import d.a.p0.l0.l.c.f;
import d.a.p0.l0.l.c.g;
import d.a.p0.l0.l.c.h;
import d.a.p0.l0.l.c.i;
import d.a.p0.l0.l.c.j;
import d.a.p0.l0.l.c.k;
import d.a.p0.l0.l.c.l;
import d.a.p0.l0.l.c.m;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public EnterForumTabFeedFragment f59738a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f59739b;

    /* renamed from: c  reason: collision with root package name */
    public k f59740c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.p0.l0.l.c.b f59741d;

    /* renamed from: e  reason: collision with root package name */
    public d f59742e;

    /* renamed from: f  reason: collision with root package name */
    public c f59743f;

    /* renamed from: g  reason: collision with root package name */
    public e f59744g;

    /* renamed from: h  reason: collision with root package name */
    public l f59745h;

    /* renamed from: i  reason: collision with root package name */
    public g f59746i;
    public i j;
    public h k;
    public f l;
    public j m;
    public d.a.p0.l0.l.c.a n;
    public m o;
    public List<d.a.c.k.e.a> p;

    public a(EnterForumTabFeedFragment enterForumTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {enterForumTabFeedFragment, bdTypeRecyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.p = new LinkedList();
        this.f59738a = enterForumTabFeedFragment;
        this.f59739b = bdTypeRecyclerView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            k kVar = new k(this.f59738a.getPageContext(), b2.U2, this.f59738a.getUniqueId(), this.f59738a.J0());
            this.f59740c = kVar;
            kVar.j0(this.f59739b);
            this.p.add(this.f59740c);
            d.a.p0.l0.l.c.b bVar = new d.a.p0.l0.l.c.b(this.f59738a.getPageContext(), b2.Z2, this.f59738a.getUniqueId(), this.f59738a.J0());
            this.f59741d = bVar;
            bVar.k0(this.f59739b);
            this.p.add(this.f59741d);
            d dVar = new d(this.f59738a.getPageContext(), b2.X2, this.f59738a.getUniqueId(), this.f59738a.J0());
            this.f59742e = dVar;
            dVar.j0(this.f59739b);
            this.p.add(this.f59742e);
            c cVar = new c(this.f59738a.getPageContext(), b2.Y2, this.f59738a.getUniqueId(), this.f59738a.J0());
            this.f59743f = cVar;
            cVar.j0(this.f59739b);
            this.p.add(this.f59743f);
            e eVar = new e(this.f59738a.getPageContext(), b2.V2, this.f59738a.getUniqueId(), this.f59738a.J0());
            this.f59744g = eVar;
            eVar.j0(this.f59739b);
            this.p.add(this.f59744g);
            l lVar = new l(this.f59738a.getPageContext(), b2.l3, this.f59738a.getUniqueId(), this.f59738a.J0());
            this.f59745h = lVar;
            lVar.m0(this.f59739b);
            this.p.add(this.f59745h);
            g gVar = new g(this.f59738a.getPageContext(), b2.f3, this.f59738a.getUniqueId(), this.f59738a.J0());
            this.f59746i = gVar;
            gVar.h0(this.f59739b);
            this.p.add(this.f59746i);
            i iVar = new i(this.f59738a.getPageContext(), b2.h3, this.f59738a.getUniqueId(), this.f59738a.J0());
            this.j = iVar;
            iVar.j0(this.f59739b);
            this.p.add(this.j);
            h hVar = new h(this.f59738a.getPageContext(), b2.i3, this.f59738a.getUniqueId(), this.f59738a.J0());
            this.k = hVar;
            hVar.h0(this.f59739b);
            this.p.add(this.k);
            f fVar = new f(this.f59738a.getPageContext(), b2.e3, this.f59738a.getUniqueId(), this.f59738a.J0());
            this.l = fVar;
            fVar.j0(this.f59739b);
            this.p.add(this.l);
            j jVar = new j(this.f59738a.getPageContext(), b2.a3, this.f59738a.getUniqueId(), this.f59738a.J0());
            this.m = jVar;
            jVar.j0(this.f59739b);
            this.p.add(this.m);
            d.a.p0.l0.l.c.a aVar = new d.a.p0.l0.l.c.a(this.f59738a.getPageContext(), b2.d3, this.f59738a.getUniqueId(), this.f59738a.J0());
            this.n = aVar;
            aVar.k0(this.f59739b);
            this.p.add(this.n);
            m mVar = new m(this.f59738a.getPageContext(), v1.f52789h, this.f59738a.getUniqueId(), this.f59738a.J0());
            this.o = mVar;
            mVar.i0(this.f59739b);
            this.p.add(this.o);
            this.f59739b.a(this.p);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f59739b.getAdapter().notifyDataSetChanged();
        }
    }

    public void c(ArrayList<n> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) {
            this.f59739b.setData(arrayList);
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            d.a.p0.l0.l.c.b bVar = this.f59741d;
            if (bVar != null) {
                bVar.setFromCDN(z);
            }
            c cVar = this.f59743f;
            if (cVar != null) {
                cVar.setFromCDN(z);
            }
            d dVar = this.f59742e;
            if (dVar != null) {
                dVar.setFromCDN(z);
            }
        }
    }
}
