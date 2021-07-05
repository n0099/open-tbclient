package d.a.s0.l0.l;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.enterForum.tabfeed.EnterForumTabFeedFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.k.e.n;
import d.a.r0.r.q.b2;
import d.a.r0.r.q.v1;
import d.a.s0.l0.l.c.c;
import d.a.s0.l0.l.c.d;
import d.a.s0.l0.l.c.e;
import d.a.s0.l0.l.c.f;
import d.a.s0.l0.l.c.g;
import d.a.s0.l0.l.c.h;
import d.a.s0.l0.l.c.i;
import d.a.s0.l0.l.c.j;
import d.a.s0.l0.l.c.k;
import d.a.s0.l0.l.c.l;
import d.a.s0.l0.l.c.m;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public EnterForumTabFeedFragment f62975a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f62976b;

    /* renamed from: c  reason: collision with root package name */
    public k f62977c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.s0.l0.l.c.b f62978d;

    /* renamed from: e  reason: collision with root package name */
    public d f62979e;

    /* renamed from: f  reason: collision with root package name */
    public c f62980f;

    /* renamed from: g  reason: collision with root package name */
    public e f62981g;

    /* renamed from: h  reason: collision with root package name */
    public l f62982h;

    /* renamed from: i  reason: collision with root package name */
    public g f62983i;
    public i j;
    public h k;
    public f l;
    public j m;
    public d.a.s0.l0.l.c.a n;
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
        this.f62975a = enterForumTabFeedFragment;
        this.f62976b = bdTypeRecyclerView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            k kVar = new k(this.f62975a.getPageContext(), b2.U2, this.f62975a.getUniqueId(), this.f62975a.I0());
            this.f62977c = kVar;
            kVar.j0(this.f62976b);
            this.p.add(this.f62977c);
            d.a.s0.l0.l.c.b bVar = new d.a.s0.l0.l.c.b(this.f62975a.getPageContext(), b2.Z2, this.f62975a.getUniqueId(), this.f62975a.I0());
            this.f62978d = bVar;
            bVar.k0(this.f62976b);
            this.p.add(this.f62978d);
            d dVar = new d(this.f62975a.getPageContext(), b2.X2, this.f62975a.getUniqueId(), this.f62975a.I0());
            this.f62979e = dVar;
            dVar.j0(this.f62976b);
            this.p.add(this.f62979e);
            c cVar = new c(this.f62975a.getPageContext(), b2.Y2, this.f62975a.getUniqueId(), this.f62975a.I0());
            this.f62980f = cVar;
            cVar.j0(this.f62976b);
            this.p.add(this.f62980f);
            e eVar = new e(this.f62975a.getPageContext(), b2.V2, this.f62975a.getUniqueId(), this.f62975a.I0());
            this.f62981g = eVar;
            eVar.j0(this.f62976b);
            this.p.add(this.f62981g);
            l lVar = new l(this.f62975a.getPageContext(), b2.l3, this.f62975a.getUniqueId(), this.f62975a.I0());
            this.f62982h = lVar;
            lVar.m0(this.f62976b);
            this.p.add(this.f62982h);
            g gVar = new g(this.f62975a.getPageContext(), b2.f3, this.f62975a.getUniqueId(), this.f62975a.I0());
            this.f62983i = gVar;
            gVar.h0(this.f62976b);
            this.p.add(this.f62983i);
            i iVar = new i(this.f62975a.getPageContext(), b2.h3, this.f62975a.getUniqueId(), this.f62975a.I0());
            this.j = iVar;
            iVar.j0(this.f62976b);
            this.p.add(this.j);
            h hVar = new h(this.f62975a.getPageContext(), b2.i3, this.f62975a.getUniqueId(), this.f62975a.I0());
            this.k = hVar;
            hVar.h0(this.f62976b);
            this.p.add(this.k);
            f fVar = new f(this.f62975a.getPageContext(), b2.e3, this.f62975a.getUniqueId(), this.f62975a.I0());
            this.l = fVar;
            fVar.j0(this.f62976b);
            this.p.add(this.l);
            j jVar = new j(this.f62975a.getPageContext(), b2.a3, this.f62975a.getUniqueId(), this.f62975a.I0());
            this.m = jVar;
            jVar.j0(this.f62976b);
            this.p.add(this.m);
            d.a.s0.l0.l.c.a aVar = new d.a.s0.l0.l.c.a(this.f62975a.getPageContext(), b2.d3, this.f62975a.getUniqueId(), this.f62975a.I0());
            this.n = aVar;
            aVar.k0(this.f62976b);
            this.p.add(this.n);
            m mVar = new m(this.f62975a.getPageContext(), v1.f56070h, this.f62975a.getUniqueId(), this.f62975a.I0());
            this.o = mVar;
            mVar.i0(this.f62976b);
            this.p.add(this.o);
            this.f62976b.a(this.p);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f62976b.getAdapter().notifyDataSetChanged();
        }
    }

    public void c(ArrayList<n> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) {
            this.f62976b.setData(arrayList);
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            d.a.s0.l0.l.c.b bVar = this.f62978d;
            if (bVar != null) {
                bVar.setFromCDN(z);
            }
            c cVar = this.f62980f;
            if (cVar != null) {
                cVar.setFromCDN(z);
            }
            d dVar = this.f62979e;
            if (dVar != null) {
                dVar.setFromCDN(z);
            }
        }
    }
}
