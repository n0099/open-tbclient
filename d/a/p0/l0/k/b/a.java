package d.a.p0.l0.k.b;

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
import d.a.c.k.e.n;
import d.a.c.k.e.s;
import d.a.p0.a0.b0;
import d.a.p0.l0.k.c.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f59697a;

    /* renamed from: b  reason: collision with root package name */
    public List<d.a.c.k.e.a> f59698b;

    /* renamed from: c  reason: collision with root package name */
    public s f59699c;

    /* renamed from: d  reason: collision with root package name */
    public b f59700d;

    /* renamed from: e  reason: collision with root package name */
    public c f59701e;

    /* renamed from: f  reason: collision with root package name */
    public d f59702f;

    /* renamed from: g  reason: collision with root package name */
    public List<n> f59703g;

    /* renamed from: h  reason: collision with root package name */
    public b0<BaseCardInfo> f59704h;

    /* renamed from: d.a.p0.l0.k.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1524a extends b0<BaseCardInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f59705b;

        public C1524a(a aVar) {
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
            this.f59705b = aVar;
        }

        @Override // d.a.p0.a0.b0
        public void a(View view, BaseCardInfo baseCardInfo) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, view, baseCardInfo) == null) && baseCardInfo != null && (baseCardInfo instanceof d.a.p0.l0.k.c.d)) {
                ArrayList arrayList = new ArrayList();
                String title = ((d.a.p0.l0.k.c.d) baseCardInfo).getTitle();
                for (n nVar : this.f59705b.f59703g) {
                    if (nVar instanceof d.a.p0.l0.k.c.d) {
                        d.a.p0.l0.k.c.d dVar = (d.a.p0.l0.k.c.d) nVar;
                        if (title.equals(dVar.getTitle())) {
                            List<d.a.p0.l0.k.c.c> o = dVar.o();
                            arrayList.add(nVar);
                            arrayList.addAll(o);
                        } else {
                            List<d.a.p0.l0.k.c.c> j = dVar.j();
                            arrayList.add(nVar);
                            arrayList.addAll(j);
                        }
                    }
                }
                e eVar = new e();
                eVar.f59728e = TbadkCoreApplication.getInst().getMainTabBottomBarHeightId();
                arrayList.add(eVar);
                if (arrayList.size() > 0) {
                    this.f59705b.f59699c.setData(arrayList);
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
        this.f59704h = new C1524a(this);
        this.f59697a = tbPageContext;
        this.f59699c = sVar;
        c();
        this.f59699c.a(this.f59698b);
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f59698b = new ArrayList();
            b bVar = new b(this.f59697a);
            this.f59700d = bVar;
            this.f59698b.add(bVar);
            c cVar = new c(this.f59697a, this.f59704h);
            this.f59701e = cVar;
            this.f59698b.add(cVar);
            d dVar = new d(this.f59697a);
            this.f59702f = dVar;
            this.f59698b.add(dVar);
        }
    }

    public void d() {
        s sVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (sVar = this.f59699c) == null) {
            return;
        }
        sVar.getListAdapter().notifyDataSetChanged();
    }

    public void e(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.f59703g = list;
            this.f59699c.setData(list);
        }
    }

    public void f(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bdUniqueId) == null) {
            for (d.a.c.k.e.a aVar : this.f59698b) {
                aVar.c0(bdUniqueId);
            }
        }
    }
}
