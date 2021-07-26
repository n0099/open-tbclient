package d.a.q0.l0.l;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.enterForum.tabfeed.EnterForumTabFeedFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.k.e.n;
import d.a.p0.s.q.b2;
import d.a.p0.s.q.v1;
import d.a.q0.l0.l.c.c;
import d.a.q0.l0.l.c.d;
import d.a.q0.l0.l.c.e;
import d.a.q0.l0.l.c.f;
import d.a.q0.l0.l.c.g;
import d.a.q0.l0.l.c.h;
import d.a.q0.l0.l.c.i;
import d.a.q0.l0.l.c.j;
import d.a.q0.l0.l.c.k;
import d.a.q0.l0.l.c.l;
import d.a.q0.l0.l.c.m;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public EnterForumTabFeedFragment f60352a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f60353b;

    /* renamed from: c  reason: collision with root package name */
    public k f60354c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.q0.l0.l.c.b f60355d;

    /* renamed from: e  reason: collision with root package name */
    public d f60356e;

    /* renamed from: f  reason: collision with root package name */
    public c f60357f;

    /* renamed from: g  reason: collision with root package name */
    public e f60358g;

    /* renamed from: h  reason: collision with root package name */
    public l f60359h;

    /* renamed from: i  reason: collision with root package name */
    public g f60360i;
    public i j;
    public h k;
    public f l;
    public j m;
    public d.a.q0.l0.l.c.a n;
    public m o;
    public List<d.a.d.k.e.a> p;

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
        this.f60352a = enterForumTabFeedFragment;
        this.f60353b = bdTypeRecyclerView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            k kVar = new k(this.f60352a.getPageContext(), b2.a3, this.f60352a.getUniqueId(), this.f60352a.O0());
            this.f60354c = kVar;
            kVar.j0(this.f60353b);
            this.p.add(this.f60354c);
            d.a.q0.l0.l.c.b bVar = new d.a.q0.l0.l.c.b(this.f60352a.getPageContext(), b2.f3, this.f60352a.getUniqueId(), this.f60352a.O0());
            this.f60355d = bVar;
            bVar.k0(this.f60353b);
            this.p.add(this.f60355d);
            d dVar = new d(this.f60352a.getPageContext(), b2.d3, this.f60352a.getUniqueId(), this.f60352a.O0());
            this.f60356e = dVar;
            dVar.j0(this.f60353b);
            this.p.add(this.f60356e);
            c cVar = new c(this.f60352a.getPageContext(), b2.e3, this.f60352a.getUniqueId(), this.f60352a.O0());
            this.f60357f = cVar;
            cVar.j0(this.f60353b);
            this.p.add(this.f60357f);
            e eVar = new e(this.f60352a.getPageContext(), b2.b3, this.f60352a.getUniqueId(), this.f60352a.O0());
            this.f60358g = eVar;
            eVar.j0(this.f60353b);
            this.p.add(this.f60358g);
            l lVar = new l(this.f60352a.getPageContext(), b2.r3, this.f60352a.getUniqueId(), this.f60352a.O0());
            this.f60359h = lVar;
            lVar.m0(this.f60353b);
            this.p.add(this.f60359h);
            g gVar = new g(this.f60352a.getPageContext(), b2.l3, this.f60352a.getUniqueId(), this.f60352a.O0());
            this.f60360i = gVar;
            gVar.g0(this.f60353b);
            this.p.add(this.f60360i);
            i iVar = new i(this.f60352a.getPageContext(), b2.n3, this.f60352a.getUniqueId(), this.f60352a.O0());
            this.j = iVar;
            iVar.j0(this.f60353b);
            this.p.add(this.j);
            h hVar = new h(this.f60352a.getPageContext(), b2.o3, this.f60352a.getUniqueId(), this.f60352a.O0());
            this.k = hVar;
            hVar.g0(this.f60353b);
            this.p.add(this.k);
            f fVar = new f(this.f60352a.getPageContext(), b2.k3, this.f60352a.getUniqueId(), this.f60352a.O0());
            this.l = fVar;
            fVar.j0(this.f60353b);
            this.p.add(this.l);
            j jVar = new j(this.f60352a.getPageContext(), b2.g3, this.f60352a.getUniqueId(), this.f60352a.O0());
            this.m = jVar;
            jVar.j0(this.f60353b);
            this.p.add(this.m);
            d.a.q0.l0.l.c.a aVar = new d.a.q0.l0.l.c.a(this.f60352a.getPageContext(), b2.j3, this.f60352a.getUniqueId(), this.f60352a.O0());
            this.n = aVar;
            aVar.k0(this.f60353b);
            this.p.add(this.n);
            m mVar = new m(this.f60352a.getPageContext(), v1.f53453h, this.f60352a.getUniqueId(), this.f60352a.O0());
            this.o = mVar;
            mVar.i0(this.f60353b);
            this.p.add(this.o);
            this.f60353b.a(this.p);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f60353b.getAdapter().notifyDataSetChanged();
        }
    }

    public void c(ArrayList<n> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) {
            this.f60353b.setData(arrayList);
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            d.a.q0.l0.l.c.b bVar = this.f60355d;
            if (bVar != null) {
                bVar.setFromCDN(z);
            }
            c cVar = this.f60357f;
            if (cVar != null) {
                cVar.setFromCDN(z);
            }
            d dVar = this.f60356e;
            if (dVar != null) {
                dVar.setFromCDN(z);
            }
        }
    }
}
