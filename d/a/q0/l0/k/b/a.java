package d.a.q0.l0.k.b;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.k.e.n;
import d.a.d.k.e.s;
import d.a.q0.a0.b0;
import d.a.q0.l0.k.c.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f60311a;

    /* renamed from: b  reason: collision with root package name */
    public List<d.a.d.k.e.a> f60312b;

    /* renamed from: c  reason: collision with root package name */
    public s f60313c;

    /* renamed from: d  reason: collision with root package name */
    public b f60314d;

    /* renamed from: e  reason: collision with root package name */
    public c f60315e;

    /* renamed from: f  reason: collision with root package name */
    public d f60316f;

    /* renamed from: g  reason: collision with root package name */
    public List<n> f60317g;

    /* renamed from: h  reason: collision with root package name */
    public b0<BaseCardInfo> f60318h;

    /* renamed from: d.a.q0.l0.k.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1529a extends b0<BaseCardInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f60319b;

        public C1529a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60319b = aVar;
        }

        @Override // d.a.q0.a0.b0
        public void a(View view, BaseCardInfo baseCardInfo) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, view, baseCardInfo) == null) && baseCardInfo != null && (baseCardInfo instanceof d.a.q0.l0.k.c.d)) {
                ArrayList arrayList = new ArrayList();
                String title = ((d.a.q0.l0.k.c.d) baseCardInfo).getTitle();
                for (n nVar : this.f60319b.f60317g) {
                    if (nVar instanceof d.a.q0.l0.k.c.d) {
                        d.a.q0.l0.k.c.d dVar = (d.a.q0.l0.k.c.d) nVar;
                        if (title.equals(dVar.getTitle())) {
                            List<d.a.q0.l0.k.c.c> o = dVar.o();
                            arrayList.add(nVar);
                            arrayList.addAll(o);
                        } else {
                            List<d.a.q0.l0.k.c.c> j = dVar.j();
                            arrayList.add(nVar);
                            arrayList.addAll(j);
                        }
                    }
                }
                e eVar = new e();
                eVar.f60342e = TbadkCoreApplication.getInst().getMainTabBottomBarHeightId();
                arrayList.add(eVar);
                if (arrayList.size() > 0) {
                    this.f60319b.f60313c.setData(arrayList);
                }
            }
        }
    }

    public a(TbPageContext tbPageContext, s sVar) {
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
        this.f60318h = new C1529a(this);
        this.f60311a = tbPageContext;
        this.f60313c = sVar;
        c();
        this.f60313c.a(this.f60312b);
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f60312b = new ArrayList();
            b bVar = new b(this.f60311a);
            this.f60314d = bVar;
            this.f60312b.add(bVar);
            c cVar = new c(this.f60311a, this.f60318h);
            this.f60315e = cVar;
            this.f60312b.add(cVar);
            d dVar = new d(this.f60311a);
            this.f60316f = dVar;
            this.f60312b.add(dVar);
        }
    }

    public void d() {
        s sVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (sVar = this.f60313c) == null) {
            return;
        }
        sVar.getListAdapter().notifyDataSetChanged();
    }

    public void e(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.f60317g = list;
            this.f60313c.setData(list);
        }
    }

    public void f(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bdUniqueId) == null) {
            for (d.a.d.k.e.a aVar : this.f60312b) {
                aVar.c0(bdUniqueId);
            }
        }
    }
}
